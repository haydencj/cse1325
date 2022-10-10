package gui;
import emporium.Emporium;
import product.*;
import java.awt.*;
import javax.swing.*;

public class MainWin extends JFrame {
    private Emporium emporium = new Emporium();
    private JLabel display;

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
        add(display, BorderLayout.CENTER);
        setVisible(true);
    }

    public void onQuitClick(){
        System.exit(0);
    }

    public void onCreateIceCreamFlavorClick(){
        String flavor = JOptionPane.showInputDialog(this, "Enter an ice cream flavor.", "Create Ice Cream", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(this, "Enter a description.", "Create Ice Cream", JOptionPane.QUESTION_MESSAGE);
        String price = JOptionPane.showInputDialog(this, "Enter the price.", "Create Ice Cream", JOptionPane.QUESTION_MESSAGE);
        String cost = JOptionPane.showInputDialog(this, "Enter the cost.", "Create Ice Cream", JOptionPane.QUESTION_MESSAGE);

        emporium.addIceCreamFlavor(new IceCreamFlavor(flavor, description, Integer.parseInt(cost), Integer.parseInt(price)));
        view(Screen.ICE_CREAM_FLAVORS);
    }

    public void onCreateMixInFlavorClick(){
        String flavor = JOptionPane.showInputDialog(this, "Enter a mix in.", "Create Mix In", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(this, "Enter a description.", "Create Mix In", JOptionPane.QUESTION_MESSAGE);
        String price = JOptionPane.showInputDialog(this, "Enter the price.", "Create Mix In", JOptionPane.QUESTION_MESSAGE);
        String cost = JOptionPane.showInputDialog(this, "Enter the cost.", "Create Mix In", JOptionPane.QUESTION_MESSAGE);

        emporium.addMixInFlavor(new MixInFlavor(flavor, description, Integer.parseInt(cost), Integer.parseInt(price)));
        view(Screen.MIX_IN_FLAVORS);
    }

    public void onCreateScoopClick(){
        Scoop scoop;
        Object[] icFlavors = emporium.iceCreamFlavors();
        Object[] mxFlavors = emporium.mixInFlavors();
        Object[] mxAmount = MixInAmount.values();

        IceCreamFlavor icChoice = (IceCreamFlavor) JOptionPane.showInputDialog(this, "Select Ice Cream Flavor", "Make a scoop", JOptionPane.QUESTION_MESSAGE, null, icFlavors, icFlavors[0]);
        if(icChoice == null){
            display.setText("Invalid response");
            return;
        }

        scoop = new Scoop(icChoice);

        MixInFlavor mxChoice = (MixInFlavor) JOptionPane.showInputDialog(this, "Select Mix In Flavor", "Make a scoop", JOptionPane.QUESTION_MESSAGE, null, mxFlavors, mxFlavors[0]);
        MixInAmount mxAmountChoice = (MixInAmount) JOptionPane.showInputDialog(this, "Select Mix In Amount", "Make a scoop", JOptionPane.QUESTION_MESSAGE, null, mxAmount, mxAmount[0]);

        while(mxChoice != null) {
            MixIn selectedMixIn = new MixIn(mxChoice, mxAmountChoice);
            scoop.addMixIn(selectedMixIn);
            
            mxChoice = (MixInFlavor) JOptionPane.showInputDialog(this, "Select Another Mix In Flavor", "Make a scoop", JOptionPane.QUESTION_MESSAGE, null, mxFlavors, mxFlavors[0]);
            mxAmountChoice = (MixInAmount) JOptionPane.showInputDialog(this, "Select A Mix In Amount", "Make a scoop", JOptionPane.QUESTION_MESSAGE, null, mxAmount, mxAmount[0]);
        }

        emporium.addScoop(scoop);
        view(Screen.SCOOPS);
    }

    public void onAboutClick(){
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporium");

        JLabel title = new JLabel("<html>"
        + "<p><font size=+4>MICE</font></p>"
        + "</html>");
        about.add(title);

        JLabel info = new JLabel("<html>"
            + "<p>Version 0.2</p>"
            + "</html>");
        about.add(info);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok, BorderLayout.PAGE_END);
        
        about.setSize(200,140);
        about.setVisible(true);
    }

    private void view(Screen screen){
        if(screen.equals(Screen.ICE_CREAM_FLAVORS)){
            for(Object i: emporium.iceCreamFlavors()){
                display.setText(i.toString());
            }
        }

        else if(screen.equals(Screen.MIX_IN_FLAVORS)){
            for(Object mx: emporium.mixInFlavors()){
                display.setText(mx.toString());
            }
        }

        else if(screen.equals(Screen.SCOOPS)){
            for(Object s: emporium.scoops()){
                display.setText(s.toString());
            }
        }
    }
}
