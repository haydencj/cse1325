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

        icFlavorView.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        mxFlavorView.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        sFlavorView.addActionListener(event -> view(Screen.SCOOPS));

        icFlavorCreate.addActionListener(event -> onCreateIceCreamFlavorClick());
        mxFlavorCreate.addActionListener(event -> onCreateMixInFlavorClick());
        sFlavorCreate.addActionListener(event -> onCreateScoopClick());

        about.addActionListener(event -> onAboutClick());

        file.add(quit);

        view.add(icFlavorView);
        view.add(mxFlavorView);
        view.add(sFlavorView);

        create.add(icFlavorCreate);
        create.add(mxFlavorCreate);
        create.add(sFlavorCreate);

        help.add(about);

        menuBar.add(file);
        menuBar.add(view);
        menuBar.add(create);
        menuBar.add(help);
        setJMenuBar(menuBar);

        display = new JLabel();
        setVisible(true);
    }

    public void onQuitClick(){
        System.exit(0);
    }

    public void onCreateIceCreamFlavorClick(){

    }

    public void onCreateMixInFlavorClick(){

    }

    public void onCreateScoopClick(){

    }

    public void onAboutClick(){
        JDialog about = new JDialog();
    }

    private void view(Screen screen){

    }

    private Emporium emporium;
    private JLabel display;
}
