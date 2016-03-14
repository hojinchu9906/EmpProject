package com.sist.view;

import com.sist.dao.EmpDAO;
import sun.dc.pr.PRError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
                                    printWriter.println("<td width=35% align=left>");
                                        //직위 항목을 디비에서 읽어와 셀렉트리스트로 출력하기
                                        //해당 셀펙트리스트에 사용할 리스트 컬랙션 객체 받기
                                        List<String> jobList=empDAO.empGetJob();
                                        //선택리스트 추가
                                        printWriter.println("<select name=job>");
                                            //이제 직위리스트가 담긴 컬랙션에 있는 내용을 가져옴.
                                            for(String str: jobList){
                                                printWriter.println("<option>" +str+ "</option>");
                                            }
                                        printWriter.println("</select>");
                                    printWriter.println("</td>");
                                printWriter.println("</tr>");

                                //테이블내 두번째줄
                                printWriter.println("<tr>");
                                    //두번째 줄 첫번째 칸
                                    printWriter.println("<td width=25% align=right>선임사원번호</td>");
                                    printWriter.println("<td width=25% align=left>");
                                        //디비로부터 선임사원번호를 얻어온다.
                                        //컬랙션 객체에 담아놓는다.
                                        List<Integer> mrgList=empDAO.empGetMgr();
                                        //위 컬랙션객체에 있는 내용을 선택리스트로 출력해줌.
                                        printWriter.println("<select name=mgr>");
                                            for(int mgr:mrgList){
                                                printWriter.println("<option>" +mgr+  "</option>");
                                            }
                                        printWriter.println("</select>");
                                    printWriter.println("</td>");
                                    //두번째 줄 두번째 칸
                                    printWriter.println("<td>부서번호</td>");

                                printWriter.println("</tr>");
                            printWriter.println("</table>");
                        printWriter.println("</form>");
                    printWriter.println("</center>");
                printWriter.println("</body>");
        printWriter.println("</html>");

    }
}


















































