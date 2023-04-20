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
    void addFile()
    {
        
    }

    void deleteFile()
    {

    }

    void printFile()
    {
        System.out.println();
    }
}
