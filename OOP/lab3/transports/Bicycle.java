package transports;

public class Bicycle extends Transport{
    private int numberOfGears;

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        if (numberOfGears <= 0) throw new IllegalArgumentException("Number of gears must be positive.");
        this.numberOfGears = numberOfGears;
    }

    public Bicycle(String name, int maxSpeed, int capacity, int numberOfGears){
        super(name, maxSpeed, capacity);
        setNumberOfGears(numberOfGears);
    }

    @Override
    protected void move() {
        System.out.println("Bycicle with " + this.numberOfGears + " number of gears moves." + "\nWroom!");
    }

    @Override
    protected void stop() {
        System.out.println("Bycicle with " + this.numberOfGears + " number of gears stop.");
    }


    public String toString(){
        return "Bycicle: " + this.getName() + "\nMax speed: " + this.getMaxSpeed() + "\nNumber of Gears: " + this.getNumberOfGears();
    }

}
