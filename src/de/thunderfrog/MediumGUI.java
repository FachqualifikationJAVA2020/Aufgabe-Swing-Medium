package de.thunderfrog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MediumGUI {
    private JFrame frame = new JFrame();

    private JTextField txtMediumName = new JTextField(10);
    private JTextField txtMediumPrice = new JTextField(10);

    private JRadioButton rbCD = new JRadioButton("CD");
    private JRadioButton rbDVD = new JRadioButton("DVD");
    private JRadioButton rbVHS = new JRadioButton("VHS");
    private JRadioButton rbMinidisk = new JRadioButton("MiniDisk");
    private JRadioButton rbSchallplatte = new JRadioButton("Schallplatte");

    protected static JComboBox<Person> cbPerson = new JComboBox<>();

    private JButton btnSave = new JButton("Save");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnNewPerson = new JButton("New Person");

    private MediumHandler mediumHandler;

    public MediumGUI(MediumHandler mediumHandler){
        this.mediumHandler = mediumHandler;

        frame.setTitle("Please add a new Medium");
        frame.setLayout(new GridLayout(4,2,2,2));

        //  Medium Details
        JPanel panelMediumDetails = new JPanel(new GridLayout(2,2,2,2));
        panelMediumDetails.add(new JLabel("Medium Name:"));
        panelMediumDetails.add(txtMediumName);

        panelMediumDetails.add(new JLabel("Medium Price:"));
        panelMediumDetails.add(txtMediumPrice);

        //  MediumTyp ButtonGroup & Panel
        ButtonGroup bgMediumTyp = new ButtonGroup();
        rbCD.setActionCommand("CD");
        bgMediumTyp.add(rbCD);
        rbDVD.setActionCommand("DVD");
        bgMediumTyp.add(rbDVD);
        rbMinidisk.setActionCommand("Minidisk");
        bgMediumTyp.add(rbMinidisk);
        rbSchallplatte.setActionCommand("Schallplatte");
        bgMediumTyp.add(rbSchallplatte);
        rbVHS.setActionCommand("VHS");
        bgMediumTyp.add(rbVHS);

        //  All Buttons from ButtonGroup
        JPanel panelMediumTyp = new JPanel(new GridLayout(1,5,2,2));
        panelMediumTyp.add(new JLabel("Medium Typ:"));
        ArrayList<AbstractButton> buttonList = Collections.list(bgMediumTyp.getElements());
        for(AbstractButton button: buttonList){
            panelMediumTyp.add(button);
        }

        //  Person Details
        JPanel panelPerson = new JPanel(new GridLayout(2,2,2,2));
        panelPerson.add(cbPerson);
        panelPerson.add(btnNewPerson);

        //  Button Panel
        JPanel panelButton = new JPanel(new GridLayout(1,2));
        panelButton.add(btnSave);
        panelButton.add(btnCancel);

        //  Add Panels to Frame
        frame.add(panelMediumDetails);
        frame.add(panelMediumTyp);
        frame.add(panelPerson);
        frame.add(panelButton);

        //  New Person Action
        btnNewPerson.addActionListener(ae -> {
            new PersonGUI();
        });

        //  Cancel Action
        btnCancel.addActionListener(ae -> {
            frame.setVisible(false);
        });

        //  New Medium Action
        btnSave.addActionListener(ae -> {
            Medium newMedium = new Medium(txtMediumName.getText(),Double.parseDouble(txtMediumPrice.getText()), bgMediumTyp.getSelection().getActionCommand(), (Person) cbPerson.getSelectedItem());
            mediumHandler.addMedium(newMedium);
            System.out.println(mediumHandler.getMediums());
            frame.setVisible(false);
        });




        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

    }
}
