<template>
    <div class="event-single">
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        {{ event.name }}
                    </h1>
                    <h2 class="subtitle ">
                        <strong>Coffee type wanted</strong>
                        <br> {{coffee.name }}
                    </h2>
                </div>
            </div>
        </section>
        <section class="event-content">
            <div class="container">
                <br>
                <p class="is-size-4 description">{{ event.description }}</p>
                <br>
                <div v-if="event.active == 1" class="button-block">
                    <button @click="buyCoffee" class="button is-xl is-dark">Get this coffee! </button>
                </div>
                <div v-if="event.active == 0" class="button-block">
                    <p class="button is-xl is-dark">Coffee request has been bought </p>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        name: 'EventSingle',

        data () {
            return {
                events: null,
                event: {},
                coffee: null,
                coffeeId: null,


            }
        },
        mounted()
        {
            const ID = Number(this.$route.params.id);
            axios.get("http://localhost:8080/event/"+ID).then(response => {
                this.event = response.data;
                axios.get("http://localhost:8080/coffee/"+this.event.type).then(response => {
                    this.coffee = response.data});
              });
        },
        methods: {
            buyCoffee(){
                const ID = Number(this.$route.params.id);
                axios.put("http://localhost:8080/event/bought/"+ID);
                this.$router.go('/');
            }
        }

    }
</script>