public class Main {
    public static void main(String[] args) {
//        HinhTron hinhTron=new HinhTron();
//        hinhTron.showName();
//        hinhTron.radiusInput();
//        hinhTron.getPerimeter();
//        hinhTron.showPerimeter();
//        hinhTron.getArea();
//        hinhTron.showArea();
//
//        HinhTru hinhTru=new HinhTru();
//        hinhTru.showName();
//        hinhTru.heightInput();
//        hinhTru.getVolume();
//        hinhTru.showVolume();
//        HinhTron hinhTron=new HinhTron(5);
//        hinhTron.getPerimeter();
//        hinhTron.getArea();
//        HinhTru hinhTru=new HinhTru(5,6);
//        hinhTru.getVolume();
//
//        hinhTron.xuatThongTin();
//        hinhTru.xuatThongTin();

        HinhTron hinhTron1=new HinhTron();
        HinhTru hinhTru1=new HinhTru();
        HinhTru hinhTru2=new HinhTru();
        HinhTru hinhTru4=new HinhTru();
        HinhTru hinhTru3=new HinhTru();
        HinhTron hinhTron2=new HinhTron();

        if (HinhHoc.dem>Configs.max){
            System.out.println("Bạn đã khai báo vượt số lượng hình cho phép");
            System.out.println("Số lượng hình học tối thiểu là: "+Configs.min);
            System.out.println("Số lượng hình học tối đa là: "+Configs.max);
        }
        else {
            System.out.println("Số lượng hình học đã khai báo là: "+HinhHoc.dem);
        }





    }
}
