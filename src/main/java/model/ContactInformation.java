package model;

public class ContactInformation {
    private int contactInformationID;
    private long phoneNo;
    private String emailID;

    public ContactInformation(int newContactInformationID, long newPhoneNo, String newEmailID){
        contactInformationID = newContactInformationID;
        phoneNo = newPhoneNo;
        emailID = newEmailID;
    }

    public int getContactInformationID(){
        return(contactInformationID);
    }
    public void setContactInformationID(int newContactInformationID){
        contactInformationID = newContactInformationID;
    }
    public long getPhoneNo(){
        return(phoneNo);
    }
    public void setPhoneNo(long newPhoneNo){
        phoneNo = newPhoneNo;
    }
    public String getEmailID(){
        return(emailID);
    }
    public void setEmailID(String newEmailID){
        emailID = newEmailID;
    }
}
