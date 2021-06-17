package model;

public class Address {
    private int addressID;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String city;
    private String state;
    private int pin;

    public Address(int newAddressID, String newAddressLine1, String newAddressLine2, String newLandmark, String newCity, String newState, int newPin){
        addressID = newAddressID;
        addressLine1 = newAddressLine1;
        addressLine2 = newAddressLine2;
        landmark = newLandmark;
        city = newCity;
        state = newState;
        pin = newPin;
    }

    public int getAddressID(){
        return(addressID);
    }
    public void setAddressID(int newAddressID){
        addressID = newAddressID;
    }
    public String getAddressLine1(){
        return(addressLine1);
    }
    public void setAddressLine1(String newAddressLine1){
        addressLine1 = newAddressLine1;
    }
    public String getAddressLine2(){
        return(addressLine2);
    }
    public void setAddressLine2(String newAddressLine2){
        addressLine2 = newAddressLine2;
    }
    public String getLandmark(){
        return(landmark);
    }
    public void setLandmark(String newLandmark){
        landmark = newLandmark;
    }
    public String getCity(){
        return(city);
    }
    public void setCity(String newCity){
        city = newCity;
    }
    public String getState(){
        return(state);
    }
    public void setState(String newState){
        state = newState;
    }
    public int getPin(){
        return(pin);
    }
    public void setPin(int newPin){
        pin = newPin;
    }
}