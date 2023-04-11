
import javax.swing.*;
import java.awt.event.*;
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

    public void VFGUI()
    {
        JFrame window = new JFrame("Memory Management GUI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700,700);
    }

    public static void main(String[] args)
    {

    }
}
