<template>
  <div v-show="display1">
    <div style="margin: 0 auto; width: 800px">
      <p style="font-size: 100px; color: red">欢迎来到first酒店</p>
    </div>
    <div style="margin: 0 auto; width: 600px">
      <el-tag style="width: 500px; height: 40px; font-size: 20px">房间基本信息</el-tag>
    </div>
    <el-table
        ref="filterTable"
        :data="tableData"
        style="width: 1000px; height: 200px; margin: 0 auto">
      <el-table-column
          prop="seq"
          label="房间号"
          width="200"
          align="center">
      </el-table-column>
      <el-table-column
          prop="type"
          label="房间类型"
          width="200"
          :filters="[{text: '单人间', value: '单人间'}, {text: '双人间', value: '双人间'}, {text: '豪华三人间', value: '豪华三人间'}]"
          :filter-method="filterType"
          align="center">
      </el-table-column>
      <el-table-column
          prop="price"
          label="价格/日"
          width="200"
          align="center"
          :filters="[{text: '不低于300', value: 300}, {text: '不低于400', value: 400}]"
          :filter-method="filterPrice">
      </el-table-column>
      <el-table-column
          prop="breakfast"
          label="有无早餐"
          width="200"
          align="center"
          :filters="[{text: '有', value: '有'}, {text: '无', value: '无'},]"
          :filter-method="filterBreakfast">
      </el-table-column>
      <el-table-column
          label="操作"
          width="200"
          align="center">
        <template v-slot="scope">
          <el-button type="primary" @click="myReverse(scope.row.seq)">预定</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 0 auto; width: 400px">
      <p style="font-size: 80px; color: red">房间平面图</p>
    </div>
    <div style="margin: 0 auto; width: 900px; height: auto">
      <img src="../../assets/img/planFigure.png" style="position: relative; z-index: -1; width: 900px; height: 400px" alt="test" @click="myReverse('CS101')">
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 345px" @click="myReverse('CS101')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 420px" @click="myReverse('CS102')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 510px" @click="myReverse('CS103')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 600px" @click="myReverse('CS104')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 687px" @click="myReverse('CS105')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 778px" @click="myReverse('CS106')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 866px" @click="myReverse('CS107')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 955px" @click="myReverse('CS108')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 1045px" @click="myReverse('CS109')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 915px; left: 1133px" @click="myReverse('CS110')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 423px" @click="myReverse('CS118')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 510px" @click="myReverse('CS117')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 605px" @click="myReverse('CS116')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 744px" @click="myReverse('CS115')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 839px" @click="myReverse('CS114')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 937px" @click="myReverse('CS113')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 1030px" @click="myReverse('CS112')"></el-button>
      <el-button style="position: absolute; z-index: 0; top: 1165px; left: 1129px" @click="myReverse('CS111')"></el-button>
    </div>
    <br/>
  </div>
  <div v-show="display2">
    <el-descriptions title="房间信息" direction="vertical" :column="4" border style="width: 1000px; margin:0 auto">
      <el-descriptions-item label="房间号">{{reserve.seq}}</el-descriptions-item>
      <el-descriptions-item label="房间类型">{{reserve.type}}</el-descriptions-item>
      <el-descriptions-item label="房间价格">{{reserve.price}}</el-descriptions-item>
      <el-descriptions-item label="有无早餐">{{reserve.breakfast}}</el-descriptions-item>
    </el-descriptions>
    <div>
      <el-form ref="form" :model="form" style="width: 500px; margin: 100px auto 0 auto">
        <el-form-item label="入住日期">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="离开日期">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.date2" style="width: 100%;"></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">预定</el-button>
          <el-button @click="goBack">返回</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
  export default {
    name: "HotelFirst",
    data() {
      return {
        user: '',
        dateIn: '',
        dateOut: '',
        form: {
          date1: '',
          date2: ''
        },
        display1: true,
        display2: false,
        reserve: {
          id: '',
          seq: '',
          type: '',
          price: '',
          breakfast: '',
        },
        tableData: [{
          seq: 'CS105',
          type: '单人间',
          price: 299,
          breakfast: '有',
        }, {
          seq: 'CS106',
          type: '标准间',
          price: 399,
          breakfast: '无',
        }, {
          seq: 'CS107',
          type: '豪华三人间',
          price: 699,
          breakfast: '有',
        }, {
          seq: 'CS111',
          type: '单人间',
          price: 299,
          breakfast: '无',
        }, {
          seq: 'CS118',
          type: '双人间',
          price: 399,
          breakfast: '有',
        }, {
          seq: 'CS117',
          type: '豪华三人间',
          price: 699,
          breakfast: '无',
        }]
      }
    },
    methods: {
      submit() {
        let date1 = this.form.date1.toString().substring(4, 15)
        let date2 = this.form.date2.toString().substring(4, 15)
        let dateIn = date1.substring(7, 11)
        dateIn += '/'
        switch (date1.substring(0, 3)) {
          case 'Jan': {
            dateIn += '01'
            break
          }
          case 'Feb': {
            dateIn += '02'
            break
          }
          case 'Mar': {
            dateIn += '03'
            break
          }
          case 'Apr': {
            dateIn += '04'
            break
          }
          case 'May': {
            dateIn += '05'
            break
          }
          case 'Jun': {
            dateIn += '06'
            break
          }
          case 'Jul': {
            dateIn += '07'
            break
          }
          case 'Aug': {
            dateIn += '08'
            break
          }
          case 'Sep': {
            dateIn += '09'
            break
          }
          case 'Oct': {
            dateIn += '10'
            break
          }
          case 'Nov': {
            dateIn += '11'
            break
          }
          case 'Dec': {
            dateIn += '12'
            break
          }
        }
        dateIn += '/'
        dateIn += date1.substring(4, 6)
        let dateOut = date2.substring(7, 11)
        dateOut += '/'
        switch (date2.substring(0, 3)) {
          case 'Jan': {
            dateOut += '01'
            break
          }
          case 'Feb': {
            dateOut += '02'
            break
          }
          case 'Mar': {
            dateOut += '03'
            break
          }
          case 'Apr': {
            dateOut += '04'
            break
          }
          case 'May': {
            dateOut += '05'
            break
          }
          case 'Jun': {
            dateOut += '06'
            break
          }
          case 'Jul': {
            dateOut += '07'
            break
          }
          case 'Aug': {
            dateOut += '08'
            break
          }
          case 'Sep': {
            dateOut += '09'
            break
          }
          case 'Oct': {
            dateOut += '10'
            break
          }
          case 'Nov': {
            dateOut += '11'
            break
          }
          case 'Dec': {
            dateOut += '12'
            break
          }
        }
        dateOut += '/'
        dateOut += date2.substring(4, 6)

        this.user = sessionStorage.getItem("user")
        this.$http.get('http://localhost:8281/order/reserve', {params:{user_tel: this.user, room_id: this.reserve.seq , start_time: dateIn, end_time: dateOut}})
            .then(res => {
              console.log(res)
              if (res.data.code === 200) {
                for (let i = 0; i < res.data.object.length; i++) {
                  let a = {seq: 'CS117', type: '豪华三人间', price: 699, breakfast: '无',};
                  a.seq = res.data.object[i].position
                  a.type = res.data.object[i].type_id;
                  a.price = res.data.object[i].price;
                  a.breakfast = res.data.object[i].hasBreakfast;
                  this.tableData.push(a)
                }
              }
            })
      },
      goBack() {
        this.display1 = true
        this.display2 = false
      },
      myReverse(seq) {
        for(let i = 0; i < this.tableData.length; i++)
          if (this.tableData[i].seq === seq) {
            this.reserve = this.tableData[i]
            this.display1 = false
            this.display2 = true
          }
      },
      filterBreakfast(value, row, column) {
        const property = column['property'];
        return row[property] === value
      },
      filterPrice(value, row, column) {
        const property = column['property'];
        return row[property] >= value
      },
      filterType(value, row, column) {
        const property = column['property'];
        return row[property] === value
      }
    },
    created() {
      this.$http.get('http://127.0.0.1:8381/room/roomInfo', {params:{id: '1'}})
          .then(res => {
            console.log(res)
            if (res.data.code === 200) {
              for (let i = 0; i < res.data.object.length; i++) {
                let a = {seq: 'CS117', type: '豪华三人间', price: 699, breakfast: '无',};
                a.seq = res.data.object[i].position
                a.type = res.data.object[i].type_id;
                a.price = res.data.object[i].price;
                a.breakfast = res.data.object[i].hasBreakfast;
                this.tableData.push(a)
              }
            }
          })
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