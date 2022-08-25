import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Users {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String avatar;
    private int role;

    public Users(String name, String mobile, String email, String password, String avatar, int role) {

        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }
}
