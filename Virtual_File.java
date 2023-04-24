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
    }
    //ALL OF THESE FUNCTIONS HAVE TO LOOK WITHIN THE DIRECTORIES TO ADD, DELETE, OR PRINT
    //Find the exact directory and add a file in that directory
    void addFile(String dirname, String fName)
    {
        if(dirname == "")
        {
            Random rand = new Random();
            int x = rand.nextInt(3);
            switch(x)
            {
                case 1:
                    //Add the file to drive A
                    drives.get(1).addFile(new File(fName));
                case 2:
                    //Add the file to drive B
                    drives.get(2).addFile(new File(fName));
                case 3:
                    //Add the file to drive C
                    drives.get(3).addFile(new File(fName));
            }

        }
        for(int i = 0; i < drives.size(); i++)
        {
            Directory temp = new Directory(dirname);
            //This if it's a level one directory
            if(drives.elementAt(i).getDirectoryName(dirname).equals(temp))
            {
                drives.elementAt(i).addFile(new File(fName));
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
            if()
            {
                System.out.println();
            }
        }
    }
}
