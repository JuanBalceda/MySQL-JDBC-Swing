package vista;

import mantenimiento.Mantenimiento;

import javax.swing.*;
import java.awt.event.*;

public class Registro extends JDialog {

    private JPanel panel1;
    private JTextField textCodigo;
    private JTextField textNombre;
    private JTextField textPrecio;
    private JTextField textCantidad;
    private JPanel panel2;
    private JButton btnRegistrar;
    private JButton btnNuevo;
    private JButton btnCerrar;

    public Registro() {
        setContentPane(panel1);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panel1.registerKeyboardAction(e -> {
                    onCancel();
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        Mantenimiento mantenimiento = new Mantenimiento();

        btnRegistrar.addActionListener(e -> {
            int codigo = Integer.parseInt(textCodigo.getText());
            String nombre = textNombre.getText();
            double precio = Double.parseDouble(textPrecio.getText());
            int cantidad = Integer.parseInt(textCantidad.getText());

            if (mantenimiento.insertar(codigo, nombre, precio, cantidad)) {
                JOptionPane.showMessageDialog(null, "Artículo registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar artículo");
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCodigo.setText("");
                textNombre.setText("");
                textPrecio.setText("");
                textCantidad.setText("");
                textCodigo.requestFocus();
            }
        });
        btnCerrar.addActionListener(new ActionListener() {
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

/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(new Registro().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
*/
}
