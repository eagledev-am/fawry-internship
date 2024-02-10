# Abstract Factory Task

![problem-en-2x](https://github.com/eagledev-am/Design-Pattern/assets/84116267/e04a0119-6a4c-45aa-a7b0-073ff6b954eb)

## description of the problem 
#### Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:

- A family of related products, say: Chair + Sofa + CoffeeTable.
- Several variants of this family. For example, products Chair + Sofa + CoffeeTable are available in these variants: Modern, Victorian, ArtDeco.

#### You need a way to create individual furniture objects so that they match other objects of the same family. Customers get quite mad when they receive non-matching furniture.
#### Also, you don’t want to change existing code when adding new products or families of products to the program. Furniture vendors update their catalogs very often, and you wouldn’t want to change the core code each time it happens.
