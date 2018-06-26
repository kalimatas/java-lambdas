package chapter3;

import java.util.ArrayList;
import java.util.List;

interface LandingObserver {
    void observeLanding(String name);
}

class Moon {
    private List<LandingObserver> observers = new ArrayList<>();

    void land(String name) {
        for (var observer : observers) {
            observer.observeLanding(name);
        }
    }

    void startSpying(LandingObserver observer) {
        observers.add(observer);
    }
}

class Aliens implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) System.out.println("Let's invade the Earth!");
    }
}

class Nasa implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) System.out.println("We made it!");
    }
}

public class Chapter8 {
    public static void main(String[] args) {
        var moon = new Moon();
        //moon.startSpying(new Aliens());
        //moon.startSpying(new Nasa());

        LandingObserver aliens = name -> {
            if (name.contains("Apollo")) System.out.println("Let's invade the Earth!");
        };

        moon.startSpying(aliens);
        moon.startSpying(name -> { if (name.contains("Apollo")) System.out.println("We made it!"); });

        moon.land("Asteroid");
        moon.land("Apollo");
    }
}
