package resource;

import controller.TaskController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Task;

@Path("/task")
public class TaskResource {

    @GET
    @Path("/enviar/{titulo}/{descricao}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarTask(@PathParam("titulo") String titulo,@PathParam("descricao") String descriacao) {
        Task task = new Task();
        task.setTitulo(titulo);
        task.setDescricao(descriacao);
        if (task != null) {
            task.setCriacao(new Date());
            TaskController controller = new TaskController();
            if (controller.salvar(task)) {
                return Response.status(200).build();
            } else {
                return Response.status(500).build();
            }
        }
        return Response.status(400).build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response todasTask() {
        List<Task> tasks = new ArrayList<>();
        TaskController controller = new TaskController();

        tasks = controller.todasTasks();
        return Response.ok().entity(tasks).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/editar/{titulo}/{descricao}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("titulo") String titulo,@PathParam("descricao") String descriacao) {
        Task task = new Task();
        task.setTitulo(titulo);
        task.setDescricao(descriacao);
        if (task != null) {
            task.setEdicao(new Date());
            TaskController controller = new TaskController();
            if(!task.isStatus()){
                task.setConclusao(new Date());
            }
            if (controller.salvar(task)) {
                return Response.status(200).build();
            } else {
                return Response.status(500).build();
            }
        }
        return Response.status(400).build();
    }

    @GET
    @Path("/remover/{titulo}/{descricao}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remover(@PathParam("titulo") String titulo,@PathParam("descricao") String descriacao) {
        Task task = new Task();
        task.setTitulo(titulo);
        task.setDescricao(descriacao);
        TaskController controller = new TaskController();
        task.setRemocao(new Date());
        if (controller.remover(task)) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }
}
