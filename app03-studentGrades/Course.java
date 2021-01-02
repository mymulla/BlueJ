/**
 * Write a description of class Course here.
 *
 * @author (Muhammad Mulla)
 * @version (Dec 2020)
 */
public class Course
{
    private String title;
    private String codeNo;

    //Creating the Modules
    private Module module01;
    private Module module02;
    private Module module03;
    private Module module04;

    private int totalMarks;
    private int meanCourseMark;
    private int numberofModules;
    
    public static final int maxModules = 4;

    /**
     * Constructor for objects of class Course
     */
    public Course(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
    }

    /**
     * Constructor for objects of class Course
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

    public void addMarks(int markoutof100, int moduleNumber)
    {
        if(moduleNumber == 1)
        {
            module01.awardModuleMark(markoutof100);
            totalMarks = totalMarks + Module.getMark();
        }

        if(moduleNumber == 2)
        {
            module02.awardModuleMark(markoutof100);
            totalMarks = totalMarks + Module.getMark();
        }

        if(moduleNumber == 3)
        {
            module03.awardModuleMark(markoutof100);
            totalMarks = totalMarks + Module.getMark();
        }

        if(moduleNumber == 4)
        {
            module04.awardModuleMark(markoutof100);
            totalMarks = totalMarks + Module.getMark();
        }
    }

    public void printModules()
    {
        if(module01 != null) module01.print();

        if(module02 != null) module02.print();

        if(module03 != null) module03.print();

        if(module04 != null) module04.print();
    }

    public void calculateCourseGrade()
    {
        meanCourseMark = totalMarks / maxModules;
        
        if (numberofModules == maxModules)
        {
        if(meanCourseMark <= 39)
        {
            System.out.println("Grade F");
        }

        else if(meanCourseMark <=49)
        {
            System.out.println("Grade D"); 
        }

        else if(meanCourseMark <=59)
        {
            System.out.println("Grade C"); 
        }

        else if(meanCourseMark <=69)
        {
            System.out.println("Grade B"); 
        }

        else if(meanCourseMark <=100)
        {
            System.out.println("Grade A"); 
        } 
        }
        else
        throw new NullPointerException("Please complete all modules first");
    }
}