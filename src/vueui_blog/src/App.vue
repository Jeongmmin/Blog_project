<template>
  <div id="app">
    <header-ui></header-ui>
    <main-ui></main-ui>
    <footer-ui></footer-ui>
  </div>
</template>

<script>
import FooterVue from './components/Footer.vue'
import HeaderVue from './components/Header.vue'
import MainVue from './components/Main.vue'

export default {
  components: {
    'header-ui': HeaderVue,
    'main-ui': MainVue,
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
  font-family: sans-serif
}
</style>
