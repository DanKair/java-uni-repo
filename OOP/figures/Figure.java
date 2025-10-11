package figures;

abstract class Figure {
    private String name;
    private String color;

    // Default Constructor
    public Figure(){
        this.name = "None";
        this.color = "White";
    }

    // Parametrized Constructor
    public Figure(String name, String color){
        this.name = name;
        this.color = color;
    }


    // Getters methods
    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    // Abstract methods
    public void calculateArea(){};
    public void calculatePerimeter(){};


}
