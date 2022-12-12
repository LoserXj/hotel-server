<template>
  <div id="app">
    <ManagerApp>

    </ManagerApp>
  </div>
</template>

<script>

import ManagerApp from "@/components/Manager/ManagerApp";
export default {
  name: 'App',
  components: {ManagerApp},
}
</script>

<style>
#app {
  height: 800px;

  background-size: 100% 100%;
}
</style>
