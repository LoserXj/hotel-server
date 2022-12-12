<template>
  <body>
  <el-card class="box-card" shadow="always" >
    <div style="">

      <h2>
        查询订房记录
      </h2>
    </div>

    <div class="search">
      <el-icon><Edit /></el-icon>
      <span>顾客姓名</span>

      <el-input
          v-model="GuestName"
          class="w-50 m-2"
          placeholder="Type something"
          clearable
          style="width: 20%; margin-right: 20%"

      ></el-input>

      <el-icon><Edit /></el-icon>
      <span>手机号&#12288;</span>

      <el-input
          v-model="GuestTelephoneNum"
          class="w-50 m-2"
          placeholder="Type something"
          clearable
          style="width: 20%"
      ></el-input>

    </div>

    <div class="search">

    </div>

    <!--      <div class="search">-->
    <!--        <el-icon><HomeFilled /></el-icon>-->
    <!--        <span class="demonstration">酒店城市</span>-->
    <!--        <el-select v-model="locationValue" filterable placeholder="请选择">-->
    <!--          <el-option-->
    <!--              v-for="item in locationOptions"-->
    <!--              :key="item.value"-->
    <!--              :label="item.label"-->
    <!--              :value="item.value">-->
    <!--          </el-option>-->
    <!--        </el-select>-->
    <!--        <br>-->
    <!--      </div>-->

    <div class="search">

      <el-icon><Edit /></el-icon>
      <span>房间号&#12288;</span>

      <el-input
          v-model="RoomNum"
          class="w-50 m-2"
          placeholder="Type something"
          clearable
          style="width: 20%; margin-right: 20%"
      ></el-input>

      <el-icon><Operation/></el-icon>
      <span class="demonstration">订单状态</span>
      <el-select v-model="StateValue" filterable placeholder="请选择">
        <el-option
            v-for="item in State"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>


    </div>
    <div class="search">
      <el-icon><Calendar /></el-icon>
      <span class="demonstration">入住时间</span>
      <el-date-picker
          v-model="inDate"
          type="date"
          placeholder="开始日期"
          style="width: 20%"
      >
      </el-date-picker>
      <span>&#12288;至&#12288;</span>
      <el-date-picker
          v-model="outDate"
          type="date"
          placeholder="结束日期"
          style="width: 20%; margin-right: 5%"
      >
      </el-date-picker>

      <el-button type="primary" size="large" :icon="Search" round @click="onSubmit">Search</el-button>
      <el-button type="danger" size="large" :icon="Delete" round @click="clear">Clear</el-button>

    </div>
    <div class="search">

    </div>



    <div>

    </div>

  </el-card>
  <el-card>
    <el-table :data="tableData"  style="width: 100%">
      <el-table-column prop="GuestName" label="顾客姓名" width="180" />
      <el-table-column prop="GuestTelephoneNum" label="手机号" width="180" />
      <el-table-column prop="inDate" label="入住日期" width="180" />
      <el-table-column prop="outDate" label="结束日期" width="180" />
      <el-table-column prop="RoomID" label="房间号" />
    </el-table>
  </el-card>


  </body>

</template>

<script>

import {
  Search,
  Delete,
  Edit,
  Calendar,
  Operation,
} from '@element-plus/icons-vue'
export default {
  name: "CheckRecord",

  components:{
    // HomeFilled,
    Edit,
    Calendar,
    Operation,
  },

  data() {
    return {
      title:'订房记录',

      RoomNum:'',
      inDate:'',
      outDate:'',
      GuestName:'',
      GuestTelephoneNum:'',

      Search: Search,
      Delete: Delete,


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

      State:[{
        value: '选项1',
        label: '已预定'
      }, {
        value: '选项2',
        label: '已支付'
      }, {
        value: '选项2',
        label: '已评价'
      }],
      StateValue: '',


      tableData: [
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
        {
          GuestName: 'Tom',
          GuestTelephoneNum: 'sdf',
          inDate: '2016-05-03',
          outDate: '342324',
          RoomID: '414342',
        },
      ]



    };
  },
  methods: {
    handleChange(value) {
      console.log(value);
    },

    clear() {
      this.RoomNum=''
      this.inDate=''
      this.outDate=''
      this.GuestName=''
      this.GuestTelephoneNum=''
      this.StateValue=''
    },

    onSubmit() {

    },

    created() {
      this.onSubmit()
    },


  }
}
</script>

<style scoped>

body{

}

.box-card{
  background-size: cover;
  background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%);
}

.search{
  margin-bottom: 10px;
}

h2{
  font-size: 25px;
  color: white;
  text-shadow:0px 1px 0px #c0c0c0,
  0px 2px 0px #b0b0b0,
  0px 3px 0px #a0a0a0,
  0px 4px 0px #909090,
  0px 5px 10px rgba(0, 0, 0, .9);
}

</style>
