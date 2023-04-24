import java.util.Vector;
public class Directory 
{
    String directoryName;
    Vector <File> files;
    Vector <Directory> directories;
    
    /**
     * Default Constructor
     */
    Directory()
    {
        directoryName = "";
        directories = new Vector<Directory>();
        files = new Vector<File>();
    }
    
    /**
     * Constructor
     * @param name
     */
    Directory(String name)
    {
        directoryName = name;
        directories = new Vector<Directory>();
        files = new Vector<File>();
    }

    /**
     * Finds the directory's name
     * @return the name of the directory
     */
    String getName()
    {
        return directoryName;
    }

    /**
     * This finds gthe directory's name as well as any inside the directory
     * @param name
     * @return directory's name
     */
    Directory getDirectoryName(String name)
    {
        if(directories.size() == 0)
        {
            return null;
        }
        for(int i = 0; i < directories.size(); i++)
        {
            if(directories.elementAt(i).getName().equals(name))
            {
                return directories.elementAt(i);
            }
        }
        //This is to get the directories within the directory
        for(int i = 0; i < directories.size();i++)
        {
            Directory Returned = directories.elementAt(i).getDirectoryName(name);
            if(Returned != null){
                return Returned;
            }
        }
        return null;
    }

    File getFileName(String name)
    {

        if(directories.size() == 0 || files.size() == 0)
        {
            return null;
        }
        //Look at the files
        for(int i = 0; i < files.size(); i++)
        {
            if(files.elementAt(i).getFileName().equals(name))
            {
                return files.elementAt(i);
            }
        }
        //Look in the lower level directory
        for(int i = 0; i < directories.size(); i++)
        {
            if(directories.)
        }
        return null;
    }
    void addFile(File f)
    {
        files.add(f);
    }
}
