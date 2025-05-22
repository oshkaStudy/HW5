import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    public static void setupConfig() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";

    }

    //2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
    // - Откройте https://the-internet.herokuapp.com/drag_and_drop
    // - Перенесите прямоугольник А на место В
    // - Проверьте, что прямоугольники действительно поменялись
    // - В Selenide есть команда $(element).dragAndDrop($(to-element)),
    // проверьте работает ли тест, если использовать её вместо actions()

    //Реализация через Selenide.actions()
    @Test
    void tryActionsTest() {

        open("/drag_and_drop");

        //Проверка первичного состояния
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //Перетаскивание
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        //Проверка состояния после действий
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

    //Реализация через .dragAndDrop
    @Test
    void tryDragAndDropTest() {

        open("/drag_and_drop");

        //Проверка первичного состояния
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //Перетаскивание
        $("#column-a").dragAndDrop(to($("#column-b")));

        //Проверка состояния после действий
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
