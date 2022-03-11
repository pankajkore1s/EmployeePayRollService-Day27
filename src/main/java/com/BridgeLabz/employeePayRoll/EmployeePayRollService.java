package com.BridgeLabz.employeePayRoll;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class EmployeePayRollService {
    private final List<EmployeePayrollData> employeePayrollList;
    public void printWelcomeMessage(){
        System.out.println("Welcome To The Employee PayRoll Service");
    }
    public EmployeePayRollService(){
        employeePayrollList=new ArrayList<>();
    }
    public static void main(String [] args){
        EmployeePayRollService employeePayRollService =new EmployeePayRollService();
        employeePayRollService.printWelcomeMessage();
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayRollData();
    }
    private void readEmployeePayRollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID");
        int id=consoleInputReader.nextInt();
        System.out.println("Enter Employee Name");
        String name=consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary=consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));
    }
    private void writeEmployeePayRollData(){
        System.out.println("\nWriting Employee PayRoll to console\n" + employeePayrollList);
    }
}
