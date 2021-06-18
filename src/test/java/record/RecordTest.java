package record;

import model.Address;
import model.ContactInformation;
import model.Department;
import model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

class RecordTest {

    Record newRecord;
    Address newAddress;
    Department newDepartment;
    ContactInformation newContactInformation;
    Date newDateOfJoining;
    List<String> newTechnologies;
    List<Employee> newReportees;

    @BeforeEach
    public void setup() throws ParseException {
        newRecord = new Record();
        newAddress = new Address(67,"chawla colony","ballabgarh","100 ft road","faridabad","haryana",121004);
        newDepartment = new Department(1,"DSF");
        newContactInformation = new ContactInformation(1,7042678092L,"prateek.goyal@wellsfargo.com");
        newDateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2020");
        newTechnologies = new ArrayList<>();
        newTechnologies.add("python");
        newTechnologies.add("Java");
        newReportees = new ArrayList<>();
    }

    @Test
    void addEmployee(){
        Assertions.assertEquals(2,newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees));
        Assertions.assertEquals(2,newRecord.addEmployee(3,"tanuj",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees));
        Assertions.assertEquals(1,newRecord.addEmployee(2,"newprateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, 5, newReportees));
        Assertions.assertEquals(0,newRecord.addEmployee(1,"newprateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees));
        System.out.println("----addEmployee working fine----");
    }

    @Test
    void deleteEmployee(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(0,newRecord.deleteEmployee(2));
        Assertions.assertEquals(1,newRecord.deleteEmployee(1));
        System.out.println("----deleteEmployees working fine----");
    }

    @Test
    void getNoOfEmployees(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(1,newRecord.getNoOfEmployees());
        Assertions.assertEquals(0,newRecord.deleteEmployee(2));
        Assertions.assertEquals(1,newRecord.getNoOfEmployees());
        Assertions.assertEquals(1,newRecord.deleteEmployee(1));
        Assertions.assertEquals(0,newRecord.getNoOfEmployees());
        System.out.println("----getNoOfEmployees working fine----");
    }

    @Test
    void getDetails(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertNull(newRecord.getDetails(3));
        Assertions.assertEquals("{ID: 1,Name: prateek,Address: {Address ID: 67,Address Line 1: chawla colony,Address Line 2: ballabgarh,Landmark: 100 ft road,City: faridabad,State: haryana,Pin: 121004},Contact Information: {Contact Information ID: 1,Phone Number: 7042678092,Email ID: prateek.goyal@wellsfargo.com},Department: {Department ID: 1,Department Name: DSF},Salary: 3000000.0,Designation: Program Associate,Date of Joining: Mon Aug 31 00:00:00 IST 2020,technologies: {python,Java},Manager: no manager,Reportees: }",newRecord.getDetails(1));
        System.out.println("----getDetails working fine----");
    }

    @Test
    void getAllDetails(){
        List<String> newAllDetails = new ArrayList<>();
        Assertions.assertEquals(newAllDetails,newRecord.getAllDetails());
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        newRecord.addEmployee(2,"tanuj",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, 1, newReportees);
        newAllDetails.add(newRecord.getDetails(1));
        newAllDetails.add(newRecord.getDetails(2));
        Assertions.assertEquals(newAllDetails,newRecord.getAllDetails());
        System.out.println("----getAllDetails working fine----");
    }

    @Test
    void editID(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(0,newRecord.editID(2,4));
        Assertions.assertEquals(1,newRecord.editID(1,-1));
        Assertions.assertEquals(1,newRecord.editID(1,1));
        Assertions.assertEquals(2,newRecord.editID(1,2));
        Assertions.assertEquals(2,newRecord.getEmployee(2).getID());
        System.out.println("----editID working fine----");
    }

    @Test
    void editName(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(0,newRecord.editName(2,"tanuj"));
        Assertions.assertEquals(1,newRecord.editName(1,"tanuj"));
        Assertions.assertEquals("tanuj",newRecord.getEmployee(1).getName());
        System.out.println("----editName working fine----");
    }

    @Test
    void editAddress(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Address newAddress1 = new Address(68,"chawla colony","ballabgarh","100 ft road","faridabad","haryana",121004);
        Assertions.assertEquals(0,newRecord.editAddress(2,newAddress1));
        Assertions.assertEquals(1,newRecord.editAddress(1,newAddress1));
        Address retrievedAddress = newRecord.getEmployee(1).getAddress();
        Assertions.assertEquals(newAddress1.getAddressID(),retrievedAddress.getAddressID());
        Assertions.assertEquals(newAddress1.getAddressLine1(),retrievedAddress.getAddressLine1());
        Assertions.assertEquals(newAddress1.getAddressLine2(),retrievedAddress.getAddressLine2());
        Assertions.assertEquals(newAddress1.getLandmark(),retrievedAddress.getLandmark());
        Assertions.assertEquals(newAddress1.getCity(),retrievedAddress.getCity());
        Assertions.assertEquals(newAddress1.getState(),retrievedAddress.getState());
        Assertions.assertEquals(newAddress1.getPin(),retrievedAddress.getPin());
        System.out.println("----editAddress working fine----");
    }

    @Test
    void editContactInformation(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        ContactInformation newContactInformation1 = new ContactInformation(2,7042678092L,"prateek.goyal@wellsfargo.com");
        Assertions.assertEquals(0,newRecord.editContactInformation(2,newContactInformation1));
        Assertions.assertEquals(1,newRecord.editContactInformation(1,newContactInformation1));
        Assertions.assertEquals(newContactInformation1.getContactInformationID(),newRecord.getEmployee(1).getContactInformation().getContactInformationID());
        Assertions.assertEquals(newContactInformation1.getPhoneNo(),newRecord.getEmployee(1).getContactInformation().getPhoneNo());
        Assertions.assertEquals(newContactInformation1.getEmailID(),newRecord.getEmployee(1).getContactInformation().getEmailID());
        System.out.println("----editContactInformation working fine----");
    }

    @Test
    void editDepartment(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Department newDepartment1 = new Department(2,"DSF");
        Assertions.assertEquals(0,newRecord.editDepartment(2,newDepartment1));
        Assertions.assertEquals(1,newRecord.editDepartment(1,newDepartment1));
        Assertions.assertEquals(newDepartment1.getDepartmentID(),newRecord.getEmployee(1).getDepartment().getDepartmentID());
        Assertions.assertEquals(newDepartment1.getDepartmentName(),newRecord.getEmployee(1).getDepartment().getDepartmentName());
        System.out.println("----editDepartment working fine----");
    }

    @Test
    void editSalary(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(0,newRecord.editSalary(2,2500000));
        Assertions.assertEquals(1,newRecord.editSalary(1,2500000));
        Assertions.assertEquals(2500000,newRecord.getEmployee(1).getSalary());
        System.out.println("----editSalary working fine----");
    }

    @Test
    void editDesignation(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Assertions.assertEquals(0,newRecord.editDesignation(2,"Software Engineer"));
        Assertions.assertEquals(1,newRecord.editDesignation(1,"Software Engineer"));
        Assertions.assertEquals("Software Engineer",newRecord.getEmployee(1).getDesignation());
        System.out.println("----editDesignation working fine----");
    }

    @Test
    void editDateOfJoining() throws ParseException {
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        Date newDateOfJoining1 = new SimpleDateFormat("dd/MM/yyyy").parse("31/09/2020");
        Assertions.assertEquals(0,newRecord.editDateOfJoining(2,newDateOfJoining1));
        Assertions.assertEquals(1,newRecord.editDateOfJoining(1,newDateOfJoining1));
        Assertions.assertEquals(newDateOfJoining1,newRecord.getEmployee(1).getDateOfJoining());
        System.out.println("----editDateOfJoining working fine----");
    }

    @Test
    void editTechnologies(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        newTechnologies.remove("python");
        newTechnologies.add("Junit");
        Assertions.assertEquals(0,newRecord.editTechnologies(2,newTechnologies));
        Assertions.assertEquals(1,newRecord.editTechnologies(1,newTechnologies));
        Assertions.assertEquals(newTechnologies,newRecord.getEmployee(1).getTechnologies());
        System.out.println("----editTechnologies working fine----");
    }

    @Test
    void editManager(){
        newRecord.addEmployee(1,"prateek",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, -1, newReportees);
        newRecord.addEmployee(2,"tanuj",newAddress,newContactInformation, newDepartment, 3000000, "Program Associate", newDateOfJoining, newTechnologies, 1, newReportees);
        Assertions.assertEquals(0,newRecord.editManager(3,1));
        Assertions.assertEquals(1,newRecord.editManager(1,1));
        Assertions.assertEquals(2,newRecord.editManager(1,2));
        Assertions.assertEquals(3,newRecord.editManager(1,3));
        Assertions.assertEquals(4,newRecord.editManager(2,-1));
        Assertions.assertNull(newRecord.getEmployee(2).getManager());
        Assertions.assertEquals(4,newRecord.editManager(1,2));
        Assertions.assertEquals(2,newRecord.getEmployee(1).getManager().getID());
        System.out.println("----editManager working fine----");
    }
}