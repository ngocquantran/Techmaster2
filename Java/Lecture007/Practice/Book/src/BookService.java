import java.util.Arrays;

public class BookService {
//    public static void getAllBook(){
//        Book[] books=new Book[2];
//
//        String[] category=new String[]{"Tình cảm","trinh thám"};
//
//        books[0]=new Book(1,"Cuốn theo chiều gió",category,"abc",1990,"xyz");
//        books[1]=new Book(2,"Dế mèn phiêu liêu ký",new String[]{"Phiêu lưu", "Viễn tưởng","Tình cảm"},"Tô Hoài",1990,"Kim Đồng");
//
////        for (Book i:books){
////            System.out.println(i);
////        }
//
//        for (int i=0;i<books.length;i++){
//            String check=Arrays.toString(books[i].getCategory());
//            if (check.contains("trinh thám")){
//                System.out.println(books[i]);
//            }
//        }
//    }
//    public static void searchBook(Book[] books){
//        getAllBook();
//        for (int i=0;i<books.length;i++){
//            String check=Arrays.toString(books[i].getCategory());
//            if (check.contains("trinh thám")){
//                System.out.println(books[i]);
//            }
//        }
//    }

    public static Book[] getAllBook() {
        Book[] books = new Book[2];

        String[] category = new String[]{"Tình cảm", "trinh thám"};

        books[0] = new Book(1, "Cuốn theo chiều gió", category, "abc", 1990, "xyz");
        books[1] = new Book(2, "Dế mèn phiêu liêu ký", new String[]{"Phiêu lưu", "Viễn tưởng", "Tình cảm"}, "Tô Hoài", 1990, "Kim Đồng");

//        for (Book i:books){
//            System.out.println(i);
//        }
        return books;


    }

    public static void printBook(Book[] arrBook){
        for (Book book:arrBook){
            System.out.println();
        }
    }

    public static void searchBook(Book[] books, String category){

        for (int i=0;i<books.length;i++){
            if (Arrays.toString(books[i].getCategory()).contains(category)){
                System.out.println(books[i]);
            }
        }
    }
}