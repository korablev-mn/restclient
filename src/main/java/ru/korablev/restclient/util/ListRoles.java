package ru.korablev.restclient.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ListRoles {

    private static Set<String> listRole;

    public ListRoles() {
        listRole = new HashSet<>();
        listRole.add("user");
        listRole.add("admin");
    }

    public Collection<String> getListRole() {
        return listRole;
    }
}