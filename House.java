import java.util.Objects;
import java.util.Scanner;

public class House extends Property {

    public int FloorNo;


    public House() {
        super(" ", 0, 0);
        FloorNo = 0;
    }

    public House(String location, double price, double area, int floorNo) {
        super(location, price, area);
        this.FloorNo = floorNo;

    }

    public int getFloorNo() {
        return FloorNo;
    }

    public void setFloorNo(int floorNo) {
        FloorNo = floorNo;
    }




    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("- floor number : " +FloorNo);
        System.out.println("===============================");
    }

    @Override
    public String toString() {
        return super.toString() +
                "FloorNo=" + FloorNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return FloorNo == house.FloorNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(FloorNo);
    }
}
