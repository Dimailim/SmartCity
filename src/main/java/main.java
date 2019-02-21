public class main {
    public static void main(String[] args){
        DatabaseHelper dataBase = new DatabaseHelper();
        System.out.println(dataBase.insertUser("IIvanov","gjhak321","Расчетный лист за февраль","/chcklst.pdf"));
        System.out.println(dataBase.checkUser("IIvanov"));
        //CheckingListService service = new CheckingListService();
        //CheckingList checkingList = service.getCheckingList("IIvanov");

       // Owners owners = service.getOwner("Maxim");
        //System.out.println("User - "+checkingList.getUser());
        //System.out.println("Comment - "+checkingList.getComment());
        // service.deleteOwner(owners);
        //service.saveOwner(owners);

        //Auto bmw = new Auto("BMW X6","black");
        // bmw.setOwners(owners);
        // owners.addAuto(bmw);
        //service.updateOwner(owners);
        //System.out.println("Car model - " + bmw.getModel());
        //System.out.println("Car color - " + bmw.getColor());

        //Auto nissan = new Auto("Nissan GTX","black");
        //nissan.setOwners(owners);
        //owners.removeAuto(nissan);
        //service.updateOwner(owners);
        //System.out.println("Car model - " + nissan.getModel());
        //System.out.println("Car color - " + nissan.getColor());


        //Owners owners = new Owners("Alex",23);
        //service.updateOwner(owners);
    }
}
