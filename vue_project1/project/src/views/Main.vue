<template>


  <el-container>
    <!--      <div>-->
    <!--      走马灯-->
    <el-header height="450px">
      <el-carousel :interval='5000' height='400px' arrow='always'>
        <el-carousel-item v-for='item in imagesbox' :key='item.id'>
          <img :src='item.idView' class='image'>
        </el-carousel-item>
      </el-carousel>
      <!--            <h3>图片</h3>-->
    </el-header>
    <!--      </div>-->
    <!--      分割线-->
    <div>
      <el-divider>
        <!--          aaa-->
      </el-divider>
    </div>

    <!--      <div>-->
    <el-main>
      <!--          城市-->
      <div>
        <el-row>
          <el-button @click="onCity('北京')">北京</el-button>
          <el-button type="primary" @click="onCity('上海')">上海</el-button>
          <el-button type="success" @click="onCity('深圳')">深圳</el-button>
          <el-button type="info" @click="onCity('广州')">广州</el-button>
          <el-button type="warning" @click="onCity('抚州')">抚州</el-button>
          <el-button type="danger" @click="onCity('赣州')">赣州</el-button>
        </el-row>

        <el-divider>
          <!--          aaa-->
        </el-divider>
      </div>
      <div>
        <List :goods-list="hotel"></List>
      </div>
<!--      <div>-->
<!--        <el-row :gutter="12">-->
<!--          <el-col :span="6">-->

<!--            <el-card :body-style="{ padding: '5px' }" shadow="hover" class="el-card-define">-->
<!--&lt;!&ndash;              <img :src="require('../assets/images/' + hotel[0].picture)" class="image" >&ndash;&gt;-->
<!--              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"-->
<!--                   class="image" >-->
<!--              <div style="padding: 14px;">-->
<!--                <span>{{ hotel[0].name }}</span>-->
<!--                <div class="bottom clearfix">-->
<!--                  <time class="time">{{ hotel[0].address }}</time>-->
<!--                  <el-button type="text" class="button">收藏</el-button>-->
<!--                </div>-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->
<!--          <el-col :span="6">-->

<!--            <el-card :body-style="{ padding: '5px' }" shadow="hover" class="el-card-define">-->
<!--              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"-->
<!--                   class="image" >-->
<!--              <div style="padding: 14px;">-->
<!--                <span>{{ hotel[1].name }}</span>-->
<!--                <div class="bottom clearfix">-->
<!--                  <time class="time">{{ hotel[1].address }}</time>-->
<!--                  <el-button type="text" class="button">收藏</el-button>-->
<!--                </div>-->
<!--              </div>-->
<!--            </el-card>-->

<!--          </el-col>-->
<!--          <el-col :span="6">-->
<!--            <el-card :body-style="{ padding: '5px' }" shadow="hover" class="el-card-define">-->
<!--              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"-->
<!--                   class="image">-->
<!--              <div style="padding: 14px;">-->
<!--                <span>{{ hotel[2].name }}</span>-->
<!--                <div class="bottom clearfix">-->
<!--                  <time class="time">{{ hotel[2].address }}</time>-->
<!--                  <el-button type="text" class="button">收藏</el-button>-->
<!--                </div>-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->
<!--          <el-col :span="6">-->
<!--            <el-card :body-style="{ padding: '5px' }" shadow="hover" class="el-card-define">-->
<!--              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"-->
<!--                   class="image">-->
<!--              <div style="padding: 14px;">-->
<!--                <span>{{ hotel[3].name }}</span>-->
<!--                <div class="bottom clearfix">-->
<!--                  <time class="time">{{ hotel[3].address }}</time>-->
<!--                  <el-button type="text" class="button">收藏</el-button>-->
<!--                </div>-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->
<!--        </el-row>-->
<!--      </div>-->


    </el-main>
    <!--      </div>-->

  </el-container>

</template>


<script>

// import List from '../components/list/List'
import List from "@/components/list/List";
console.log("我已初始化执行成功");


export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Main',
  components: {List},
  data() {
    return {
      city: '北京',
      // url: require('../assets/img/img.jpg'),
      hotel: [
        {id:0,
          name: 'name',
          address: 'xxx',
          city: 'city',
          picture:'../assets/img/img.jpg',
          description: '描述',
        },
        {id:1,
          name: 'name',
          address: 'xxx',
          city: 'city',
          picture:'img.jpg',
          description: '描述',
        },
        {id:2,
          name: 'name',
          address: 'xxx',
          city: 'city',
          picture:'../assets/img/img.jpg',
          description: '描述',
        },
        {id:3,
          name: 'name',
          address: 'xxx',
          city: '北京',
          picture:'../assets/img/img.jpg',
          description: '描述',
        }
      ],
      // hotel: [],
      imagesbox: [
        {id: 0, idView: require('../assets/img/pic1.jpg')},
        {id: 1, idView: require('../assets/img/280.jpg')},
        {id: 2, idView: require('../assets/img/img.jpg')}],
      currentDate: new Date()
    };
  },
  methods: {
    trans(hotelName) {
      alert(hotelName)
      this.$router.push('/main/HotelFirst')
    },

    onCity(city) {
      this.city = city
      console.log(this.city)
      this.onSubmit()

    },

    onSubmit() {
      this.$http.get('http://localhost:8181/hotel/getHotel', {params: {city: this.city}}).then(
          res => {
            //  res.data
            console.log(res.data[0])
            let hotels = res.data;
            for (let i = 0; i < 1; i++) {
              let hotel = hotels[i];
              this.hotel[i].id = i
              this.hotel[i].name = hotel.name
              this.hotel[i].address = hotel.address
              this.hotel[i].city = hotel.city
              this.hotel[i].picture = 'background.jpg';
              this.hotel[i].description = hotel.description
            }
            console.log('pic')
            console.log(this.hotel[0].picture)
          }
      )
    },
  },
  created() {
    this.onCity('深圳')
  }

};


</script>

<style>
.el-header {
  background-color: #ffffff;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  background-color: #ffffff;
  color: #333;
  text-align: center;
  line-height: 160px;
}

.time {
  width: 100%;
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}


</style>

<!--<template>-->
<!--  <el-container>-->
<!--    <el-header>-->
<!--      <el-button type="primary" @click="order()">订单</el-button>-->
<!--      <el-button type="primary" @click="evaluation()">评价</el-button>-->
<!--      <el-button type="primary" @click="customerService()">客服</el-button>-->
<!--    </el-header>-->
<!--    <el-main>-->
<!--      <HotelsByCity></HotelsByCity>-->
<!--    </el-main>-->
<!--  </el-container>-->
<!--</template>-->

<!--<script>-->
<!--import HotelsByCity from "@/components/HotelsByCity";-->
<!--  export default {-->
<!--    // eslint-disable-next-line vue/multi-word-component-names-->
<!--    name: "Main",-->
<!--    components: {-->
<!--      HotelsCity-->
<!--    },-->
<!--    data() {-->
<!--      return {-->
<!--        input: '',-->
<!--      }-->
<!--    },-->
<!--    methods: {-->
<!--      order() {-->
<!--        this.$router.push('/main/order')-->
<!--      },-->
<!--      evaluation() {-->
<!--        this.$router.push('/main/evaluation')-->
<!--      },-->
<!--      customerService() {-->
<!--        this.$router.push('/main/customerService')-->
<!--      }-->

<!--    }-->
<!--  }-->
<!--</script>-->

<!--<style scoped>-->
<!--  .el-header, .el-footer {-->
<!--    background-color: #B3C0D1;-->
<!--    color: #333;-->
<!--    text-align: center;-->
<!--    line-height: 60px;-->
<!--  }-->

<!--  .el-aside {-->
<!--    background-color: #D3DCE6;-->
<!--    color: #333;-->
<!--    text-align: center;-->
<!--    line-height: 200px;-->
<!--  }-->

<!--  .el-main {-->
<!--    background-color: #E9EEF3;-->
<!--    color: #333;-->
<!--    text-align: center;-->
<!--    line-height: 160px;-->
<!--  }-->

<!--  body > .el-container {-->
<!--    margin-bottom: 40px;-->
<!--  }-->

<!--  .el-container:nth-child(5) .el-aside,-->
<!--  .el-container:nth-child(6) .el-aside {-->
<!--    line-height: 260px;-->
<!--  }-->

<!--  .el-container:nth-child(7) .el-aside {-->
<!--    line-height: 320px;-->
<!--  }-->
<!--</style>-->