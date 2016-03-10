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
public class EmpListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=EUC-KR");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<center>");

        //실 내용 출력
            //첫번째 테이블 생성
            printWriter.println("<table width=600 border=0>");
                printWriter.println("<tr>");
                    printWriter.println("<td>");
                        printWriter.println("<a href=MainServlet?type=1>등록</a>");
                    printWriter.println("</td>");
                printWriter.println("</tr>");
            printWriter.println("</table>");


            //두번째 테이블 추가
            printWriter.println("<table width=600 border=0>");
                printWriter.println("<tr bgcolor=#ccccff>");
                    printWriter.println("<th>사원번호</th>");

                printWriter.println("</tr>");



            printWriter.println("</table>");

        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}







































































































