package com.paytool.config.util;

public class DocumentValidator {

    public static void isValidCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            throw new RuntimeException("Invalid Document length");
        }

        int[] digits = new int[14];

        for (int i = 0; i < 14; i++) {
            digits[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        int firstVerifier = calculateCNPJVerifier(digits, 12);
        int secondVerifier = calculateCNPJVerifier(digits, 13);

        if (!(digits[12] == firstVerifier && digits[13] == secondVerifier)) {
            throw new RuntimeException("Invalid Document");
        }
    }

    private static int calculateCNPJVerifier(int[] digits, int position) {
        int sum = 0;
        int multiplier = 2;

        for (int i = position - 1; i >= 0; i--) {
            sum += digits[i] * multiplier;
            multiplier = (multiplier == 9) ? 2 : multiplier + 1;
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    public static void isValidCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            throw new RuntimeException("Invalid Document length");
        }

        if (cpf.matches("^(\\d)\\1*$")) {
            throw new RuntimeException("Invalid Document");
        }

        int[] weightsFirstDigit = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsSecondDigit = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        int remainder;

        // Cálculo do primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * weightsFirstDigit[i];
        }

        remainder = sum % 11;
        int firstDigit = (remainder < 2) ? 0 : 11 - remainder;

        if (Character.getNumericValue(cpf.charAt(9)) != firstDigit) {
            throw new RuntimeException("Invalid Document");
        }

        sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * weightsSecondDigit[i];
        }

        remainder = sum % 11;
        int secondDigit = (remainder < 2) ? 0 : 11 - remainder;

        if (!(Character.getNumericValue(cpf.charAt(10)) == secondDigit)) {
            throw new RuntimeException("Invalid Document");
        }
    }
}
