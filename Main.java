package com.company;

import java.util.Hashtable;

abstract class bulb{
    int power;
    String brand;
    void emitLight() {}
}

class LED extends bulb {
    final int type = 1;//rating based on eco friendliness

     public LED(int power,String brand){
         this.power=power;
         this.brand=brand;

         System.out.println("LED light with lumination power of "+this.power+ " and brand "+ this.brand +" is being CREATED");
     }

    @Override
    public void emitLight() {
        System.out.println("LED light with a lumination power of "+this.power+" and brand is "+this.brand);

    }
}

class incandescent extends bulb{
    final int type=0;//rating based on eco friendliness

    public incandescent(int power,String brand){
        this.power=power;
        this.brand=brand;

        System.out.println("incandescent light with lumination power of "+this.power+ " and brand "+ this.brand +" is being CREATED");
    }

    @Override
    public void emitLight() {
        System.out.println("Incandescent light with a lumination power of "+this.power+" and brand is "+this.brand);
    }
}

class flyweightFactory{



    Hashtable<String,bulb> table = new Hashtable<>();

    bulb getBulb(int t, int p, String l){

        String key = t + " " + p + " " + l;

        bulb b = table.get(key);

        if(b==null){
            if(t==0){
                b = new LED(p,l);
            }
            if(t==1){
                b= new incandescent(p,l);
            }
            table.put(key,b);
        }
        else{
            System.out.println("Bulb already exists... returning it to you now");
        }

        return b;
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        flyweightFactory flyweight = new flyweightFactory();
        String[] brandArray = new String[]{ "bell","bower","hager","GE",};

        long startTime = System.nanoTime();
        for(int i =0 ;i<1000; i++ ) {
            int t = (int) (Math.random() * 2 + 0);
            int p =(int) (Math.random() * 20 + 60);
            int l =(int) (Math.random() * 4 + 0);
            bulb b = flyweight.getBulb(t,p,brandArray[l]);
        }
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        
        System.out.println("Execution time for flyweight in milliseconds : " +
                timeElapsed / 1000000);

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        long actualMemUsed=afterUsedMem-beforeUsedMem;

        System.out.println("MEMORY USAGE IS: "+actualMemUsed);


    }
}
