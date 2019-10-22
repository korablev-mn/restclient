package ru.korablev.restclient.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private Long id;
    private String login;
    private String name;
    private String password;
    private Date birthday;
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String login, String name, String password, Date birthday, Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.roles = roles;
    }

    public User(String login, String name, String password, Date birthday, Set<Role> roles) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", roles=" + roles +
                '}';
    }
}