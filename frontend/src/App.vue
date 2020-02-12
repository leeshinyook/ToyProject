<template>
  <div id="app">
    
    <p><router-link to="/">main</router-link></p>
    <p><router-link to="/login">login</router-link></p>
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
