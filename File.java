public class File {
    private String filename;
    private String extension;
    
    File()
    {
        filename = "";
        extension = "";
    }

    File(String fName, String ext)
    {
        filename = fName;
        extension = ext;
    }
    String getFileName()
    {
        return filename;
    }

    String getExtension()
    {
        return extension;
    }
}
