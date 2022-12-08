<template>
  <div>
  <header_a></header_a>
</div>

  <div id="body">
    <div id="app">
      <router-view/>
    </div>
  </div>
</template>

<script>
import header_a from "@/components/page/header_a";

export default {
  name: 'App',
  components: {header_a}
}
</script>

<style>
#app {
  height: 800px;
  background-image: url("@/assets/images/background.jpg");
  background-size: 100% 100%;
}
</style>
