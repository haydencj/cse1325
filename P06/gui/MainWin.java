package gui;
import emporium.Emporium;
import java.awt.*;
import javax.swing.*;

public class MainWin extends JFrame {
    public MainWin(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu view = new JMenu("View");
        JMenuItem icFlavorView = new JMenuItem("Ice Cream Flavor");
        JMenuItem mxFlavorView = new JMenuItem("Mix In Flavor");
        JMenuItem sFlavorView = new JMenuItem("Scoop");

        JMenu create = new JMenu("Create");
        JMenuItem icFlavorCreate = new JMenuItem("Ice Cream Flavor");
        JMenuItem mxFlavorCreate= new JMenuItem("Mix In Flavor");
        JMenuItem sFlavorCreate = new JMenuItem("Scoop");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
    }

    public void onQuitClick(){

    }

    public void onCreateIceCreamFlavorClick(){

    }

    public void onCreateMixInFlavorClick(){

    }

    public void onCreateScoopClick(){

    }

    public void onAboutClick(){

    }

    private void view(Screen screen){

    }
    
    private Emporium emporium;
    private JLabel display;
}
