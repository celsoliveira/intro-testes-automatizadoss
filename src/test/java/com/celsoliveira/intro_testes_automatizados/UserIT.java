package com.celsoliveira.intro_testes_automatizados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// Testes Integrados (IT)
public class UserIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createUser(){
        User user = new User("celsoliveira", "123456");

        User[] users = restTemplate.postForObject("/users", user, User[].class);

        assertNotNull(users);
        assertEquals(1, users.length);
        assertEquals(user, users[0]);

        // Esperando uma exceção ao inserir o mesmo usuario
        assertThrows(RuntimeException.class, () ->
                restTemplate.postForObject("/users", user, User[].class));
    }
}
