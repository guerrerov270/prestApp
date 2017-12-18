package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

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
@SuppressWarnings("serial")
public class VentanaPrincipal extends javax.swing.JFrame {

	private JPanel jPanelContenedor;
	private JPanel jPanelPrestamos;
	private JPanel jPanelAbonos;
	private JPanel jPanelClientes;
	private JPanel jPanelReportes;
	private JTabbedPane jTabPestañas;
	private JLabel jLabelMontoPrestamo;
	private JPanel jPanelAgregarAbono;
	private JTable jTableAbonosRecibidos;
	private JScrollPane jScrollAbonosRecibidos;
	private JPanel jPanelAbonosRecibidos;
	private JPanel jPanelAbonosPendientes;
	private JTable jTableAbonosPendientes;
	private JScrollPane jScrollAbonosPendientes;
	private JComboBox jComboFechasCobro;
	private JLabel jLabelTelefono;
	private JLabel jLabelEmpresaCliente;
	private JLabel jLabelNombreCliente;
	private JButton jButtonClienteNuevo;
	private JButton jButtonClienteExiste;
	private JLabel jLabelTotalFormato;
	private JLabel jLabelTotalPago;
	private JLabel jLabelCliente;
	private JButton jButtonCancelar;
	private JButton jButtonAceptar;
	private JLabel jLabelFechaFinResultado;
	private JComboBox jComboPlazo;
	private JLabel jLabelTipoPlazo;
	private JLabel jLabelFechaFin;
	private JLabel jLabelDiaCobro;
	private JLabel jLabelFechaInicio;
	private JTextField jTextNumeroCuotas;
	private JLabel jLabelNumeroCuotas;
	private JLabel jLabelPocentaje;
	private JTextField jTextTasaInteres;
	private JLabel jLabelTasaInteres;
	private JTextField jTextMonto;
	private JPanel jPanelEntradasPrestamo;
	private JTable jTablePrestamos;
	private JScrollPane jScrollReportes;
	private JDateChooser calendario;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaPrincipal inst = new VentanaPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public VentanaPrincipal() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("PrestApp 1.0");
			{
				jPanelContenedor = new JPanel();
				jPanelAbonos = new JPanel();
				BorderLayout jPanelAbonosLayout = new BorderLayout();
				jPanelAbonos.setLayout(jPanelAbonosLayout);
				jPanelClientes = new JPanel();
				jPanelPrestamos = new JPanel();
				BorderLayout jPanelPrestamosLayout = new BorderLayout();
				jPanelPrestamos.setLayout(jPanelPrestamosLayout);

				jPanelReportes = new JPanel();

				getContentPane().add(jPanelContenedor, BorderLayout.CENTER);
				jPanelContenedor.setLayout(null);
				{
					jTabPestañas = new JTabbedPane();
					jPanelContenedor.add(jTabPestañas);
					jTabPestañas.setBounds(8, 5, 782, 553);

					jTabPestañas.addTab("Préstamos", jPanelPrestamos);
					jPanelPrestamos.setPreferredSize(new java.awt.Dimension(
							777, 350));
					{
						jScrollReportes = new JScrollPane();
						jPanelPrestamos
								.add(jScrollReportes, BorderLayout.SOUTH);
						jScrollReportes
								.setPreferredSize(new java.awt.Dimension(753,
										219));
						{
							TableModel jTablePrestamosModel = new DefaultTableModel(
									new String[][] { { "One", "Two" },
											{ "Three", "Four" } },
									new String[] { "Cliente", "Empresa",
											"Monto", "Plazo", "Saldo pendiente" });
							jTablePrestamos = new JTable();
							jScrollReportes.setViewportView(jTablePrestamos);
							jTablePrestamos.setModel(jTablePrestamosModel);
						}
					}
					{
						jPanelEntradasPrestamo = new JPanel();
						jPanelPrestamos.add(jPanelEntradasPrestamo,
								BorderLayout.CENTER);
						jPanelEntradasPrestamo.setBorder(BorderFactory
								.createTitledBorder("Datos préstamo"));
						jPanelEntradasPrestamo.setLayout(null);
						{
							jLabelMontoPrestamo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelMontoPrestamo,
									new GridBagConstraints(0, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelMontoPrestamo.setText("Monto préstamo:");
							jLabelMontoPrestamo.setBounds(15, 36, 178, 15);
						}
						{
							jTextMonto = new JTextField();
							jPanelEntradasPrestamo.add(jTextMonto,
									new GridBagConstraints(1, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextMonto.setBounds(201, 29, 135, 22);
						}
						{
							jLabelTasaInteres = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTasaInteres,
									new GridBagConstraints(2, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelTasaInteres.setText("Tasa interés:");
							jLabelTasaInteres.setBounds(425, 36, 150, 15);
						}
						{
							jTextTasaInteres = new JTextField();
							jPanelEntradasPrestamo.add(jTextTasaInteres,
									new GridBagConstraints(3, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextTasaInteres.setBounds(605, 29, 111, 22);
						}
						{
							jLabelPocentaje = new JLabel();
							jPanelEntradasPrestamo.add(jLabelPocentaje,
									new GridBagConstraints(0, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelPocentaje.setText("%");
							jLabelPocentaje.setBounds(541, 36, 71, 15);
						}
						{
							jLabelNumeroCuotas = new JLabel();
							jPanelEntradasPrestamo.add(jLabelNumeroCuotas,
									new GridBagConstraints(1, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelNumeroCuotas.setText("Número cuotas:");
							jLabelNumeroCuotas.setBounds(425, 84, 150, 15);
						}
						{
							jTextNumeroCuotas = new JTextField();
							jPanelEntradasPrestamo.add(jTextNumeroCuotas,
									new GridBagConstraints(2, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextNumeroCuotas.setBounds(605, 77, 111, 22);
						}
						{
							jLabelDiaCobro = new JLabel();
							jPanelEntradasPrestamo.add(jLabelDiaCobro,
									new GridBagConstraints(3, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelDiaCobro.setText("Días de cobro:");
							jLabelDiaCobro.setBounds(15, 175, 178, 15);
						}
						{
							jLabelFechaInicio = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaInicio,
									new GridBagConstraints(0, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelFechaInicio.setText("Fecha de inicio:");
							jLabelFechaInicio.setBounds(15, 132, 178, 15);
						}
						{
							jLabelFechaFin = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaFin,
									new GridBagConstraints(1, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelFechaFin.setText("Fecha finalización:");
							jLabelFechaFin.setBounds(17, 217, 150, 15);
						}
						{
							jLabelFechaFinResultado = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaFinResultado,
									new GridBagConstraints(2, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelFechaFinResultado.setText("Fecha en formato");
							jLabelFechaFinResultado.setBounds(201, 217, 135, 15);
						}
						{
							jLabelTipoPlazo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTipoPlazo,
									new GridBagConstraints(3, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelTipoPlazo.setText("Tipo de plazo:");
							jLabelTipoPlazo.setBounds(15, 84, 178, 15);
						}
						{
							ComboBoxModel jComboPlazoModel = new DefaultComboBoxModel(
									new String[] { "Seleccione uno", "Mensual",
											"Quincenal", "Semanal", "Otro" });
							jComboPlazo = new JComboBox();
							jPanelEntradasPrestamo.add(jComboPlazo,
									new GridBagConstraints(0, 3, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jComboPlazo.setModel(jComboPlazoModel);
							jComboPlazo.setBounds(201, 77, 135, 22);
						}
						{
							jButtonAceptar = new JButton();
							jPanelEntradasPrestamo.add(jButtonAceptar,
									new GridBagConstraints(1, 3, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							{
								jButtonCancelar = new JButton();
								jPanelEntradasPrestamo.add(jButtonCancelar);
								jButtonCancelar.setText("Cancelar");
								jButtonCancelar.setBounds(603, 254, 135, 22);
							}
							{
								jLabelCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCliente);
								jLabelCliente.setText("Cliente:");
								jLabelCliente.setBounds(425, 128, 178, 15);
							}
							{
								jLabelTotalPago = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalPago);
								jLabelTotalPago.setText("Total a pagar:");
								jLabelTotalPago.setBounds(17, 261, 116, 15);
							}
							{
								jLabelTotalFormato = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalFormato);
								jLabelTotalFormato.setText("Total en formato");
								jLabelTotalFormato.setBounds(201, 261, 135, 15);
							}
							{
								jButtonClienteExiste = new JButton();
								jPanelEntradasPrestamo
										.add(jButtonClienteExiste);
								jButtonClienteExiste.setText("Existente");
								jButtonClienteExiste.setBounds(427, 214, 135,
										22);
								jButtonClienteExiste
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jButtonClienteExisteActionPerformed(evt);
											}
										});
							}
							{
								jButtonClienteNuevo = new JButton();
								jPanelEntradasPrestamo.add(jButtonClienteNuevo);
								jButtonClienteNuevo.setText("Nuevo");
								jButtonClienteNuevo
										.setBounds(603, 214, 135, 22);
								jButtonClienteNuevo
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jButtonClienteNuevoActionPerformed(evt);
											}
										});
							}
							{
								calendario = new JDateChooser();
								jPanelEntradasPrestamo.add(calendario);
								calendario.setBounds(201, 129, 135, 22);
							}
							{
								jLabelNombreCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelNombreCliente);
								jLabelNombreCliente.setText("nombreC");
								jLabelNombreCliente
										.setBounds(603, 122, 113, 15);
							}
							{
								jLabelEmpresaCliente = new JLabel();
								jPanelEntradasPrestamo
										.add(jLabelEmpresaCliente);
								jLabelEmpresaCliente.setText("empresa");
								jLabelEmpresaCliente.setBounds(603, 143, 113,
										15);
							}
							{
								jLabelTelefono = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTelefono);
								jLabelTelefono.setText("telefono");
								jLabelTelefono.setBounds(603, 164, 113, 15);
							}
							{
								ComboBoxModel jComboFechasCobroModel = new DefaultComboBoxModel(
										new String[] { "Ver fechas", "Fecha 1",
												"Fecha 2", "Fecha 3",
												"Fecha 4", "Fecha 5", "Fecha 6" });
								jComboFechasCobro = new JComboBox();
								jPanelEntradasPrestamo.add(jComboFechasCobro);
								jComboFechasCobro
										.setModel(jComboFechasCobroModel);
								jComboFechasCobro.setBounds(201, 171, 135, 22);
							}

							jButtonAceptar.setText("Guardar");
							jButtonAceptar.setBounds(427, 254, 135, 22);
						}
					}
					jTabPestañas.addTab("Abonos", jPanelAbonos);
					{
						jPanelAbonosPendientes = new JPanel();
						BorderLayout jPanelAbonosPendientesLayout = new BorderLayout();
						jPanelAbonosPendientes.setLayout(jPanelAbonosPendientesLayout);
						jPanelAbonos.add(jPanelAbonosPendientes, BorderLayout.CENTER);
						jPanelAbonosPendientes.setPreferredSize(new java.awt.Dimension(755, 186));
						jPanelAbonosPendientes.setBorder(BorderFactory.createTitledBorder("Pendientes"));
						{
							jScrollAbonosPendientes = new JScrollPane();
							jPanelAbonosPendientes.add(jScrollAbonosPendientes, BorderLayout.CENTER);
							jScrollAbonosPendientes.setPreferredSize(new java.awt.Dimension(730, 157));
							{
								TableModel jTableAbonosPendientesModel = 
										new DefaultTableModel(
												new String[][] { { "One", "Two" }, { "Three", "Four" } },
												new String[] { "Column 1", "Column 2" });
								jTableAbonosPendientes = new JTable();
								jScrollAbonosPendientes.setViewportView(jTableAbonosPendientes);
								jTableAbonosPendientes.setModel(jTableAbonosPendientesModel);
							}
						}
					}
					{
						jPanelAbonosRecibidos = new JPanel();
						BorderLayout jPanelAbonosRecibidosLayout = new BorderLayout();
						jPanelAbonosRecibidos.setLayout(jPanelAbonosRecibidosLayout);
						jPanelAbonos.add(jPanelAbonosRecibidos, BorderLayout.SOUTH);
						jPanelAbonosRecibidos.setPreferredSize(new java.awt.Dimension(763, 181));
						jPanelAbonosRecibidos.setBorder(BorderFactory.createTitledBorder("Recibidos"));
						{
							jScrollAbonosRecibidos = new JScrollPane();
							jPanelAbonosRecibidos.add(jScrollAbonosRecibidos, BorderLayout.CENTER);
							jScrollAbonosRecibidos.setPreferredSize(new java.awt.Dimension(713, 146));
							{
								TableModel jTableAbonosRecibidosModel = 
										new DefaultTableModel(
												new String[][] { { "One", "Two" }, { "Three", "Four" } },
												new String[] { "Column 1", "Column 2" });
								jTableAbonosRecibidos = new JTable();
								jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
								jTableAbonosRecibidos.setModel(jTableAbonosRecibidosModel);
							}
						}
					}
					{
						jPanelAgregarAbono = new JPanel();
						jPanelAbonos.add(jPanelAgregarAbono, BorderLayout.NORTH);
						jPanelAgregarAbono.setPreferredSize(new java.awt.Dimension(756, 138));
						jPanelAgregarAbono.setBorder(BorderFactory.createTitledBorder("Agregar abono"));
					}
					jTabPestañas.addTab("Clientes", jPanelClientes);
					jTabPestañas.addTab("Reportes", jPanelReportes);

				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButtonClienteNuevoActionPerformed(ActionEvent evt) {

		DialogoClienteNuevo dialogoClienteNuevo = new DialogoClienteNuevo(this);
		dialogoClienteNuevo.setVisible(true);

		// obtener los datos ingresados en el dialogo, guardar cliente en bd y
		// adjuntarlo a prestamo actual
	}

	private void jButtonClienteExisteActionPerformed(ActionEvent evt) {

		int codigoCliente = Integer.parseInt(JOptionPane
				.showInputDialog("Ingrese código del cliente"));

		// Busco el código en la bd y lo adjunto al prestamo
	}

}