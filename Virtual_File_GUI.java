
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dialog.ModalityType;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Virtual_File_GUI extends JFrame
{
    private Virtual_File vf;
    
    public Virtual_File_GUI()
    {
        vf = new Virtual_File();
    }

    private void printFile()
    {
        final JDialog addDialog = new JDialog();

        JPanel miniPanel = new JPanel(new BorderLayout());

        miniPanel.setPreferredSize(new Dimension(175, 100));

        final JTextField text = new JTextField(10);

        JButton printButton = new JButton("Print");

        printButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {

                String printFile = text.getText();
                if(printFile.length() > 0 && hasText(printFile))
                {
                    vf.printFile(printFile);
                }    
                addDialog.dispose();
            }

        });

        JLabel title = new JLabel(" Additional Priority ");

        miniPanel.add(title, BorderLayout.NORTH);

        miniPanel.add(printButton, BorderLayout.WEST);

        miniPanel.add(text, BorderLayout.EAST);
        
        addDialog.setTitle("Add New Process");

        addDialog.add(miniPanel);

        addDialog.setResizable(false);

        addDialog.pack();

        addDialog.setLocationRelativeTo(null);

        addDialog.setModal(true);

        addDialog.setAlwaysOnTop(true);

        addDialog.setModalityType(ModalityType.APPLICATION_MODAL);

        addDialog.setVisible(true);
    }

    public boolean hasText(String word)
    {
        for(int i=0; i < word.length();i++)
        {
            if(word.charAt(i) != ' ')
            {
                return true;
            }
        }
        return false;
    }

    public void ErrorMssg(String message)
    {
        JDialog addDialog = new JDialog();

        JPanel miniPanel = new JPanel(new BorderLayout());

        miniPanel.setPreferredSize(new Dimension(175, 100));

        JLabel mess = new JLabel(message);

        miniPanel.add(mess);

        addDialog.add(miniPanel);

        addDialog.setTitle("ERROR");

        addDialog.setResizable(false);

        addDialog.pack();

        addDialog.setLocationRelativeTo(null);

        addDialog.setModal(true);

        addDialog.setAlwaysOnTop(true);

        addDialog.setModalityType(ModalityType.APPLICATION_MODAL);

        addDialog.setVisible(true);
    }
    
    private void Creator() 
    {

        String creatorString = "CS_471 Operating Systems \n"

        + "Alexji Gaston \n" ;

        JFrame frame = new JFrame("Creator");

        JPanel panel = new JPanel();

        JTextArea label = new JTextArea(creatorString);

        panel.add(label);

        frame.add(panel);

        frame.setResizable(false);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void VFGUI()
    {
        Vector<JLabel> virtualFileList = new Vector<JLabel>();
        Vector<JLabel> systemList = new Vector<JLabel>();
        for(int i= 0;i < vf.drives.size(); i++){
            virtualFileList.add(new JLabel(vf.drives.elementAt(i).getChildren() + ":"));
        }
        for(int i = 0; i < vf.drives.size(); i++)
        {
            systemList.add(new JLabel (vf.drives.elementAt(i).getName() + ":"));
            systemList.add(new JLabel("Directory " + vf.drives.elementAt(i).getChildren() + ":"));
        }
        //Window Creation
        JFrame window = new JFrame("Virtual File System GUI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1300,700);

        //SplitPane Creation
        JPanel leftPane = new JPanel();
        for(JLabel label: virtualFileList)
        {
            leftPane.add(label);
        }
        JPanel rightPane = new JPanel();
        for(JLabel plabel: systemList)
        {
            rightPane.add(plabel);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftPane), new JScrollPane(rightPane));
        //Panel Creation
        JPanel NewFile = new JPanel();
        JLabel dir = new JLabel("Directory: ");
        JTextField DirectoryField = new JTextField(30);
        JLabel Newf = new JLabel("File Name: ");
        JTextField FileField = new JTextField(30);
        JButton addFile = new JButton("Add File");
        addFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String fileText = "";
                String NewFileName = FileField.getText();
                String NewDirectory = DirectoryField.getText();
                FileField.setText("");
                DirectoryField.setText("");
                if(NewFileName.length() > 0 && hasText(NewFileName))
                {
                    if(NewDirectory.length() > 0 && hasText(NewDirectory))
                    {
                        try{
                            FileWriter outFile = new FileWriter(NewFileName, true);
                            
                            Scanner sc = new Scanner(System.in);
                            while(sc.hasNextLine())
                            {
                                fileText = sc.nextLine();
                            }
                            sc.close();
                            outFile.write(fileText);
                            outFile.close();
                        } catch(IOException Thing){
                            Thing.printStackTrace();
                        }
                    }
                    vf.addFile(NewDirectory, NewFileName, fileText);
                }
            }
        });
        
        JButton Creator = new JButton("CREATOR");
        Creator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Creator();
            }
        });
        
        NewFile.add(dir);
        NewFile.add(DirectoryField);
        NewFile.add(Newf);
        NewFile.add(FileField);
        NewFile.add(addFile);
        NewFile.add(Creator);
        
        JPanel panelDeleteFile = new JPanel();
        JTextField DeleteFileField = new JTextField(30);
        JLabel DeleteFileLable = new JLabel("File to delete: ");
        JButton deleteFile = new JButton("Delete File");
        deleteFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String df = DeleteFileField.getText();
                DeleteFileField.setText("");
                if(!vf.deleteFile(df))
                {
                    ErrorMssg("Unable to find and delete file!");
                }

            }
        });
        panelDeleteFile.add(DeleteFileField);
        panelDeleteFile.add(DeleteFileLable);
        panelDeleteFile.add(deleteFile);
        
        JButton printFile = new JButton("Print File");
        printFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                printFile();
            }
        });
        panelDeleteFile.add(printFile);
        
        //Window Formating
        window.add(splitPane);
        window.add(BorderLayout.NORTH, NewFile);
        window.add(BorderLayout.SOUTH, panelDeleteFile);
        window.setVisible(true);
    }
    public static void main(String[] args)
    {
        Virtual_File_GUI gui = new Virtual_File_GUI();

        gui.VFGUI();

        gui.setVisible(true);
    }
}
