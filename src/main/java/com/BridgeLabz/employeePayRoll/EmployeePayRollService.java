package com.BridgeLabz.employeePayRoll;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class EmployeePayRollService {
    //Actually tells me to where I can write date like i have declared enum
    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayRollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }
    ///welcome message//
    public void printWelcomeMessage(){
        System.out.println("Welcome To The Employee PayRoll Service");
    }
    public EmployeePayRollService(){
        employeePayrollList=new ArrayList<>();
    }
    ///main method to take input from user///
    public static void main(String [] args){
        EmployeePayRollService employeePayRollService =new EmployeePayRollService();
        employeePayRollService.printWelcomeMessage();
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayRollData(IOService.CONSOLE_IO);
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
    void writeEmployeePayRollData(IOService ioService){
        if (ioService.equals(ioService.CONSOLE_IO))
            System.out.println("\nWriting Employee PayRoll Roaster To Consle\n" + employeePayrollList);
        else if (ioService.equals(ioService.FILE_IO))new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }
    /***
     *
     */
    public void printData(IOService ioService){
        if (ioService.equals(ioService.FILE_IO))new EmployeePayrollFileIOService().printData();
    }

    /*
    count entries in file
    @param ioService
    @return
     */
    public long countEntries(IOService ioService){
        if(ioService.equals(ioService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
    ////read data from file///
    public List<EmployeePayrollData> readPayRollData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayrollList=new EmployeePayrollFileIOService().readData();
        return employeePayrollList;
    }
}
