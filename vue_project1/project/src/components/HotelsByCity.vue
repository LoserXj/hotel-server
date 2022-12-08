<template>
  <div>
    酒店推荐
    <el-button type="primary" @click="this.city('Beijing')">北京</el-button>
    <el-button type="primary" @click="this.city('Shanghai')">上海</el-button>
    <el-button type="primary" @click="this.city('Shenzhen')">深圳</el-button>
    <el-button type="primary" @click="this.city('Guangzhou')">广州</el-button>
    <el-button type="primary" @click="this.city('Hangzhou')">杭州</el-button>
    <br/>
    <el-table
        :data="tableData"
        style="width: 800px; margin: 0 auto"
        :default-sort = "{prop: 'id', order: 'ascending'}"
    >
      <el-table-column
          prop="name"
          label="名称"
          sortable
          width="200">
      </el-table-column>
      <el-table-column
          prop="total"
          label="总房间数"
          sortable
          width="200">
      </el-table-column>
      <el-table-column
          prop="empty"
          label="空房间数"
          sortable
          width="200">
      </el-table-column>
      <el-table-column
          prop="picture"
          label="酒店图片"
          width="200"
      >
        <template v-slot="scope">
          <el-image style="width: 100%; height: 200px" :src="scope.row.address" @click="trans(scope.row.name)"></el-image>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  // eslint-disable-next-line vue/no-export-in-script-setup

  export default {
    name: "HotelsByCity",
    data() {
      return {
        tableData: [{
          name: 'SUSTechHotel1',
          total: 520,
          empty: 250,
          address: require('../assets/images/logo.png')
        }, {
          name: 'SUSTechHotel2',
          total: 520,
          empty: 250,
          address: require('../assets/images/login.jpg')
        }]
      }
    },
    methods: {
      city(cityName) {
        if (cityName === 'Beijing')
          this.tableData = [{
            name: 'SUSTechHotel3',
            total: 520,
            empty: 250,
            address: require('../assets/images/logo.png')
          }, {
            name: 'SUSTechHotel4',
            total: 520,
            empty: 250,
            address: require('../assets/images/login.jpg')
          }]
        else if (cityName === 'Shanghai') {
          this.tableData = [{
            name: 'SUSTechHotel5',
            total: 520,
            empty: 250,
            address: require('../assets/images/login.jpg')
          }, {
            name: 'SUSTechHotel6',
            total: 520,
            empty: 250,
            address: require('../assets/images/logo.png')
          }]
        }
      },
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