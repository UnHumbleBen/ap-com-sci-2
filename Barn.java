import java.util.*;

class Animal {
    private int age = 5;
    private String name = "notUsed";
    public Animal() {
        age = 10;
        name = "Used";
        System.out.println("I was used");
    }
    
    public String talk() {
        return "";
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    
    public String talk() {
        return "Meow";
    }
    
    public String sit() {
        return "sit"; 
    }
}

class Dog extends Animal {

    
    public String talk() {
        return "Woof";
    }
}

class Cow extends Animal {

    
    public String talk() {
        return "Moo";
    }
}

// polymorphism
public class Barn {
    /*
    static void makeSound(final Animal a) {
        System.out.println(a.talk());
    }
    */
    public static void main (String[] args) {
        Animal b = new Cat();
        System.out.println(b.talk());
        ArrayList<Cat> barn = new ArrayList<Cat>();
        Animal a = new Animal();
        Cat c = new Cat();
        //System.out.println(b.sit());
        System.out.println(c.sit());
        //barn.add(a);
        //barn.add(b);
        barn.add(c);
        
        System.out.println(a.getAge());
        System.out.println(b.getAge());
        System.out.println(c.getAge());

        System.out.println(a.getName());
        System.out.println(b.getName());
        System.out.println(c.getName());
        
        
        
        
        
        //ArrayList<Animal> barn = new ArrayList<Animal>();
        //barn.add(new Cat());
        //barn.add(new Dog());
        //barn.add(new Cow());
        //makeSound(new Cat()); // returns "Meow"
        //makeSound(new Dog()); // returns "Woof"
        //makeSound(new Cow()); // returns "Moo"
    }
}