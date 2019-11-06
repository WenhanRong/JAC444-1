package student;

public class Student {

    // Student Fields
    private String firstName;
    private String lastName;
    private Double grade;
    private String department;

     Student(final String fName, final String lName, final double _grade, final String _department){
        if(fName == null || lName == null || _department == null || _grade == 0.00)
            throw new NullPointerException();

        setFirstName(fName);
        setLastName(lName);
        setDepartment(_department);
        setGrade(_grade);
    }


    // ******************* Getter and Setter Method *******************
    //FIRST NAME
    String getFirstName() { return firstName; }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //LAST NAME
    String getLastName() {
        return lastName;
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // GRADE
    public Double getGrade() { return grade; }
    private void setGrade(Double grade) { this.grade = grade;   }

    // DEPARTMENT
    public String getDepartment() { return department; }
    private void setDepartment(String department) { this.department = department; }

    private String getName(){
        return getFirstName() + "\t" + getLastName();
    }




    // EQUAL METHOD
    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        if(firstName == null) {
            if(student.firstName != null) {
                return false;
            }
        } else if(!(firstName.equals(student.firstName))){
            return false;
        }
        if(lastName == null) {
            if(student.lastName != null) {
                return false;
            }
        } else if(!(lastName.equals(student.lastName))){
            return false;
        }
        if(grade == null) {
            if(student.grade != null) {
                return false;
            }
        } else if(!(grade.equals(student.grade))){
            return false;
        }
        if(department == null) {
            return student.department == null;
        } else return department.equals(student.department);
    }


    @Override
    public String toString() {
        return getName() + "\t" + getGrade() + "\t" + getDepartment();
    }
}
