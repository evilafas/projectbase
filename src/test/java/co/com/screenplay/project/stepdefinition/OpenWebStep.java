package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.tasks.AddAnElementToCart;
import co.com.screenplay.project.tasks.SelectAnItem;
import co.com.screenplay.project.tasks.ValidateElements;
import co.com.screenplay.project.utils.Time;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import co.com.screenplay.project.hook.OpenWeb;

import static co.com.screenplay.project.ui.HomeUI.*;
import static co.com.screenplay.project.utils.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.StringContains.containsString;

public class OpenWebStep {
    private String webUrl;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web")
    public void openTheWebSite(String actor) {

        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL()
        );
        Time.waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                seeThat(TheWebPage.title(), containsString(TITLE))
        );
    }

    @Given("desea validar la funcion de la carta de elementos")
    public void wantsToValidateTheFuncionOfTheItemsCard() {
        OnStage.theActorCalled(ACTOR).attemptsTo(ValidateElements.toBeVisible(LOVE_CATEGORY) );
    }

    @When("selecciona un elemento")
    public void selectAnItem() {
        OnStage.theActorCalled(ACTOR).attemptsTo(SelectAnItem.on(FIRST_ELEMENT));
    }

    @When("agrega un elemento mas al carrito")
    public void addsOneMoreItemToCart() {
        OnStage.theActorCalled(ACTOR).attemptsTo(AddAnElementToCart.toBeVisible(BTN_PLUS_ELEMENT_TO_CART));
    }

    @Then("visualizara en el carrito los elementos seleccionados")
    public void willSeeTheSelectedItems() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Click.on(BTN_CART)
        );
    }
}
