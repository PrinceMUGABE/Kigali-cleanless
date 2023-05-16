package com.example.kigalicleaniliness;

import com.example.kigalicleaniliness.model.UserModel;
import com.example.kigalicleaniliness.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class UserTeste {
    @Autowired
    UserRepository repo;
    public void testSave(){
        UserModel user = new UserModel();
        user.setUsername("admin");
        user.setEmail("princemugabe568@gmail.com");
        user.setPassword("07288");
        UserModel savedUser = repo.save(user);

        Assertions.assertNotNull(savedUser);

    }
}
