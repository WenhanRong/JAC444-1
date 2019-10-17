package students;
import java.util.ArrayList;

 public class Students implements java.io.Serializable {

    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    public Students() {                 //initialises arrayList
        courses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName ;
    }       // getter First Name
     public String getLastName() {
         return lastName;
     }          // getter Last name


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }       // First name setter

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }           //Last name setter

    public int getStdID() {
        return stdID;
    }                   // getter ID

    public void setStdID(int stdID) throws Exception {          // ID setter
        if(stdID > 0) {
            this.stdID = stdID;
        }
        else {
            throw new Exception("Invalid student ID!");
        }
    }

    public ArrayList<String> getCourses() {
        return courses;
    }           // Get courses getter

    public void setCourses(String courses) {                // courses Setter
        this.courses.add(courses);
    }
}