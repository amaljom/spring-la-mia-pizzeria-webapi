<template>
  <PizzaComponent />
</template>

<script>
import PizzaComponent from './components/PizzaComponent.vue'

export default {
  name: 'App',
  components: {
    PizzaComponent
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
  margin-top: 60px;
}
</style>
