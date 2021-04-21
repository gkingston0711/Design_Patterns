package com.company;



abstract class PizzaIF{
    String Type="";

    abstract double cost();
    String getDescription(){return Type;}
}

abstract class PizzaDecorator extends PizzaIF{
    PizzaIF pizza;

    abstract String getDescription();
}

class ThinCrustPizza extends PizzaIF {
    public ThinCrustPizza(){
        this.Type="Thin Crust with sauce ";
    }

    double cost() {
        return 6.90;}
}

class ThickCrustPizza extends PizzaIF {
    public ThickCrustPizza(){
        this.Type="Thick Crust with sauce ";
    }

    double cost() {
        return 5.10;}
}

class MediumCrustPizza extends PizzaIF {
    public MediumCrustPizza(){
        this.Type="Medium Crust with sauce ";
    }

    double cost() {
        return 6.90;}
}

class Pepperoni extends PizzaDecorator{

    public Pepperoni(PizzaIF pizza){
        this.pizza=pizza;
    }

    double cost() {
        return pizza.cost() + 1.10;
    }

    String getDescription() {
        return pizza.getDescription() + "Pepperoni, ";
    }
}

class Sausage extends PizzaDecorator{

    public Sausage(PizzaIF pizza){
        this.pizza=pizza;
    }

    double cost() {
        return pizza.cost() + 1.30;
    }

    String getDescription() {
        return pizza.getDescription() + "Sausage, ";
    }
}

class Cheese extends PizzaDecorator{

    public Cheese(PizzaIF pizza){
        this.pizza=pizza;
    }

    double cost() {
        return pizza.cost() + 1.50;
    }

    String getDescription() {
        return pizza.getDescription() + "Cheese, ";
    }
}

class Veggies extends PizzaDecorator{

    public Veggies(PizzaIF pizza){
        this.pizza=pizza;
    }

    double cost() {
        return pizza.cost() + 2.10;
    }

    String getDescription() {
        return pizza.getDescription() + "Veggies, ";
    }
}

public class Main {

    public static void main(String[] args) {
	System.out.println("***TESTING FOR DECORATOR***");
	PizzaIF Pizza = new ThinCrustPizza();

	Pizza = new Cheese(Pizza);
	Pizza = new Pepperoni(Pizza);
	Pizza = new Veggies(Pizza);
	Pizza = new Sausage(Pizza);

	System.out.println(Pizza.getDescription() + " price : " + Pizza.cost());
    }
}
