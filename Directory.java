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
    /**
     * Gets the name of a file within the directory
     * @param name
     * @return the file the matches the name
     */
    File getFileName(String name)
    {
        if(directories.size() == 0 || files.size() == 0)
        {
            return null;
        }
        //Look at the files in the tope drive/directory
        for(int i = 0; i < files.size(); i++)
        {
            if(files.elementAt(i).getFileName().equals(name))
            {
                return files.elementAt(i);
            }
        }
        //Look in the lower level directory (so the directory under A,B,C)
        for(int i = 0; i < directories.size(); i++)
        {
            if(directories.elementAt(i).getFileName(name).equals(name)){
                File temp = directories.elementAt(i).getFileName(name);
                return temp;
            }
        }
        return null;
    }

    int fileSize(){
        return files.size();
    }
    
    void addDirectory(Directory dir)
    {
        directories.add(dir);
    }

    void addFile(File f)
    {
        files.add(f);
    }
}
