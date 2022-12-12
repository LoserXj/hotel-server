<template id="body">
  <div id="app">
    <div class="box1">
      <h1>Login</h1>
      <form>
        <div class="inputbox">
          <input type="text" required="" id="username" v-model="username">
          <label for="username">用户名</label>
        </div>
        <div class="inputbox">
          <input type="password" required="" id="password" v-model="password">
          <label for="password">密码</label>
        </div>
        <input style="margin-left: 25px; margin-right: 80px" type="button" value="用户登录" @click="onSubmit">
        <input type="button" value="管理员登录" @click="onManagerSubmit">
        <br/>
        <input style="margin-left: 125px; margin-top: 20px" type="button" value="注册" @click="register">
      </form>
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Login",

  data() {
    return {
      username: '',
      password: ''
    }
  },

  methods: {
    onManagerSubmit() {
      this.$http.get('http://localhost:8081/user/manager', {params:{tel: this.username, password: this.password}})
          .then(res => {
            if (res.data.code === 200){
              sessionStorage.setItem("user", this.username);
              this.$router.push('/manager');
            }
            else {
              this.$message.error(res.data.msg);
            }
          })
    },
    register() {
      this.$router.push('/register')
    },
    onSubmit() {
      sessionStorage.setItem("user", this.username);
      this.$router.push('/main');
/*
      //使用axios发送请求到后端
      this.$http.get('http://localhost:8081/user/login', {params:{tel: this.username, password: this.password}})
          .then(res => {
            if (res.data.code === 200)
              sessionStorage.setItem("user", this.username);
              this.$router.push('/main');
            else if (res.data.status === 200 && res.data.msg === 'manager')
              this.$router.push('/manager');
            else {
              this.$message.error(res.data.msg);
            }
          })*/
    }
  },

}
</script>
<style scoped>
  #app {
    background-image: url("@/assets/images/background.jpg");
  }
  body{
    padding: 0px;
    margin: 0px;
  }
  .box1{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 400px;
    padding: 40px;
    background: rgb(0,0,0,0.8);
    box-sizing: border-box;
    box-shadow: 0 15px 25px rgb(0,0,0,0.5);
    border-radius: 10px;
  }
  .box1 h1{
    margin: 0 0 30px;
    padding: 0px;
    color: #ffffff;
    text-align: center;
  }
  .box1 .inputbox{
    position: relative;
  }
  .box1 .inputbox input{
    width: 100%;
    padding: 10px 0;
    margin-bottom: 30px;
    font-size: 18px;
    border: none;
    color: #ffffff;
    outline: none;
    background: transparent;
    border-bottom: 1px solid #ffffff;
  }
  .box1 .inputbox label{
    position:  absolute;
    top: 0;
    left: 0;
    font-size: 18px;
    color: #ffffff;
    pointer-events: none;
    transition: 0.5s;
  }
  .box1 .inputbox input:focus ~ label,
  .box1 .inputbox input:valid ~ label{
    top: -18px;
    left: 0px;
    font-size: 16px;
    color: #03a9f4;
  }
  .box1 input[type="button"]{
    background: transparent;
    border: none;
    outline: none;
    color: #ffffff;
    background: #03a9f4;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 5px;
  }
</style>