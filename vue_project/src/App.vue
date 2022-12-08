<template>
  <div id="body">
    <div id="app">
      <router-view/>
    </div>
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
  #app{
    height: 800px;
    /*background-image: url("@/assets/images/login.jpg");*/
    background-size: 100% 100%;
  }
</style>