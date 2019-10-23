package ru.korablev.restclient.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.korablev.restclient.model.Role;
import ru.korablev.restclient.service.RoleService;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RestRoleServiceImpl implements RoleService {

    private String url = "http://localhost:8081/rest/roles";
    RestTemplate restTemplate = new RestTemplate();

    public Role findByRole(String role) {
        return null;
    }

    public List<Role> findAll() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, Role[].class)));
    }
}
