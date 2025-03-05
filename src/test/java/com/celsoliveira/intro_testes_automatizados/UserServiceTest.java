package com.celsoliveira.intro_testes_automatizados;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;


public class UserServiceTest {

   private UserService userService = new UserService();

    @Test
    public void createUser_ReturnUsers(){
        // AAA:

        // Arrange (montar os dados)
        User user = new User("celsoliveira", "123456");

        //Act (Agir, exercitar os códigos que serão testados)
        List<User> users = userService.create(user);

        //Assert (avaliar os resultados esperados)
        assertEquals(1, users.size());
        assertEquals(user,users.get(0));
    }

    @Test
    public void createUser_ThrowsException(){
        User user = new User("celsoliveira", "123456");

        // cria o mesmo usuario 2 vezes
        userService.create(user);

        assertThrows(RuntimeException.class, () ->
                userService.create(user));
    }
};
