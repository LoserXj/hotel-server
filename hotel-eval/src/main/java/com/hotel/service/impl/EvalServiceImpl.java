package com.hotel.service.impl;

import com.elio.hotel.domain.Evaluation;
import com.hotel.dao.EvalDao;

import com.hotel.service.EvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class EvalServiceImpl implements EvalService {

    @Autowired
    private EvalDao evalDao;

    @Override
    public List<Evaluation> getAll(){
        return evalDao.getAll();
    }

    @Override
    public List<Evaluation> getByRoom(Integer roomId){
        return evalDao.getByRoom(roomId);
    }

    @Override
    public List<Evaluation> getByHotel(String hotelId){
        return evalDao.getByHotel(hotelId);
    }

    @Override
    public boolean delete(Integer orderId){
        return evalDao.delete(orderId)==1;
    }

    @Override
    public boolean insert(MultipartFile pic, MultipartFile video, HttpServletRequest request){
        Evaluation eval=new Evaluation();
        Date date=new Date();
        String s=date.toString();//加入时间戳，目的是为了让所有文件名都不一样
        boolean flag = true;
        if(pic!=null&& !pic.isEmpty()){
            String fileName=pic.getOriginalFilename();
            String filePath="D:\\pic";
            File file=new File(filePath+"\\"+fileName);
            try {
                pic.transferTo(file);
                eval.setPic(filePath);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if(video!=null&& !video.isEmpty()){
            String fileName=video.getOriginalFilename();
            String filePath="D:\\video";
            File file=new File(filePath+"\\"+fileName);
            try {
                video.transferTo(file);
                eval.setVideo(filePath);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        eval.setContext(request.getParameter("context"));
        eval.setScore(Integer.parseInt(request.getParameter("score")));
        eval.setOrder_id(Integer.valueOf(request.getParameter("orderId")));
        eval.setRoom_id(Integer.valueOf(request.getParameter("roomId")));
        eval.setHotel_id(request.getParameter("hotelId"));
        if(flag){
            evalDao.insert(eval);
        }
        return flag;
    }
}
