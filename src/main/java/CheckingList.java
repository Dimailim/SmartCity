import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[EmployeeProfile]CheckingList")
public class CheckingList {
    @Id
    @Column(name="user")
    private String user;
    @Column(name="Password")
    private  String password;
    @Column(name="Comment")
    private String  comment;
    @Column (name = "checkinglist")
    private  String checkinglist;
    @OneToMany(mappedBy = "[EmployeeProfile]CheckingList",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<History> historyList;
    public CheckingList(){

    }
    public CheckingList (String user, String password, String comment, String checkinglist){
        this.user = user;
        this.password = password;
        this.comment = comment;
        this.checkinglist = checkinglist;
        historyList = new ArrayList<History>();
    }

    public  void AddHistory(History history){
        historyList.add(history);
    }
    public void  RemoveHistory(History history){
        historyList.remove(history);
    }


    public void setUser(String user){
        this.user = user;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setCheckinglist(String checkinglist){
        this.checkinglist = checkinglist;
    }
    public  void setComment (String comment){
        this.comment = comment;
    }
    public  String getUser(){
        return user;
    }
    public String getPassword(){
        return  password;
    }
    public  String getComment(){
        return comment;
    }
    public String getCheckinglist(){
        return checkinglist;
    }


}
