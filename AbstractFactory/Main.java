package com.company;

import java.awt.*;

/**----------------Below is product A (pizzas)-----------------------**/
abstract class pizza{
    String type;
    int price;

    public void prep(){System.out.println("prepping...");}
    public void bake(){System.out.println("baking...");}
    public void box(){System.out.println("its headed your way");}

}
//CONCRETE CHEESE PIZZA FOR OREGON FACTORY
class ORCheesePizza extends pizza{
    public ORCheesePizza(){
        System.out.println("creation of cheese pizza at oregon store");
        this.price=12;
        this.type="cheese";
    }
}

//CONCRETE PEPPERONI PIZZA FOR OREGON FACTORY
class ORPepperoniPizza extends pizza{
    public ORPepperoniPizza(){
        System.out.println("creation of pepperoni pizza at oregon store");
        this.price=13;
        this.type="pepperoni";
    }
}

//CONCRETE CHEESE PIZZA FOR WASHINGTON FACTORY
class WACheesePizza extends pizza{
    public WACheesePizza(){
        System.out.println("creation of cheese pizza at washington store");
        this.price=14;
        this.type="cheese";
    }
}

//CONCRETE PEPPERONI PIZZA FOR WASHINGTON FACTORY
class WAPepperoniPizza extends pizza{
    public WAPepperoniPizza(){
        System.out.println("creation of pepperoni pizza at washington store");
        this.price=15;
        this.type="pepperoni";
    }
}

//CONCRETE CHEESE PIZZA FOR CALIFORNIA FACTORY
class CACheesePizza extends pizza{
    public CACheesePizza(){
        System.out.println("creation of cheese pizza at california store");
        this.price=17;
        this.type="cheese";
    }
}

//CONCRETE PEPPERONI PIZZA FOR WASHINGTON FACTORY
class CAPepperoniPizza extends pizza{
    public CAPepperoniPizza(){
        System.out.println("creation of pepperoni pizza at california store");
        this.price=15;
        this.type="pepperoni";
    }
}

/**----------------Below is product B (salads)----------------------**/

abstract class salad{
    String type;
    int price;

    public void tossing(){System.out.println("tossing salad now...");}
    public void box(){System.out.println("salad is boxed and ready to go...");}
}

//CONCRETE SALAD OREGON
class ORSalad extends salad{
    public ORSalad(){
        System.out.println("creation of salad at oregon store");
        this.price=6;
        this.type="salad";
    }
}

//CONCRETE SALAD WASHINGTON
class WASalad extends salad{
    public WASalad(){
        System.out.println("creation of salad at washington store");
        this.price=8;
        this.type="salad";
    }
}

//CONCRETE SALAD CALIFORNIA
class CASalad extends salad{
    public CASalad(){
        System.out.println("creation of salad at california store");
        this.price=9;
        this.type="salad";
    }
}

/**------------FACTORY BELOW--------------**/

abstract class pizzaStore {
    public pizza orderPizza(String type) {

        pizza Pizza = createPizza(type);
        Pizza.prep();
        Pizza.bake();
        Pizza.box();
        return Pizza;
    }

    public salad orderSalad(){//no arguments needed since only one type of salad per factory

        salad Salad = createSalad();

        Salad.tossing();
        Salad.box();
        return Salad;
    }

    abstract pizza createPizza(String type);//getProductA
    abstract salad createSalad();//getProductB

}
/**-----------CONCRETE FACTORY BELOW---------------**/

class OregonPizzaStore extends pizzaStore{

    @Override
    pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ORCheesePizza();
        }
        if(type.equals("pepperoni")){
            return new ORPepperoniPizza();
        }
        System.out.println("not found, throw exception");
        return null;
    }

    @Override
    salad createSalad() {
        return new ORSalad();
    }
}

class WashingtonPizzaStore extends pizzaStore{

    @Override
    pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new WACheesePizza();
        }
        if(type.equals("pepperoni")){
            return new WAPepperoniPizza();
        }
        System.out.println("not found, throw exception");
        return null;
    }

    @Override
    salad createSalad() {
        return new WASalad();
    }
}

class CaliforniaPizzaStore extends pizzaStore{

    @Override
    pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new CACheesePizza();
        }
        if(type.equals("pepperoni")){
            return new CAPepperoniPizza();
        }
        System.out.println("not found, throw exception");
        return null;
    }

    @Override
    salad createSalad() {
        return new CASalad();
    }
}

/**---------- Client testing below ----------------**/

public class Main {

    public static void main(String[] args) {
	System.out.println("ABSTRACT FACTORY TEST\n");

	pizzaStore Portland = new OregonPizzaStore();
	pizzaStore Seattle = new WashingtonPizzaStore();
	pizzaStore Riverside = new CaliforniaPizzaStore();

	Portland.orderPizza("cheese");
	Portland.orderPizza("pepperoni");
	Portland.orderSalad();
	System.out.println("\n");

	Riverside.orderPizza("cheese");
	Riverside.orderPizza("pepperoni");
	Riverside.orderSalad();
	System.out.println("\n");

	Seattle.orderPizza("cheese");
	Seattle.orderPizza("pepperoni");
	Seattle.orderSalad();


    }
}
