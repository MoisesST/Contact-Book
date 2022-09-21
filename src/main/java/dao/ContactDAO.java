package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Contact;

import util.HibernateUtil;

public class ContactDAO {

  public void saveContact(Contact contact) {

    Transaction transaction = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();

      transaction = session.beginTransaction();
      session.save(contact);
      transaction.commit();

    } catch (Exception e) {
      System.out.println(e);
      if (transaction != null) {
        transaction.rollback();
        System.out.println("Abrio a sessão mas falhou");
      }
    }
  }

  public void updateContact(Contact contact) {

    Transaction transaction = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();

      transaction = session.beginTransaction();
      session.saveOrUpdate(contact);
      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
        System.out.println("abriu transaction mas falhou");
      }
    }
  }

  public Contact getContactById(int id) {

    Transaction transaction = null;
    Contact contact = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();

      transaction = session.beginTransaction();

      contact = session.get(Contact.class, id);

      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
        System.out.println("abriu transaction mas falhou");
      }
    }
    return contact;
  }

  public void deleteContact(int id) {

    Transaction transaction = null;
    Contact contact = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();

      transaction = session.beginTransaction();

      contact = session.get(Contact.class, id);
      session.delete(contact);

      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
        System.out.println("abriu transaction mas falhou");
      }
    }
  }
}