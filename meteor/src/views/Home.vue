<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <div>
      <router-link to="/home">Home</router-link> |
      <router-link to="/about">About</router-link>
      <p>
        If Element is successfully added to this project, you'll see an
        <code v-text="'<el-button>'"></code>
        below
      </p>
      <el-button>el-button</el-button>
    </div>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import '../plugins/element'
// @ is an alias to /src
import HelloWorld from '../components/HelloWorld.vue'

export default {
  name: 'home',
  components: {
    HelloWorld
  }
}
</script>

<style lang="stylus">
  .home
    padding 30px
    a
      font-weight bold
      color #2c3e50
      &.router-link-exact-active
        color #42b983
</style>
