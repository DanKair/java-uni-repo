package VolumeAreaCalculator;

abstract class Figure {
    private String name;

    // Default Constructor
    public Figure(){
        this.name = "None";
    }

    // Parametrized Constructor
    public Figure(String name){
        this.name = name;
    }


    // Getters methods
    public String getName(){
        return this.name;
    }


    // Abstract methods
    public abstract void calculateArea();
    public abstract void calculateVolume();


}
