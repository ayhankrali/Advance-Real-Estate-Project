package models;

public class Property {
    private String offerNumber ;
    private PropertyType type;
    private int size;
    private String yearCreated; // not required
    private double priceBGN;
    private double priceEUR; //not required
    private boolean isActive; //not required
    private boolean isDeposited; //not required
    private int floor; //not required
    private String imageName; // Not required

    public Property(String offerNumber, PropertyType type, int size, double priceBGN) {
        this.offerNumber = offerNumber;
        this.type = type;
        this.size = size;
        this.priceBGN = priceBGN;
        this.yearCreated = "Not specified";
        this.priceEUR = 0.0;
        this.isActive = true;
        this.isDeposited = false;
        this.floor = 0;
        this.imageName = "";
    }
    public String getPropertyType() {
        switch (this.type) {
            case FLAT: return "Flat";
            case HOUSE: return "House";
            case LAND: return "Land";
            default: return "Unknown";
        }
    }
    public String getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }

    public double getPriceBGN() {
        return priceBGN;
    }

    public void setPriceBGN(double priceBGN) {
        this.priceBGN = priceBGN;
    }

    public double getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeposited() {
        return isDeposited;
    }

    public void setDeposited(boolean deposited) {
        isDeposited = deposited;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}

