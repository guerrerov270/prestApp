package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.SwingUtilities;

import co.prestapp.DAO.AbonoDAO;
import co.prestapp.DAO.ClienteDAO;
import co.prestapp.DAO.MovimientoDAO;
import co.prestapp.DAO.PrestamoDAO;
import co.prestapp.VO.AbonoVO;
import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBBackup;
import co.prestapp.reports.ReporteAbonos;
import co.prestapp.reports.ReporteAbonosPagados;
import co.prestapp.reports.ReporteAbonosPendientes;
import co.prestapp.reports.ReporteClientes;
import co.prestapp.reports.ReporteClientesActivos;
import co.prestapp.reports.ReporteClientesAlfa;
import co.prestapp.reports.ReporteClientesNOActivos;
import co.prestapp.reports.ReporteMovimientos;
import co.prestapp.reports.ReporteMovimientosEntrada;
import co.prestapp.reports.ReporteMovimientosFechas;
import co.prestapp.reports.ReporteMovimientosSalida;
import co.prestapp.reports.ReportePrestamos;
import co.prestapp.reports.ReportePrestamosPagados;
import co.prestapp.reports.ReportePrestamosPendientes;
import co.prestapp.reports.ReportePrestamosVencidos;

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
	private JTabbedPane jTabPestanias;
	private JLabel jLabelMontoPrestamo;
	private JPanel jPanelAgregarAbono;
	private JPanel jPanelAgregarCliente;
	private JTable jTableClientes;
	private JScrollPane jScrollPaneClientes;
	private JButton jButtonCancelarAbono;
	private JButton jButtonAbonoPorFecha;
	private JButton jButtonPrestamoPorFecha;
	private JLabel jLabelAbonosPorFecha;
	private JLabel jLabelPrestadoPorFecha;
	private JTable jTableReportesPorFecha;
	private JScrollPane jScrollPaneReportesPorFecha;
	private JTextField jTextIntersesePendientesRecaudo;
	private JLabel jLabelInteresesPendientesRecaudo;
	private JTextField jTextTotalrecaudoPendiente;
	private JLabel jLabelTotalRecaudoPendiente;
	private JTextField jTextTotalAbonosPendientes;
	private JTextField jTextTotalAbonosCobrados;
	private JLabel jLabelTotalAbonosPendientes;
	private JLabel jLabelTotalAbonosCobrados;
	private JLabel jLabelTotalClientesactivos;
	private JLabel jLabelCerosPrestamo;
	private JTextField jTextTotalSalidas;
	private JTextField jTextTotalentradas;
	private JLabel jLabelTotalSalidas;
	private JLabel jLabelTotalEntradas;
	private JPanel jPanelEstadisticas;
	private JButton jButtonBuscarMovimientos;
	private JLabel jLabelFechaFinMovimiento;
	private JLabel jLabelFechaInicioMovimiento;
	private JPanel jPanelMovimientos;
	private JCheckBox jCheckBoxEditandoAbono;
	private JCheckBox jCheckBoxEdicionCliente;
	private JButton jButtonEditarAbono;
	private JLabel jLabelPesosPrestamo;
	private JLabel jLabelPesosAbono;
	private JLabel jLabelCerosAbono;
	private JButton jButtonBackup;
	private JButton jButtonGenerarPDF;
	private JComboBox<String> jComboSeleccionListado;
	private JLabel jLabelSeleccioneListado;
	private JScrollPane jScrollPaneResultados;
	private JPanel jPanListaResultados;
	private JPanel jPaneSeleccionListado;
	private JPanel jPaneListados;
	private JLabel jLabelCodigoCliente;
	private JButton jButtonEditarCliente;
	private JTextField jTextTotalclientesRegistrados;
	private JTextField jTextTotalClientesactivos;
	private JLabel jLabelTotalclientesRegistrados;
	private JTextField jTextTotalprestamosVencidos;
	private JLabel jLabelTotalPrestamosVencidos;
	private JTextField jTextTotalPrestamosFinalizados;
	private JLabel jLabelTotalPrestamosFinalizados;
	private JTextField jTextTotalPrestamosActivos;
	private JLabel jLabelTotalPrestamosActivos;
	private JTextField jTextInteresesRecaudados;
	private JLabel jLabelInteresesRecaudados;
	private JTextField jTextTotalRecaudado;
	private JTextField jTextTotalPrestado;
	private JLabel jLabelTotalrecibido;
	private JLabel jLabelTotalPrestado;
	private JPanel jPanelCifras;
	private JButton jButtonGuardar;
	private JTextField jTextCodigoPrestamo;
	private JLabel jLabelCodigoPrestamo;
	private JLabel jLabelFecha;
	private JTextField jTextField1;
	private JLabel jLabelMonto;
	private JTable jTableAbonosRecibidos;
	private JScrollPane jScrollAbonosRecibidos;
	private JComboBox<String> jComboFechasCobro;
	public JLabel jLabelCodigo;
	public JLabel jLabelNombreCliente;
	private JButton jButtonClienteExiste;
	private JLabel jLabelTotalFormato;
	private JLabel jLabelTotalPago;
	private JLabel jLabelCliente;
	private JButton jButtonAceptar;
	@SuppressWarnings("rawtypes")
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
	private JDateChooser calendarioPrestamosPorfecha;
	private JDateChooser calendarioAbonosPorFecha;
	private JDateChooser calendarioInicioMovimiento;
	private JDateChooser calendarioFinMovimiento;
	private JLabel jLabelNombre;
	private JTextField jTextEmpresa;
	private JLabel jLabelReferencia;
	private JTextField jTextReferencia;
	private JTextField jTextFieldCodigoAbono;
	private JLabel jLabelCodigoAbono;
	private JButton jButtonBuscarPrestamo;
	private JLabel jLabelEmpresaResult;
	private JButton jButtonCalcular;
	private JButton jButtonCancelar;
	@SuppressWarnings("unused")
	private JButton jButtonCancelarPrestamo;
	private JButton jButtonGuardarCliente;
	private JTextField jTextNombre;
	private JLabel jLabelEmpresa;
	private JTable tablaResultados;
	// Constantes para listados
	private final String seleccioneUno = "Seleccione uno";
	private final String listaClientes = "Listado de clientes registrados";
	private final String listaClientesAlfa = "Listado de clientes alfabéticamente";
	private final String listaClientesActivos = "Listado de clientes activos";
	private final String listaClientesNoActivos = "Listado de clientes no activos";
	private final String listaPrestamos = "Listado de préstamos registrados";
	private final String listaPrestamosPendientes = "Listado de préstamos pendientes";
	private final String listaPrestamosPagados = "Listado de préstamos pagados";
	private final String listaPrestamosVencidos = "Listado de préstamos vencidos";
	private final String listaAbonos = "Listado de abonos registrados";
	private final String listaAbonosPendientes = "Listado de abonos pendientes";
	private final String listaAbonosPagados = "Listado de abonos pagados";
	private final String listaMovimientos = "Listado de movimientos registrados";
	private final String listaMovimientosEntrada = "Listado de movimientos de entrada registrados";
	private final String listaMovimientosSalida = "Listado de movimientos de salida registrados";
	private final String listaMovimientosFechas = "Listado de movimientos entre fechas";

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
		actualizaReportes();
		llenaComboListados();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("PrestApp 1.0");
			this.setFont(new java.awt.Font("Arial", 0, 16));
			this.setResizable(false);
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
				BorderLayout jPanelReportesLayout = new BorderLayout();
				jPanelReportes.setLayout(jPanelReportesLayout);
				jPaneListados = new JPanel();
				BorderLayout jPaneListadosLayout = new BorderLayout();
				jPaneListados.setLayout(jPaneListadosLayout);
				jPanelMovimientos = new JPanel();
				BorderLayout jPanelMovimientosLayout = new BorderLayout();
				jPanelMovimientos.setLayout(jPanelMovimientosLayout);

				getContentPane().add(jPanelContenedor, BorderLayout.CENTER);
				jPanelContenedor.setLayout(jPanelContenedorLayout);
				{
					jTabPestanias = new JTabbedPane();
					jPanelContenedor.add(jTabPestanias, BorderLayout.CENTER);
					jTabPestanias.setBounds(8, 5, 782, 553);

					jTabPestanias.addTab("Préstamos", jPanelPrestamos);
					jPanelPrestamos.setPreferredSize(new java.awt.Dimension(921, 547));
					jPanelPrestamos.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollReportes = new JScrollPane();
						jPanelPrestamos.add(jScrollReportes, BorderLayout.SOUTH);
						jScrollReportes.setBounds(8, 263, 777, 381);
						jScrollReportes.setPreferredSize(new java.awt.Dimension(909, 372));
						{

						}
					}
					{
						jPanelEntradasPrestamo = new JPanel();
						jPanelPrestamos.add(jPanelEntradasPrestamo, BorderLayout.NORTH);
						jPanelEntradasPrestamo.setBorder(BorderFactory.createTitledBorder("Datos préstamo"));
						jPanelEntradasPrestamo.setLayout(null);
						jPanelEntradasPrestamo.setPreferredSize(new java.awt.Dimension(921, 204));
						{
							jLabelMontoPrestamo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelMontoPrestamo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelMontoPrestamo.setText("Monto préstamo:");
							jLabelMontoPrestamo.setBounds(17, 30, 145, 23);
							jLabelMontoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							// MaskFormatter formatoMoneda= new
							// MaskFormatter("$ ###,###");
							jTextMonto = new JFormattedTextField();
							jPanelEntradasPrestamo.add(jTextMonto, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextMonto.setBounds(162, 30, 54, 23);
							jTextMonto.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTasaInteres = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTasaInteres, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelTasaInteres.setText("Tasa interés:");
							jLabelTasaInteres.setBounds(362, 30, 178, 23);
							jLabelTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextTasaInteres = new JTextField();
							jPanelEntradasPrestamo.add(jTextTasaInteres, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextTasaInteres.setBounds(477, 30, 71, 23);
							jTextTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelPocentaje = new JLabel();
							jPanelEntradasPrestamo.add(jLabelPocentaje, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelPocentaje.setText("%");
							jLabelPocentaje.setBounds(547, 31, 64, 23);
							jLabelPocentaje.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelNumeroCuotas = new JLabel();
							jPanelEntradasPrestamo.add(jLabelNumeroCuotas, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelNumeroCuotas.setText("Número cuotas:");
							jLabelNumeroCuotas.setBounds(361, 78, 178, 23);
							jLabelNumeroCuotas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextNumeroCuotas = new JTextField();
							jPanelEntradasPrestamo.add(jTextNumeroCuotas, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextNumeroCuotas.setBounds(476, 78, 71, 23);
							jTextNumeroCuotas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelDiaCobro = new JLabel();
							jPanelEntradasPrestamo.add(jLabelDiaCobro, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelDiaCobro.setText("Días de cobro:");
							jLabelDiaCobro.setBounds(17, 121, 178, 23);
							jLabelDiaCobro.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelFechaInicio = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaInicio, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelFechaInicio.setText("Fecha de inicio:");
							jLabelFechaInicio.setBounds(579, 30, 178, 23);
							jLabelFechaInicio.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTipoPlazo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTipoPlazo, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelTipoPlazo.setText("Tipo de plazo:");
							jLabelTipoPlazo.setBounds(17, 78, 178, 23);
							jLabelTipoPlazo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							ComboBoxModel jComboPlazoModel = new DefaultComboBoxModel(
									new String[] { "Seleccione uno", "Mensual", "Quincenal", "Semanal" });
							jComboPlazo = new JComboBox();
							jPanelEntradasPrestamo.add(jComboPlazo, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jComboPlazo.setModel(jComboPlazoModel);
							jComboPlazo.setBounds(162, 78, 178, 23);
							jComboPlazo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{

							// Test de carga de imagenes dentro del jar
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/guardar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonAceptar = new JButton();
							jButtonAceptar.setIcon(new ImageIcon(otraimg));
							jButtonAceptar.setBounds(9, 157, 130, 30);
							jPanelEntradasPrestamo.add(jButtonAceptar);
							jButtonAceptar.setText("Guardar");
							jButtonAceptar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonAceptar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonAceptarActionPerformed(evt);
								}
							});
							{
								URL urlDeLaImagen1 = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/cancelar.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagen1);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
								JButton jButtonCancelarPrestamo = new JButton();
								jButtonCancelarPrestamo.setIcon(new ImageIcon(otraimg1));
								jPanelEntradasPrestamo.add(jButtonCancelarPrestamo);
								jButtonCancelarPrestamo.setText("Cancelar");
								jButtonCancelarPrestamo.setBounds(145, 157, 145, 30);
								jButtonCancelarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonCancelarPrestamo.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonCancelarPrestamoActionPerformed(evt);
									}
								});

							}
							{
								jLabelCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCliente);
								jLabelCliente.setText("Cliente:");
								jLabelCliente.setBounds(591, 121, 132, 23);
								jLabelCliente.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelTotalPago = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalPago);
								jLabelTotalPago.setText("Total a pagar:  $");
								jLabelTotalPago.setBounds(362, 121, 116, 23);
								jLabelTotalPago.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelTotalFormato = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalFormato);
								jLabelTotalFormato.setBounds(478, 122, 178, 23);
								jLabelTotalFormato.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								URL urlDeLaImagen2 = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/buscar.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagen2);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
								jButtonClienteExiste = new JButton();
								jButtonClienteExiste.setIcon(new ImageIcon(otraimg1));
								jPanelEntradasPrestamo.add(jButtonClienteExiste);
								jButtonClienteExiste.setText("Cliente");
								jButtonClienteExiste.setBounds(726, 78, 130, 30);
								jButtonClienteExiste.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonClienteExiste.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonClienteExisteActionPerformed(evt);
									}
								});
							}
							{
								calendarioPrestamos = new JDateChooser();
								calendarioPrestamos.setLocale(new Locale("ES", "CO"));
								calendarioPrestamos.setDateFormatString("dd/MM/yyyy");
								jPanelEntradasPrestamo.add(calendarioPrestamos);
								calendarioPrestamos.setBounds(712, 30, 178, 23);
								calendarioPrestamos.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelNombreCliente = new JLabel();
								jPanelEntradasPrestamo.add(jLabelNombreCliente);
								jLabelNombreCliente.setText("Nombre");
								jLabelNombreCliente.setBounds(726, 121, 173, 23);
								jLabelNombreCliente.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelCodigo = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCodigo);
								jLabelCodigo.setText("Código");
								jLabelCodigo.setBounds(593, 161, 121, 23);
								jLabelCodigo.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{

								jComboFechasCobro = new JComboBox();
								jPanelEntradasPrestamo.add(jComboFechasCobro);
								DefaultComboBoxModel modelo = new DefaultComboBoxModel();
								modelo.addElement("Nada para mostrar");
								jComboFechasCobro.setModel(modelo);
								jComboFechasCobro.setBounds(162, 121, 178, 23);
								jComboFechasCobro.setFont(new java.awt.Font("Arial", 0, 14));
							}
							{
								URL urlDeLaImagenCalcular = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/calcular.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagenCalcular);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
								jButtonCalcular = new JButton();
								jPanelEntradasPrestamo.add(jButtonCalcular);
								jButtonCalcular.setIcon(new ImageIcon(otraimg1));
								jButtonCalcular.setText("Calcular");
								jButtonCalcular.setBounds(579, 78, 130, 30);
								jButtonCalcular.setFont(new java.awt.Font("Arial", 0, 14));
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
							{
								jLabelEmpresaResult = new JLabel();
								jPanelEntradasPrestamo.add(jLabelEmpresaResult);
								jLabelEmpresaResult.setText("Empresa");
								jLabelEmpresaResult.setBounds(726, 161, 168, 23);
								jLabelEmpresaResult.setFont(new java.awt.Font("Arial", 0, 16));

							}
							{
								jLabelCerosPrestamo = new JLabel();
								jPanelEntradasPrestamo.add(jLabelCerosPrestamo);
								jLabelCerosPrestamo.setText(".000");
								jLabelCerosPrestamo.setBounds(216, 33, 55, 16);
								jLabelCerosPrestamo.setFont(new java.awt.Font("Arial", 0, 18));
							}
							{
								jLabelPesosPrestamo = new JLabel();
								jPanelEntradasPrestamo.add(jLabelPesosPrestamo);
								jLabelPesosPrestamo.setText("$");
								jLabelPesosPrestamo.setBounds(149, 33, 19, 16);
								jLabelPesosPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
							}

						}
					}
					jTabPestanias.addTab("Abonos", jPanelAbonos);
					jPanelAbonos.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollAbonosRecibidos = new JScrollPane();
						jPanelAbonos.add(jScrollAbonosRecibidos, BorderLayout.SOUTH);
						jScrollAbonosRecibidos.setBounds(8, 263, 777, 381);
						jScrollAbonosRecibidos.setPreferredSize(new java.awt.Dimension(909, 373));
						{

						}
					}
					{
						jPanelAgregarAbono = new JPanel();
						jPanelAbonos.add(jPanelAgregarAbono, BorderLayout.NORTH);
						jPanelAgregarAbono.setPreferredSize(new java.awt.Dimension(911, 204));
						jPanelAgregarAbono.setBorder(BorderFactory.createTitledBorder("Agregar abono"));
						jPanelAgregarAbono.setLayout(null);
						{
							jLabelMonto = new JLabel();
							jPanelAgregarAbono.add(jLabelMonto);
							jLabelMonto.setText("Monto a abonar:");
							jLabelMonto.setBounds(592, 76, 146, 23);
							jLabelMonto.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextField1 = new JTextField();
							jPanelAgregarAbono.add(jTextField1);
							jTextField1.setBounds(730, 76, 80, 23);
							jTextField1.setFont(new java.awt.Font("Arial", 0, 16));
							jTextField1.setSize(54, 23);
						}
						{
							jLabelFecha = new JLabel();
							jPanelAgregarAbono.add(jLabelFecha);
							jLabelFecha.setText("Fecha:");
							jLabelFecha.setBounds(17, 78, 178, 23);
							jLabelFecha.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							calendarioAbonos = new JDateChooser();
							jPanelAgregarAbono.add(calendarioAbonos);
							calendarioAbonos.setBounds(162, 78, 178, 23);
							calendarioAbonos.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelCodigoPrestamo = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoPrestamo);
							jLabelCodigoPrestamo.setText("Código préstamo:");
							jLabelCodigoPrestamo.setBounds(17, 30, 178, 23);
							jLabelCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextCodigoPrestamo = new JTextField();
							jPanelAgregarAbono.add(jTextCodigoPrestamo);
							jTextCodigoPrestamo.setBounds(162, 30, 178, 23);
							jTextCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/guardar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonGuardar = new JButton();
							jButtonGuardar.setIcon(new ImageIcon(otraimg));
							jPanelAgregarAbono.add(jButtonGuardar);
							jButtonGuardar.setText("Guardar");
							jButtonGuardar.setBounds(17, 147, 130, 30);
							jButtonGuardar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonGuardar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarAbonoActionPerformed(evt);
								}
							});
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/cancelar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonCancelarAbono = new JButton();
							jPanelAgregarAbono.add(jButtonCancelarAbono);
							jButtonCancelarAbono.setIcon(new ImageIcon(otraimg));
							jButtonCancelarAbono.setText("Cancelar");
							jButtonCancelarAbono.setBounds(351, 147, 145, 30);
							jButtonCancelarAbono.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonCancelarAbono.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									jButtonCancelarAbonoActionPerformed(e);

								}
							});

						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/buscar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonBuscarPrestamo = new JButton();
							jPanelAgregarAbono.add(jButtonBuscarPrestamo);
							jButtonBuscarPrestamo.setIcon(new ImageIcon(otraimg));
							jButtonBuscarPrestamo.setText("Buscar");
							jButtonBuscarPrestamo.setBounds(376, 25, 130, 30);
							jButtonBuscarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonBuscarPrestamo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonBuscarPrestamoActionPerformed(evt);
								}
							});

						}
						{
							jLabelCodigoAbono = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoAbono);
							jLabelCodigoAbono.setText("Código abono:");
							jLabelCodigoAbono.setBounds(381, 78, 178, 23);
							jLabelCodigoAbono.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							jTextFieldCodigoAbono = new JTextField();
							jPanelAgregarAbono.add(jTextFieldCodigoAbono);
							jTextFieldCodigoAbono.setBounds(496, 78, 71, 23);

						}
						{
							jLabelCerosAbono = new JLabel();
							jPanelAgregarAbono.add(jLabelCerosAbono);
							jLabelCerosAbono.setText(".000");
							jLabelCerosAbono.setBounds(784, 79, 48, 16);
							jLabelCerosAbono.setFont(new java.awt.Font("Arial", 0, 18));
						}
						{
							jLabelPesosAbono = new JLabel();
							jPanelAgregarAbono.add(jLabelPesosAbono);
							jLabelPesosAbono.setText("$");
							jLabelPesosAbono.setBounds(717, 79, 18, 16);
							jLabelPesosAbono.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/editar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonEditarAbono = new JButton();
							jButtonEditarAbono.setIcon(new ImageIcon(otraimg));
							jPanelAgregarAbono.add(jButtonEditarAbono);
							jButtonEditarAbono.setText("Editar");
							jButtonEditarAbono.setBounds(185, 146, 130, 30);
							jButtonEditarAbono.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonEditarAbono.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonEditarAbonoActionPerformed(evt);
								}
							});
						}
						{
							jCheckBoxEditandoAbono = new JCheckBox();
							jPanelAgregarAbono.add(jCheckBoxEditandoAbono);
							jCheckBoxEditandoAbono.setText("Editando");
							jCheckBoxEditandoAbono.setBounds(778, 170, 126, 20);
							jCheckBoxEditandoAbono.setFont(new java.awt.Font("Arial", 0, 16));
						}
					}
					jTabPestanias.addTab("Clientes", jPanelClientes);
					jPanelClientes.setBorder(BorderFactory.createTitledBorder("Datos de clientes"));
					jPanelClientes.setPreferredSize(new java.awt.Dimension(767, 526));
					jPanelClientes.setFont(new java.awt.Font("Arial", 0, 16));
					{

						jScrollPaneClientes = new JScrollPane();
						jPanelClientes.add(jScrollPaneClientes, BorderLayout.SOUTH);
						jScrollPaneClientes.setBounds(8, 263, 777, 381);
						jScrollPaneClientes.setPreferredSize(new java.awt.Dimension(899, 419));
						{

						}
					}
					{
						jPanelAgregarCliente = new JPanel();
						jPanelClientes.add(jPanelAgregarCliente, BorderLayout.NORTH);
						jPanelAgregarCliente.setPreferredSize(new java.awt.Dimension(899, 132));
						jPanelAgregarCliente.setLayout(null);
						{
							jLabelNombre = new JLabel();
							jPanelAgregarCliente.add(jLabelNombre);
							jLabelNombre.setText("Nombre:");
							jLabelNombre.setBounds(12, 19, 178, 23);
							jLabelNombre.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							jLabelEmpresa = new JLabel();
							jPanelAgregarCliente.add(jLabelEmpresa);
							jLabelEmpresa.setText("Empresa:");
							jLabelEmpresa.setBounds(312, 19, 178, 23);
							jLabelEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextNombre = new JTextField();
							jPanelAgregarCliente.add(jTextNombre);
							jTextNombre.setBounds(100, 19, 178, 23);
							jTextNombre.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextEmpresa = new JTextField();
							jPanelAgregarCliente.add(jTextEmpresa);
							jTextEmpresa.setBounds(403, 19, 178, 23);
							jTextEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							ImageIcon icono = new ImageIcon("src/co/prestapp/res/guardar.png");
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonGuardarCliente = new JButton();
							jButtonGuardarCliente.setIcon(new ImageIcon(otraimg));
							jPanelAgregarCliente.add(jButtonGuardarCliente);
							jButtonGuardarCliente.setText("Guardar");
							jButtonGuardarCliente.setBounds(12, 90, 130, 30);
							jButtonGuardarCliente.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonGuardarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarClienteActionPerformed(evt);
								}
							});
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/cancelar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonCancelar = new JButton();
							jButtonCancelar.setIcon(new ImageIcon(otraimg));
							jPanelAgregarCliente.add(jButtonCancelar);
							jButtonCancelar.setText("Cancelar");
							jButtonCancelar.setBounds(386, 90, 130, 30);
							jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 14));
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
							jLabelReferencia.setBounds(606, 19, 178, 23);
							jLabelReferencia.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextReferencia = new JTextField();
							jPanelAgregarCliente.add(jTextReferencia);
							jTextReferencia.setBounds(708, 19, 178, 23);
							jTextReferencia.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/editar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagen);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonEditarCliente = new JButton();
							jPanelAgregarCliente.add(jButtonEditarCliente);
							jButtonEditarCliente.setIcon(new ImageIcon(otraimg1));
							jButtonEditarCliente.setText("Editar");
							jButtonEditarCliente.setBounds(198, 90, 130, 30);
							jButtonEditarCliente.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonEditarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonEditarClienteActionPerformed(evt);
								}
							});

						}
						{
							jLabelCodigoCliente = new JLabel();
							jPanelAgregarCliente.add(jLabelCodigoCliente);
							jLabelCodigoCliente.setBounds(12, 65, 65, 10);

						}
						{
							jCheckBoxEdicionCliente = new JCheckBox();
							jPanelAgregarCliente.add(jCheckBoxEdicionCliente);
							jCheckBoxEdicionCliente.setText("Editando");
							jCheckBoxEdicionCliente.setBounds(778, 103, 115, 20);
							jCheckBoxEdicionCliente.setFont(new java.awt.Font("Arial", 0, 16));
						}
					}
					// Aquí listados
					jTabPestanias.addTab("Listados", jPaneListados);
					jPaneListados.setFont(new java.awt.Font("Arial", 0, 16));
					{
						// Panel superior
						jPaneSeleccionListado = new JPanel();
						jPaneListados.add(jPaneSeleccionListado, BorderLayout.NORTH);
						jPaneSeleccionListado.setPreferredSize(new java.awt.Dimension(909, 99));
						jPaneSeleccionListado.setBorder(BorderFactory.createTitledBorder("Listados"));
						jPaneSeleccionListado.setLayout(null);
						{
							jButtonBuscarMovimientos = new JButton();
							jPaneSeleccionListado.add(jButtonBuscarMovimientos);
							jButtonBuscarMovimientos.setText("Buscar");
							jButtonBuscarMovimientos.setBounds(665, 60, 229, 30);
							jButtonBuscarMovimientos.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonBuscarMovimientos.setEnabled(false);
							jButtonBuscarMovimientos.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonBuscarMovimientosActionPerformed(evt);
								}
							});
						}
						{
							calendarioFinMovimiento = new JDateChooser();
							jPaneSeleccionListado.add(calendarioFinMovimiento);
							calendarioFinMovimiento.setLocale(new Locale("ES", "CO"));
							calendarioFinMovimiento.setDateFormatString("dd/MM/yyyy");
							calendarioFinMovimiento.setBounds(483, 60, 170, 30);
							calendarioFinMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
							calendarioFinMovimiento.setEnabled(false);
						}
						{
							jLabelFechaFinMovimiento = new JLabel();
							jPaneSeleccionListado.add(jLabelFechaFinMovimiento);
							jLabelFechaFinMovimiento.setText("Fecha fin:");
							jLabelFechaFinMovimiento.setBounds(355, 60, 132, 30);
							jLabelFechaFinMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelFechaInicioMovimiento = new JLabel();
							jPaneSeleccionListado.add(jLabelFechaInicioMovimiento);
							jLabelFechaInicioMovimiento.setText("Fecha inicio:");
							jLabelFechaInicioMovimiento.setBounds(12, 60, 143, 30);
							jLabelFechaInicioMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							calendarioInicioMovimiento = new JDateChooser();
							jPaneSeleccionListado.add(calendarioInicioMovimiento);
							calendarioInicioMovimiento.setLocale(new Locale("ES", "CO"));
							calendarioInicioMovimiento.setDateFormatString("dd/MM/yyyy");
							calendarioInicioMovimiento.setBounds(155, 60, 178, 30);
							calendarioInicioMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
							calendarioInicioMovimiento.setEnabled(false);

						}
						{
							// Componentes del panel superior
							jLabelSeleccioneListado = new JLabel();
							jPaneSeleccionListado.add(jLabelSeleccioneListado);
							jLabelSeleccioneListado.setText("Seleccione listado:");
							jLabelSeleccioneListado.setBounds(12, 19, 172, 25);
							jLabelSeleccioneListado.setFont(new java.awt.Font("Arial", 0, 16));

							jComboSeleccionListado = new JComboBox();
							jPaneSeleccionListado.add(jComboSeleccionListado);
							jComboSeleccionListado.setBounds(155, 20, 316, 23);
							jComboSeleccionListado.setFont(new java.awt.Font("Arial", 0, 16));
							jComboSeleccionListado.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jComboSeleccionListadoActionPerformed(evt);
								}
							});

							URL urlDeLaImagenpdf = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/pdf.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagenpdf);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonGenerarPDF = new JButton();
							jButtonGenerarPDF.setIcon(new ImageIcon(otraimg1));
							jPaneSeleccionListado.add(jButtonGenerarPDF);

							jButtonGenerarPDF.setText("Generar PDF");
							jButtonGenerarPDF.setBounds(483, 14, 170, 30);
							jButtonGenerarPDF.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonGenerarPDF.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGenerarPDFActionPerformed(evt);
								}
							});

							URL urlDeLaImagenBackup = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/backup.png");
							ImageIcon iconoBackup = new ImageIcon(urlDeLaImagenBackup);
							Image imgBackup = iconoBackup.getImage();
							Image otraimgBackup = imgBackup.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonBackup = new JButton();
							jButtonBackup.setIcon(new ImageIcon(otraimgBackup));
							jPaneSeleccionListado.add(jButtonBackup);
							jButtonBackup.setText("Copia de seguridad");
							jButtonBackup.setBounds(664, 14, 229, 30);
							jButtonBackup.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonBackup.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGenerarBackupActionPerformed(evt);
								}
							});

						}
					}
					{
						// Panel inferior
						jPanListaResultados = new JPanel();
						BorderLayout jPanListaResultadosLayout = new BorderLayout();
						jPanListaResultados.setLayout(jPanListaResultadosLayout);
						jPaneListados.add(jPanListaResultados, BorderLayout.CENTER);
						jPanListaResultados.setPreferredSize(new java.awt.Dimension(909, 400));
						jPanListaResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
						{
							// Componentes del panel inferior
							jScrollPaneResultados = new JScrollPane();
							jPanListaResultados.add(jScrollPaneResultados, BorderLayout.CENTER);
						}
					}
					{
						jPanelEstadisticas = new JPanel();
						GridLayout jPanelEstadisticasLayout = new GridLayout(1, 1);
						jPanelEstadisticasLayout.setHgap(5);
						jPanelEstadisticasLayout.setVgap(5);
						jPanelEstadisticasLayout.setColumns(1);
						jPaneListados.add(jPanelEstadisticas, BorderLayout.SOUTH);
						jPanelEstadisticas.setLayout(jPanelEstadisticasLayout);
						jPanelEstadisticas.setPreferredSize(new java.awt.Dimension(909, 66));
						jPanelEstadisticas.setBorder(BorderFactory.createTitledBorder("Estadísticas"));
						{
							jLabelTotalEntradas = new JLabel();
							jPanelEstadisticas.add(jLabelTotalEntradas);
							jLabelTotalEntradas.setText("Total entradas:");
							jLabelTotalEntradas.setBounds(11, 27, 189, 30);
							jLabelTotalEntradas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextTotalentradas = new JTextField();
							jPanelEstadisticas.add(jTextTotalentradas);
							jTextTotalentradas.setEditable(false);
							jTextTotalentradas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTotalSalidas = new JLabel();
							jPanelEstadisticas.add(jLabelTotalSalidas);
							jLabelTotalSalidas.setText("Total salidas:");
							jLabelTotalSalidas.setBounds(448, 26, 189, 30);
							jLabelTotalSalidas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextTotalSalidas = new JTextField();
							jPanelEstadisticas.add(jTextTotalSalidas);
							jTextTotalSalidas.setEditable(false);
							jTextTotalSalidas.setFont(new java.awt.Font("Arial", 0, 16));
						}

					}

					jTabPestanias.addTab("Reportes", jPanelReportes);
					jPanelReportes.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollPaneReportesPorFecha = new JScrollPane();
						jPanelReportes.add(jScrollPaneReportesPorFecha, BorderLayout.SOUTH);
						jScrollPaneReportesPorFecha.setBounds(82, 316, 740, 197);
						jScrollPaneReportesPorFecha.setPreferredSize(new java.awt.Dimension(909, 243));
					}
					{
						// Aquí el panel de cifras
						jPanelCifras = new JPanel();
						jPanelReportes.add(jPanelCifras, BorderLayout.NORTH);
						jPanelCifras.setLayout(null);
						jPanelCifras.setBorder(BorderFactory.createTitledBorder("Cifras"));
						jPanelCifras.setPreferredSize(new java.awt.Dimension(905, 335));
						{
							// Componentes del panel de cifras
							jLabelTotalPrestado = new JLabel();
							jPanelCifras.add(jLabelTotalPrestado);
							jLabelTotalPrestado.setText("Total prestado:");
							jLabelTotalPrestado.setBounds(17, 30, 211, 23);
							jLabelTotalPrestado.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalrecibido = new JLabel();
							jPanelCifras.add(jLabelTotalrecibido);
							jLabelTotalrecibido.setText("Total recaudado:");
							jLabelTotalrecibido.setBounds(17, 117, 211, 23);
							jLabelTotalrecibido.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestado = new JTextField();
							jPanelCifras.add(jTextTotalPrestado);
							jTextTotalPrestado.setBounds(226, 30, 178, 23);
							jTextTotalPrestado.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestado.setEditable(false);

							jTextTotalRecaudado = new JTextField();
							jPanelCifras.add(jTextTotalRecaudado);
							jTextTotalRecaudado.setBounds(226, 117, 178, 23);
							jTextTotalRecaudado.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalRecaudado.setEditable(false);

							jLabelInteresesRecaudados = new JLabel();
							jPanelCifras.add(jLabelInteresesRecaudados);
							jLabelInteresesRecaudados.setText("Intereses recaudados:");
							jLabelInteresesRecaudados.setBounds(17, 160, 210, 23);
							jLabelInteresesRecaudados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextInteresesRecaudados = new JTextField();
							jPanelCifras.add(jTextInteresesRecaudados);
							jTextInteresesRecaudados.setBounds(226, 160, 178, 23);
							jTextInteresesRecaudados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextInteresesRecaudados.setEditable(false);

							jLabelTotalPrestamosActivos = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosActivos);
							jLabelTotalPrestamosActivos.setText("Total préstamos activos:");
							jLabelTotalPrestamosActivos.setBounds(17, 247, 210, 23);
							jLabelTotalPrestamosActivos.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestamosActivos = new JTextField();
							jPanelCifras.add(jTextTotalPrestamosActivos);
							jTextTotalPrestamosActivos.setBounds(226, 247, 178, 23);
							jTextTotalPrestamosActivos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestamosActivos.setEditable(false);

							jLabelTotalPrestamosFinalizados = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosFinalizados);
							jLabelTotalPrestamosFinalizados.setText("Total préstamos finalizados:");
							jLabelTotalPrestamosFinalizados.setBounds(448, 30, 209, 23);
							jLabelTotalPrestamosFinalizados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestamosFinalizados = new JTextField();
							jPanelCifras.add(jTextTotalPrestamosFinalizados);
							jTextTotalPrestamosFinalizados.setBounds(710, 30, 178, 23);
							jTextTotalPrestamosFinalizados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestamosFinalizados.setEditable(false);

							jLabelTotalPrestamosVencidos = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosVencidos);
							jLabelTotalPrestamosVencidos.setText("Total préstamos vencidos:");
							jLabelTotalPrestamosVencidos.setBounds(448, 73, 212, 23);
							jLabelTotalPrestamosVencidos.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalprestamosVencidos = new JTextField();
							jPanelCifras.add(jTextTotalprestamosVencidos);
							jTextTotalprestamosVencidos.setBounds(710, 73, 178, 23);
							jTextTotalprestamosVencidos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalprestamosVencidos.setEditable(false);

							jLabelTotalclientesRegistrados = new JLabel();
							jPanelCifras.add(jLabelTotalclientesRegistrados);
							jLabelTotalclientesRegistrados.setText("Total clientes registrados:");
							jLabelTotalclientesRegistrados.setBounds(448, 204, 178, 23);
							jLabelTotalclientesRegistrados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalClientesactivos = new JTextField();
							jPanelCifras.add(jTextTotalClientesactivos);
							jTextTotalClientesactivos.setBounds(710, 247, 178, 23);
							jTextTotalClientesactivos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalClientesactivos.setEditable(false);

							jTextTotalclientesRegistrados = new JTextField();
							jPanelCifras.add(jTextTotalclientesRegistrados);
							jTextTotalclientesRegistrados.setBounds(710, 204, 178, 23);
							jTextTotalclientesRegistrados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalclientesRegistrados.setEditable(false);

							jLabelTotalClientesactivos = new JLabel();
							jPanelCifras.add(jLabelTotalClientesactivos);
							jLabelTotalClientesactivos.setText("Total clientes activos:");
							jLabelTotalClientesactivos.setBounds(448, 247, 178, 23);
							jLabelTotalClientesactivos.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalAbonosCobrados = new JLabel();
							jPanelCifras.add(jLabelTotalAbonosCobrados);
							jLabelTotalAbonosCobrados.setText("Total abonos cobrados:");
							jLabelTotalAbonosCobrados.setBounds(448, 117, 178, 23);
							jLabelTotalAbonosCobrados.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalAbonosPendientes = new JLabel();
							jPanelCifras.add(jLabelTotalAbonosPendientes);
							jLabelTotalAbonosPendientes.setText("Total abonos pendientes:");
							jLabelTotalAbonosPendientes.setBounds(448, 160, 178, 23);
							jLabelTotalAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalAbonosCobrados = new JTextField();
							jPanelCifras.add(jTextTotalAbonosCobrados);
							jTextTotalAbonosCobrados.setBounds(710, 117, 178, 23);
							jTextTotalAbonosCobrados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalAbonosCobrados.setEditable(false);

							jTextTotalAbonosPendientes = new JTextField();
							jPanelCifras.add(jTextTotalAbonosPendientes);
							jTextTotalAbonosPendientes.setBounds(710, 160, 178, 23);
							jTextTotalAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalAbonosPendientes.setEditable(false);

							jLabelTotalRecaudoPendiente = new JLabel();
							jPanelCifras.add(jLabelTotalRecaudoPendiente);
							jLabelTotalRecaudoPendiente.setText("Total recaudo pendiente:");
							jLabelTotalRecaudoPendiente.setBounds(17, 73, 178, 23);
							jLabelTotalRecaudoPendiente.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalrecaudoPendiente = new JTextField();
							jPanelCifras.add(jTextTotalrecaudoPendiente);
							jTextTotalrecaudoPendiente.setBounds(226, 73, 178, 23);
							jTextTotalrecaudoPendiente.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalrecaudoPendiente.setEditable(false);

							jLabelInteresesPendientesRecaudo = new JLabel();
							jPanelCifras.add(jLabelInteresesPendientesRecaudo);
							jLabelInteresesPendientesRecaudo.setText("Interses a recaudar");
							jLabelInteresesPendientesRecaudo.setBounds(17, 204, 178, 23);
							jLabelInteresesPendientesRecaudo.setFont(new java.awt.Font("Arial", 0, 16));

							jTextIntersesePendientesRecaudo = new JTextField();
							jPanelCifras.add(jTextIntersesePendientesRecaudo);
							jTextIntersesePendientesRecaudo.setBounds(226, 204, 178, 23);
							jTextIntersesePendientesRecaudo.setFont(new java.awt.Font("Arial", 0, 16));
							jTextIntersesePendientesRecaudo.setEditable(false);

							jLabelPrestadoPorFecha = new JLabel();
							jPanelCifras.add(jLabelPrestadoPorFecha);
							jLabelPrestadoPorFecha.setText("Préstamos por fecha:");
							jLabelPrestadoPorFecha.setBounds(17, 291, 209, 23);
							jLabelPrestadoPorFecha.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelAbonosPorFecha = new JLabel();
							jPanelCifras.add(jLabelAbonosPorFecha);
							jLabelAbonosPorFecha.setText("Abonos pagados por fecha:");
							jLabelAbonosPorFecha.setBounds(448, 291, 249, 23);
							jLabelAbonosPorFecha.setFont(new java.awt.Font("Arial", 0, 16));

							URL urlDeLaImagenBuscar = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/buscar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagenBuscar);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonPrestamoPorFecha = new JButton();
							jPanelCifras.add(jButtonPrestamoPorFecha);
							jButtonPrestamoPorFecha.setIcon(new ImageIcon(otraimg1));
							jButtonPrestamoPorFecha.setBounds(357, 282, 49, 38);
							jButtonPrestamoPorFecha.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonPrestamoPorFechaActionPerformed(evt);
								}
							});

							jButtonAbonoPorFecha = new JButton();
							jPanelCifras.add(jButtonAbonoPorFecha);
							jButtonAbonoPorFecha.setIcon(new ImageIcon(otraimg1));
							// jButtonAbonoPorFecha.setText("Buscar");
							jButtonAbonoPorFecha.setBounds(844, 281, 49, 38);
							jButtonAbonoPorFecha.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonAbonoPorFechaActionPerformed(evt);
								}
							});

							calendarioPrestamosPorfecha = new JDateChooser();
							calendarioPrestamosPorfecha.setLocale(new Locale("ES", "CO"));
							calendarioPrestamosPorfecha.setDateFormatString("dd/MM/yyyy");
							jPanelCifras.add(calendarioPrestamosPorfecha);
							calendarioPrestamosPorfecha.setBounds(225, 291, 132, 23);
							calendarioPrestamosPorfecha.setFont(new java.awt.Font("Arial", 0, 16));

							calendarioAbonosPorFecha = new JDateChooser();
							calendarioAbonosPorFecha.setLocale(new Locale("ES", "CO"));
							calendarioAbonosPorFecha.setDateFormatString("dd/MM/yyyy");
							jPanelCifras.add(calendarioAbonosPorFecha);
							calendarioAbonosPorFecha.setBounds(712, 291, 132, 23);
							calendarioAbonosPorFecha.setFont(new java.awt.Font("Arial", 0, 16));
						}
					}

				}
			}
			pack();
			this.setSize(920, 640);

		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}// Fin initGUI-------------------------------------------------------

	private void jButtonClienteExisteActionPerformed(ActionEvent evt) {

		try {

			String codigoCliente = JOptionPane.showInputDialog("Ingrese código del cliente");
			// Busco el código en la bd y lo adjunto al prestamo
			ClienteDAO miCliente = new ClienteDAO();
			ClienteVO cliente = miCliente.buscarCliente(codigoCliente);

			if (cliente.getCodigoCliente() == null) {
				JOptionPane.showMessageDialog(this, "Verifique el código del cliente", "Cliente no encontrado",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Cambio valores de etiquetas en la vista
				jLabelNombreCliente.setText(cliente.getNombreCliente());
				jLabelCodigo.setForeground(Color.RED);
				jLabelCodigo.setText(cliente.getCodigoCliente() + "");
				jLabelEmpresaResult.setText(cliente.getEmpresaCliente());
			}

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

		if (jCheckBoxEdicionCliente.isSelected()) {
			ClienteDAO miCliente = new ClienteDAO();

			String codigoCliente = jLabelCodigoCliente.getText();
			String nombre = jTextNombre.getText();
			String empresa = jTextEmpresa.getText();
			String referencia = jTextReferencia.getText();
			miCliente.editarCliente(codigoCliente, nombre, empresa, referencia);
			JOptionPane.showMessageDialog(this, "Cliente editado con éxito", "Edición exitosa",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposCliente();
			jCheckBoxEdicionCliente.setSelected(false);
			actualizaClientes();
			return;
		}
		if (validarCamposCliente()) {
			String nombre = jTextNombre.getText();
			String empresa = jTextEmpresa.getText();
			String referencia = jTextReferencia.getText();
			ClienteDAO miCliente = new ClienteDAO();
			miCliente.agregarCliente(nombre, empresa, referencia);
			JOptionPane.showMessageDialog(this, "Cliente guardado con éxito", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposCliente();
			actualizaClientes();
			actualizaReportes();

		}

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

	private void limpiarCamposCliente() {

		jTextNombre.setText("");
		jTextEmpresa.setText("");
		jTextReferencia.setText("");

	}

	private void limpiarCamposPrestamo() {

		jTextMonto.setText("");
		jTextTasaInteres.setText("");
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		modelo.addElement("Nada para mostrar");
		jComboFechasCobro.setModel(modelo);
		jTextNumeroCuotas.setText("");
		jLabelTotalFormato.setText("");
		jComboPlazo.setSelectedIndex(0);
		jLabelNombreCliente.setText("Nombre");
		jLabelCodigo.setText("Código");
		jLabelEmpresaResult.setText("Empresa");
		calendarioPrestamos.setDate(null);

	}

	private void limpiarCamposAbono() {

		jTextFieldCodigoAbono.setText("");
		jTextField1.setText("");
		calendarioAbonos.setDate(null);

	}

	@SuppressWarnings("unchecked")
	private void jButtonCalcularActionPerformed(ActionEvent evt) throws Exception {

		float montoPrestamo = 0;
		int tasaInteres = 0;
		String tipoPlazo = "";
		int numeroCuotas = 0;
		Date fechaInicio = null;
		PrestamoDAO miPrestamo = null;

		if (validarCamposCalcular()) {

			try {
				montoPrestamo = Float.parseFloat(jTextMonto.getText()) * 1000;
				tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
				tipoPlazo = (String) jComboPlazo.getSelectedItem();
				numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
				fechaInicio = calendarioPrestamos.getDate();
				miPrestamo = new PrestamoDAO();

				ArrayList<Date> fechasPago = miPrestamo.calcularFechasPago(tipoPlazo, numeroCuotas, fechaInicio);
				@SuppressWarnings("rawtypes")
				DefaultComboBoxModel modeloNuevo = new DefaultComboBoxModel();
				modeloNuevo = llenaComboPlazos(fechasPago);
				jComboFechasCobro.setModel(modeloNuevo);

				double totalPagar = miPrestamo.calcularPrestamo(montoPrestamo, tasaInteres, tipoPlazo, numeroCuotas);
				jLabelTotalFormato.setText(totalPagar + "");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} // Fin if

	}// Fin método jButtonCalcularActionPerformed

	// Suma los días recibidos a la fecha
	public Date sumarRestarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a aniadir, o
													// restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días aniadidos

	}

	/**
	 * Guarda los préstamos
	 * 
	 * @param evt
	 */
	private void jButtonAceptarActionPerformed(ActionEvent evt) {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		AbonoDAO miAbono = new AbonoDAO();
		MovimientoDAO miMovimiento = new MovimientoDAO();
		float montoPrestamo = 0;
		int tasaInteres = 0;
		int numeroCuotas = 0;
		String tipoPlazo = "";
		String tipoPlazoMayus = "";
		double totalPagar = 0;
		double totalPagado = 0;
		Date fechaInicio = null;
		int tamanioArray = 0;
		// La ultima fecha del arreglo
		Date fechaFin = null;
		String codigoCliente = "";
		ArrayList<Date> fechasPago = new ArrayList<Date>();

		if (validarCamposPrestamo()) {
			// Recojo los datos necesarios
			try {
				montoPrestamo = Float.parseFloat(jTextMonto.getText()) * 1000;
				tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
				numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			tipoPlazo = (String) jComboPlazo.getSelectedItem();
			tipoPlazoMayus = tipoPlazo.toUpperCase();

			// El saldo pendiente
			totalPagar = miPrestamo.calcularPrestamo(montoPrestamo, tasaInteres, tipoPlazo, numeroCuotas);
			// El saldo pagado
			totalPagado = 0;
			fechaInicio = calendarioPrestamos.getDate();
			// Fecha de fin
			fechasPago = miPrestamo.calcularFechasPago(tipoPlazo, numeroCuotas, fechaInicio);
			try {
				tamanioArray = fechasPago.size();
				fechaFin = fechasPago.get(tamanioArray - 1);
				// Busco el cliente de nuevo
				codigoCliente = JOptionPane.showInputDialog("Verifique código del cliente");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} // Fin de if de validar campos

		// Busco el código en la bd y lo adjunto al prestamo
		ClienteDAO miCliente = new ClienteDAO();
		ClienteVO cliente = miCliente.buscarCliente(codigoCliente);
		if (cliente.getCodigoCliente() == null) {
			JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
		} else {
			// Cambio valores de etiquetas en la vista
			jLabelNombreCliente.setText(cliente.getNombreCliente());
			jLabelCodigo.setForeground(Color.RED);
			jLabelCodigo.setText(cliente.getCodigoCliente() + "");
			jLabelEmpresaResult.setText(cliente.getEmpresaCliente());

			// El estado del prestamo
			String estadoPrestamo = "PENDIENTE";

			// Agrego el prestamo
			String codigoPrestamo = miPrestamo.agregarPrestamo(montoPrestamo, tasaInteres, numeroCuotas, totalPagar,
					totalPagado, fechaInicio, fechaFin, tipoPlazoMayus, codigoCliente, estadoPrestamo);

			// Creo los abonos correspondientes a ese préstamo
			miAbono.crearAbonosPrestamo(totalPagar, numeroCuotas, fechasPago, codigoPrestamo);

			// Registro el movimiento
			miMovimiento.agregarMovimiento(codigoPrestamo, fechaInicio, 0, montoPrestamo);

			JOptionPane.showMessageDialog(this, "El préstamo se ha creado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposPrestamo();
			actualizaPrestamos();
			actualizaReportes();
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DefaultComboBoxModel llenaComboPlazos(ArrayList<Date> fechasPago) {

		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		Iterator it = fechasPago.iterator();
		while (it.hasNext()) {
			Date fechaSalida = (Date) it.next();
			// Aniadimos la fecha al modelo
			@SuppressWarnings("unused")
			java.sql.Date fechaFormateada = new java.sql.Date(fechaSalida.getTime());
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			modelo.addElement(formato.format(fechaSalida));

		}
		return modelo;

	}

	private void jButtonBuscarPrestamoActionPerformed(ActionEvent evt) {

		if (jTextCodigoPrestamo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe especificar un código de préstamo", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			actualizaPrestamoBuscado();
		}

	}

	private void jButtonGuardarAbonoActionPerformed(ActionEvent e) {

		AbonoDAO miAbono = new AbonoDAO();
		AbonoVO miAbonoVO = new AbonoVO();
		MovimientoDAO miMovimiento = new MovimientoDAO();
		Date fechaPago = null;
		String codigoAbono = "";
		double montoPagado = 0;

		if (jCheckBoxEditandoAbono.isSelected()) {
			fechaPago = calendarioAbonos.getDate();
			codigoAbono = jTextFieldCodigoAbono.getText();
			montoPagado = Double.parseDouble(jTextField1.getText()) * 1000;
			miAbono.editarAbonoPagado(codigoAbono, fechaPago, montoPagado);
			// Edito el movimiento para actualizar cifras
			miMovimiento.editarMovimiento(codigoAbono, fechaPago, montoPagado, 0);
			JOptionPane.showMessageDialog(this, "Abono editado con éxito", "Edición exitosa",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposAbono();
			jCheckBoxEditandoAbono.setSelected(false);
			actualizaAbonos();
			return;
		}

		if (validarCamposAbonoPrestamo()) {
			fechaPago = calendarioAbonos.getDate();
			codigoAbono = jTextFieldCodigoAbono.getText();
			montoPagado = Double.parseDouble(jTextField1.getText()) * 1000;
			miAbonoVO = miAbono.buscarAbono(codigoAbono);
			if (miAbonoVO == null || !(miAbono.verificarAbonoPendiente(codigoAbono))) {
				JOptionPane.showMessageDialog(this, "No se ha podido encontrar el abono o ya está pagado",
						"Verifique el código del abono", JOptionPane.WARNING_MESSAGE);
			} else {
				miAbono.pagarAbono(codigoAbono, fechaPago, montoPagado);

				// Registro el movimiento
				miMovimiento.agregarMovimiento(codigoAbono, fechaPago, montoPagado, 0);
				actualizaAbonos();
				actualizaPrestamos();
				actualizaAbonosPagados();
				actualizaReportes();
				JOptionPane.showMessageDialog(this, "Abono guardado correctamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarCamposAbono();
			}

		} else {
			JOptionPane.showMessageDialog(this, "No se ha podido guardar el abono", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void jButtonCancelarAbonoActionPerformed(ActionEvent e) {
		limpiarCamposAbono();
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
		ajustaColumnasAContenido(jTableAbonosRecibidos);
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
		ajustaColumnasAContenido(jTableAbonosRecibidos);
	}

	private void actualizaPrestamosPorFecha() {

		Date fechaSeleccionada = calendarioPrestamosPorfecha.getDate();
		PrestamoDAO miPrestamo = new PrestamoDAO();
		String informacionPrestamosPorFecha[][] = miPrestamo.obtenerMatrizPrestamosPorFecha(fechaSeleccionada);
		String titulos[] = miPrestamo.getColumnas();
		jTableReportesPorFecha = new JTable(informacionPrestamosPorFecha, titulos);
		jScrollPaneReportesPorFecha.setViewportView(jTableReportesPorFecha);
		jTableReportesPorFecha.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableReportesPorFecha.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
		ajustaColumnasAContenido(jTableReportesPorFecha);
	}

	private void actualizaAbonosPorFecha() {

		Date fechaSeleccionada = calendarioAbonosPorFecha.getDate();
		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonosPorFecha[][] = miAbono.obtenerMatrizAbonosPorFecha(fechaSeleccionada);
		String titulos[] = miAbono.getColumnas();
		jTableReportesPorFecha = new JTable(informacionAbonosPorFecha, titulos);
		jScrollPaneReportesPorFecha.setViewportView(jTableReportesPorFecha);
		jTableReportesPorFecha.setFont(new java.awt.Font("Arial", 0, 16));
		JTableHeader th = jTableReportesPorFecha.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 16));
		ajustaColumnasAContenido(jTableReportesPorFecha);
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
		ajustaColumnasAContenido(jTablePrestamos);
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
		ajustaColumnasAContenido(jTableClientes);

	}

	private void actualizaPrestamoBuscado() {

		AbonoDAO miAbono = new AbonoDAO();
		String abonoPrestamo = jTextCodigoPrestamo.getText();
		String informacionAbonos[][] = miAbono.obtenerMatrizAbonosBusqueda(abonoPrestamo);
		if (informacionAbonos != null) {
			String titulos[] = miAbono.getColumnas();
			jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
			jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
			jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader th = jTableAbonosRecibidos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(jTableAbonosRecibidos);

		} else {
			System.out.println("Lista de abonos no encontrada");
			JOptionPane.showMessageDialog(this, "Préstamo no encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void actualizaReportes() {

		ClienteDAO miCliente = new ClienteDAO();
		AbonoDAO miAbono = new AbonoDAO();
		PrestamoDAO miPrestamo = new PrestamoDAO();

		String totalPrestado = "";
		String totalRecaudado = "";
		String interesesRecaudados = "";
		String intersesARecaudar = "";
		String totalRecaudoPendiente = "";
		int totalPrestamosActivos = 0;
		int totalPrestamosFinalizados = 0;
		int totalPrestamosVencidos = 0;

		int totalAbonosCobrados = 0;
		int totalAbonosPendientes = 0;

		int totalClientesRegistrados = 0;
		int totalClientesActivos = 0;
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		try {

			totalAbonosCobrados = miAbono.contarAbonosCobrados();
			totalAbonosPendientes = miAbono.contarAbonosPendientes();
			jTextTotalAbonosCobrados.setText(totalAbonosCobrados + "");
			jTextTotalAbonosPendientes.setText(totalAbonosPendientes + "");

			totalClientesRegistrados = miCliente.contarClientesRegistrados();
			totalClientesActivos = miCliente.contarClientesActivos();
			jTextTotalclientesRegistrados.setText(totalClientesRegistrados + "");
			jTextTotalClientesactivos.setText(totalClientesActivos + "");

			totalPrestado = formatoMoneda.format(miPrestamo.calcularTotalPrestado());
			totalRecaudado = formatoMoneda.format(miPrestamo.calcularTotalRecaudado());
			interesesRecaudados = formatoMoneda.format(miPrestamo.calcularInteresesPendientesRecaudo());
			intersesARecaudar = formatoMoneda.format(miPrestamo.calcularInteresesRecaudados());
			totalRecaudoPendiente = formatoMoneda.format(miPrestamo.calcularRecaudoPendiente());
			jTextTotalPrestado.setText(totalPrestado);
			jTextTotalRecaudado.setText(totalRecaudado + "");
			jTextInteresesRecaudados.setText(interesesRecaudados + "");
			jTextTotalrecaudoPendiente.setText(totalRecaudoPendiente + "");
			jTextIntersesePendientesRecaudo.setText(intersesARecaudar + "");

			totalPrestamosActivos = miPrestamo.contarPrestamosActivos();
			totalPrestamosFinalizados = miPrestamo.contarPrestamosFinalizados();
			totalPrestamosVencidos = miPrestamo.contarPrestamosVencidos();

			jTextTotalPrestamosActivos.setText(totalPrestamosActivos + "");
			jTextTotalPrestamosFinalizados.setText(totalPrestamosFinalizados + "");
			jTextTotalprestamosVencidos.setText(totalPrestamosVencidos + "");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void ajustaColumnasAContenido(JTable tabla) {

		TableColumnModel modeloColumnas = tabla.getColumnModel();
		for (int col = 0; col < tabla.getColumnCount(); col++) {
			int maxwidth = 0;
			for (int row = 0; row < tabla.getRowCount(); row++) {
				TableCellRenderer rend = tabla.getCellRenderer(row, col);
				Object value = tabla.getValueAt(row, col);
				Component comp = rend.getTableCellRendererComponent(tabla, value, false, false, row, col);
				maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
			} // row
			TableColumn columna = modeloColumnas.getColumn(col);
			columna.setPreferredWidth(maxwidth);
		} // col
		tabla.setRowHeight(30);

	}// Fin ajustaColumnasAContenido

	/**
	 * Valida que no queden vacios los campos de monto, tasa, numero de cuotas, tipo
	 * de plazo y fecha de inicio
	 * 
	 * @return true si están llenos los campos
	 */
	public boolean validarCamposPrestamo() {

		boolean resultado = false;

		if (jTextMonto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe especificar un monto para el préstamo", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (jTextTasaInteres.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe especificar una tasa de interés para el préstamo", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (jComboPlazo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(this, "Debe especificar un tipo de plazo para el préstamo", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (calendarioPrestamos.getDate() == null) {
						JOptionPane.showMessageDialog(this, "Debe especificar una fecha de inicio para el préstamo",
								"Alerta", JOptionPane.WARNING_MESSAGE);
					} else {
						if (jTextNumeroCuotas.getText().isEmpty()) {
							JOptionPane.showMessageDialog(this, "Debe especificar un número de cuotas para el préstamo",
									"Alerta", JOptionPane.WARNING_MESSAGE);
						} else {

							// Busco el código en la bd y lo adjunto al prestamo
							ClienteDAO miCliente = new ClienteDAO();
							ClienteVO cliente = miCliente
									.buscarCliente(JOptionPane.showInputDialog("Ingrese el código del cliente"));
							if (cliente == null) {
								JOptionPane.showMessageDialog(this, "Debe especificar un código de cliente válido",
										"Alerta", JOptionPane.WARNING_MESSAGE);
							} else {
								resultado = true;
							}

						}
					}
				}
			}

		}

		return resultado;

	}// Fin validarCamposPrestamo

	public boolean validarCamposCalcular() {

		boolean resultado = false;

		if (jTextMonto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe especificar un monto para el préstamo", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (jTextTasaInteres.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe especificar una tasa de interés para el préstamo", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (jComboPlazo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(this, "Debe especificar un tipo de plazo para el préstamo", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (calendarioPrestamos.getDate() == null) {
						JOptionPane.showMessageDialog(this, "Debe especificar una fecha de inicio para el préstamo",
								"Alerta", JOptionPane.WARNING_MESSAGE);
					} else {
						if (jTextNumeroCuotas.getText().isEmpty()) {
							JOptionPane.showMessageDialog(this, "Debe especificar un número de cuotas para el préstamo",
									"Alerta", JOptionPane.WARNING_MESSAGE);
						} else {

							resultado = true;

						}
					}
				}
			}

		}

		return resultado;

	}// Fin validarCamposCalcular

	public boolean validarCamposCliente() {

		boolean resultado = false;

		if (jTextNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe especificar un nombre para el cliente", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			resultado = true;
		}

		return resultado;
	}// Fin validarCamposPrestamo

	public boolean validarCamposAbonoPrestamo() {

		boolean resultado = false;
		if (calendarioAbonos.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha para el abono", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (jTextFieldCodigoAbono.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe especificar el código del abono a pagar", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (jTextField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Debe especificar el monto del abono a pagar", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					resultado = true;
				}
			}
		}
		return resultado;

	}// Fin validarCamposPrestamo

	private void jButtonPrestamoPorFechaActionPerformed(ActionEvent evt) {

		Date fechaIngresada = calendarioPrestamosPorfecha.getDate();
		if (fechaIngresada != null) {
			actualizaPrestamosPorFecha();
			calendarioPrestamosPorfecha.setDate(null);
		} else {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha para la búsqueda", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void jButtonAbonoPorFechaActionPerformed(ActionEvent evt) {

		Date fechaIngresada = calendarioAbonosPorFecha.getDate();
		if (fechaIngresada != null) {
			actualizaAbonosPorFecha();
			calendarioAbonosPorFecha.setDate(null);
		} else {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha para la búsqueda", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void llenaComboListados() {

		ComboBoxModel<String> jComboListadosModel = new DefaultComboBoxModel<String>(
				new String[] { seleccioneUno, listaClientes, listaClientesAlfa, listaClientesActivos,
						listaClientesNoActivos, listaPrestamos, listaPrestamosPendientes, listaPrestamosPagados,
						listaPrestamosVencidos, listaAbonos, listaAbonosPendientes, listaAbonosPagados,
						listaMovimientos, listaMovimientosEntrada, listaMovimientosSalida, listaMovimientosFechas });
		jComboSeleccionListado.setModel(jComboListadosModel);

	}

	private void generarBackup() {

		// configuracion de la fecha actual
		Calendar c = Calendar.getInstance();
		String fecha = String.valueOf(c.get(Calendar.DATE));
		fecha = fecha + "-" + String.valueOf(c.get(Calendar.MONTH) + 1);
		fecha = fecha + "-" + String.valueOf(c.get(Calendar.YEAR));
		fecha = fecha + "." + String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		fecha = fecha + "." + String.valueOf(c.get(Calendar.MINUTE));
		fecha = fecha + "." + String.valueOf(c.get(Calendar.SECOND));

		DBBackup backup = new DBBackup();
		boolean resultado = backup.CrearBackup("localhost", "3306", "root", "root", "test",
				"C:\\PrestApp\\backup" + "_" + fecha + ".sql");
		if (resultado) {
			JOptionPane.showMessageDialog(this, "Copia de seguridad generada con éxito", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"La copia de seguridad no pudo ser generada, contacte al administrador del sistema", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void generarReporteClientes() {
		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteClientes" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de clientes registrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteClientes ejemplo = new ReporteClientes(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();
	}

	private void generarReporteClientesAlfa() {
		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteClientesAlfa" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de clientes registrados ordenados alfabéticamente, generado el: " + diaS + "/"
				+ mesS + "/" + anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteClientesAlfa ejemplo = new ReporteClientesAlfa(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();
	}

	private void generarReporteClientesActivos() {
		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteClientesActivos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de clientes activos registrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteClientesActivos ejemplo = new ReporteClientesActivos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();
	}

	private void generarReporteClientesNOActivos() {
		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteClientesNOActivos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de clientes no activos registrados, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteClientesNOActivos ejemplo = new ReporteClientesNOActivos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();
	}

	public String concatenaCero(int parametro) {
		String resultado = "";
		if (parametro < 10) {
			resultado = "0" + parametro + "";
		} else {
			resultado = parametro + "";
		}
		return resultado;
	}

	private void generarReportePrestamos() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReportePrestamos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de préstamos registrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReportePrestamos ejemplo = new ReportePrestamos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReportePrestamosPendientes() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReportePrestamosPendientes" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de préstamos pendientes registrados, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReportePrestamosPendientes ejemplo = new ReportePrestamosPendientes(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReportePrestamosPagados() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReportePrestamosPagados" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de préstamos pagados registrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReportePrestamosPagados ejemplo = new ReportePrestamosPagados(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReportePrestamosVencidos() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReportePrestamosVencidos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de préstamos vencidos registrados, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReportePrestamosVencidos ejemplo = new ReportePrestamosVencidos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReporteAbonos() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteAbonos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de abonos registrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteAbonos ejemplo = new ReporteAbonos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReporteAbonosPendientes() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteAbonosPendientes" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de abonos pendientes, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteAbonosPendientes ejemplo = new ReporteAbonosPendientes(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReporteAbonosPagados() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteAbonosPagados" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de abonos pagados, generado el: " + diaS + "/" + mesS + "/" + anio + "  a las "
				+ " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteAbonosPagados reporte = new ReporteAbonosPagados(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			reporte.abrirPDF();

	}

	private void generarReporteMovimientos() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteMovimientos" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de movimientos resgistrados, generado el: " + diaS + "/" + mesS + "/" + anio
				+ "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteMovimientos reporte = new ReporteMovimientos(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			reporte.abrirPDF();
	}

	private void generarReporteMovimientosEntrada() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteMovimientosEntrada" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de movimientos de entrada resgistrados, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteMovimientosEntrada reporte = new ReporteMovimientosEntrada(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			reporte.abrirPDF();
	}

	private void generarReporteMovimientosSalida() {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteMovimientosSalida" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de movimientos de salida resgistrados, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteMovimientosSalida reporte = new ReporteMovimientosSalida(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			reporte.abrirPDF();
	}

	private void generarReporteMovimientosFechas(java.sql.Date fechaInicio, java.sql.Date fechaFin) {

		// configuracion de la fecha actual
		// Creamos un objeto de la clase Calendar.
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
		// Usando el método get y el parámetro correspondiente.
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String mesS = concatenaCero(mes + 1);
		String diaS = concatenaCero(dia);
		String horaS = concatenaCero(hora);
		String minutoS = concatenaCero(minuto);
		String segundoS = concatenaCero(segundo);

		String strNombrePDF = "ReporteMovimientosFechas" + diaS + mesS + anio + horaS + minutoS + segundoS + ".pdf";
		String strTituloPDF = "Reporte de movimientos resgistrados por fecha, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteMovimientosFechas reporte = new ReporteMovimientosFechas(strTituloPDF, strNombrePDF, fechaInicio,
				fechaFin);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			reporte.abrirPDF();
	}

	private void jButtonEditarClienteActionPerformed(ActionEvent evt) {

		ClienteVO clienteEncontrado = null;
		String codigoCliente = JOptionPane.showInputDialog("Ingrese código del cliente");
		ClienteDAO miCliente = new ClienteDAO();
		clienteEncontrado = miCliente.buscarCliente(codigoCliente);

		if (clienteEncontrado.getCodigoCliente() != null) {
			jTextNombre.setText(clienteEncontrado.getNombreCliente());
			jTextEmpresa.setText(clienteEncontrado.getEmpresaCliente());
			jTextReferencia.setText(clienteEncontrado.getReferenciaCliente());
			jLabelCodigoCliente.setText(clienteEncontrado.getCodigoCliente());
			jLabelCodigoCliente.setVisible(false);
			jCheckBoxEdicionCliente.setSelected(true);
		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del cliente", "Cliente no encontrado",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	private void jButtonEditarAbonoActionPerformed(ActionEvent evt) {

		String codigoAbono = JOptionPane.showInputDialog("Ingrese código del abono");
		AbonoVO abonoEncontrado = null;
		AbonoDAO miAbono = new AbonoDAO();
		SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		abonoEncontrado = miAbono.buscarAbono(codigoAbono);

		if (abonoEncontrado.getCodigoAbono() != null) {
			jTextFieldCodigoAbono.setText(abonoEncontrado.getCodigoAbono());
			Date fechaFormateada;
			try {
				fechaFormateada = formato.parse(abonoEncontrado.getFechaPago());
				calendarioAbonos.setDate(fechaFormateada);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			int monto;
			try {
				monto = formatoMoneda.parse(abonoEncontrado.getMontoPagado()).intValue();
				jTextField1.setText((monto / 1000) + "");
			} catch (ParseException e) {

				e.printStackTrace();
			}

			jCheckBoxEditandoAbono.setSelected(true);
		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del abono", "Abono no encontrado",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	private void jButtonGenerarBackupActionPerformed(ActionEvent evt) {
		generarBackup();

	}

	private void jButtonGenerarPDFActionPerformed(ActionEvent evt) {

		String listaSeleccionada = (String) jComboSeleccionListado.getSelectedItem();

		switch (listaSeleccionada) {
		case seleccioneUno:
			JOptionPane.showMessageDialog(this, "Debe seleccionar una lista", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case listaClientes:
			generarReporteClientes();
			break;
		case listaClientesAlfa:
			generarReporteClientesAlfa();
			break;
		case listaClientesActivos:
			generarReporteClientesActivos();
			break;
		case listaClientesNoActivos:
			generarReporteClientesNOActivos();
			break;
		case listaPrestamos:
			generarReportePrestamos();
			break;
		case listaPrestamosPendientes:
			generarReportePrestamosPendientes();
			break;
		case listaPrestamosPagados:
			generarReportePrestamosPagados();
			break;
		case listaPrestamosVencidos:
			generarReportePrestamosVencidos();
			break;
		case listaAbonos:
			generarReporteAbonos();
			break;
		case listaAbonosPendientes:
			generarReporteAbonosPendientes();
			break;
		case listaAbonosPagados:
			generarReporteAbonosPagados();
			break;
		case listaMovimientos:
			generarReporteMovimientos();
			break;
		case listaMovimientosEntrada:
			generarReporteMovimientosEntrada();
			break;
		case listaMovimientosSalida:
			generarReporteMovimientosSalida();
			break;
		case listaMovimientosFechas:
			java.sql.Date fechaInicioFormateada = new java.sql.Date(calendarioInicioMovimiento.getDate().getTime());
			java.sql.Date fechaFinFormateada = new java.sql.Date(calendarioFinMovimiento.getDate().getTime());
			generarReporteMovimientosFechas(fechaInicioFormateada, fechaFinFormateada);
			calendarioInicioMovimiento.setDate(null);
			calendarioFinMovimiento.setDate(null);
			break;
		}

	}

	private void jComboSeleccionListadoActionPerformed(ActionEvent evt) {

		String listaSeleccionada = (String) jComboSeleccionListado.getSelectedItem();

		AbonoDAO miAbono = new AbonoDAO();
		String titulosAbono[] = miAbono.getColumnas();
		ClienteDAO miCliente = new ClienteDAO();
		String titulosCliente[] = miCliente.getColumnas();
		PrestamoDAO miPrestamo = new PrestamoDAO();
		String titulosPrestamo[] = miPrestamo.getColumnas();
		MovimientoDAO miMovimiento = new MovimientoDAO();
		String titulosMovimiento[] = miMovimiento.getColumnas();

		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		switch (listaSeleccionada) {
		case seleccioneUno:
			tablaResultados = new JTable();
			jScrollPaneResultados.setViewportView(tablaResultados);
			break;
		case listaClientes:
			miCliente = new ClienteDAO();
			String informacionClientes[][] = miCliente.obtenerMatrizClientes();
			tablaResultados = new JTable(informacionClientes, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thClientes = tablaResultados.getTableHeader();
			thClientes.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesAlfa:
			miCliente = new ClienteDAO();
			String informacionClientesAlfa[][] = miCliente.obtenerMatrizClientesAlfa();
			tablaResultados = new JTable(informacionClientesAlfa, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thClientesAlfa = tablaResultados.getTableHeader();
			thClientesAlfa.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesActivos:
			miCliente = new ClienteDAO();
			String informacionClientesActivos[][] = miCliente.obtenerMatrizClientesActivos();
			tablaResultados = new JTable(informacionClientesActivos, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thClientesActivos = tablaResultados.getTableHeader();
			thClientesActivos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesNoActivos:
			miCliente = new ClienteDAO();
			String informacionClientesNOActivos[][] = miCliente.obtenerMatrizClientesNOActivos();
			tablaResultados = new JTable(informacionClientesNOActivos, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thClientesNOActivos = tablaResultados.getTableHeader();
			thClientesNOActivos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamos:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamos[][] = miPrestamo.obtenerMatrizPrestamos();
			tablaResultados = new JTable(informacionPrestamos, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thPrestamos = tablaResultados.getTableHeader();
			thPrestamos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosPendientes:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamosPendientes[][] = miPrestamo.obtenerMatrizPrestamosPendientes();
			tablaResultados = new JTable(informacionPrestamosPendientes, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thPrestamosPendientes = tablaResultados.getTableHeader();
			thPrestamosPendientes.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosPagados:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamosPagados[][] = miPrestamo.obtenerMatrizPrestamosPagados();
			tablaResultados = new JTable(informacionPrestamosPagados, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thPrestamosPagados = tablaResultados.getTableHeader();
			thPrestamosPagados.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosVencidos:
			miPrestamo = new PrestamoDAO();
			String informacionPrestamosVencidos[][] = miPrestamo.obtenerMatrizPrestamosVencidos();
			if (informacionPrestamosVencidos != null) {
				tablaResultados = new JTable(informacionPrestamosVencidos, titulosPrestamo);
				jScrollPaneResultados.setViewportView(tablaResultados);
				tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
				JTableHeader thPrestamosVencidos = tablaResultados.getTableHeader();
				thPrestamosVencidos.setFont(new java.awt.Font("Arial", 0, 16));
				ajustaColumnasAContenido(tablaResultados);

			} else {
				JOptionPane.showMessageDialog(this, "Préstamos no encontrados", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case listaAbonos:
			miAbono = new AbonoDAO();
			String informacionAbonos[][] = miAbono.obtenerMatrizAbonos();
			tablaResultados = new JTable(informacionAbonos, titulosAbono);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thAbonos = tablaResultados.getTableHeader();
			thAbonos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaAbonosPendientes:
			miAbono = new AbonoDAO();
			String informacionAbonosPendientes[][] = miAbono.obtenerMatrizAbonosPendientes();
			tablaResultados = new JTable(informacionAbonosPendientes, titulosAbono);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader thAbonosPen = tablaResultados.getTableHeader();
			thAbonosPen.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaAbonosPagados:
			miAbono = new AbonoDAO();
			String informacionAbonosPagados[][] = miAbono.obtenerMatrizAbonosPagados();
			tablaResultados = new JTable(informacionAbonosPagados, titulosAbono);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thAbonosPag = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			thAbonosPag.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaMovimientos:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientos[][] = miMovimiento.obtenerMatrizMovimientos();
			tablaResultados = new JTable(informacionMovimientos, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientos = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			thMovimientos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas()) + "");
			jTextTotalSalidas.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas()) + "");

			break;
		case listaMovimientosEntrada:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientosEntrada[][] = miMovimiento.obtenerMatrizMovimientosEntrada();
			tablaResultados = new JTable(informacionMovimientosEntrada, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientosEntrada = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			thMovimientosEntrada.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas()) + "");
			jTextTotalSalidas.setText("");
			break;
		case listaMovimientosSalida:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientosSalida[][] = miMovimiento.obtenerMatrizMovimientosSalida();
			tablaResultados = new JTable(informacionMovimientosSalida, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientosSalida = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			thMovimientosSalida.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText("");
			jTextTotalSalidas.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas()) + "");
			break;
		case listaMovimientosFechas:
			calendarioInicioMovimiento.setEnabled(true);
			calendarioFinMovimiento.setEnabled(true);
			jButtonBuscarMovimientos.setEnabled(true);
			jTextTotalentradas.setText("");
			jTextTotalSalidas.setText("");
			break;

		}

	}

	private void jButtonBuscarMovimientosActionPerformed(ActionEvent evt) {

		MovimientoDAO miMovimiento = new MovimientoDAO();
		String titulosMovimiento[] = miMovimiento.getColumnas();
		Date fechaInicio = calendarioInicioMovimiento.getDate();
		Date fechaFin = calendarioFinMovimiento.getDate();
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		if (fechaInicio != null && fechaFin != null) {

			miMovimiento = new MovimientoDAO();
			String informacionMovimientosFechas[][] = miMovimiento.obtenerMatrizMovimientosFechas(fechaInicio,
					fechaFin);
			tablaResultados = new JTable(informacionMovimientosFechas, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientos = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 16));
			thMovimientos.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas
					.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas(fechaInicio, fechaFin)) + "");
			jTextTotalSalidas
					.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas(fechaInicio, fechaFin)) + "");
			calendarioInicioMovimiento.setEnabled(false);
			calendarioFinMovimiento.setEnabled(false);
			jButtonBuscarMovimientos.setEnabled(false);

		} else {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha de inicio y una final", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
