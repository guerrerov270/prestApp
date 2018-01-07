package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingUtilities;

import co.prestapp.DAO.AbonoDAO;
import co.prestapp.DAO.ClienteDAO;
import co.prestapp.DAO.PrestamoDAO;
import co.prestapp.VO.AbonoVO;
import co.prestapp.VO.ClienteVO;

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
	private JButton jButtonCancelarAbono;
	private JButton jButtonGuardar;
	private JTextField jTextCodigoPrestamo;
	private JLabel jLabelCodigoPrestamo;
	private JLabel jLabelFecha;
	private JTextField jTextField1;
	private JLabel jLabelMonto;
	private JTable jTableAbonosRecibidos;
	private JScrollPane jScrollAbonosRecibidos;
	private JComboBox jComboFechasCobro;
	public JLabel jLabelCodigo;
	public JLabel jLabelNombreCliente;
	private JButton jButtonClienteExiste;
	private JLabel jLabelTotalFormato;
	private JLabel jLabelTotalPago;
	private JLabel jLabelCliente;
	private JButton jButtonAceptar;
	private JComboBox jComboPlazo;
	private JLabel jLabelTipoPlazo;
	private JLabel jLabelDiaCobro;
	private JLabel jLabelFechaInicio;
	private JTextField jTextNumeroCuotas;
	private JLabel jLabelNumeroCuotas;
	private JLabel jLabelPocentaje;
	private JTextField jTextTasaInteres;
	private JLabel jLabelTasaInteres;
	private JFormattedTextField jTextMonto;
	private JPanel jPanelEntradasPrestamo;
	private JTable jTablePrestamos;
	private JScrollPane jScrollReportes;
	private JDateChooser calendarioPrestamos;
	private JDateChooser calendarioAbonos;
	private JLabel jLabelNombre;
	private JTextField jTextEmpresa;
	private JLabel jLabelReferencia;
	private JTextField jTextReferencia;
	private JButton jButtonAbonosPendientes;
	private JButton jButtonAbonosPagados;
	private JTextField jTextFieldCodigoAbono;
	private JLabel jLabelCodigoAbono;
	private JButton jButtonActualizarAbonos;
	private JButton jButtonBuscarPrestamo;
	private JLabel jLabelEmpresaResult;
	private JButton jButton2;
	private JButton jButtonCalcular;
	private JButton jButtonActualizar;
	private JButton jButtonCancelar;
	private JButton jButtonCancelarPrestamo;
	private JButton jButtonGuardarCliente;
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
		actualizaPrestamos();
		actualizaAbonos();
		actualizaClientes();		

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("PrestApp 1.0");
			{
				jPanelContenedor = new JPanel();
				BorderLayout jPanelContenedorLayout = new BorderLayout();
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
				jPanelContenedor.setLayout(jPanelContenedorLayout);
				{
					jTabPestañas = new JTabbedPane();
					jPanelContenedor.add(jTabPestañas, BorderLayout.CENTER);
					jTabPestañas.setBounds(8, 5, 782, 553);

					jTabPestañas.addTab("Préstamos", jPanelPrestamos);
					jPanelPrestamos.setPreferredSize(new java.awt.Dimension(
							777, 350));
					{
						jScrollReportes = new JScrollPane();
						jPanelPrestamos
								.add(jScrollReportes, BorderLayout.SOUTH);
						jScrollReportes.setBounds(8, 263, 777, 381);
						jScrollReportes
								.setPreferredSize(new java.awt.Dimension(777,
										303));
						{

						}
					}
					{
						jPanelEntradasPrestamo = new JPanel();
						jPanelPrestamos.add(jPanelEntradasPrestamo,
								BorderLayout.NORTH);
						jPanelEntradasPrestamo.setBorder(BorderFactory
								.createTitledBorder("Datos préstamo"));
						jPanelEntradasPrestamo.setLayout(null);
						jPanelEntradasPrestamo
								.setPreferredSize(new java.awt.Dimension(777,
										322));
						{
							jLabelMontoPrestamo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelMontoPrestamo,
									new GridBagConstraints(0, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelMontoPrestamo.setText("Monto préstamo:");
							jLabelMontoPrestamo.setBounds(40, 35, 178, 23);
							jLabelMontoPrestamo.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							//MaskFormatter formatoMoneda= new MaskFormatter("$ ###,###");
							jTextMonto = new JFormattedTextField();
							jPanelEntradasPrestamo.add(jTextMonto,
									new GridBagConstraints(1, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextMonto.setBounds(250, 35, 178, 23);
							jTextMonto
									.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTasaInteres = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTasaInteres,
									new GridBagConstraints(2, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelTasaInteres.setText("Tasa interés:");
							jLabelTasaInteres.setBounds(498, 35, 178, 23);
							jLabelTasaInteres.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jTextTasaInteres = new JTextField();
							jPanelEntradasPrestamo.add(jTextTasaInteres,
									new GridBagConstraints(3, 0, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextTasaInteres.setBounds(676, 35, 119, 23);
							jTextTasaInteres.setFont(new java.awt.Font("Arial",
									0, 16));
						}
						{
							jLabelPocentaje = new JLabel();
							jPanelEntradasPrestamo.add(jLabelPocentaje,
									new GridBagConstraints(0, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelPocentaje.setText("%");
							jLabelPocentaje.setBounds(604, 35, 64, 23);
						}
						{
							jLabelNumeroCuotas = new JLabel();
							jPanelEntradasPrestamo.add(jLabelNumeroCuotas,
									new GridBagConstraints(1, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelNumeroCuotas.setText("Número cuotas:");
							jLabelNumeroCuotas.setBounds(498, 79, 178, 23);
							jLabelNumeroCuotas.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jTextNumeroCuotas = new JTextField();
							jPanelEntradasPrestamo.add(jTextNumeroCuotas,
									new GridBagConstraints(2, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jTextNumeroCuotas.setBounds(676, 79, 119, 23);
							jTextNumeroCuotas.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jLabelDiaCobro = new JLabel();
							jPanelEntradasPrestamo.add(jLabelDiaCobro,
									new GridBagConstraints(3, 1, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelDiaCobro.setText("Días de cobro:");
							jLabelDiaCobro.setBounds(41, 175, 178, 23);
							jLabelDiaCobro.setFont(new java.awt.Font("Arial",
									0, 16));
						}
						{
							jLabelFechaInicio = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaInicio,
									new GridBagConstraints(0, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelFechaInicio.setText("Fecha de inicio:");
							jLabelFechaInicio.setBounds(41, 124, 178, 23);
							jLabelFechaInicio.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jLabelTipoPlazo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTipoPlazo,
									new GridBagConstraints(3, 2, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jLabelTipoPlazo.setText("Tipo de plazo:");
							jLabelTipoPlazo.setBounds(40, 79, 178, 23);
							jLabelTipoPlazo.setFont(new java.awt.Font("Arial",
									0, 16));
						}
						{
							ComboBoxModel jComboPlazoModel = new DefaultComboBoxModel(
									new String[] { "Seleccione uno", "Mensual",
											"Quincenal", "Semanal" });
							jComboPlazo = new JComboBox();
							jPanelEntradasPrestamo.add(jComboPlazo,
									new GridBagConstraints(0, 3, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							jComboPlazo.setModel(jComboPlazoModel);
							jComboPlazo.setBounds(248, 79, 178, 23);
							jComboPlazo.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jButtonAceptar = new JButton();
							jPanelEntradasPrestamo.add(jButtonAceptar,
									new GridBagConstraints(1, 3, 1, 1, 0.0,
											0.0, GridBagConstraints.CENTER,
											GridBagConstraints.NONE,
											new Insets(0, 0, 0, 0), 0, 0));
							{
								JButton jButtonCancelarPrestamo = new JButton();
								jPanelEntradasPrestamo
										.add(jButtonCancelarPrestamo);
								jButtonCancelarPrestamo.setText("Cancelar");
								jButtonCancelarPrestamo.setBounds(249, 253,
										178, 23);
								jButtonCancelarPrestamo
										.setFont(new java.awt.Font("Arial", 0,
												16));
								jButtonCancelarPrestamo
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jButtonCancelarPrestamoActionPerformed(evt);
											}
										});

							}
							{
								jLabelCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCliente);
								jLabelCliente.setText("Cliente:");
								jLabelCliente.setBounds(498, 175, 178, 23);
								jLabelCliente.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}
							{
								jLabelTotalPago = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalPago);
								jLabelTotalPago.setText("Total a pagar:");
								jLabelTotalPago.setBounds(42, 214, 178, 30);
								jLabelTotalPago.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}
							{
								jLabelTotalFormato = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalFormato);
								jLabelTotalFormato.setText("Total en formato");
								jLabelTotalFormato.setBounds(249, 214, 178, 30);
								jLabelTotalFormato.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}
							{
								jButtonClienteExiste = new JButton();
								jPanelEntradasPrestamo
										.add(jButtonClienteExiste);
								jButtonClienteExiste.setText("Buscar");
								jButtonClienteExiste.setBounds(676, 175, 119,
										23);
								jButtonClienteExiste.setFont(new java.awt.Font(
										"Arial", 0, 16));
								jButtonClienteExiste
										.addActionListener(new ActionListener() {
											public void actionPerformed(
													ActionEvent evt) {
												jButtonClienteExisteActionPerformed(evt);
											}
										});
							}
							{
								calendarioPrestamos = new JDateChooser();
								calendarioPrestamos.setLocale(new Locale("ES",
										"CO"));
								calendarioPrestamos
										.setDateFormatString("dd/MM/yyyy");
								jPanelEntradasPrestamo.add(calendarioPrestamos);
								calendarioPrestamos
										.setBounds(248, 124, 178, 23);
								calendarioPrestamos.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}
							{
								jLabelNombreCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelNombreCliente);
								jLabelNombreCliente.setText("nombre");
								jLabelNombreCliente
										.setBounds(498, 214, 178, 23);
								jLabelNombreCliente.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}
							{
								jLabelCodigo = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCodigo);
								jLabelCodigo.setText("Código");
								jLabelCodigo.setBounds(676, 214, 178, 23);
								jLabelCodigo.setFont(new java.awt.Font("Arial",
										0, 16));
							}
							{

								jComboFechasCobro = new JComboBox();
								jPanelEntradasPrestamo.add(jComboFechasCobro);
								DefaultComboBoxModel modelo = new DefaultComboBoxModel();
								modelo.addElement("Nada para mostrar");
								jComboFechasCobro.setModel(modelo);
								jPanelEntradasPrestamo
										.add(getJButtonCalcular());
								jPanelEntradasPrestamo.add(getJButton2());
								jPanelEntradasPrestamo
										.add(getJLabelEmpresaResult());
								jComboFechasCobro.setBounds(251, 175, 178, 23);
								jComboFechasCobro.setFont(new java.awt.Font(
										"Arial", 0, 16));
							}

							jButtonAceptar.setText("Guardar");
							jButtonAceptar.setBounds(43, 253, 178, 23);
							jButtonAceptar.setFont(new java.awt.Font("Arial",
									0, 16));
							jButtonAceptar
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jButtonAceptarActionPerformed(evt);
										}
									});
						}
					}
					jTabPestañas.addTab("Abonos", jPanelAbonos);
					{
						jScrollAbonosRecibidos = new JScrollPane();
						jPanelAbonos.add(jScrollAbonosRecibidos,
								BorderLayout.SOUTH);
						jScrollAbonosRecibidos.setBounds(5, 212, 767, 410);
						jScrollAbonosRecibidos
								.setPreferredSize(new java.awt.Dimension(777,
										414));
						{

						}
					}
					{
						jPanelAgregarAbono = new JPanel();
						jPanelAbonos
								.add(jPanelAgregarAbono, BorderLayout.NORTH);
						jPanelAgregarAbono
								.setPreferredSize(new java.awt.Dimension(777,
										208));
						jPanelAgregarAbono.setBorder(BorderFactory
								.createTitledBorder("Agregar abono"));
						jPanelAgregarAbono.setLayout(null);
						{
							jLabelMonto = new JLabel();
							jPanelAgregarAbono.add(jLabelMonto);
							jLabelMonto.setText("Monto:");
							jLabelMonto.setBounds(45, 115, 146, 23);
							jLabelMonto.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jTextField1 = new JTextField();
							jPanelAgregarAbono.add(jTextField1);
							jTextField1.setBounds(240, 116, 146, 23);
							jTextField1.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jLabelFecha = new JLabel();
							jPanelAgregarAbono.add(jLabelFecha);
							jLabelFecha.setText("Fecha:");
							jLabelFecha.setBounds(43, 72, 146, 23);
							jLabelFecha.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							calendarioAbonos = new JDateChooser();
							jPanelAgregarAbono.add(calendarioAbonos);
							calendarioAbonos.setBounds(240, 74, 146, 23);
							calendarioAbonos.setFont(new java.awt.Font("Arial",
									0, 16));
						}
						{
							jLabelCodigoPrestamo = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoPrestamo);
							jLabelCodigoPrestamo.setText("Código préstamo:");
							jLabelCodigoPrestamo.setBounds(44, 29, 146, 23);
							jLabelCodigoPrestamo.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jTextCodigoPrestamo = new JTextField();
							jPanelAgregarAbono.add(jTextCodigoPrestamo);
							jTextCodigoPrestamo.setBounds(240, 32, 146, 23);
							jTextCodigoPrestamo.setFont(new java.awt.Font(
									"Arial", 0, 16));
						}
						{
							jButtonGuardar = new JButton();
							jPanelAgregarAbono.add(jButtonGuardar);
							jButtonGuardar.setText("Guardar");
							jButtonGuardar.setBounds(457, 114, 146, 23);
							jButtonGuardar.setFont(new java.awt.Font("Arial",
									0, 16));
							jButtonGuardar
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jButtonGuardarAbonoActionPerformed(evt);
										}
									});
						}
						{
							jButtonCancelarAbono = new JButton();
							jPanelAgregarAbono.add(jButtonCancelarAbono);
							jPanelAgregarAbono.add(getJButtonBuscarPrestamo());
							jPanelAgregarAbono
									.add(getJButtonActualizarAbonos());
							jPanelAgregarAbono.add(getJLabelCodigoAbono());
							jPanelAgregarAbono.add(getJTextFieldCodigoAbono());
							jPanelAgregarAbono.add(getJButtonAbonosPagados());
							jPanelAgregarAbono
									.add(getJButtonAbonosPendientes());
							jButtonCancelarAbono.setText("Cancelar");
							jButtonCancelarAbono.setBounds(653, 114, 146, 23);
							jButtonCancelarAbono.setFont(new java.awt.Font(
									"Arial", 0, 16));
							jButtonCancelarAbono
									.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(
												ActionEvent e) {
											jButtonCancelarAbonoActionPerformed(e);

										}
									});
						}
					}
					jTabPestañas.addTab("Clientes", jPanelClientes);
					jPanelClientes.setBorder(BorderFactory
							.createTitledBorder("Datos de clientes"));
					jPanelClientes.setPreferredSize(new java.awt.Dimension(767,
							526));
					{

						jScrollPaneClientes = new JScrollPane();
						jPanelClientes.add(jScrollPaneClientes,
								BorderLayout.SOUTH);
						jScrollPaneClientes
								.setPreferredSize(new java.awt.Dimension(767,
										405));
						{

						}
					}
					{
						jPanelAgregarCliente = new JPanel();
						jPanelClientes.add(jPanelAgregarCliente,
								BorderLayout.NORTH);
						jPanelAgregarCliente
								.setPreferredSize(new java.awt.Dimension(767,
										191));
						jPanelAgregarCliente.setLayout(null);
						{
							jLabelNombre = new JLabel();
							jPanelAgregarCliente.add(jLabelNombre);
							jLabelNombre.setText("Nombre:");
							jLabelNombre.setBounds(12, 11, 178, 23);
							jLabelNombre.setFont(new java.awt.Font("Arial", 0,
									16));

						}
						{
							jLabelEmpresa = new JLabel();
							jPanelAgregarCliente.add(jLabelEmpresa);
							jLabelEmpresa.setText("Empresa:");
							jLabelEmpresa.setBounds(12, 69, 178, 23);
							jLabelEmpresa.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jTextNombre = new JTextField();
							jPanelAgregarCliente.add(jTextNombre);
							jTextNombre.setBounds(110, 11, 178, 23);
							jTextNombre.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jTextEmpresa = new JTextField();
							jPanelAgregarCliente.add(jTextEmpresa);
							jTextEmpresa.setBounds(110, 69, 178, 23);
							jTextEmpresa.setFont(new java.awt.Font("Arial", 0,
									16));
						}
						{
							jButtonGuardarCliente = new JButton();
							jPanelAgregarCliente.add(jButtonGuardarCliente);
							jButtonGuardarCliente.setText("Guardar");
							jButtonGuardarCliente.setBounds(334, 69, 178, 23);
							jButtonGuardarCliente.setFont(new java.awt.Font(
									"Arial", 0, 16));
							jButtonGuardarCliente
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jButtonGuardarClienteActionPerformed(evt);
										}
									});
						}
						{
							jButtonCancelar = new JButton();
							jPanelAgregarCliente.add(jButtonCancelar);
							jButtonCancelar.setText("Cancelar");
							jButtonCancelar.setBounds(334, 128, 178, 23);
							jButtonCancelar.setFont(new java.awt.Font("Arial",
									0, 16));
							jButtonCancelar
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evt) {
											jButtonCancelarActionPerformed(evt);
										}
									});
						}
						{
							jLabelReferencia = new JLabel();
							jPanelAgregarCliente.add(jLabelReferencia);
							jLabelReferencia.setText("Referencia:");
							jLabelReferencia.setBounds(13, 128, 178, 23);
							jLabelReferencia.setFont(new java.awt.Font("Arial",
									0, 16));
						}
						{
							jTextReferencia = new JTextField();
							jPanelAgregarCliente.add(jTextReferencia);
							jPanelAgregarCliente.add(getJButtonActualizar());
							jTextReferencia.setBounds(111, 128, 178, 23);
							jTextReferencia.setFont(new java.awt.Font("Arial",
									0, 16));
						}
					}
					jTabPestañas.addTab("Reportes", jPanelReportes);

				}
			}
			pack();
			this.setSize(885, 681);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButtonClienteExisteActionPerformed(ActionEvent evt) {

		try {
			String codigoCliente = JOptionPane
					.showInputDialog("Ingrese código del cliente");
			// Busco el código en la bd y lo adjunto al prestamo
			ClienteDAO miCliente = new ClienteDAO();
			ClienteVO cliente = miCliente.buscarCliente(codigoCliente);

			// Cambio valores de etiquetas en la vista
			jLabelNombreCliente.setText(cliente.getNombreCliente());
			jLabelCodigo.setForeground(Color.RED);
			jLabelCodigo.setText(cliente.getCodigoCliente() + "");
			jLabelEmpresaResult.setText(cliente.getEmpresaCliente());

		} catch (NumberFormatException e) {

			System.out.println(e.getMessage());
		}

	}

	/**
	 * Guarda los clientes
	 * 
	 * @param evt
	 */
	private void jButtonGuardarClienteActionPerformed(ActionEvent evt) {

		String nombre = jTextNombre.getText();
		String empresa = jTextEmpresa.getText();
		String referencia = jTextReferencia.getText();
		ClienteDAO miCliente = new ClienteDAO();
		miCliente.agregarCliente(nombre, empresa, referencia);
		limpiarCamposCliente();
		actualizaClientes();

	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {

		limpiarCamposCliente();
		ClienteDAO miCliente = new ClienteDAO();
		String codigoCliente = miCliente.recuperarCodigoCliente();
		System.out.println("Código de cliente:" + " " + codigoCliente);

	}

	private void jButtonCancelarPrestamoActionPerformed(ActionEvent evt) {

		limpiarCamposPrestamo();
	}

	private JButton getJButtonActualizar() {
		if (jButtonActualizar == null) {
			jButtonActualizar = new JButton();
			jButtonActualizar.setText("Actualizar");
			jButtonActualizar.setBounds(334, 11, 184, 32);
			jButtonActualizar.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonActualizar.setSize(178, 23);
			jButtonActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonActualizarActionPerformed(evt);
				}
			});
		}
		return jButtonActualizar;
	}

	/**
	 * Actualiza la tabla de clientes
	 * 
	 * @param evt
	 */
	private void jButtonActualizarActionPerformed(ActionEvent evt) {

		actualizaClientes();
	}

	public void limpiarCamposCliente() {

		jTextNombre.setText("");
		jTextEmpresa.setText("");
		jTextReferencia.setText("");

	}

	public void limpiarCamposPrestamo() {

		jTextMonto.setText("");
		jTextTasaInteres.setText("");
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		modelo.addElement("Nada para mostrar");
		jComboFechasCobro.setModel(modelo);
		jTextNumeroCuotas.setText("");
		jLabelTotalFormato.setText("");
		jComboPlazo.setSelectedIndex(0);

	}

	private JButton getJButtonCalcular() {
		if (jButtonCalcular == null) {
			jButtonCalcular = new JButton();
			jButtonCalcular.setText("Calcular");
			jButtonCalcular.setBounds(498, 124, 131, 23);
			jButtonCalcular.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						jButtonCalcularActionPerformed(evt);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			});
		}
		return jButtonCalcular;
	}

	private void jButtonCalcularActionPerformed(ActionEvent evt)
			throws Exception {

		float montoPrestamo = Float.parseFloat(jTextMonto.getText());
		int tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
		String tipoPlazo = (String) jComboPlazo.getSelectedItem();
		int numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
		Date fechaInicio = calendarioPrestamos.getDate();
		// java.sql.Date fechaFormateada = new
		// java.sql.Date(fechaInicio.getTime());
		// DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");

		PrestamoDAO miPrestamo = new PrestamoDAO();
		ArrayList<Date> fechasPago = miPrestamo.calcularFechasPago(tipoPlazo,
				numeroCuotas, fechaInicio);
		DefaultComboBoxModel modeloNuevo = new DefaultComboBoxModel();
		modeloNuevo = llenaComboPlazos(fechasPago);
		jComboFechasCobro.setModel(modeloNuevo);

		double totalPagar = miPrestamo.calcularPrestamo(montoPrestamo,
				tasaInteres, tipoPlazo, numeroCuotas);
		jLabelTotalFormato.setText(totalPagar + "");

		// System.out.println(montoPrestamo);
		// System.out.println(tasaInteres);
		// System.out.println(tipoPlazo);
		// System.out.println(numeroCuotas);
		// System.out.println(fechaFormateada);
		// System.out.println("Sumando dias a la fecha");
		// Date nuevaFecha = sumarRestarDiasFecha(fechaFormateada, 15);
		// java.sql.Date fechaNuevaFormateada = new java.sql.Date(
		// nuevaFecha.getTime());
		// System.out.println(fechaNuevaFormateada);
		// System.out.println(formato.format(fechaNuevaFormateada));

	}// Fin método jButtonCalcularActionPerformed

	// Suma los días recibidos a la fecha
	public Date sumarRestarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
													// restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos

	}

	/**
	 * Guarda los préstamos
	 * 
	 * @param evt
	 */
	private void jButtonAceptarActionPerformed(ActionEvent evt) {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		AbonoDAO miAbono = new AbonoDAO();
		// Recojo los datos necesarios
		float montoPrestamo = Float.parseFloat(jTextMonto.getText());
		int tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
		int numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
		String tipoPlazo = (String) jComboPlazo.getSelectedItem();
		String tipoPlazoMayus = tipoPlazo.toUpperCase();
		// El saldo pendiente
		double totalPagar = miPrestamo.calcularPrestamo(montoPrestamo,
				tasaInteres, tipoPlazo, numeroCuotas);
		// El saldo pagado
		double totalPagado = 0;
		Date fechaInicio = calendarioPrestamos.getDate();
		// Fecha de fin
		ArrayList<Date> fechasPago = miPrestamo.calcularFechasPago(tipoPlazo,
				numeroCuotas, fechaInicio);
		// La ultima fecha del arreglo
		int tamañoArray = fechasPago.size();
		Date fechaFin = fechasPago.get(tamañoArray - 1);

		// Busco el cliente de nuevo
		String codigoCliente = JOptionPane
				.showInputDialog("Verifique código del cliente");
		// Busco el código en la bd y lo adjunto al prestamo
		ClienteDAO miCliente = new ClienteDAO();
		ClienteVO cliente = miCliente.buscarCliente(codigoCliente);

		// Cambio valores de etiquetas en la vista
		jLabelNombreCliente.setText(cliente.getNombreCliente());
		jLabelCodigo.setForeground(Color.RED);
		jLabelCodigo.setText(cliente.getCodigoCliente() + "");
		jLabelEmpresaResult.setText(cliente.getEmpresaCliente());

		// El estado del prestamo
		String estadoPrestamo = "PENDIENTE";

		// Agrego el prestamo
		String codigoPrestamo = miPrestamo.agregarPrestamo(montoPrestamo,
				tasaInteres, numeroCuotas, totalPagar, totalPagado,
				fechaInicio, fechaFin, tipoPlazoMayus, codigoCliente,
				estadoPrestamo);

		// Creo los abonos correspondientes a ese préstamo
		miAbono.crearAbonosPrestamo(totalPagar, numeroCuotas, fechasPago,
				codigoPrestamo);

		limpiarCamposPrestamo();
		actualizaPrestamos();

	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Actualizar");
			jButton2.setBounds(676, 253, 119, 23);
			jButton2.setFont(new java.awt.Font("Arial", 0, 16));
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
		}
		return jButton2;
	}

	/**
	 * Actualiza la tabla de prestamos
	 * 
	 * @param evt
	 */
	private void jButton2ActionPerformed(ActionEvent evt) {

		actualizaPrestamos();
	}

	private JLabel getJLabelEmpresaResult() {
		if (jLabelEmpresaResult == null) {
			jLabelEmpresaResult = new JLabel();
			jLabelEmpresaResult.setText("Empresa");
			jLabelEmpresaResult.setBounds(498, 253, 134, 23);
			jLabelEmpresaResult.setFont(new java.awt.Font("Arial", 0, 16));
		}
		return jLabelEmpresaResult;
	}

	private DefaultComboBoxModel llenaComboPlazos(ArrayList<Date> fechasPago) {

		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		Iterator it = fechasPago.iterator();
		while (it.hasNext()) {
			Date fechaSalida = (Date) it.next();
			// Añadimos la fecha al modelo
			java.sql.Date fechaFormateada = new java.sql.Date(
					fechaSalida.getTime());
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			modelo.addElement(formato.format(fechaSalida));

		}
		return modelo;

	}

	private JButton getJButtonBuscarPrestamo() {
		if (jButtonBuscarPrestamo == null) {
			jButtonBuscarPrestamo = new JButton();
			jButtonBuscarPrestamo.setText("Buscar");
			jButtonBuscarPrestamo.setBounds(457, 29, 146, 23);
			jButtonBuscarPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonBuscarPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonBuscarPrestamoActionPerformed(evt);
				}
			});
		}
		return jButtonBuscarPrestamo;
	}

	private JButton getJButtonActualizarAbonos() {
		if (jButtonActualizarAbonos == null) {
			jButtonActualizarAbonos = new JButton();
			jButtonActualizarAbonos.setText("Actualizar");
			jButtonActualizarAbonos.setBounds(653, 29, 146, 23);
			jButtonActualizarAbonos.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonActualizarAbonos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonActualizarAbonosActionPerformed(evt);
				}
			});
		}
		return jButtonActualizarAbonos;
	}

	private JLabel getJLabelCodigoAbono() {
		if (jLabelCodigoAbono == null) {
			jLabelCodigoAbono = new JLabel();
			jLabelCodigoAbono.setText("Código abono:");
			jLabelCodigoAbono.setBounds(457, 71, 146, 23);
			jLabelCodigoAbono.setFont(new java.awt.Font("Arial", 0, 16));
		}
		return jLabelCodigoAbono;
	}

	private JTextField getJTextFieldCodigoAbono() {
		if (jTextFieldCodigoAbono == null) {
			jTextFieldCodigoAbono = new JTextField();
			jTextFieldCodigoAbono.setBounds(653, 71, 146, 23);
		}
		return jTextFieldCodigoAbono;
	}

	/**
	 * Actualiza la tabla de abonos
	 * 
	 * @param evt
	 */
	private void jButtonActualizarAbonosActionPerformed(ActionEvent evt) {

		actualizaAbonos();

	}

	private void jButtonBuscarPrestamoActionPerformed(ActionEvent evt) {

		actualizaPrestamoBuscado();

	}

	private void jButtonGuardarAbonoActionPerformed(ActionEvent e) {

		AbonoDAO miAbono = new AbonoDAO();
		Date fechaPago = calendarioAbonos.getDate();
		String codigoAbono = jTextFieldCodigoAbono.getText();
		double montoPagado = Double.parseDouble(jTextField1.getText());
		miAbono.pagarAbono(codigoAbono, fechaPago, montoPagado);
		actualizaAbonos();
		actualizaPrestamoBuscado();
		actualizaPrestamos();

	}

	private void jButtonCancelarAbonoActionPerformed(ActionEvent e) {
		System.out.println("Cancelo los abonos");
	}

	private JButton getJButtonAbonosPagados() {
		if (jButtonAbonosPagados == null) {
			jButtonAbonosPagados = new JButton();
			jButtonAbonosPagados.setText("Solo pagados");
			jButtonAbonosPagados.setBounds(457, 161, 146, 22);
			jButtonAbonosPagados.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonAbonosPagados.setSize(146, 23);
			jButtonAbonosPagados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAbonosPagadosActionPerformed(evt);
				}
			});
		}
		return jButtonAbonosPagados;
	}

	private JButton getJButtonAbonosPendientes() {
		if (jButtonAbonosPendientes == null) {
			jButtonAbonosPendientes = new JButton();
			jButtonAbonosPendientes.setText("Solo pendientes");
			jButtonAbonosPendientes.setBounds(653, 161, 146, 22);
			jButtonAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));
			jButtonAbonosPendientes.setSize(146, 23);
			jButtonAbonosPendientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAbonosPendientesActionPerformed(evt);
				}
			});
		}
		return jButtonAbonosPendientes;
	}

	private void jButtonAbonosPagadosActionPerformed(ActionEvent evt) {
		
		actualizaAbonosPagados();
	}

	private void jButtonAbonosPendientesActionPerformed(ActionEvent evt) {
		
		actualizaAbonosPendientes();
	}

	// -----------------Tablas------------------------------------------------------
	private void actualizaAbonos() {

		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonos[][] = miAbono.obtenerMatrizAbonos();
		String titulos[] = miAbono.getColumnas();
		jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
		jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
		jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableAbonosRecibidos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
	}

	private void actualizaAbonosPendientes() {

		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonos[][] = miAbono.obtenerMatrizAbonosPendientes();
		String titulos[] = miAbono.getColumnas();
		jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
		jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
		jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableAbonosRecibidos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
	}

	private void actualizaAbonosPagados() {

		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonos[][] = miAbono.obtenerMatrizAbonosPagados();
		String titulos[] = miAbono.getColumnas();
		jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
		jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
		jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableAbonosRecibidos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
	}

	private void actualizaPrestamos() {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		miPrestamo.actualizaPagos();
		String informacionPrestamos[][] = miPrestamo.obtenerMatrizPrestamos();
		String titulos[] = miPrestamo.getColumnas();
		jTablePrestamos = new JTable(informacionPrestamos, titulos);
		jScrollReportes.setViewportView(jTablePrestamos);
		jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTablePrestamos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
	}

	private void actualizaClientes() {

		ClienteDAO miCliente = new ClienteDAO();
		String informacionClientes[][] = miCliente.obtenerMatrizClientes();
		String titulos[] = miCliente.getColumnas();
		jTableClientes = new JTable(informacionClientes, titulos);
		jScrollPaneClientes.setViewportView(jTableClientes);
		jTableClientes.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableClientes.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
	}

	private void actualizaPrestamoBuscado() {

		AbonoDAO miAbono = new AbonoDAO();
		String abonoPrestamo = jTextCodigoPrestamo.getText();
		String informacionAbonos[][] = miAbono
				.obtenerMatrizAbonosBusqueda(abonoPrestamo);
		if (informacionAbonos != null) {
			String titulos[] = miAbono.getColumnas();
			jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
			jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
			jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader th = jTableAbonosRecibidos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 16));
			System.out.println("Resultados actualizados");
		} else {
			System.out.println("Lista de abonos no encontrada");
		}
	}

}
