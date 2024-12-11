package com.igor.bondezam.testereceive.testereceive.config.service;

import com.igor.bondezam.testereceive.testereceive.config.domain.UserReceiver;
import com.igor.bondezam.testereceive.testereceive.config.domain.dto.UsuarioRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserReceiverService {

    @Value("${project-glue.host}")
    private String glueHost;

    @Autowired
    private RestTemplate restTemplate;

    public UserReceiver getReceiver(Long userId) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", userId.toString());
        UsuarioRes usuarioRes = restTemplate.getForObject(glueHost + "/usuario/{id}", UsuarioRes.class, uriVariables);
        return new UserReceiver(usuarioRes.getEmail(), usuarioRes.getWeight());
    }
}
