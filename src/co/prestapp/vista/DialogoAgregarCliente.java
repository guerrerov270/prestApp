package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import co.prestapp.DAO.ClienteDAO;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class DialogoAgregarCliente extends javax.swing.JDialog implements ActionListener {

	private JLabel jLabelNombre;
	private JLabel jLabelEmpresa;
	private JLabel jLabelReferencia;
	private JTextField jTextNombre;
	private JTextField jTextEmpresa;
	private JTextField jTextReferencia;
	private JButton jButtonGuardarCliente;
	private JButton jButtonCancelar;
	private JPanel jPanContenedorClientes;

	public DialogoAgregarCliente(VentanaPrincipal frame) {
		super(frame);
		initGUI(frame);

	}

	private void initGUI(VentanaPrincipal frame) {
		try {
			{
				jPanContenedorClientes = new JPanel();
				GridLayout jPanContenedorClientesLayout = new GridLayout(6, 2);
				jPanContenedorClientesLayout.setHgap(5);
				jPanContenedorClientesLayout.setVgap(5);
				getContentPane().add(jPanContenedorClientes, BorderLayout.CENTER);
				jPanContenedorClientes.setLayout(jPanContenedorClientesLayout);

				jLabelNombre = new JLabel();
				jPanContenedorClientes.add(jLabelNombre);
				jLabelNombre.setText("Nombre:");
				jLabelNombre.setBounds(44, 73, 60, 19);
				jLabelNombre.setFont(new java.awt.Font("Arial", 0, 16));

			}
			{
				jTextNombre = new JTextField();
				jPanContenedorClientes.add(jTextNombre);
				jTextNombre.setBounds(179, 66, 126, 26);
				jTextNombre.setFont(new java.awt.Font("Arial", 0, 16));
			}
			{
				jLabelEmpresa = new JLabel();
				jPanContenedorClientes.add(jLabelEmpresa);
				jLabelEmpresa.setText("Empresa:");
				jLabelEmpresa.setBounds(44, 116, 68, 19);
				jLabelEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
			}
			{
				jTextEmpresa = new JTextField();
				jPanContenedorClientes.add(jTextEmpresa);
				jTextEmpresa.setBounds(179, 111, 126, 26);
				jTextEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
			}
			{
				jLabelReferencia = new JLabel();
				jPanContenedorClientes.add(jLabelReferencia);
				jLabelReferencia.setText("Referencia:");
				jLabelReferencia.setBounds(44, 156, 80, 19);
				jLabelReferencia.setFont(new java.awt.Font("Arial", 0, 16));
			}

			{
				jTextReferencia = new JTextField();
				jPanContenedorClientes.add(jTextReferencia);
				// jPanContenedorClientes.add(getJButtonActualizar());
				jTextReferencia.setBounds(179, 149, 126, 26);
				jTextReferencia.setFont(new java.awt.Font("Arial", 0, 16));
			}
			{
				ImageIcon icono = new ImageIcon("res/guardar.png");
				Image img = icono.getImage();
				Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
				ImageIcon otroicon = new ImageIcon(otraimg);
				jButtonGuardarCliente = new JButton();
				jPanContenedorClientes.add(jButtonGuardarCliente);
				jButtonGuardarCliente.setText("Guardar");
				jButtonGuardarCliente.setBounds(44, 211, 135, 19);
				jButtonGuardarCliente.setFont(new java.awt.Font("Arial", 0, 16));
				jButtonGuardarCliente.addActionListener(this);

			}
			{
				ImageIcon icono = new ImageIcon("res/cancelar.png");
				Image img = icono.getImage();
				Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
				ImageIcon otroicon = new ImageIcon(otraimg);
				jButtonCancelar = new JButton();
				jPanContenedorClientes.add(jButtonCancelar);
				jButtonCancelar.setText("Cancelar");
				jButtonCancelar.setBounds(198, 211, 135, 19);
				jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 16));
				jButtonCancelar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						jButtonCancelarActionPerformed(evt);
					}
				});

			}

			setSize(400, 300);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {

		limpiarCamposCliente();
		ClienteDAO miCliente = new ClienteDAO();
		String codigoCliente = miCliente.recuperarCodigoCliente();
		System.out.println("Código de cliente:" + " " + codigoCliente);

	}

	public boolean validarCamposCliente() {

		boolean resultado = false;

		if (jTextNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe especificar un nombre para el cliente", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			resultado = true;
		}

		return resultado;
	}// Fin validarCamposCliente

	public void limpiarCamposCliente() {

		jTextNombre.setText("");
		jTextEmpresa.setText("");
		jTextReferencia.setText("");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jButtonGuardarCliente) {
			if (validarCamposCliente()) {
				String nombre = jTextNombre.getText();
				String empresa = jTextEmpresa.getText();
				String referencia = jTextReferencia.getText();
				ClienteDAO miCliente = new ClienteDAO();
				miCliente.agregarCliente(nombre, empresa, referencia);
				JOptionPane.showMessageDialog(this, "Cliente guardado con éxito", "Información",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarCamposCliente();
				
				
			}
		}

	}

}
