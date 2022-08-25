package control;

import model.*;
import service.ProductService;
import util.Util;
import util.Validate;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class StaffController {
    static Scanner scanner=new Scanner(System.in);
    public static void staffMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Xem gian hàng");
        System.out.println("2 - Xem danh sách khách hàng");
        System.out.println("3 - Xem danh sách đơn hàng");
        System.out.println("4 - Quản lý sản phẩm");
        if (Controller.activeAccount.getRole()==AccountRole.Admin){
            System.out.println("5 - Quản lý nhân viên");
        }
        System.out.println("0 - Đăng xuất");
    }

    public static void staffProgram(){
        boolean isContinue=true;
        while (isContinue){
            staffMenu();
            int choice= Validate.inputNumber();
            switch (choice){
                case 1:
                    Controller.productTypeProgram();
                    break;
                case 2:
                    Controller.productService.showArraylist(Controller.customers);
                    break;
                case 3:
                    viewOrderProgram();
                    break;
                case 4:
                    productManagementProgram();
                    break;
                case 5:
                    if (Controller.activeAccount.getRole()==AccountRole.Admin){
                        staffManagementProgram();
                    }else {
                        System.out.println("Không có lựa chọn này");
                    }

                    break;
                case 0:
                    Controller.activeAccount=new Account("","","",AccountRole.Visitor,"");
                    Controller.program();
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }
    }

    public static void viewOrderMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Xem toàn bộ đơn hàng");
        System.out.println("2 - Xem đơn hàng theo khách hàng");
        System.out.println("3 - Xem đơn hàng theo ngày");
        System.out.println("0 - Trở về");
    }

    public static void viewOrderProgram(){
        boolean isContinue=true;
        while (isContinue){
            viewOrderMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    Controller.productService.showArraylist(Controller.purchaseHistories);
                    break;
                case 2:
                    System.out.println("Nhập mã khách hàng");
                    String customerId= scanner.nextLine();
                    if (Controller.customerService.isCustomerIdAvailable(Controller.accounts,customerId)){
                        Controller.purchaseHistories.stream().filter(purchaseHistory -> purchaseHistory.getCustomerId().equals(customerId))
                                .forEach(purchaseHistory -> System.out.println(purchaseHistory));
                    }
                    else {
                        System.out.println("Không có khách hàng này. Kiểm tra lại danh sách khách hàng");
                    }
                    break;
                case 3:
                    System.out.println("Nhập ngày cần xem đơn hàng (dd/MM/yyyy)");
                    LocalDate date= Validate.inputDateFormat();
                    int found=0;
                    for (PurchaseHistory p:Controller.purchaseHistories){
                        if (p.getDate().equals(date)){
                            System.out.println(p);
                            found++;
                        }
                    }
                    if (found<1){
                        System.out.println("Không có đơn hàng trong ngày "+ Util.FormatDate(date));
                    }
                    break;
                case 0:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }
    }
    public static void modifyProductMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Sửa tên sản phẩm");
        System.out.println("2 - Sửa thương hiệu sản phẩm");
        System.out.println("3 - Sửa loại sản phẩm");
        System.out.println("4 - Sửa ngày nhập sản phẩm");
        System.out.println("5 - Sửa ngày sản xuất");
        System.out.println("6 - Sửa hạn sử dụng");
        System.out.println("7 - Sửa số lượng nhập sản phẩm");
        System.out.println("8 - Sửa số lượng sản phẩm đã bán");
        System.out.println("9 - Sửa xuất sứ");
        System.out.println("10 - Sửa giá sản phẩm");
        System.out.println("0 - Trở về");
    }

    public static void modifyProductProgram(Product product){
        boolean isContinue=true;
        while (isContinue){
            modifyProductMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    String oldName= product.getName();
                    ActionHistory action1=getCurrentAction(product);

                    System.out.println("Nhập tên mới");
                    String newName= scanner.nextLine();
                    product.setName(newName);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi

                    action1.setAction("Sửa tên sản phẩm");
                    action1.setDescription("Tên cũ: "+oldName+" - Tên mới: "+newName);
                    Controller.actionHistories.add(action1);
                    break;
                case 2:
                    String oldBrand= product.getBrand();

                    System.out.println("Nhập thương hiệu sản phẩm mới");
                    String newBrand= scanner.nextLine();
                    product.setBrand(newBrand);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

                    //                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action2=getCurrentAction(product);
                    action2.setAction("Sửa thương hiệu sản phẩm");
                    action2.setDescription("Thương hiệu cũ: "+oldBrand+" - Thương hiệu mới: "+newBrand);
                    Controller.actionHistories.add(action2);
                    break;
                case 3:
                    ProductCategory oldCategory=product.getProductCategory();

                    System.out.println("Chọn loại mặt hàng mới");
                    for (ProductCategory p:ProductCategory.values()){
                        System.out.println(p.getNumber()+" - "+p.getValue());
                    }
                    ProductCategory newCategory=Controller.productService.chooseProductCategory();

                    product.setProductCategory(newCategory);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action3=getCurrentAction(product);
                    action3.setAction("Sửa loại mặt hàng sản phẩm");
                    action3.setDescription("Loại hàng cũ: "+oldCategory+" - Loại mới: "+newCategory);
                    Controller.actionHistories.add(action3);
                    break;
                case 4:
                    LocalDate oldDate=product.getReceiptDate();

                    System.out.println("Nhập ngày nhập sản phẩm về kho mới");
                    LocalDate newReceiptDate=Validate.inputDateFormat();
                    product.setReceiptDate(newReceiptDate);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action4=getCurrentAction(product);
                    action4.setAction("Sửa ngày nhập sản phẩm");
                    action4.setDescription("Ngày nhập cũ: "+oldDate+" - Ngày nhập mới: "+newReceiptDate);
                    Controller.actionHistories.add(action4);
                    break;
                case 5:
                    LocalDate oldMfg=product.getMfg();

                    System.out.println("Nhập ngày sản xuất mới");
                    LocalDate newMfg=Validate.inputDateFormat();
                    product.setMfg(newMfg);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action5=getCurrentAction(product);
                    action5.setAction("Sửa ngày sản xuất sản phẩm");
                    action5.setDescription("Ngày sản xuất cũ: "+oldMfg+" - Ngày sản xuất mới: "+newMfg);
                    Controller.actionHistories.add(action5);
                    break;
                case 6:
                    int oldExp=product.getExp();

                    System.out.println("Nhập hạn sử dụng (tháng) mới");
                    int newExp=Validate.inputNumberBiggerThanZero();
                    product.setExp(newExp);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action6=getCurrentAction(product);
                    action6.setAction("Sửa hạn sử dụng sản phẩm");
                    action6.setDescription("Hạn sử dụng cũ: "+oldExp+" - Hạn sử dụng mới: "+newExp);
                    Controller.actionHistories.add(action6);
                    break;
                case 7:
                    int oldQuantity=product.getQuantity();

                    System.out.println("Nhập số lượng sản phẩm nhập mới");
                    int newQuantity=Validate.inputNumberBiggerThanZero();
                    product.setQuantity(newQuantity);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action7=getCurrentAction(product);
                    action7.setAction("Sửa số lượng sản phẩm");
                    action7.setDescription("Số lượng cũ: "+oldQuantity+" - Số lượng mới: "+newQuantity);
                    Controller.actionHistories.add(action7);
                    break;
                case 8:
                    int oldSoldQuantity=product.getSoldQuantity();

                    System.out.println("Nhập số lượng đã bán");
                    int newSoldQuanity=Validate.inputInLimit(0,product.getQuantity());
                    product.setSoldQuantity(newSoldQuanity);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action8=getCurrentAction(product);
                    action8.setAction("Sửa số lượng đã bán sản phẩm");
                    action8.setDescription("Số lượng cũ: "+oldSoldQuantity+" - Số lượng mới: "+newSoldQuanity);
                    Controller.actionHistories.add(action8);
                    break;
                case 9:
                    String oldOrigin= product.getOrigin();

                    System.out.println("Nhập xuất xứ sản phẩm mới");
                    String newOrigin= scanner.nextLine();
                    product.setOrigin(newOrigin);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action9=getCurrentAction(product);
                    action9.setAction("Sửa xuất sứ sản phẩm");
                    action9.setDescription("Xuất xứ cũ: "+oldOrigin+" - Xuất sứ mới: "+newOrigin);
                    Controller.actionHistories.add(action9);
                    break;
                case 10:
                    long oldPrice=product.getPrice();

                    System.out.println("Nhập giá mới");
                    long newPrice=Validate.inputLongNumber();
                    product.setPrice(newPrice);
                    System.out.println("Sản phẩm sau khi sửa:");
                    System.out.println(product);

//                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action10=getCurrentAction(product);
                    action10.setAction("Sửa giá sản phẩm");
                    action10.setDescription("Giá cũ: "+oldPrice+" - Giá mới: "+newPrice);
                    Controller.actionHistories.add(action10);
                    break;
                case 0:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }
    }

    public static void productManagementMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Sửa thông tin sản phẩm");
        System.out.println("2 - Thêm sản phẩm mới");
        System.out.println("3 - Xóa sản phẩm");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");

    }

    public static void productManagementProgram(){
        boolean isContinue=true;
        while (isContinue){
            productManagementMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập id sản phẩm");
                    String id= scanner.nextLine().trim();
                    if (!Validate.duplicateProductId(Controller.products,id)){
                        System.out.println("Không có sản phẩm này");
                        System.out.println("Vui lòng kiểm tra lại gian hàng");
                    }
                    else {
                        Product product=Controller.productService.searchProductId(Controller.products,id);
                        System.out.println(product);
                        modifyProductProgram(product);
                    }
                    break;
                case 2:
                    String newId="";
                    boolean repeat=true;
                    while (repeat){
                        newId=Util.randomProductId();
                        repeat=Validate.duplicateProductId(Controller.products,newId);
                    }

                    System.out.println("Nhập tên sản phẩm");
                    String newName= scanner.nextLine();

                    System.out.println("Nhập thương hiệu sản phẩm");
                    String newBrand= scanner.nextLine();

                    System.out.println("Chọn loại mặt hàng");
                    for (ProductCategory p:ProductCategory.values()){
                        System.out.println(p.getNumber()+" - "+p.getValue());
                    }

                    ProductCategory newCategory=Controller.productService.chooseProductCategory();


                    System.out.println("Nhập ngày nhập sản phẩm về kho");
                    LocalDate newReceiptDate=Validate.inputDateFormat();

                    System.out.println("Nhập ngày sản xuất");
                    LocalDate newMfg=Validate.inputDateFormat();

                    System.out.println("Nhập hạn sử dụng (tháng)");
                    int newExp=Validate.inputNumberBiggerThanZero();

                    System.out.println("Nhập số lượng nhập sản phẩm");
                    int newQuantity=Validate.inputNumberBiggerThanZero();

                    int newSoldQuantity=0;

                    System.out.println("Nhập xuất xứ sản phẩm");
                    String newOrigin= scanner.nextLine();

                    System.out.println("Nhập giá");
                    long newPrice=Validate.inputLongNumber();

                    Product newProduct=new Product(newId,newName,newBrand,newCategory,newReceiptDate,newMfg,newExp,newQuantity,newSoldQuantity,newOrigin,newPrice);
                    Controller.products.add(newProduct);
                    System.out.println("Tạo sản phẩm thành công");
                    System.out.println(newProduct);

                    //                    Thêm tác vụ vào lịch sử theo dõi
                    ActionHistory action1=getCurrentAction(newProduct);
                    action1.setAction("Thêm mới sản phẩm");
                    action1.setDescription("Thông tin sản phẩm: "+newProduct.toString());
                    Controller.actionHistories.add(action1);

                    break;
                case 3:
                    Product oldProduct=null;
                    System.out.println("Nhập id sản phẩm");
                    String removeId= scanner.nextLine().trim();
                    if (!Validate.duplicateProductId(Controller.products,removeId)){
                        System.out.println("Không có sản phẩm này");
                        System.out.println("Vui lòng kiểm tra lại gian hàng");
                    }
                    else {
                        for (int i=0;i<Controller.products.size();i++){
                            if (Controller.products.get(i).getId().equals(removeId)){
                                oldProduct=Controller.products.get(i);

                                Controller.products.remove(i);

//                                Thêm tác vụ vào lịch sử theo dõi
                                ActionHistory action2=getCurrentAction(oldProduct);
                                action2.setAction("Xóa sản phẩm");
                                action2.setDescription("Sản phẩm đã xóa: "+oldProduct.toString());
                                Controller.actionHistories.add(action2);
                                break;
                            }
                        }
                    }
                    System.out.println("Xóa thành công");

//
                    break;

                case 0:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public static void staffManagementMenu(){
        System.out.println("--------------------------------");
        System.out.println("1 - Xem danh sách nhân viên");
        System.out.println("2 - Thêm nhân viên");
        System.out.println("3 - Xóa nhân viên");
        System.out.println("4 - Khóa tài khoản nhân viên");
        System.out.println("5 - Truy xuất tác vụ");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void staffManagementProgram(){
        boolean isContinue=true;
        while (isContinue){
            staffManagementMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Danh sách nhân viên");
                    Controller.accounts.stream().filter(account -> account.getRole()==AccountRole.Staff)
                            .forEach(account -> System.out.println(account));
                    break;
                case 2:
                    String id="";
                    boolean repeat=true;
                    while (repeat){
                        id=Util.randomStaffId();
                        if (!Validate.duplicateAccountId(Controller.accounts,id)){
                            repeat=false;
                        }
                    }

                    String phoneNumber="";
                    System.out.println("Nhập số điện thoại");
                    boolean repeat2 = true;
                    while (repeat2) {
                        phoneNumber = Validate.isPhoneNumber();
                        repeat2 = Validate.duplicatePhoneNumber(Controller.accounts, phoneNumber);
                    }

                    System.out.println("Nhập mật khẩu");
                    String password=Controller.accountService.passwordInput();

                    System.out.println("Nhập họ tên");
                    String name= scanner.nextLine();

                    Account newAccount=new Account(id,phoneNumber,password,AccountRole.Staff,name);
                    System.out.println("Tạo nhân viên mới thành công");
                    System.out.println(newAccount);

                    Controller.accounts.add(newAccount);
                    break;

                case 3:
                    System.out.println("Nhập id nhân viên");
                    String removeId= scanner.nextLine();
                    int found=0;
                    for (int i=0;i<Controller.accounts.size();i++){
                        if (Controller.accounts.get(i).getId().equals(removeId) && Controller.accounts.get(i).getRole()==AccountRole.Staff){
                            Controller.accounts.remove(i);
                            System.out.println("Xóa thành công");
                            found++;
                            break;
                        }
                    }
                    if (found<1){
                        System.out.println("Không tồn tại id này");
                    }
                    break;
                case 4:
                    System.out.println("Nhập id nhân viên");
                    String lockId= scanner.nextLine();
                    int found2=0;
                    for (int i=0;i<Controller.accounts.size();i++){
                        if (Controller.accounts.get(i).getId().equals(lockId) && Controller.accounts.get(i).getRole()==AccountRole.Staff){
                            Controller.accounts.get(i).setRole(AccountRole.Visitor);
                            Controller.accounts.get(i).setPassword("!@#$%^&*(");
                            System.out.println("Khóa tài khoản thành công");
                            found2++;
                            break;
                        }
                    }
                    if (found2<1){
                        System.out.println("Không tồn tại id này");
                    }
                    break;
                case 5:
                    System.out.println("Lịch sử tác vụ");
                    Controller.productService.showArraylist(Controller.actionHistories);
                    break;
                case 0:
                    isContinue=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;




            }
        }

    }

    public static ActionHistory getCurrentAction(Product product){
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();
        String staffId=Controller.activeAccount.getId();
        String staffName=Controller.activeAccount.getName();
        String productIt= product.getId();
        String productName=product.getName();
        return new ActionHistory(date,time,staffId,staffName,productIt,productName,"","");
    }
}
