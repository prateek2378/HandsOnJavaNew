import model.Address;
import model.ContactInformation;
import model.Department;
import model.Employee;
import record.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    private static int noOfRecords = 0;
    private static List<Record> records = new ArrayList<Record>();
    private static int activeRecord = -1;

    private static void createNewRecord() {
        noOfRecords++;
        Record temp = new Record();
        records.add(temp);
    }
    private static void printAllRecords() {
        for (int i = 0; i < noOfRecords; i++) {
            System.out.println(i + 1 + ": Record" + (i + 1));
        }
    }

    private static int enterInt() {
        Scanner s = new Scanner(System.in);
        int newInt;
        while (!s.hasNextInt()) {
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newInt = s.nextInt();
        String temp = s.nextLine();
        return (newInt);
    }
    private static String enterString() {
        Scanner s = new Scanner(System.in);
        String newString;
        while (!s.hasNextLine()) {
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newString = s.nextLine();
        return (newString);
    }
    private static double enterDouble() {
        Scanner s = new Scanner(System.in);
        double newDouble;
        while (!s.hasNextDouble()) {
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newDouble = s.nextDouble();
        String temp = s.nextLine();
        return (newDouble);
    }
    private static long enterLong() {
        Scanner s = new Scanner(System.in);
        long newLong;
        while (!s.hasNextLong()) {
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newLong = s.nextLong();
        String temp = s.nextLine();
        return (newLong);
    }

    private static int enterID() {
        System.out.println("Enter ID:");
        int newID = enterInt();
        return (newID);
    }
    private static String enterName() {
        System.out.println("Enter Name:");
        String newName = enterString();
        return (newName);
    }
    private static Address enterAddress() {
        System.out.println("Enter Address ID:");
        int newAddressID = enterInt();

        System.out.println("Enter Address Line1:");
        String newAddressLine1 = enterString();

        System.out.println("Enter Address Line2:");
        String newAddressLine2 = enterString();

        System.out.println("Enter Landmark:");
        String newLandmark = enterString();

        System.out.println("Enter City:");
        String newCity = enterString();

        System.out.println("Enter State:");
        String newState = enterString();

        System.out.println("Enter Pin:");
        int newPin = enterInt();

        Address newAddress = new Address(newAddressID, newAddressLine1, newAddressLine2, newLandmark, newCity, newState, newPin);
        return (newAddress);
    }
    private static ContactInformation enterContactInformation() {
        System.out.println("Enter Contact Information ID:");
        int newContactInformationID = enterInt();

        System.out.println("Enter Phone Number:");
        long newPhoneNo = enterLong();

        System.out.println("Enter Email ID");
        String newEmailID = enterString();

        ContactInformation newContactInformation = new ContactInformation(newContactInformationID, newPhoneNo, newEmailID);
        return (newContactInformation);
    }
    private static Department enterDepartment() {
        System.out.println("Enter Department ID:");
        int newDepartmentID = enterInt();

        System.out.println("Enter Department Name");
        String newDepartmentName = enterString();

        Department newDepartment = new Department(newDepartmentID, newDepartmentName);
        return (newDepartment);
    }
    private static double enterSalary() {
        System.out.println("Enter Salary:");
        double newSalary = enterDouble();
        return (newSalary);
    }
    private static String enterDesignation() {
        System.out.println("Enter Designation");
        String newDesignation = enterString();
        return (newDesignation);
    }
    private static Date enterDateOfJoining() throws ParseException {
        System.out.println("Enter date of joining in dd/mm/yyyy format(Default is \'01/01/2021\' if incorrect date is entered)");
        String stringDate = enterString();
        Date newDateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021");
        try {
            newDateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (newDateOfJoining);
    }
    private static List<String> enterTechnologies() {
        System.out.println("Enter technologies (enter \'end\' to end entering technologies):");
        List<String> newTechnologies = new ArrayList<String>();
        while (true) {
            String temp = enterString();
            temp = temp.toLowerCase();
            if (temp.equalsIgnoreCase("end")) {
                break;
            } else {
                if (newTechnologies.contains(temp)) {
                    System.out.println("Already present");
                } else {
                    newTechnologies.add(temp);
                }
            }
        }
        return (newTechnologies);
    }
    private static int enterManagerID() {
        System.out.println("Enter Manager ID:");
        int newManagerID = enterInt();
        return (newManagerID);
    }

    private static void printMenu2() {
        System.out.println("Which field do you want to edit?");
        System.out.println("1: Edit ID");
        System.out.println("2: Edit Name");
        System.out.println("3: Edit Address");
        System.out.println("4: Edit Contact Information");
        System.out.println("5: Edit Department");
        System.out.println("6: Edit Salary");
        System.out.println("7: Edit Designation");
        System.out.println("8: Edit Date of Joining");
        System.out.println("9: Edit Technologies");
        System.out.println("10: Edit Manager");
        System.out.println("11: Go Back");
    }
    private static void printMenu1(){
        System.out.println("Choose a command for this record");
        System.out.println("1: No of employees in Record");
        System.out.println("2: Print all Employees in Record");
        System.out.println("3: Add an Employee");
        System.out.println("4: Get Employee Details");
        System.out.println("5: Edit an Employee's record");
        System.out.println("6: Delete an Employee's record");
        System.out.println("7: Go back");
    }
    private static void editID(Record newRecord,int ID){
        int newID = enterID();
        int outcome = newRecord.editID(ID, newID);
        if(outcome == 0){
            System.out.println("No such user exists");
        }
        else if(outcome == 1){
            System.out.println("Invalid new ID");
        }
        else{
            System.out.println("ID changed");
        }
    }
    private static void editName(Record newRecord,int ID){
        String newName = enterString();
        int outcome = newRecord.editName(ID, newName);
        if(outcome == 0){
            System.out.println("No such user found");
        }
        else{
            System.out.println("Name changed");
        }
    }
    private static void editAddress(Record newRecord,int ID){
        Address newAddress = enterAddress();
        int outcome = newRecord.editAddress(ID, newAddress);
        if(outcome == 0){
            System.out.println("No such user exists");
        }
        else{
            System.out.println("Address changed");
        }
    }
    private static void editContactInformation(Record newRecord,int ID){
        ContactInformation newContactInformation = enterContactInformation();
        int outcome = newRecord.editContactInformation(ID, newContactInformation);
    }
    private static void editDepartment(Record newRecord,int ID){
        Department newDepartment = enterDepartment();
        int outcome = newRecord.editDepartment(ID, newDepartment);
    }
    private static void editSalary(Record newRecord,int ID){
        double newSalary = enterSalary();
        int outcome = newRecord.editSalary(ID, newSalary);
    }
    private static void editDesignation(Record newRecord,int ID) {
        String newDesignation = enterDesignation();
        int outcome = newRecord.editDesignation(ID, newDesignation);
    }
    private static void editDateOfJoining(Record newRecord,int ID){
        Date newDateOfJoining = null;
        try {
            newDateOfJoining = enterDateOfJoining();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int outcome = newRecord.editDateOfJoining(ID, newDateOfJoining);
    }
    private static void editTechnologies(Record newRecord,int ID){
        List<String> newTechnologies = enterTechnologies();
        int outcome = newRecord.editTechnologies(ID, newTechnologies);
    }
    private static void editManager(Record newRecord,int ID){
        System.out.println("Manager");
        int newManagerID = enterID();
        int outcome = newRecord.editManager(ID, newManagerID);
        switch(outcome){
            case 0:{
                System.out.println("No such Employee found");
                break;
            }
            case 1:{
                System.out.println("Employee can't be its own manager");
                break;
            }
            case 2:{
                System.out.println("Reportee can't be employee's manager");
                break;
            }
            case 3:{
                System.out.println("Manager ID not Valid");
                break;
            }
            case 4:{
                System.out.println("Manager Changed");
                break;
            }
        }
    }

    private static void addEmployee(Record newRecord) {
        System.out.println("Ensure that you have entered manager details before entering employee details");
        System.out.println("Choose a command:");
        System.out.println("1: Proceed to add employee");
        System.out.println("Any other number: Cancel adding employee");
        int input = enterInt();
        if (input == 1) {
            int newID = enterID();
            String newName = enterName();
            Address newAddress = enterAddress();
            ContactInformation newContactInformation = enterContactInformation();
            Department newDepartment = enterDepartment();
            double newSalary = enterSalary();
            String newDesignation = enterDesignation();
            Date newDateOfJoining = null;
            try {
                newDateOfJoining = enterDateOfJoining();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<String> newTechnologies = enterTechnologies();
            int newManagerID = enterManagerID();
            List<Employee> newReportees = new ArrayList<Employee>();

            int outcome = newRecord.addEmployee(newID, newName, newAddress, newContactInformation, newDepartment, newSalary, newDesignation, newDateOfJoining, newTechnologies, newManagerID, newReportees);
            switch(outcome){
                case 0: {
                    System.out.println("New ID already present");
                    break; }
                case 1: {
                    System.out.println("Manager ID not valid");
                    break; }
                case 2: {
                    System.out.println("Employee added successfully");
                    break; }
            }
        }
    }
    private static void getDetails(Record newRecord){
        System.out.println("Enter Employee ID");
        int newID = enterInt();
        String details = newRecord.getDetails(newID);
        if(details == null){
            System.out.println("No such Employee in record");
        }
        else{
            System.out.println(details);
        }
    }
    private static void getAllDetails(Record newRecord){
        List<String> allDetails = newRecord.getAllDetails();
        for(String itr: allDetails){
            System.out.println(itr);
        }
    }
    private static void editDetails(Record currentRecord){
        int ID = enterID();
        boolean temp = true;
        while(temp){
            int command = 15;
            while(command>11 || command<1){
                printMenu2();
                command = enterInt();
            }
            switch(command) {
                case 1: {
                    editID(currentRecord,ID);
                    break;
                }
                case 2: {
                    editName(currentRecord, ID);
                    break;
                }
                case 3: {
                    editAddress(currentRecord, ID);
                    break;
                }
                case 4: {
                    editContactInformation(currentRecord, ID);
                    break;
                }
                case 5: {
                    editDepartment(currentRecord, ID);
                    break;
                }
                case 6: {
                    editSalary(currentRecord, ID);
                    break;
                }
                case 7: {
                    editDesignation(currentRecord, ID);
                    break;
                }
                case 8: {
                   editDateOfJoining(currentRecord, ID);
                    break;
                }
                case 9: {
                    editTechnologies(currentRecord, ID);
                    break;
                }
                case 10: {
                    editManager(currentRecord, ID);
                    break;
                }
                case 11: {
                    temp = false;
                    break;
                }
            }
        }
    }
    private static void deleteEmployee(Record newRecord){
        int newID = enterID();
        int outcome = newRecord.deleteEmployee(newID);
        if(outcome == 1){
            System.out.println("Employee deleted");
        }
        else{
            System.out.println("No such Employee");
        }
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Enter commands from the list below");
            if(noOfRecords == 0){
                System.out.println("1: Create new Record");
                System.out.println("2: Exit");
                int input = enterInt();
                if(input == 1){
                    createNewRecord();
                }
                else if(input == 2){
                    break;
                }
                else{
                    System.out.println("Wrong Input");
                }
            }
            else{
                System.out.println("1: Create new Record");
                System.out.println("2: Enter a record");
                System.out.println("3: Exit");
                int input = enterInt();
                if(input == 1){
                    createNewRecord();
                }
                else if(input == 2){
                    Record currentRecord;
                    while(true) {
                        System.out.println("Which record do you want to access?");
                        printAllRecords();
                        System.out.println(noOfRecords + 1 + ": Go Back");
                        int recordInput = enterInt();
                        if (recordInput <= noOfRecords) {
                            activeRecord = recordInput;
                            System.out.println("Entered Record" + activeRecord);
                            currentRecord = records.get(recordInput - 1);
                            boolean temp = true;
                            while(temp) {
                                int recordCommand = 15;
                                while(recordCommand>7 || recordCommand<1){
                                    printMenu1();
                                    recordCommand = enterInt();
                                }
                                switch(recordCommand) {
                                    case 1:{
                                        System.out.println(currentRecord.getNoOfEmployees());
                                        break;
                                    }
                                    case 2:{
                                        getAllDetails(currentRecord);
                                        break;
                                    }
                                    case 3:{
                                        addEmployee(currentRecord);
                                        break;
                                    }
                                    case 4:{
                                        getDetails(currentRecord);
                                        break;
                                    }
                                    case 5:{
                                        editDetails(currentRecord);
                                        break;
                                    }
                                    case 6:{
                                        deleteEmployee(currentRecord);
                                        break;
                                    }
                                    case 7:{
                                        currentRecord = null;
                                        activeRecord = -1;
                                        temp = false;
                                        break;
                                    }
                                }
                            }
                        }
                        else if (recordInput == noOfRecords + 1) {
                            break;
                        }
                        else {
                            System.out.println("Wrong Input");
                        }
                    }
                }
                else if(input == 3){
                    break;
                }
                else{
                    System.out.println("Wrong Input");
                }
            }
        }
    }
}
