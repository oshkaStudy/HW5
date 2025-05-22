import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    public static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    //1. На главной странице GitHub выберите:
    // Меню -> Solutions -> Enterprise (с помощью команды hover для Solutions).
    // Убедитесь, что загрузилась нужная страница
    // (например, что заголовок: "The AI-powered developer platform.").

    @Test
    void checkGithubEnterprisePage() {

        //Открываем главную страницу
        open("/");

        //Наводим курсор на опцию Solutions
        $(".HeaderMenu-nav").$$("li").findBy(text("Solutions")).hover();

        //Находим ссылку на раздел Enterprise
        $(byTagAndText("a", "Enterprises")).click();

        //Проверяем страницу на соответствие
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

}
