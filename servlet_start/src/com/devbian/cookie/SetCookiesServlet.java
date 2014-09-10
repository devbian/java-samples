package com.devbian.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by phnix on 2014/9/9.
 */
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String output = null;
        String username = req.getParameter("username");
        if(username !=null)
        {
            Cookie cookie1 = new Cookie("username", username);
            cookie1.setMaxAge(24*60*60*30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Cookie cookie2 = new Cookie("lastTime",sdf.format(new Date()));
            cookie2.setMaxAge(24*60*60*30);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            output = "本次登录时间与用户名已经写入到cookie中<br />";
            output +="<a href=\"/servlet/getCookies\">查看cookies</a>";
        }else
        {
            output = "用户名为空，请重新输入";
            output += "<br /> <a href=\"cookieInput.html\">输入用户名</a>";
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><head><title>set cookies</title></head>");
        pw.println("<body><h2>"+output+"</h2></body></html>");
        pw.flush();
        pw.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);

    }
}
