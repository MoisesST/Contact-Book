package dao;

import java.util.List;

import org.hibernate.*;

import util.HibernateUtil;
import model.User;

public class UserDAO {

  public List<User> listAllUsers() {
    GenericDAO<User> dao = new GenericDAO<User>();
    List<User> users = dao.listAll(new User());
    return users;
  }

  public User getUserById(int id) {
    Transaction transaction = null;
    User user = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      user = session.get(User.class, id);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
        System.out.println("abriu transaction mas falhou");
      }
    }
    return user;
  }

  public void createUser(User user) {
    GenericDAO<User> dao = new GenericDAO<User>();
    dao.save(user);
  }
}