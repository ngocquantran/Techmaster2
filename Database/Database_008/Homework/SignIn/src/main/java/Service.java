import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Service {
    ConnectDatabase connectDatabase=new ConnectDatabase();
    Connection connection= connectDatabase.connect();
    public ArrayList<Users> getAllUsers(){
        ConnectDatabase connectDatabase=new ConnectDatabase();
        connectDatabase.connect();
        String query="SELECT * FROM users";
        ArrayList<Users> users=new ArrayList<>();

        try {
            Statement stm=connection.createStatement();
            ResultSet result= stm.executeQuery(query);

            while (result.next()){
                int id=result.getInt("id");
                String name=result.getString("fullname");
                String mobile=result.getString("mobile");
                String email=result.getString("email");
                String password=result.getString("password");
                String avatar=result.getString("avatar");
                int role=result.getInt("role");
                users.add(new Users(id,name, mobile, email,password,avatar,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int getIdFromMoblie(ArrayList<Users> users,String mobile){
        int id=0;
        for (Users u:users){
            if (u.getMobile().equals(mobile)){
                id=u.getId();
                break;
            }
        }
        return id;
    }
    public String getNameFromId(ArrayList<Users> users,int id){
        String name="";
        for (Users u:users){
            if (u.getId()==id){
                name=u.getName();
                break;
            }
        }
        return name;
    }

    public Users getUserFromId(ArrayList<Users> users,int id){
        Users users1=new Users("","","","","",1);
        for (Users u:users){
            if (u.getId()==id){
                users1.setId(id);
                users1.setName(u.getName());
                users1.setMobile(u.getMobile());
                users1.setEmail(u.getEmail());
                users1.setPassword(u.getPassword());
                users1.setAvatar(u.getAvatar());
                users1.setRole(u.getRole());
                break;
            }
        }
        return users1;
    }


}
