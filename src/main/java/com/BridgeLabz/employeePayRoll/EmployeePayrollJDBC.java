package com.BridgeLabz.employeePayRoll;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayrollJDBC {
    public static void main(String args[]) {
        String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll_service_db?useSSl=false";
        String userName = "root";
        String password = "Pankaj100%";
        String QUERY = "select * from employee_payroll";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!");
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is Successful!!" + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (
                Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);

        ) {
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("id"));
                System.out.print(rs.getString("name"));
                System.out.print(rs.getDouble("salary"));
                System.out.print(rs.getDate("start"));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}