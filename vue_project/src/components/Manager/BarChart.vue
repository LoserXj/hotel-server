<template>

  <div>
    <div id="baseEcharts2" style="width: 100%; height: 360px;"></div>
  </div>
</template>


<script>

export default {
  data() {
    return {
      // 需要合并的数据
      options: {
        title: {
          text: "用户来源"
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#E9EEF3"
            }
          }
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        xAxis: [
          {
            boundaryGap: false
          }
        ],
        yAxis: [
          {
            type: "value"
          }
        ]
      }
    };
  },

  created() {
    this.drawEcharts();
  },

  mounted() {
    this.drawEcharts();
  },

  methods: {
    drawEcharts() {
      if (!document.getElementById('baseEcharts2')) return
      let myChart = this.$echarts.init(document.getElementById('baseEcharts2'))
      let options = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
        },
        yAxis: {
          type: 'value',
        },
        series: [
          {
            data: [150, 230, 224, 218, 135, 147, 260],
            type: 'bar',
          },
        ],
      }
      myChart.setOption(options)
    }
  }
};
</script>

<style scoped>

</style>
