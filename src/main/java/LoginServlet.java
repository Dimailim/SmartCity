import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; utf-8");
        PrintWriter out = resp.getWriter();
        DatabaseHelper databaseHelper = new DatabaseHelper();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        if(pass.equals(databaseHelper.checkUser(name))){
            out.println("Welcome "+name);
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
            out.println("<br>My session counter " + sessionCounter(session)+"<br>");
            //out.println("Session Id: "+ session.getId());
            Date dateFormat = new Date(session.getCreationTime());
            out.println("<br> Create session data: "+dateFormat+"<br>");
            out.println("<p><a href = 'C:\\Users\\Dimailim\\Pictures\\Study\\smartCity\\EmployeeProfile.docx'>Download Checking List" +
                    "</a></p>");

            out.println("<p><a href = 'http://localhost:8080/logout'>Logout</a></p>");
            int time = 120;
            session.setMaxInactiveInterval(time);
        }
        else{
            out.println("Wrong password");
        }
        out.close();
    }
    private  int sessionCounter(HttpSession session){
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null){
            session.setAttribute("counter", 1);
            return 1;
        } else {
            counter++;
            return counter;
        }
    }
}
