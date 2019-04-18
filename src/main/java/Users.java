import javax.persistence.*;
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "login")
    private  String login;
    @Column (name = "password")
    private  String password;
    @Column (name = "adminka")
    private  boolean isAdmin;
    public void  setLogin(String login){
        this.login = login;
    }
    public  void setPassword(String password){
        this.password = password;
    }
    public void setAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    public  String  getLogin(){
        return login;
    }
    public  String getPassword(){
        return password;
    }
    public boolean getAdmin(){
        return  isAdmin;
    }
}
