package service;

import model.*;
import util.Util;
import util.Validate;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
    public ArrayList<Product> getAllPowdered(){
        ArrayList<Product> powderedMilk=new ArrayList<>();
        powderedMilk.add(new Product("MI111111","Sữa bột Similac 5HMOs số 1 - 900g (0 - 6 tháng tuổi)","Abbott", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,10,"Ireland",589000));
        powderedMilk.add(new Product("MI111112","Sữa bột Similac 5HMOs số 3 - 900g (1 - 2 tuổi)","Abbott", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,20,"Ireland",502000));
        powderedMilk.add(new Product("MI111113","Sữa bột Similac 5HMOs số 2 - 900g (6 - 12 tháng tuổi)","Abbott", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,15,"Ireland",577000));
        powderedMilk.add(new Product("MI111114","Sữa Aptamil Profutura Follow On số 2 800g (6 - 12 tháng tuổi)","Aptamil", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,25,"Ireland",680000));
        powderedMilk.add(new Product("MI111115","Sữa Aptamil Đức số 2 800g (6 - 12 tháng tuổi)","Aptamil", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,30,"Ireland",560000));
        powderedMilk.add(new Product("MI111116","Sữa Aptamil New Zealand số 1 900g (0 - 12 tháng tuổi)","Aptamil", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,35,"Newzealand",625000));
        powderedMilk.add(new Product("MI111117","Sữa Aptamil Profutura Úc số 2 - 900g (6 - 12 tháng)","Aptamil", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,22,"Úc",960000));
        powderedMilk.add(new Product("MI111118","Sữa PediaSure BA 850g (1 - 10 tuổi)","PediaSure", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,40,"Singapore",603000));
        powderedMilk.add(new Product("MI111119","Sữa PediaSure BA 1.6 kg (1 - 10 tuổi)","PediaSure", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,5,"Singapore",1039000));
        powderedMilk.add(new Product("MI111120","Sữa PediaSure BA vị dâu 400g (1 - 10 tuổi)","PediaSure", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,35,"Singapore",291000));
        powderedMilk.add(new Product("MI111121","Sữa I Am Mother số 4 800g (1 - 3 tuổi)","Namyang", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,36,"Hàn Quốc",791000));
        powderedMilk.add(new Product("MI111122","Sữa I Am Mother số 3 800g (6 - 12 tháng)","Abbott", ProductCategory.powdered, LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),36,100,28,"Hàn Quốc",760000));

        return powderedMilk;
    }

    public ArrayList<Product> getAllFreshMilk(){
        ArrayList<Product> freshMilk=new ArrayList<>();
        freshMilk.add(new Product("MI211111","Sữa hạt óc chó 137 Degrees truyền thống 180ml","137 Degrees", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,250,"Thái Lan",28000));
        freshMilk.add(new Product("MI211112","Sữa hạt óc chó 137 Degrees truyền thống 1l","137 Degrees", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,150,"Thái Lan",125000));
        freshMilk.add(new Product("MI211113","Sữa hạt hạnh nhân 137 Degrees truyền thống 1l","137 Degrees", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,160,"Thái Lan",102000));
        freshMilk.add(new Product("MI211114","Sữa hạt hạnh nhân 137 Degrees truyền thống 180ml","137 Degrees", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,180,"Thái Lan",23000));
        freshMilk.add(new Product("MI211115","Sữa tươi tiệt trùng nguyên chất TH True Milk 110ML","TH True Milk", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,295,"Việt Nam",5500));
        freshMilk.add(new Product("MI211116","Sữa tươi tiệt trùng nguyên chất TH True Milk 180ML","TH True Milk", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,260,"Việt Nam",8250));
        freshMilk.add(new Product("MI211117","Sữa tươi tiệt trùng socola TH True Milk 110ml","TH True Milk", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,170,"Việt Nam",5500));
        freshMilk.add(new Product("MI211118","Sữa tươi tiệt trùng socola TH True Milk 180ML","TH True Milk", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,50,"Việt Nam",8250));
        freshMilk.add(new Product("MI211119","Sữa đêm Fruto ngũ cốc 200ml 6m+","Frutonyanya", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,65,"Nga",42000));
        freshMilk.add(new Product("MI211120","Sữa đêm Fruto vị gạo sữa 200ml 6m+","Frutonyanya", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,185,"Nga",42000));
        freshMilk.add(new Product("MI211121","Sữa lắc Fruto vị chuối 200ml 12m+","Frutonyanya", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,210,"Nga",38000));
        freshMilk.add(new Product("MI211122","Sữa chua yến mạch Fruto vị táo mâm xôi việt quất 200ml (Trên 6 tháng tuổi)","Frutonyanya", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,222,"Nga",41000));
        freshMilk.add(new Product("MI211123","Sữa Fruto tăng canxi uống đêm 200ml (Trên 8 tháng)","Frutonyanya", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,60,"Nga",35000));
        freshMilk.add(new Product("MI211124","Sữa nước ngũ cốc Alete vị chuối 200mlx2 10m+","Alete", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,112,"Đức",95000));
        freshMilk.add(new Product("MI211125","Sữa nước ngũ cốc Alete vị mật ong 200mlx2 10m+","Alete", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,80,"Đức",95000));
        freshMilk.add(new Product("MI211126","Sữa bò hữu cơ Koita ít béo 1L","Koita", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,33,"Ý",81000));
        freshMilk.add(new Product("MI211127","Sữa yến mạch Koita 1L","Koita", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,10,"Ý",98000));
        freshMilk.add(new Product("MI211128","Sữa nước Monte Drink vị vani 95ml (Trên 6 tháng)","Monte", ProductCategory.fresh,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,233,"Ba Lan",16000));

        return freshMilk;

    }

    public ArrayList<Product> getAllYogurt(){
        ArrayList<Product> yogurt=new ArrayList<>();
        yogurt.add(new Product("MI311111","Sữa chua uống tiệt trùng vị cam SuSu túi 110ml","SuSu", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,30,"Việt Nam",5000));
        yogurt.add(new Product("MI311112","Sữa chua uống cam LiF Kun túi 110ml","LiF Kun", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,150,"Việt Nam",5000));
        yogurt.add(new Product("MI311113","Sữa chua uống tiệt trùng hương dâu SuSu túi 110ml","SuSu", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,160,"Việt Nam",5000));
        yogurt.add(new Product("MI311114","Sữa chua diêm mạch và chà là Nestlé Acti-V hộp 180ml","Nestlé", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,110,"Việt Nam",14500));
        yogurt.add(new Product("MI311115","Sữa chua yến mạch Nestlé Acti-V hộp 180ml","Nestlé", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,80,"Việt Nam",14500));
        yogurt.add(new Product("MI311116","Lốc 4 hộp sữa trái cây vị cam Vinamilk Hero hộp 110ml","Vinamilk", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,96,"Việt Nam",15500));
        yogurt.add(new Product("MI311117","Lốc 4 hộp sữa chua lên men tự nhiên vị việt quất sữa Fristi 100ml","Vinamilk", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,73,"Việt Nam",16000));
        yogurt.add(new Product("MI311118","Lốc 5 chai thức uống từ sữa lên men vị nho Calpis Mini 80ml","Calpis", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,62,"Nhật Bản",19000));
        yogurt.add(new Product("MI311119","Lốc 5 chai thức uống từ sữa lên men vị cam Calpis Mini 80ml","Calpis", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,180,"Nhật Bản",19000));
        yogurt.add(new Product("MI311120","Sữa chua uống hương dâu Zott Milk Tiger chai 70ml","Zott", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,111,"Indonesia",7000));
        yogurt.add(new Product("MI311121","Lốc 4 hũ váng sữa uống Zott vị vani Monte Drink 95ml","Zott", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,65,"Indonesia",58000));
        yogurt.add(new Product("MI311122","Lốc 4 hộp phô mai tươi Zott hương dâu vani 200g","Zott", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,125,"Indonesia",51000));
        yogurt.add(new Product("MI311123","Lốc 4 hộp sữa chua uống cam TH True Yogurt Top Kid 110ml","TH True Yogurt", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,130,"Việt Nam",18500));
        yogurt.add(new Product("MI311124","Lốc 4 hộp sữa chua hương dâu chuối và lúa mạch TH True Yogurt 110ml","TH True Yogurt", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,86,"Việt Nam",18500));
        yogurt.add(new Product("MI311125","Lốc 4 chai sữa chua uống hương việt quất TH True Yogurt 180ml","TH True Yogurt", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,99,"Việt Nam",27500));
        yogurt.add(new Product("MI311126","Lốc 4 hộp sữa chua TH True Yogurt vị tự nhiên 100g","TH True Yogurt", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,33,"Việt Nam",28000));
        yogurt.add(new Product("MI311127","Lốc 4 hộp sữa chua TH True Yogurt chanh dây 100g","TH True Yogurt", ProductCategory.yogurt,LocalDate.of(2021,6,15),LocalDate.of(2021,1,10),6,500,5,"Việt Nam",30500));

        return yogurt;
    }

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products=new ArrayList<>();
        products.addAll(getAllPowdered());
        products.addAll(getAllFreshMilk());
        products.addAll(getAllYogurt());

        return products;
    }

    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> customers=new ArrayList<>();
        customers.add(new Customer("CU1234","0986458367","Tranlan_1994", AccountRole.Customer,"Ngọc Lan","lan@gmail.com","số 25, Tây Sơn, Đống Đa, Hà Nội"));
        customers.add(new Customer("CU1235","0962389654","Trannam_1996",AccountRole.Customer,"Bá Nam","nam@gmail.com","số 30, Chùa Bộc, Đống Đa, Hà Nội"));

        return customers;
    }

    public ArrayList<Account> getAllStaff(){
        ArrayList<Account> staffs=new ArrayList<>();
        staffs.add(new Account("ST1236","0986458596","Tranphong_1994",AccountRole.Staff,"Nam Phong"));
        staffs.add(new Account("ST1237","0962312345","Tranba_1996",AccountRole.Staff,"Văn Ba"));

        return staffs;
    }

    public ArrayList<Account> getAdmin(){
        ArrayList<Account> admins=new ArrayList<>();
        admins.add(new Account("888888","0999888888","Admin_1994",AccountRole.Admin,"Ngọc Quân"));
        return admins;
    }

    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> accounts=new ArrayList<>();
        accounts.addAll(getAllCustomer());
        accounts.addAll(getAllStaff());
        accounts.addAll(getAdmin());
        return accounts;
    }

}
