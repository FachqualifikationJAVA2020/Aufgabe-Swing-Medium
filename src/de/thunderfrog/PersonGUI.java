package de.thunderfrog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PersonGUI {
    private JFrame frame = new JFrame();
    private JTextField txtFirstName = new JTextField(10);
    private JTextField txtLastName = new JTextField(10);
    private JButton btnSave = new JButton("Save");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnNewJob = new JButton("add Job");
    private JComboBox<String> cbJobBox = new JComboBox<>();
    private Person creator = new Person();
    private MedienGUI medienGUI;

    public PersonGUI(MedienGUI medienGUI) {
        this.medienGUI = medienGUI;
        frame.setTitle("Please add a new Person");

        frame.setLayout(new GridLayout(4,2,2,2));
        frame.add(new JLabel("Firstname:"));
        frame.add(txtFirstName);

        frame.add(new JLabel("Lastname:"));
        frame.add(txtLastName);


        frame.add(new JLabel("Job:"));
        ArrayList<String> jobname = new ArrayList<>(creator.addSomeJobs());
        for (String jobs: jobname) {
            cbJobBox.addItem(jobs);
        }
        frame.add(cbJobBox);

        JPanel panelButton = new JPanel(new GridLayout(1,3));
        panelButton.add(btnSave);
        panelButton.add(btnNewJob);
        panelButton.add(btnCancel);
        frame.add(panelButton);


        btnSave.addActionListener(ae -> {
            Person newPerson = new Person(txtFirstName.getText(),txtLastName.getText(), (String) cbJobBox.getSelectedItem());
            medienGUI.cbPerson.addItem(newPerson);
            frame.setVisible(false);
        });

        btnCancel.addActionListener(ae -> {
            frame.setVisible(false);
        });

        btnNewJob.addActionListener(ae -> {
            String newJobName = JOptionPane.showInputDialog("Please enter a new jobname", "Jobname");
            cbJobBox.addItem(newJobName);
        });

        frame.setResizable(false);
        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
