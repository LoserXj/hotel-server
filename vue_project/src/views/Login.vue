<template id="body">
  <div class="wrap">
    <form class="sign-in-form">
      <div class="form-title-wrap"><h2 class="form-title">酒店登录系统</h2></div>
      <label for="username"></label><input type="text" class="text" placeholder="用户名" id="username"/> <br/>
      <label for="password"></label><input type="password" class="text" placeholder="密码" id="password"/> <br/>
      <el-button type="primary" class="submit-btn" @click="onSubmit">登录</el-button> <br/>
      <el-button type="primary" @click="my_register" class="submit-btn">新用户注册</el-button>
    </form>
  </div>

</template>

<script>
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Login",

    data() {
      return {
        form: {
          username: '',
          password: '',
        }
      }
    },

    methods: {
      my_register() {
        this.$router.push('/register')
      },
      onSubmit() {
        this.$router.push('/main')

        /*
        //使用axios发送请求到后端
        this.$axios.post('http://localhost:8081/login', {'username': this.form.username, 'password': this.form.password})
            .then(res => {
              //console.log(res)
              if (res.data.status === 200 && res.data.msg === 'customer')
                //跳转为主页面
                this.$router.push('/main');
              else if (res.data.status === 200 && res.data.msg === 'manager')
                this.$router.push('/manager');
              else {
                this.$message.error(res.data.msg);
              }
            })
         */
      }
    },

  }
</script>
<style scoped>
</style>
