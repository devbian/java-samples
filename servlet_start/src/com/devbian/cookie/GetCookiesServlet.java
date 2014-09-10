package com.devbian.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by phnix on 2014/9/9.
 */
public class GetCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>display login information</title></head>");
        pw.println("<body>");
        pw.println("<h2>从cookie中获得上次登录时间与用户名</h2>");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals("username"))
            {
                pw.println("用户名:"+cookie.getValue());
                pw.println("<br />");
            }
            else if(cookie.getName().equals("lastTime"))
            {
                pw.println("上次登录时间:"+cookie.getValue());
                pw.println("<br />");
            }
            request.getSession();
            pw.println(cookie.getName());
            pw.println(cookie.getValue());
            pw.println("<br />");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();


    }
}
