import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    static Scanner scanner=new Scanner(System.in);
    static Service service=new Service();
    static ArrayList<Post> posts=service.getAllPost();

    public static void menu(){
        System.out.println("1 - Xem thông tin tất cả bài viết");
        System.out.println("2 - Chọn bài viết");
        System.out.println("3 - Thêm bài viết mới");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void choosePostMenu(){
        System.out.println("1 - Cập nhật tiêu đề và nội dung bài viết");
        System.out.println("2 - Xóa bài viết");
        System.out.println("0 - Trở về");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void program(){
        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    service.showPostForUser(posts);
                    break;
                case 2:
                    System.out.println("Nhập id bài viết");
                    int id=Validate.inputNumber();
                    if (Validate.isIdAPostAvailable(posts,id)==false){
                        System.out.println("Không tồn tại id này");
                    }else {
                        service.getPostById(id);
                        choosePostProgram(id);
                    }
                    break;
                case 3:
                    Post newPost=service.createPost(posts);
                    service.addNewPost(newPost);
                    posts=service.getAllPost();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }
    }

    public static void choosePostProgram(int id){

        boolean isContinue=true;
        while (isContinue){
            choosePostMenu();
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    System.out.println("Nhập tiêu đề mới");
                    String title= scanner.nextLine();
                    System.out.println("Nhập nội dung mới");
                    String content=scanner.nextLine();
                    service.updateTitleAndContent(id,title,content);
                    posts=service.getAllPost();
                    service.getPostById(id);
                    break;
                case 2:
                    service.deletePost(id);
                    posts=service.getAllPost();
                    isContinue=false;
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

}
