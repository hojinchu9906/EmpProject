package com.sist.dao;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sist on 2016-03-10.
 * POJO 방식 구현임.
 */
public class EmpDAO {
    //일단 디비 연결해야함.  연결 객체
    private Connection connection;

    //디비에 쿼리문을 전송함. 이때 스트림 객체가 필요함. ==> BufferedReader, OutputStream 인데 이걸 대체하는 객체 선언
    private PreparedStatement preparedStatement;

    //디비 주소 선언
    private final String URL="jdbc:oracle:thin:@211.238.142.72:1521:ORCL";

    //생성자에서 오라클 디비 연결 초기화 작업함.-클라이언트단에서 필요한 디비 드라이버 로드함.
    public EmpDAO(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception ex){
            System.out.println("EmpDAO: " + ex.getMessage());
        }
    }

    //DAO 객체는 하나만 생성해서 공유하면 됨.  그래서 싱글턴 패턴으로 DAO 객체 생성함.(static으로 생성함)
    private static EmpDAO empDAO;

    public static EmpDAO newInstance(){
        if(empDAO==null)
            empDAO=new EmpDAO();
        return empDAO;
    }

    //오라클  디비 연결 객체 생성-함수로 기능 추가함.
    public void getConnection(){
        try{
            connection= DriverManager.getConnection(URL,"scott5","tiger5");
        }catch(Exception ex){
            System.out.println("getConnection: " +ex.getMessage());
        }
    }

    //오라클 디비 연결 해재 객체 생성-함수로 기능 추가함.
    public void disConnection(){
        try{
            if(preparedStatement!=null)
                preparedStatement.close();
            if(connection!=null)
                connection.close();
        }catch(Exception ex){
            System.out.println("disConnection : " +ex.getMessage());
        }
    }


    //DAO 고유 기능 추가 -1. 목록 (SELECT)-화면 출력
    public List<EmpDTO> empAllData(){
        //리턴해주는 에래이리스트 선언
        List<EmpDTO> empDTOList=new ArrayList<>();
        try{
            //디비 연결 객체 생성
            getConnection();

            //전체 리스트 쿼리 문장
            String sql="SELECT empno,ename,job,hiredate,dname "
                        +"FROM emp,dept "
                        +"WHERE emp.deptno=dept.deptno "
                        +"ORDER BY empno DESC";

            //위 문장을 스트림 객체 활용해서 보내기
            preparedStatement= connection.prepareStatement(sql);

            //디비에서 실행하기
            ResultSet resultSet=preparedStatement.executeQuery();

            //리절트 셋에 있는걸 출력하기
            //먼저 읽어오기
            while (resultSet.next()){
                //리절트 셋에 있는 해당 AC는 EmpDTO 객체이다.
                EmpDTO empDTO=new EmpDTO();
                empDTO.setEmpno(resultSet.getInt(1));;
                empDTO.setEname(resultSet.getString(2));
                empDTO.setJob(resultSet.getString(3));
                empDTO.setHiredate(resultSet.getDate(4));
                empDTO.setDname(resultSet.getString(5));
                //위처럼 값이 셋팅된 하나의 행단위가 되는 empDTO를 리턴하게 되는 어레이리스트에 추가함.
                empDTOList.add(empDTO);
                //이상 위 레코드 단위 값 셋팅을 테이블에 있는 개수만큼 반복함.
            }
            resultSet.close();

        }catch (Exception ex){
            System.out.println("empAllData() : " +ex.getMessage());
        }finally {
            //디비 연결 객체 해제
            disConnection();
        }
        return empDTOList;
    }

    //기능 추가.  잡항목리스트 디비로부터 가져오기 함수
    public List<String> empGetJob(){
        //해당 항목을 디비로부터 가져와 저장해둘 컬랙션 객체 생성하기
        List<String> arrayList=new ArrayList<>();

        //해당 항목 디비로 부터 받아오기
        try{
            getConnection();
            //쿼리문
            //emp 테이블에서의 직함인데, 그중 장은 한명만 있어서 직함항목에 해당이 안되므로
            // ename=KING인 사원의 직함인 제외한 쿼리문을 작성한다.
            String sql="SELECT DISTINCT job FROM emp "
                        +"WHERE ename<>'KING'";

            //해당 쿼리문을 스트림으로 디비에 전송할 객체 획득.
            preparedStatement=connection.prepareStatement(sql);

            //이제 해당 쿼리문을 실행하여 결과를 ResultSet에 저장함.
            ResultSet resultSet=preparedStatement.executeQuery();
            //해당 내용을 이 함수 맨 앞에서 선언한 컬랙션객체에 저장하고 그걸 리턴함.
            while(resultSet.next()){
                arrayList.add(resultSet.getString(1));
            }
            //리절트셋 사용이 다 끝났으면 종료함.
            resultSet.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            disConnection();
        }

        return arrayList;
    }
}






















































