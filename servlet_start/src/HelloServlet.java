import com.devbian.dao.WorldInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Created by phnix on 2014/9/7.
 */
public class HelloServlet extends javax.servlet.http.HttpServlet {

    private int i;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(++i);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><title>hello</title><body>欢迎光临");
        try {
            WorldInfo info = new WorldInfo();
            ResultSet set = info.GetInfos();
            while (set.next())
            {
                pw.println(set.getString("Name")+"  "+set.getString("District")+"<br />");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error fuck");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.println("</body></html>");
        pw.flush();
        pw.close();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("has para: in init");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("no para: in init");
    }
}
