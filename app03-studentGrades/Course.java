
/**
 * Write a description of class Course here.
 *
 * @author (Muhammad Mulla)
 * @version (Dec 2020)
 */
public class Course
{
    private String title;
    private String moduleCode;
    
    private Module module01;
    private Module module02;
    private Module module03;
    private Module module04;
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String moduleCode, String title)
    {
        this.title = title;
        this.moduleCode = moduleCode;
        
        module01 = new Module("Module 1", "C001");
        module02 = new Module("Module 2", "C002");
        module03 = new Module("Module 3", "C003");
        module04 = new Module("Module 4", "C004");
    }

    /**
     * Constructor for objects of class Course
     */
    public void addmodule(int moduleNumber, Module module)
    {
        if ((moduleNumber <=4) && (moduleNumber !=0));
        
        switch (moduleNumber)
        {
            case 1: module01 = module; break;
            case 2: module02 = module; break;
            case 3: module03 = module; break;
            case 4: module04 = module; break;
        }
    }
}
