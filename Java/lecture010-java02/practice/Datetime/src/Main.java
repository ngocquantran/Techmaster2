

public class Main {


    public static void main(String[] args){

        

//        Scanner sc=new Scanner(System.in);
//        System.out.println("Nhập số bất kỳ:");
//        int  rdNumber=sc.nextInt();
//
//        Random rd = new Random();
//        int rvNumber= rd.nextInt(100-80)+80;
//
//        String rs=rdNumber %2==0? rdNumber+" là số chẵn": rdNumber +" là số lẻ";
//        System.out.println(rs);
//        Scanner sc=new Scanner(System.in);
//
//        Random rd= new Random();
//        int a= rd.nextInt(100);
//        System.out.println("Số ngẫu nhiên:"+a);
//
//
//        System.out.println("Nhập số bất kỳ:");
//        int  Number=sc.nextInt();
//
//        String result=a==Number? "Hai số bằng nhau":"Hai số khác nhau";
//        System.out.println(result);

//        Scanner sc=new Scanner(System.in);
//        System.out.println("Nhập cạnh góc vuông thứ nhất:");
//        double canhvuong1=sc.nextDouble();
//
//        System.out.println("Nhập cạnh góc vuông thứ hai:");
//        double canhvuong2=sc.nextDouble();
//
//        double canhhuyen=Math.sqrt(canhvuong1*canhvuong1+canhvuong2*canhvuong2);
//        System.out.println("Chiều dài cạnh huyền là \n"+canhhuyen);

//        System.out.print("Xin chào");
//        System.out.print("Xin chào");
//
//        System.out.println("Xin chào");
//        System.out.println("Xin chào");
//
//        System.out.printf("kí tự %c, chuỗi %s, số nguyên %d\n",'a', "Chuỗi", 21);
//
//
//        System.out.printf("%s%d%s\n", "Quân",25, "Hà Nam");
//        System.out.printf("%s%d%s\n", "Hà",26, "Nam Định");
//        System.out.printf("%s%d%s\n", "Nam",25, "Bắc Ninh");

//        int i=5;
//        int j=++i;
//        System.out.println(i);
//        System.out.println(j);

//ScannerExample.usingScanner();

//        LocalDate toDay=LocalDate.now();
//        System.out.println(toDay);
//
//        System.out.println(toDay.getDayOfMonth());
//        System.out.println(toDay.getDayOfWeek());
//        System.out.println(toDay.getDayOfYear());
//
//        System.out.println(toDay.getMonthValue());
//        System.out.println(toDay.getMonth());
//
//        System.out.println(toDay.getYear());
//
//        System.out.println("Ngày mai: "+toDay.plusDays(1));
//        System.out.println("Hôm qua:"+toDay.minusDays(1));
//
//        LocalDate date=LocalDate.of(2021, 12,20);
//        System.out.println(date);
//
//        LocalDate currentDate=LocalDate.of(2021, Month.DECEMBER,25);
//        System.out.println(currentDate);

//        LocalTime time=LocalTime.now();
//        System.out.println(time);
//
//        LocalTime time2=LocalTime.of(23,20,59);
//        System.out.println(time2);
//
//        System.out.println(time.getHour());
//        System.out.println(time.getMinute());
//
//        System.out.println(time.plusMinutes(100));

//        LocalDateTime dateTime=LocalDateTime.now();
//        System.out.println(dateTime);
//
//        LocalDateTime dateTime3=LocalDateTime.of(2021,12,15,14,25,59);
//        System.out.println(dateTime3);
//
//        DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        System.out.println(dateTime.format(myFormat));
//
//
//        System.out.println("\"Xin \n chào\"");
//
//        System.out.println(div(9,4));
//        int[] myArray ={3,5,0,8,-6,8,7,10};
//        System.out.println(myArray[4]);
//        for (int i=0; i< myArray.length;i++){
//            System.out.println("Phần tử thứ "+i+": "+myArray[i]);
//        }

//        int[] myArray = {3,5,7,30,10,5,8,23,0,-5};

//        int sum=0;
//        for (int i=0;i<myArray.length;i++){
//            sum+=myArray[i];
//        }
//        System.out.println("Tổng các giá trị phần tử là "+sum);
//        System.out.println("Trung bình cộng các giá trị phần tử là "+sum/ myArray.length);
//
//        boolean isFound=false;
//        for (int i=0;i<myArray.length;i++){
//            if (myArray[i]<=0){
//                System.out.println(i);
//                isFound=true;
//            }
////        }
//        if(!isFound){
//         System.out.println("Could not file the position you need");}
//        int[] myArray = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
//        for (int i=0; i< myArray.length - 1;i++) {
//            for (int j=i;j<= myArray.length -1;j++){
//                if (myArray[i]>myArray[j]){
//                    int temp;
//                    temp=myArray[i];
//                    myArray[i]=myArray[j];
//                    myArray[j]=temp;
//                }
//            }
//
//        }
//         for (int i=0; i< myArray.length;i++){
//             System.out.print(myArray[i]+", ");
//         }


//        int[] myArray = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
//        for (int i = 0; i < myArray.length - 1; i++) {
//            for (int j = i; j <= myArray.length - 1; j++) {
//                if (myArray[i] > myArray[j]) {
//                    // Thao tác này đổi chỗ 2 giá trị ở 2 vị trí i, j của mảng
//                    int temp;
//                    temp = myArray[i];
//                    myArray[i] = myArray[j];
//                    myArray[j] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < myArray.length; i++) {
//            System.out.print(myArray[i] + " ");
//        }
        int[] myArray = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
        int sum=0;
        double avg;
        for (int i:myArray){
            sum+=i;
        }
        avg= sum/myArray.length;
        System.out.println(sum);
        System.out.println(avg);


    }

}
