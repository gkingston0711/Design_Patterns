package com.company;

import java.util.Vector;

abstract class Unit{
    String name;
    Unit(String name){this.name=name;}
    abstract void print();
    /** NEEDED BELOW FOR VISITOR **/
    abstract Object accept(VisitorIF visitor, Object data);

}

class Composite extends Unit {
    Vector<Unit> members = new Vector<>();

    Composite(String name) {
        super(name);
    }

    void print() {
        System.out.println("Composite Name: "+ this.name);
        for(Unit i : members){
            i.print();
        }
    }

    void addMember(Unit unit) {
        members.add(unit);
    }
    /** NEEDED BELOW FOR VISITOR **/
    Object accept(VisitorIF visitor, Object data) {
        return visitor.visit(this, data);
    }
}

class Leaf extends Unit {
    Leaf(String name) {
        super(name);
    }
    void print(){
        System.out.println("Leaf Name: "+ this.name);
    }
    /** NEEDED BELOW FOR VISITOR **/
    Object accept(VisitorIF visitor, Object data) {
        return visitor.visit(this, data);
    }

}

/** VISITOR BELOW **/

interface VisitorIF{
    Object visit(Leaf individual, Object data);
    Object visit(Composite group, Object data);
}

class Visitor implements VisitorIF {

    public Object visit(Leaf individual, Object data) {
        return individual.name.equals((String) data);
    }
    public Object visit(Composite group, Object data) {
        if (group.name.equals((String) data)){
            return true;
        }

        for (Unit u : group.members) {
            if ((Boolean) u.accept(this, data)){
                return true;
            }
        }
        return false;

    }
}



public class Main {

    public static void main(String[] args) {
    Composite company = new Composite("Home Depot");
    Composite oregon = new Composite("Oregon");
    Leaf name1 = new Leaf("john");
    Leaf name2 = new Leaf("james");
    Leaf name3 = new Leaf("sally");
    Leaf name4 = new Leaf("jake");
    Leaf name5 = new Leaf("zack");
    company.addMember(name1);
    company.addMember(name5);
    company.addMember(oregon);
    oregon.addMember(name2);
    oregon.addMember(name3);
    company.addMember(name4);


    company.print();

        VisitorIF find = new Visitor();
        System.out.println(company.accept(find, "john"));
        System.out.println(company.accept(find, "xyz"));
    }
}
