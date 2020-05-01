import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
  mode: 'history', // Use browser history
  routes: [
    {
      path: "/",
      name: "Main",
      component: () => import("../components/TodoList"),
    },
    {
      path: "/todos",
      name: "Todos",
      component: () => import("../components/TodoList"),
    },
    {
      path: "/todo/:id",
      name: "Todo",
      component: () => import("../components/Todo"),
    },
  ]
});

export default router;