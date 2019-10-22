package sample;
public class Student {
    private String fname;
    private String lname;
    private Integer psID;
    private String gradeLevel;
    private String email;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    static int count;

    public int getCount()
    {
        return count;
    }

    public void incrementCount()
    {
        count++;
    }

    public Student(String firstname, String lastname, Integer peoplesoft, String grade, String emailAddress, String stAddress, String cityA, String stateA, Integer zipcode)
    {
        fname = firstname;
        lname = lastname;
        psID = peoplesoft;
        gradeLevel = grade;
        email = emailAddress;
        address = stAddress;
        city = cityA;
        state = stateA;
        zip = zipcode;
    }

    public void displayInfo()
    {
        System.out.println(fname + "\t" + lname + "\t" + psID + "\t" + gradeLevel + "\t" + email + "\t" + address + "\t" + city + "\t" + state+ "\t" + zip);
    }



}
