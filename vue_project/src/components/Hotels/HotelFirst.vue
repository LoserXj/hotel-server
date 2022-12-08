<template>
  <div style="padding-top: 100px; margin: 0 auto; width: 200px">
    <p style="color: red">欢迎来到first酒店</p>
  </div>
  <el-table
      :data="tableData"
      style="width: 900px; margin: 0 auto"
      :default-sort = "{prop: 'id', order: 'ascending'}"
  >
    <el-table-column
        prop="seq"
        label="房间号"
        sortable
        width="300">
    </el-table-column>
    <el-table-column
        prop="type"
        label="房间类型"
        sortable
        width="300">
    </el-table-column>
    <el-table-column
        prop="price"
        label="价格"
        sortable
        width="300">
    </el-table-column>
  </el-table>
  <div style="margin: 0 auto; width: 200px">
    <p style="color: red">房间平面图</p>
  </div>
  <br/>
  <template>
    <div class="demo-image__lazy">
      <el-image v-for="url in urls" :key="url" :src="url" lazy />
    </div>
  </template>


</template>

<script>
  export default {
    name: "HotelFirst",
    data() {
      return {
        tableData: [{
          seq: 'CS101',
          type: 'Single Room',
          price: 520,
        }, {
          seq: 'CS102',
          type: 'Standard Room',
          price: 520,
        }],
        urls: [
          //require('D:\\vue_project\\src\\assets\\images\\login.jpg'),
          //require('D:\\vue_project\\src\\assets\\images\\logo.png')
          // '../../assets/images/logo.png',
          // '../../assets/images/login.jpg',
          // '../../assets/images/logo.png',
          // '../../assets/images/login.jpg',
          // '../../assets/images/logo.png',
          // '../../assets/images/login.jpg',
          // '../../assets/images/logo.png'
        ]
      }
    },
    methods: {
      trans(hotelName) {
        alert(hotelName)
        this.$router.push('/main/HotelFirst')
      }
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