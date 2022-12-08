import {createRouter, createWebHistory} from 'vue-router'
import Login from "@/views/Login";
import Main from "@/views/Main";
import Register from "@/views/Register";
import OrderForm from "@/views/Function/OrderForm";
import Evaluation from "@/views/Function/Evaluation";
import CustomerService from "@/views/Function/CustomerService";
import HotelFirst from "@/components/Hotels/HotelFirst";
import ManagerMain from "@/views/Manager/ManagerMain";

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
        {
            path:'/main/order',
            component: OrderForm
        },
        {
            path:'/main/evaluation',
            component: Evaluation
        },
        {
            path:'/main/customerService',
            component: CustomerService
        },
        {
            path:'/main/HotelFirst',
            component: HotelFirst
        },
        {
            path: '/manager',
            component: ManagerMain
        },



    ]
})

export default router