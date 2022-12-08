import {createRouter, createWebHistory} from 'vue-router'
import Login from "@/views/Login";
import Main from "@/views/Main";
import Register from "@/views/Register";

const router = createRouter({
    history: createWebHistory(),
    routes:[
        {
            path:'/',
            component: Login
        },
        {
            path:'/main',
            component: Main
        },
        {
            path:'/register',
            component: Register
        },
    ]
})

export default router
