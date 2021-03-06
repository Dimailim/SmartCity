import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class main {
    public static void main(String[] args){
        DatabaseHelper dataBase = new DatabaseHelper();

        //System.out.println(dataBase.insertUser("Admin","cllstadminpassword","Расчетный лист за апрель 2019","/april2019.pdf"));
        //System.out.println(dataBase.checkLogUser("Admin"));
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
        CLServlet CLservlet = new CLServlet();
        HistServlet histServlet = new HistServlet();
        LoginServlet loginServlet = new LoginServlet();
        LogoutServlet logoutServlet = new LogoutServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(CLservlet), "/chcklist");
        context.addServlet(new ServletHolder(histServlet), "/hist");
        context.addServlet(new ServletHolder(loginServlet), "/login");
        context.addServlet(new ServletHolder(logoutServlet), "/logout");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        }
        catch (Exception ex){
            System.out.println("Непредвиденное завершение работы");
            ex.printStackTrace();
        }

    }
}
