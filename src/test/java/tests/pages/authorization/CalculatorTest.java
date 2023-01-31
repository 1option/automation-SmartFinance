package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import static constants.Constant.URLS.TEST_PLAN;

@DisplayName("test_calculator_001")
@Tag("Login")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Калькулятор")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
@Tag("Smoke")
public class CalculatorTest extends BaseTest {

    @DisplayName("Изменить положения хэндлеров на ")
    @Description("Тест проверяет возможность взаимодействия со слайдером")
    @ParameterizedTest(name = "{0} по оси X")
    @Execution(ExecutionMode.SAME_THREAD) // В одном потоке. Каждый вызов теста - новый инстанс
    @ValueSource(ints = {-100, 45, 70})
    public void moveHandlersAndCheckValues(int xOffset) {
        calculator.moveHandlers(xOffset).checkValues();
    }
}
