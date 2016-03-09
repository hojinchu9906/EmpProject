package com.sist.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sist on 2016-03-09.
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //수행 방식 전송(브라우저) ==> html, xml
        resp.setContentType("text/html;charset=EUC-KR");

        String file="";
        String type=req.getParameter("type");
        if(type==null){
            type="0";
        }
        switch(Integer.parseInt(type)){
            case 0:
                file="EmpListServlet";
                break;
            case 1:
                file="InsertServlet";
                break;
        }

        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<center>");
        //브라우저 출력 부분
        printWriter.println("<table border=1 bordercolor=black width=1000 height=700 cellspacing=0>");
        printWriter.println("<tr>");
            printWriter.println("<td height=150 colspan=2>");
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("HeaderServlet");
                requestDispatcher.include(req,resp);
            printWriter.println("</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
            printWriter.println("<td height=450 width=200>");
            printWriter.println("&nbsp;");
            printWriter.println("</td>");

            printWriter.println("<td height=450 width=200>");
            printWriter.println("&nbsp;");
            printWriter.println("</td>");

            printWriter.println("<td height=450 width=800 align=center style=\"margin-top:10px \" >");
            requestDispatcher=req.getRequestDispatcher(file);
            requestDispatcher.include(req,resp);
            printWriter.println("</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
            printWriter.println("<td height=100 colspan=2 align=center>");
            printWriter.println("<address>서울특별시 마포구 백범로 미화빌딩 2층 A강의장</address>");
            printWriter.println("</td>");
        printWriter.println("</tr>");


        printWriter.println("</table>");
        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}































































































