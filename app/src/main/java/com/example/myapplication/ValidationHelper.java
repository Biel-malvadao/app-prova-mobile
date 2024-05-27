package com.example.myapplication;

public class ValidationHelper {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidZipCode(String zipCode) {
        return zipCode != null && zipCode.matches("\\d{5}-\\d{3}");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }

    // Exemplo de validação para campos gerais (nome, cidade, etc.)
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z\\s]+$");
    }

    public static void main(String[] args) {
        // Testes rápidos das validações
        System.out.println(isValidEmail("teste@example.com")); // true
        System.out.println(isValidPhone("1234567890")); // true
        System.out.println(isNotEmpty("   ")); // false
        System.out.println(isValidZipCode("12345-678")); // true
        System.out.println(isValidPassword("password123")); // true
        System.out.println(isValidName("João da Silva")); // true
    }
}


