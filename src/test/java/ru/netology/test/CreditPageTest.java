package ru.netology.test;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditPageTest {
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
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldSuccessfulPayment();
        assertEquals("APPROVED", SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldNotSuccessPaymentAllValidDECLINED() {
        var cardInfo = DataHelper.getDeclinedCardInfo();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldDeclinedTransaction();
        assertEquals("DECLINED", SQLHelper.getCreditRequestStatus());
    }

    @Test
    void shouldSuccessPaymentAllValidNameWithHyphenAPPROVED() {
        var cardInfo = DataHelper.getCardholderHyphenated();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.shouldSuccessfulPayment();
        assertEquals("APPROVED", SQLHelper.getCreditRequestStatus());
    }


    @Test
    void errorCardNumberWithSymbols() {
        var cardInfo = DataHelper.getCardNumberGetFilledLettersOrSymbols();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCardNumberNotTotal() {
        var cardInfo = DataHelper.getNumberCard15Symbols();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCardNumberIsEmpty() {
        var cardInfo = DataHelper.getEmptyCardNumber();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorMonthEmpty() {
        var cardInfo = DataHelper.getEmptyMonth();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }


    @Test
    void errorMonthTooHigh() {
        var cardInfo = DataHelper.getCardMonthOver12();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.cardExpirationDateIncorrect();
    }

    @Test
    void errorMonthWithSymbols() {
        var cardInfo = DataHelper.getMonthGetFilledLettersOrSymbols();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearEmpty() {
        var cardInfo = DataHelper.getEmptyYear();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearIsPrevious() {
        var cardInfo = DataHelper.getExpiredCard();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.expiredNotification();
    }

    @Test
    void errorMonthNotTotal() {
        var cardInfo = DataHelper.getMonthFilledOneDigit();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearNotTotal() {
        var cardInfo = DataHelper.getOneDigitInYear();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCardholderEmpty() {
        var cardInfo = DataHelper.getEmptyCardholder();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.requiredField();
    }

    @Test
    void errorCardholderWithNumbers() {
        var cardInfo = DataHelper.getNumbersInCardholder();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorYearTooHigh() {
        var cardInfo = DataHelper.getCurrentYearPlus5Years();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.cardExpirationDateIncorrect();
    }

    @Test
    void errorCardholderWithSymbols() {
        var cardInfo = DataHelper.getDataInSymbols();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCVCEmpty() {
        var cardInfo = DataHelper.getEmptyCVC();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }

    @Test
    void errorCVCNotTotal() {
        var cardInfo = DataHelper.get2SymbolsInCVC();
        var cardPage = homePage.goToCreditPage();
        cardPage.fillingCardData(cardInfo);
        cardPage.wrongFormat();
    }


}