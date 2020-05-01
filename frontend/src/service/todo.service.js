import axios from 'axios'

const AXIOS = axios.create({
    timeout: 1000
});

const API_URL = '/api/todos'

export default {
    retrieveAllTodos() {
        return axios.get(`${API_URL}`);
    },

    retrieveTodo(id) {
        return axios.get(`${API_URL}/${id}`);
    },

    deleteTodo(id) {
        return axios.delete(`${API_URL}/${id}`);
    },

    updateTodo(id, todo) {
        return axios.put(`${API_URL}/${id}`, todo);
    },

    createTodo(todo) {
        return axios.post(`${API_URL}`, todo);
    }
}
