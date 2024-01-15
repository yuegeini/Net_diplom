package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.LocalDate.now;

public class DataHelper {
    private static final String cardNumberOne =  "4444 4444 4444 4441";
    private static final String cardNumberTwo =  "4444 4444 4444 4442";
    private static final Faker faker = new Faker(new Locale("en"));

    private DataHelper() {

    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String cardholder;
        String validationCode;
    }

    public static String generateMonth(int shift) {
        return now().plusDays(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYears(int shift) {
        return LocalDate.now().plusYears(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static CardInfo getApprovedCardInfo() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getDeclinedCardInfo() {
        String cardNumber = cardNumberTwo;
        String month = generateMonth(0);
        String year = generateYears(0);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getCardholderHyphenated() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(3);
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getEmptyCardNumber() {
        String month = generateMonth(5);
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo("", month, year, cardHolder, validationCode);
    }

    public static CardInfo getCardNumberGetFilledLettersOrSymbols() {
        String cardNumber = "qwdf!#(^%!_+=ыв";
        String month = generateMonth(3);
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getNumberCard15Symbols() {
        String cardNumber = "4444 4444 4444 ";
        String month = generateMonth(3);
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getEmptyMonth() {
        String cardNumber = cardNumberOne;
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, "", year, cardHolder, validationCode);
    }

    public static CardInfo getMonthGetFilledLettersOrSymbols() {
        String cardNumber = cardNumberOne;
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, "!w", year, cardHolder, validationCode);
    }

    public static CardInfo getMonthFilledOneDigit() {
        String cardNumber = cardNumberOne;
        String year = generateYears(3);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, "2", year, cardHolder, validationCode);
    }

    public static CardInfo getCardMonthOver12() {
        String cardNumber = cardNumberOne;
        String year = generateYears(0);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, "15", year, cardHolder, validationCode);
    }


    public static CardInfo getEmptyYear() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, "", cardHolder, validationCode);
    }

    public static CardInfo getExpiredCard() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, "00", cardHolder, validationCode);
    }

    public static CardInfo getCurrentYearPlus5Years() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(6);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }

    public static CardInfo getOneDigitInYear() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, "2", cardHolder, validationCode);
    }

    public static CardInfo getEmptyCardholder() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, "", validationCode);
    }

    public static CardInfo getNumbersInCardholder() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, "1234567890", validationCode);
    }

    public static CardInfo getDataInSymbols() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(cardNumber, month, year, "!^*&(*)(_)(&^$%*}{", validationCode);
    }

    public static CardInfo getEmptyCVC() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        return new CardInfo(cardNumber, month, year, cardHolder, "");
    }

    public static CardInfo get2SymbolsInCVC() {
        String cardNumber = cardNumberOne;
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(2);
        return new CardInfo(cardNumber, month, year, cardHolder, validationCode);
    }
}