package tests.calculator;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;

@DisplayName("test_calculator_001")
@Tag("Login")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Калькулятор (слайдер)")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Tag("Smoke")
public class CalculatorTest extends BaseTest {

    @DisplayName("Изменить положения хэндлеров")
    @Description(value = "Тест проверяет возможность взаимодействия со слайдером")
    @Test
    public void moveHandlersAndCheckValues() {
        calculator.findHandlerElements();
        calculator.moveHandlers(-100)
                .checkValues()
                .moveHandlers(45)
                .checkValues()
                .moveHandlers(70)
                .checkValues();
    }
}
