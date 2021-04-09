package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class pizza{
    public String type;
    public int price;
    public int getPrice(){return this.price;}
    public String getType(){return this.type;}


    public void prep(){System.out.println("prepping...");}
    public void bake(){System.out.println("baking...");}
    public void box(){System.out.println("its headed your way");}

}

class peperoniPizza extends pizza{
    public peperoniPizza(){
        this.type="peperoni";
        this.price=11;
        System.out.println("peperoni pizza created");
    }

}

class cheesePizza extends pizza{
    public cheesePizza(){
        this.type="cheese";
        this.price=10;
        System.out.println("cheese pizza created");
    }
}

class veggiePizza extends pizza{
    public veggiePizza(){
        this.type="veggie";
        this.price=14;
        System.out.println("veggie pizza created");
    }
}

class simplePizzaFactory{

    public pizza createPizza(String type){
        if(type.equals("peperoni")){
            System.out.println("creating peperoni pizza...");
            return new peperoniPizza();
        }
        if(type.equals("cheese")){
            System.out.println("creating cheese pizza...");
            return new cheesePizza();
        }
        if(type.equals("veggie")){
            System.out.println("creating veggia pizza...");
            return new veggiePizza();
        }
        return null;
    }
}

class pizzaStore{
    private simplePizzaFactory factory;

    public pizzaStore(simplePizzaFactory factory){
        this.factory=factory;
    }
    public pizza orderPizza(String type){
        pizza Pizza = factory.createPizza(type);

        System.out.println("price is: "+Pizza.getPrice());
        Pizza.prep();
        Pizza.bake();
        Pizza.box();



        return Pizza;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        simplePizzaFactory factory = new simplePizzaFactory();
        pizzaStore ORstore=new pizzaStore(factory);


    System.out.println("----welcome to Oregon pizza store what pizza would you like? -----");
        //String input = reader.readLine();


    ORstore.orderPizza("veggie");
    //ORstore.orderPizza("peperoni");


    }
}
