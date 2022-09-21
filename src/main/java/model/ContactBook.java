package model;

import dao.ContactDAO;

public class ContactBook {

  private ContactDAO dao;

  public ContactBook() {
    dao = new ContactDAO();
  }

  public Contact adicionaContact(Contact contact) {
    dao.saveContact(contact);
    return contact;
  }

  public void editaContact(Contact contact) {
    dao.updateContact(contact);
  }

  public Contact obterContactPeloId(Integer id) {
    return dao.getContactById(id);
  }

  // public ArrayList<Contact> listaDeTodosOsContacts() {
  // return contacts;
  // }

  public void excluirContact(Integer id) {
    dao.deleteContact(id);
  }
}