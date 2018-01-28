package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import co.prestapp.VO.PrestamoVO;
import co.prestapp.connection.DBBackup;
import co.prestapp.connection.DBError;
import co.prestapp.reports.ReporteAbonos;
import co.prestapp.reports.ReporteAbonosPagados;
import co.prestapp.reports.ReporteAbonosPendientes;
import co.prestapp.reports.ReporteClientes;
import co.prestapp.reports.ReporteClientesActivos;
import co.prestapp.reports.ReporteClientesAlfa;
import co.prestapp.reports.ReporteClientesNOActivos;
import co.prestapp.reports.ReporteMovimientosEntrada;
import co.prestapp.reports.ReporteMovimientosFechas;
import co.prestapp.reports.ReporteMovimientosSalida;
import co.prestapp.reports.ReportePrestamosCatEmpresa;

import com.toedter.calendar.JDateChooser;
import info.clearthought.layout.TableLayout;

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
	private JButton jButtonVerTodosAbono;
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
	private JButton jButton1;
	private JLabel jLabel1;
	private JButton jButtonEliminarPrestamo;
	private JComboBox<String> jComboBoxCategoriaEmpresa;
	private JLabel jLabelCategoríaEmpresa;
	private JLabel jLabelComplemento;
	private JLabel jLabelComplemento3;
	private JLabel jLabelComplemento4;
	private JLabel jLabelComplemento6;
	private JCheckBox jCheckBoxEditandoPrestamo;
	private JLabel jLabelCodigoPrestamoOculto;
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
	private JButton jButtonEditarPrestamo;
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
	private JButton jButtonAceptar;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboPlazo;
	private JLabel jLabelTipoPlazo;
	private JLabel jLabelDiaCobro;
	private JLabel jLabelFechaInicio;
	private JTextField jTextNumeroCuotas;
	private JLabel jLabelNumeroCuotas;
	private JTextField jTextTasaInteres;
	private JLabel jLabelTasaInteres;
	private JFormattedTextField jTextMonto;
	private JPanel jPanelEntradasPrestamo;
	private JTable jTablePrestamos;
	private JScrollPane jScrollReportes;
	private JDateChooser calendarioPrestamos;
	private JDateChooser calendarioFinPrestamo;
	private JDateChooser calendarioAbonos;
	private JDateChooser calendarioAbonosCobro;
	private JDateChooser calendarioPrestamosPorfecha;
	private JDateChooser calendarioAbonosPorFecha;
	private JDateChooser calendarioInicioMovimiento;
	private JDateChooser calendarioFinMovimiento;
	private JLabel jLabelNombre;
	@SuppressWarnings("rawtypes")
	private JComboBox jTextEmpresa;
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

	// Nuevos
	// private final String listaClientesEmpresa = "Listado de clientes por
	// empresa/categoria";
	private final String listaPrestamosEmpresa = "Listado de préstamos por empresa/categoria";
	// private final String listaPrestamosPlazo = "Listado de préstamos por tipo de
	// plazo";
	private final String listaPrestamosCliente = "Listado de préstamos de un cliente";
	// private final String listaAbonosCliente = "Listado de abonos por cliente";

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
	// SIN CATEGORIA, SEMANAL, IMPULSO, SUPERMERCADO, COMUN, VENDEDORES, DON POLLO,
	// DROGUERIA, LA LOCURA, MR POMPY, COMUNICACIONES, MOCAWA, HOGAR INFANTIL, OTRO
	private final String seleccioneUna = "Seleccione una";
	private final String SinCategoria = "SIN CATEGORIA";
	private final String Semanal = "SEMANAL";
	private final String Impulso = "IMPULSO";
	private final String Supermercados = "SUPERMERCADOS";
	private final String Comun = "COMÚN";
	private final String Vendedores = "VENDEDORES";
	private final String DonPollo = "DON POLLO";
	private final String Drogueria = "DROGUERIA";
	private final String LaLocura = "LA LOCURA";
	private final String MrPompy = "MR POMPY";
	private final String Comunicaciones = "COMUNICACIONES";
	private final String Mocawa = "MOCAWA";
	private final String Hogarinfantil = "HOGAR INFANTIL";
	private final String Otro = "OTRO";

	private DBError error = new DBError();

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
		actualizaTodo();
		llenaComboListados();
		llenaComboCategoriaEmpresa();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("PrestApp 1.0");
			this.setFont(new java.awt.Font("Arial", 0, 16));
			this.setResizable(false);
			this.setFocusable(true);
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
					jTabPestanias.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jTabPestaniasMouseClicked(evt);
						}
					});

					jTabPestanias.addTab("Préstamos", jPanelPrestamos);
					jPanelPrestamos.setPreferredSize(new java.awt.Dimension(921, 547));
					jPanelPrestamos.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollReportes = new JScrollPane();
						jPanelPrestamos.add(jScrollReportes, BorderLayout.SOUTH);
						jScrollReportes.setBounds(8, 263, 777, 381);
						jScrollReportes.setPreferredSize(new java.awt.Dimension(1057, 455));
						{

						}
					}
					{
						jPanelEntradasPrestamo = new JPanel();
						TableLayout jPanelEntradasPrestamoLayout = new TableLayout(
								new double[][] { { 10, 200, 98, 98, 195, 195, 200, 10 }, { 30, 30, 30, 30, 30, 30 } });
						jPanelEntradasPrestamoLayout.setHGap(5);
						jPanelEntradasPrestamoLayout.setVGap(5);
						jPanelPrestamos.add(jPanelEntradasPrestamo, BorderLayout.NORTH);
						jPanelEntradasPrestamo.setBorder(BorderFactory.createTitledBorder("Datos préstamo"));
						jPanelEntradasPrestamo.setLayout(jPanelEntradasPrestamoLayout);
						jPanelEntradasPrestamo.setPreferredSize(new java.awt.Dimension(1057, 232));
						{
							jLabelMontoPrestamo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelMontoPrestamo, "1,0,f,f");
							jLabelMontoPrestamo.setText("Monto préstamo:            $");
							jLabelMontoPrestamo.setBounds(17, 30, 145, 30);
							jLabelMontoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							// MaskFormatter formatoMoneda= new
							// MaskFormatter("$ ###,###");
							jTextMonto = new JFormattedTextField();
							jPanelEntradasPrestamo.add(jTextMonto, "2, 0");
							jTextMonto.setBounds(162, 30, 54, 30);
							jTextMonto.setFont(new java.awt.Font("Arial", 0, 16));
							jTextMonto.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent e) {
									char caracter = e.getKeyChar();

									// Verificar si la tecla pulsada no es un digito
									if (((caracter < '0') || (caracter > '9'))
											&& (caracter != '\b' /* corresponde a BACK_SPACE */)) {
										e.consume(); // ignorar el evento de teclado
									}
								}
							});
						}
						{
							URL urlDeLaImagen2 = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/buscar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagen2);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonClienteExiste = new JButton();
							jButtonClienteExiste.setIcon(new ImageIcon(otraimg1));
							jPanelEntradasPrestamo.add(jButtonClienteExiste, "6, 0");
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
							jLabelTasaInteres = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTasaInteres, "1,1,f,f");
							jLabelTasaInteres.setText("Tasa interés:                  %");
							jLabelTasaInteres.setBounds(362, 30, 178, 30);
							jLabelTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextTasaInteres = new JTextField();
							jPanelEntradasPrestamo.add(jTextTasaInteres, "2, 1, 3, 1");
							jTextTasaInteres.setBounds(477, 30, 71, 30);
							jTextTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTasaInteres.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent e) {
									char caracter = e.getKeyChar();

									// Verificar si la tecla pulsada no es un digito
									if (((caracter < '0') || (caracter > '9'))
											&& (caracter != '\b' /* corresponde a BACK_SPACE */)) {
										e.consume(); // ignorar el evento de teclado
									}
								}
							});
						}

						{
							jLabelNumeroCuotas = new JLabel();
							jPanelEntradasPrestamo.add(jLabelNumeroCuotas, "1,2,f,f");
							jLabelNumeroCuotas.setText("Número cuotas:");
							jLabelNumeroCuotas.setBounds(361, 78, 178, 30);
							jLabelNumeroCuotas.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextNumeroCuotas = new JTextField();
							jPanelEntradasPrestamo.add(jTextNumeroCuotas, "2, 2, 3, 2");
							jTextNumeroCuotas.setBounds(476, 78, 71, 30);
							jTextNumeroCuotas.setFont(new java.awt.Font("Arial", 0, 16));
							jTextNumeroCuotas.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent e) {
									char caracter = e.getKeyChar();

									// Verificar si la tecla pulsada no es un digito
									if (((caracter < '0') || (caracter > '9'))
											&& (caracter != '\b' /* corresponde a BACK_SPACE */)) {
										e.consume(); // ignorar el evento de teclado
									}
								}
							});
						}
						{
							jLabelCodigoPrestamoOculto = new JLabel();
							jPanelEntradasPrestamo.add(jLabelCodigoPrestamoOculto, "2, 2");
							jLabelCodigoPrestamoOculto.setBounds(289, 34, 10, 10);
							jLabelCodigoPrestamoOculto.setVisible(false);
						}
						{
							jLabelCodigo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelCodigo, "6, 1");
							jLabelCodigo.setText("Código");
							jLabelCodigo.setBounds(593, 161, 121, 30);
							jLabelCodigo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTipoPlazo = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTipoPlazo, "1,3,f,f");
							jLabelTipoPlazo.setText("Tipo de plazo:");
							jLabelTipoPlazo.setBounds(17, 78, 178, 30);
							jLabelTipoPlazo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							ComboBoxModel jComboPlazoModel = new DefaultComboBoxModel(
									new String[] { "Seleccione uno", "Mensual", "Quincenal", "Semanal" });
							jComboPlazo = new JComboBox();
							jPanelEntradasPrestamo.add(jComboPlazo, "2, 3, 3, 3");
							jComboPlazo.setModel(jComboPlazoModel);
							jComboPlazo.setBounds(162, 78, 178, 30);
							jComboPlazo.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							jLabelNombreCliente = new JLabel();
							jPanelEntradasPrestamo.add(jLabelNombreCliente, "4, 0, 5, 0");
							jLabelNombreCliente.setText("Nombre");
							jLabelNombreCliente.setBounds(726, 121, 173, 30);
							jLabelNombreCliente.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelFechaInicio = new JLabel();
							jPanelEntradasPrestamo.add(jLabelFechaInicio, "1,4,f,f");
							jLabelFechaInicio.setText("Fecha de inicio:");
							jLabelFechaInicio.setBounds(579, 30, 178, 30);
							jLabelFechaInicio.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							calendarioPrestamos = new JDateChooser();
							calendarioPrestamos.setLocale(new Locale("ES", "CO"));
							calendarioPrestamos.setDateFormatString("dd/MM/yyyy");
							jPanelEntradasPrestamo.add(calendarioPrestamos, "2, 4, 3, 4");
							calendarioPrestamos.setBounds(712, 30, 178, 30);
							calendarioPrestamos.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							jLabelTotalPago = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTotalPago, "4, 2");
							jLabelTotalPago.setText("Total a pagar:");
							jLabelTotalPago.setBounds(362, 121, 116, 30);
							jLabelTotalPago.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							jLabelEmpresaResult = new JLabel();
							jPanelEntradasPrestamo.add(jLabelEmpresaResult, "6, 2");
							jLabelEmpresaResult.setText("Empresa");
							jLabelEmpresaResult.setBounds(726, 161, 168, 30);
							jLabelEmpresaResult.setFont(new java.awt.Font("Arial", 0, 16));

						}

						{
							jLabelDiaCobro = new JLabel();
							jPanelEntradasPrestamo.add(jLabelDiaCobro, "4,3,f,f");
							jLabelDiaCobro.setText("Días de cobro:");
							jLabelDiaCobro.setBounds(17, 121, 178, 30);
							jLabelDiaCobro.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{

							jComboFechasCobro = new JComboBox();
							jPanelEntradasPrestamo.add(jComboFechasCobro, "5, 3");
							DefaultComboBoxModel modelo = new DefaultComboBoxModel();
							modelo.addElement("Nada para mostrar");
							jComboFechasCobro.setModel(modelo);
							jComboFechasCobro.setBounds(162, 121, 178, 30);
							jComboFechasCobro.setFont(new java.awt.Font("Arial", 0, 14));
						}

						{
							{
								jLabelTotalFormato = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalFormato, "5, 2");
								jLabelTotalFormato.setBounds(478, 122, 178, 30);
								jLabelTotalFormato.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelComplemento6 = new JLabel();
								jPanelEntradasPrestamo.add(jLabelComplemento6, "4, 1, 5, 1");
								jLabelComplemento6.setText("Referencia");
								jLabelComplemento6.setBounds(12, 65, 65, 10);
								jLabelComplemento6.setFont(new java.awt.Font("Arial", 0, 16));

							}

							{
								jLabelComplemento4 = new JLabel();
								jPanelEntradasPrestamo.add(jLabelComplemento4, "4,4,f,f");
								jLabelComplemento4.setText("Fecha de fin: ");
								jLabelComplemento4.setBounds(12, 65, 65, 10);
								jLabelComplemento4.setFont(new java.awt.Font("Arial", 0, 16));

							}
							{
								calendarioFinPrestamo = new JDateChooser();
								jPanelEntradasPrestamo.add(calendarioFinPrestamo, "5, 4");
								calendarioFinPrestamo.setBounds(162, 78, 178, 30);
								calendarioFinPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
								calendarioFinPrestamo.setEnabled(false);
							}
							{
								jCheckBoxEditandoPrestamo = new JCheckBox();
								jPanelEntradasPrestamo.add(jCheckBoxEditandoPrestamo, "6, 4");
								jCheckBoxEditandoPrestamo.setText("Editando");
								jCheckBoxEditandoPrestamo.setBounds(789, 178, 115, 20);
								jCheckBoxEditandoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
								jCheckBoxEditandoPrestamo.setEnabled(false);
							}

							{
								URL urlDeLaImagenCalcular = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/calcular.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagenCalcular);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
								jButtonCalcular = new JButton();
								jPanelEntradasPrestamo.add(jButtonCalcular, "1, 5");
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
											error.guardarMensajeError(e.getMessage(),
													this.getClass().getCanonicalName() + ".initGUI");
										}
									}
								});

							}
							// Test de carga de imagenes dentro del jar
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/guardar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonAceptar = new JButton();
							jButtonAceptar.setIcon(new ImageIcon(otraimg));
							jButtonAceptar.setBounds(9, 157, 130, 30);
							jPanelEntradasPrestamo.add(jButtonAceptar, "2, 5, 3, 5");
							jButtonAceptar.setText("Guardar");
							jButtonAceptar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonAceptar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonAceptarActionPerformed(evt);
								}
							});

							{
								URL urlDeLaImagenEditar = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/editar.png");
								ImageIcon iconoEditar = new ImageIcon(urlDeLaImagenEditar);
								Image imgEditar = iconoEditar.getImage();
								Image otraimgEditar = imgEditar.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
								jButtonEditarPrestamo = new JButton();
								jButtonEditarPrestamo.setIcon(new ImageIcon(otraimgEditar));
								jPanelEntradasPrestamo.add(jButtonEditarPrestamo, "4, 5");
								jButtonEditarPrestamo.setText("Editar");
								jButtonEditarPrestamo.setBounds(189, 158, 130, 30);
								jButtonEditarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonEditarPrestamo.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonEditarPrestamoPerformed(evt);
									}
								});
							}
							{
								URL urlDeLaImagen1 = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/cancelar.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagen1);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
								JButton jButtonCancelarPrestamo = new JButton();
								jButtonCancelarPrestamo.setIcon(new ImageIcon(otraimg1));
								jPanelEntradasPrestamo.add(jButtonCancelarPrestamo, "6, 5");
								jButtonCancelarPrestamo.setText("Cancelar");
								jButtonCancelarPrestamo.setBounds(362, 157, 145, 30);
								jButtonCancelarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonCancelarPrestamo.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonCancelarPrestamoActionPerformed(evt);
									}
								});

							}
							{
								URL urlDeLaImagen1 = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/noPagado.png");
								ImageIcon icono1 = new ImageIcon(urlDeLaImagen1);
								Image img1 = icono1.getImage();
								Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
								jButtonEliminarPrestamo = new JButton();
								jButtonEliminarPrestamo.setIcon(new ImageIcon(otraimg1));
								jPanelEntradasPrestamo.add(jButtonEliminarPrestamo, "5, 5");
								jButtonEliminarPrestamo.setText("Eliminar");
								jButtonEliminarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonEliminarPrestamo.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonEliminarPrestamoActionPerformed(evt);
									}
								});
							}
							{
								jLabel1 = new JLabel();
								jPanelEntradasPrestamo.add(jLabel1, "3, 0");
								jLabel1.setText(".000");
								jLabel1.setFont(new java.awt.Font("Arial", 0, 18));
								jLabel1.setBounds(810, 83, 48, 30);
							}

						}
					}
					jTabPestanias.addTab("Abonos", jPanelAbonos);
					jPanelAbonos.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollAbonosRecibidos = new JScrollPane();
						jPanelAbonos.add(jScrollAbonosRecibidos, BorderLayout.SOUTH);
						jScrollAbonosRecibidos.setBounds(8, 263, 777, 381);
						jScrollAbonosRecibidos.setPreferredSize(new java.awt.Dimension(1057, 489));
						{

						}
					}
					{
						jPanelAgregarAbono = new JPanel();
						TableLayout jPanelAgregarAbonoLayout = new TableLayout(
								new double[][] { { 10, 200, 98, 98, 195, 195, 200, 10 }, { 30, 30, 30, 30, 30 } });
						jPanelAgregarAbonoLayout.setHGap(5);
						jPanelAgregarAbonoLayout.setVGap(5);
						jPanelAbonos.add(jPanelAgregarAbono, BorderLayout.NORTH);
						jPanelAgregarAbono.setPreferredSize(new java.awt.Dimension(1057, 197));
						jPanelAgregarAbono.setBorder(BorderFactory.createTitledBorder("Agregar abono"));
						jPanelAgregarAbono.setLayout(jPanelAgregarAbonoLayout);
						{
							jLabelCodigoPrestamo = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoPrestamo, "1, 0");
							jLabelCodigoPrestamo.setText("Código préstamo:");
							jLabelCodigoPrestamo.setBounds(17, 30, 178, 30);
							jLabelCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextCodigoPrestamo = new JTextField();
							jPanelAgregarAbono.add(jTextCodigoPrestamo, "2, 0, 3, 0");
							jTextCodigoPrestamo.setBounds(162, 30, 178, 30);
							jTextCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/buscar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonBuscarPrestamo = new JButton();
							jPanelAgregarAbono.add(jButtonBuscarPrestamo, "4, 0");
							jButtonBuscarPrestamo.setIcon(new ImageIcon(otraimg));
							jButtonBuscarPrestamo.setBounds(376, 25, 130, 30);
							jButtonBuscarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonBuscarPrestamo.setText("Buscar");
							jButtonBuscarPrestamo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonBuscarPrestamoActionPerformed(evt);
								}
							});

						}

						{
							jLabelCodigoAbono = new JLabel();
							jPanelAgregarAbono.add(jLabelCodigoAbono, "1, 1");
							jLabelCodigoAbono.setText("Código abono:");
							jLabelCodigoAbono.setBounds(381, 78, 178, 30);
							jLabelCodigoAbono.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							jTextFieldCodigoAbono = new JTextField();
							jPanelAgregarAbono.add(jTextFieldCodigoAbono, "2, 1, 3, 1");
							jTextFieldCodigoAbono.setBounds(496, 78, 71, 30);
							jTextFieldCodigoAbono.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/actualizar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonVerTodosAbono = new JButton();
							jButtonVerTodosAbono.setIcon(new ImageIcon(otraimg));
							jButtonVerTodosAbono.setText("Ver todos");
							jPanelAgregarAbono.add(jButtonVerTodosAbono, "5, 0");
							jButtonVerTodosAbono.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonVerTodosAbono.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonVerTodosAbonoActionPerformed(evt);
								}
							});

						}

						{
							jLabelFecha = new JLabel();
							jPanelAgregarAbono.add(jLabelFecha, "1, 2");
							jLabelFecha.setText("Fecha de pago:");
							jLabelFecha.setBounds(17, 78, 178, 30);
							jLabelFecha.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							calendarioAbonos = new JDateChooser();
							jPanelAgregarAbono.add(calendarioAbonos, "2, 2, 3, 2");
							calendarioAbonos.setBounds(162, 78, 178, 30);
							calendarioAbonos.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jCheckBoxEditandoAbono = new JCheckBox();
							jPanelAgregarAbono.add(jCheckBoxEditandoAbono, "6, 4");
							jCheckBoxEditandoAbono.setText("Editando");
							jCheckBoxEditandoAbono.setBounds(779, 181, 126, 20);
							jCheckBoxEditandoAbono.setFont(new java.awt.Font("Arial", 0, 16));
							jCheckBoxEditandoAbono.setEnabled(false);
						}
						{
							jLabelMonto = new JLabel();
							jPanelAgregarAbono.add(jLabelMonto, "1, 3");
							jLabelMonto.setText("Monto a abonar:                 $");
							jLabelMonto.setBounds(592, 76, 146, 30);
							jLabelMonto.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextField1 = new JTextField();
							jPanelAgregarAbono.add(jTextField1, "2, 3");
							jTextField1.setBounds(730, 76, 80, 30);
							jTextField1.setFont(new java.awt.Font("Arial", 0, 16));
							jTextField1.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent e) {
									char caracter = e.getKeyChar();

									// Verificar si la tecla pulsada no es un digito
									if (((caracter < '0') || (caracter > '9'))
											&& (caracter != '\b' /* corresponde a BACK_SPACE */)) {
										e.consume(); // ignorar el evento de teclado
									}
								}
							});
						}
						{
							jLabelCerosAbono = new JLabel();
							jPanelAgregarAbono.add(jLabelCerosAbono, "3, 3");
							jLabelCerosAbono.setText(".000");
							jLabelCerosAbono.setBounds(810, 83, 48, 30);
							jLabelCerosAbono.setFont(new java.awt.Font("Arial", 0, 18));
						}
						{
							jLabelComplemento3 = new JLabel();
							jPanelAgregarAbono.add(jLabelComplemento3, "4, 2");
							jLabelComplemento3.setText("Fecha de cobro: ");
							jLabelComplemento3.setBounds(12, 65, 65, 10);
							jLabelComplemento3.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							calendarioAbonosCobro = new JDateChooser();
							jPanelAgregarAbono.add(calendarioAbonosCobro, "5, 2");
							calendarioAbonosCobro.setBounds(162, 78, 178, 30);
							calendarioAbonosCobro.setEnabled(false);
							calendarioAbonosCobro.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/guardar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonGuardar = new JButton();
							jPanelAgregarAbono.add(jButtonGuardar, "2, 4, 3, 4");
							jButtonGuardar.setIcon(new ImageIcon(otraimg));
							jButtonGuardar.setText("Guardar");
							// jButtonGuardar.setBounds(17, 147, 130, 30);
							jButtonGuardar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonGuardar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarAbonoActionPerformed(evt);
								}
							});
						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/editar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonEditarAbono = new JButton();
							jPanelAgregarAbono.add(jButtonEditarAbono, "4, 4");
							jButtonEditarAbono.setIcon(new ImageIcon(otraimg));
							jButtonEditarAbono.setText("Editar");
							// jButtonEditarAbono.setBounds(185, 146, 130, 30);
							jButtonEditarAbono.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonEditarAbono.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonEditarAbonoActionPerformed(evt);
								}
							});
						}

						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/cancelar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonCancelarAbono = new JButton();
							jPanelAgregarAbono.add(jButtonCancelarAbono, "5, 4");
							jButtonCancelarAbono.setIcon(new ImageIcon(otraimg));
							jButtonCancelarAbono.setText("Cancelar");
							// jButtonCancelarAbono.setBounds(351, 147, 145, 30);
							jButtonCancelarAbono.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonCancelarAbono.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									jButtonCancelarAbonoActionPerformed(e);

								}
							});

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
						jScrollPaneClientes.setPreferredSize(new java.awt.Dimension(1015, 521));
						{

						}
					}
					{
						jPanelAgregarCliente = new JPanel();
						TableLayout jPanelAgregarClienteLayout = new TableLayout(
								new double[][] { { 10, 200, 98, 98, 195, 195, 200, 10 }, { 30, 30, 30, 30 } });
						jPanelAgregarClienteLayout.setHGap(5);
						jPanelAgregarClienteLayout.setVGap(5);
						jPanelClientes.add(jPanelAgregarCliente, BorderLayout.NORTH);
						jPanelAgregarCliente.setPreferredSize(new java.awt.Dimension(1015, 142));
						jPanelAgregarCliente.setLayout(jPanelAgregarClienteLayout);
						{
							jLabelNombre = new JLabel();
							jPanelAgregarCliente.add(jLabelNombre, "1, 0");
							jLabelNombre.setText("Nombre:");
							jLabelNombre.setBounds(12, 19, 178, 30);
							jLabelNombre.setFont(new java.awt.Font("Arial", 0, 16));

						}
						{
							jTextNombre = new JTextField();
							jPanelAgregarCliente.add(jTextNombre, "2, 0, 4, 0");
							jTextNombre.setBounds(100, 19, 178, 30);
							jTextNombre.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelCodigoCliente = new JLabel();
							jPanelAgregarCliente.add(jLabelCodigoCliente, "2, 0");
							jLabelCodigoCliente.setBounds(12, 65, 65, 10);

						}

						{
							jLabelEmpresa = new JLabel();
							jPanelAgregarCliente.add(jLabelEmpresa, "1, 1");
							jLabelEmpresa.setText("Categoría / Empresa:");
							jLabelEmpresa.setBounds(312, 19, 178, 30);
							jLabelEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							ComboBoxModel jComboEmpresaModel = new DefaultComboBoxModel(
									new String[] { "Sin categoria", "Semanal", "Impulso", "Supermercados", "Común",
											"Vendedores", "Don Pollo", "Droguería", "La Locura", "Mr Pompy",
											"Comunicaciones", "Mocawa", "Hogar infantil", "Otra" });
							jTextEmpresa = new JComboBox<>();
							jTextEmpresa.setModel(jComboEmpresaModel);
							jPanelAgregarCliente.add(jTextEmpresa, "2, 1, 4, 1");
							jTextEmpresa.setBounds(403, 19, 178, 30);
							jTextEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}

						{
							jLabelComplemento = new JLabel();
							jPanelAgregarCliente.add(jLabelComplemento, "1, 1");
							jLabelComplemento.setBounds(12, 65, 65, 10);

						}
						{
							jLabelReferencia = new JLabel();
							jPanelAgregarCliente.add(jLabelReferencia, "1, 2");
							jLabelReferencia.setText("Referencia:");
							jLabelReferencia.setBounds(606, 19, 178, 30);
							jLabelReferencia.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextReferencia = new JTextField();
							jPanelAgregarCliente.add(jTextReferencia, "2, 2, 4, 2");
							jTextReferencia.setBounds(708, 19, 178, 30);
							jTextReferencia.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jCheckBoxEdicionCliente = new JCheckBox();
							jPanelAgregarCliente.add(jCheckBoxEdicionCliente, "6, 3");
							jCheckBoxEdicionCliente.setText("Editando");
							jCheckBoxEdicionCliente.setBounds(784, 112, 115, 20);
							jCheckBoxEdicionCliente.setFont(new java.awt.Font("Arial", 0, 16));
							jCheckBoxEdicionCliente.setEnabled(false);
						}

						{
							ImageIcon icono = new ImageIcon("src/co/prestapp/res/guardar.png");
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonGuardarCliente = new JButton();
							jButtonGuardarCliente.setIcon(new ImageIcon(otraimg));
							jPanelAgregarCliente.add(jButtonGuardarCliente, "2, 3, 3, 3");
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
									.getResource("co/prestapp/res/editar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagen);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonEditarCliente = new JButton();
							jPanelAgregarCliente.add(jButtonEditarCliente, "4, 3");
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
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/cancelar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonCancelar = new JButton();
							jButtonCancelar.setIcon(new ImageIcon(otraimg));
							jPanelAgregarCliente.add(jButtonCancelar, "5, 3");
							jButtonCancelar.setText("Cancelar");
							jButtonCancelar.setBounds(386, 90, 130, 30);
							jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonCancelar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonCancelarActionPerformed(evt);
								}
							});
						}

					}
					// Aquí listados
					jTabPestanias.addTab("Listados", jPaneListados);
					jPaneListados.setFont(new java.awt.Font("Arial", 0, 16));
					{
						// Panel superior
						jPaneSeleccionListado = new JPanel();
						TableLayout jPaneSeleccionListadoLayout = new TableLayout(
								new double[][] { { 10, 200, 98, 98, 195, 195, 200, 10 }, { 30, 30, 30 } });
						jPaneSeleccionListadoLayout.setHGap(5);
						jPaneSeleccionListadoLayout.setVGap(5);
						jPaneListados.add(jPaneSeleccionListado, BorderLayout.NORTH);
						jPaneSeleccionListado.setPreferredSize(new java.awt.Dimension(1025, 132));
						jPaneSeleccionListado.setBorder(BorderFactory.createTitledBorder("Listados"));
						jPaneSeleccionListado.setLayout(jPaneSeleccionListadoLayout);
						{
							jButtonBuscarMovimientos = new JButton();
							jPaneSeleccionListado.add(jButtonBuscarMovimientos, "6, 1");
							jButtonBuscarMovimientos.setText("Buscar");
							jButtonBuscarMovimientos.setBounds(795, 61, 229, 30);
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
							jPaneSeleccionListado.add(calendarioFinMovimiento, "5, 1");
							calendarioFinMovimiento.setLocale(new Locale("ES", "CO"));
							calendarioFinMovimiento.setDateFormatString("dd/MM/yyyy");
							calendarioFinMovimiento.setBounds(601, 61, 170, 30);
							calendarioFinMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
							calendarioFinMovimiento.setEnabled(false);
						}
						{
							jLabelFechaFinMovimiento = new JLabel();
							jPaneSeleccionListado.add(jLabelFechaFinMovimiento, "4, 1");
							jLabelFechaFinMovimiento.setText("Fecha fin:");
							jLabelFechaFinMovimiento.setBounds(473, 60, 132, 30);
							jLabelFechaFinMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelFechaInicioMovimiento = new JLabel();
							jPaneSeleccionListado.add(jLabelFechaInicioMovimiento, "1, 1");
							jLabelFechaInicioMovimiento.setText("Fecha inicio:");
							jLabelFechaInicioMovimiento.setBounds(12, 60, 143, 30);
							jLabelFechaInicioMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							calendarioInicioMovimiento = new JDateChooser();
							jPaneSeleccionListado.add(calendarioInicioMovimiento, "2, 1, 3, 1");
							calendarioInicioMovimiento.setLocale(new Locale("ES", "CO"));
							calendarioInicioMovimiento.setDateFormatString("dd/MM/yyyy");
							calendarioInicioMovimiento.setBounds(267, 60, 178, 30);
							calendarioInicioMovimiento.setFont(new java.awt.Font("Arial", 0, 16));
							calendarioInicioMovimiento.setEnabled(false);

						}
						{
							// Componentes del panel superior
							jLabelSeleccioneListado = new JLabel();
							jPaneSeleccionListado.add(jLabelSeleccioneListado, "1, 0");
							jLabelSeleccioneListado.setText("Seleccione listado:");
							jLabelSeleccioneListado.setBounds(12, 19, 172, 25);
							jLabelSeleccioneListado.setFont(new java.awt.Font("Arial", 0, 16));

							jComboSeleccionListado = new JComboBox();
							jPaneSeleccionListado.add(jComboSeleccionListado, "2, 0, 4, 0");
							jComboSeleccionListado.setBounds(265, 13, 316, 30);
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
							Image otraimg1 = img1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonGenerarPDF = new JButton();
							jButtonGenerarPDF.setIcon(new ImageIcon(otraimg1));
							jPaneSeleccionListado.add(jButtonGenerarPDF, "5, 0");

							jButtonGenerarPDF.setText("Generar PDF");
							jButtonGenerarPDF.setBounds(601, 14, 170, 30);
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
							Image otraimgBackup = imgBackup.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
							jButtonBackup = new JButton();
							jButtonBackup.setIcon(new ImageIcon(otraimgBackup));
							jPaneSeleccionListado.add(jButtonBackup, "6, 0");
							jButtonBackup.setText("Copia seguridad");
							jButtonBackup.setBounds(795, 14, 229, 30);
							jButtonBackup.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonBackup.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGenerarBackupActionPerformed(evt);
								}
							});

						}
						{
							jLabelCategoríaEmpresa = new JLabel();
							jPaneSeleccionListado.add(jLabelCategoríaEmpresa, "1, 2");
							jLabelCategoríaEmpresa.setText("Categoría/Empresa:");
							jLabelCategoríaEmpresa.setBounds(12, 112, 143, 30);
							jLabelCategoríaEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							ComboBoxModel jComboBoxCategoriaEmpresaModel = new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
							jComboBoxCategoriaEmpresa = new JComboBox();
							jPaneSeleccionListado.add(jComboBoxCategoriaEmpresa, "2, 2, 4, 2");
							jComboBoxCategoriaEmpresa.setModel(jComboBoxCategoriaEmpresaModel);
							jComboBoxCategoriaEmpresa.setBounds(267, 112, 316, 30);
							jComboBoxCategoriaEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
							jComboBoxCategoriaEmpresa.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jComboBoxCategoriaEmpresaActionPerformed(evt);
								}
							});
						}
						{
							jButton1 = new JButton();
							jPaneSeleccionListado.add(jButton1, "5, 2");
							jButton1.setText("Generar PDF");
							jButton1.setFont(new java.awt.Font("Arial", 0, 16));
							jButton1.setBounds(601, 14, 170, 30);
							jButton1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButton1ActionPerformed(evt);
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
						jPanListaResultados.setPreferredSize(new java.awt.Dimension(1025, 493));
						jPanListaResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
						{
							// Componentes del panel inferior
							jScrollPaneResultados = new JScrollPane();
							jPanListaResultados.add(jScrollPaneResultados, BorderLayout.CENTER);
							jScrollPaneResultados.setPreferredSize(new java.awt.Dimension(1047, 444));
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
						jScrollPaneReportesPorFecha.setPreferredSize(new java.awt.Dimension(1057, 415));
					}
					{
						// Aquí el panel de cifras
						jPanelCifras = new JPanel();
						TableLayout jPanelCifrasLayout = new TableLayout(new double[][] {
								{ 10, 200, 150, 50, 10, 200, 150, 50, 10 }, { 30, 30, 30, 30, 30, 30, 30 } });
						jPanelCifrasLayout.setHGap(5);
						jPanelCifrasLayout.setVGap(5);
						jPanelReportes.add(jPanelCifras, BorderLayout.NORTH);
						jPanelCifras.setLayout(jPanelCifrasLayout);
						jPanelCifras.setBorder(BorderFactory.createTitledBorder("Cifras"));
						jPanelCifras.setPreferredSize(new java.awt.Dimension(1057, 267));
						{
							// Componentes del panel de cifras
							jLabelTotalPrestado = new JLabel();
							jPanelCifras.add(jLabelTotalPrestado, "1, 0");
							jLabelTotalPrestado.setText("Total prestado:");
							jLabelTotalPrestado.setBounds(17, 30, 211, 23);
							jLabelTotalPrestado.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalrecibido = new JLabel();
							jPanelCifras.add(jLabelTotalrecibido, "1, 2");
							jLabelTotalrecibido.setText("Total recaudado:");
							jLabelTotalrecibido.setBounds(17, 117, 211, 23);
							jLabelTotalrecibido.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestado = new JTextField();
							jPanelCifras.add(jTextTotalPrestado, "2, 0");
							jTextTotalPrestado.setBounds(226, 30, 178, 23);
							jTextTotalPrestado.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestado.setEditable(false);

							jTextTotalRecaudado = new JTextField();
							jPanelCifras.add(jTextTotalRecaudado, "2, 2");
							jTextTotalRecaudado.setBounds(226, 117, 178, 23);
							jTextTotalRecaudado.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalRecaudado.setEditable(false);

							jLabelInteresesRecaudados = new JLabel();
							jPanelCifras.add(jLabelInteresesRecaudados, "1, 3");
							jLabelInteresesRecaudados.setText("Intereses recaudados:");
							jLabelInteresesRecaudados.setBounds(17, 160, 210, 23);
							jLabelInteresesRecaudados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextInteresesRecaudados = new JTextField();
							jPanelCifras.add(jTextInteresesRecaudados, "2, 3");
							jTextInteresesRecaudados.setBounds(226, 160, 178, 23);
							jTextInteresesRecaudados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextInteresesRecaudados.setEditable(false);

							jLabelTotalPrestamosActivos = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosActivos, "1, 5");
							jLabelTotalPrestamosActivos.setText("Total préstamos activos:");
							jLabelTotalPrestamosActivos.setBounds(17, 247, 210, 23);
							jLabelTotalPrestamosActivos.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestamosActivos = new JTextField();
							jPanelCifras.add(jTextTotalPrestamosActivos, "2, 5");
							jTextTotalPrestamosActivos.setBounds(226, 247, 178, 23);
							jTextTotalPrestamosActivos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestamosActivos.setEditable(false);

							jLabelTotalPrestamosFinalizados = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosFinalizados, "5, 0");
							jLabelTotalPrestamosFinalizados.setText("Total préstamos finalizados:");
							jLabelTotalPrestamosFinalizados.setBounds(448, 30, 209, 23);
							jLabelTotalPrestamosFinalizados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalPrestamosFinalizados = new JTextField();
							jPanelCifras.add(jTextTotalPrestamosFinalizados, "6, 0");
							jTextTotalPrestamosFinalizados.setBounds(710, 30, 178, 23);
							jTextTotalPrestamosFinalizados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalPrestamosFinalizados.setEditable(false);

							jLabelTotalPrestamosVencidos = new JLabel();
							jPanelCifras.add(jLabelTotalPrestamosVencidos, "5, 1");
							jLabelTotalPrestamosVencidos.setText("Total préstamos vencidos:");
							jLabelTotalPrestamosVencidos.setBounds(448, 73, 212, 23);
							jLabelTotalPrestamosVencidos.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalprestamosVencidos = new JTextField();
							jPanelCifras.add(jTextTotalprestamosVencidos, "6, 1");
							jTextTotalprestamosVencidos.setBounds(710, 73, 178, 23);
							jTextTotalprestamosVencidos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalprestamosVencidos.setEditable(false);

							jLabelTotalclientesRegistrados = new JLabel();
							jPanelCifras.add(jLabelTotalclientesRegistrados, "5, 4");
							jLabelTotalclientesRegistrados.setText("Total clientes registrados:");
							jLabelTotalclientesRegistrados.setBounds(448, 204, 178, 23);
							jLabelTotalclientesRegistrados.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalClientesactivos = new JTextField();
							jPanelCifras.add(jTextTotalClientesactivos, "6, 5");
							jTextTotalClientesactivos.setBounds(710, 247, 178, 23);
							jTextTotalClientesactivos.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalClientesactivos.setEditable(false);

							jTextTotalclientesRegistrados = new JTextField();
							jPanelCifras.add(jTextTotalclientesRegistrados, "6, 4");
							jTextTotalclientesRegistrados.setBounds(710, 204, 178, 23);
							jTextTotalclientesRegistrados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalclientesRegistrados.setEditable(false);

							jLabelTotalClientesactivos = new JLabel();
							jPanelCifras.add(jLabelTotalClientesactivos, "5, 5");
							jLabelTotalClientesactivos.setText("Total clientes activos:");
							jLabelTotalClientesactivos.setBounds(448, 247, 178, 23);
							jLabelTotalClientesactivos.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalAbonosCobrados = new JLabel();
							jPanelCifras.add(jLabelTotalAbonosCobrados, "5, 2");
							jLabelTotalAbonosCobrados.setText("Total abonos cobrados:");
							jLabelTotalAbonosCobrados.setBounds(448, 117, 178, 23);
							jLabelTotalAbonosCobrados.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelTotalAbonosPendientes = new JLabel();
							jPanelCifras.add(jLabelTotalAbonosPendientes, "5, 3");
							jLabelTotalAbonosPendientes.setText("Total abonos pendientes:");
							jLabelTotalAbonosPendientes.setBounds(448, 160, 178, 23);
							jLabelTotalAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalAbonosCobrados = new JTextField();
							jPanelCifras.add(jTextTotalAbonosCobrados, "6, 2");
							jTextTotalAbonosCobrados.setBounds(710, 117, 178, 23);
							jTextTotalAbonosCobrados.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalAbonosCobrados.setEditable(false);

							jTextTotalAbonosPendientes = new JTextField();
							jPanelCifras.add(jTextTotalAbonosPendientes, "6, 3");
							jTextTotalAbonosPendientes.setBounds(710, 160, 178, 23);
							jTextTotalAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalAbonosPendientes.setEditable(false);

							jLabelTotalRecaudoPendiente = new JLabel();
							jPanelCifras.add(jLabelTotalRecaudoPendiente, "1, 1");
							jLabelTotalRecaudoPendiente.setText("Total recaudo pendiente:");
							jLabelTotalRecaudoPendiente.setBounds(17, 73, 178, 23);
							jLabelTotalRecaudoPendiente.setFont(new java.awt.Font("Arial", 0, 16));

							jTextTotalrecaudoPendiente = new JTextField();
							jPanelCifras.add(jTextTotalrecaudoPendiente, "2, 1");
							jTextTotalrecaudoPendiente.setBounds(226, 73, 178, 23);
							jTextTotalrecaudoPendiente.setFont(new java.awt.Font("Arial", 0, 16));
							jTextTotalrecaudoPendiente.setEditable(false);

							jLabelInteresesPendientesRecaudo = new JLabel();
							jPanelCifras.add(jLabelInteresesPendientesRecaudo, "1, 4");
							jLabelInteresesPendientesRecaudo.setText("Interses a recaudar");
							jLabelInteresesPendientesRecaudo.setBounds(17, 204, 178, 23);
							jLabelInteresesPendientesRecaudo.setFont(new java.awt.Font("Arial", 0, 16));

							jTextIntersesePendientesRecaudo = new JTextField();
							jPanelCifras.add(jTextIntersesePendientesRecaudo, "2, 4");
							jTextIntersesePendientesRecaudo.setBounds(226, 204, 178, 23);
							jTextIntersesePendientesRecaudo.setFont(new java.awt.Font("Arial", 0, 16));
							jTextIntersesePendientesRecaudo.setEditable(false);

							jLabelPrestadoPorFecha = new JLabel();
							jPanelCifras.add(jLabelPrestadoPorFecha, "1, 6");
							jLabelPrestadoPorFecha.setText("Préstamos por fecha:");
							jLabelPrestadoPorFecha.setBounds(17, 291, 209, 23);
							jLabelPrestadoPorFecha.setFont(new java.awt.Font("Arial", 0, 16));

							jLabelAbonosPorFecha = new JLabel();
							jPanelCifras.add(jLabelAbonosPorFecha, "5, 6");
							jLabelAbonosPorFecha.setText("Abonos pagados por fecha:");
							jLabelAbonosPorFecha.setBounds(448, 291, 249, 23);
							jLabelAbonosPorFecha.setFont(new java.awt.Font("Arial", 0, 16));

							URL urlDeLaImagenBuscar = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/buscar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagenBuscar);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonPrestamoPorFecha = new JButton();
							jPanelCifras.add(jButtonPrestamoPorFecha, "3, 6");
							jButtonPrestamoPorFecha.setIcon(new ImageIcon(otraimg1));
							jButtonPrestamoPorFecha.setBounds(357, 282, 49, 38);
							jButtonPrestamoPorFecha.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonPrestamoPorFechaActionPerformed(evt);
								}
							});

							jButtonAbonoPorFecha = new JButton();
							jPanelCifras.add(jButtonAbonoPorFecha, "7, 6");
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
							jPanelCifras.add(calendarioPrestamosPorfecha, "2, 6");
							calendarioPrestamosPorfecha.setBounds(225, 291, 132, 23);
							calendarioPrestamosPorfecha.setFont(new java.awt.Font("Arial", 0, 16));

							calendarioAbonosPorFecha = new JDateChooser();
							calendarioAbonosPorFecha.setLocale(new Locale("ES", "CO"));
							calendarioAbonosPorFecha.setDateFormatString("dd/MM/yyyy");
							jPanelCifras.add(calendarioAbonosPorFecha, "6, 6");
							calendarioAbonosPorFecha.setBounds(712, 291, 132, 23);
							calendarioAbonosPorFecha.setFont(new java.awt.Font("Arial", 0, 16));
						}
					}

				}
			}
			pack();
			this.setSize(1068, 750);

		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".initGUI");
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
				jLabelComplemento6.setText(cliente.getReferenciaCliente());
			}

		} catch (NumberFormatException e) {

			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(),
					this.getClass().getCanonicalName() + ".jButtonClienteExisteActionPerformed");
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
			String empresa = (String) jTextEmpresa.getSelectedItem();
			String referencia = jTextReferencia.getText();
			miCliente.editarCliente(codigoCliente, nombre, empresa, referencia);
			JOptionPane.showMessageDialog(this, "Cliente editado con éxito", "Edición exitosa",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposCliente();
			jCheckBoxEdicionCliente.setSelected(false);
			actualizaTodo();
			return;
		}
		if (validarCamposCliente()) {
			String nombre = jTextNombre.getText();
			String empresa = (String) jTextEmpresa.getSelectedItem();
			String referencia = jTextReferencia.getText();
			ClienteDAO miCliente = new ClienteDAO();
			miCliente.agregarCliente(nombre, empresa, referencia);
			JOptionPane.showMessageDialog(this, "Cliente guardado con éxito", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposCliente();
			actualizaTodo();

		}

	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {

		limpiarCamposCliente();
		jCheckBoxEdicionCliente.setSelected(false);

	}

	private void jButtonCancelarPrestamoActionPerformed(ActionEvent evt) {

		limpiarCamposPrestamo();
		jCheckBoxEditandoPrestamo.setSelected(false);
	}

	private void limpiarCamposCliente() {

		jTextNombre.setText("");
		jTextEmpresa.setSelectedIndex(0);
		jTextReferencia.setText("");

	}

	private void limpiarCamposPrestamo() {

		jTextMonto.setText("");
		jTextTasaInteres.setText("");
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		modelo.addElement("Nada para mostrar");
		jComboFechasCobro.setModel(modelo);
		jTextNumeroCuotas.setText("");
		jLabelTotalFormato.setText("total formato");
		jComboPlazo.setSelectedIndex(0);
		jLabelNombreCliente.setText("Nombre");
		jLabelCodigo.setText("Código");
		jLabelEmpresaResult.setText("Empresa");
		jLabelComplemento6.setText("Referencia");
		calendarioPrestamos.setDate(null);
		calendarioFinPrestamo.setDate(null);
		calendarioFinPrestamo.setEnabled(false);

	}

	private void limpiarCamposAbono() {

		jTextFieldCodigoAbono.setText("");
		jTextField1.setText("");
		calendarioAbonos.setDate(null);
		calendarioAbonosCobro.setDate(null);

	}

	@SuppressWarnings("unchecked")
	private void jButtonCalcularActionPerformed(ActionEvent evt) throws Exception {

		float montoPrestamo = 0;
		int tasaInteres = 0;
		String tipoPlazo = "";
		int numeroCuotas = 0;
		Date fechaInicio = null;
		Date fechaFin = null;
		PrestamoDAO miPrestamo = null;
		int tamanioArray = 0;
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

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
				tamanioArray = fechasPago.size();
				fechaFin = fechasPago.get(tamanioArray - 1);
				calendarioFinPrestamo.setDate(fechaFin);
				modeloNuevo = llenaComboPlazos(fechasPago);
				jComboFechasCobro.setModel(modeloNuevo);

				float totalPagar = miPrestamo.calcularPrestamo(montoPrestamo, tasaInteres, tipoPlazo, numeroCuotas);

				jLabelTotalFormato.setText(formatoMoneda.format(totalPagar) + "");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonCalcularActionPerformed");
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
		// La ultima fecha del arreglo
		Date fechaFin = null;
		String codigoCliente = jLabelCodigo.getText();
		String codigoPrestamo = jLabelCodigoPrestamoOculto.getText();
		ArrayList<Date> fechasPago = new ArrayList<Date>();

		if (jCheckBoxEditandoPrestamo.isSelected()) {
			if (validarCamposPrestamo()) {

				// recojo valores
				try {
					montoPrestamo = Float.parseFloat(jTextMonto.getText()) * 1000;
					tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
					numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					error.guardarMensajeError(e.getMessage(),
							this.getClass().getCanonicalName() + ".jButtonAceptarActionPerformed");
				}
				tipoPlazo = (String) jComboPlazo.getSelectedItem();
				tipoPlazoMayus = tipoPlazo.toUpperCase();
				// El saldo pendiente
				totalPagar = miPrestamo.calcularPrestamo(montoPrestamo, tasaInteres, tipoPlazo, numeroCuotas);

				fechaInicio = calendarioPrestamos.getDate();
				// Fecha de fin
				fechasPago = miPrestamo.calcularFechasPago(tipoPlazo, numeroCuotas, fechaInicio);
				try {
					fechaFin = calendarioFinPrestamo.getDate();

					// Busco el cliente de nuevo
					codigoCliente = jLabelCodigo.getText();
					if (codigoCliente.equals("Código")) {
						JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Alerta",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					error.guardarMensajeError(e.getMessage(),
							this.getClass().getCanonicalName() + ".jButtonAceptarActionPerformed");
				}

			}
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

				// edito el préstamo
				// edito el movimiento
				// limpio campos
				// quito selección del checkbutton
				// actualizo valores

				// Verifico si ya han abonado dinero al préstamo
				// Si han abonado no dejo editar
				if (miPrestamo.prestamoTieneAbonos(codigoPrestamo)) {
					JOptionPane.showMessageDialog(this,
							"Este préstamo ya tiene saldo abonado, por tanto no es posible modificar sus parámetros",
							"El préstamo no se puede editar", JOptionPane.ERROR_MESSAGE);
					return;
				} else {

					// elimino los abonos asociados
					miAbono.eliminarAbonosAsociados(codigoPrestamo);

					// edito el prestamo
					miPrestamo.editarPrestamo(codigoPrestamo, montoPrestamo, tasaInteres, numeroCuotas, totalPagar,
							fechaInicio, fechaFin, tipoPlazoMayus, codigoCliente);

					// Creo los abonos correspondientes a ese préstamo
					miAbono.crearAbonosPrestamo(totalPagar, numeroCuotas, fechasPago, codigoPrestamo);

					// Registro el movimiento
					miMovimiento.editarMovimiento(codigoPrestamo, fechaInicio, 0, montoPrestamo);

					JOptionPane.showMessageDialog(this, "El préstamo se ha editado correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					jCheckBoxEditandoPrestamo.setSelected(false);
					limpiarCamposPrestamo();
					actualizaTodo();
				}

			}

			return;
		}

		if (validarCamposPrestamo()) {
			// Recojo los datos necesarios
			try {
				montoPrestamo = Float.parseFloat(jTextMonto.getText()) * 1000;
				tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
				numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonAceptarActionPerformed");
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
				fechaFin = calendarioFinPrestamo.getDate();
				// Busco el cliente de nuevo
				codigoCliente = jLabelCodigo.getText();
				if (codigoCliente.equals("Código")) {
					JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonAceptarActionPerformed");
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
			String codigoPrestamoN = miPrestamo.agregarPrestamo(montoPrestamo, tasaInteres, numeroCuotas, totalPagar,
					totalPagado, fechaInicio, fechaFin, tipoPlazoMayus, codigoCliente, estadoPrestamo);

			// Creo los abonos correspondientes a ese préstamo
			miAbono.crearAbonosPrestamo(totalPagar, numeroCuotas, fechasPago, codigoPrestamoN);

			// Registro el movimiento
			miMovimiento.agregarMovimiento(codigoPrestamoN, fechaInicio, 0, montoPrestamo);

			JOptionPane.showMessageDialog(this, "El préstamo se ha creado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposPrestamo();
			actualizaTodo();
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
		Date fechaCobro = null;
		String codigoAbono = "";
		double montoPagado = 0;

		if (jCheckBoxEditandoAbono.isSelected()) {

			if (validarCamposAbonoPrestamo()) {

				fechaPago = calendarioAbonos.getDate();
				fechaCobro = calendarioAbonosCobro.getDate();
				codigoAbono = jTextFieldCodigoAbono.getText();
				montoPagado = Double.parseDouble(jTextField1.getText()) * 1000;
				miAbono.editarAbonoPagado(codigoAbono, fechaPago, montoPagado, fechaCobro);
				// Edito el movimiento para actualizar cifras
				miMovimiento.editarMovimiento(codigoAbono, fechaPago, montoPagado, 0);
				JOptionPane.showMessageDialog(this, "Abono editado con éxito", "Edición exitosa",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarCamposAbono();
				jCheckBoxEditandoAbono.setSelected(false);
				calendarioAbonosCobro.setEnabled(false);

				// Ver todos o uno
				if (jTextCodigoPrestamo.getText().isEmpty()) {
					actualizaAbonos();
				} else {
					actualizaPrestamoBuscado();
				}

				actualizaPrestamosRequerido();
				actualizaClientes();
				actualizaReportes();
				return;
			}
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

				// Ver todos o uno
				if (jTextCodigoPrestamo.getText().isEmpty()) {
					actualizaAbonos();
				} else {
					actualizaPrestamoBuscado();
				}
				actualizaPrestamosRequerido();
				actualizaClientes();
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
		jCheckBoxEditandoAbono.setSelected(false);
		calendarioAbonosCobro.setEnabled(false);
	}

	// -----------------Tablas------------------------------------------------------
	private void actualizaTodo() {

		actualizaPrestamosRequerido();
		actualizaAbonos();
		actualizaReportes();
		actualizaClientes();

	}

	private void actualizaAbonos() {

		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonos[][] = miAbono.obtenerMatrizAbonos();
		String titulos[] = miAbono.getColumnas();
		jTableAbonosRecibidos = new JTable(informacionAbonos, titulos);
		jScrollAbonosRecibidos.setViewportView(jTableAbonosRecibidos);
		jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 14));
		JTableHeader th = jTableAbonosRecibidos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 14));
		ajustaColumnasAContenido(jTableAbonosRecibidos);
	}

	private void actualizaPrestamosPorFecha() {

		Date fechaSeleccionada = calendarioPrestamosPorfecha.getDate();
		PrestamoDAO miPrestamo = new PrestamoDAO();
		String informacionPrestamosPorFecha[][] = miPrestamo.obtenerMatrizPrestamosPorFecha(fechaSeleccionada);
		String titulos[] = miPrestamo.getColumnasRequerido();
		jTableReportesPorFecha = new JTable(informacionPrestamosPorFecha, titulos);
		jScrollPaneReportesPorFecha.setViewportView(jTableReportesPorFecha);
		jTableReportesPorFecha.setFont(new java.awt.Font("Arial", 0, 14));
		JTableHeader th = jTableReportesPorFecha.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 14));
		ajustaColumnasAContenido(jTableReportesPorFecha);
	}

	private void actualizaAbonosPorFecha() {

		Date fechaSeleccionada = calendarioAbonosPorFecha.getDate();
		AbonoDAO miAbono = new AbonoDAO();
		String informacionAbonosPorFecha[][] = miAbono.obtenerMatrizAbonosPorFecha(fechaSeleccionada);
		String titulos[] = miAbono.getColumnas();
		jTableReportesPorFecha = new JTable(informacionAbonosPorFecha, titulos);
		jScrollPaneReportesPorFecha.setViewportView(jTableReportesPorFecha);
		jTableReportesPorFecha.setFont(new java.awt.Font("Arial", 0, 14));
		JTableHeader th = jTableReportesPorFecha.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 14));
		ajustaColumnasAContenido(jTableReportesPorFecha);
	}

	private void actualizaPrestamosRequerido() {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		miPrestamo.actualizaPagos();
		String informacionPrestamos[][] = miPrestamo.obtenerMatrizPrestamosPendientes();
		String titulos[] = miPrestamo.getColumnasRequerido();
		jTablePrestamos = new JTable(informacionPrestamos, titulos);
		jScrollReportes.setViewportView(jTablePrestamos);
		jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
		JTableHeader th = jTablePrestamos.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 14));
		ajustaColumnasAContenido(jTablePrestamos);
	}

	private void actualizaClientes() {

		ClienteDAO miCliente = new ClienteDAO();
		String informacionClientes[][] = miCliente.obtenerMatrizClientes();
		String titulos[] = miCliente.getColumnas();
		jTableClientes = new JTable(informacionClientes, titulos);
		jScrollPaneClientes.setViewportView(jTableClientes);
		jTableClientes.setFont(new java.awt.Font("Arial", 0, 14));
		JTableHeader th = jTableClientes.getTableHeader();
		th.setFont(new java.awt.Font("Arial", 0, 14));
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
			jTableAbonosRecibidos.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader th = jTableAbonosRecibidos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
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
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".actualizaReportes");
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
							String codigoCliente = jLabelCodigo.getText();
							if (codigoCliente.equals("Código")) {
								JOptionPane.showMessageDialog(this, "Debe especificar un código de cliente válido",
										"Alerta", JOptionPane.WARNING_MESSAGE);
							} else {
								if (calendarioFinPrestamo.getDate() == null) {
									JOptionPane.showMessageDialog(this,
											"Debe presionar <Calcular> para obtener la fecha final del préstamo",
											"Alerta", JOptionPane.WARNING_MESSAGE);
								} else {
									resultado = true;
								}

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
						listaClientesNoActivos, listaPrestamosCliente, listaPrestamos, listaPrestamosPendientes,
						listaPrestamosPagados, listaPrestamosVencidos, listaAbonos, listaAbonosPendientes,
						listaAbonosPagados, listaMovimientosEntrada, listaMovimientosSalida, listaMovimientosFechas });
		jComboSeleccionListado.setModel(jComboListadosModel);

	}

	private void llenaComboCategoriaEmpresa() {

		ComboBoxModel<String> jComboCategoriasModel = new DefaultComboBoxModel<String>(
				new String[] { seleccioneUna, SinCategoria, Semanal, Impulso, Supermercados, Comun, Vendedores,
						DonPollo, Drogueria, LaLocura, MrPompy, Comunicaciones, Mocawa, Hogarinfantil, Otro });
		jComboBoxCategoriaEmpresa.setModel(jComboCategoriasModel);

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
		boolean resultado = backup.CrearBackup("localhost", "3306", "root", "root", "prestapp",
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
		String tituloTabla = "Listado de todos los préstamos registrados";
		ReportePrestamosCatEmpresa ejemplo = new ReportePrestamosCatEmpresa(strTituloPDF, strNombrePDF, "todos",
				tituloTabla);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

	}

	private void generarReportePrestamosPorEmpresa(String categoriaSeleccionada) {

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

		String strNombrePDF = "ReportePrestamosCategoriaEmpresa" + diaS + mesS + anio + horaS + minutoS + segundoS
				+ ".pdf";
		String strTituloPDF = "Reporte de préstamos registrados por categoria, generado el: " + diaS + "/" + mesS + "/"
				+ anio + "  a las " + " " + horaS + ":" + minutoS + ":" + segundoS;
		String tituloTabla = "Listado de préstamos por categoría: " + categoriaSeleccionada;
		ReportePrestamosCatEmpresa ejemplo = new ReportePrestamosCatEmpresa(strTituloPDF, strNombrePDF,
				categoriaSeleccionada, tituloTabla);
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
		String tituloTabla = "Listado de préstamos pendientes";
		ReportePrestamosCatEmpresa ejemplo = new ReportePrestamosCatEmpresa(strTituloPDF, strNombrePDF, "pendientes",
				tituloTabla);
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
		String tituloTabla = "Listado de préstamos pagados";
		ReportePrestamosCatEmpresa ejemplo = new ReportePrestamosCatEmpresa(strTituloPDF, strNombrePDF, "pagados",
				tituloTabla);
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
		String tituloTabla = "Listado de préstamos vencidos";
		ReportePrestamosCatEmpresa ejemplo = new ReportePrestamosCatEmpresa(strTituloPDF, strNombrePDF, "vencidos",
				tituloTabla);
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

			// Tipo de plazo
			// ComboBoxModel jComboEmpresaModel = new DefaultComboBoxModel(
			// new String[] { "Sin categoria", "Semanal", "Impulso", "Supermercados",
			// "Común",
			// "Vendedores", "Don Pollo", "Droguería", "La Locura", "Mr Pompy",
			// "Comunicaciones", "Mocawa", "Hogar infantil", "Otra" });

			String categoria = clienteEncontrado.getEmpresaCliente();
			switch (categoria) {
			case "SIN CATEGORIA":
				jTextEmpresa.setSelectedIndex(0);
				break;
			case "SEMANAL":
				jTextEmpresa.setSelectedIndex(1);
				break;
			case "IMPULSO":
				jTextEmpresa.setSelectedIndex(2);
				break;
			case "SUPERMERCADOS":
				jTextEmpresa.setSelectedIndex(3);
				break;
			case "COMUN":
				jTextEmpresa.setSelectedIndex(4);
				break;
			case "VENDEDORES":
				jTextEmpresa.setSelectedIndex(5);
				break;
			case "DON POLLO":
				jTextEmpresa.setSelectedIndex(6);
				break;
			case "DROGUERIA":
				jTextEmpresa.setSelectedIndex(7);
				break;
			case "LA LOCURA":
				jTextEmpresa.setSelectedIndex(8);
				break;
			case "MR POMPY":
				jTextEmpresa.setSelectedIndex(9);
				break;

			case "COMUNICACIONES":
				jTextEmpresa.setSelectedIndex(10);
				break;
			case "MOCAWA":
				jTextEmpresa.setSelectedIndex(11);
				break;
			case "HOGAR INFANTIL":
				jTextEmpresa.setSelectedIndex(12);
				break;
			case "OTRA":
				jTextEmpresa.setSelectedIndex(13);
				break;
			}

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

		if (abonoEncontrado != null) {
			jTextFieldCodigoAbono.setText(abonoEncontrado.getCodigoAbono());
			Date fechaFormateada;
			Date fechaFormateadaCobro;
			try {
				fechaFormateada = formato.parse(abonoEncontrado.getFechaPago());
				calendarioAbonos.setDate(fechaFormateada);

				// Fecha de cobro
				fechaFormateadaCobro = formato.parse(abonoEncontrado.getFechaACobrar());
				calendarioAbonosCobro.setDate(fechaFormateadaCobro);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			int monto;
			try {
				monto = formatoMoneda.parse(abonoEncontrado.getMontoPagado()).intValue();
				jTextField1.setText((monto / 1000) + "");
			} catch (ParseException e) {

				e.printStackTrace();
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonEditarAbonoActionPerformed");
			}

			jCheckBoxEditandoAbono.setSelected(true);
			calendarioAbonosCobro.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del abono", "Abono no encontrado",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	private void jButtonEditarPrestamoPerformed(ActionEvent evt) {

		String codigoPrestamo = JOptionPane.showInputDialog("Ingrese código del préstamo");
		PrestamoDAO miPrestamoDAO = new PrestamoDAO();
		ClienteDAO miClienteDAO = new ClienteDAO();
		SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);
		PrestamoVO miPrestamo = miPrestamoDAO.buscarPrestamo(codigoPrestamo);
		if (miPrestamo != null) {
			// Relleno los campos con los datos del prestamo encontrado
			jLabelCodigoPrestamoOculto.setText(miPrestamo.getCodigoPrestamo());

			int monto;
			try {
				monto = formatoMoneda.parse(miPrestamo.getMontoPrestamo()).intValue();
				jTextMonto.setText((monto / 1000) + "");
			} catch (ParseException e) {

				e.printStackTrace();
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonEditarPrestamoPerformed");
			}
			jTextTasaInteres.setText(miPrestamo.getTasaInteresPrestamo() + "");

			// Falta la fecha
			Date fechaFormateada = null;
			Date fechaFinFormateada = null;
			try {
				fechaFormateada = formato.parse(miPrestamo.getFechaInicioPrestamo());
				calendarioPrestamos.setDate(fechaFormateada);
				fechaFinFormateada = formato.parse(miPrestamo.getFechafinPrestamo());
				calendarioFinPrestamo.setEnabled(true);
				calendarioFinPrestamo.setDate(fechaFinFormateada);
			} catch (ParseException e) {

				e.printStackTrace();
				error.guardarMensajeError(e.getMessage(),
						this.getClass().getCanonicalName() + ".jButtonEditarPrestamoPerformed");
			}

			// Tipo de plazo
			String tipoPlazo = miPrestamo.getTipoPlazoPrestamo();
			switch (tipoPlazo) {
			case "MENSUAL":
				jComboPlazo.setSelectedIndex(1);
				break;

			case "QUINCENAL":
				jComboPlazo.setSelectedIndex(2);
				break;
			case "SEMANAL":
				jComboPlazo.setSelectedIndex(3);
				break;
			}
			jTextNumeroCuotas.setText(miPrestamo.getNumeroCuotasPrestamo() + "");
			jLabelTotalFormato.setText(miPrestamo.getSaldoPendienteprestamo());

			// El cliente
			ClienteVO miCliente = miClienteDAO.buscarCliente(miPrestamo.getIcodigoClienteFK());
			jLabelNombreCliente.setText(miCliente.getNombreCliente());
			jLabelEmpresaResult.setText(miCliente.getEmpresaCliente());
			jLabelCodigo.setText(miCliente.getCodigoCliente());
			jLabelCodigo.setForeground(Color.RED);
			jCheckBoxEditandoPrestamo.setSelected(true);

		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del préstamo", "Préstamo no encontrado",
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
		case listaPrestamosCliente:
			break;

		}

	}

	// listaClientesEmpresa,
	// listaPrestamosEmpresa, listaPrestamosPlazo, listaPrestamosCliente,
	// listaAbonosCliente,

	private void jComboSeleccionListadoActionPerformed(ActionEvent evt) {

		String listaSeleccionada = (String) jComboSeleccionListado.getSelectedItem();

		AbonoDAO miAbono = new AbonoDAO();
		String titulosAbono[] = miAbono.getColumnas();
		ClienteDAO miCliente = new ClienteDAO();
		String titulosCliente[] = miCliente.getColumnas();
		PrestamoDAO miPrestamo = new PrestamoDAO();
		String titulosPrestamo[] = miPrestamo.getColumnasRequerido();
		MovimientoDAO miMovimiento = new MovimientoDAO();
		String titulosMovimiento[] = miMovimiento.getColumnas();

		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		switch (listaSeleccionada) {
		case seleccioneUno:
			tablaResultados = new JTable();
			jScrollPaneResultados.setViewportView(tablaResultados);
			calendarioInicioMovimiento.setEnabled(false);
			calendarioFinMovimiento.setEnabled(false);
			jTextTotalentradas.setText("");
			jTextTotalSalidas.setText("");
			break;
		case listaClientes:
			miCliente = new ClienteDAO();
			String informacionClientes[][] = miCliente.obtenerMatrizClientes();
			tablaResultados = new JTable(informacionClientes, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thClientes = tablaResultados.getTableHeader();
			thClientes.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesAlfa:
			miCliente = new ClienteDAO();
			String informacionClientesAlfa[][] = miCliente.obtenerMatrizClientesAlfa();
			tablaResultados = new JTable(informacionClientesAlfa, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thClientesAlfa = tablaResultados.getTableHeader();
			thClientesAlfa.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesActivos:
			miCliente = new ClienteDAO();
			String informacionClientesActivos[][] = miCliente.obtenerMatrizClientesActivos();
			tablaResultados = new JTable(informacionClientesActivos, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thClientesActivos = tablaResultados.getTableHeader();
			thClientesActivos.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaClientesNoActivos:
			miCliente = new ClienteDAO();
			String informacionClientesNOActivos[][] = miCliente.obtenerMatrizClientesNOActivos();
			tablaResultados = new JTable(informacionClientesNOActivos, titulosCliente);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thClientesNOActivos = tablaResultados.getTableHeader();
			thClientesNOActivos.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamos:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamos[][] = miPrestamo.obtenerMatrizPrestamosRequerido();
			tablaResultados = new JTable(informacionPrestamos, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thPrestamos = tablaResultados.getTableHeader();
			thPrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosPendientes:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamosPendientes[][] = miPrestamo.obtenerMatrizPrestamosPendientes();
			tablaResultados = new JTable(informacionPrestamosPendientes, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thPrestamosPendientes = tablaResultados.getTableHeader();
			thPrestamosPendientes.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosPagados:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			String informacionPrestamosPagados[][] = miPrestamo.obtenerMatrizPrestamosPagados();
			tablaResultados = new JTable(informacionPrestamosPagados, titulosPrestamo);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thPrestamosPagados = tablaResultados.getTableHeader();
			thPrestamosPagados.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaPrestamosVencidos:
			miPrestamo = new PrestamoDAO();
			String informacionPrestamosVencidos[][] = miPrestamo.obtenerMatrizPrestamosVencidos();
			if (informacionPrestamosVencidos != null) {
				tablaResultados = new JTable(informacionPrestamosVencidos, titulosPrestamo);
				jScrollPaneResultados.setViewportView(tablaResultados);
				tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
				JTableHeader thPrestamosVencidos = tablaResultados.getTableHeader();
				thPrestamosVencidos.setFont(new java.awt.Font("Arial", 0, 14));
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
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thAbonos = tablaResultados.getTableHeader();
			thAbonos.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaAbonosPendientes:
			miAbono = new AbonoDAO();
			String informacionAbonosPendientes[][] = miAbono.obtenerMatrizAbonosPendientes();
			tablaResultados = new JTable(informacionAbonosPendientes, titulosAbono);
			jScrollPaneResultados.setViewportView(tablaResultados);
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			JTableHeader thAbonosPen = tablaResultados.getTableHeader();
			thAbonosPen.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaAbonosPagados:
			miAbono = new AbonoDAO();
			String informacionAbonosPagados[][] = miAbono.obtenerMatrizAbonosPagados();
			tablaResultados = new JTable(informacionAbonosPagados, titulosAbono);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thAbonosPag = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			thAbonosPag.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			break;
		case listaMovimientos:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientos[][] = miMovimiento.obtenerMatrizMovimientos();
			tablaResultados = new JTable(informacionMovimientos, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientos = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			thMovimientos.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas()) + "");
			jTextTotalSalidas.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas()) + "");
			jLabelTotalSalidas.setText("Total salidas:");

			break;
		case listaMovimientosEntrada:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientosEntrada[][] = miMovimiento.obtenerMatrizMovimientosEntrada();
			tablaResultados = new JTable(informacionMovimientosEntrada, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientosEntrada = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			thMovimientosEntrada.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas()) + "");
			jTextTotalSalidas.setText("");
			jLabelTotalSalidas.setText("Total salidas:");
			break;
		case listaMovimientosSalida:
			miMovimiento = new MovimientoDAO();
			String informacionMovimientosSalida[][] = miMovimiento.obtenerMatrizMovimientosSalida();
			tablaResultados = new JTable(informacionMovimientosSalida, titulosMovimiento);
			jScrollPaneResultados.setViewportView(tablaResultados);
			JTableHeader thMovimientosSalida = tablaResultados.getTableHeader();
			tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
			thMovimientosSalida.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(tablaResultados);
			jTextTotalentradas.setText("");
			jTextTotalSalidas.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas()) + "");
			jLabelTotalSalidas.setText("Total salidas:");
			break;
		case listaMovimientosFechas:
			calendarioInicioMovimiento.setEnabled(true);
			calendarioFinMovimiento.setEnabled(true);
			jButtonBuscarMovimientos.setEnabled(true);
			jTextTotalentradas.setText("");
			jTextTotalSalidas.setText("");
			jLabelTotalSalidas.setText("Total salidas:");
			break;
		case listaPrestamosEmpresa:
			jComboBoxCategoriaEmpresa.setEnabled(true);
			break;
		case listaPrestamosCliente:
			String codigoCliente = JOptionPane.showInputDialog("Ingrese código del cliente");
			miPrestamo = new PrestamoDAO();
			ClienteVO cliente = miCliente.buscarCliente(codigoCliente);
			if (cliente.getCodigoCliente() == null) {
				JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
			} else {

				miPrestamo.actualizaPagos();
				informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequeridoCliente(codigoCliente);
				jTablePrestamos = new JTable(informacionPrestamos, titulosPrestamo);
				jScrollPaneResultados.setViewportView(jTablePrestamos);
				jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
				JTableHeader thPrestCli = jTablePrestamos.getTableHeader();
				thPrestCli = jTablePrestamos.getTableHeader();
				thPrestCli.setFont(new java.awt.Font("Arial", 0, 14));
				ajustaColumnasAContenido(jTablePrestamos);
			}
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

		// Movimientos entre fechas seleccionado
		if (jComboSeleccionListado.getSelectedIndex() == 15) {

			if (fechaInicio != null && fechaFin != null) {

				miMovimiento = new MovimientoDAO();
				String informacionMovimientosFechas[][] = miMovimiento.obtenerMatrizMovimientosFechas(fechaInicio,
						fechaFin);
				tablaResultados = new JTable(informacionMovimientosFechas, titulosMovimiento);
				jScrollPaneResultados.setViewportView(tablaResultados);
				JTableHeader thMovimientos = tablaResultados.getTableHeader();
				tablaResultados.setFont(new java.awt.Font("Arial", 0, 14));
				thMovimientos.setFont(new java.awt.Font("Arial", 0, 14));
				ajustaColumnasAContenido(tablaResultados);
				jTextTotalentradas
						.setText(formatoMoneda.format(miMovimiento.calcularTotalEntradas(fechaInicio, fechaFin)) + "");
				jTextTotalSalidas
						.setText(formatoMoneda.format(miMovimiento.calcularTotalSalidas(fechaInicio, fechaFin)) + "");
				jLabelTotalSalidas.setText("Total salidas:");
				calendarioInicioMovimiento.setEnabled(false);
				calendarioFinMovimiento.setEnabled(false);
				jButtonBuscarMovimientos.setEnabled(false);
				return;

			} else {
				JOptionPane.showMessageDialog(this, "Debe especificar una fecha de inicio y una final", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	private void jTabPestaniasMouseClicked(MouseEvent evt) {
		actualizaReportes();
	}

	private void jButtonVerTodosAbonoActionPerformed(ActionEvent evt) {
		actualizaAbonos();
	}

	// seleccioneUna, SinCategoria, Semanal, Impulso, Supermercados, Comun,
	// Vendedores,
	// DonPollo, Drogueria, LaLocura, MrPompy, Comunicaciones, Mocawa,
	// Hogarinfantil, Otro

	private void jComboBoxCategoriaEmpresaActionPerformed(ActionEvent evt) {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		String titulos[] = miPrestamo.getColumnasRequerido();
		String informacionPrestamos[][] = null;
		JTableHeader th = null;

		String categoriaSeleccionada = (String) jComboBoxCategoriaEmpresa.getSelectedItem();
		switch (categoriaSeleccionada) {
		case seleccioneUna:
			JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			tablaResultados = new JTable();
			jScrollPaneResultados.setViewportView(tablaResultados);
			break;
		case SinCategoria:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(SinCategoria);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Semanal:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Semanal);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Impulso:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Impulso);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Supermercados:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Supermercados);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Comun:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Comun);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Vendedores:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Vendedores);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case DonPollo:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(DonPollo);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Drogueria:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Drogueria);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case LaLocura:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(LaLocura);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case MrPompy:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(MrPompy);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Comunicaciones:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Comunicaciones);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Mocawa:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Mocawa);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Hogarinfantil:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Hogarinfantil);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		case Otro:
			miPrestamo = new PrestamoDAO();
			miPrestamo.actualizaPagos();
			informacionPrestamos = miPrestamo.obtenerMatrizPrestamosRequerido(Otro);
			jTablePrestamos = new JTable(informacionPrestamos, titulos);
			jScrollPaneResultados.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 14));
			th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 14));
			ajustaColumnasAContenido(jTablePrestamos);

			break;
		}
	}

	private void jButtonEliminarPrestamoActionPerformed(ActionEvent evt) {

		PrestamoDAO miPrestamoDAO = new PrestamoDAO();
		String codigoPrestamo = JOptionPane.showInputDialog("Ingrese código del préstamo");
		PrestamoVO miPrestamo = miPrestamoDAO.buscarPrestamo(codigoPrestamo);
		if (miPrestamo != null) {
			miPrestamoDAO.eliminarPrestamo(codigoPrestamo);
			JOptionPane.showMessageDialog(this, "Préstamo eliminado con éxito", "Eliminación exitosa",
					JOptionPane.INFORMATION_MESSAGE);
			miPrestamoDAO.actualizaPagos();
			actualizaTodo();

		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del préstamo", "Préstamo no encontrado",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {

		String categoriaSeleccionada = (String) jComboBoxCategoriaEmpresa.getSelectedItem();
		switch (categoriaSeleccionada) {
		case seleccioneUna:
			JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			tablaResultados = new JTable();
			jScrollPaneResultados.setViewportView(tablaResultados);
			break;
		case SinCategoria:
			generarReportePrestamosPorEmpresa(SinCategoria);
			break;
		case Semanal:
			generarReportePrestamosPorEmpresa(Semanal);
			break;
		case Impulso:
			generarReportePrestamosPorEmpresa(Impulso);
			break;
		case Supermercados:
			generarReportePrestamosPorEmpresa(Supermercados);
			break;
		case Comun:
			generarReportePrestamosPorEmpresa(Comun);
			break;
		case Vendedores:
			generarReportePrestamosPorEmpresa(Vendedores);
			break;
		case DonPollo:
			generarReportePrestamosPorEmpresa(DonPollo);
			break;
		case Drogueria:
			generarReportePrestamosPorEmpresa(Drogueria);
			break;
		case LaLocura:
			generarReportePrestamosPorEmpresa(LaLocura);
			break;
		case MrPompy:
			generarReportePrestamosPorEmpresa(MrPompy);
			break;
		case Comunicaciones:
			generarReportePrestamosPorEmpresa(Comunicaciones);
			break;
		case Mocawa:
			generarReportePrestamosPorEmpresa(Mocawa);
			break;
		case Hogarinfantil:
			generarReportePrestamosPorEmpresa(Hogarinfantil);
			break;
		case Otro:
			generarReportePrestamosPorEmpresa(Otro);
			break;
		}
	}

}
