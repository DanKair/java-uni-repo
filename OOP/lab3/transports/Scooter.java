package transports;

public class Scooter extends Transport{
    private boolean isElectric;

    public Scooter(String name, int maxSpeed, int capacity, boolean isElectric){
        super(name, maxSpeed, capacity);
        this.isElectric = isElectric;
    }

    public boolean getIsElectricStatus(){
        return this.isElectric;
    }

    protected void move() {
        System.out.println("Scooter with " + this.getName() + "  moves.");
    }

    protected void stop() {
        System.out.println("Bycicle with " + this.getName()+ " stops.");
    }

    public String toString(){
        return "Scooter: " + this.getName() + "\nMax speed: " + this.getMaxSpeed() + 
        "\n Is Electric: " + this.getIsElectricStatus();
    }
}
