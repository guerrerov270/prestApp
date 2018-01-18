package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import co.prestapp.DAO.PrestamoDAO;
import co.prestapp.VO.AbonoVO;
import co.prestapp.VO.ClienteVO;
import co.prestapp.connection.DBBackup;
import co.prestapp.reports.ReporteAbonos;
import co.prestapp.reports.ReporteAbonosPagados;
import co.prestapp.reports.ReporteAbonosPendientes;
import co.prestapp.reports.ReporteClientes;
import co.prestapp.reports.ReportePrestamos;

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
	private JComboBox jComboSeleccionListado;
	private JLabel jLabelSeleccioneListado;
	private JScrollPane jScrollPaneResultados;
	private JPanel jPanListaResultados;
	private JPanel jPaneSeleccionListado;
	private JPanel jPaneListados;
	private JLabel jLabelCodigoCliente;
	private JButton jButtonGuardarEdicionCliente;
	private JButton jButtonEditarCliente;
	private JMenuItem jMenuItemReporteAbonosPagados;
	private JMenuItem jMenuItemReporteabonosPendientes;
	private JMenu jMenuReportes;
	private JMenuItem jMenuItemReporteAbonos;
	private JMenuItem jMenuItemReportePrestamos;
	private JMenuItem jMenuItemReporteClientes;
	private JMenuItem jMenuItemBackup;
	private JMenu jMenuBackup;
	private JMenuBar jMenuBarOpciones;
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
	private JButton jButtonPrestamosPendientes;
	private JButton jButtonGuardar;
	private JTextField jTextCodigoPrestamo;
	private JLabel jLabelCodigoPrestamo;
	private JLabel jLabelFecha;
	private JTextField jTextField1;
	private JLabel jLabelMonto;
	private JTable jTableAbonosRecibidos;
	private JScrollPane jScrollAbonosRecibidos;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboFechasCobro;
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
	@SuppressWarnings("unused")
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
		actualizaReportes();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("PrestApp 1.0");
			this.setFont(new java.awt.Font("Arial", 0, 16));
			this.setResizable(false);
			{
				jMenuBarOpciones = new JMenuBar();
				setJMenuBar(jMenuBarOpciones);
				jMenuBarOpciones.add(getJMenuBackup());
				jMenuBarOpciones.add(getJMenuReportes());
			}
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
						jScrollReportes.setPreferredSize(new java.awt.Dimension(911, 354));
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
							jLabelMontoPrestamo.setText("Monto préstamo:  $");
							jLabelMontoPrestamo.setBounds(17, 30, 178, 23);
							jLabelMontoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							// MaskFormatter formatoMoneda= new
							// MaskFormatter("$ ###,###");
							jTextMonto = new JFormattedTextField();
							jPanelEntradasPrestamo.add(jTextMonto, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextMonto.setBounds(162, 30, 178, 23);
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
								URL urlDeLaImagenActualizar = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/actualizar.png");
								ImageIcon iconoActualizar = new ImageIcon(urlDeLaImagenActualizar);
								Image imgActualizar = iconoActualizar.getImage();
								Image otraimgActualizar = imgActualizar.getScaledInstance(30, 30,
										java.awt.Image.SCALE_SMOOTH);
								jButton2 = new JButton();
								jPanelEntradasPrestamo.add(jButton2);
								jButton2.setIcon(new ImageIcon(otraimgActualizar));
								jButton2.setText("Todos");
								jButton2.setBounds(296, 157, 130, 30);
								jButton2.setFont(new java.awt.Font("Arial", 0, 14));
								jButton2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButton2ActionPerformed(evt);
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
								URL urlDeLaImagenNoPagado = VentanaPrincipal.class.getClassLoader()
										.getResource("co/prestapp/res/noPagado.png");
								ImageIcon iconoNoPagado = new ImageIcon(urlDeLaImagenNoPagado);
								Image imgNoPagado = iconoNoPagado.getImage();
								Image otraimgNoPagado = imgNoPagado.getScaledInstance(30, 30,
										java.awt.Image.SCALE_SMOOTH);
								jButtonPrestamosPendientes = new JButton();
								jPanelEntradasPrestamo.add(jButtonPrestamosPendientes);
								jButtonPrestamosPendientes.setIcon(new ImageIcon(otraimgNoPagado));
								jButtonPrestamosPendientes.setText("Vencidos");
								jButtonPrestamosPendientes.setFont(new java.awt.Font("Arial", 0, 14));
								jButtonPrestamosPendientes.setBounds(431, 157, 150, 30);
								jButtonPrestamosPendientes.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										jButtonPrestamosPendientesActionPerformed(evt);
									}
								});

							}

						}
					}
					jTabPestanias.addTab("Abonos", jPanelAbonos);
					jPanelAbonos.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollAbonosRecibidos = new JScrollPane();
						jPanelAbonos.add(jScrollAbonosRecibidos, BorderLayout.SOUTH);
						jScrollAbonosRecibidos.setBounds(8, 263, 777, 381);
						jScrollAbonosRecibidos.setPreferredSize(new java.awt.Dimension(911, 354));
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
							jTextField1.setBounds(748, 78, 146, 23);
							jTextField1.setFont(new java.awt.Font("Arial", 0, 16));
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
							jButtonCancelarAbono.setBounds(195, 147, 145, 30);
							jButtonCancelarAbono.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonCancelarAbono.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									jButtonCancelarAbonoActionPerformed(e);

								}
							});

						}
						{
							jPanelAgregarAbono.add(getJButtonBuscarPrestamo());
						}
						{
							jPanelAgregarAbono.add(getJButtonActualizarAbonos());
						}
						{
							jPanelAgregarAbono.add(getJLabelCodigoAbono());
						}
						{
							jPanelAgregarAbono.add(getJTextFieldCodigoAbono());
						}
						{
							jPanelAgregarAbono.add(getJButtonAbonosPagados());
						}
						{
							jPanelAgregarAbono.add(getJButtonAbonosPendientes());
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
						jScrollPaneClientes.setPreferredSize(new java.awt.Dimension(911, 354));
						{

						}
					}
					{
						jPanelAgregarCliente = new JPanel();
						jPanelClientes.add(jPanelAgregarCliente, BorderLayout.NORTH);
						jPanelAgregarCliente.setPreferredSize(new java.awt.Dimension(903, 182));
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
							jButtonGuardarCliente.setBounds(12, 125, 130, 30);
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
							jButtonCancelar.setBounds(570, 125, 130, 30);
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
									.getResource("co/prestapp/res/actualizar.png");
							ImageIcon icono = new ImageIcon(urlDeLaImagen);
							Image img = icono.getImage();
							Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonActualizar = new JButton();
							jPanelAgregarCliente.add(jButtonActualizar);
							jButtonActualizar.setIcon(new ImageIcon(otraimg));
							jButtonActualizar.setText("Todos");
							jButtonActualizar.setBounds(757, 125, 130, 30);
							jButtonActualizar.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonActualizar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonActualizarActionPerformed(evt);
								}
							});

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
							jButtonEditarCliente.setBounds(198, 125, 130, 30);
							jButtonEditarCliente.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonEditarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonEditarClienteActionPerformed(evt);
								}
							});

						}
						{
							URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader()
									.getResource("co/prestapp/res/guardar.png");
							ImageIcon icono1 = new ImageIcon(urlDeLaImagen);
							Image img1 = icono1.getImage();
							Image otraimg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
							jButtonGuardarEdicionCliente = new JButton();
							jPanelAgregarCliente.add(jButtonGuardarEdicionCliente);
							jButtonGuardarEdicionCliente.setIcon(new ImageIcon(otraimg1));
							jButtonGuardarEdicionCliente.setText("Guardar edición");
							jButtonGuardarEdicionCliente.setBounds(358, 125, 181, 30);
							jButtonGuardarEdicionCliente.setFont(new java.awt.Font("Arial", 0, 14));
							jButtonGuardarEdicionCliente.setEnabled(false);
							jButtonGuardarEdicionCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarEdicionClienteActionPerformed(evt);
								}

							});

						}
						{
							jLabelCodigoCliente = new JLabel();
							jPanelAgregarCliente.add(jLabelCodigoCliente);
							jLabelCodigoCliente.setBounds(12, 65, 65, 10);

						}
					}
					jTabPestanias.addTab("Reportes", jPanelReportes);
					jPanelReportes.setFont(new java.awt.Font("Arial", 0, 16));
					{
						jScrollPaneReportesPorFecha = new JScrollPane();
						jPanelReportes.add(jScrollPaneReportesPorFecha, BorderLayout.SOUTH);
						jScrollPaneReportesPorFecha.setBounds(82, 316, 740, 197);
						jScrollPaneReportesPorFecha.setPreferredSize(new java.awt.Dimension(905, 214));
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

					jTabPestanias.addTab("Listados", jPaneListados);
					jPaneListados.setFont(new java.awt.Font("Arial", 0, 16));
					{
						// Panel superior
						jPaneSeleccionListado = new JPanel();
						jPaneListados.add(jPaneSeleccionListado, BorderLayout.NORTH);
						jPaneSeleccionListado.setPreferredSize(new java.awt.Dimension(909, 127));
						jPaneSeleccionListado.setBorder(BorderFactory.createTitledBorder("Listados"));
						jPaneSeleccionListado.setLayout(null);
						{
							// Componentes del panel superior
							jLabelSeleccioneListado = new JLabel();
							jPaneSeleccionListado.add(jLabelSeleccioneListado);
							jLabelSeleccioneListado.setText("Seleccione listado:");
							jLabelSeleccioneListado.setBounds(23, 44, 179, 25);

							jComboSeleccionListado = new JComboBox();
							jPaneSeleccionListado.add(jComboSeleccionListado);
							jComboSeleccionListado.setBounds(241, 46, 176, 23);
						}
					}
					{
						// Panel inferior
						jPanListaResultados = new JPanel();
						jPaneListados.add(jPanListaResultados, BorderLayout.SOUTH);
						jPanListaResultados.setPreferredSize(new java.awt.Dimension(909, 424));
						jPanListaResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
						{
							// Componentes del panel inferior
							jScrollPaneResultados = new JScrollPane();
							jPanListaResultados.add(jScrollPaneResultados);
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

	@SuppressWarnings("unchecked")
	public void limpiarCamposPrestamo() {

		jTextMonto.setText("");
		jTextTasaInteres.setText("");
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		modelo.addElement("Nada para mostrar");
		jComboFechasCobro.setModel(modelo);
		jTextNumeroCuotas.setText("");
		jLabelTotalFormato.setText("");
		jComboPlazo.setSelectedIndex(0);
		jLabelNombreCliente.setText("Nombre");
		jLabelCodigo.setText("Código");
		jLabelEmpresaResult.setText("Empresa");

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
				montoPrestamo = Float.parseFloat(jTextMonto.getText());
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
			JOptionPane.showMessageDialog(this, "El préstamo se ha creado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCamposPrestamo();
			actualizaPrestamos();
			actualizaReportes();
		}

	}

	/**
	 * Actualiza la tabla de prestamos
	 * 
	 * @param evt
	 */
	private void jButton2ActionPerformed(ActionEvent evt) {

		actualizaPrestamos();
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

	private JButton getJButtonBuscarPrestamo() {
		if (jButtonBuscarPrestamo == null) {
			URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader().getResource("co/prestapp/res/buscar.png");
			ImageIcon icono = new ImageIcon(urlDeLaImagen);
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon otroicon = new ImageIcon(otraimg);
			jButtonBuscarPrestamo = new JButton(otroicon);
			jButtonBuscarPrestamo.setText("Buscar");
			jButtonBuscarPrestamo.setBounds(376, 25, 130, 30);
			jButtonBuscarPrestamo.setFont(new java.awt.Font("Arial", 0, 14));
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
			URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader().getResource("co/prestapp/res/actualizar.png");
			ImageIcon icono = new ImageIcon(urlDeLaImagen);
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jButtonActualizarAbonos = new JButton();
			jButtonActualizarAbonos.setIcon(new ImageIcon(otraimg));
			jButtonActualizarAbonos.setText("Todos");
			jButtonActualizarAbonos.setBounds(381, 147, 130, 30);
			jButtonActualizarAbonos.setFont(new java.awt.Font("Arial", 0, 14));
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
			jLabelCodigoAbono.setBounds(381, 78, 178, 23);
			jLabelCodigoAbono.setFont(new java.awt.Font("Arial", 0, 16));
		}
		return jLabelCodigoAbono;
	}

	private JTextField getJTextFieldCodigoAbono() {
		if (jTextFieldCodigoAbono == null) {
			jTextFieldCodigoAbono = new JTextField();
			jTextFieldCodigoAbono.setBounds(496, 78, 71, 23);
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
		Date fechaPago = null;
		String codigoAbono = "";
		double montoPagado = 0;

		if (validarCamposAbonoPrestamo()) {
			fechaPago = calendarioAbonos.getDate();
			codigoAbono = jTextFieldCodigoAbono.getText();
			montoPagado = Double.parseDouble(jTextField1.getText()) * 1000;
			miAbonoVO = miAbono.buscarAbono(codigoAbono);
			if (miAbonoVO == null) {
				JOptionPane.showMessageDialog(this, "No se ha podido encontrar el abono", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				miAbono.pagarAbono(codigoAbono, fechaPago, montoPagado);
				actualizaAbonos();
				actualizaPrestamos();
				actualizaAbonosPagados();
				actualizaReportes();
				JOptionPane.showMessageDialog(this, "Abono guardado correctamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(this, "No se ha podido guardar el abono", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void jButtonCancelarAbonoActionPerformed(ActionEvent e) {

	}

	private JButton getJButtonAbonosPagados() {
		if (jButtonAbonosPagados == null) {
			URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader().getResource("co/prestapp/res/pagado.png");
			ImageIcon icono = new ImageIcon(urlDeLaImagen);
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jButtonAbonosPagados = new JButton();
			jButtonAbonosPagados.setIcon(new ImageIcon(otraimg));
			jButtonAbonosPagados.setText("Pagados");
			jButtonAbonosPagados.setBounds(567, 147, 145, 30);
			jButtonAbonosPagados.setFont(new java.awt.Font("Arial", 0, 14));
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
			URL urlDeLaImagen = VentanaPrincipal.class.getClassLoader().getResource("co/prestapp/res/noPagado.png");
			ImageIcon icono = new ImageIcon(urlDeLaImagen);
			Image img = icono.getImage();
			Image otraimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			jButtonAbonosPendientes = new JButton();
			jButtonAbonosPendientes.setIcon(new ImageIcon(otraimg));
			jButtonAbonosPendientes.setText("Pendientes");
			jButtonAbonosPendientes.setBounds(738, 147, 150, 30);
			jButtonAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 14));
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
		ajustaColumnasAContenido(jTableAbonosRecibidos);
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

	private void actualizaPrestamoVencido() {

		PrestamoDAO miPrestamo = new PrestamoDAO();
		String informacionAbonos[][] = miPrestamo.obtenerMatrizPrestamosVencidos();
		if (informacionAbonos != null) {
			String titulos[] = miPrestamo.getColumnas();
			jTablePrestamos = new JTable(informacionAbonos, titulos);
			jScrollReportes.setViewportView(jTablePrestamos);
			jTablePrestamos.setFont(new java.awt.Font("Arial", 0, 16));
			JTableHeader th = jTablePrestamos.getTableHeader();
			th.setFont(new java.awt.Font("Arial", 0, 16));
			ajustaColumnasAContenido(jTablePrestamos);

		} else {
			System.out.println("Lista de abonos no encontrada");
			JOptionPane.showMessageDialog(this, "Préstamos no encontrados", "Alerta", JOptionPane.WARNING_MESSAGE);
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

	private void jButtonPrestamosPendientesActionPerformed(ActionEvent evt) {

		actualizaPrestamoVencido();
	}

	private void jButtonPrestamoPorFechaActionPerformed(ActionEvent evt) {

		Date fechaIngresada = calendarioPrestamosPorfecha.getDate();
		if (fechaIngresada != null) {
			actualizaPrestamosPorFecha();
		} else {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha para la búsqueda", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void jButtonAbonoPorFechaActionPerformed(ActionEvent evt) {

		Date fechaIngresada = calendarioAbonosPorFecha.getDate();
		if (fechaIngresada != null) {
			actualizaAbonosPorFecha();
		} else {
			JOptionPane.showMessageDialog(this, "Debe especificar una fecha para la búsqueda", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private JMenu getJMenuBackup() {
		if (jMenuBackup == null) {
			jMenuBackup = new JMenu();
			jMenuBackup.setText("Opciones");
			jMenuBackup.add(getJMenuItemBackup());

		}
		return jMenuBackup;
	}

	private JMenuItem getJMenuItemBackup() {
		if (jMenuItemBackup == null) {
			jMenuItemBackup = new JMenuItem();
			jMenuItemBackup.setText("Crear copia de seguridad");
			jMenuItemBackup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemBackupActionPerformed(evt);
				}
			});
		}
		return jMenuItemBackup;
	}

	private void jMenuItemBackupActionPerformed(ActionEvent evt) {

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

	private JMenuItem getJMenuItemReporteClientes() {
		if (jMenuItemReporteClientes == null) {
			jMenuItemReporteClientes = new JMenuItem();
			jMenuItemReporteClientes.setText("Reporte de clientes");
			jMenuItemReporteClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemReporteClientesActionPerformed(evt);
				}
			});
		}
		return jMenuItemReporteClientes;
	}

	private void jMenuItemReporteClientesActionPerformed(ActionEvent evt) {
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

		String strNombrePDF = "ReporteClientes.pdf";
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

	public String concatenaCero(int parametro) {
		String resultado = "";
		if (parametro < 10) {
			resultado = "0" + parametro + "";
		} else {
			resultado = parametro + "";
		}
		return resultado;
	}

	private JMenuItem getJMenuItemReportePrestamos() {
		if (jMenuItemReportePrestamos == null) {
			jMenuItemReportePrestamos = new JMenuItem();
			jMenuItemReportePrestamos.setText("Reporte de préstamos");
			jMenuItemReportePrestamos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemReportePrestamosActionPerformed(evt);
				}
			});
		}
		return jMenuItemReportePrestamos;
	}

	private void jMenuItemReportePrestamosActionPerformed(ActionEvent evt) {

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

		String strNombrePDF = "ReportePrestamos.pdf";
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

	private JMenuItem getJMenuItemReporteAbonos() {
		if (jMenuItemReporteAbonos == null) {
			jMenuItemReporteAbonos = new JMenuItem();
			jMenuItemReporteAbonos.setText("Reporte de abonos");
			jMenuItemReporteAbonos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemReporteAbonosActionPerformed(evt);
				}
			});
		}
		return jMenuItemReporteAbonos;
	}

	private void jMenuItemReporteAbonosActionPerformed(ActionEvent evt) {

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

		String strNombrePDF = "ReporteAbonos.pdf";
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

	private JMenu getJMenuReportes() {
		if (jMenuReportes == null) {
			jMenuReportes = new JMenu();
			jMenuReportes.setText("Reportes");
			jMenuReportes.add(getJMenuItemReporteClientes());
			jMenuReportes.add(getJMenuItemReportePrestamos());
			jMenuReportes.add(getJMenuItemReporteAbonos());
			jMenuReportes.add(getJMenuItemReporteabonosPendientes());
			jMenuReportes.add(getJMenuItemReporteAbonosPagados());
		}
		return jMenuReportes;
	}

	private JMenuItem getJMenuItemReporteabonosPendientes() {
		if (jMenuItemReporteabonosPendientes == null) {
			jMenuItemReporteabonosPendientes = new JMenuItem();
			jMenuItemReporteabonosPendientes.setText("Reporte de abonos pendientes");
			jMenuItemReporteabonosPendientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemReporteAbonosPendientesActionPerformed(evt);
				}
			});
		}
		return jMenuItemReporteabonosPendientes;
	}

	private void jMenuItemReporteAbonosPendientesActionPerformed(ActionEvent evt) {

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

		String strNombrePDF = "ReporteAbonosPendientes.pdf";
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

	private JMenuItem getJMenuItemReporteAbonosPagados() {
		if (jMenuItemReporteAbonosPagados == null) {
			jMenuItemReporteAbonosPagados = new JMenuItem();
			jMenuItemReporteAbonosPagados.setText("Reporte de abonos pagados");
			jMenuItemReporteAbonosPagados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemReporteAbonosPagadosActionPerformed(evt);
				}
			});
		}
		return jMenuItemReporteAbonosPagados;
	}

	private void jMenuItemReporteAbonosPagadosActionPerformed(ActionEvent evt) {

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

		String strNombrePDF = "ReporteAbonosPagados.pdf";
		String strTituloPDF = "Reporte de abonos pagados, generado el: " + diaS + "/" + mesS + "/" + anio + "  a las "
				+ " " + horaS + ":" + minutoS + ":" + segundoS;
		ReporteAbonosPagados ejemplo = new ReporteAbonosPagados(strTituloPDF, strNombrePDF);
		// Preguntar al usuario si desea abrir el documento PDF
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Se ha generado el documento " + strNombrePDF + ", ¿Desea abrirlo?", "Pregunta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// Si la respuesta es SI, abrirlo
		if (respuesta == JOptionPane.YES_OPTION)
			ejemplo.abrirPDF();

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
			jButtonGuardarEdicionCliente.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Verifique el código del cliente", "Cliente no encontrado",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	private void jButtonGuardarEdicionClienteActionPerformed(ActionEvent evt) {

		ClienteDAO miCliente = new ClienteDAO();

		String codigoCliente = jLabelCodigoCliente.getText();
		String nombre = jTextNombre.getText();
		String empresa = jTextEmpresa.getText();
		String referencia = jTextReferencia.getText();
		miCliente.editarCliente(codigoCliente, nombre, empresa, referencia);
		JOptionPane.showMessageDialog(this, "Cliente editado con éxito", "Edición exitosa",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarCamposCliente();
		jButtonGuardarEdicionCliente.setEnabled(false);
		actualizaClientes();

	}

}
