<template>
  <div id="app">
    <HeaderNav></HeaderNav>
    <nav>
      <router-link to="/">홈</router-link> |
      <router-link to="/route">산책로</router-link> |
      <router-link to="/spot">경유지</router-link>
    </nav>
    <hr />

    <router-view />
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";
export default {
  components: {
    HeaderNav,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
