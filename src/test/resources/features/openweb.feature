#author: Andres
#language: es
  Característica: Abrir una pagina web
    Yo como Andres
    quiero realizar una prueba de abrir la pagina Floristeria Mundo Flor
    para comprobar la robustes y control de errores de la aplicacion

    Antecedentes:
      Dado "Andres" abre el sitio web

    @successful
    Escenario: validacion de productos
      Y desea validar la funcion de la carta de elementos
      Cuando selecciona un elemento
      Y agrega un elemento mas al carrito
      Entonces visualizara en el carrito los elementos seleccionados
