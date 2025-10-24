public class Ticket {
    // In real-world applications, usually this common Ticket attributes are visible to users
    public SectorType sector;
    public int seatNumber;
    public double price;
    public boolean isSold;

    // Parametrized Constrcutor
    public Ticket(SectorType sector, int seatNumber, double price, boolean isSold){
        this.sector = sector;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isSold = isSold;
    }


    // Formatted String Representation
    public String toString(){
        return "Sector Type: " + sector + "\nSeat Number: " + seatNumber + "\nPrice: " + price + "\n" + isSold;
    }
}
