package de.thunderfrog;


import javax.swing.*;
import java.awt.*;

public class MedienGUI {

    protected JFrame frame;
    private JTextField txtFirstName = new JTextField(10);
    private JTextField txtLastName = new JTextField(10);
    private JTextField txtJobBox = new JTextField(10);
    protected JComboBox<Person> cbPerson = new JComboBox<>();

    public MedienGUI() {

        frame = new JFrame();
        frame.setTitle("Medien Datenbank - Version 1.0");
        frame.setLayout(new GridLayout(4,2));

        JPanel person = new JPanel();
        person.setSize(400,300);
        person.setLayout(new GridLayout(4,2,5,5));

        //  Select Person
        person.add(new JLabel("Select Person"));
        person.add(cbPerson);

        //  Details Person
        person.add(new JLabel("First Name:"));
        txtFirstName.setEditable(false);
        person.add(txtFirstName);

        person.add(new JLabel("Second Name:"));
        txtLastName.setEditable(false);
        person.add(txtLastName);

        person.add(new JLabel("Job:"));
        txtJobBox.setEditable(false);
        person.add(txtJobBox);

        //  Edit Person
        JPanel editPerson = new JPanel(new GridLayout(1,1));
        JButton newPerson = new JButton("New Person");
        editPerson.add(newPerson);

        frame.add(person);
        frame.add(editPerson);

        //  New Person Action
        newPerson.addActionListener(ae -> {
            new PersonGUI(this);
        });

        //  Select Person for Details Action
        cbPerson.addActionListener(ae -> {
            Person detailPerson = (Person) cbPerson.getSelectedItem();
            txtFirstName.setText(detailPerson.getFirstName());
            txtLastName.setText(detailPerson.getLastName());
            txtJobBox.setText(detailPerson.getJob());
        });




        frame.setResizable(false);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
