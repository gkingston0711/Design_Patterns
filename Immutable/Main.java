package com.company;

/**
 * whats important is that no methods to set and all
 * variables are finals
 */


final class animal{
    private final String name;
    private final int speed;

    public animal(String name,int speed){
        this.name=name;
        this.speed=speed;
    }

    public String getName(){return this.name;}
    public int getSpeed(){return this.speed;}
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("immutalbe here");
        animal bigCat=new animal("tiger",35);

        System.out.println(bigCat.getName());
    }
}
