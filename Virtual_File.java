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
       
        drives.get(0).addDirectory(new Directory("Directory 1"));
        drives.get(0).addDirectory(new Directory("Directory 2"));

        drives.get(1).addDirectory(new Directory("Directory 3"));
        
        drives.get(2).addDirectory(new Directory("Directory 4"));
    }
    //ALL OF THESE FUNCTIONS HAVE TO LOOK WITHIN THE DIRECTORIES TO ADD, DELETE, OR PRINT
    //Find a directory and add a file in that directory
    void addFile(String fName)
    {
        for(int i = 0; i < drives.size(); i++)
        {
            //If it has no file at all
            if(drives.elementAt(i).fileSize() == 0)
            {
                drives.elementAt(i).addFile(new File(fName));
            }
            else
            {
                Random rand = new Random();
                int x = rand.nextInt(3);
                switch (x)
                {
                    case 1:
                        for(int k = 0; k < drives.size(); k++){
                            if()
                        }
                    case 2:
                    case 3:
                }
            }
        }   
    }

    //Search in the directories and delete file of exact name and extension
    void deleteFile(String fName)
    {
        for(int i = 0; i < drives.size(); i++)
        {
            if(drives.elementAt(i).getFileName(fName).equals(fName))
            {
                
            }
        }
    }

    //Search in the directories and find file of exact name
    void printFile(String fName)
    {
        for(int i = 0; i < drives.size(); i++)
        {
            if(drives.elementAt(i).getFileName(fName).equals(fName))
            {
                System.out.println();
            }
        }
    }
}
