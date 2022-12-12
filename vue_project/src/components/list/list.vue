<template>

  <ul class="list">

    <li class="lii" v-for="item in goodsList" :key = item.id >
      <img class="productimg" :src="require('../../assets/images/'+ item.picture)" alt="图片"
           @click="goDetail(item.id)"/>
      <section class="card">
        <div class="protitle" >{{ item.name }}</div>
        <div class="price">
          {{ 'coin:' + item.description }}
          <el-button type="info" icon="el-icon-star-off" autofocus="autofocus" circle></el-button>
        </div>
      </section>
    </li>
  </ul>
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
    goDetail(id) {
      this.$router.push(`/detail?id=${id}`)
    },

  }
};
</script>

<style>
ul {
  list-style: none;
  display: flex;
  align-items: center;
}

.list {

  display: flex;
  justify-content: flex-start;
  /*flex-wrap: wrap;*/
}

.lii:hover {
  width: 300px;
  height: 430px;
  position: relative;
  margin-bottom: 20px;
  margin-right: 20px;
  transition: all .5s linear;
  cursor: pointer;
  box-shadow: 1px 1px 10px #ccc;
  transform: translateY(-10px);
  background: #fff;
}


.productimg {
  width: 300px;
  height: 230px;
  display: block;
}

.card {
  /*font-size: 18px;*/
  /*font-weight: 300;*/
  width: 330px;
  height: 100px;
  /*padding-bottom: 32px;*/
}

.protitle {
  /*position:absolute;*/
  /*top: 100px;*/
  /*bottom: 0px;*/
  /*background-color: green;*/
  /*width: 100%;*/
  width: 300px;
  height: 30px;
  margin-top: 22px;
  margin-bottom: 16px;
  color: #333333;
  text-align: center;
}

.price {
  /*width: 300px;*/
  /*height: 30px;*/
  display: flex;
  justify-content: center;
  color: orange;
  font-weight: bold;
}

.producticon {
  width: 20px;
  height: 20px;
}


.button:hover {
  /*width: 50px;*/
  /*height: 36px;*/
  /*line-height: 36px;*/
  text-align: center;
  margin: 20px auto;
  margin-bottom: 0;
  border: 1px solid blue;
  color: blue;
  background: #fff;
}


</style>
