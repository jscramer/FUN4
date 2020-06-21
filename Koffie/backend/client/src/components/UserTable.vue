<template>
    <div id="app">
        <label> Delete user: </label>
        <input type="text" v-model="deleteUserName" @keyup.enter="deleteUser" >
        <label> Add new user: </label>
        <input type="text" v-model="userName" @keyup.enter="addUser" >
        <h1>Current users with a 'good' name</h1>
        <label> Henk is a bad name ;)</label>
        <ul>
            <li v-for="user of users" :key="user.id">
                - {{user.name}}
            </li>
        </ul>
    </div>
</template>

<script>
    import axios from 'axios';
    const baseURL = "http://localhost:8080/"

    export default {
        name: 'app',
        data() {
            return {
                users: [],
                userName: '',
                deleteUserName: ''
            }
        },
        async created() {
            try {
                const res = await axios.get(baseURL+"good-names")

                this.users = res.data;
            } catch(e) {
                console.error(e)
            }
        },
        methods: {
            async addUser() {
                const params = {
                    name: this.userName,
                    surname: "Hello"
                };
                const response = await axios.post(baseURL + "add-name", params, {
                    headers: {
                        'content-type': 'application/json',
                    },
                })
                this.users.push(response.data);
                console.log(response.data);
                this.userName = ''
            },
            async deleteUser(){
                await axios.delete(baseURL+"delete-user/", {params: {name: this.deleteUserName}})
            }
        },
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #6c5ce7;
        margin-top: 60px;
    }

    li {
        list-style: none;
    }

    h1 {
        color: #a29bfe
    }
</style>
