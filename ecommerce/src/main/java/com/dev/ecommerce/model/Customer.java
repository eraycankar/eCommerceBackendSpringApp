package com.dev.ecommerce.model;
import javax.persistence.*;


@Entity
public class Customer {
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String mail;
    private String phone;

   /*@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
    var orders: Set<Orders>?*/

    public Customer() {}

    public Customer(Long id, String name, String mail, String phone) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
