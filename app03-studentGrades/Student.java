import java.util.*;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context, which are
 * The name, ID, the course they are enrolled on (and its modules),
 * and the credits earned by completing the modules.
 * 
 * @author Muhammad Mulla
 * @version Jan 2021
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits- earned by completing modules (25 per module above 40%)
    public static int credits;
    private int creditsadded;

    private Course course;
    /**
     * Constructor for object of class Student.
     * Creates a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * This method is to enroll the student on a course.
     */
    public void enrolonCourse(Course course)
    {
        this.course = course;

        System.out.println(name + " is now enrolled on the course");
    }

    /**
     * This method is to add credits manually.
     * This method is called with int 25 under the "awardModuleMarks" method
     * in the Course class.
     */
    public static void addCredits(int creditsadded)
    {
        credits += creditsadded;
        System.out.println (creditsadded + " Credits have been added"); 
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Print the student's name, ID number and other course details
     * (credits, course, grade) to the output terminal.
     */
    public void printStudentCourseDetails()
    {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Credits: " + credits);
        System.out.println();
        course.printCourseDetails();
        System.out.println();
        course.printCourseModules();
        course.printCourseGrade();
    }
}