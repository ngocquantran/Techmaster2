import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    static Scanner scanner=new Scanner(System.in);
    ConnectDatabase connectDatabase=new ConnectDatabase();
    Connection connection= connectDatabase.connect();


    public ArrayList<Post> getAllPost(){
        String query="SELECT * FROM post p ";
        ArrayList<Post> posts=new ArrayList<>();

        try {
            Statement stm=connection.createStatement();
            ResultSet result= stm.executeQuery(query);

            while (result.next()){
                int id=result.getInt("id");
                String title= result.getString("title");
                String content= result.getString("content");
                String description= result.getString("description");
                String thumbnail= result.getString("thumnail");
                int idCategory= result.getInt("id_category");
                int idAuthor= result.getInt("id_author");
                LocalDate createAt= LocalDate.parse(result.getString("create_at"));
                String status=result.getString("status");
                posts.add(new Post(id,title,content,description,thumbnail,idCategory,idAuthor,createAt,status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public void showPostForUser(ArrayList<Post> posts){
        for (Post p:posts){
            if (p.getStatus().equals("public")){
                System.out.println("Post{id="+p.getId() +
                        ", title='" + p.getTitle() +
                        "', content='" + p.getContent() +
                        "', description='" + p.getDescription() +
                        "', create_at='" +  p.getCreateAt()+
                        "', thumbnail='"+ p.getThumbnail()+"'}" );
            }
        }
    }



    public void getPostById(int id){
        String query="SELECT p.id AS 'post_id',p.title ,p.content ,a.name ,(SELECT JSON_ARRAYAGG(JSON_OBJECT('tag',t.name))\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tFROM tag t INNER JOIN post_tag pt ON t.id =pt.id_tag \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tWHERE pt.id_post ="+id+") as 'tagarr'\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t,p.create_at \n" +
                "FROM post p INNER JOIN author a \n" +
                "ON p.id_author =a.id \n" +
                "WHERE p.id="+id;

        try {
            Statement stm=connection.createStatement();
            ResultSet result= stm.executeQuery(query);

            while (result.next()){
                System.out.println(result.getInt("post_id")+" - "+result.getString("title")+" - "+result.getString("content")+" - "+result.getString("name")+" - "+result.getString("tagarr")+" - "+result.getString("create_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTitleAndContent(int id,String newTitle,String newContent){
        String query="UPDATE post \n" +
                "set title='"+newTitle+"', content ='"+newContent+"'\n" +
                "WHERE id="+id;

        try {
            Statement stm=connection.createStatement();
            stm.executeUpdate(query);

            System.out.println("Cập nhật thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int id){
        String query="DELETE FROM post \n" +
                "WHERE id="+id;

        try {
            Statement stm=connection.createStatement();
            stm.executeUpdate(query);
            System.out.println("Xóa thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Post createPost(ArrayList<Post> posts){
        System.out.println("Nhập tiêu đề bài viết");
        String title=scanner.nextLine();

        System.out.println("Nhập nội dung bài viết");
        String content=scanner.nextLine();

        System.out.println("Nhập mô tả bài viết");
        String description=scanner.nextLine();

        System.out.println("Nhập mã thể loại");
        int idCategory=0;
        boolean isContinue=true;
        while (isContinue){
            idCategory=Validate.inputNumber();
            if (Validate.isIdCategoryAvailable(posts,idCategory)==true){
                isContinue=false;
            }else {
                System.out.println("Không tồn tại mã này");
            }
        }

        System.out.println("Nhập mã tác giả");
        int idAuthor=0;
        boolean isContinue2=true;
        while (isContinue2){
            idAuthor=Validate.inputNumber();
            if (Validate.isIdAuthorAvailable(posts,idAuthor)==true){
                isContinue2=false;
            }else {
                System.out.println("Không tồn tại mã này");
            }
        }



        System.out.println("Chọn trạng thái bài viết");
        String status="public";
        boolean isContinue3=true;
        while (isContinue3){
            System.out.println("1 - Công khai");
            System.out.println("2 - Riêng tư");
            System.out.println("3 - Nháp");
            System.out.println("Lựa chọn của bạn là");
            int choice=Validate.inputNumber();
            switch (choice){
                case 1:
                    status="public";
                    isContinue3=false;
                    break;
                case 2:
                    status="hidden";
                    isContinue3=false;
                    break;
                case 3:
                    status="draft";
                    isContinue3=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }

        Post post=new Post(title,content,description,"NULL",idCategory,idAuthor,null,status);
        return post;
    }

    public void addNewPost(Post post){
        String query="INSERT INTO post VALUES (NULL,'"+post.getTitle()+"','"+post.getContent()+"','"+post.getDescription()+"',NULL,"+post.getIdCategory()+","+post.getIdAuthor()+",CURRENT_DATE(),'"+post.getStatus()+"')";
        try {
            Statement stm = connection.createStatement();
            stm.executeUpdate(query);
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }








}
