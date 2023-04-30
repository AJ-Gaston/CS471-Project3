public class VFFile {
    private String filename;
    private String fileContent;
    
    VFFile()
    {
        filename = "";
    }

    VFFile(String fName, String contents)
    {
        filename = fName;
        fileContent = contents;

    }

    String getFileName()
    {
        return filename;
    }

    String getFileContent(){
        return fileContent;
    }
}
