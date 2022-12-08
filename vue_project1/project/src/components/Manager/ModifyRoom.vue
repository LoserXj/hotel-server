<template>
  <div>
    <ul>
      <li>
        <span class="demonstration">床型</span>
        <el-select v-model="bedValue" filterable placeholder="请选择">
          <el-option
              v-for="item in bedOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </li>
      <li>
        <span class="demonstration">早餐</span>
        <el-select v-model="breakfastValue" filterable placeholder="请选择">
          <el-option
              v-for="item in breakfastOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </li>
      <li>
        <span class="demonstration">住客</span>
        <el-input-number v-model="adultNum" @change="handleChange" :min="1" :max="100" label="adultNum">
        </el-input-number>
      </li>
    </ul>
  </div>
</template>


<script>


export default {

  name: 'ModifyRoom',

  data() {
    return {
      value1: '',
      value2: '',
      input: '',

      input2: '',
      adultNum: '',

      bedOptions: [{
        value: '选项1',
        label: '大床'
      }, {
        value: '选项2',
        label: '双床'
      }, {
        value: '选项3',
        label: '单人床'
      }],
      bedValue: '',

      breakfastOptions: [{
        value: '选项1',
        label: '有早餐'
      }, {
        value: '选项2',
        label: '无早餐'
      }],
      breakfastValue: '',

    };
  },


  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
};
</script>

<style scoped>
ul li{
  list-style: none;
  float: left;
}
</style>


