package com.BridgeLabz.employeePayRoll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static com.BridgeLabz.employeePayRoll.EmployeePayRollService.IOService.FILE_IO;

public class EmployeePayRollServiceTest {
    static EmployeePayRollService employeePayrollService = new EmployeePayRollService();

    /**
     * Test case for printing welcome message
     */
    @Test
    public void printWelcomeMessage() {
        employeePayrollService.printWelcomeMessage();
    }

    /**
     * test case to write data to the file
     */
    @Test
    public void given3Employees_WhenWrittenTo_FileShouldMatch_EmployeeEntries() {
        EmployeePayrollData[] arrayOfEmployees={
                new EmployeePayrollData(1,"Jeff Bezos",100000.0),
                new EmployeePayrollData(2,"Bill Gates",500000.0),
                new EmployeePayrollData(3,"Elon Musk",4000000.0)};

        EmployeePayRollService employeePayrollService;
        employeePayrollService = new EmployeePayRollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writeEmployeePayRollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries=employeePayrollService.countEntries(FILE_IO);
        Assertions.assertEquals(3,entries);
    }

    @Test
    public void givenFileOn_ReadingFrom_File_ShouldMatch_EmployeeCount(){
        EmployeePayRollService employeePayRollService =new EmployeePayRollService();
        List<EmployeePayrollData> count=employeePayRollService.readPayRollData(FILE_IO);
        long countEntries=employeePayrollService.countEntries(FILE_IO);
        Assertions.assertEquals(3,countEntries);
    }
}
