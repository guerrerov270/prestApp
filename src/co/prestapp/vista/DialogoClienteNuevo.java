package co.prestapp.vista;
import java.awt.BorderLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
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
					getContentPane().add(jPanelDatosNuevoCliente, BorderLayout.CENTER);
					jPanelDatosNuevoCliente.setPreferredSize(new java.awt.Dimension(390, 305));
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
						jTextNombre.setBounds(184, 69, 184, 32);
					}
					{
						jTextDireccion = new JTextField();
						jPanelDatosNuevoCliente.add(jTextDireccion);
						jTextDireccion.setBounds(184, 119, 184, 32);
					}
					{
						jTextEmpresa = new JTextField();
						jPanelDatosNuevoCliente.add(jTextEmpresa);
						jTextEmpresa.setBounds(184, 169, 184, 32);
					}
					{
						jTextTeléfono = new JTextField();
						jPanelDatosNuevoCliente.add(jTextTeléfono);
						jTextTeléfono.setBounds(184, 19, 184, 32);
					}
					{
						jButtonGuardar = new JButton();
						jPanelDatosNuevoCliente.add(jButtonGuardar);
						jButtonGuardar.setText("Guardar");
						jButtonGuardar.setBounds(69, 266, 120, 32);
					}
					{
						jButtonCancelar = new JButton();
						jPanelDatosNuevoCliente.add(jButtonCancelar);
						jButtonCancelar.setText("Cancelar");
						jButtonCancelar.setBounds(221, 266, 120, 32);
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

}
