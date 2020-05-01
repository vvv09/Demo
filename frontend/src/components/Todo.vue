<template>
    <div>
        <h3>TODO</h3>
        <div class="container">
            <form @submit="validateAndSubmit">
                <div v-if="errors.length">
                    <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{error}}</div>
                </div>
                <fieldset class="form-group">
                    <label>Id</label>
                    <input type="text" class="form-control" v-model="id" disabled>
                </fieldset>
                <fieldset class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" v-model="description">
                </fieldset>
                <button class="btn btn-success" style="margin-right: 10px" type="submit">Save</button>
                <button class="btn btn-info" @click="backToList">Cancel</button>
            </form>
        </div>
    </div>
</template>
<script>
    import Service from "@/service/todo.service";

    export default {
        name: "Todo",
        data() {
            return {
                description: "",
                errors: []
            };
        },
        computed: {
            id() {
                return this.$route.params.id;
            }
        },
        methods: {
            refreshTodoDetails() {
                if (this.id == -1) return
                Service.retrieveTodo(this.id).then(res => {
                    this.description = res.data.description;
                });
            },
            validateAndSubmit(e) {
                e.preventDefault();
                this.errors = [];
                if (!this.description) {
                    this.errors.push("Enter valid values");
                } else if (this.description.length < 5) {
                    this.errors.push("Enter atleast 5 characters in Description");
                }
                if (this.errors.length === 0) {
                    if (this.id == -1) {
                        Service.createTodo({
                            description: this.description
                        })
                            .then(() => {
                                this.$router.push('/todos');
                            });
                    } else {
                        Service.updateTodo(this.id, {
                            id: this.id,
                            description: this.description
                        })
                            .then(() => {
                                this.$router.push('/todos');
                            });
                    }
                }
            },
            backToList() {
                this.$router.push('/todos')
            }
        },
        created() {
            this.refreshTodoDetails();
        }
    };
</script>
