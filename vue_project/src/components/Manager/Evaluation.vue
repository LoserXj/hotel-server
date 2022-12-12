<template>
  <div class="block">
    <span class="demonstration">区分颜色</span>
    <el-rate
        v-model="value2"
        :colors="colors">
    </el-rate>
  </div>
  <el-button type="primary" @click="submit">提交</el-button>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Evaluation",
  data() {
    return {
      value1: null,
      value2: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900']
    }
  },
  methods: {
    submit() {

    }
  }
}
</script>

<style scoped>

</style>