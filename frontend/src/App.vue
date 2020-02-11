<template>
  <div id="app">
    <router-link to="/">main</router-link>
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
