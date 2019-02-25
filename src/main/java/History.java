import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "action")
    private  String action;
    @Column(name = "userlog")
    private  String Userlog;
    @Column(name = "recivedata")
    private  String recivedata;
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private CheckingList checkingList;

    public History(){

    }
    public History(String action, String Userlog, String recivedata){
        this.action = action;
        this.Userlog = Userlog;
        this.recivedata = recivedata;
    }
    public  void setAction(String action){
        this.action = action;

    }
    public  void setUserlog(String userlog){
        this.Userlog = userlog;
    }
    public  void setRecivedata (String recivedata) { this.recivedata = recivedata;}
    public  String getAction(){
        return action;
    }
    public  String getUserlog(){
        return  Userlog;
    }
    public  String getRecivedata(){ return  recivedata;}
    public  void setCheckingList(CheckingList checkingList){
        this.checkingList = checkingList;
    }
    public  CheckingList getCheckingList(){
        return checkingList;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

}
