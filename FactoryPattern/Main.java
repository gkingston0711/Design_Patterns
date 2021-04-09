package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class pizza{
    public String type;
    public int price;

    public void prep(){System.out.println("prepping...");}
    public void bake(){System.out.println("baking...");}
    public void box(){System.out.println("its headed your way");}
}

class peperoniPizza extends pizza{
    public peperoniPizza(){
        this.type="peperoni";
        this.price=11;
        System.out.println("OR/NY peperoni pizza created");
    }
}

class cheesePizza extends pizza{
    public cheesePizza(){
        this.type="cheese";
        this.price=10;
        System.out.println("OR/NY cheese pizza created");
    }
}
//ONLY FOR THE OR LOCATION
class deluxPizza extends pizza{
    public deluxPizza(){
        this.type="delux";
        this.price=14;
        System.out.println("OR Delux pizza created");
    }
}

//ONLY FOR THE NY LOCATION
class veggiePizza extends pizza{
    public veggiePizza(){
        this.type="veggie";
        this.price=24;
        System.out.println("NY veggie pizza created");
    }
}


abstract class pizzaStore{
    public pizza orderPizza(String type){

        pizza Pizza = CreatePizza(type);
        Pizza.prep();
        Pizza.bake();
        Pizza.box();
        return Pizza;
    }
    abstract pizza CreatePizza(String type);
}



class OR_pizzaStore extends pizzaStore {

    @Override
    pizza CreatePizza(String type) {
        if (type.equals("cheese")) {
            return new cheesePizza();
        }
        if (type.equals("peperoni")) {
            return new peperoniPizza();
        }
        if (type.equals("delux")) {
            return new  deluxPizza();
        }
        return null;
    }
}

class NY_pizzaStore extends pizzaStore{

    @Override
    pizza CreatePizza(String type) {
        if(type.equals("cheese")){
            return new cheesePizza();
        }
        if(type.equals("peperoni")){
            return new peperoniPizza();
        }
        if(type.equals("veggie")){
            return new veggiePizza();
        }
        return null;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("----welcome to pizza store  -----");

        pizzaStore ORstore = new OR_pizzaStore();
        pizzaStore NYstore = new NY_pizzaStore();

        NYstore.orderPizza("cheese");
        ORstore.CreatePizza("peperoni");
        NYstore.orderPizza("veggie");
        ORstore.orderPizza("delux");
    }
}

