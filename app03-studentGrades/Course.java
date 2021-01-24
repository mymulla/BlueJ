/**
 * This class, Course, models a course which consists of 4 modules.
 * The course has a title, code number and number of modules.
 * Marks can also be awarded for the course's modules in this class.
 * A final grade can also be calculated based on the average (mean) percentage 
 * mark of the modules.
 *
 * @author Muhammad Mulla
 * @version Jan 2021
 */
public class Course
{
    private String title;
    private String codeNo;

    //Creating the Modules to be selected using module number
    private Module module01;
    private Module module02;
    private Module module03;
    private Module module04;

    //To identify if the course has been completed or not (completed when a minimum of 40% is awarded
        //for each module
    private boolean complete;

    public static int totalMarks;
    private int numberofModules;

    /**
     * Constructor for objects of class Course
     */
    public Course(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;

        totalMarks = 0;
        complete = false;
    }

    /**
     * This method adds the modules to the course (its title and code have been pre-outlined in the Method class).
     */
    public void addmodule(int moduleNumber, Module module)
    {
        if ((moduleNumber <=4) && (moduleNumber !=0)) numberofModules++;

        switch (moduleNumber)
        {
            case 1: module01 = module; 
            System.out.println("Module01 has been added to the course");
            break;
            case 2: module02 = module;
            System.out.println("Module02 has been added to the course");
            break;
            case 3: module03 = module;
            System.out.println("Module03 has been added to the course");
            break;
            case 4: module04 = module;
            System.out.println("Module04 has been added to the course");
            break;
        }
    }

    /**
     * This method awards marks to modules which have been added to the course.
     */
    public void awardModuleMarks(int moduleNumber, int markoutof100)
    {
        if(moduleNumber == 1)
        {
            module01.awardMark(markoutof100);
            totalMarks = totalMarks + module01.getMark();
        }

        if(moduleNumber == 2)
        {
            module02.awardMark(markoutof100);
            totalMarks = totalMarks + module02.getMark();
        }

        if(moduleNumber == 3)
        {
            module03.awardMark(markoutof100);
            totalMarks = totalMarks + module03.getMark();
        }

        if(moduleNumber == 4)
        {
            module04.awardMark(markoutof100);
            totalMarks = totalMarks + module04.getMark();
        }
        
        //This calls this method, which is below.
        completeCourse();
        
        //To add credits for the student automatically if above 40% has been awarded for the module.
        if (markoutof100 >=40)
        {
            Student.addCredits(25);
        }
    }
    
    /**
     * This method updates the boolean statement to true if the mark for all modules are above 40%
     */
    private void completeCourse()
    {
        if (totalMarks >=160)
        {
            complete = true;
        }
        else
        {
            complete = false;
        }
    }
    
    /**
     * This method prints the modules and its details (title, code and % mark)
     */
    public void printCourseModules()
    {
        if(module01 != null) module01.print();

        if(module02 != null) module02.print();

        if(module03 != null) module03.print();

        if(module04 != null) module04.print();
    }

    /**
     * This method prints the title, code and number of modules in the course
     */
    public void printCourseDetails()
    {
        System.out.println("Course title: " + title);
        System.out.println("Course code: " + codeNo);
        System.out.println("Number of Modules: " + numberofModules);
    }

    /**
     * This method calculates the mean course mark, which is then used to calculate the overall course grade
     */
    public void printCourseGrade()
    {   
        //Calculating the mean course mark- to be used when calculating the grade
        int meanCourseMark = totalMarks / 4;
        System.out.println("Average Mark: " + meanCourseMark + " %");
        if (numberofModules == 4)
        {
            if(meanCourseMark <= 39)
            {
                System.out.println("Grade: F");
            }

            else if(meanCourseMark <=49)
            {
                System.out.println("Grade: D"); 
            }

            else if(meanCourseMark <=59)
            {
                System.out.println("Grade: C"); 
            }

            else if(meanCourseMark <=69)
            {
                System.out.println("Grade: B"); 
            }

            else if(meanCourseMark <=100)
            {
                System.out.println("Grade: A"); 
            } 
        }
        else
        {
            throw new NullPointerException("Please complete all modules first");
        }
    }
    
    /**
     * This method prints the course credits earned by completing the modules
     */
    public void printCourseCredits()
    {
        System.out.println("Credits for this course: " + Student.credits);
    }
}