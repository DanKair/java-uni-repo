public enum SectorType {
    VIP(StadiumConstants.VIP_PRICE),
    STUDENT(StadiumConstants.STUDENT_PRICE),
    STANDARD(StadiumConstants.STANDARD_PRICE);

    private final double basePrice;

    SectorType(double basePrice){
        this.basePrice = basePrice;
    }

    public double getBasePrice(){
        return basePrice;
    }
}
