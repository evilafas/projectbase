package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.LOVE_CATEGORY;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FuntionsElementsTask implements Task {

    @Override
    @Step("{0} seleccion de la ID Card ELEMENTS")
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(Scroll.to(LOVE_CATEGORY));
        actor.attemptsTo(WaitUntil.the(LOVE_CATEGORY, isEnabled())
                .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(LOVE_CATEGORY));

    }


    public static FuntionsElementsTask choose(){
        return Tasks.instrumented(FuntionsElementsTask.class);
    }

}
