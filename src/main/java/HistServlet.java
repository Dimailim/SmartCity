import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HistServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Получение json из потока

        String username = req.getParameter("username");
        //String password = req.getParameter("password");

        //Готовим ответ на корректность пароля и логина
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        DatabaseHelper dbHelper = new DatabaseHelper();
        Map<String, Object> pageVariables = new HashMap<String, Object>();
        pageVariables.put("message","Hello");
        //Отправляем в ответ
        out.print(PageGenerator.instance().getPage("page.html", pageVariables));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        JsonReader reader = Json.createReader(req.getInputStream());
        JsonObject newJson = reader.readObject();
        reader.close();


        String action = newJson.getString("action");
        String userLog = newJson.getString("user");


        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        DatabaseHelper dbHelper = new DatabaseHelper();

        Map<String, Object> pageVariables = new HashMap<String, Object>();
        pageVariables.put("message", "Hello");

        //Отправляем в ответ
        //out.print(dbHelper.insertUser(user, password));
        resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
    }
}
