<template>
  <div id="app">
    <header-ui></header-ui>
    <router-view></router-view>
    <footer-ui></footer-ui>
  </div>
</template>

<script>
import FooterVue from './components/Footer.vue'
import HeaderVue from './components/Header.vue'

export default {
  components: {
    'header-ui': HeaderVue,
    'footer-ui': FooterVue
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: rgb(232, 234, 235);
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
* {
  font-family: 'IBM Plex Sans KR', sans-serif;
}
</style>
