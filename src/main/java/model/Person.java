// package model;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Inheritance;
// import javax.persistence.Id;
// import javax.persistence.Column;
// import javax.persistence.PrePersist;
// import javax.persistence.PreUpdate;
// import javax.persistence.GenerationType;
// import javax.persistence.InheritanceType;

// import java.util.Date;

// import java.io.Serializable;

// @Entity
// @Inheritance(strategy = InheritanceType.JOINED)
// public class Person implements Serializable {

//   @Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
//   @Column(name = "id")
//   private int id;

//   @Column(name = "email")
//   private String email;

//   @Column(name = "password")
//   private String password;

//   @Column(name = "name")
//   private String name;

//   @Column(name = "phone")
//   private String phone;

//   @Column(name = "creation_date")
//   private Date creationDate;

//   @Column(name = "update_date")
//   private Date updateDate;

//   public int getId() {
//     return id;
//   }

//   public void setId(int id) {
//     this.id = id;
//   }

//   public String getEmail() {
//     return email;
//   }

//   public void setEmail(String email) {
//     this.email = email;
//   }

//   public String getPassword() {
//     return password;
//   }

//   public void setPassword(String password) {
//     this.password = password;
//   }

//   public String getName() {
//     return name;
//   }

//   public void setName(String name) {
//     this.name = name;
//   }

//   public String getPhone() {
//     return phone;
//   }

//   public void setPhone(String phone) {
//     this.phone = phone;
//   }

//   @PrePersist
//   protected void onCreate() {
//     this.creationDate = new Date();
//   }

//   @PreUpdate
//   protected void onUpdate() {
//     this.updateDate = new Date();
//   }
// }