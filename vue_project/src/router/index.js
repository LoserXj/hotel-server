import {createRouter, createWebHistory} from 'vue-router'
import Login from "@/views/Login";
import Main from "@/views/Main";
import Register from "@/views/Register";
import OrderForm from "@/views/Function/OrderForm";
import Evaluation from "@/views/Function/Evaluation";
import CustomerService from "@/views/Function/CustomerService";
import HotelFirst from "@/components/Hotels/HotelFirst";
import ManagerSystem from "@/components/Manager/ManagerSystem";
import CheckRecord from "@/components/Manager/CheckRecord";
import ModifyRoom from "@/components/Manager/ModifyRoom";
import BarChart from "@/components/Manager/BarChart";
import evaluationPage from "@/components/Hotels/evaluationPage";
import store from "@/views/store";

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
            component: ManagerSystem
        },
        {
            path: '/manager/DataAnalyse/1',
            component: BarChart
        },{
            path: '/manager/DataAnalyse/2',
            component: BarChart
        },{
            path: '/manager/DataAnalyse/3',
            component: BarChart
        },
        {
            path: '/manager/ModifyRoom',
            component: ModifyRoom
        },
        {
            path: '/manager/CheckRecord',
            component: CheckRecord
        },
        {
            path: '/main/store',
            component: store
        },

        {
            path: '/main/evaluation',
            component: evaluationPage
        },


    ]
})

export default router
