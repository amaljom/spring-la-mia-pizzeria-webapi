<template>
  <div>
        <h1>ciao</h1>
        <!-- pizza create form -->
        <div v-if="!pizzaCreateFrom">
            <button @click="pizzaCreateFrom = true">CREATE NEW PIZZA</button>
        </div>
        <div v-else>
            <form @submit="createPizza">
                <label for="nome">nome</label><br>
                <input type="text" name="nome" v-model="pizza_create.nome">
                <br>
                <label for="descrizione"> Descizione</label> <br>
                <input type="text" name="descrizione" v-model="pizza_create.descrizione">
                <br>
                <label for="prezzo"> Prezzo</label> <br>
                <input type="number" name="prezzo" v-model="pizza_create.prezzo">
                <input type="submit" value="CREATE">
            </form>
        </div>
        <!-- List of pizzas -->
        <ul>
            <li
                v-for="pizza in pizze"
                :key="pizza.id"
            >
            {{ pizza.nome }}
            <button @click="editPizza(pizza.id)">EDIT</button>

            <button @click="deletePizza(pizza.id)">DELETE</button>
            </li>
            
        </ul>


  </div>
</template>

<script>

import axios from 'axios';
const API_URL = "http://localhost:8080/api/1";

export default {
    name: 'PizzaComponent',

    data() {

        return {
            pizze: [],
            pizzaCreateFrom: false,
            pizza_create: { },
        };
    },

    methods: {
        getPizzaIndexById(id) {
            for (let x=0;x<this.pizze.length;x++) {
                const pizza = this.pizze[x];
                if (pizza.id == id)
                return x;
            }
            return -1;
        },
        deletePizza(id){
            
            console.log(id);
            axios.get(API_URL + '/pizza/delete'/ + id)
            .then(res => {
        
            const deletd = res.data;

            if (!deletd) return;

            const index = this.getPizzaIndexById(id);
            this.pizze.splice(index, 1);
            });
        },
        
        createPizza(e){
            e.preventDefault();

            axios.post(API_URL + '/pizza/create', this.pizza_create)
            .then(res => {
        
            const pizza = res.data;

            if (!pizza) return;

            this.pizze.push(pizza);
            });
        }
    },

    mounted() {
        axios.get(API_URL + '/pizza/all')
         .then(res => {
     
        const pizze = res.data;
        if (pizze == null) return;
        this.pizze = pizze;
        });
    }
}
</script>

<style>

</style>