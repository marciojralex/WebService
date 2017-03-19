package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Task;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import util.conexao;

public class TaskDao {

    private Session session;

    public boolean salvarAtualizar(Task task) {
        boolean retorno = false;
        session = conexao.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(task);
            tx.commit();
            retorno = true;
        } catch (Exception e) {
            e.printStackTrace();

            tx.rollback();
        } finally {
            session.close();
        }
        
        return retorno;
    }

    public List<Task> todasTasks() {
        session = conexao.getInstance();
        Query query = session.createSQLQuery(" SELECT * FROM tasklist.task");
        List<Task> tasks = query.setResultTransformer(Transformers.aliasToBean(Task.class)).list();
        session.close();
        return tasks;
    }

    public boolean remover(Task task) {
        session = conexao.getInstance();
        Transaction tx = null;
        boolean retorno = false;
        
        try {
            tx = session.beginTransaction();
            session.delete(task);
            tx.commit();
            retorno = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            session.close();
        }
        
        return retorno;
    }

}
