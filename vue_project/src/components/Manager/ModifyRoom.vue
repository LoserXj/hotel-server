<template>
  <body>
  <el-card>
    <el-table :data="tableData" style="height: 100%; width: 100%">
      <el-table-column prop="type" label="类型名称"  />
      <el-table-column prop="price" label="价格" />
      <el-table-column prop="hotel" label="酒店" />
      <el-table-column prop="message" label="信息" />
      <el-table-column prop="hasBreakfast" label="早餐" />
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button class="btn" size="small" @click="handleEdit(scope.$index)">Edit</el-button>
          <el-button class="btn" size="small" type="danger" @click="handleDelete(scope.$index)">Delete</el-button>
        </template >
      </el-table-column>
    </el-table>
  </el-card>


  <el-dialog v-model="dialogFormVisible.show" title="编辑房间信息" ><el-form :model="form">
    <el-form-item label="类型名称">
      <el-input v-model="form.type" autocomplete="off" />
    </el-form-item>
    <el-form-item label="价格&#12288;&#12288;" >
      <el-input v-model="form.price" autocomplete="off" />
    </el-form-item>

    <el-form-item label="酒店&#12288;&#12288;">
      <el-input v-model="form.hotel" autocomplete="off" />
    </el-form-item>
    <el-form-item label="信息&#12288;&#12288;">
      <el-input v-model="form.message" autocomplete="off" />
    </el-form-item>
    <el-form-item label="早餐&#12288;&#12288;" >
      <el-select v-model="form.hasBreakfast" placeholder="">
        <el-option label="有早餐" value="有早餐" />
        <el-option label="无早餐" value="无早餐" />
      </el-select>
    </el-form-item>
  </el-form>
    <template #footer>
      <span class="dialog-footer">

        <el-button type="primary" @click=submit()>
          Confirm
        </el-button>

        <el-button @click="dialogFormVisible.show = false">Cancel</el-button>
      </span>
    </template>
  </el-dialog>


  </body>


</template>


<script>

import { reactive } from 'vue'

import {Edit} from '@element-plus/icons-vue'


export default {

  name: 'ModifyRoom',
  components: {

  },

  data() {

    return {
      title:'房间信息',

      dialogFormVisible: {
        show: false,
        index: 1,
      },

      form:reactive({
        price:'',
        type:'',
        hotel:'',
        message:'',
        hasBreakfast: '',
      }) ,

      Edit: Edit,

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


      tableData: [
        {
          price:1.0,
          type:'2',
          hotel:'1',
          message:'1',


          hasBreakfast: 'No. 189, Grove St, Los Angeles',
        },
        {
          price:1.0,
          type:'3',
          hotel:'1',
          message:'1',


          hasBreakfast: 'No. 189, Grove St, Los Angeles',
        },{
          price:1.0,
          type:'4',
          hotel:'1',
          message:'1',

          hasBreakfast: 'No. 189, Grove St, Los Angeles',
        },{
          price:1.0,
          type:'5',
          hotel:'1',
          message:'1',


          hasBreakfast: 'No. 189, Grove St, Los Angeles',
        },
      ]

    };
  },


  methods: {
    handleChange(value) {
      console.log(value);
    },

    handleEdit(index){
      this.dialogFormVisible.show = true
      this.dialogFormVisible.index = index
    },

    handleDelete(index){

      this.tableData.splice(index,1)

    },

    submit(){
      this.tableData[this.dialogFormVisible.index] = this.form
      this.dialogFormVisible.show = false
    },

    onSubmit(){

    },

    created() {
      this.onSubmit()
    },
  }
};
</script>

<style scoped>

  .btn{
    margin-left: 0;
  }



  .el-button--text {
    margin-right: 15px;
  }
  .el-select {
    width: 300px;
  }
  .el-input {
    width: 300px;
  }
  .dialog-footer button:first-child {
    margin-right: 10px;
  }


</style>



