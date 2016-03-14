package com.sist.view;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;
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
                                    printWriter.println("<td width=15% align=right>부서번호</td>");
                                    printWriter.println("<td width=35% align=left>");
                                        //선택리스트 추가함.
                                        printWriter.println("<select name=deptno>");
                                        //부서번호를 선택 입력하는것임
                                            printWriter.println("<option>10</option>");
                                            printWriter.println("<option>20</option>");
                                            printWriter.println("<option>30</option>");
                                            printWriter.println("<option>40</option>");
                                        printWriter.println("</select>");
                                    printWriter.println("</td>");
                                printWriter.println("</tr>");

                                //세번째 줄
                                //급여 선택리스트 출력하기
                                printWriter.println("<tr>");
                                    printWriter.println("<td width=25% align=right>사원연봉대</td>");
                                    printWriter.println("<td>");
                                        //선택리스트 추가
                                        printWriter.println("<select name=salary>");
                                            //옵션태그들 추가
                                            printWriter.println("<option>1000</option>");
                                            printWriter.println("<option>2000</option>");
                                            printWriter.println("<option>3000</option>");
                                            printWriter.println("<option>4000</option>");
                                            printWriter.println("<option>4500</option>");
                                        printWriter.println("</select>");
                                    printWriter.println("</td>");
                                    //셋째줄 두번째 칸-성과급 리스트 추가함.
                                    printWriter.println("<td width=15% align=right>보너스급</td>");
                                    printWriter.println("<td width=35% align=left>");
                                        //입력시 선택하여 고르는 선택 리스트 추가
                                        printWriter.println("<select name=commition>");
                                            printWriter.println("<option>100</option>");
                                            printWriter.println("<option>200</option>");
                                            printWriter.println("<option>300</option>");
                                            printWriter.println("<option>400</option>");
                                            printWriter.println("<option>500</option>");
                                        printWriter.println("</select>");
                                    printWriter.println("<td>");
                                printWriter.println("</tr>");

                                //마지막 네번째 줄
                                //등록,취소 버튼 추가함.
                                printWriter.println("<tr>");
                                    //내번째 줄 첫번째 칸
                                    printWriter.println("<td colspan=4 align=center>");
                                        printWriter.println("<input type=submit value=사원등록하기>");
                                        printWriter.println("<input type=button value=취소하기 onclick=\"javascript:history.back()\">");
                                    printWriter.println("</td>");

                                printWriter.println("</tr>");
                            printWriter.println("</table>");
                        printWriter.println("</form>");
                    printWriter.println("</center>");
                printWriter.println("</body>");
        printWriter.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("EUC-KR");
        //위 doGet()에서 입력했던 모든 값들을 변수에 담아서
        //각 항목의 값들을 AO에 셋팅해서
        //최종적으로 dao의 입력하기 기능을 활용하여 테이블에 추가함.
        //추가하고 나서는 다시 메인 리스트 서블릿으로 리다이렉트함.

        String ename=req.getParameter("ename");
        String job=req.getParameter("job");
        String mgr=req.getParameter("mgr");
        String salary=req.getParameter("salary");
        String commition=req.getParameter("commition");
        String deptno=req.getParameter("deptno");

        //DTO 즉 AO에 셋팅하기 위해 AO 객체 생성
        EmpDTO empDTO=new EmpDTO();
        //위의 각 입력받은 값들을 AO 각 필드에 셋팅함.
        empDTO.setEname(ename);
        empDTO.setJob(job);
        empDTO.setMgr(Integer.parseInt(mgr));
        empDTO.setSal(Integer.parseInt(salary));
        empDTO.setComm(Integer.parseInt(commition));
        empDTO.setDeptno(Integer.parseInt(deptno));

        //이제 이 값들을 서버측에 보내 테이블에 입력하면 됨.
        //우선 입력기능을 직접적으로 호출할수 있는 함수를 갖고 있는 DAO객체 생성
        EmpDAO empDAO=new EmpDAO();
        empDAO.empInsert(empDTO);

        //입력후 메인리스트로 리다이렉트함
        resp.sendRedirect("MainServlet");
    }
}


















































