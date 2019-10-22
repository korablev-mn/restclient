package ru.korablev.restclient.service.Impl;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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

//    HttpClient httpClient = HttpClientBuilder.create().build();
////    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//RestTemplate restTemplate = new RestTemplate(requestFactory);

    public Role findByRole(String role) {
        return null;
    }

    public List<Role> findAll() {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, Role[].class)));

//        ResponseEntity<List<Role>> responce = null;
//            responce = restTemplate.exchange(
//                    url,
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<Role>>() {
//                    });
//        return responce.getBody();
    }
}
