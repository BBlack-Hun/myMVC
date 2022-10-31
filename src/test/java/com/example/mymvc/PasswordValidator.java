package com.example.mymvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 패스워드는 최소 8자리 이상 12자리 이하여야한다.
 * 비밀번호가 8자 미만, 12자 초과일 경우 IllegalArgumentException 을 발생시켜야 한다.
 * 견계 조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidator {

    public final static String WRONG_PASSWORD_LEGNTH_EXCEPTION_MESSAGE = "비밀번호가 최소 8자 이상 12자 이하여야 합니다.";

    @DisplayName("비밀번호가 최소 8자이상 12자 이하일 경우 오류가 발생하지 않음")
    @Test
    void validatePasswordTest() {
          assertThatCode(() -> PasswordValidator.validate("serverWizard"))
                  .doesNotThrowAnyException ();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과일때 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaa", "aaaaaaaaaaaaa"})
    void validatePasswordTest2(String password) {
        assertThatCode(()-> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호가 최소 8자 이상 12자 이하여야 합니다.");
    }

    private static void validate(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LEGNTH_EXCEPTION_MESSAGE);
        }
    }
}
