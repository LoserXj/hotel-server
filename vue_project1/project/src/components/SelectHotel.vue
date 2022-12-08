<template>

  <!--  <el-input v-model="input" placeholder="请输入内容" ></el-input>-->

  <div class="block">
    <span class="demonstration">城市</span>
    <el-select v-model="locationValue" filterable placeholder="请选择">
      <el-option
          v-for="item in locationOptions"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>

    <span class="demonstration">入住时间</span>
    <el-date-picker
        v-model="value2"
        type="daterange"
        align="right"
        unlink-panels
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
      <!--        :picker-options="pickerOptions"-->
      <!--    >-->
      <!--      start-placeholder =-->
    </el-date-picker>
    <br>

    <span class="demonstration">房间</span>
    <el-input-number v-model="roomNum" @change="handleChange" :min="1" :max="100" label="roomNum"></el-input-number>
    <span class="demonstration">住客</span>
    <el-input-number v-model="adultNum" @change="handleChange" :min="1" :max="100" label="adultNum"></el-input-number>
    <br>
    <span class="demonstration">酒店级别</span>
    <el-select v-model="levelValue" placeholder="请选择">
      <el-option
          v-for="item in levelOptions"
          :key="item.value"
          :label="item.label"
          :value="item.value">
      </el-option>
    </el-select>
    <el-row>
      <el-button type="primary" style="margin:0 auto;">搜索</el-button>
    </el-row>

  </div>
</template>
<!--state：存储基本数据
getter：从基本数据(state)派生的数据，相当于state的计算属性
mutation ： store中更改state数据状态的唯一方法（mutations必须是同步函数）
action： 包含异步操作（请求API方法）、回调函数提交mutaions更改state数据状态，使之可以异步。
module： 模块化Vuex（将store分割成不同的模块）-->
<script>

export default {
  name: 'App',
  data() {
    return {
      // pickerOptions: {
      //   shortcuts: []
      // },
      value1: '',
      value2: '',
      input: '',
      roomNum: 1,
      adultNum: 1,
      // teenNum: 1,
      //城市
      locationOptions: [{
        value: '选项1',
        label: '深圳'
      }, {
        value: '选项2',
        label: '广州'
      }, {
        value: '选项3',
        label: '抚州'
      }, {
        value: '选项4',
        label: '南昌'
      }, {
        value: '选项5',
        label: '北京'
      }],
      locationValue: '',
      levelValue: '',
      levelOptions: [{
        value: '选项0',
        label: '无星级'
      }, {
        value: '选项1',
        label: '一星级'
      }, {
        value: '选项2',
        label: '二星级'
      }, {
        value: '选项3',
        label: '三星级'
      }, {
        value: '选项4',
        label: '四星级'
      }, {
        value: '选项5',
        label: '五星级及以上'
      }],
    };
  },
  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
};
</script>
<style>
  body {
    margin: 0;
    padding: 0;
  }
</style>
