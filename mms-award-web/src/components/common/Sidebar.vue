<template>
  <div class="sidebar">
    <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
             text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template slot="title">
              <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
            </template>
            <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">
              {{ subItem.title }}
            </el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  import bus from '../common/bus';

  export default {
    data() {
      return {
        collapse: false,
        items: [
          {
            icon: 'el-icon-news',
            index: 'dashboard',
            title: '系统首页'
          },
          {
            icon: 'el-icon-tickets',
            index: 'prize',
            title: '奖项列表'
          }
        ]
      }
    },
    computed:{
      onRoutes(){
        return this.$route.meta.menu;
      }
    },
    created(){
      bus.$on('collapse', msg => {
        this.collapse = msg;
      })
    }
  }
</script>
<style scoped>
  .sidebar{
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom:0;
  }
  .sidebar-el-menu:not(.el-menu--collapse){
    width: 200px;
  }
  .sidebar > ul {
    height:100%;
  }
</style>
