package ru.netology.test;

import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.HomePage;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPageTest {
    HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = open("http://localhost:8080/", HomePage.class);
    }

    @AfterEach
    void tearDown() {
        SQLHelper.cleanDB();
    }

    @Test
    void shouldSuccessPaymentAllValidAPPROVED() {
        var cardInfo = DataHelper.getApprovedCardInfo();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldSuccessfulPayment();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotSuccessPaymentAllValidDECLINED() {
        var cardInfo = DataHelper.getDeclinedCardInfo();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldDeclinedTransaction();
        assertEquals("DECLINED", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldSuccessPaymentAllValidNameWithHyphenAPPROVED() {
        var cardInfo = DataHelper.getCardholderHyphenated();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldSuccessfulPayment();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }


    @Test
    void errorCardNumberNotTotal() {
        var cardInfo = DataHelper.getNumberCard15Symbols();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCardNumberIsEmpty() {
        var cardInfo = DataHelper.getEmptyCardNumber();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorMonthTooHigh() {
        var cardInfo = DataHelper.getCardMonthOver12();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.cardExpirationDateIncorrect();
    }

    @Test
    void errorMonthWithSymbols() {
        var cardInfo = DataHelper.getMonthGetFilledLettersOrSymbols();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCardNumberWithSymbols() {
        var cardInfo = DataHelper.getCardNumberGetFilledLettersOrSymbols();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorMonthNotTotal() {
        var cardInfo = DataHelper.getMonthFilledOneDigit();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearNotTotal() {
        var cardInfo = DataHelper.getOneDigitInYear();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearEmpty() {
        var cardInfo = DataHelper.getEmptyYear();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearIsPrevious() {
        var cardInfo = DataHelper.getExpiredCard();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.expiredNotification();
    }

    @Test
    void errorCardholderWithNumbers() {
        var cardInfo = DataHelper.getNumbersInCardholder();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorMonthEmpty() {
        var cardInfo = DataHelper.getEmptyMonth();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearTooHigh() {
        var cardInfo = DataHelper.getCurrentYearPlus5Years();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.cardExpirationDateIncorrect();
    }


    @Test
    void errorCardholderEmpty() {
        var cardInfo = DataHelper.getEmptyCardholder();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.requiredField();
    }


    @Test
    void errorCardholderWithSymbols() { //Данные о владельце карты указаны неверно: введены символы
        var cardInfo = DataHelper.getDataInSymbols();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCVCEmpty() {//пустое поле CVC
        var cardInfo = DataHelper.getEmptyCVC();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCVCNotTotal() { //Невалидный код CVC: ввод менее 3 цифр
        var cardInfo = DataHelper.get2SymbolsInCVC();
        var cardPage = homePage.goToCardPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }


}