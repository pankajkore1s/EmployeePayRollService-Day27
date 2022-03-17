package com.BridgeLabz.employeePayRoll;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE_NAME="payroll-file.txt";
    public void writeData(List<EmployeePayrollData> employeePayrollList){
        StringBuffer empBuffer=new StringBuffer();
        employeePayrollList.forEach(employee ->{
            String employeeDataString=employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        ///writing in file//
        try{
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //print dada//
    public void printData(){
        try{
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /*count entries*/
    public long countEntries(){
        long entries=0;
        try{
            entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return entries;
    }
}
