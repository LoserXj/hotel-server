import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import "./assets/style/global.css";
import router from './router/index'
import axios from "axios";
axios.defaults.baseURL = 'http://www.kymid.com/testphp/public/index.php/api/'

const app = createApp(App)
app.config.globalProperties.$http=axios
app.use(ElementPlus).use(router).mount('#app')

