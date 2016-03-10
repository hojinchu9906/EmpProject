package com.sist.dao;

import java.util.Date;

/**
 * Created by sist on 2016-03-10.
 *
 *   데이터형(오라클)                                  자바
 *   CHAR, VARCHAR2, CLOB                           String
 *   NUMBER                                         int, double
 *   DATE, TIMESTAMP                                java.util.Date
 *   BLOB, BFILE                                    inputStream
 *
 *   EMPNO NUMBER,                                  int
     ENAME VARCHAR2,                                String
     JOB VARCHAR2,                                  String
     MGR NUMBER,                                    int
     HIREDATE DATE,                                 Date
     SAL NUMBER,                                    int, double
     COMM NUMBER,                                   int
     DEPTNO NUMBER                                  int

     DEPTNO NUMBER,                                 int
     DNAME VARCHAR2,                                String
     LOC VARCHAR2                                   String
 */
public class EmpDTO {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;

    private String dname;
    private String loc;
    //필드 2개 더 추가
    private String strSal;
    private String strDay;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getStrSal() {
        return strSal;
    }

    public void setStrSal(String strSal) {
        this.strSal = strSal;
    }

    public String getStrDay() {
        return strDay;
    }

    public void setStrDay(String strDay) {
        this.strDay = strDay;
    }
}






































































