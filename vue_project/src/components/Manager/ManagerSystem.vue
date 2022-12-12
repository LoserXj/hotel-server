<template>

  <body>
  <div style="margin-top:10%; text-align: center; vertical-align: middle">
    <el-avatar :size="50" :src="userImg" />
    <p>管理员</p>
    <p>姓名：<span>{{ name }}</span></p>
    <p>工号：<span>{{admin_id}}</span></p>
    <p>手机：<span>{{telephone}}</span></p>
  </div>

  </body>

</template>

<script>


export default {
  name: 'ManagerSystem',

  components: {

  },
  data() {
    return {
      title:'管理员主页',
      userImg: require('../../assets/manager/img_6.png'),
      name:'',
      admin_id:'',
      telephone:'',

    };
  },
  methods: {
    onInformation(){

      this.$http.get('http://localhost:8081/user/managerInfo', {params: {user_tel: sessionStorage.getItem("user")}}).then(
          res => {
            let admin = res.data;

            this.name = admin.name
            this.admin_id = admin.id;
            this.telephone = admin.tel;
            console.log(admin)
          }

      )
    },



  },
  created() {
    this.onInformation()
  }


};

</script>

<style scoped>
body{

}
</style>
