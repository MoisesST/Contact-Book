package model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

  public Contact() {}

  public Contact(String name, String phone) {
    this();
    setName(name);
    setPhone(phone);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}