<template>

  <div id="app">
    <el-container class="layout-container-demo" style="height: 100%">

      <el-aside>
        <el-scrollbar>
          <div class="side">
            <el-menu
                active-text-color="#ffd04b"
                background-color="#545c64"
                text-color="#fff"
                router="router"
            >
              <el-menu-item route="/manager" @click="changeBackgroundImage(1)" index="1">
                <el-icon><UserFilled /></el-icon>
                <span class="functions">管理员主页</span>
              </el-menu-item>
              <el-menu-item route="/manager/CheckRecord" @click="changeBackgroundImage(2)" index="2">
                <el-icon><Menu /></el-icon>
                <span class="functions">订房记录</span>
              </el-menu-item>
              <el-menu-item route="/manager/ModifyRoom" @click="changeBackgroundImage(3)" index="3">
                <el-icon><Document /></el-icon>
                <span class="functions">房间信息</span>
              </el-menu-item>
              <el-sub-menu index="4">
                <template #title>
                  <el-icon><DataAnalysis /></el-icon>
                  <span class="functions">酒店数据</span>
                </template>
                <el-menu-item-group>
                  <template #title>查看数据</template>
                  <el-sub-menu index="4-1">
                    <template #title>
                      <span class="functions">统计房间订购量</span>
                    </template>
                    <el-menu-item route="/manager/DataAnalyse/1" @click="showData(1)" index="4-1-1">
                      <span class="functions">按天查看</span>
                    </el-menu-item>
                    <el-menu-item route="/manager/DataAnalyse/2" @click="showData(2)" index="4-1-2">
                      <span class="functions">按房型查看</span>
                    </el-menu-item>

                  </el-sub-menu>
                  <el-menu-item route="/manager/DataAnalyse/3" @click="showData(3)" index="4-2">
                    <span class="functions">房间信息</span>
                  </el-menu-item>
                </el-menu-item-group>
              </el-sub-menu>
            </el-menu>
          </div>

        </el-scrollbar>
      </el-aside>


      <el-container>
        <el-header style="text-align: right">

          <div class="title">
            <span>{{this.title}}</span>
          </div>

          <div class="toolbar">
            <el-icon size="16px" style="margin-right: 1px; margin-top: 1px"><Message/></el-icon>
            <span style="margin-right: 8px; margin-top: 1px" >邮件</span>
            <el-icon size="16px" style="margin-right: 1px; margin-top: 1px"><ChatLineSquare/></el-icon>
            <span style="margin-right: 8px; margin-top: 1px">信息</span>
            <el-icon size="16px" style="margin-right: 1px; margin-top: 1px"><Setting/></el-icon>
            <span style="margin-right: 8px; margin-top: 1px">设置</span>
          </div>
        </el-header>

        <el-main :style="bgStyle">
          <el-scrollbar>
            <router-view ></router-view>
          </el-scrollbar>
        </el-main>
      </el-container>

    </el-container>
  </div>

</template>

<script>

import {ChatLineSquare, DataAnalysis, Document, Menu, Message, Setting, UserFilled} from "@element-plus/icons-vue";

export default {
  name: 'ManagerApp',
  components: {
    UserFilled,
    DataAnalysis,
    Menu,
    Document,
    Message,
    Setting,
    ChatLineSquare,
  },
  data() {
    return {
      title: '管理员主页',
      coverImgUrl:'',// 背景图片的地址
    }
  },

  computed: {
    bgStyle() {
      return {
        backgroundImage: 'url(' + this.coverImgUrl + ')'
      }
    }
  },

  methods: {
    changeBackgroundImage(index){
      switch (index) {
        case 1:
          this.coverImgUrl = require('../../assets/manager/img_2.png')
          break;
        case 2:
          this.coverImgUrl = require('../../assets/manager/img_4.png')
          break;
        case 3:
          this.coverImgUrl = require('../../assets/manager/img_5.png')
          break;
        default:
          this.coverImgUrl = ""
          break;
      }
    },

    showData(index){
      this.changeBackgroundImage()
      switch (index) {
        case 1:

          break;
        case 2:

          break;
        case 3:

          break;
        default:
          break;
      }
    },


  }
}
</script>

<style scoped>

.layout-container-demo .el-header {
  position: relative;
  background-image: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-header {
  position: relative;
  background-image: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: white;
  width: 20%;
  height: 100vh;
  position: -webkit-sticky;
  position: sticky;
  top: 0;
}
.layout-container-demo .el-menu {
  border-right: none;
  height: 100vh;
  position: -webkit-sticky;
  position: sticky;
  top: 0;

}
.layout-container-demo .el-main {
  padding: 0;

  background-repeat:no-repeat ;
  background-size:100% 100%;
  background-attachment: fixed;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
  font-size:16px
}

.layout-container-demo .title {
  float: left;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;

}

.layout-container-demo .title {
  float: left;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}

.functions:hover{
  color: #ffd04b;
}

</style>




