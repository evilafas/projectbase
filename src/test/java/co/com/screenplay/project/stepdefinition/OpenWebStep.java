package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.utils.Time;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.util.EnvironmentVariables;
import co.com.screenplay.project.hook.OpenWeb;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
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
        // Código para validar la función de la carta de elementos
        throw new io.cucumber.java.PendingException();
    }

    @When("selecciona un elemento")
    public void selectAnItem() {
        // Código para seleccionar un elemento
        throw new io.cucumber.java.PendingException();
    }

    @When("agrega un elemento mas al carrito")
    public void addsOneMoreItemToCart() {
        // Código para agregar un elemento más al carrito
        throw new io.cucumber.java.PendingException();
    }

    @Then("visualizara en el carrito los elementos seleccionados")
    public void willSeeTheSelectedItems() {
        // Código para verificar los elementos seleccionados en el carrito
        throw new io.cucumber.java.PendingException();
    }
}
