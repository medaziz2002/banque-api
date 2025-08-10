package com.cloudmonstertunisia.banqueapi.account;

import com.cloudmonstertunisia.banqueapi.user.User;
import com.cloudmonstertunisia.banqueapi.user.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceSpringTest {

    // @Autowired
    private AccountService service;
    // @Autowired
    private UserRepository userRepository;

    // @Test
    public void should_create_account() {
        var savedUser = userRepository.save(User.builder().firstname("Ali").build());
        var request = AccountRequest.builder()
                .userId(savedUser.getId())
                .build();

        var id = service.create(request);

        assertEquals(1, id);
    }
}

