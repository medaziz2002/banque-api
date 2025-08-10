package com.cloudmonstertunisia.banqueapi.account;

import com.cloudmonstertunisia.banqueapi.exception.ObjectValidationException;
import com.cloudmonstertunisia.banqueapi.validator.ObjectsValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRequestValidatorTest {

    private final ObjectsValidator<AccountRequest> validator = new ObjectsValidator<>();

    @Test
    public void should_return_error_msg() {
        var exp = assertThrows(ObjectValidationException.class, () -> validator.validate(AccountRequest.builder().build()));
        assertEquals(1, exp.getViolations().size());
        assertTrue(exp.getViolations().contains("User should not be null"));
        assertEquals("AccountRequest", exp.getViolationSource());
    }

    @Test
    public void should_not_throw_exp() {
        assertDoesNotThrow(() -> validator.validate(AccountRequest.builder().userId(1).build()));
    }

}
