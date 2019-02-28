import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; utf-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        session.invalidate();
        out.println("Session is closed!>");
        out.println("<p><a href = 'C:\\Users\\Dimailim\\IdeaProjects\\EmployeeProfile\\templates\\index.html'>Index</a></p>");
        out.close();
    }

}
