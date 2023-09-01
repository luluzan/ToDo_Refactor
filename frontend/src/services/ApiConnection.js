import http from '../httpCommon.js';

class ApiConnection {
    getAllTasks() {
        return http.get();
    }

    getTaskById(id) {
        return http.get(`/${id}`);
    }

    addTask(task) {
        return http.post('', task);
    }
   
    updateTask(id, task) {
        return http.put(`${id}`, task);
    }

    deleteTaskById(id) {
        return http.delete(`${id}`);
    }
}

export default new ApiConnection();