
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dialog.ModalityType;
import java.awt.*;

public class Virtual_File_GUI extends JFrame
{
    private Virtual_File vf;
    
    public Virtual_File_GUI()
    {
        vf = new Virtual_File();
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
        //Window Creation
        JFrame window = new JFrame("Virtual File System GUI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1300,700);

        //Panel Creation
        JPanel NewFile = new JPanel();
        JLabel Newf = new JLabel("File Name: ");
        JTextField ProcessField = new JTextField(30);
        JButton addFile = new JButton("Add File");
        addFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        
        JButton Creator = new JButton("CREATOR");
        Creator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Creator();
            }
        });

        NewFile.add(addFile);
        NewFile.add(Newf);
        NewFile.add(ProcessField);
        NewFile.add(Creator);

        JPanel panelDeleteFile = new JPanel();
        JTextField DFField = new JTextField(30);
        JLabel DFLable = new JLabel("File to delete: ");
        JButton deleteFile = new JButton("Delete File");
        deleteFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        panelDeleteFile.add(DFField);
        panelDeleteFile.add(DFLable);
        panelDeleteFile.add(deleteFile);
        
        JButton printFile = new JButton("Print File");
        printFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        //Window Formating
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
