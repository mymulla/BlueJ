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
    // the amount of credits for study taken so far
    private int credits;

    private Course course;
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    public void enrolonCourse(Course course)
    {
        this.course = course;

        System.out.println(name + " is now enrolled on the course");
    }

    /**
     * Add 25 credit points to the student's accumulated credits.
     */
    public void addCredits()
    {
        credits += 25;
        System.out.println ("25 Credits have been added"); 
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
    }
}