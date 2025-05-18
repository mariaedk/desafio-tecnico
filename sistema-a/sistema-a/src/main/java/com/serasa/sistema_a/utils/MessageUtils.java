package com.serasa.sistema_a.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author maria
 * @date 16/05/2025
 * @description classe utilitária para recuperar mensagens
 */
public class MessageUtils {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("SistemaAResources");

    public static String get(String chave, Object... args) {
        String mensagem = bundle.getString(chave);
        return MessageFormat.format(mensagem, args);
    }
}