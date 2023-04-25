import java.util.Vector;
import java.util.Random;

public class Virtual_File
{
    Vector<Directory> drives;
    String vfName;
    
    /**
     * Default Constructor 
     */
    Virtual_File()
    {
        drives.add(new Directory("Drive A"));
        
        drives.add(new Directory("Drive B"));
        
        drives.add(new Directory("Drive C"));
       
        drives.get(0).addDirectory(new Directory("Directory 1A"));
        drives.get(0).addDirectory(new Directory("Directory 2A"));

        drives.get(1).addDirectory(new Directory("Directory 3B"));

        drives.get(2).addDirectory(new Directory("Directory 4C"));
    }
    //ALL OF THESE FUNCTIONS HAVE TO LOOK WITHIN THE DIRECTORIES TO ADD, DELETE, OR PRINT
    //Find a directory and add a file in that directory
    void addFile(String dirName, String fName, String textString)
    {   
        Directory temporary = findDirectory(dirName);
        if(temporary != null)
        {
            temporary.addFile(new File(fName, textString));
        }

    }

    //Search in the directories and delete file of exact name and extension
    boolean deleteFile(String fName)
    {
        boolean deleted = false;
        for(int i = 0; i < drives.size(); i++)
        {
            drives.elementAt(i).deleteFileInDirectory(fName);
            deleted = true;

        }
        return deleted;
    }

    //Search in the directories and find file of exact name, then print them
    String printFile(String fName)
    {
        for(int i = 0; i < drives.size(); i++)
        {
            File temp = drives.elementAt(i).getFileNameInDirectory(fName);
            //This is for the null string
            if(temp != null)
            {
                return temp.getFileContent();
            }
        }
        return null;
    }

    Directory findDirectory(String name)
    {
        Directory temp = null;
        for(int i = 0; i < drives.size(); i++)
        {
            temp = drives.elementAt(i).getDirectoryName(name);
            if(temp != null)
            {
                return temp;
            }
        }
        return null;
    }
}
