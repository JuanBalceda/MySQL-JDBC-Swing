package vista;

import mantenimiento.Mantenimiento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta extends JDialog {
    private JPanel contentPane;
    private JButton btnConsultar;
    private JButton btnLimpiar;
    private JTable tableArticulos;
    private DefaultTableModel tableModel = new DefaultTableModel(15, 4);

    private JButton btnCerrar;

    Mantenimiento mantenimiento = new Mantenimiento();

    public Consulta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnConsultar);
        tableArticulos.setModel(tableModel);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> {
                    onCancel();
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnConsultar.addActionListener(e -> {
            ResultSet datos = mantenimiento.consultar("SELECT * FROM articulos");
            int registro = 0;

            try {
                while (datos.next()) {
                    tableArticulos.setValueAt(datos.getInt(1), registro, 0);
                    tableArticulos.setValueAt(datos.getString(2), registro, 1);
                    tableArticulos.setValueAt(datos.getDouble(3), registro, 2);
                    tableArticulos.setValueAt(datos.getInt(4), registro, 3);
                    registro++;
                }
            } catch (SQLException error) {
                System.out.println(error);
                JOptionPane.showMessageDialog(null, "Error al consultar la base de datos.");
            }
        });

        btnCerrar.addActionListener(e -> {
            onCancel();
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = 0;
                for (int i = 0; i < tableArticulos.getRowCount(); i++) {
                    tableArticulos.setValueAt(" ", i, 0);
                    tableArticulos.setValueAt(" ", i, 1);
                    tableArticulos.setValueAt(" ", i, 2);
                    tableArticulos.setValueAt(" ", i, 3);
                    fila++;
                }
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
/*
    public static void main(String[] args) {
        Consulta dialog = new Consulta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
*/
}
