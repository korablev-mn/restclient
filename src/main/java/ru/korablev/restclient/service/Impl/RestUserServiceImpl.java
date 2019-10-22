package ru.korablev.restclient.service.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.korablev.restclient.model.User;
import ru.korablev.restclient.service.UserService;
import java.util.*;

@Service
public class RestUserServiceImpl implements UserService {

    private String url = "http://localhost:8081/rest/users";

    private RestTemplate restTemplate = new RestTemplate();

    public List<User> findAll() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, User[].class)));
    }

    public User findById(Long theId) {

        User user = restTemplate.getForObject(url + "/" + theId, User.class);
        return user;
    }

    public void save(User user) {
        if (user.getId() == null) {
            restTemplate.postForEntity(url, user, ResponseEntity.class);
        } else {
            restTemplate.put(url, user);
        }
    }

    public void deleteById(Long theId) {
        restTemplate.delete(url + "/" + theId);
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }
}