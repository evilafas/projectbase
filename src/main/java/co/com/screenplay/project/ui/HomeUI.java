package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class HomeUI extends PageObject {

    public static final Target LOVE_CATEGORY = Target.the("Categoria Amor").located(By.xpath("//ul[@id='primary-menu']/li[3]"));
    public static final Target BTN_CART = Target.the("Boton carrito").located(By.xpath("//button[contains(text(), 'Añadir al carrito')]"));
    public static final Target BTN_PLUS_ELEMENT_TO_CART = Target.the("Sumar un elemento mas al carrito").located(By.xpath("//input[@class='plus']"));
    }
