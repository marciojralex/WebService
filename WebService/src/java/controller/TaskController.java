package controller;

import dao.TaskDao;
import java.util.Date;
import java.util.List;
import model.Task;

public class TaskController {

    private TaskDao dao = new TaskDao();

    public boolean salvar(Task task) {
        task.setStatus(true);
        return dao.salvarAtualizar(task);
    }

    public List<Task> todasTasks() {
        return dao.todasTasks();
    }

    public boolean remover(Task task) {
        task.setStatus(false);
        task.setRemocao(new Date());
        return dao.remover(task);
    }
}
