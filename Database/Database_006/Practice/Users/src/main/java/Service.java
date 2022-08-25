import com.sun.source.tree.WhileLoopTree;
import oracle.jdbc.proxy.annotation.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service {
    ConnectDatabase connectDatabase=new ConnectDatabase();
    Connection conn= connectDatabase.connect();

    public void getAllUsers(){
        String query="SELECT * FROM users";
        List<Users> list;


        try {
            Statement stm= conn.createStatement();
            ResultSet resultSet= stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" - "+resultSet.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Users> getUsers(int id){
        String query="SELECT * FROM users WHERE id="+ id;
        List<Users> list=new ArrayList<>();

        try {
            Statement stm= conn.createStatement();
            ResultSet resultSet= stm.executeQuery(query);
            while (resultSet.next()){
//                System.out.println(resultSet.getString("id")+" - "+resultSet.getString("name"));
                int idUser=resultSet.getInt(id);
                String name=resultSet.getString("name");
                String gender=resultSet.getString("gender");
                String address=resultSet.getString("address");
                String mobile=resultSet.getString("mobile");
                String date=resultSet.getString("create_at");

                list.add(new Users(id,name,gender,address,mobile,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void show(List<?> list){
        for (Object o:list){
            System.out.println(o);
        }
    }

    public Users getUsersById(int id){
        Users findUser=null;
        String query="SELECT * FROM users WHERE id="+ id;

        try {
            Statement stm= conn.createStatement();
            ResultSet resultSet= stm.executeQuery(query);

            while (resultSet.next()){
                int idUser=resultSet.getInt(id);
                String name=resultSet.getString("name");
                String gender=resultSet.getString("gender");
                String address=resultSet.getString("address");
                String mobile=resultSet.getString("mobile");
                String date=resultSet.getString("create_at");

                findUser=new Users(id,name,gender,address,mobile,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findUser;
    }

    public List<Users> searchByName(String name){
        String query="SELECT * FROM users WHERE name LIKE '%"+name+"%'";
        List<Users> list=new ArrayList<>();

        try {
            Statement stm= conn.createStatement();
            ResultSet resultSet= stm.executeQuery(query);

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String nameUser=resultSet.getString("name");
                String gender=resultSet.getString("gender");
                String address=resultSet.getString("address");
                String mobile=resultSet.getString("mobile");
                String date=resultSet.getString("create_at");

                list.add(new Users(id,nameUser,gender,address,mobile,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addNewUser(Users users){
        String query="INSERT INTO users VALUES(null,'"+users.getName()+"','"+users.getGender()+"','"+users.getAddress()+"','"+users.getMobile()+"',CURRENT_DATE())";
        List<Users> list=new ArrayList<>();

        try {
            Statement stm= conn.createStatement();
            stm.executeUpdate(query);

            System.out.println("Thêm thành công");
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void showPostForUser(ArrayList<){

    }


}
