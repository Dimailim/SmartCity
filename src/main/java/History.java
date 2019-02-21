import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
@Entity
@Table(name = "[EmployeeProfile]History")
public class History {
    @Id
    @Column(name = "Action")
    private  String action;
    @Column(name = "UserLog")
    private  String Userlog;
    @OneToMany(fetch =  FetchType.LAZY)
    @JoinColumn(name = "Recivedata")
    private CheckingList checkingList;

    public History(){

    }
    public History(String action, String Userlog){
        this.action = action;
        this.Userlog = Userlog;
    }
    public  void setAction(String action){
        this.action = action;

    }
    public  void setUserlog(String userlog){
        this.Userlog = userlog;
    }
    public  String getAction(){
        return action;
    }
    public  String getUserlog(){
        return  Userlog;
    }
    public  void setCheckingList(CheckingList checkingList){
        this.checkingList = checkingList;
    }
    public  CheckingList getCheckingList(){
        return checkingList;
    }





}
