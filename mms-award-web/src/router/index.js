import Vue from 'vue'
import Router from 'vue-router'
import HOME from 'src/components/common/Home'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            children: [
                {
                    path: '/dashboard',
                    component: resolve => require(['../components/page/Dashboard.vue'], resolve),
                    name:'dashboard',
                    meta: {
                        title: '系统首页',
                        menu: 'dashboard'
                    }
                },
                {
                    path: '/prize',
                    component: resolve => require(['../components/page/prize.vue'], resolve),
                    name: 'prize',
                    meta: {
                        title: '奖项列表',
                        menu: 'prize'
                    }
                },
                {
                    path: '/add-prize',
                    component: resolve => require(['../components/page/addPrize.vue'], resolve),
                    name: 'add-prize',
                    meta: {
                        title: '新建奖项',
                        menu: 'add-prize',
                        parent_label:'奖项列表',
                        parent_path:'/prize',
                    }
                }
            ]
        }, {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve)
        }
    ]
})
