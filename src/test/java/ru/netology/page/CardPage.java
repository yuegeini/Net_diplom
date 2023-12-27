package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardPage {
    private final SelenideElement heading = $(byText("Оплата по карте"));
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement cardholderField = $$("[class='input__control']").get(3);
    private final SelenideElement cvcCodeField = $("[placeholder='999']");
    private final SelenideElement buyButton = $$("span.button__text").get(2);

    private final SelenideElement errorMessage = $("span.input__sub");
    private final SelenideElement errorNotification = $(".notification_status_error .notification__content");
    private final SelenideElement notificationStatusOk = $(".notification_status_ok .notification__content");

    public CardPage() {
        heading.shouldBe(Condition.visible);
    }

    public void fillingCardData(DataHelper.CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        cardholderField.setValue(cardInfo.getCardholder());
        cvcCodeField.setValue(cardInfo.getValidationCode());
        buyButton.click();
    }

    public void shouldSuccessfulPayment() {
        notificationStatusOk.shouldHave(Condition.text("Операция одобрена Банком"), Duration.ofSeconds(15));
        notificationStatusOk.shouldBe(Condition.visible);
    }

    public void shouldDeclinedTransaction() {
        errorNotification.shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(15));
        errorNotification.shouldBe(Condition.visible);
    }

    public void wrongFormat() {
        errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Неверный формат"));
    }

    public void expiredNotification() {
        errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Истёк срок действия карты"));
    }

    public void cardExpirationDateIncorrect() {
        errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Неверно указан срок действия карты"));
    }

    public void requiredField() {
        errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Поле обязательно для заполнения"));
    }

}