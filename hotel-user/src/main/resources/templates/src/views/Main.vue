<template>
  <el-container>
    <el-header>
      <el-button type="primary">订单</el-button>
      <el-button type="primary">评价</el-button>
      <el-button type="primary">客服</el-button>
    </el-header>
    <el-main>
      <SelectHotel></SelectHotel>
      <HotelsCity></HotelsCity>
    </el-main>
  </el-container>
</template>

<script>
import HotelsCity from "@/components/HotelsCity";
import SelectHotel from "@/components/SelectHotel";
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Main",
    components: {
      HotelsCity,
      SelectHotel
    },
    data() {
      return {
        input: '',
      }
    },
    methods: {

    }
  }
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>