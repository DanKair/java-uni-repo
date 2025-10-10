package transports;

public class Scooter {
    private boolean isElectric;

    public Scooter(String name, int maxSpeed, int capacity, int isElectric){
        super(name, maxSpeed, capacity);
        this.isElectric = isElectric;
    }

    protected void move() {
        System.out.println("Scooter with " + this.name + "  moves.");
    }

    protected void stop() {
        System.out.println("Bycicle with " + this.name+ " stops.");
    }
}
