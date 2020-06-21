<template>
  <div id="app" class="small-container">
    <h1>Users with a good-name</h1>

    <user-table />
  </div>
</template>

<script>
  import UserTable from './components/UserTable.vue'

  export default {
    name: 'app',
    components: {
      UserTable,
    },
  }
</script>

<style>
  button {
    background: #009435;
    border: 1px solid #009435;
  }

  .small-container {
    max-width: 680px;
  }
</style>