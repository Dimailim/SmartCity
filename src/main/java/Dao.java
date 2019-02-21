import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Dao {
    //remember it
    public  void saveData(CheckingList checkingList){
        Session session = DatabaseHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(checkingList);
        transaction.commit();
        session.close();

    }
    public void updateData(CheckingList checkingList){
        Session session = DatabaseHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(checkingList);
        transaction.commit();
        session.close();
    }
    public  void deleteData(CheckingList checkingList){
        Session session = DatabaseHelper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(checkingList);
        transaction.commit();
        session.close();
    }
    public List<CheckingList> getALL(){
        List<CheckingList> checkingLists = (List<CheckingList>) DatabaseHelper.getSessionFactory().openSession().createQuery("from CheckingList").list();
        return checkingLists;
    }
    public CheckingList getCheckingList(String user){
        Session session = DatabaseHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from CheckingList where user = :user");
        query.setParameter("user",user);
        List list = query.list();
        CheckingList checkingList = (CheckingList) list.iterator().next();
        session.close();
        return checkingList;

    }
}
