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
     * This finds the directory's name as well as any inside the directory
     * @param name
     * @return directory
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

    Vector<String> getChildren()
    {
        Vector<String> temp = new Vector<String>();
        //This looks at the directories within the current directory
        for(int i = 0; i < directories.size(); i++)
        {
            temp.add(directories.elementAt(i).getName());
        }
        //Looks into the files within directory
        for(int i = 0; i < files.size(); i++)
        {
            temp.add(files.elementAt(i).getFileName());
        }
        return temp;
    }

    /**
     * Gets the name of a file within the directory
     * @param name
     * @return the file the matches the name
     */
    File getFileNameInDirectory(String name)
    {
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
            File temp = directories.elementAt(i).getFileNameInDirectory(name);
            if(temp.getFileName().equals(name)){
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

    //Make it more specific 
    void deleteFileInDirectory(String fName){
        for(int k = 0; k < files.size(); k++)
        {
            if(fName.equals(files.elementAt(k).getFileName()))
            {
                files.removeElementAt(k);
            }
        }
        for(int j = 0; j < directories.size(); j++)
        {
            directories.elementAt(j).deleteFileInDirectory(fName);
        }
    }
    
}
