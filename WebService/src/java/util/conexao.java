package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class conexao {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal
            = new ThreadLocal<Session>();
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().
                    configure()
                    .buildSessionFactory();

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getInstance() {
        Session session = (Session) threadLocal.get();
        session = sessionFactory.openSession();
        threadLocal.set(session);
        return session;
    }
}
