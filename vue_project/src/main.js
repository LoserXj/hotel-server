import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import "./assets/style/global.css";
import router from './router/index'

//createApp.prototype.$axios = axios
createApp(App).use(ElementPlus).use(router).mount('#app')

