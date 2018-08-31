<template>
  <div class="about">
    <img alt="Vue logo" src="../assets/logo.png">
    <div>
      <router-link to="/home">Home</router-link> |
      <router-link to="/about">About</router-link>
      <p>
        If Element is successfully added to this project, you'll see an
        <code v-text="'<el-button>'"></code>
        below
      </p>
      <el-button @click="secretTest">el-button</el-button>
    </div>
    <h1>This is an about page</h1>
  </div>
</template>

<script>
import '../plugins/element'
import secret from '../utils/secret'
export default {
  name: 'about',
  methods: {
    secretTest () {
      console.log('前端AES加密数据：' + secret.AESEncrypt('前端AES加密数据'))
      console.log('前端私钥加密数据：' + secret.RSAEncryptByPrivateKey('前端私钥加密数据'))
      console.log('前端公钥加密数据：' + secret.RSAEncryptByPublicKey('前端公钥加密数据'))
      console.log('前端AES解密后端AES加密数据：' + secret.AESDecrypt('OpaFCVpQqrPW00a8rGnMoIzQE0p8o9ICpt08bzT6oEY='))
      console.log('前端私钥解密后端RSA公钥加密数据：' + secret.RSADecryptByPrivateKey('bKGnee3BeBNa6IsZpylbX7Pqo6N/ZBeseUsy3s+4YB7c16kVqxLi10so0HXyPUyKE8499mHBbh6hDWoEc2AfvZk9QxoysZxV06OaYG9gZcplFApiK+S7ZEcju6F+fBOBYGnTBZxaAgcCVBb3zbUFjeZGolYnLCv7lfauj3OEnyg='))
      console.log('前端公钥解密后端RSA私钥加密数据：' + secret.RSADecryptByPublicKey('h807avqYv/ilG/yH/+bolEQVZ0QYQSEVEHWt2Oh+Fe5kL5B2jIvuub0/CgAI2DcoqxSY7T8OrUWB0nH3Urz0ibl3sVfperRKoEquzApUcKFyVeqtb+0/La+ifJp729QnqBpo0QxHUFXdAtNE1roRnSXolTn8YijPgeBq0bHCHgU='))
    }
  }
}
</script>

<style lang="stylus">
  .about
    padding 30px
    a
      font-weight bold
      color #2c3e50
      &.router-link-exact-active
        color #42b983
</style>
