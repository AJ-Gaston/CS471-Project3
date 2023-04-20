import java.util.Vector;

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
    void addFile(String fName)
    {

    }
    //Search in the directories and delete file of exact name and extension
    void deleteFile(String fName, String fExtension)
    {

    }
    //Search in the directories and find file of exact name
    void printFile(String fName, String fext)
    {
        System.out.println();
    }
}
