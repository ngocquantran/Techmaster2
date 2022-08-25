public class CarService {
    public static void createCar(){
        Car car1=new Car("Ertiga","Red","Maruti");
        Car car2=new Car("XUV 500", "Black","Mahindra");
        Car car3=new Car("CX5","White","Mazda");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

//        car1.setModel("SUV");
//
//        System.out.println(car1);
        System.out.println(car1.getModel());



    }
}
