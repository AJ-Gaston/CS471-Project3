public class File {
    private String filename;
    private String fileContent;
    
    File()
    {
        filename = "";
    }

    File(String fName, String contents)
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
