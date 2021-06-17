package model;

public class Department {
    private int departmentID;
    private String departmentName;

    public Department(int newDepartmentID, String newDepartmentName){
        departmentID = newDepartmentID;
        departmentName = newDepartmentName;
    }

    public int getDepartmentID(){
        return(departmentID);
    }
    public void setDepartmentID(int newDepartmentID){
        departmentID = newDepartmentID;
    }
    public String getDepartmentName(){
        return(departmentName);
    }
    public void setDepartmentName(String newDepartmentName){
        departmentName = newDepartmentName;
    }
}
