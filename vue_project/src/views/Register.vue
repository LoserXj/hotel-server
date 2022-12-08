<template>
  <div class="wrap">
    <form class="sign-in-form">
      <div class="form-title-wrap"><h2 class="form-title">新用户注册</h2></div>
      <label for="username"></label><input type="text" class="text" placeholder="姓名" id="username"/><br/>
      <label for="password"></label><input type="password" class="text" placeholder="密码" id="password"/><br/>
      <label for="verify"></label><input type="password" class="text" placeholder="确认密码" id="verify"><br/>
      <label for="telephone"></label><input type="tel" class="text" placeholder="手机号" id="telephone"><br/>
      <label for="gender"></label>
      Your gender:
      <select id="gender" name="gender" class="select">
        <option>male</option>
        <option>female</option>
      </select> <br/>
      <el-button type="primary" class="submit-btn">注册</el-button>
    </form>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Register"
}
</script>

<style scoped>

</style>