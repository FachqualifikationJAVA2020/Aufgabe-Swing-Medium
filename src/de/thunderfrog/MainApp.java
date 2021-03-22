package de.thunderfrog;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainApp {

    protected JFrame frame;

    //  Person
    private JTextField txtFirstName = new JTextField(10);
    private JTextField txtLastName = new JTextField(10);
    private JTextField txtJobBox = new JTextField(10);
    protected static JComboBox<Person> cbPerson = new JComboBox<>();

    //  Medium
    private JTextField txtMediumName = new JTextField(10);
    private JTextField txtMediumPrice = new JTextField(10);
    private JTextField txtMediumTyp = new JTextField(10);
    private JTextField txtMediumCreatorFirstName = new JTextField(10);
    private JTextField txtMediumCreatorLastName = new JTextField(10);
    private JTextField txtMediumCreatorJobName = new JTextField(10);
    protected static JComboBox<Medium> cbMedium = new JComboBox<>();
    private MediumHandler mediumHandler;

    public MainApp() {

        mediumHandler = new MediumHandler();


        frame = new JFrame();
        frame.setTitle("Medien Datenbank - Version 1.0");
        frame.setLayout(new GridLayout(3,2));

        JPanel panelPerson = new JPanel();
        panelPerson.setLayout(new GridLayout(5,2,5,5));
        panelPerson.add(new JLabel("-- Person -- "));
        panelPerson.add(new JLabel(""));

        //  Select Person
        panelPerson.add(new JLabel("Select Person:"));
        panelPerson.add(cbPerson);

        //  Details Person
        panelPerson.add(new JLabel("First Name:"));
        txtFirstName.setEditable(false);
        panelPerson.add(txtFirstName);

        panelPerson.add(new JLabel("Second Name:"));
        txtLastName.setEditable(false);
        panelPerson.add(txtLastName);

        panelPerson.add(new JLabel("Job:"));
        txtJobBox.setEditable(false);
        panelPerson.add(txtJobBox);

        //  Edit Person/Medium
        JPanel panelEdit = new JPanel(new GridLayout(1,4));
        JButton btnNewPerson = new JButton("New Person");
        panelEdit.add(btnNewPerson);
        JButton btnDeletePerson = new JButton("Delete Person");
        panelEdit.add(btnDeletePerson);
        JButton btnNewMedia = new JButton("New Medium");
        panelEdit.add(btnNewMedia);
        JButton btnDeleteMedia = new JButton("Delete Medium");
        panelEdit.add(btnDeleteMedia);


        //  Medium Details
        JPanel panelMedium = new JPanel(new GridLayout(8,2));
        panelMedium.add(new JLabel("-- MEDIUM --"));
        panelMedium.add(new JLabel(""));

        panelMedium.add(new JLabel("Select Medium"));
        panelMedium.add(cbMedium);

        panelMedium.add(new JLabel("Medium Name:"));
        panelMedium.add(txtMediumName);

        panelMedium.add(new JLabel("Medium Price:"));
        panelMedium.add(txtMediumPrice);

        panelMedium.add(new JLabel("Medium Typ:"));
        panelMedium.add(txtMediumTyp);

        panelMedium.add(new JLabel("Medium Creator Firstname:"));
        panelMedium.add(txtMediumCreatorFirstName);

        panelMedium.add(new JLabel("Medium Creator Lastname:"));
        panelMedium.add(txtMediumCreatorLastName);

        panelMedium.add(new JLabel("Medium Creator Job:"));
        panelMedium.add(txtMediumCreatorJobName);

        //  Add Panels to Frame
        frame.add(panelPerson);
        frame.add(panelEdit);
        frame.add(panelMedium);


        //  New Person Action
        btnNewPerson.addActionListener(ae -> {
            new PersonGUI();
        });

        //  Select Person for Details Action
        cbPerson.addActionListener(ae -> {
            Person detailPerson = (Person) cbPerson.getSelectedItem();

            txtFirstName.setText(Objects.requireNonNull(detailPerson).getFirstName());
            txtLastName.setText(detailPerson.getLastName());
            txtJobBox.setText(detailPerson.getJob());
        });

        //  New Medium Action
        btnNewMedia.addActionListener(ae -> {
            new MediumGUI(mediumHandler);
        });

        cbMedium.addActionListener(ae -> {
            java.util.List<Medium> mList = mediumHandler.getMediums();
            for (Medium medium : mList) {
                cbMedium.addItem(medium);
            }
            Medium detailMedium = (Medium) cbMedium.getSelectedItem();

            txtMediumName.setText(Objects.requireNonNull(detailMedium).getmTitle());
            txtMediumPrice.setText(String.valueOf(detailMedium.getmCost()));
            txtMediumTyp.setText(detailMedium.getmType());
            txtMediumCreatorFirstName.setText(detailMedium.getCreator().getFirstName());
            txtMediumCreatorLastName.setText(detailMedium.getCreator().getLastName());
            txtMediumCreatorJobName.setText(detailMedium.getCreator().getJob());
        });

        //frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MainApp();
    }
}
