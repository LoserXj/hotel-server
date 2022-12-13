<template>
  <div class="header">
<!--    <img class="avatar" src="../../assets/images/logo.png" alt="头像"/>-->
    <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="1">
        用户名
      </el-menu-item>
      <el-sub-menu index="2">
        <template v-slot:title>个人信息</template>
        <el-menu-item index="2-1">coin: {{'硬币数'}}</el-menu-item>
        <el-menu-item index="2-2">用户中心</el-menu-item>
        <el-menu-item index="2-3" @click="evaluation">测试评价页面</el-menu-item>
        <el-sub-menu index="2-4">
          <template v-slot:title>选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="3" >订单管理</el-menu-item>

      <el-menu-item index="4" @click="store">积分商城</el-menu-item>
      <el-menu-item index="5" @click="chat()">
<!--        <a ref="../../../di"></a>-->
        客服</el-menu-item>
    </el-menu>
  </div>

</template>
<script>
export default {
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    store(){
      this.$router.push('/main/store')
    },
    evaluation(){
      this.$router.push('/main/evaluation')
    },
    chat(){
      window.location.href="../test/chat.html"
    }
  }
}
</script>
<style>


ul {
    list-style: none;
     display: flex;
     align-items: center;
  }


.header {
  width: 100%;
  height: 59px;
  /*background: #17b9b9;*/
  color: #FFFEFE;
  font-size: 14px;
  /*display: table;*/
  justify-content: space-between;
  align-items: center;
}

</style>
