package transports;

public class Bus extends Transport {
    private int passengerSeats;

    public Bus(String name, int maxSpeed, int capacity, int passengerSeats) {
        super(name, maxSpeed, capacity);
        setPassengerSeats(passengerSeats);
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(int passengerSeats) {
        if (passengerSeats <= 0) throw new IllegalArgumentException("Passenger seats must be positive.");
        this.passengerSeats = passengerSeats;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is moving on the road.");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " has stopped.");
    }

    public String toString(){
        return "Bus: " + this.getName() + "\nMax speed: " + this.getMaxSpeed() + 
        "\nNumber of Passenger Seats: " + this.getPassengerSeats();
    }
}

