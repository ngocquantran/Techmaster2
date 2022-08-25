import java.util.Formattable;
import java.util.Scanner;

public class Service {
    public Account getAccount(){
        Account account=new Account("0962367123","12345678",5000000);
        return account;
    }

    public void showBalance(Account account){
        System.out.println("Số dư hiện tại là: "+account.getAccountBalance());
    }

    public boolean signIn(String phoneNumber, String password, Account account){

        Scanner scanner=new Scanner(System.in);
        boolean isContinue=true;
        while (isContinue){
            System.out.println("Nhập số điện thoại");
            phoneNumber= scanner.nextLine();
            if (phoneNumber.equals(account.getPhoneNumber())){
                isContinue=false;
            }else {
                System.out.println("Số điện thoại không đúng");
            }
        }
        boolean isContinue2=true;
        while (isContinue2){
            System.out.println("Nhập password");
            password= scanner.nextLine();
            if (password.equals(account.getPassword())){
                isContinue2=false;
            }else {
                System.out.println("Mật khẩu không đúng");
            }
        }
        return true;
    }

    public Bank chooseBank(){
        Bank bank=Bank.BIDV;
        for (Bank b:Bank.values()){
            System.out.println(b.value+" - "+b);
        }
        System.out.println("Lựa chọn của bạn là");
        Scanner scanner=new Scanner(System.in);
        int choice=Integer.parseInt(scanner.nextLine());
        for (Bank b:Bank.values()){
            if (choice==b.value){
              bank=b;
            }
        }
        return bank;
    }



}
