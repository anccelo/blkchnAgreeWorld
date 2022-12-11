package com.angelolagreca.agreeworld.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.angelolagreca.agreeworld.common.ConstatsForTest.CIAO;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HashUtilTest {



    @Test
    void should_return_correct_hash_when_imput_is_ciao() {
        String actual = HashUtil.applySha256(CIAO);

        assertEquals(ConstatsForTest.HASH_256_OF_CIAO, actual);
    }

    @Test
    void should_catch_runtimeException_when_is_thorws() {
        Assertions.assertThrows(RuntimeException.class, () -> HashUtil.applySha256(null));

    }
}