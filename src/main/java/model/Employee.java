package model;
import java.util.*;


public class Employee {
    private int ID;
    private String name;
    private Address address;
    private ContactInformation contactInformation;
    private Department department;
    private double salary;
    private String designation;
    private Date dateOfJoining;
    private List<String> technologies;
    private Employee manager;
    private List<Employee> reportees;

    public Employee(int newID, String newName, Address newAddress, ContactInformation newContactInformation, Department newDepartment, double newSalary, String newDesignation, Date newDateOfJoining, List<String> newTechnologies, Employee newManager, List<Employee> newReportees){
        ID = newID;
        name = newName;
        address = newAddress;
        contactInformation = newContactInformation;
        department = newDepartment;
        salary = newSalary;
        designation = newDesignation;
        dateOfJoining = newDateOfJoining;
        technologies = newTechnologies;
        manager = newManager;
        reportees = newReportees;
    }

    public int getID(){
        return(ID);
    }
    public void setID(int newID){
        ID = newID;
    }
    public String getName(){
        return(name);
    }
    public void setName(String newName){
        name = newName;
    }
    public Address getAddress(){
        return(address);
    }
    public void setAddress(Address newAddress){
        address.setAddressID(newAddress.getAddressID());
        address.setAddressLine1(newAddress.getAddressLine1());
        address.setAddressLine2(newAddress.getAddressLine2());
        address.setState(newAddress.getState());
        address.setCity(newAddress.getCity());
        address.setLandmark(newAddress.getLandmark());
        address.setPin(newAddress.getPin());
    }
    public ContactInformation getContactInformation() {
        return (contactInformation);
    }
    public void setContactInformation(ContactInformation newContactInformation){
        contactInformation.setContactInformationID(newContactInformation.getContactInformationID());
        contactInformation.setEmailID(newContactInformation.getEmailID());
        contactInformation.setPhoneNo(newContactInformation.getPhoneNo());
    }
    public Department getDepartment(){
        return(department);
    }
    public void setDepartment(Department newDepartment){
        department.setDepartmentName(newDepartment.getDepartmentName());
        department.setDepartmentID(newDepartment.getDepartmentID());
    }
    public double getSalary(){
        return(salary);
    }
    public void setSalary(double newSalary){
        salary = newSalary;
    }
    public String getDesignation(){
        return(designation);
    }
    public void setDesignation(String newDesignation){
        designation = newDesignation;
    }
    public Date getDateOfJoining(){
        return(dateOfJoining);
    }
    public void setDateOfJoining(Date newDateOfJoining){
        dateOfJoining = newDateOfJoining;
    }
    public List<String> getTechnologies(){
        return(technologies);
    }
    public void setTechnologies(List<String> newTechnologies){
        technologies = newTechnologies;
    }
    public Employee getManager(){
        return(manager);
    }
    public void setManager(Employee newManager){
        manager = newManager;
    }
    public List<Employee> getReportees(){
        return(reportees);
    }
    public void setReportees(List<Employee> newReportees){
        reportees = newReportees;
    }
}
