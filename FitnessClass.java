import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.PrintStream;
import myPackage.Location;
/**
 *  FitnessClass class that keeps track of all the gym classes available for members to sign up for
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class FitnessClass {
    private String classType;
    private String fitnessInstructor;
    private Time classTime;
    private ArrayList<Member> classList = new ArrayList<Member>(0);
    private ArrayList<Member> studentList = new ArrayList<Member>(0);
    private ArrayList<Member> guestList = new ArrayList<Member>(0);
    private Location location;

    /**
     * Constructor for the FitnessClass object
     *
     * @param classType
     * @param instructorName
     * @param classStartingTime
     */
    public FitnessClass(String classType, String instructorName, Time classStartingTime, String location) {
        this.classType = classType;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
        if (location.equalsIgnoreCase("piscataway")) {
            this.location = Location.PISCATAWAY;
        } else if (location.equalsIgnoreCase("bridgewater")) {
            this.location = Location.BRIDGEWATER;
        } else if (location.equalsIgnoreCase("edison")) {
            this.location = Location.EDISON;
        } else if (location.equalsIgnoreCase("franklin")) {
            this.location = Location.FRANKLIN;
        } else {
            this.location = Location.SOMERVILLE;
        }

    }

    /**
     * Getter method for the classType
     *
     * @return
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Method that adds students to the list when they want to check-in
     *
     * @param member
     */
    public void addStudent(Member member) {
        studentList.add(member);
    }

    public int findStudent(Member member) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals(member)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Method that prints the list of students in inputted class
     */
    public void printStudentList() {
        if (this.studentList.size() > 0) {
            int arraySize = studentList.size();
            for (int i = 0; i < arraySize; i++) {
                if (studentList.size() > 1) {
                    studentList.toString();
                }
                System.out.println("empty class");
            }
        } else {
            System.out.println("class does not exist");
        }
        System.out.println("class does not exist");
    }

    /**
     * Method to remove a student from the class list if they decide they do not want to go to the class anymore
     *
     * @param cancelStudent
     * @return new array with updated information and the cancelled student is removed.
     */
    public String removeStudent(Member cancelStudent) {
        if (this.classType.equals(classType)) {
            for (int i = 0; i < studentList.size(); i++) {
                studentList.remove(cancelStudent);
            }
        }
        return cancelStudent.getFirstName() + " " + cancelStudent.getLastName() + " is not a participant in " + classType;
    }

    @Override
    public String toString() {
        return classType.toUpperCase() + " - " + fitnessInstructor + ", " + Time.values() + ", " + location.values();
    }

    public void printClass() {
        String strClassType = this.classType.toUpperCase();
        System.out.println(strClassType + " - " + this.fitnessInstructor.toUpperCase() + ", " + this.classTime.getHour() + ":" + this.classTime.getMinute() + ", " + this.location.toString());
        if (studentList.size() > 0) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(0) != null) {
                    System.out.println("\t** participants **");
                    System.out.println(studentList.get(i).toString());
                }
                if (studentList.get(0) != null) {
                    System.out.println("\t** guests **");
                    System.out.println(guestList.get(i).toString());
                }
            }
            System.out.println();
        }
    }
}