import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExGroups {

    private static boolean validDate;
    private static String date;
    private static Matcher dateM;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String date;
        Pattern dateP = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");

        date = getDate(in, dateP);
        System.out.println("Us style date - " + date);

        in.close();

    }//end main method

    public static String getDate(Scanner in, Pattern dateP){


        do{

            //System.out.println("Enter a date (dd/mm/yyyy): ");
            //date =in.nextLine();
            //dateM = dateP.matcher(date);

            //if (dateM.matches()){

                String day = dateM.group(1);
                String month = dateM.group(2);
                String year = dateM.group(3);

              //  date = month + "/" + day + "/" + year;

            //}//end if



            validDate = validateDate(date);

            if(dateM.matches() && validDate){

                date = month + "/" + day + "/" + year;

            }

            else {
                System.out.println("Incorrect date entered!");
            }

        }while (!dateM.matches() && validDate); //end of do while loop

      return date;

    }//end getDate method

    public static boolean validateDate(String newDate){

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        format.setLenient(false);
        String date = newDate;

        try{

            format.parse(date);
            return true;

        } catch (ParseException e){

            System.out.println(date + " is not valid according to "
                               + ((SimpleDateFormat) format).toPattern() + " pattern.");
            return false;

        }//end try catch


    }//end newDate

}//end class
