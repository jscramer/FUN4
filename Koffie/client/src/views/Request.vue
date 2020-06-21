<template>
    <div class="request">
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title is-size-1">Request a coffee</h1>
                </div>
            </div>
        </div>
        <div class="container">
            <p class="org-description is-size-4">Don't have time to get your own coffee? Request one down below!</p>
            <form class="vue-form" @submit.prevent="processForm">
            <div class="org-description is-size-4">
                <div>
                    <label class="label">Type of coffee</label>
                    <p class="customSelect">
                        <select v-model="coffeeChoice">
                            <option v-for="coffeeType in coffee" :value="coffeeType.id">
                                {{ coffeeType.name }} {{coffeeType.id}}
                            </option>
                        </select>
                    </p>
                </div>
                <div>
                    <label class="label">Location</label>
                    <input type="text" name="userLocation" id="userLocation" required="" v-model="userLocation">
                </div>
            </div>
                <div>
                    <label class="label" for="textarea">Description / Additional information</label>
                    <textarea class="message" name="textarea" id="textarea" required=""
                              v-model="message.text"
                              :maxlength="message.maxlength"></textarea>
                    <span class="counter">{{ message.text.length }} / {{ message.maxlength }}</span>
                </div>
                <div>
                    <input type="submit" class="button" value="Submit">
                </div>
            </form>
        </div>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        name: 'RequestPage',
        data () {
            return {
                coffee: {},
                coffeeChoice: 0,
                userLocation: '',
                message: {
                    text: '',
                    maxlength: 255
                }
            }
        },
        methods:{
            processForm(){
                axios.post('http://localhost:8080/event/add', {
                    "name": this.$auth.user.name,
                    "type": this.coffeeChoice,
                    "place": this.userLocation,
                    "description": this.message.text,
                })

            }
        },
        mounted() {
            axios.get("http://localhost:8080/coffee/active").then(response => {this.coffee = response.data})
        },
    }
</script>
<style lang="scss" scoped>
    .org-description {
        margin-top: 50px;
    }
    body {
        color: #fff;
        background: #949c4e;
        background: linear-gradient(
                        115deg,
                        rgba(86, 216, 228, 1) 10%,
                        rgba(159, 1, 234, 1) 90%
        );
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
        Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial,
        sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
    html,
    body,
    .center {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    a {
        color: #2c3e50;
        text-decoration: none;
    }
    header h1 {
        text-align: center;
        font-size: 2.4rem;
        font-weight: 300;
    }
    h4{
        font-size: 1.4rem;
        font-weight: 300;
    }


    .vue-form {
        font-size: 16px;
        width: 500px;
        padding: 15px 30px;
        border-radius: 4px;
        margin: 50px auto;
        width: 500px;
        background-color: #fff;
        box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.3);
    }
    .vue-form fieldset {
        margin: 24px 0 0 0;
    }
    .vue-form legend {
        padding-bottom: 10px;
        border-bottom: 1px solid #ecf0f1;
    }
    .vue-form div {
        position: relative;
        margin: 20px 0;
    }
    .vue-form h4,
    .vue-form .label {
        color: #94aab0;
        margin-bottom: 10px;
    }
    .vue-form .label {
        display: block;
    }
    .vue-form input,
    .vue-form textarea,
    .vue-form select,
    .vue-form label {
        color: #2b3e51;
    }
    .vue-form input[type="text"],
    .vue-form input[type="email"],
    .vue-form textarea,
    .vue-form select,
    .vue-form legend {
        display: block;
        width: 100%;
        appearance: none;
    }
    .vue-form input[type="text"],
    .vue-form input[type="email"],
    .vue-form textarea,
    .vue-form select {
        padding: 12px;
        border: 1px solid #cfd9db;
        background-color: #ffffff;
        border-radius: 0.25em;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.08);
    }
    .vue-form input[type="text"]:focus,
    .vue-form input[type="email"]:focus,
    .vue-form textarea:focus,
    .vue-form select:focus {
        outline: none;
        border-color: #2c3e50;
        box-shadow: 0 0 5px rgba(44, 151, 222, 0.2);
    }


    .vue-form select {
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.08);

    }
    .vue-form select::-ms-expand {
        display: none;
    }
    .vue-form .vue-form-list {
        margin-top: 16px;
    }
    .vue-form .vue-form-list::after {
        clear: both;
        content: "";
        display: table;
    }
    .vue-form .vue-form-list li {
        display: inline-block;
        position: relative;
        user-select: none;
        margin: 0 26px 16px 0;
        float: left;
    }
    .vue-form input[type="radio"],
    .vue-form input[type="checkbox"] {
        position: absolute;
        left: 0;
        top: 50%;
        transform: translateY(-50%);
        margin: 0;
        padding: 0;
        opacity: 0;
        z-index: 2;
    }
    .vue-form input[type="radio"] + label,
    .vue-form input[type="checkbox"] + label {
        padding-left: 24px;
    }
    .vue-form input[type="radio"] + label::before,
    .vue-form input[type="radio"] + label::after,
    .vue-form input[type="checkbox"] + label::before,
    .vue-form input[type="checkbox"] + label::after {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 50%;
        margin-top: -8px;
        width: 16px;
        height: 16px;
    }
    .vue-form input[type="radio"] + label::before,
    .vue-form input[type="checkbox"] + label::before {
        border: 1px solid #cfd9db;
        background: #ffffff;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.08);
    }
    .vue-form input[type="radio"] + label::before,
    .vue-form input[type="radio"] + label::after {
        border-radius: 50%;
    }
    .vue-form input[type="checkbox"] + label::before,
    .vue-form input[type="checkbox"] + label::after {
        border-radius: 0.25em;
    }
    .vue-form input[type="radio"] + label::after,
    .vue-form input[type="checkbox"] + label::after {
        background-color: #2c3e50;
        background-position: center center;
        background-repeat: no-repeat;
        box-shadow: 0 0 5px rgba(44, 151, 222, 0.4);
        display: none;
    }
    .vue-form input[type="radio"] + label::after {
        background-image: url("data:image/svg+xml;charset=utf-8,%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22utf-8%22%3F%3E%0D%0A%3C%21DOCTYPE%20svg%20PUBLIC%20%22-%2F%2FW3C%2F%2FDTD%20SVG%201.1%2F%2FEN%22%20%22http%3A%2F%2Fwww.w3.org%2FGraphics%2FSVG%2F1.1%2FDTD%2Fsvg11.dtd%22%3E%0D%0A%3Csvg%20version%3D%221.1%22%20id%3D%22Layer_1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20x%3D%220px%22%20y%3D%220px%22%0D%0A%09%20width%3D%2216px%22%20height%3D%2216px%22%20viewBox%3D%220%200%2016%2016%22%20enable-background%3D%22new%200%200%2016%2016%22%20xml%3Aspace%3D%22preserve%22%3E%0D%0A%3Ccircle%20fill%3D%22%23FFFFFF%22%20cx%3D%228%22%20cy%3D%228%22%20r%3D%223%22%2F%3E%0D%0A%3C%2Fsvg%3E");
    }
    .vue-form input[type="checkbox"] + label::after {
        background-image: url("data:image/svg+xml;charset=utf-8,%3C%3Fxml%20version%3D%221.0%22%20encoding%3D%22utf-8%22%3F%3E%0D%0A%3C%21--%20Generator%3A%20Adobe%20Illustrator%2018.1.1%2C%20SVG%20Export%20Plug-In%20.%20SVG%20Version%3A%206.00%20Build%200%29%20%20--%3E%0D%0A%3C%21DOCTYPE%20svg%20PUBLIC%20%22-%2F%2FW3C%2F%2FDTD%20SVG%201.1%2F%2FEN%22%20%22http%3A%2F%2Fwww.w3.org%2FGraphics%2FSVG%2F1.1%2FDTD%2Fsvg11.dtd%22%3E%0D%0A%3Csvg%20version%3D%221.1%22%20id%3D%22Layer_1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20x%3D%220px%22%20y%3D%220px%22%0D%0A%09%20width%3D%2216px%22%20height%3D%2216px%22%20viewBox%3D%220%200%2016%2016%22%20enable-background%3D%22new%200%200%2016%2016%22%20xml%3Aspace%3D%22preserve%22%3E%0D%0A%3Cpolyline%20fill%3D%22none%22%20stroke%3D%22%23FFFFFF%22%20stroke-width%3D%222%22%20stroke-linecap%3D%22square%22%20stroke-miterlimit%3D%2210%22%20points%3D%225%2C8%207%2C10%2011%2C6%20%22%2F%3E%0D%0A%3C%2Fsvg%3E");
    }
    .vue-form input[type="radio"]:focus + label::before,
    .vue-form input[type="checkbox"]:focus + label::before {
        box-shadow: 0 0 5px rgba(44, 151, 222, 0.6);
    }
    .vue-form input[type="radio"]:checked + label::after,
    .vue-form input[type="checkbox"]:checked + label::after {
        display: block;
    }
    .vue-form input[type="radio"]:checked + label::before,
    .vue-form input[type="radio"]:checked + label::after,
    .vue-form input[type="checkbox"]:checked + label::before,
    .vue-form input[type="checkbox"]:checked + label::after {
        animation: cd-bounce 0.3s;
    }
    .vue-form textarea {
        min-height: 120px;
        resize: vertical;
        overflow: auto;
    }
    .vue-form input[type="submit"] {
        border: none;
        background: #2c3e50;
        border-radius: 0.25em;
        padding: 12px 20px;
        color: #ffffff;
        font-weight: bold;
        float: right;
        cursor: pointer;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        appearance: none;
    }
    .no-touch .vue-form input[type="submit"]:hover {
        background: #42a2e1;
    }
    .vue-form input[type="submit"]:focus {
        outline: none;
        background: #2b3e51;
    }
    .vue-form input[type="submit"]:active {
        transform: scale(0.9);
    }
    .vue-form .error-message {
        height: 35px;
        margin: 0px;
    }
    .vue-form .error-message p {
        background: #e94b35;
        color: #ffffff;
        font-size: 1.4rem;
        text-align: center;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        border-radius: 0.25em;
        padding: 16px;
    }
    .vue-form .error {
        border-color: #e94b35 !important;
    }
    .vue-form .counter {
        background-color: #ecf0f1;
        position: absolute;
        right: 0px;
        top: 0px;
        font-size: 10px;
        padding: 4px;
    }
    .customSelect{
        cursor: pointer;
    }
</style>