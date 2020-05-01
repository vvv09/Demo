<template>
    <div class="container">
        <h3>All TODOs</h3>
        <div v-if="message" class="alert alert-success">{{this.message}}</div>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="todo in todos" v-bind:key="todo.id">
                    <td>{{todo.id}}</td>
                    <td>{{todo.description}}</td>
                    <td><button class="btn btn-success" v-on:click="updateTodo(todo.id)">Update</button></td>
                    <td><button class="btn btn-warning" v-on:click="deleteTodo(todo.id)">Delete</button></td>
                </tr>
                </tbody>
            </table>
            <div class="row">
                <button class="btn btn-success" v-on:click="addTodo()">Add</button>
            </div>
        </div>
    </div>
</template>
<script>
    import Service from '@/service/todo.service';
    export default {
        name: "TodoList",
        data() {
            return {
                todos: [],
                message: "",
            }
        },
        methods: {
            refreshTodos() {
                Service.retrieveAllTodos()
                    .then((res) => {
                        this.todos = res.data;
                    });
            },
            addTodo() {
                this.$router.push(`/todo/-1`);
            },
            updateTodo(id) {
                this.$router.push(`/todo/${id}`);
            },
            deleteTodo(id) {
                Service.deleteTodo(id)
                    .then(() => {
                        this.refreshTodos();
                    });
            },
        },
        created() {
            this.refreshTodos();
        }
    }
</script>
