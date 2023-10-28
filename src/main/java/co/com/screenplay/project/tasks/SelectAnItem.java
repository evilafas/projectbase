package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAnItem implements Task {
    private final Target element;

    public SelectAnItem(Target element) {
        this.element = element;
    }

    public static SelectAnItem on(Target element) {
        return instrumented(SelectAnItem.class, element);
    }

    @Override
    @Step("{0} espera hasta que el elemento #element sea visible y hace clic")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(element)
        );
    }
}
