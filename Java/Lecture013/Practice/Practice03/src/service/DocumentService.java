package service;

import model.Document;
import model.Ebook;
import model.Newspaper;
import model.Textbook;
import util.Util;

import java.time.LocalDate;
import java.util.ArrayList;

public class DocumentService {


    public ArrayList<Textbook> getAllTextbook(){
        ArrayList<Textbook> textbooks=new ArrayList<>();
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 1","Địa lý","Kim Đồng",2010,100,90,"Nhà văn 1"));
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 2","Lịch sử","A",2019,50,150,"Nhà văn 2"));
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 3","Văn học","B",2011,600,60,"Nhà văn 3"));
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 4","Toán học","C",2012,150,80,"Nhà văn 4"));
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 5","Hóa học","D",2021,120,110,"Nhà văn 5"));
        textbooks.add(new Textbook(Util.randomId(5),"Sách giáo khoa 6","Tiếng Anh","F",2022,100,90,"Nhà văn 6"));

        return textbooks;
    }

    public ArrayList<Newspaper> getAllNewspaper(){
        ArrayList<Newspaper> newspapers=new ArrayList<>();
        newspapers.add(new Newspaper(Util.randomId(5),"Báo 7","Thể thao","24h", LocalDate.of(2021,12,15),1000,20));
        newspapers.add(new Newspaper(Util.randomId(5),"Báo 8","Thời trang","Elle", LocalDate.of(2020,12,15),2000,60));
        newspapers.add(new Newspaper(Util.randomId(5),"Báo 9","Sức khỏe","Hà Nội Mới", LocalDate.of(2022,12,15),500,30));
        return newspapers;
    }

    public ArrayList<Ebook> getAllEbook(){
        ArrayList<Ebook> ebooks=new ArrayList<>();
        ebooks.add(new Ebook(Util.randomId(5),"Cuốn theo chiều gió","Lãng mạn","Kim Đồng",1994,2000,"ảnh 1",5000));
        ebooks.add(new Ebook(Util.randomId(5),"Quốc gia khởi nghiệp","Self-help","Sen Vàng",1994,1500,"ảnh 2",6000));
        ebooks.add(new Ebook(Util.randomId(5),"Harry Potter","Phiêu Lưu","Sen Xanh",2010,3000,"ảnh 3",7000));
        return ebooks;
    }

    public ArrayList<Document> getAllDocument(){
        ArrayList<Document> allDocuments=new ArrayList<>();
        allDocuments.addAll(getAllTextbook());
        allDocuments.addAll(getAllNewspaper());
        allDocuments.addAll(getAllEbook());


        return allDocuments;

    }

    public void show(ArrayList<?> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

    public void searchByName(ArrayList<Document> documents, String name){
        int found=0;
        for (Document d:documents){
            if (d.getName().toLowerCase().contains(name.trim())){
                System.out.println(d);
                found++;
            }
        }
        if (found<1){
            System.out.println("Không có kết quả");
        }
    }

    public void searchByCategory(ArrayList<Document> documents, String category){
        int found=0;
        for (Document d:documents){
            if (d.getCategory().toLowerCase().contains(category.trim())){
                System.out.println(d);
                found++;
            }
        }
        if (found<1){
            System.out.println("Không có kết quả");
        }
    }

    public void getMaxDownloadEbook(ArrayList<Ebook> ebooks){
        int max=0;
        for (int i=1;i<ebooks.size();i++){
            if(ebooks.get(i).getDownload()>max){
                max=i;
            }
        }
        System.out.println(ebooks.get(max));
    }

    public void getCurrentYearNewspaper(ArrayList<Newspaper> newspapers){
        LocalDate localDate=LocalDate.now();
        int currentYear= localDate.getYear();
        for (Newspaper n:newspapers){
            if (n.getPublishingDate().getYear()==currentYear){
                System.out.println(n);
            }
        }
    }




}
