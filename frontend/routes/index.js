import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../src/components/Login";
import HelloWorld from "../src/components/HelloWorld";
import Registration from "../src/components/Registration.vue";
import BoardList from "@/components/BoardList";

Vue.use(VueRouter);

export const router = new VueRouter({
  mode: "history",
  routes: [
    { path: "/", component: HelloWorld },
    { path: "/login", component: Login },
    { path: "/registration", component: Registration },
    { path: "/boards", component: BoardList }
  ]
});
