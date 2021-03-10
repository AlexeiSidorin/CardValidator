
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardValidateTest {

    @Test
    void shouldSubmitRequest(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("Алеша");
        $("[type='tel']").sendKeys("+79200000000");
        $("[class='checkbox__box']").click();
        $(byText("Продолжить")).click();
        $(Selectors.withText("Ваша заявка успешно отправлена!")).shouldBe(visible, Duration.ofSeconds(6));
    }

    @Test
    void shouldFieldValidBeOnName(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("sdf");
        $("[type='tel']").sendKeys("+79200000010");
        $(byText("Продолжить")).click();
        $(Selectors.withText("Имя и Фамилия указаные неверно.")).shouldBe(visible);

    }
    @Test
    void shouldFieldValidBeOnPhone(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("Витя");
        $("[type='tel']").sendKeys("+23123");
        $(byText("Продолжить")).click();
        $(Selectors.withText("Телефон указан неверно.")).shouldBe(visible);

    }

    @Test
    void shouldFieldValidBeOnCheckBox(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("Дима");
        $("[type='tel']").sendKeys("+79200000000");
        $(byText("Продолжить")).click();
        $("[class='checkbox checkbox_size_m checkbox_theme_alfa-on-white input_invalid']").shouldBe(visible);

    }

    @Test
    void shouldFieldValidIfNameIsEmpty(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("");
        $("[type='tel']").sendKeys("+79200000000");
        $("[class='checkbox__box']").click();
        $(byText("Продолжить")).click();
        $(Selectors.withText("Поле обязательно для заполнения")).shouldBe(visible);
    }

    @Test
    void shouldFieldValidIfPhoneIsEmpty(){
        open("http://localhost:9999");
        $("[type='text']").sendKeys("Женя");
        $("[type='tel']").sendKeys("");
        $("[class='checkbox__box']").click();
        $(byText("Продолжить")).click();
        $(Selectors.withText("Поле обязательно для заполнения")).shouldBe(visible);
    }


}
