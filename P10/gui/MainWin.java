package gui;

/***************************************************************************************
*    Title: MainWin
*    Author: George Rice
*    Date: 10/16/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P06/gui
*
***************************************************************************************/

import emporium.Emporium;
import product.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainWin extends JFrame {
    private Emporium emporium = new Emporium();
    private JLabel display;
    private File filename;

    public MainWin(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        filename = new File("untitled.mice");

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

        //Toolbar
        JToolBar toolbar = new JToolBar("MICE controls");
        
        //first button group
        JButton saveButton = new JButton();
            saveButton.setIcon(new ImageIcon("images/save.png"));
            saveButton.setActionCommand("Save");
            saveButton.setToolTipText("Save");
            toolbar.add(saveButton);
            saveButton.addActionListener(event -> onSaveClick());

        JButton saveAsButton = new JButton();
            saveAsButton.setIcon(new ImageIcon("images/saveas.png"));
            saveAsButton.setActionCommand("Save As");
            saveAsButton.setToolTipText("Save As");
            toolbar.add(saveAsButton);
            saveButton.addActionListener(event -> onSaveAsClick());

        JButton openButton = new JButton();
            openButton.setIcon(new ImageIcon("images/open.png"));
            openButton.setActionCommand("Open file");
            openButton.setToolTipText("Open file");
            toolbar.add(openButton);
            saveButton.addActionListener(event -> onOpenClick());

        toolbar.add(Box.createHorizontalStrut(25));

        //second button group
        JButton onCreateICButton = new JButton();
            onCreateICButton.setIcon(new ImageIcon("images/ice-cream.png"));
            onCreateICButton.setActionCommand("Create ice cream");
            onCreateICButton.setToolTipText("Create ice cream");
            toolbar.add(onCreateICButton);
            onCreateICButton.addActionListener(event -> onCreateIceCreamFlavorClick());

        JButton onCreateMXButton = new JButton();
            onCreateMXButton.setIcon(new ImageIcon("images/sprinkles.png"));
            onCreateMXButton.setActionCommand("Create mix in");
            onCreateMXButton.setToolTipText("Create mix in");
            toolbar.add(onCreateMXButton);
            onCreateMXButton.addActionListener(event -> onCreateMixInFlavorClick());

        JButton onCreateScpButton = new JButton();
            onCreateScpButton.setIcon(new ImageIcon("images/scoop.png"));
            onCreateScpButton.setActionCommand("Create scoop");
            onCreateScpButton.setToolTipText("Create scoop");
            toolbar.add(onCreateScpButton);
            onCreateScpButton.addActionListener(event -> onCreateScoopClick());

        toolbar.add(Box.createHorizontalStrut(25));

        //third button group
        JButton onViewICButton = new JButton();
            onViewICButton.setIcon(new ImageIcon("images/ice-cream-cone-color.png"));
            onViewICButton.setActionCommand("View ice cream");
            onViewICButton.setToolTipText("View ice cream");
            toolbar.add(onViewICButton);
            onViewICButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        
        JButton onViewMXButton = new JButton();
            onViewMXButton.setIcon(new ImageIcon("images/sprinkles-color.png"));
            onViewMXButton.setActionCommand("View mix in");
            onViewMXButton.setToolTipText("View mix in");
            toolbar.add(onViewMXButton);
            onViewMXButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        JButton onViewScpButton = new JButton();
            onViewScpButton.setIcon(new ImageIcon("images/scoop-color.png"));
            onViewScpButton.setActionCommand("View scoop");
            onViewScpButton.setToolTipText("View scoop");
            toolbar.add(onViewScpButton);
            onViewScpButton.addActionListener(event -> view(Screen.SCOOPS));


        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        setVisible(true);
    }

    public void onOpenClick(){ //open to select a filename via a FileChooser dialog and then create a new Emporium from it, changing the current filename if successful.
        final JFileChooser fc = new JFileChooser(filename); //create file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", "mice"); 
        fc.addChoosableFileFilter(miceFiles); //add "MICE file" filter
        fc.setFileFilter(miceFiles); //show mice files only by default

        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                emporium = new Emporium(br);                   
                view(Screen.SCOOPS);                         // Update the user interface
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    public void onSaveClick(){ //save to write all data to the current filename.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            emporium.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    public void onSaveAsClick(){ //save as to change the current filename via filechooser dialog and then chain to save.
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", "mice");
        fc.addChoosableFileFilter(miceFiles);
        fc.setFileFilter(miceFiles);  
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".mice"))  
                filename = new File(filename.getAbsolutePath() + ".mice");
            onSaveClick();                       // Delegate to Save method
        }
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
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
              
        try {
            BufferedImage myPicture = ImageIO.read(new File("images/mice-logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            JPanel canvas = new Canvas();
            about.add(canvas);
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(subTitle);

        JLabel artists = new JLabel("<html>"
        + "<p>Version 0.2</p>"
        + "Icons and logo created by Freepik - Flaticon"
        + "<p>https://www.flaticon.com/free-icons/save</p>"
        + "<p>https://www.flaticon.com/free-icons/open-folder</p>"
        + "<p>https://www.flaticon.com/free-icons/ice-cream</p>"
        + "<p>https://www.flaticon.com/free-icons/sprinkles</p>" 
        + "<p>https://www.flaticon.com/free-icons/scoop</p>"
        + "</html>", JLabel.CENTER);
        about.add(artists);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
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
