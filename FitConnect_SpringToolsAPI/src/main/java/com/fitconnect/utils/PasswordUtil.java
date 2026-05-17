package com.fitconnect.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public static String criptografar(String senha) {
        return encoder.encode(senha);
    }

    public static boolean verificar(
            String senhaDigitada,
            String senhaCriptografada
    ) {
        return encoder.matches(
                senhaDigitada,
                senhaCriptografada
        );
    }
}