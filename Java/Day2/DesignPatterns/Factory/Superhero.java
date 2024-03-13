package Java.Day2.DesignPatterns.Factory;

public interface Superhero { 
    void activateSuperpower();
    void sayName();
}

class CaptainAmerica implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I can do this all day!");
    }

    @Override
    public void sayName() {
        System.out.println("I am Steve Rogers.");
    }
}

class BlackPanther implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("Wakanda Forever!");
    }

    @Override
    public void sayName() {
        System.out.println("I am T'Challa");
    }
}

class IronMan implements Superhero {

    @Override
    public void activateSuperpower() {
        System.out.println("I'm rich!");
    }

    @Override
    public void sayName() {
        System.out.println("I am.... Iron Man.");
    }
}
