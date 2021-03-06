package com.sist.view;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
                    printWriter.println("<th>성명</th>");
                    printWriter.println("<th>사내직위</th>");
                    printWriter.println("<th>입사날짜</th>");
                    printWriter.println("<th>부서이름</th>");
                printWriter.println("</tr>");

                //실제 디비 테이블에 있는 데이터 출력하기
                EmpDAO empDAO=EmpDAO.newInstance();         //싱클톤으로 DAO 객체 생성
                //테이블에 대이터를 까서 웹화면에 출력해 주기.
                List<EmpDTO> empDTOList=empDAO.empAllData();

                    for(EmpDTO empDTO: empDTOList){
                        printWriter.println("<tr>");
                            printWriter.println("<td align=center>" +empDTO.getEmpno()+ "</td>");

                            printWriter.println("<td align=center>");
                                printWriter.println("<a href=MainServlet?type=2&empno="+empDTO.getEmpno()+">");
                                printWriter.println(empDTO.getEname() +"</a>");
                            printWriter.println("</td>");

                            printWriter.println("<td align=center>" +empDTO.getJob()+ "</td>");
                            printWriter.println("<td align=center>" +empDTO.getHiredate().toString()+ "</td>");
                            printWriter.println("<td align=center>" +empDTO.getDname()+ "</td>");
                        printWriter.println("</tr>");
                    }

            printWriter.println("</table>");
        printWriter.println("<hr widht=500>");

        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}







































































































