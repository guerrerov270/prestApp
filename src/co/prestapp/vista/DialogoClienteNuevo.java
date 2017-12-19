package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import co.prestapp.controlador.ControlaDialogo;

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
public class DialogoClienteNuevo extends javax.swing.JDialog {
	private JPanel jPanelDatosNuevoCliente;
	private JLabel jLabelNombre;
	private JLabel jLabelDirección;
	private JLabel jLabelTelefono;
	private JTextField jTextEmpresa;
	private JLabel jLabelReferencia;
	private JTextField jTextReferencia;
	private JButton jButtonCancelar;
	private JButton jButtonGuardar;
	private JTextField jTextTeléfono;
	private JTextField jTextDireccion;
	private JTextField jTextNombre;
	private JLabel jLabelEmpresa;
	private ControlaDialogo controladorDialogo;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				DialogoClienteNuevo inst = new DialogoClienteNuevo(frame);
				inst.setVisible(true);
			}
		});
	}

	public DialogoClienteNuevo(JFrame frame) {
		super(frame);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Nuevo cliente");
				{
					jPanelDatosNuevoCliente = new JPanel();
					jPanelDatosNuevoCliente.setLayout(null);
					getContentPane().add(jPanelDatosNuevoCliente,
							BorderLayout.CENTER);
					jPanelDatosNuevoCliente
							.setPreferredSize(new java.awt.Dimension(390, 305));
					{
						jLabelNombre = new JLabel();
						jPanelDatosNuevoCliente.add(jLabelNombre);
						jLabelNombre.setText("Nombre:");
						jLabelNombre.setBounds(12, 18, 184, 32);

					}
					{
						jLabelDirección = new JLabel();
						jPanelDatosNuevoCliente.add(jLabelDirección);
						jLabelDirección.setText("Dirección:");
						jLabelDirección.setBounds(12, 68, 184, 32);
					}
					{
						jLabelEmpresa = new JLabel();
						jPanelDatosNuevoCliente.add(jLabelEmpresa);
						jLabelEmpresa.setText("Empresa:");
						jLabelEmpresa.setBounds(12, 118, 184, 32);
					}
					{
						jLabelTelefono = new JLabel();
						jPanelDatosNuevoCliente.add(jLabelTelefono);
						jLabelTelefono.setText("Telefono:");
						jLabelTelefono.setBounds(12, 168, 184, 32);
					}
					{
						jTextNombre = new JTextField();
						jPanelDatosNuevoCliente.add(jTextNombre);
						jTextNombre.setBounds(183, 19, 184, 32);
						jTextNombre.setText("nombre");
					}
					{
						jTextDireccion = new JTextField();
						jPanelDatosNuevoCliente.add(jTextDireccion);
						jTextDireccion.setBounds(181, 69, 184, 32);
					}
					{
						jTextEmpresa = new JTextField();
						jPanelDatosNuevoCliente.add(jTextEmpresa);
						jTextEmpresa.setBounds(182, 120, 184, 32);
					}
					{
						jTextTeléfono = new JTextField();
						jPanelDatosNuevoCliente.add(jTextTeléfono);
						jTextTeléfono.setBounds(181, 171, 184, 32);
					}
					{
						jButtonGuardar = new JButton();
						jPanelDatosNuevoCliente.add(jButtonGuardar);
						jButtonGuardar.setText("Guardar");
						jButtonGuardar.setBounds(69, 266, 120, 32);
						jButtonGuardar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonGuardarActionPerformed(evt);
							}
						});
					}
					{
						jButtonCancelar = new JButton();
						jPanelDatosNuevoCliente.add(jButtonCancelar);
						jButtonCancelar.setText("Cancelar");
						jButtonCancelar.setBounds(221, 266, 120, 32);
						jButtonCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonCancelarActionPerformed(evt);
							}
						});
					}
					{
						jLabelReferencia = new JLabel();
						jPanelDatosNuevoCliente.add(jLabelReferencia);
						jLabelReferencia.setText("Referencia:");
						jLabelReferencia.setBounds(12, 229, 184, 32);
					}
					{
						jTextReferencia = new JTextField();
						jPanelDatosNuevoCliente.add(jTextReferencia);
						jTextReferencia.setBounds(184, 222, 184, 32);
					}
				}
			}
			this.setSize(396, 349);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jButtonGuardarActionPerformed(ActionEvent evt) {

		Date fechaClave= new Date();
		DateFormat formato= new SimpleDateFormat("ddMMHHmmss");
		String clave= formato.format(new Date());		
		int codigoCliente= Integer.parseInt(clave);
		String nombre = jTextNombre.getText();
		String direccion = jTextDireccion.getText();
		String empresa = jTextEmpresa.getText();
		String telefono = jTextTeléfono.getText();
		String referencia = jTextReferencia.getText();
		controladorDialogo = new ControlaDialogo();
		controladorDialogo.guardarCliente(codigoCliente, nombre, direccion, empresa, telefono,
				referencia);
		this.setVisible(false);

	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {

		this.setVisible(false);

	}

}
