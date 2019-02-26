import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "checkinglist")
public class CheckingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name="username")
    private String user;
    @Column(name="password")
    private  String password;
    @Column(name="comment")
    private String  comment;
    @Column (name = "checkinglistfile")
    private  String checkinglistfile;
    @OneToMany(mappedBy = "checkingList",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<History> historyList;
    public CheckingList(){

    }
    public CheckingList (String user, String password, String comment, String checkinglist){
        this.user = user;
        this.password = password;
        this.comment = comment;
        this.checkinglistfile = checkinglist;
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
    public void setCheckinglistfile(String checkinglist){
        this.checkinglistfile = checkinglist;
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
    public String getCheckinglistfile(){
        return checkinglistfile;
    }
    public void setId(){
        this.id = id;
    }
    public  long getId(){
        return id;
    }

}
