<template>
  <div class="wrapper">
    <v-head></v-head>
    <v-sidebar></v-sidebar>
    <div class="content-box" :class="{'content-collapse':collapse}">
      <v-tags></v-tags>
      <div class="content">
        <transition name="move" mode="out-in">
            <router-view></router-view>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
  import vHead from './Header';
  import vSidebar from './Sidebar';
  import bus from '../common/bus';
  import vTags from './Tags.vue';

  export default {
    data () {
      return {
        collapse: false
      }
    },
    components:{
      vHead,vSidebar,vTags
    },
    created() {
      bus.$on('collapse', msg => {
        this.collapse = msg;
      })
    }
  }
</script>

<style scoped>

</style>
