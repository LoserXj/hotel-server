<template>
  <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
    <el-tab-pane label="修改房间基本信息" name="first">
      <ModifyRoom/>
    </el-tab-pane>
    <el-tab-pane label="查询顾客订房记录" name="second">
      <CheckRecord/>
    </el-tab-pane>

  </el-tabs>
</template>


<script>
import ModifyRoom from "../../components/Manager/ModifyRoom.vue";
import CheckRecord from "../../components/Manager/CheckRecord.vue";
  export default {
    components: {
      CheckRecord,
      ModifyRoom
    },
    data() {
      return {
        activeName: 'second'
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };

</script>

<style>

</style>