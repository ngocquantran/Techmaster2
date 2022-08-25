package service;

import model.Customer;
import model.Gender;
import util.Util;
import util.Validate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {

    static Scanner scanner=new Scanner(System.in);

    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> customers=new ArrayList<>();
        customers.add(new Customer("KH123456","Nam", LocalDate.of(1996,8,20), Gender.MALE,"Hà Nam","0983658795","nam@gmail.com"));
        customers.add(new Customer("KH256984","Nga", LocalDate.of(1994,6,15), Gender.FEMALE,"Nam Định","0963589641","nga@gmail.com"));
        customers.add(new Customer("KH562845","Hoàng", LocalDate.of(1995,5,16), Gender.MALE,"Lào Cai","0922368125","hoang@gmail.com"));
        customers.add(new Customer("KH268954","Lan", LocalDate.of(1997,7,17), Gender.FEMALE,"Ninh Bình","0963896877","lan@gmail.com"));
        customers.add(new Customer("KH289657","Lâm", LocalDate.of(1992,4,18), Gender.MALE,"Hưng Yên","0989636999","lam@gmail.com"));
        customers.add(new Customer("KH258963","Vân", LocalDate.of(1991,3,11), Gender.FEMALE,"Hải Dương","0856145896","van@gmail.com"));
        customers.add(new Customer("KH258947","Trang", LocalDate.of(1998,9,5), Gender.FEMALE,"Bắc Ninh","0265896363","trang@gmail.com"));
        return customers;

    }

//    In dữ liệu arraylist
    public void showArraylist(ArrayList<?> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

//    Chọn giới tính để xem thông tin
    public Gender chooseGender(){
        Gender gender= Gender.FEMALE;
        System.out.println("1 - Khách hàng nam");
        System.out.println("2 - Khách hàng nữ");
        System.out.println("Lựa chọn của bạn là");
        boolean isContinue=true;
        while (isContinue){
            int choice= Validate.inputNumber();
            switch (choice){
                case  1:
                    gender= Gender.MALE;
                    isContinue=false;
                    break;
                case 2:
                    gender= Gender.FEMALE;
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }

        return gender;
    }

//    In dữ liệu khách hàng theo giới tính đã chọn
    public void showByGender(Gender gender, ArrayList<Customer> customers){
        for (Customer c:customers){
            if (c.getGender()==gender){
                System.out.println(c);
            }
        }
    }


//    Thêm 1 khách hàng mới
    public ArrayList<Customer> addCustomer(ArrayList<Customer> customers){

            System.out.println("Nhập mã khách hàng");
            String id= Util.isId();
            if (!Util.duplicateId(customers,id)){
                System.out.println("Nhập tên khách hàng");
                String name= scanner.nextLine();

                System.out.println("Nhập ngày sinh khách hàng (dd/MM/yyyy)");
                LocalDate birthday= Validate.isDateFormat();

                System.out.println("Chọn giới tính");
                Gender gender=chooseGender();

                System.out.println("Nhập quê quán");
                String address= scanner.nextLine();

                System.out.println("Nhập số điện thoại");
                String phoneNumber= Util.isPhoneNumber();

                System.out.println("Nhập email");
                String email= Util.isEmail();

                customers.add(new Customer(id,name,birthday,gender,address,phoneNumber,email));
            }
            else {
                System.out.println("Mã khách hàng đã tồn tại");
            }
        return customers;
    }

//    Tìm kiến khách hàng theo ID
    public int searchById(ArrayList<Customer> customers, String id){
        int found=0;
        int index=-1;
        for (int i=0;i< customers.size();i++){
           if (customers.get(i).getId().equals(id)){
               found++;
               index=i;
               break;
           }
        }
        if (found<1){
            System.out.println("Không có khách hàng này");
        } else {
            System.out.println(customers.get(index));
        }
        return index;
    }

//    Xóa thông tin khách hàng theo ID
    public ArrayList<Customer> removeCustomer(ArrayList<Customer> customers, int index){
        customers.remove(index);
        return customers;
    }

//    Cập nhật thông tin khách hàng theo id
    public ArrayList<Customer> updateCustomer(ArrayList<Customer> customers, int index){
        System.out.println("Nhập tên khách hàng");
        customers.get(index).setName(scanner.nextLine());

        System.out.println("Nhập ngày sinh khách hàng (dd/MM/yyyy)");
        customers.get(index).setBirthday(Validate.isDateFormat());

        System.out.println("Chọn giới tính");
        customers.get(index).setGender(chooseGender());

        System.out.println("Nhập quê quán");
        customers.get(index).setAddress(scanner.nextLine());

        System.out.println("Nhập số điện thoại");
        customers.get(index).setPhone(Util.isPhoneNumber());

        System.out.println("Nhập email");
        customers.get(index).setEmail(Util.isEmail());
        return customers;
    }

    public void countByGender(ArrayList<Customer>customers){
        Map<String,Integer> listCount=new HashMap<>();
        for (Customer c:customers){
            String str=c.getGender().getValue();
            if (listCount.get(str)==null){
                listCount.put(str,1);
            }
            else {
                listCount.put(str,listCount.get(str)+1);
            }

        }
        System.out.println(listCount);
    }

}
