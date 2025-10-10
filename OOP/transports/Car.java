package transports;

public class Car extends Transport {
    private String fuelType;

    public Car(String name, int maxSpeed, int capacity, String fuelType) {
        super(name, maxSpeed, capacity);
        setFuelType(fuelType);
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (fuelType == null || fuelType.isEmpty()) throw new IllegalArgumentException("Fuel type cannot be empty.");
        this.fuelType = fuelType;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is driving.");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " stopped.");
    }
}

