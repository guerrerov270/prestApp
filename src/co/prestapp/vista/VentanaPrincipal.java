package co.prestapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingUtilities;

import co.prestapp.DAO.AbonoDAO;
import co.prestapp.DAO.ClienteDAO;
import co.prestapp.DAO.PrestamoDAO;
import co.prestapp.VO.AbonoVO;
import co.prestapp.VO.ClienteVO;

import com.toedter.calendar.JDateChooser;

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
					jTabPestanias = new JTabbedPane();
					jPanelContenedor.add(jTabPestanias, BorderLayout.CENTER);
					jTabPestanias.setBounds(8, 5, 782, 553);

					jTabPestanias.addTab("Préstamos", jPanelPrestamos);
					jPanelPrestamos.setPreferredSize(new java.awt.Dimension(921, 547));
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
							jLabelMontoPrestamo.setText("Monto préstamo:");
							jLabelMontoPrestamo.setBounds(17, 35, 178, 23);
							jLabelMontoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							// MaskFormatter formatoMoneda= new
							// MaskFormatter("$ ###,###");
							jTextMonto = new JFormattedTextField();
							jPanelEntradasPrestamo.add(jTextMonto, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextMonto.setBounds(162, 35, 178, 23);
							jTextMonto.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelTasaInteres = new JLabel();
							jPanelEntradasPrestamo.add(jLabelTasaInteres, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelTasaInteres.setText("Tasa interés:");
							jLabelTasaInteres.setBounds(362, 35, 178, 23);
							jLabelTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextTasaInteres = new JTextField();
							jPanelEntradasPrestamo.add(jTextTasaInteres, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jTextTasaInteres.setBounds(477, 35, 71, 23);
							jTextTasaInteres.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jLabelPocentaje = new JLabel();
							jPanelEntradasPrestamo.add(jLabelPocentaje, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jLabelPocentaje.setText("%");
							jLabelPocentaje.setBounds(548, 36, 64, 23);
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
							jLabelFechaInicio.setBounds(579, 35, 178, 23);
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
							jButtonAceptar = new JButton();
							jPanelEntradasPrestamo.add(jButtonAceptar, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							{
								JButton jButtonCancelarPrestamo = new JButton();
								jPanelEntradasPrestamo.add(jButtonCancelarPrestamo);
								jButtonCancelarPrestamo.setText("Cancelar");
								jButtonCancelarPrestamo.setBounds(162, 161, 137, 23);
								jButtonCancelarPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
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
								jLabelCliente.setBounds(579, 121, 132, 23);
								jLabelCliente.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelTotalPago = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalPago);
								jLabelTotalPago.setText("Total a pagar:");
								jLabelTotalPago.setBounds(362, 121, 116, 23);
								jLabelTotalPago.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jLabelTotalFormato = new JLabel();
								jPanelEntradasPrestamo.add(jLabelTotalFormato);
								jLabelTotalFormato.setBounds(476, 121, 178, 23);
								jLabelTotalFormato.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{
								jButtonClienteExiste = new JButton();
								jPanelEntradasPrestamo.add(jButtonClienteExiste);
								jButtonClienteExiste.setText("Buscar cliente");
								jButtonClienteExiste.setBounds(726, 78, 132, 23);
								jButtonClienteExiste.setFont(new java.awt.Font("Arial", 0, 16));
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
								calendarioPrestamos.setBounds(726, 35, 178, 23);
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
								jLabelCodigo.setBounds(579, 161, 121, 23);
								jLabelCodigo.setFont(new java.awt.Font("Arial", 0, 16));
							}
							{

								jComboFechasCobro = new JComboBox();
								jPanelEntradasPrestamo.add(jComboFechasCobro);
								DefaultComboBoxModel modelo = new DefaultComboBoxModel();
								modelo.addElement("Nada para mostrar");
								jComboFechasCobro.setModel(modelo);
								jPanelEntradasPrestamo.add(getJButtonCalcular());
								jPanelEntradasPrestamo.add(getJButton2());
								jPanelEntradasPrestamo.add(getJLabelEmpresaResult());
								jComboFechasCobro.setBounds(162, 121, 178, 23);
								jComboFechasCobro.setFont(new java.awt.Font("Arial", 0, 16));
							}

							jButtonAceptar.setText("Guardar");
							jButtonAceptar.setBounds(17, 161, 137, 23);
							jButtonAceptar.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonAceptar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonAceptarActionPerformed(evt);
								}
							});
						}
					}
					jTabPestanias.addTab("Abonos", jPanelAbonos);
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
							jLabelCodigoPrestamo.setBounds(17, 35, 178, 23);
							jLabelCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jTextCodigoPrestamo = new JTextField();
							jPanelAgregarAbono.add(jTextCodigoPrestamo);
							jTextCodigoPrestamo.setBounds(162, 35, 178, 23);
							jTextCodigoPrestamo.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jButtonGuardar = new JButton();
							jPanelAgregarAbono.add(jButtonGuardar);
							jButtonGuardar.setText("Guardar");
							jButtonGuardar.setBounds(14, 161, 137, 23);
							jButtonGuardar.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonGuardar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarAbonoActionPerformed(evt);
								}
							});
						}
						{
							jButtonCancelarAbono = new JButton();
							jPanelAgregarAbono.add(jButtonCancelarAbono);
							jPanelAgregarAbono.add(getJButtonBuscarPrestamo());
							jPanelAgregarAbono.add(getJButtonActualizarAbonos());
							jPanelAgregarAbono.add(getJLabelCodigoAbono());
							jPanelAgregarAbono.add(getJTextFieldCodigoAbono());
							jPanelAgregarAbono.add(getJButtonAbonosPagados());
							jPanelAgregarAbono.add(getJButtonAbonosPendientes());
							jButtonCancelarAbono.setText("Cancelar");
							jButtonCancelarAbono.setBounds(197, 161, 137, 23);
							jButtonCancelarAbono.setFont(new java.awt.Font("Arial", 0, 16));
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
							jTextEmpresa.setBounds(401, 19, 178, 23);
							jTextEmpresa.setFont(new java.awt.Font("Arial", 0, 16));
						}
						{
							jButtonGuardarCliente = new JButton();
							jPanelAgregarCliente.add(jButtonGuardarCliente);
							jButtonGuardarCliente.setText("Guardar");
							jButtonGuardarCliente.setBounds(14, 144, 140, 21);
							jButtonGuardarCliente.setFont(new java.awt.Font("Arial", 0, 16));
							jButtonGuardarCliente.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									jButtonGuardarClienteActionPerformed(evt);
								}
							});
						}
						{
							jButtonCancelar = new JButton();
							jPanelAgregarCliente.add(jButtonCancelar);
							jButtonCancelar.setText("Cancelar");
							jButtonCancelar.setBounds(196, 144, 140, 21);
							jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 16));
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
							jPanelAgregarCliente.add(getJButtonActualizar());
							jTextReferencia.setBounds(708, 19, 178, 23);
							jTextReferencia.setFont(new java.awt.Font("Arial", 0, 16));
						}
					}
					jTabPestanias.addTab("Reportes", jPanelReportes);

				}
			}
			pack();
			this.setSize(926, 617);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

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

	private JButton getJButtonActualizar() {
		if (jButtonActualizar == null) {
			jButtonActualizar = new JButton();
			jButtonActualizar.setText("Actualizar");
			jButtonActualizar.setBounds(378, 144, 140, 21);
			jButtonActualizar.setFont(new java.awt.Font("Arial", 0, 16));
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
		jLabelNombreCliente.setText("Nombre");
		jLabelCodigo.setText("Código");
		jLabelEmpresaResult.setText("Empresa");

	}

	private JButton getJButtonCalcular() {
		if (jButtonCalcular == null) {
			jButtonCalcular = new JButton();
			jButtonCalcular.setText("Calcular");
			jButtonCalcular.setBounds(579, 78, 132, 23);
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

	private void jButtonCalcularActionPerformed(ActionEvent evt) throws Exception {

		float montoPrestamo = Float.parseFloat(jTextMonto.getText());
		int tasaInteres = Integer.parseInt(jTextTasaInteres.getText());
		String tipoPlazo = (String) jComboPlazo.getSelectedItem();
		int numeroCuotas = Integer.parseInt(jTextNumeroCuotas.getText());
		Date fechaInicio = calendarioPrestamos.getDate();
		// java.sql.Date fechaFormateada = new
		// java.sql.Date(fechaInicio.getTime());
		// DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");

		PrestamoDAO miPrestamo = new PrestamoDAO();
		ArrayList<Date> fechasPago = miPrestamo.calcularFechasPago(tipoPlazo, numeroCuotas, fechaInicio);
		DefaultComboBoxModel modeloNuevo = new DefaultComboBoxModel();
		modeloNuevo = llenaComboPlazos(fechasPago);
		jComboFechasCobro.setModel(modeloNuevo);

		double totalPagar = miPrestamo.calcularPrestamo(montoPrestamo, tasaInteres, tipoPlazo, numeroCuotas);
		jLabelTotalFormato.setText(totalPagar + "");

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
				montoPrestamo = Float.parseFloat(jTextMonto.getText());
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
		}

	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Actualizar");
			jButton2.setBounds(362, 161, 137, 23);
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
			jLabelEmpresaResult.setBounds(726, 161, 168, 23);
			jLabelEmpresaResult.setFont(new java.awt.Font("Arial", 0, 16));
		}
		return jLabelEmpresaResult;
	}

	private DefaultComboBoxModel llenaComboPlazos(ArrayList<Date> fechasPago) {

		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		Iterator it = fechasPago.iterator();
		while (it.hasNext()) {
			Date fechaSalida = (Date) it.next();
			// Aniadimos la fecha al modelo
			java.sql.Date fechaFormateada = new java.sql.Date(fechaSalida.getTime());
			DateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
			modelo.addElement(formato.format(fechaSalida));

		}
		return modelo;

	}

	private JButton getJButtonBuscarPrestamo() {
		if (jButtonBuscarPrestamo == null) {
			jButtonBuscarPrestamo = new JButton();
			jButtonBuscarPrestamo.setText("Buscar");
			jButtonBuscarPrestamo.setBounds(382, 35, 178, 23);
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
			jButtonActualizarAbonos.setBounds(381, 161, 137, 23);
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
			montoPagado = Double.parseDouble(jTextField1.getText());
			miAbonoVO = miAbono.buscarAbono(codigoAbono);
			if (miAbonoVO == null) {
				JOptionPane.showMessageDialog(this, "No se ha podido encontrar el abono", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				miAbono.pagarAbono(codigoAbono, fechaPago, montoPagado);
				actualizaAbonos();
				actualizaPrestamos();
				actualizaAbonosPagados();
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
			jButtonAbonosPagados = new JButton();
			jButtonAbonosPagados.setText("Solo pagados");
			jButtonAbonosPagados.setBounds(565, 161, 137, 23);
			jButtonAbonosPagados.setFont(new java.awt.Font("Arial", 0, 16));
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
			jButtonAbonosPendientes.setBounds(738, 161, 157, 23);
			jButtonAbonosPendientes.setFont(new java.awt.Font("Arial", 0, 16));
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

}
