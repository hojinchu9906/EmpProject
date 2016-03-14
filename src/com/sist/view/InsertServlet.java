package com.sist.view;

import com.sist.dao.EmpDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cjw on 2016-03-14.
 */
public class InsertServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=EUC-KR");

        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
                printWriter.println("<body>");
                    printWriter.println("<center>");
                        //브라우저에 해당 레코드 사원 정보 출력하기
                        //출력하기 위해 DB에 select 쿼리를 보내야하므로 해당 DAO 객체 일단 생성.
                        EmpDAO empDAO=new EmpDAO();

                        printWriter.println("<form action=InsertServlet method=post>");
                            printWriter.println("<table width=500 border=1 bordercolor=black cellspacing=0>");
                                printWriter.println("<tr>");
                                    printWriter.println("<td width=15% align=right>이름</td>");
                                    printWriter.println("<td width=35% align=left>");
                                        printWriter.println("<input type=text size=12 name=ename");
                                    printWriter.println("</td>");

                                    printWriter.println("<td width=15% align=right>직위</td>");
                                printWriter.println("</tr>");
                            printWriter.println("</table>");
                        printWriter.println("</form>");
                    printWriter.println("</center>");
                printWriter.println("</body>");
        printWriter.println("</html>");

    }
}


















































