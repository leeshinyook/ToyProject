<template>
  <div id="app">
    <p><router-link to="/">메인</router-link></p>
    <p><router-link to="/registration">회원가입</router-link></p>
    <p><router-link to="/login">로그인</router-link></p>
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
