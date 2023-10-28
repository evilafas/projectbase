package co.com.screenplay.project.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateElements implements Task {

    private final Target element;

    public ValidateElements(Target element) {
        this.element = element;
    }

    public static ValidateElements toBeVisible(Target element) {
        return instrumented(ValidateElements.class, element);
    }

    @Override
    @Step("{0} espera hasta que el elemento #element sea visible")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(element, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(element)
        );
    }
}
