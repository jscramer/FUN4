<template>
    <div class="events container">
        <h2 class="subtitle is-3">
            Coffee listings
        </h2>
        <div class="columns is-multiline">
            <div v-for="eventListed in events" :event="eventListed" :key="eventListed.id" class="column is-one-quarter">
                <router-link :to="'/event/' + eventListed.id">
                    <EventCard :event="eventListed" />
                </router-link>
            </div>
        </div>
    </div>
</template>
<script>
    import EventCard from '@/components/EventCard';
    import axios from "axios";
    export default {
        name: 'EventsList',
        components : {
            EventCard
        },
        mounted() {
         axios.get("http://localhost:8080/event/active").then(response => {this.events = response.data});

        },
        data () {
            return {
                event: {},
                events: null,
                componentKey: 0,
            }
        },

    }
</script>
<style lang="scss" scoped>
    .events {
        margin-top: 100px;
        text-align: center;
    }
</style>