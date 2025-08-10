package com.cloudmonstertunisia.banqueapi.account;

import com.cloudmonstertunisia.banqueapi.user.User;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

  public Account toAccount(AccountRequest request) {
    if (request == null) {
      return new Account();
    }
    return Account.builder()
        .user(
            User.builder()
                .id(request.getUserId())
                .build()
        )
        .build();
  }

  public AccountResponse toResponse(Account account) {
    return AccountResponse.builder()
        .id(account.getId())
        .iban(account.getIban())
        .userFirstname(account.getUser().getFirstname())
        .userLastname(account.getUser().getLastname())
        .build();
  }
}
