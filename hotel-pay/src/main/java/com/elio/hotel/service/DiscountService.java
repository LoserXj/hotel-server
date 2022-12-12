package com.elio.hotel.service;

import com.elio.hotel.dao.DiscountDao;
import com.elio.hotel.domain.Discount;
import com.elio.hotel.domain.DiscountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountService {

    @Autowired
    private DiscountDao discountDao;

    @Transactional(rollbackFor=Exception.class)
    public void optimisticLockSold(Integer userId, Integer discountId) {
        //判断库存是否充足
        Discount discount = checkInventory(discountId);
        //扣除库存 使用了乐观锁
        deductInventoryOptimisticLock(discount);
        //生成订单
        generateOrders(userId, discountId);
    }

    private Discount checkInventory(Integer discountId) {
        Discount discount = discountDao.selectDiscountById(discountId);
        // 如果库存等于售卖 则商品售空
        if (discount.getSale() >= discount.getStock()) {
            throw new RuntimeException(discount.getName() + "has been sold out");
        }
        return discount;
    }


    private Integer generateOrders(Integer userId, Integer discountId) {
        DiscountRecord discountRecord = new DiscountRecord();
        discountRecord.setUser_id(userId);
        discountRecord.setDiscount_id(discountId);
        discountRecord.setNumber(1);
        System.out.println(discountRecord);
        int row = discountDao.insertDiscountRecord(discountRecord.getUser_id(),discountRecord.getDiscount_id(),discountRecord.getNumber());
        if (row == 0) {
            throw new RuntimeException("generate order error");
        }
        return discountRecord.getId();
    }


    private void deductInventoryOptimisticLock(Discount discount) {
        int updateRows = discountDao.updateOptimisticLock(discount.getId(),discount.getVersion());
        if(updateRows == 0) {
            throw new RuntimeException("Failed to buy, please try again");
        }
    }






}
