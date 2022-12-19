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
                <button @click="editCreatoFalse()">CANCEL</button>
            </form>
        </div>
        <!-- List of pizzas -->
        
        <div
            v-for="pizza in pizze"
            :key="pizza.id"
        >
            <div v-if="pizze_edit_id != pizza.id">
            
                {{ pizza.nome }}
                <br>
                <div
                    v-if="!pizza.ingredienti"
                >
                    <button @click="getIngredienti(pizza.id)">GET INGREDIENTI</button>
                </div>
                 <div
                    v-else
                >
                    <ul
                    v-if="pizza.ingredienti.length > 0"
                    >
                    <li
                        v-for="ingrediente in pizza.ingredienti"
                        :key="ingrediente.id"
                    >
                        {{ ingrediente.nome }}
                    </li>
                    </ul>
                </div>
                <br>
                <button @click="editPizza(pizza.id)">EDIT</button>
                <button @click="deletePizza(pizza.id)">DELETE</button>
            </div>
            <div v-else>
                <form @submit="updatePizza">
                <label for="nome">nome</label><br>
                <input type="text" name="nome" v-model="pizza.nome">
                <br>
                <label for="descrizione"> Descizione</label> <br>
                <input type="text" name="descrizione" v-model="pizza.descrizione">
                <br>
                <label for="prezzo"> Prezzo</label> <br>
                <input type="number" name="prezzo" v-model="pizza.prezzo">

                <input type="submit" value="UPDATE">
                <button @click="editPizzaFalse()">CANCEL</button>
            </form>
            </div>
        </div>
        
        


  </div>
</template>

<script>

import axios from 'axios';
const API_URL = "http://localhost:8080/api/1";
const PIZZE_EDIT_ID_DEFAULT = -1;

export default {
    name: 'PizzaComponent',

    data() {

        return {
            pizze_edit_id: PIZZE_EDIT_ID_DEFAULT,
            pizze: [],
            pizzaCreateFrom: false,
            pizza_create: { },
        };
    },

    methods: {
        // Return to default
        editCreatoFalse(){
            this.pizzaCreateFrom = false;
        },
        editPizzaFalse(){
            this.pizze_edit_id = this.PIZZE_EDIT_ID_DEFAULT;
        },

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
            axios.get(API_URL + '/pizza/delete/' + id)
            .then(res => {
        
            const deletd = res.data;

            if (!deletd) return;

            const index = this.getPizzaIndexById(id);
            this.pizze.splice(index, 1);
            });
        },

        editPizza(id) {

            this.pizze_edit_id=id;
        },
        createPizza(e){
            e.preventDefault();

            axios.post(API_URL + '/pizza/create', this.pizza_create)
            .then(res => {
        
            const pizza = res.data;

            if (!pizza) return;

            this.pizze.push(pizza);
            });
        },
        getPizzaById(id) {
            return this.pizze[this.getPizzaIndexById(id)];
        },
        updatePizza(e){
            e.preventDefault();

            const id = this.pizze_edit_id;
            const pizza = this.getPizzaById(id);

            this.editPizza(PIZZE_EDIT_ID_DEFAULT);

            axios.post(API_URL + '/pizza/update/' + id, pizza)
            .then(res => {

                const index = this.getPizzaIndexById(id);
                const pizza = res.data;
                this.pizze[index] = pizza;
           });
        },
        
        getIngredienti(id) {
            axios.get(API_URL + '/ingredienti/by/pizza/' + id)
                .then(res => {
            
                    const ingredienti = res.data;
                    
                    if (ingredienti == null) return;
                    const index = this.getPizzaIndexById(id);
                    this.pizze[index].ingredienti = ingredienti;
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