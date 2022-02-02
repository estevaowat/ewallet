package com.ewcode.ewallet.user.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateEmailTest {

    @Test
    @DisplayName("should be a valid e-mail")
    void shouldBeValidEmail() {
        final String email = "estevao.watanabe@gmail.com";
        final String expected = "validEmail";
        
        Assertions.assertEquals(expected, email);
    }
}
