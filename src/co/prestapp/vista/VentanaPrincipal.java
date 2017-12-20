package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import co.prestapp.DAO.ClienteDAO;

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
	private JPanel jPanelAgregarCliente;
	private JTable jTableClientes;
	private JScrollPane jScrollPaneClientes;
	private JButton jButton1;
	private JButton jButtonGuardar;
	private JLabel jLabelEsPuntualR;
	private JLabel jLabel1EsCompletoR;
	private JLabel jLabelEsPuntual;
	private JLabel jLabelEsCompleto;
	private JTextField jTextCodigoPrestamo;
	private JLabel jLabelCodigoPrestamo;
	private JLabel jLabelFecha;
	private JTextField jTextField1;
	private JLabel jLabelMonto;
	private JTable jTableAbonosRecibidos;
	private JScrollPane jScrollAbonosRecibidos;
	private JPanel jPanelAbonosRecibidos;
	private JPanel jPanelAbonosPendientes;
	private JTable jTableAbonosPendientes;
	private JScrollPane jScrollAbonosPendientes;
	private JComboBox jComboFechasCobro;
	public JLabel jLabelCodigo;
	private JLabel jLabelEmpresaCliente;
	public JLabel jLabelNombreCliente;
	private JButton jButtonClienteNuevo;
	private JButton jButtonClienteExiste;
	private JLabel jLabelTotalFormato;
	private JLabel jLabelTotalPago;
	private JLabel jLabelCliente;
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
	private JDateChooser calendarioPrestamos;
	private JDateChooser calendarioAbonos;
	private JLabel jLabelNombre;
	private JLabel jLabelDirección;
	private JLabel jLabelTelefono;
	private JTextField jTextEmpresa;
	private JLabel jLabelReferencia;
	private JTextField jTextReferencia;
	private JButton jButtonActualizar;
	private JButton jButtonCancelar;
	private JButton jButtonGuardarCliente;
	private JTextField jTextTeléfono;
	private JTextField jTextDireccion;
	private JTextField jTextNombre;
	private JLabel jLabelEmpresa;
	

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
				BorderLayout jPanelClientesLayout = new BorderLayout();
				jPanelClientes.setLayout(jPanelClientesLayout);
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
							jLabelFechaFinResultado
									.setBounds(201, 217, 135, 15);
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
								final JButton jButtonCancelar = new JButton();
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
								calendarioPrestamos = new JDateChooser();
								jPanelEntradasPrestamo.add(calendarioPrestamos);
								calendarioPrestamos
										.setBounds(201, 129, 135, 22);
							}
							{
								jLabelNombreCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelNombreCliente);
								jLabelNombreCliente.setText("nombre");
								jLabelNombreCliente
										.setBounds(603, 122, 113, 15);
							}
							{
								jLabelCodigo = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCodigo);
								jLabelCodigo.setText("Código");
								jLabelCodigo.setBounds(603, 149, 113, 15);
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
						jPanelAbonosPendientes
								.setLayout(jPanelAbonosPendientesLayout);
						jPanelAbonos.add(jPanelAbonosPendientes,
								BorderLayout.CENTER);
						jPanelAbonosPendientes
								.setPreferredSize(new java.awt.Dimension(755,
										186));
						jPanelAbonosPendientes.setBorder(BorderFactory
								.createTitledBorder("Pendientes"));
						{
							jScrollAbonosPendientes = new JScrollPane();
							jPanelAbonosPendientes.add(jScrollAbonosPendientes,
									BorderLayout.CENTER);
							jScrollAbonosPendientes
									.setPreferredSize(new java.awt.Dimension(
											730, 157));
							{
								TableModel jTableAbonosPendientesModel = new DefaultTableModel(
										new String[][] { { "One", "Two" },
												{ "Three", "Four" } },
										new String[] { "Column 1", "Column 2" });
								jTableAbonosPendientes = new JTable();
								jScrollAbonosPendientes
										.setViewportView(jTableAbonosPendientes);
								jTableAbonosPendientes
										.setModel(jTableAbonosPendientesModel);
							}
						}
					}
					{
						jPanelAbonosRecibidos = new JPanel();
						BorderLayout jPanelAbonosRecibidosLayout = new BorderLayout();
						jPanelAbonosRecibidos
								.setLayout(jPanelAbonosRecibidosLayout);
						jPanelAbonos.add(jPanelAbonosRecibidos,
								BorderLayout.SOUTH);
						jPanelAbonosRecibidos
								.setPreferredSize(new java.awt.Dimension(763,
										181));
						jPanelAbonosRecibidos.setBorder(BorderFactory
								.createTitledBorder("Recibidos"));
						{
							jScrollAbonosRecibidos = new JScrollPane();
							jPanelAbonosRecibidos.add(jScrollAbonosRecibidos,
									BorderLayout.CENTER);
							jScrollAbonosRecibidos
									.setPreferredSize(new java.awt.Dimension(
											713, 146));
							{
								TableModel jTableAbonosRecibidosModel = new DefaultTableModel(
										new String[][] { { "One", "Two" },
												{ "Three", "Four" } },
										new String[] { "Column 1", "Column 2" });
								jTableAbonosRecibidos = new JTable();
								jScrollAbonosRecibidos
										.setViewportView(jTableAbonosRecibidos);
								jTableAbonosRecibidos
										.setModel(jTableAbonosRecibidosModel);
							}
						}
					}
					{
						jPanelAgregarAbono = new JPanel();
						jPanelAbonos
								.add(jPanelAgregarAbono, BorderLayout.NORTH);
						jPanelAgregarAbono
								.setPreferredSize(new java.awt.Dimension(756,
										138));
						jPanelAgregarAbono.setBorder(BorderFactory
								.createTitledBorder("Agregar abono"));
						jPanelAgregarAbono.setLayout(null);
						{
							jLabelMonto = new JLabel();
							jPanelAgregarAbono.add(jLabelMonto);
							jLabelMonto.setText("Monto:");
							jLabelMonto.setBounds(17, 29, 174, 15);
						}
						{
							jTextField1 = new JTextField();
							jPanelAgregarAbono.add(jTextField1);
							jTextField1.setBounds(191, 27, 115, 22);
						}
						{
							jLabelFecha = new JLabel();
							jPanelAgregarAbono.add(jLabelFecha);
							jLabelFecha.setText("Fecha:");
							jLabelFecha.setBounds(17, 68, 174, 15);
						}
						{
							calendarioAbonos = new JDateChooser();
							jPanelAgregarAbono.add(calendarioAbonos);
							calendarioAbonos.setBounds(191, 61, 135, 22);
						}
						{
							jLabelCodigoPrestamo = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoPrestamo);
							jLabelCodigoPrestamo.setText("Código préstamo:");
							jLabelCodigoPrestamo.setBounds(17, 101, 174, 15);
						}
						{
							jTextCodigoPrestamo = new JTextField();
							jPanelAgregarAbono.add(jTextCodigoPrestamo);
							jTextCodigoPrestamo.setBounds(191, 99, 115, 22);
						}
						{
							jLabelEsCompleto = new JLabel();
							jPanelAgregarAbono.add(jLabelEsCompleto);
							jLabelEsCompleto.setText("¿Abono completo?");
							jLabelEsCompleto.setBounds(433, 30, 201, 15);
						}
						{
							jLabelEsPuntual = new JLabel();
							jPanelAgregarAbono.add(jLabelEsPuntual);
							jLabelEsPuntual.setText("¿Abono puntual?");
							jLabelEsPuntual.setBounds(433, 68, 201, 15);
						}
						{
							jLabel1EsCompletoR = new JLabel();
							jPanelAgregarAbono.add(jLabel1EsCompletoR);
							jLabel1EsCompletoR.setText("Sí");
							jLabel1EsCompletoR.setBounds(676, 30, 84, 15);
						}
						{
							jLabelEsPuntualR = new JLabel();
							jPanelAgregarAbono.add(jLabelEsPuntualR);
							jLabelEsPuntualR.setText("Sí");
							jLabelEsPuntualR.setBounds(676, 68, 84, 15);
						}
						{
							jButtonGuardar = new JButton();
							jPanelAgregarAbono.add(jButtonGuardar);
							jButtonGuardar.setText("Guardar");
							jButtonGuardar.setBounds(433, 100, 132, 22);
						}
						{
							jButton1 = new JButton();
							jPanelAgregarAbono.add(jButton1);
							jButton1.setText("Cancelar");
							jButton1.setBounds(587, 100, 132, 22);
						}
					}
					jTabPestañas.addTab("Clientes", jPanelClientes);
					jPanelClientes.setBorder(BorderFactory.createTitledBorder("Datos de clientes"));
					{
					
						jScrollPaneClientes = new JScrollPane();
						jPanelClientes.add(jScrollPaneClientes,
								BorderLayout.CENTER);
						{
							

						}
					}
					{
						jPanelAgregarCliente = new JPanel();
						jPanelClientes.add(jPanelAgregarCliente, BorderLayout.NORTH);
						jPanelAgregarCliente.setPreferredSize(new java.awt.Dimension(767, 191));
						jPanelAgregarCliente.setLayout(null);
						{
							jLabelNombre = new JLabel();
							jPanelAgregarCliente.add(jLabelNombre);
							jLabelNombre.setText("Nombre:");
							jLabelNombre.setBounds(11, 12,184, 32);
							
						}
						{
							jLabelDirección = new JLabel();
							jPanelAgregarCliente.add(jLabelDirección);
							jLabelDirección.setText("Dirección:");
							jLabelDirección.setBounds(12, 59, 184, 32);
						}
						{
							jLabelEmpresa = new JLabel();
							jPanelAgregarCliente.add(jLabelEmpresa);
							jLabelEmpresa.setText("Empresa:");
							jLabelEmpresa.setBounds(12, 107, 184, 32);
						}
						{
							jLabelTelefono = new JLabel();
							jPanelAgregarCliente.add(jLabelTelefono);
							jLabelTelefono.setText("Telefono:");
							jLabelTelefono.setBounds(12, 155, 184, 32);
						}
						{
							jTextNombre = new JTextField();
							jPanelAgregarCliente.add(jTextNombre);
							jTextNombre.setBounds(114, 9,184, 32);
						}
						{
							jTextDireccion = new JTextField();
							jPanelAgregarCliente.add(jTextDireccion);
							jTextDireccion.setBounds(114, 51, 184, 32);
						}
						{
							jTextEmpresa = new JTextField();
							jPanelAgregarCliente.add(jTextEmpresa);
							jTextEmpresa.setBounds(114, 99, 184, 32);
						}
						{
							jTextTeléfono = new JTextField();
							jPanelAgregarCliente.add(jTextTeléfono);
							jTextTeléfono.setBounds(114, 152, 184, 32);
						}
						{
							jButtonGuardarCliente = new JButton();
							jPanelAgregarCliente.add(jButtonGuardarCliente);
							jButtonGuardarCliente.setText("Guardar");
							jButtonGuardarCliente.setBounds(452, 99, 184, 32);
							jButtonGuardarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarActionPerformed(evt);
								}
							});
						}
						{
							jButtonCancelar = new JButton();
							jPanelAgregarCliente.add(jButtonCancelar);
							jButtonCancelar.setText("Cancelar");
							jButtonCancelar.setBounds(452, 148, 184, 32);
							jButtonCancelar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonCancelarActionPerformed(evt);
								}
							});
						}
						{
							jLabelReferencia = new JLabel();
							jPanelAgregarCliente.add(jLabelReferencia);
							jLabelReferencia.setText("Referencia:");
							jLabelReferencia.setBounds(346, 12, 184, 32);
						}
						{
							jTextReferencia = new JTextField();
							jPanelAgregarCliente.add(jTextReferencia);
							jPanelAgregarCliente.add(getJButtonActualizar());
							jTextReferencia.setBounds(452, 13, 184, 32);
						}
					}
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

		// obtener los datos ingresados en el dialogo, guardar cliente en bd y
		// adjuntarlo a prestamo actual
	}

	private void jButtonClienteExisteActionPerformed(ActionEvent evt) {

		int codigoCliente = Integer.parseInt(JOptionPane
				.showInputDialog("Ingrese código del cliente"));

		// Busco el código en la bd y lo adjunto al prestamo
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
		ClienteDAO miCliente= new ClienteDAO();
		miCliente.agregarCliente(codigoCliente, nombre, direccion, empresa, telefono,
				referencia);	
		
	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {


	}
	
	public DefaultTableModel actualizaTabla(){
	
		ClienteDAO miCliente= new ClienteDAO();
		DefaultTableModel modelo=miCliente.llenaTablaClientes();
		return modelo;
		
		
	}
	
	private JButton getJButtonActualizar() {
		if(jButtonActualizar == null) {
			jButtonActualizar = new JButton();
			jButtonActualizar.setText("Actualizar");
			jButtonActualizar.setBounds(452, 51, 184, 32);
			jButtonActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonActualizarActionPerformed(evt);
				}
			});
		}
		return jButtonActualizar;
	}
	
	private void jButtonActualizarActionPerformed(ActionEvent evt) {
		
		jTableClientes= new JTable();
		jTableClientes.setModel(actualizaTabla());
		jScrollPaneClientes.setViewportView(jTableClientes);
	}
}
