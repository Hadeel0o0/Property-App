import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Control {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Property> propertyArrayList;

    //تهيئة المصفوفه
    public Control() {
        propertyArrayList = new ArrayList<Property>();
        readpropertyFile();
    }

    //بناء كائن من نوع منزل ومن ثم إضافته الى المصفوفه
    public  boolean add_Property(String location, double price, double area,int floorNo ,int id ) {
        House new_house = new House( location,  price,  area,floorNo);
        new_house.setProperty_id( Enter_id(id) );
        /// بتظهر الرساله في مربع حوار صغير
        System.out.println("The id of property ( " + new_house.getProperty_id() + " )  \n NOTE : Keep the id to can be able for modifying later.");
        // معلومات المالك
        return propertyArrayList.add(new_house);
        //ممكن نعمل زر يستدعي داله اذا يشتي يشوف الي اضافه
    }

    public  void owner(){}////////////////////////////////////////


    //بناء كائن من نوع أرض ومن ثم إضافته الى المصفوفه
    public  boolean add_Property(String location, double price, double area, String location_street, int id) {
        Land new_land=new Land( location,  price,  area,  location_street);
        new_land.setProperty_id(Enter_id(id));
        /// بتظهر الرساله في مربع حوار صغير
        System.out.println("The id of property ( " + new_land.getProperty_id() + " )  \n NOTE : Keep the id to can be able for modifying later.");
        // معلومات المالك
        return propertyArrayList.add(new_land);
        //ممكن نعمل زر يستدعي داله اذا يشتي يشوف الي اضافه
    }




    


    // propertyArrayList.indexOf(propertyArrayList.get(i));

    //دالة مساعده منفصله تقوم بإدخال ال id للعقار مع التأكد من انه يتكون من 6 ارقام
    public static int Enter_id(int id) {                                 //علامه
        do {
            if (id <= 999999 && id >= 99999) {
                break;
            } else {
                System.out.println("6 numbers !"); /// بتظهر الرساله في مربع حوار صغير
                id = in.nextInt(); // هل بيمسح الحقل ويعبيه من جديد
            }
        } while (true);

        return id;
    }

    //داله مساعده منفصله تقوم ب إرجاع ال index الذي يحتوي على id المدخل + إتاحة 3 فرص لإدخاله في حال لم يطابق اي من id المخزنه _تحسبا بإنه قام بخطأ في الإدخال_
    public static int search_index_id(int id) {
        int index = -1, tries = 0;
        do {
            id = in.nextInt();
            tries++;
            for (int i = 0; i < propertyArrayList.size(); i++) {
                if (propertyArrayList.get(i).getProperty_id() == id) {
                    index = i;
                    return index;
                } else
                    System.out.println("invalid ID !.. Enter again :"); /// بتظهر الرساله في مربع حوار صغير
                id = in.nextInt(); //هل بيمسح الحقل ويعبيه من جديد
            }
        } while (tries < 3);

        System.out.println("Sorry the id [ " + id + " ] is not exit.");

        return -1;
    }

    

   





    public  void search_price(double priceSearch){
        int flag=0;
        double  search_price = priceSearch;
            for (int i = 0; i < propertyArrayList.size(); i++) {
                if (propertyArrayList.get(i).getPrice() == search_price) {
                    propertyArrayList.get(i).displayDetails();
                    flag = 1;
                }
            }
                    if(flag == 0 )
                    System.out.println("Sorry no property with  "+search_price+" price");

    }

    public  void search_area(double areaSearch){
        int flag=0;
        double search_area = areaSearch;
        for (int i = 0; i < propertyArrayList.size(); i++) {
            if (propertyArrayList.get(i).getArea() == search_area) {
                propertyArrayList.get(i).displayDetails();
                flag = 1;
            }
        }
        if(flag == 0 )
            System.out.println("Sorry no property with  "+search_area+" area");
  
}

    void add(String zz, double d, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void readpropertyFile ()
      {
        System.out.println("the read property : ");
        try {
            Scanner in= new Scanner(new File("D:\\property.txt"));
            while (in.hasNext())
            {
                String location= in.next();
                double price=in.nextDouble();
                double area=in.nextDouble();
                int floorNo=in.nextInt();
                int id=in.nextInt();
                add_Property(location , price ,area , floorNo ,id);

            }
            in.close();
        } catch (FileNotFoundException new_house) {
            JOptionPane.showMessageDialog(null,"Error in reading file "+new_house.getMessage());        }
    }

    /**
     *
     * @return
     */
    public boolean writeproperty()
    {


        try{
            PrintWriter writer= new PrintWriter(new File("D:\\property.txt"));

            for (Property x:propertyArrayList) {

                writer.write(x.getLocation()+" "+x.getPrice()+" "+x.getArea());
            }
            writer.close();


        } catch (FileNotFoundException p) {
            p.printStackTrace();
        }
        return true;
    }
}