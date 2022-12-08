<template>
  请输入你想发送的内容<input type="text" ref="input">
  <button @click="submit">发送</button>
  <br/>
  回复: {{record}}
</template>

<script>
export default {
  name: "CustomerService",
  data() {
    return {
      record: ''
    }
  },
  methods: {
    submit() {
      this.record += '\n' + this.$refs.input.value
    }
  }
}
</script>

<style scoped>

</style>