<template>
  <div class="block">
    <ul>
      <li>
        <span class="demonstration">酒店城市</span>
        <el-select v-model="locationValue" filterable placeholder="请选择">
          <el-option
              v-for="item in locationOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </li>
      <li>
        <span class="demonstration">酒店名称</span>
        <el-select v-model="NameValue" filterable placeholder="请选择">
          <el-option
              v-for="item in Names"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </li>
      <li>
        <span class="demonstration">入住时间</span>
        <el-date-picker
            v-model="value2"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">

        </el-date-picker>
      </li>
      <li>
        <el-row>
          <span class="ml-3 w-35 text-gray-600 inline-flex items-center" >房间号</span>
          <el-input
              v-model="input2"
              class="w-50 m-2"
              placeholder="Type something"
              :prefix-icon="Search"
              clearable

          />
        </el-row>
      </li>
    </ul>
  </div>
</template>

<script>

import { Search } from '@element-plus/icons-vue'
export default {
  name: "CheckRecord",

  data() {
    return {
      value1: '',
      value2: '',
      input: '',
      Search: Search,
      input2: '',
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

      Names:[],
      NameValue: '',




    };
  },
  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
}
</script>

<style scoped>
ul li{
  list-style: none;
  float: left;
}
</style>
