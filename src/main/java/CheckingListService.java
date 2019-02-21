import java.util.List;

public class CheckingListService {
    private Dao checkinglistDao = new Dao();
    public void saveCheckingList (CheckingList checkingList){
        checkinglistDao.saveData(checkingList);
    }
    public void updateOwner(CheckingList checkingList){
        checkinglistDao.updateData(checkingList);
    }
    public void deleteOwner(CheckingList checkingList){
        checkinglistDao.deleteData(checkingList);
    }
    public List<CheckingList> getAllOwner(){
        return checkinglistDao.getALL();
    }
    public CheckingList getCheckingList(String user){
        return checkinglistDao.getCheckingList(user);

    }
}
