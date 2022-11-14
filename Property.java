import java.util.Objects;

public class Property {
    private String location;
    private double price;
    private double area;
    private int Property_id  ;

    private String ownerName;

    private int  ownerPhone ;


    public Property(String location, double price, double area  ) {
        this.location = location;
        this.price = price;
        this.area = area;
        this.Property_id=0;
        ownerName=" ";
        ownerPhone=0;
    }

    public Property() {
        this.location = " ";
        this.price = 0;
        this.area = 0;
    }

     public void setProperty_id(int Property_id){
        this.Property_id=Property_id;
     }

    public int getProperty_id() {
        return Property_id;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(int ownerPhone) {
        this.ownerPhone = ownerPhone;
    }


    public void new_Property(){ }
    public void displayDetails()
    {
        System.out.println("The Details of the Property :"
        +"- Property_id : "+ Property_id+"\n"+"- location : " +location
        +"- price : " + price+"\n"+"- area : " + area);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.price, price) == 0 && Double.compare(property.area, area) == 0 && Property_id == property.Property_id 
                && ownerPhone == property.ownerPhone && Objects.equals(location, property.location) && Objects.equals(ownerName, property.ownerName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, price, area, Property_id, ownerName, ownerPhone);
    }
}
