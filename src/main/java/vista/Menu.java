package vista;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog {
    private JPanel contentPane;
    private JButton btnRegistro;
    private JButton btnConsultar;
    private JButton cerrarButton;

    public Menu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnRegistro);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(
                e -> {
                    onCancel();
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnRegistro.addActionListener(e -> {
            Registro registro = new Registro();
            registro.pack();
            registro.setVisible(true);
        });

        btnConsultar.addActionListener(e -> {
            Consulta consulta = new Consulta();
            consulta.pack();
            consulta.setVisible(true);
        });
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
