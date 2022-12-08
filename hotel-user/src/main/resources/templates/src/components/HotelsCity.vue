<template>
  <div>
    酒店推荐
    <el-button type="primary">北京</el-button>
    <el-button type="primary">上海</el-button>
    <el-button type="primary">深圳</el-button>
    <el-button type="primary">广州</el-button>
    <el-button type="primary">杭州</el-button>
    <br/>
  </div>
</template>

<script>
  // eslint-disable-next-line vue/no-export-in-script-setup
  export default {
    name: "HotelsCity",
    data() {
      return {
      }
    },
    methods: {
    }
  }
</script>

<style scoped>
.demo-image__lazy {
  height: 400px;
  overflow-y: auto;
}
.demo-image__lazy .el-image {
  display: block;
  min-height: 200px;
  margin-bottom: 10px;
}
.demo-image__lazy .el-image:last-child {
  margin-bottom: 0;
}
</style>