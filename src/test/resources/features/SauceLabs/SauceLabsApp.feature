@CarritoCompras
Feature: Funcionalidad del carrito de compras

  Scenario Outline: Verificar la funcionalidad del carrito de compras
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galería
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                | UNIDADES |
      | Sauce Labs Backpack     | 1        |
      | Sauce Labs Bolt T-Shirt | 1        |
      | Sauce Labs Bike Light   | 2        |

