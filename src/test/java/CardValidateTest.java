
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
        Configuration.timeout = 6000;
        $(Selectors.withText("Ваша заявка успешно отправлена!")).shouldBe(visible, Duration.ofSeconds(6));
    }



}
