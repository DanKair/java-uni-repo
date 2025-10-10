package transports;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transport> transports = new ArrayList<>();

        transports.add(new Bicycle("Mountain Bike", 25, 1, 21));
        transports.add(new Bicycle("Road Bike", 30, 1, 18));
        transports.add(new Car("Sedan", 180, 5, "Petrol"));
        transports.add(new Car("Sports Car", 320, 2, "Petrol"));
        transports.add(new Bus("City Bus", 90, 50, 45));
        transports.add(new Bus("Coach", 100, 55, 50));

        Bicycle bestBicycle = null;
        Car bestCar = null;
        Bus bestBus = null;

        for (Transport t : transports) {
            if (t instanceof Bicycle) {
                Bicycle b = (Bicycle) t;
                if (bestBicycle == null || b.getNumberOfGears() > bestBicycle.getNumberOfGears()) {
                    bestBicycle = b;
                }
            } else if (t instanceof Car) {
                Car c = (Car) t;
                if (bestCar == null || c.getMaxSpeed() > bestCar.getMaxSpeed()) {
                    bestCar = c;
                }
            } else if (t instanceof Bus) {
                Bus b = (Bus) t;
                if (bestBus == null || b.getCapacity() > bestBus.getCapacity()) {
                    bestBus = b;
                }
            }
        }

        System.out.println("Best Bicycle: " + bestBicycle);
        System.out.println("Best Car: " + bestCar);
        System.out.println("Best Bus: " + bestBus);
    }
}

