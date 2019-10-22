package sample;

import javafx.event.Event;
import javafx.fxml.FXML;

import java.awt.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {

    ArrayList<Student> sArray = new ArrayList<>();

    @FXML //fx:id="first_name";
    private TextField first_name;

    @FXML //fx:id="last_name";
    private TextField last_name;

    @FXML //fx:id="ps_id";
    private TextField ps_id;

    @FXML //fx:id="grade_level";
    private TextField grade_level;

    @FXML //fx:id="email_address";
    private TextField email_address;

    @FXML //fx:id="street_address";
    private TextField street_address;

    @FXML //fx:id="city";
    private TextField city;

    @FXML //fx:id="state";
    private TextField state;

    @FXML //fx:id="zipcode";
    private TextField zipcode;

    @FXML //fx:id="fnLabel";
    private Label fnLabel;

    @FXML //fx:id="lnLabel";
    private Label lnLabel;

    @FXML //fx:id="psLabel";
    private Label psLabel;

    @FXML //fx:id="glLabel";
    private Label glLabel;

    @FXML //fx:id="eaLabel";
    private Label eaLabel;

    @FXML //fx:id="saLabel";
    private Label saLabel;

    @FXML //fx:id="stLabel";
    private Label stLabel;

    @FXML //fx:id="ciLabel";
    private Label ciLabel;

    @FXML //fx:id="zcLabel";
    private Label zcLabel;

    @FXML //fx:id="submitLabel";
    private Label submitLabel;

    public void buttonPressed(Event evt)
    {
        print();
    }

    public void print()
    {
        createStudent(sArray);
        System.out.println("Student Details, Department of ILT");
        System.out.println("----------------------------------");
        for(int i = 0; i < sArray.size(); i++)
        {
            sArray.get(i).displayInfo();
            System.out.println("\n");
        }
        System.out.println("Number of students: " + sArray.get(0).getCount());
    }

    public static boolean nameValidate(String x)
    {
        int length = x.length();
        boolean result = true;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
            boolean digitCheck = Character.isDigit(c);
            if (digitCheck == true) {
                result = false;
                i = length;
            }

        }
        return result;
    }

    public static boolean numValidate(String x)
    {
        int length = x.length();
        boolean result = true;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
            boolean digitCheck = Character.isDigit(c);
            if (!digitCheck) {
                result = false;
                i = length;
            }

        }
        return result;
    }

    public static boolean emailValidate(String x)
    {
        boolean check = x.contains("@");
        if(check)
        {
            check = x.contains(".");
            if(check)
            {
                int tldpos = x.indexOf('.');
                String tldCheck = x.substring(tldpos);
                if((tldCheck.equals(".com")) || (tldCheck.equals(".org")) || (tldCheck.equals(".edu")))
                {
                    return true;
                }
                else
                {
                    System.out.println("Make sure your email includes a top level domain (.com, .org. or .edu).");
                    return false;
                }

            }
            else
            {
                System.out.println("Did your email have a \".\" before the top level domain?");
                return false;
            }

        }
        else
        {
            System.out.println("Did your email include an \"@\" symbol?");
            return false;
        }
    }

    public static boolean addressValidate(String x)
    {
        int length = x.length();
        int firstspacepos = 0;
        int numberInStreet = 0;
        boolean digitCheck = true;
        boolean result = true;
        int count = 0;
        for(int i = 0; i < length; i++) {
            Character c = x.charAt(i);
            digitCheck = Character.isDigit(c);
            if (!digitCheck) {
                firstspacepos = (i+1);
                i = length;
            }
            else
            {
                if(count == (length-1))
                {
                    result = false;
                }
                else
                {
                    count++;
                }
            }

        }

        String streetName = x.substring(firstspacepos);
        boolean check = nameValidate(streetName);
        if(!check) {
            length = streetName.length();
            for (int n = 0; n < length; n++) {
                Character v = streetName.charAt(n);
                digitCheck = Character.isDigit(v);
                if (digitCheck) {
                    numberInStreet = n;
                    String posCheck = streetName.substring(numberInStreet);
                    if (!(posCheck.contains("nd") || posCheck.contains("st") || posCheck.contains("rd") || posCheck.contains("th"))) {
                        result = false;
                        System.out.println("Please make sure that you entered your street name properly.");
                        n = length;
                    }
                    else
                    {
                        n =length;
                    }
                }
            }

        }
        return result;
    }

    public static boolean stateValidate(String x)
    {
        String stateArray[] = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
                "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT",
                "WA", "WI", "WV", "WY" };
        for(int i = 0; i<50; i++)
        {
            if(x.equals(stateArray[i]))
            {
                return true;
            }
        }

        return false;

    }

    public static boolean lengthCheck(int x, Integer y)
    {
        int check = y.toString().length();
        if(check != x)
        {
            return false;
        }
        else
        { return true;}
    }

    public void createStudent(ArrayList<Student> x)
    {
        int count =0;

        String fnameTemp ="", lnameTemp = "", gradeTemp = "", emailTemp = "", addressTemp ="", cityTemp="", stateTemp ="";
        Integer psTemp = 0, zipTemp = 0;

            fnameTemp = first_name.getText();
            boolean check = nameValidate(fnameTemp);
            if(!check)
            {
                fnLabel.setVisible(true);
                fnLabel.setText("Please check this field.");
                count++;
            }


            lnameTemp = last_name.getText();
            check = nameValidate(lnameTemp);
            if(!check)
            {
                lnLabel.setVisible(true);
                lnLabel.setText("Please check this field.");
                count++;
            }




            String psTempAsString = ps_id.getText();

            check = numValidate(psTempAsString);
            if(check)
            {
                psTemp = Integer.parseInt(psTempAsString);
                check = lengthCheck(7,psTemp);
                if(!check)
                {
                    psLabel.setVisible(true);
                    psLabel.setText("Please check this field.");
                    count++;
                }
            }
            else
            {
                psLabel.setVisible(true);
                psLabel.setText("Please check this field.");
                count++;
            }



            gradeTemp = grade_level.getText();
            check = nameValidate(gradeTemp);
            if(!check)
            {
                glLabel.setVisible(true);
                glLabel.setText("Please check this field.");
                count++;
            }


            emailTemp = email_address.getText();
            check = emailValidate(emailTemp);
            if(!check)
            {
                eaLabel.setVisible(true);
                eaLabel.setText("Please check this field.");
                count++;
            }



            addressTemp = street_address.getText();
            check = addressValidate(addressTemp);
            if(!check)
            {
                saLabel.setVisible(true);
                saLabel.setText("Please check this field.");
                count++;
            }



            cityTemp = city.getText();
            check = nameValidate(cityTemp);
            if(!check)
            {
                ciLabel.setVisible(true);
                ciLabel.setText("Please check this field.");
                count++;
            }



            stateTemp = state.getText();
            check = stateValidate(stateTemp);
            if(!check)
            {
                stLabel.setVisible(true);
                stLabel.setText("Please check this field.");
                count++;
            }




            String zipTempAsString = zipcode.getText();

            check = numValidate(zipTempAsString);
            if(check)
            {
                zipTemp = Integer.parseInt(zipTempAsString);
                check = lengthCheck(5,zipTemp);
                if(!check) {
                    zcLabel.setVisible(true);
                    zcLabel.setText("Please check this field.");
                    count++;
                }
            }
            else
            {
                zcLabel.setVisible(true);
                zcLabel.setText("Please check this field.");
                count++;
            }

        if(count == 0) {
            x.add(new Student(fnameTemp, lnameTemp, psTemp, gradeTemp, emailTemp, addressTemp, cityTemp, stateTemp, zipTemp));
            x.get(0).incrementCount();
            submitLabel.setTextFill(Color.web("#2b00ff"));
            fnLabel.setVisible(false);
            lnLabel.setVisible(false);
            saLabel.setVisible(false);
            stLabel.setVisible(false);
            ciLabel.setVisible(false);
            glLabel.setVisible(false);
            eaLabel.setVisible(false);
            zcLabel.setVisible(false);
            psLabel.setVisible(false);
            first_name.setText("");
            last_name.setText("");
            email_address.setText("");
            grade_level.setText("");
            street_address.setText("");
            ps_id.setText("");
            city.setText("");
            zipcode.setText("");
            state.setText("");
            submitLabel.setVisible(true);
            submitLabel.setText("Submission Successful!");
        }
        else
        {
            submitLabel.setVisible(true);
            submitLabel.setText("Submission Failed!");
            submitLabel.setTextFill(Color.web("#ff0000"));
        }

    }



}
