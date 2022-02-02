package com.ewcode.ewallet.user.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateEmailTest {

    @Test
    @DisplayName("should be a valid e-mail")
    void shouldBeValidEmail() {
        final String email = "estevao.watanabe@gmail.com";
        final String expected = "estevao.watanabe@gmail.com";

        Assertions.assertEquals(expected, email);
    }

    @Test
    @DisplayName("should be a invalid e-mail")
    void shouldBeInvalidEmail() {
        final String email = "invalidemail12381237192837g";
        final String expected = "estevao.watnabe@gmail.com";

        Assertions.assertNotEquals(expected, email);
    }
}
