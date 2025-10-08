
#language: es
@testfeatures
Característica: ProductStore
  Yo, como usuario
  Quiero, validar el precio
  Para adquirir mi producto

  @testStore
  Esquema del escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario: "<usuario>" y contraseña: "<contraseña>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego <cantidad> del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

    Ejemplos:
    | usuario              | contraseña | categoria | subcategoria | cantidad |
    | squispem20@gmail.com | Quispe20@@ | Clothes   | Men          | 2        |
    | squispem20@gmail.com | Quispe@@   | Clothes     | Men          | 2        |
    | squispem20@gmail.com | Quispe20@@ | Autos     | Men          | 2        |

