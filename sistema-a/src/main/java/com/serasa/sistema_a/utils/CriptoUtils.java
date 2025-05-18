package com.serasa.sistema_a.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author maria
 * @date 17/05/2025
 * @description utilitário simples para simular criptografia de dados sensíveis
 */
public class CriptoUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String criptografar(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }

    public static String descriptografar(String criptografado) {
        return new String(Base64.getDecoder().decode(criptografado), StandardCharsets.UTF_8);
    }

    public static boolean verificar(String senhaDigitada, String senhaCriptografada) {
        return encoder.matches(senhaDigitada, senhaCriptografada);
    }
}

