package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.GenerationType;

@Entity
@Table(name = "contacts")
public class Contact implements BaseEntity {

  public Contact() {}

  public Contact(String name, String phone, String email) {
    this();
    setName(name);
    setPhone(phone);
    setEmail(email);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

  @Column(name = "email")
  private String email;

  @Column(name = "creation_date")
  private Date creationDate;

  @Column(name = "update_date")
  private Date updateDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @PrePersist
  protected void onCreate() {
    this.creationDate = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updateDate = new Date();
  }
}