import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../src/components/Login";
import HelloWorld from "../src/components/HelloWorld";

Vue.use(VueRouter);

export const router = new VueRouter({
  mode: "history",
  routes: [
    { path: "/", component: HelloWorld },
    { path: "/login", component: Login }
  ]
});
