package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.LocalDate.now;

public class DataHelper {
    private static final String CARD_NUMBER_ONE =  "4444 4444 4444 4441";
    private static final String CARD_NUMBER_TWO =  "4444 4444 4444 4442";
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
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, cardHolder, validationCode);
    }

    public static CardInfo getDeclinedCardInfo() {
        String month = generateMonth(0);
        String year = generateYears(0);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_TWO, month, year, cardHolder, validationCode);
    }

    public static CardInfo getCardholderHyphenated() {
        String month = generateMonth(3);
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, cardHolder, validationCode);
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
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, "", year, cardHolder, validationCode);
    }

    public static CardInfo getMonthGetFilledLettersOrSymbols() {
        String year = generateYears(2);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, "!w", year, cardHolder, validationCode);
    }

    public static CardInfo getMonthFilledOneDigit() {
        String year = generateYears(3);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, "2", year, cardHolder, validationCode);
    }

    public static CardInfo getCardMonthOver12() {
        String year = generateYears(0);
        String cardHolder = faker.name().firstName() + "-" + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, "15", year, cardHolder, validationCode);
    }


    public static CardInfo getEmptyYear() {
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, "", cardHolder, validationCode);
    }

    public static CardInfo getExpiredCard() {
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, "00", cardHolder, validationCode);
    }

    public static CardInfo getCurrentYearPlus5Years() {
        String month = generateMonth(2);
        String year = generateYears(6);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, cardHolder, validationCode);
    }

    public static CardInfo getOneDigitInYear() {
        String month = generateMonth(2);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, "2", cardHolder, validationCode);
    }

    public static CardInfo getEmptyCardholder() {
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, "", validationCode);
    }

    public static CardInfo getNumbersInCardholder() {
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, "1234567890", validationCode);
    }

    public static CardInfo getDataInSymbols() {
        String month = generateMonth(2);
        String year = generateYears(1);
        String validationCode = faker.number().digits(3);
        return new CardInfo(CARD_NUMBER_ONE, month, year, "!^*&(*)(_)(&^$%*}{", validationCode);
    }

    public static CardInfo getEmptyCVC() {
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        return new CardInfo(CARD_NUMBER_ONE, month, year, cardHolder, "");
    }

    public static CardInfo get2SymbolsInCVC() {
        String month = generateMonth(2);
        String year = generateYears(1);
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String validationCode = faker.number().digits(2);
        return new CardInfo(CARD_NUMBER_ONE, month, year, cardHolder, validationCode);
    }
}