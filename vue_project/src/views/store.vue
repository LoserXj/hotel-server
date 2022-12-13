<template>
  <div class="goods">
    <div class="banxin">

      <img style="display: block;" src="../assets/img/login-bg.jpg" alt="">
      <list_goods :goodsList="goodsList"></list_goods>
      <div class="loading">
        <i class="iconfont icon-loading" v-show="loading"></i>
        <span>{{ loading ? '正在加载中' : '已经到底啦~' }}</span>
      </div>
    </div>
  </div>
</template>

<script>

import list_goods from "@/components/list/list_goods";
export default {
  name: `store`,
  data() {
    return {
      // 正在加载的状态
      loading: true,
      // 排序的当前项
      num1: -1,
      // 分类的当前项
      num2: -1,
      // 栏目 目前可提供的参数是 1->精品推荐 2-> 热门兑换 0->全部
      did: 0,
      // ( 1->实体商品 2->虚拟商品 0->全部 )
      type: 0,
      // 大于多少积分，最少是0
      min: 0,
      // 少于多少积分，最多是10000，当传入0的时候，会直接返回所有商品，无视后台逻辑。
      max: 0,
      // 商品关键词
      keyword: '',
      // 商品列表数据
      goodsList: [
        {
          name: "杯子",
          coin: 50,
          description: '好看',
          picture: 'beizi.jpg',
        },
        {
          name: "电风扇",
          coin: 80,
          description: '好看',
          picture: 'dianfengshan.jpg',
        },
        {
          name: "加湿器",
          coin: 0,
          description: '好看',
          picture: 'jiashiqi.jpg',
        },
        {
          name: "巧克力",
          coin: 0,
          description: '好看',
          picture: 'qiaokeli.jpg',
        },
        {
          name: "热水袋",
          coin: 0,
          description: '好看',
          picture: 'reshuidai.jpg',
        },
        {
          name: "手套",
          coin: 0,
          description: '好看',
          picture: 'shoutao.jpg',
        },
        {
          name: "拖鞋",
          coin: 0,
          description: '好看',
          picture: 'tuoxie.jpg',
        },
        {
          name: "旅行箱",
          coin: 0,
          description: '好看',
          picture: 'xiangzi.jpg',
        },
        {
          name: "鞋子",
          coin: 0,
          description: '好看',
          picture: 'xie.jpg',
        }
      ]

    }
  },
  components: {
    // Mianbao,
    list_goods
  },
  methods: {
    // 获取商品的数据请求
    options1Click(item,index) {
      this.min = item.min
      this.max = item.max
      this.num1 = index
      // this.getData()
    },
    // options2选项的点击
    options2Click(item,index) {
      this.type = item.type
      this.num2 = index
      // this.getData()
    },

  }
}
</script>

<style scoped>

</style>
