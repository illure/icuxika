<template>
    <div class="login">
        <router-link to="/register">注册</router-link>
        <router-link to="/retrievePassword">找回密码</router-link>
        <button type="button" @click="login">Sign in</button>
        <div>
            {{responseValue}}
        </div>
    </div>
</template>

<script>
import '../../plugins/bootstrap'
export default {
  name: 'Login',
  data: function () {
    return {
      responseValue: ''
    }
  },
  methods: {
    login () {
      let thisAttribute = this
      this.$axios({
        url: '/test/test',
        method: 'post',
        baseURL: 'http://localhost:8888',
        data: {
          age: 18,
          name: 'illure'
        }
      }).then(function (response) {
        thisAttribute.responseValue += JSON.stringify(response.data)
        console.log('=================')
        console.log(response.data)
        console.log('=================')
        console.log(response.status)
        console.log('=================')
        console.log(response.statusText)
        console.log('=================')
        console.log(response.headers)
        console.log('=================')
        console.log(response.config)
        console.log('=================')
        console.log(response.request)
      }).catch(function (error) {
        alert(error)
      })
    }
  }
}
</script>

<style scoped>

</style>
