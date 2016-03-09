package com.sist.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sist on 2016-03-09.
 */
public class HeaderServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=EUC-KR");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<center>");
        //브라우저 출력 부분
        printWriter.println("<table width=1000 height=150 background=image/back.jpg>");
        printWriter.println("<tr>");
            printWriter.println("<td align=center><font size=25><b>사원들 관리 프로그램</b></font></td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}
















































































