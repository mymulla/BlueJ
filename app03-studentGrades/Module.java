
/**
 * This class, Module, models a module of a course, which
 * will have a Title, a Module Code, and a mark (%).
 *
 * @author (Muhammad Mulla)
 * @version (Dec 2020)
 */
public class Module
{
    private String title;
    
    private String moduleCode;
    
    private int percentageMark;
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String moduleCode)
    {
        this.title = title;
        this.moduleCode = moduleCode;
        
        percentageMark=0;
    }

    public void print()
    {
        System.out.println("Module: " + title + " Code: " + moduleCode);
        System.out.println("Mark for this module: " + percentageMark + "%");
    }
}
