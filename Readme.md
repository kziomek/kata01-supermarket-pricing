# Supermarket pricing
Inspired by [Kata01: Supermarket Pricing](http://codekata.com/kata/kata01-supermarket-pricing)

There is an example _basket_ with content listed below. 

    Beans                0.50
    Beans                0.50
    Beans                0.50
    Coke                 0.70
    Coke                 0.70
    Oranges
    0.200 kg @  £1.99/kg 0.40

_Product_ price is listed next to product's name on list above.
        

Application is supposed to make calculation of _basket_ and return _pricing_ object which contains all data needed to present receipt displayed below.


    Beans                0.50
    Beans                0.50
    Beans                0.50
    Coke                 0.70
    Coke                 0.70
    Oranges
    0.200 kg @  £1.99/kg 0.40
                        -----
    Sub-total            3.30

    Savings
    Beans 3 for 2       -0.50
    Coke 2 for £1       -0.40
                        -----
    Total savings       -0.90
    -------------------------
    Total to Pay         2.40

## Test
    
    ./gradlew test

## Implementation

**Product**

Beans, Coke and Oranges extends abstract _Product_. All of them are placed in _product_ package. Factory is added to create product objects.

**Basket**

Basket contains items. Item is related with Product and has quantity which may be fractional i.e. for Oranges.

**Pricing** 

Pricing requirement is implemented by public method _calculate_ in _PricingService_ class.
    
        public Pricing calculate(Basket basket)

**Discount**

There is significant functionality of discounts so it is extracted to separate package _discount_ with _DiscountService_ class which contains method _collectDiscounts_.

        public List<Discount> collectDiscounts(Item item)

Algorithm is simple and iterate through all _discount rules_ and collect result in list of discounts for given _Item_.
There may be more then one rule which produce discount for one Item.
    
Every rule implements _calculateDiscount_ defined in _DiscountRule_ interface.

        Discount calculateDiscount(Item item);

Abstract _BunchDiscountRule_

_Beans3For2DiscountRule_ and _Coke2For1PoundDiscountRule_ implement the same algorithm, so abstract superclass _BunchDiscountRule_ is defined.
_BunchDiscountRule_ implements calculation algorithms and depends on abstract methods, which are implemented in subclasses.
 

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
    
