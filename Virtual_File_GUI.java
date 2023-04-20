
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.Dialog.ModalityType;
import java.awt.*;

public class Virtual_File_GUI extends JFrame
{
    private Virtual_File vf;
    
    public Virtual_File_GUI()
    {

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
        Vector<JLabel> PageList = new Vector<JLabel>();
        Vector<JLabel> FreeSpace  =new Vector<JLabel>();
        for(int i=0;i < pageSize; i++){
            PageList.add(new JLabel("Memory Address& "+ i +" |"));
            if(i == 0)
                FreeSpace.add(new JLabel("Block "+ i +": "+ pageSize));
            else
                FreeSpace.add(new JLabel());
        }
        //Window Creation

        JFrame window = new JFrame("Memory Management GUI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700,700);
        //Panel Creation
        JPanel PQ = new JPanel(new GridBagLayout());
        JPanel FreeSpacePanel = new JPanel(new GridBagLayout());

        JPanel NewProcess = new JPanel();
        JPanel PQDisplay = new JPanel(new GridBagLayout());
        PQ.setBackground(Color.white);
        NewProcess.setBackground(Color.gray);
        PQDisplay.setBackground(Color.lightGray);
        PQDisplay.setSize(new Dimension(300, 500));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);


        //Panel Priority Queue
        gbc.gridx=5;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.ipadx=5;
        gbc.ipady=5;
        JLabel pQLabel = new JLabel("Pages");
        gbc.gridx=0;
        gbc.gridy=0;
        PQ.add(pQLabel, gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth = pageSize;
        gbc.gridheight = NumberofPages + 1;
        PQ.add(PQDisplay, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx=0;
        gbc.gridy=0;
        for(int i=0; i < NumberofPages; i++){
            gbc.gridy = i;
            PQDisplay.add(PageList.elementAt(i), gbc);
            FreeSpacePanel.add(FreeSpace.elementAt(i),gbc);
        }
        //Panel NewProcess
        JLabel NewP = new JLabel("Program Name: ");
        JTextField ProcessField = new JTextField(30);
        JLabel sizeJLabel = new JLabel("Program Size: ");
        JTextField sizeField = new JTextField(5);
        JButton AddProcess = new JButton("Add Program");

        AddProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String NewProcessName = ProcessField.getText();//Grabs what is in the field
                int size = Integer.valueOf(sizeField.getText());
                if(size < 0)
                {
                    size = 1;
                }  
                ProcessField.setText("");
                sizeField.setText("");
                if(NewProcessName.length() > 0 && hasText(NewProcessName))
                {
                    
                    if(!memManag.addProcess(new Process(NewProcessName,size)))
                    {
                        ErrorMessage("Error! Insufficient memory space! Starting Garbage compaction!");
                        memManag.GarbageCollection();
                        if(!memManag.addProcess(new Process(NewProcessName, size)))
                        {
                            ErrorMessage("Failed to add program after compacting");
                        }
                        memManag.freeSpaceList();
                    }
                }
                for(int i=0; i < pageSize; i++){
                    PageList.elementAt(i).setText(memManag.slot(i));
                    if(i < memManag.getNumBlocks())
                        FreeSpace.elementAt(i).setText(memManag.getFreeSpace(i));
                    else
                        FreeSpace.elementAt(i).setText("");   
                }
                //Update Display
            }
        });
        NewProcess.add(NewP);
        NewProcess.add(ProcessField);
        NewProcess.add(sizeJLabel);
        NewProcess.add(sizeField);
        NewProcess.add(AddProcess);
        //Delete Panel
        JPanel panelDeleteProg = new JPanel();
        JTextField DPField = new JTextField(30);
        JLabel DPLable = new JLabel("Programe to de-allocate: ");
        JButton DPButton = new JButton("Delete Program");
        DPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String prog = DPField.getText();
                DPField.setText("");
                if(!memManag.removeProcess(prog))
                {
                    ErrorMessage("Could not find a program by that name");
                }
                for(int i=0; i < pageSize;i++){
                    PageList.elementAt(i).setText(memManag.slot(i));
                    if(i < memManag.getNumBlocks()){
                        FreeSpace.elementAt(i).setText(memManag.getFreeSpace(i));
                    }
                    else{
                        FreeSpace.elementAt(i).setText("");
                    }   
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

        panelDeleteProg.add(DPLable);
        panelDeleteProg.add(DPField);
        panelDeleteProg.add(DPButton);
        panelDeleteProg.add(Creator);
        //Window formating

        window.add(BorderLayout.NORTH, NewProcess);
        window.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.CENTER);
        window.add(BorderLayout.CENTER, PQ);
        window.add(BorderLayout.SOUTH, panelDeleteProg);
        window.setVisible(true);
    }

    public static void main(String[] args)
    {

    }
}
