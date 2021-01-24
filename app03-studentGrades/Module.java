/**
 * This class, Module, models a module of a course, which
 * will have a Title, a Module Code, and a mark (%).
 * The module details of the four courses have been pre-configured, allowing the 
 * creation of a module (object) with only the module number (1-4).
 *
 * @author Muhammad Mulla
 * @version Jan 2021
 */
public class Module
{
    private String title;
    private String moduleCode;

    public int markforthismodule;

    public boolean moduleisComplete;

    /**
     * Constructor for objects of class Module
     * Creates a new module with a title and code, by inputting a module number (1-4)
     */
    public Module(int moduleNumber)
    {
        this.title = title;
        this.moduleCode = moduleCode;

        moduleisComplete = false;
        markforthismodule = 0;
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
            //If a module number other than 1-4 is selected
            throw new NullPointerException("Please select a module from 1-4");
        }
    }

    /**
     * This method prints the awarded mark for the module object.
     * This method is called under the "awardModuleMarks" method in the Course class.
     */
    public void awardMark(int markforthismodule)
    {
        if ((markforthismodule <= 100) && (markforthismodule >=0))
        {
            this.markforthismodule = markforthismodule;
            System.out.println(markforthismodule + 
                " % has been awarded for " + title);
            if (markforthismodule >=40)
            {
                moduleisComplete = true;
            }
        }
        else
        {
            System.out.print("Please input a number between 0 and 100");
        }
    }

    /**
     * Getter method which returns the awarded mark
     * This method is called under the "awardModuleMarks" method in the Course class.
     */
    public int getMark()
    {
        return markforthismodule;
    }

    /**
     * This method checks if the module has been completed (if 40% + has been awarded).
     */
    public boolean moduleComplete()
    {
        return moduleisComplete;
    }

    /**
     * This method prints the module title, code and % mark)
     */
    public void print()
    {
        System.out.println("Module: " + title);
        System.out.println("Code: " + moduleCode);
        System.out.println("Mark for this module: " + markforthismodule + "%");
    }
}