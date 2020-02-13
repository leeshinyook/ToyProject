<template>
  <div id="app">
    <b-nav>
      <b-nav-item href="/">Main</b-nav-item>
      <b-nav-item href="/registration">Registration</b-nav-item>
      <b-nav-item href="/login">Login</b-nav-item>
      <b-nav-item href="/boards">Boards</b-nav-item>
    </b-nav>
    <!-- <p><router-link to="/">메인</router-link></p>
    <p><router-link to="/registration">회원가입</router-link></p>
    <p><router-link to="/login">로그인</router-link></p> -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
#app {
  text-align: center;
}
</style>
