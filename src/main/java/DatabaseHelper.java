import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DatabaseHelper {

        private static SessionFactory dbSession;
        private  static Session session;
        public static SessionFactory getSessionFactory(){
            if(dbSession == null){
                Configuration conf = new Configuration().configure("/hibernate.cfg.xml");
                conf.addAnnotatedClass(CheckingList.class);
                conf.addAnnotatedClass(History.class);
                conf.addAnnotatedClass(Users.class);


                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
                dbSession = conf.buildSessionFactory(builder.build());
            }
            return dbSession;
        }
        public String checkUser(String user){

            if(dbSession == null){
                dbSession = getSessionFactory();
            }
            session = dbSession.openSession();
            try{
                Query query = session.createQuery("from CheckingList where user = :user");
                query.setParameter("user",user);
                List users = query.list();
                if(users.size() == 0){
                    return "no data";
                }
                // заменить
                //return "success";
                CheckingList checkingList = (CheckingList) users.iterator().next();
                return checkingList.getPassword();
            }catch (HibernateException ex){
                ex.printStackTrace();
            }finally{
                session.close();
            }
            return "not connection";
        }

        public String insertUser(String user, String password, String comments, String CL){
            if(dbSession == null) {
                dbSession = getSessionFactory();
            }
            Session session = dbSession.openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                CheckingList checkingList = new CheckingList();
                checkingList.setUser(user);
                checkingList.setPassword(password);
                checkingList.setComment(comments);
                checkingList.setCheckinglistfile(CL);
                session.save(checkingList); // сохранение и коммит  важно!
                transaction.commit();

            }catch (HibernateException ex){
                if(transaction != null)
                    transaction.rollback();
                ex.printStackTrace();
                return  "Ошибка транзакции";

            } finally {
                session.close();
            }
            return "Success";

        }

    public String checkLogUser(String login){

        if(dbSession == null){
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        try{
            Query  query = session.createQuery("from Users where login = :log");
            query.setParameter("log",login);
            List users = query.list();
            if(users.size() == 0){
                return "no data";
            }
            // заменить
            //return "success";
            Users user = (Users) users.iterator().next();
            return user.getPassword();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return "not connection";
    }

    public String insertLogUser(String login, String password, boolean isAdmin){
        if(dbSession == null) {
            dbSession = getSessionFactory();
        }
        Session session = dbSession.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Users user = new Users();
            user.setLogin(login);
            user.setPassword(password);
            user.setAdmin(isAdmin);
            session.save(user); // сохранение и коммит  важно!
            transaction.commit();

        }catch (HibernateException ex){
            if(transaction != null)
                transaction.rollback();
            ex.printStackTrace();
            return  "Ошибка транзакции";

        } finally {
            session.close();
        }
        return "Success";

    }
    public String checkCLUser(String user){

        if(dbSession == null){
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        try{
            Query query = session.createQuery("from CheckingList where user = :user ");
            query.setParameter("user",user);
            List users = query.list();
            if(users.size() == 0){
                return "no data";
            }
            // заменить
            //return "success";
            CheckingList checkingList = (CheckingList) users.iterator().next();
            return checkingList.getUser();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return "not connection";
    }
    public String checkComment(String user){

        if(dbSession == null){
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        try{
            Query query = session.createQuery("from CheckingList where user = :user");
            query.setParameter("user",user);
            List users = query.list();
            if(users.size() == 0){
                return "no data";
            }
            // заменить
            //return "success";
            CheckingList checkingList = (CheckingList) users.iterator().next();
            return checkingList.getComment();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return "not connection";
    }
    public String checkCL(String user){

        if(dbSession == null){
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        try{
            Query query = session.createQuery("from CheckingList where user = :user");
            query.setParameter("user",user);
            List users = query.list();
            if(users.size() == 0){
                return "no data";
            }
            // заменить
            //return "success";
            CheckingList checkingList = (CheckingList) users.iterator().next();
            return checkingList.getCheckinglistfile();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return "not connection";
    }
    }

