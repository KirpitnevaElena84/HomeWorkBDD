package ru.netology.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
        // приватный конструктор, чтобы нельзя было создать экземпляр
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");

    }

    /**
     * Возвращает валидную сумму: положительное число на основе баланса.
     * Здесь пример логики: берём модуль баланса и делим на 100 (если баланс в копейках).
     */
    public static int generateValidAmount(int balance) {
        int amount = Math.abs(balance) / 100;
        // Чтобы сумма не была 0, если баланс маленький:
        return amount == 0 ? 1 : amount;
    }
    public static int generateInvalidAmount(int balance) {
        return Math.abs(balance) + 1; // на 1 рубль больше остатка — гарантированно превышает баланс
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
        // Геттеры генерируются Lombok автоматически, отдельный getCardNumber() не нужен
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}
