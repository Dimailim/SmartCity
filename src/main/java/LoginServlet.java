import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //resp.setContentType("text/html; utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        DatabaseHelper databaseHelper = new DatabaseHelper();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
//        out.println(name);
//        out.println(pass);
        if(pass.equals(databaseHelper.checkLogUser(name))){
            //out.println("Welcome "+name);
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
            //Date dateFormat = new Date(session.getCreationTime());
            Map<String, Object> pageVariables = new HashMap<String, Object>();
            pageVariables.put("name",name);
            pageVariables.put("id",session.getId());
            //pageVariables.put("dateId",dateFormat);
            pageVariables.put("login",databaseHelper.checkCLUser(name));
            pageVariables.put("comment",databaseHelper.checkComment(name));
            pageVariables.put("cl",databaseHelper.checkCL(name));
            //Отправляем в ответ
            out.print(PageGenerator.instance().getPage("index.html", pageVariables));
            //out.println("<br>My session counter " + sessionCounter(session)+"<br>");
            //out.println("Session Id: "+ session.getId());

            //out.println("<br> Create session data: "+dateFormat+"<br>");
            //out.println("<p><a href = 'C:\\Users\\Dimailim\\Pictures\\Study\\smartCity\\EmployeeProfile.docx'>Download Checking List" +"</a></p>");

            //out.println("<p><a href = 'http://localhost:8080/logout'>Logout</a></p>");
            int time = 12000;
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
