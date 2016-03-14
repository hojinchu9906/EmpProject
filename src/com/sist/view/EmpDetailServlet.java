package com.sist.view;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cjw on 2016-03-14.
 *
 * 페이지 이동 (화면 전환)
 *      HTML
 *          <a></a>    ==> GET 방식임.
 *          <form></form>          ==> GET, POST 방식 둘다 가능함.
 *     JavaScript
 *          location.href="URL"     ==> GET 방식임.
 *     Java
 *          response.sendRedirect() ==> GET 방식임.
 */
public class EmpDetailServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=euc-kr");
        //특정 사원번호 기준으로 선택된 사원의 세부정보를 보여줌.--PK
        //우선 사원번호를 얻는다.
        String empno=req.getParameter("empno");     //url에 파라미터로 empno를 사용했음.EmpListServlet의 57라임.
        //이제 한 레코드에 해당하는 사원의 정보를 불러오면 됨.
        //해당 기능을 갖고 있는 DAO 객체를 생성함.
        EmpDAO empDAO=new EmpDAO();

        //해당 세부내용 기능 호출함
        //이 결과를 화면에 뿌려주기위해 DTO 변수로 받아줌.
        EmpDTO empDTO=empDAO.empDetailData(Integer.parseInt(empno));

        //테이블로 부터 얻은 위 결과를 클라이트에 보내기 위해 스트림 쓰기 객체 필요함.
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
            printWriter.println("<head>");
                printWriter.println("<script type=\"text/javascript\">");
                    //DTO에 담아있는 내용을 다 출력해야함.
                    printWriter.println("var i=0;");





            printWriter.println("</head>");
        printWriter.println("</html>");
    }
}

































































