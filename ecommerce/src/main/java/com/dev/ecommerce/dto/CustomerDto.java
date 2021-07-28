package com.dev.ecommerce.dto;

import java.util.Objects;

public class CustomerDto {
    Long id;
    String name;
    String mail;
    String phone;
    //var orders: Set<Orders>?


    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String mail, String phone) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mail, that.mail) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mail, phone);
    }
}
