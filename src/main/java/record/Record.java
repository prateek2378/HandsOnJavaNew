package record;

import model.Address;
import model.ContactInformation;
import model.Department;
import model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Record {
    private List<Employee> employee;
    private List<Integer> employeeIDs;
    private int noOfEmployees;

    public Record(){
        employee = new ArrayList<Employee>();
        employeeIDs = new ArrayList<Integer>();
        noOfEmployees = 0;
    }

    public int getNoOfEmployees(){
        return(noOfEmployees);
    }
    public List<Integer> getEmployeeIDS(){
        return employeeIDs;
    }
    public List<Employee> getEmployee(){
        return employee;
    }

    private String printEmployee(Employee newEmployee){
        String stringEmployee = "{";
        stringEmployee = stringEmployee.concat("ID: ");
        stringEmployee = stringEmployee.concat(String.valueOf(newEmployee.getID()));
        stringEmployee = stringEmployee.concat(",Name: ");
        stringEmployee = stringEmployee.concat(newEmployee.getName());
        stringEmployee = stringEmployee.concat(",Address: ");
        stringEmployee = stringEmployee.concat(printAddress(newEmployee.getAddress()));
        stringEmployee = stringEmployee.concat(",Contact Information: ");
        stringEmployee = stringEmployee.concat(printContactInformation(newEmployee.getContactInformation()));
        stringEmployee = stringEmployee.concat(",Department: ");
        stringEmployee = stringEmployee.concat(printDepartment(newEmployee.getDepartment()));
        stringEmployee = stringEmployee.concat(",Salary: ");
        stringEmployee = stringEmployee.concat(String.valueOf(newEmployee.getSalary()));
        stringEmployee = stringEmployee.concat(",Designation: ");
        stringEmployee = stringEmployee.concat(newEmployee.getDesignation());
        stringEmployee = stringEmployee.concat(",Date of Joining: ");
        stringEmployee = stringEmployee.concat(String.valueOf(newEmployee.getDateOfJoining()));
        stringEmployee = stringEmployee.concat(",technologies: ");
        stringEmployee = stringEmployee.concat("{");
        stringEmployee = stringEmployee.concat(String.join(",",newEmployee.getTechnologies()));
        stringEmployee = stringEmployee.concat("}");
        stringEmployee = stringEmployee.concat(",Manager: ");
        if(newEmployee.getManager() != null) {
            stringEmployee = stringEmployee.concat(String.valueOf(newEmployee.getManager().getID()));
        }
        else{
            stringEmployee = stringEmployee.concat("no manager");
        }
        stringEmployee = stringEmployee.concat(",Reportees: ");
        for(Employee itr : newEmployee.getReportees()){
            stringEmployee = stringEmployee.concat(String.valueOf(itr.getID())+" ");
        }
        stringEmployee = stringEmployee.concat("}");

        return(stringEmployee);
    }
    private String printDepartment(Department newDepartment){
        String stringDepartment = "{";
        stringDepartment = stringDepartment.concat("Department ID: ");
        stringDepartment = stringDepartment.concat(String.valueOf(newDepartment.getDepartmentID()));
        stringDepartment = stringDepartment.concat(",Department Name: ");
        stringDepartment = stringDepartment.concat(newDepartment.getDepartmentName());
        stringDepartment = stringDepartment.concat("}");

        return(stringDepartment);
    }
    private String printContactInformation(ContactInformation newContactInformation){
        String stringContactInformation = "{";
        stringContactInformation = stringContactInformation.concat("Contact Information ID: ");
        stringContactInformation = stringContactInformation.concat(String.valueOf(newContactInformation.getContactInformationID()));
        stringContactInformation = stringContactInformation.concat(",Phone Number: ");
        stringContactInformation = stringContactInformation.concat(String.valueOf(newContactInformation.getPhoneNo()));
        stringContactInformation = stringContactInformation.concat(",Email ID: ");
        stringContactInformation = stringContactInformation.concat(newContactInformation.getEmailID());
        stringContactInformation = stringContactInformation.concat("}");

        return(stringContactInformation);
    }
    private String printAddress(Address newAddress){
        String stringAddress = "{";
        stringAddress = stringAddress.concat("Address ID: ");
        stringAddress = stringAddress.concat(String.valueOf(newAddress.getAddressID()));
        stringAddress = stringAddress.concat(",Address Line 1: ");
        stringAddress = stringAddress.concat(newAddress.getAddressLine1());
        stringAddress = stringAddress.concat(",Address Line 2: ");
        stringAddress = stringAddress.concat(newAddress.getAddressLine2());
        stringAddress = stringAddress.concat(",Landmark: ");
        stringAddress = stringAddress.concat(newAddress.getLandmark());
        stringAddress = stringAddress.concat(",City: ");
        stringAddress = stringAddress.concat(newAddress.getCity());
        stringAddress = stringAddress.concat(",State: ");
        stringAddress = stringAddress.concat(newAddress.getState());
        stringAddress = stringAddress.concat(",Pin: ");
        stringAddress = stringAddress.concat(String.valueOf(newAddress.getPin()));
        stringAddress = stringAddress.concat("}");

        return(stringAddress);
    }

    private boolean validateNewID(int newID){
        if(newID==-1 || employeeIDs.contains(newID)){
            return false;
        }
        return true;
    }
    private boolean validateNewManagerID(int newManagerID){
        if(!employeeIDs.contains(newManagerID) && newManagerID!=-1){
            return false;
        }
        return true;
    }
    private boolean validateID(int newID){
        if(employeeIDs.contains(newID)){
            return true;
        }
        return false;
    }
    private void addReportees(Employee newManager, Employee newEmployee){
        List<Employee> newReportees = newManager.getReportees();
        newReportees.add(newEmployee);
        newManager.setReportees(newReportees);
    }

    public int addEmployee(int newID, String newName, Address newAddress, ContactInformation newContactInformation, Department newDepartment, double newSalary, String newDesignation, Date newDateOfJoining, List<String> newTechnologies, int newManagerID, List<Employee> newReportees){
        if(validateNewID(newID)){
            if(validateNewManagerID(newManagerID)){
                if(newManagerID!=-1){
                    int indexOfManager = employeeIDs.indexOf(newManagerID);
                    Employee newManager = employee.get(indexOfManager);
                    Employee newEmployee = new Employee(newID, newName, newAddress, newContactInformation, newDepartment, newSalary, newDesignation, newDateOfJoining, newTechnologies, newManager, newReportees);
                    addReportees(newManager, newEmployee);
                    employee.add(newEmployee);
                    employeeIDs.add(newID);
                    noOfEmployees++;
                    return 2;
                }
                else{
                    Employee newEmployee = new Employee(newID, newName, newAddress, newContactInformation, newDepartment, newSalary, newDesignation, newDateOfJoining, newTechnologies, null, newReportees);
                    employee.add(newEmployee);
                    employeeIDs.add(newID);
                    noOfEmployees++;
                    return 2;
                }
            }
            else{
                return 1;
            }
        }
        else{
            return 0;
        }

    }
    public String getDetails(int newID){
        if(validateID(newID)){
            int indexOfEmployee = employeeIDs.indexOf(newID);
            Employee newEmployee = employee.get(indexOfEmployee);
            return printEmployee(newEmployee);
        }
        else{
            return null;
        }
    }
    public List<String> getAllDetails(){
        List<String> allDetails = new ArrayList<String>();
        for(Employee itr: employee){
            allDetails.add(getDetails(itr.getID()));
        }
        return allDetails;
    }
    public int deleteEmployee(int newID) {
        if (employeeIDs.contains(newID)) {
            Employee newEmployee = employee.get(employeeIDs.indexOf(newID));
            Employee newEmployeeManager = newEmployee.getManager();
            if (newEmployeeManager != null) {
                List<Employee> newEmployeeManagerReportees = newEmployeeManager.getReportees();
                newEmployeeManagerReportees.remove(newEmployee);
                List<Employee> newEmployeeReportees = newEmployee.getReportees();
                for (Employee itr : newEmployeeReportees) {
                    newEmployeeManagerReportees.add(itr);
                    itr.setManager(newEmployeeManager);
                }
            } else {
                List<Employee> newEmployeeReportees = newEmployee.getReportees();
                for (Employee itr : newEmployeeReportees) {
                    itr.setManager(null);
                }
            }
            employee.remove(employeeIDs.indexOf(newID));
            employeeIDs.remove(employeeIDs.indexOf(newID));
            noOfEmployees--;
            return 1;
        }
        return 0;
    }
    public int editID(int oldID, int newID){
        if(employeeIDs.contains(oldID)){
            if(newID != oldID){
                if(validateNewID(newID)){
                    int indexOfEmployee = employeeIDs.indexOf(oldID);
                    Employee oldEmployee = employee.get(indexOfEmployee);
                    employeeIDs.set(indexOfEmployee,newID);
                    oldEmployee.setID(newID);
                    return 2;
                }
            }
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editName(int oldID, String newName){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setName(newName);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editAddress(int oldID, Address newAddress){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setAddress(newAddress);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editContactInformation(int oldID, ContactInformation newContactInformation){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setContactInformation(newContactInformation);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editDepartment(int oldID, Department newDepartment){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setDepartment(newDepartment);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editSalary(int oldID, double newSalary){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setSalary(newSalary);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editDesignation(int oldID, String newDesignation){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setDesignation(newDesignation);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editDateOfJoining(int oldID, Date newDateOfJoining){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setDateOfJoining(newDateOfJoining);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editTechnologies(int oldID, List<String> newTechnologies){
        if(employeeIDs.contains(oldID)){
            int indexOfEmployee = employeeIDs.indexOf(oldID);
            Employee newEmployee = employee.get(indexOfEmployee);
            newEmployee.setTechnologies(newTechnologies);
            return 1;
        }
        else{
            return 0;
        }
    }
    public int editManager(int oldID, int newManagerID){
        if(employeeIDs.contains(oldID)){
            if(validateNewManagerID(newManagerID)) {
                if(newManagerID == oldID){
                    return 1;
                }
                int indexOfEmployee = employeeIDs.indexOf(oldID);
                Employee newEmployee = employee.get(indexOfEmployee);
                for(Employee itr: newEmployee.getReportees()){
                    if(newManagerID == itr.getID()){
                        return 2;
                    }
                }
                Employee oldManager = newEmployee.getManager();
                if(oldManager != null){
                    List<Employee> oldManagerReportees = oldManager.getReportees();
                    oldManagerReportees.remove(newEmployee);
                }
                if(newManagerID == -1){
                    newEmployee.setManager(null);
                }
                else{
                    int indexOfNewManager = employeeIDs.indexOf(newManagerID);
                    Employee newManager = employee.get(indexOfNewManager);
                    addReportees(newManager, newEmployee);
                    newEmployee.setManager(newManager);
                }
                return 4;
            }
            else{
                return 3;
            }
        }
        else{
            return 0;
        }
    }
}
