import java.util.Objects;
import java.util.Scanner;

public class Land extends  Property{
    private   String  Location_street ;

    public Land(String location, double price, double area, String location_street) {
        super(location, price, area);
        Location_street = location_street;
    }
    public Land(){
        super(" ", 0, 0);
        Location_street=" ";
    }

    public String getLocation_street() {
        return Location_street;
    }

    public void setLocation_street(String location_street) {
        Location_street = location_street;
    }
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("- street Location: " +Location_street);
        System.out.println("===============================");

    }


    @Override
    public String toString() {
        return super.toString() +
                "Location_street='" + Location_street + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Land land = (Land) o;
        return Objects.equals(Location_street, land.Location_street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Location_street);
    }
}
