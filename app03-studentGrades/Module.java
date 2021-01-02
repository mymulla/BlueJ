
/**
 * This class, Module, models a module of a course, which
 * will have a Title, a Module Code, and a mark (%).
 *
 * @author (Muhammad Mulla)
 * @version (Jan 2020)
 */
public class Module
{
    private String title;

    private String moduleCode;

    private static int markoutof100;

    public static boolean moduleisComplete;

    /**
     * Constructor for objects of class Module
     */
    public Module(int moduleNumber)
    {
        this.title = title;
        this.moduleCode = moduleCode;

        moduleisComplete = false;
        markoutof100 = 0;
        if ((moduleNumber <=4) && (moduleNumber !=0))

        {switch (moduleNumber)
            {
                case 1: title = "Module01"; moduleCode = "M001"; break;
                case 2: title = "Module02"; moduleCode = "M002"; break;
                case 3: title = "Module03"; moduleCode = "M003"; break;
                case 4: title = "Module04"; moduleCode = "M004"; break;
            }
        }
        else
        {
            throw new NullPointerException("Please select a module from 1-4");
        }

    }

    public void awardModuleMark(int markoutof100)
    {
        if ((markoutof100 <= 100) && (markoutof100 >=0))
        {
            this.markoutof100 = markoutof100;
            System.out.println(markoutof100 + 
                " % has been awarded for this module");
            moduleisComplete = true;
        }
        else
        {
            System.out.print("Please input a number between 0 and 100");
        }
    }

    public static int getMark()
    {
        return markoutof100;
    }
    
    public static boolean moduleComplete()
    {
        return moduleisComplete;
    }

    public void print()
    {
        System.out.println("Module: " + title);
        System.out.println("Code: " + moduleCode);
        System.out.println("Mark for this module: " + markoutof100 + "%");
    }
}
