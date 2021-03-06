package facade;

import builder.BasicBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HoneyBuilder;
import builder.KillerBuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import singleton.Apiary;

public class MainFrame extends JFrame {

    private final DefaultListModel<Hive> apiaryHivesModel = new DefaultListModel<Hive>();

    JList<Hive> apiaryHives = new JList<Hive>(apiaryHivesModel);


    JLabel apiaryName = new JLabel();
    JLabel messageLabel = new JLabel("Welcome");
    JLabel specialMessage = new JLabel("Special");

    JFrame masterPanel = new JFrame();
    JPanel allPanels = new JPanel();

    JPanel apiaryPanel = new JPanel();
    JPanel hivePanel = new JPanel();
    JPanel beePanel = new JPanel();
    JPanel response = new JPanel();

    Apiary beeHome = Apiary.getInstance();
    ArrayList<Hive> allHives;

    JButton addRoom = new JButton("Add Hive to Apiary");
    JButton newHoney = new JButton("Create new Honey Bee Hive");
    JButton newKiller = new JButton("Create new Killer Bee Hive");
    JButton newBasic = new JButton("Create new Drone Bee Hive");
    JButton getInfo = new JButton("Hive information");

    JLabel queenLabel = new JLabel("Hive Queen Attribute:");
    JLabel attributeLabel = new JLabel("Hive Attribute:");
    JLabel typeLabel = new JLabel("Hive Type:");
    JLabel roomsLabel = new JLabel("Hive Rooms:");
    JLabel workersLabel = new JLabel("Hive Workers:");

    JTextArea hiveQueen = new JTextArea("");     
    JTextArea hiveAttribute = new JTextArea("");
    JTextArea hiveType = new JTextArea("");
    JTextArea hiveRooms = new JTextArea("");
    JTextArea hiveWorkers = new JTextArea("");

    JScrollPane hiveScroll;

    HiveDirector hiveDir = new HiveDirector();
    HiveBuilder killerBuilder = new KillerBuilder();
    HiveBuilder honeyBuilder = new HoneyBuilder();
    HiveBuilder basicBuilder = new BasicBuilder();

    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject();
    }
    
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    /**
     * Constructor method for the MainFrame class that brings forward the working
     * panel.
     */
    public MainFrame() {
        super("The BeesKnees Apiary");
        try {
            createAllPanels();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method called from the constructor that creates all the frames and calls
     * to create the listeners as well.
     * @return JFrame that is used as the interface for the user.
     */
    public JFrame createAllPanels() {

        masterPanel.setLayout(new BorderLayout());

        messageLabel.setFont(new Font("Serif", Font.BOLD, 20));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);

        specialMessage.setFont(new Font("Serif", Font.BOLD, 20));
        specialMessage.setHorizontalAlignment(JLabel.CENTER);
        specialMessage.setVerticalAlignment(JLabel.CENTER);


        createListeners();
        //apiaryName.setText(beeHome.toString());
        apiaryHives.setVisibleRowCount(10);
        apiaryHives.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        allHives = beeHome.getHives();
        for (Hive hive: allHives) {
            apiaryHivesModel.addElement(hive);
        }
        hiveScroll = new JScrollPane(apiaryHives);

        hivePanel.setLayout(new GridLayout(5, 1));

        hiveQueen.setVisible(true);
        hiveQueen.setEditable(false);
        hiveQueen.setLineWrap(true);
        hiveQueen.setBorder(border);

        hiveAttribute.setVisible(true);
        hiveAttribute.setEditable(false);
        hiveAttribute.setLineWrap(true);
        hiveAttribute.setBorder(border);

        hiveType.setVisible(true);
        hiveType.setEditable(false);
        hiveType.setBorder(border);

        hiveRooms.setVisible(true);
        hiveRooms.setEditable(false);
        hiveRooms.setBorder(border);

        hiveWorkers.setVisible(true);
        hiveWorkers.setEditable(false);
        hiveWorkers.setBorder(border);

        hivePanel.add(queenLabel);
        hivePanel.add(hiveQueen);
        hivePanel.add(attributeLabel);
        hivePanel.add(hiveAttribute);
        hivePanel.add(typeLabel);
        hivePanel.add(hiveType);
        hivePanel.add(roomsLabel);
        hivePanel.add(hiveRooms);
        hivePanel.add(workersLabel);
        hivePanel.add(hiveWorkers);

        beePanel.setLayout(new GridLayout(3,0));
        beePanel.add(newBasic);
        beePanel.add(newHoney);
        beePanel.add(newKiller);


        masterPanel.add(messageLabel, BorderLayout.NORTH);
        masterPanel.add(hivePanel, BorderLayout.CENTER);
        masterPanel.add(hiveScroll, BorderLayout.WEST);
        masterPanel.add(beePanel, BorderLayout.EAST);
        masterPanel.add(specialMessage, BorderLayout.SOUTH);
        masterPanel.pack();
        masterPanel.setVisible(true);
        masterPanel.setSize(1024, 768);
        masterPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        return masterPanel;
    }


    /**
     * Method called to create the listeners that will be used in the frame.
     */
    public void createListeners() {
        //button to create a new honey bee hive
        newHoney.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        hiveDir.setBuilder(honeyBuilder);
                        hiveDir.makeHive();
                        Hive honeyHive = hiveDir.getHive();
                        beeHome.addHive(honeyHive);
                        apiaryHivesModel.addElement(honeyHive);
                        messageLabel.setText("New Honey Bee Hive created and"
                                + " added to your Apiary");
                        specialMessage.setText(beeHome.toString());

                    }

                }
        );

        //button to create new killer bee hive
        newKiller.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        hiveDir.setBuilder(killerBuilder);
                        hiveDir.makeHive();
                        Hive killerHive = hiveDir.getHive();
                        beeHome.addHive(killerHive);
                        apiaryHivesModel.addElement(killerHive);
                        messageLabel.setText("New Killer Bee Hive created and"
                                + " added to your Apiary");
                        specialMessage.setText("<html><br>" + beeHome.toString() 
                            + "\n \' The killer Queen has diamond eyes"
                            + " with laser beams, guaranteed to blow your"
                            + " minds\' --Freddie Mercury</br></html>");

                    }

                }
        );

        newBasic.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hiveDir.setBuilder(basicBuilder);
                        hiveDir.makeHive();
                        Hive basicHive = hiveDir.getHive();
                        beeHome.addHive(basicHive);
                        apiaryHivesModel.addElement(basicHive);
                        messageLabel.setText("New Basic Bee Hive created and"
                                + " added to your Apiary");
                        specialMessage.setText(beeHome.toString());

                    }

                }
        );

        apiaryHives.addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        Hive temp = (Hive) apiaryHives.getSelectedValue();
                        hiveQueen.setText(temp.getQueen().getAttribute());
                        hiveAttribute.setText(temp.getBeeAttribute());
                        hiveType.setText(temp.getBeeType());
                        hiveRooms.setText(Integer.toString(temp.getRooms()));
                        hiveWorkers.setText(Integer.toString(temp.getWorkers().size()));
                        messageLabel.setText(temp.toString());
                        if (temp.beeAttribute.contains("Killer")) {
                            specialMessage.setText("\n \' The killer Queen has diamond eyes"
                                    + " with laser beams, guaranteed to blow your"
                                    + " minds\' --Freddie Mercury</br></html>");
                        }


                    }

                }
        );







    }




}
