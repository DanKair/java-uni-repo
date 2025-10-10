package transports;

abstract class Transport {
    private String name;
    private int maxSpeed;
    private int capacity;

    public Transport(String name, int maxSpeed, int capacity){
        // General constructor template for others child classes
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void move(){

    }
    protected void stop(){

    }
}
