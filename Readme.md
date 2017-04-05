# Supermarket pricing
Inspired by [Kata01: Supermarket Pricing](http://codekata.com/kata/kata01-supermarket-pricing)



## REST API

Suggested REST API definition for supermarket pricing is presented below.

### Root:

    /api/v1

### Products

    GET     /products                               | Get all products.
    GET     /products/{productId}                   | Get product by productId.

### Baskets

    POST    /baskets                                |   Create empty basket.
    GET     /baskets/{basketId}                     |   Get basket by basketId.
    POST    /baskets/{basketId}/items               |   Add item into basket.
    GET     /baskets/{basketId}/items/{itemId}      |   Get item by itemId from basket identified by basketId.
    DELETE  /baskets/{basketId}/items/{itemId}      |   Delete item from basket.


### Pricing

    GET     /pricing?basketId={basketId}            |   Get pricing for basket.


### Discounts

    GET     /discounts?itemId={itemId}              |   Get discounts for item.
    
