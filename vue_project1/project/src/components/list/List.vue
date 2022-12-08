<template>

  <ul class="list">

    <li class="li" @click="goDetail(item.id)" v-for="item in goodsList" :key="item.id">
      <img class="productimg" v-lazy="'assets/images/' + item.picture" alt="图片" />
      <section>
        <div class="protitle">{{ item.name }}</div>
        <div class="price">
          <span>{{ item.address }}</span>
          <img class="producticon" src="../../assets/img/pic1.jpg" alt="'鸡腿"/>
        </div>
        <div class="button">收藏</div>
      </section>
    </li>
  </ul>
</template>

<script>
export default {
  name: `List`,
  // name: "List",
  props: ['goodsList'],
  methods: {
    goDetail(id) {
      this.$router.push(`/detail?id=${id}`)
    }
  }
};
</script>

<style>
.list {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

.li {
  position: relative;
  margin-bottom: 20px;
  margin-right: 20px;
  transition: all .5s linear;
  cursor: pointer;
  box-shadow: 1px 1px 10px #ccc;
}

.productimg {
  width: 285px;
  height: 330px;
  display: block;
}


.protitle {
  margin-top: 22px;
  margin-bottom: 16px;
  color: #333333;
  text-align: center;
}

.price {
  display: flex;
  justify-content: center;
  color: orange;
  font-weight: bold;
}
.producticon {
  width: 20px;
  height: 20px;
}


.button {
  width: 100px;
  height: 36px;
  line-height: 36px;
  text-align: center;
  margin: 20px auto;
  margin-bottom: 0;
  border: 1px solid blue;
  color: blue;
  background: #fff;
}


</style>
