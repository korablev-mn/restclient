package ru.korablev.restclient.service;


import ru.korablev.restclient.model.Role;

import java.util.List;


public interface RoleService {

    public Role findByRole(String role);

    public List<Role> findAll();
}
