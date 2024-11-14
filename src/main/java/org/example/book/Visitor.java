package org.example.book;

public class Visitor {
    Integer id;
    String name;
    String surname;
    String phone;
    Boolean subscribed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Visitor(Integer id, String name, String surname, String phone, Boolean subscribed) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", subscribed=" + subscribed +
                "}\n";
    }
}
