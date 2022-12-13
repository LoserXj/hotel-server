<template>
  <el-row>
    <el-col :span="50" v-for="item in goodsList" :key="item.id" class="card">
      <el-card :body-style="{ padding: '0px' }">
        <img class="image" :src="require('../../assets/goods/'+ item.picture)" alt="图片"/>
        <div style="padding: 20px;" class="info">
          <div style="float: contour;color: crimson;display: flex;" >{{ item.name }}</div>
          <div class="price">{{ 'coin:' + item.coin }}</div>
          <el-button type="primary" round @click="buy(item.coin)" style="float: right;justify-content: center;">立即兑换</el-button>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
export default {

  name: `list`,
  // name: 'list',
  props: ['goodsList'],
  data() {
    return {
      isCollection: false
    }

  },
  methods: {
    buy(coin){
      let user_coin= 0;
      this.$confirm('立即兑换', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'primary'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '兑换成功!'
        });
        //获取用户的coin 然后减去这个商品的价格
        user_coin = user_coin - coin;
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消兑换'
        });
      });
      //更新用户coin
      return user_coin
    },

    getInfo(){

    }

  }
};
</script>

<style scoped>
.info{
  height: 150px;
}

ul {
  list-style: none;
  display: flex;
  align-items: center;
}



.image {
  width: 320px;
  height: 200px;
  display: block;
}


.card:hover {
  font-size: 18px;
  /*font-weight: 300;*/
  /*height: 320px;*/
  padding-bottom: 32px;
  width: 320px;
  /*height: 180px;*/
  transform: translateY(-10px);
}


.price {
  /*width: 300px;*/
  /*height: 10px;*/
  float: outside;
  display: flex;
  justify-content: center;
  color: orange;
  font-weight: bold;
}

</style>
