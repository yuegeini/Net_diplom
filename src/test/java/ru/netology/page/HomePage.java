package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement heading = $(byText("Путешествие дня"));
    private final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement creditButton = $(byText("Купить в кредит"));

    public HomePage() {
        heading.shouldBe(Condition.visible);
    }

    public CardPage goToCardPage() {
        buyButton.click();
        return new CardPage();
    }

    public CreditPage goToCreditPage() {
        creditButton.click();
        return new CreditPage();
    }

}