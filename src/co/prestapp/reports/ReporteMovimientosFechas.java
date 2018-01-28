package co.prestapp.reports;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import co.prestapp.DAO.MovimientoDAO;
import co.prestapp.connection.DBConnection;
import co.prestapp.connection.DBError;

import com.lowagie.text.pdf.PdfPTable;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReporteMovimientosFechas {

	MovimientoDAO miMovimiento = new MovimientoDAO();
	DBError error = new DBError();
	private String strNombreDelPDF;
	Color grisClaro = new Color(230, 230, 230);
	Color azulClaro = new Color(124, 195, 255);

	// ############# VARIABLES PARA MANEJO DE BASE DE DATOS ########################
	Document document;
	PdfWriter writer;
	String strRotuloPDF;

	// Metodo principal del ejemplo
	public ReporteMovimientosFechas(String titulo, String nomPDF, String consultaSeleccionada, String tituloTabla,
			Date fechaInicio, Date fechaFin, String rangoFechas) {
		strRotuloPDF = titulo;
		strNombreDelPDF = nomPDF;
		try { // Hoja tamanio carta, rotarla (cambiar a horizontal)
			document = new Document(PageSize.LETTER.rotate());

			writer = PdfWriter.getInstance(
					// that listens to the document
					document,
					// direccionar el PDF-stream a un archivo
					new FileOutputStream(strNombreDelPDF));
			document.open();

			agregarMetaDatos(document);
			agregarContenido(document, consultaSeleccionada, tituloTabla, fechaInicio, fechaFin, rangoFechas);

			document.close();

			System.out.println("Se ha generado el PDF: " + strNombreDelPDF);

		} catch (Exception e) {
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".ReporteMovimientosFechas");
		}
	}

	// agrega el contenido del documento; para este ejemplo agrega una tabla con
	// datos y una imagen
	// Espera como entrada el documento donde agregara el contenido
	private void agregarContenido(Document document, String consultaSeleccionada, String tituloTabla, Date fechaInicio,
			Date fechaFin, String rangoFechas) throws DocumentException {
		Paragraph ParrafoHoja = new Paragraph();
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		// Agregamos una linea en blanco al principio del documento
		// agregarLineasEnBlanco(ParrafoHoja, 1);
		// Colocar un encabezado (en mayusculas)
		ParrafoHoja.add(new Paragraph(strRotuloPDF));

		agregarLineasEnBlanco(ParrafoHoja, 1);

		if (consultaSeleccionada.equals("entrada") || consultaSeleccionada.equals("entradaFecha")) {
			ParrafoHoja.add(new Paragraph("El total de las entradas es:  "
					+ formatoMoneda.format(miMovimiento.calcularTotalEntradas(fechaInicio, fechaFin))));
		} else if (consultaSeleccionada.equals("salida") || consultaSeleccionada.equals("salidaFecha")) {
			ParrafoHoja.add(new Paragraph("El total de las salidas es:  "
					+ formatoMoneda.format(miMovimiento.calcularTotalSalidas(fechaInicio, fechaFin))));
		} else {
			ParrafoHoja.add(new Paragraph("El total de las entradas es:  "
					+ formatoMoneda.format(miMovimiento.calcularTotalEntradas(fechaInicio, fechaFin))));
			ParrafoHoja.add(new Paragraph("El total de las salidas es:  "
					+ formatoMoneda.format(miMovimiento.calcularTotalSalidas(fechaInicio, fechaFin))));
		}

		ParrafoHoja.add(new Paragraph(rangoFechas));
		// 1.- AGREGAMOS LA TABLA
		try {
			agregarTabla(ParrafoHoja, consultaSeleccionada, tituloTabla, fechaInicio, fechaFin);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".agregarTabla");
		}
		// Agregar 2 lineas en blanco
		agregarLineasEnBlanco(ParrafoHoja, 2);
		// 2.- AGREGAMOS LA IMAGEN
		// try {
		// Image im = Image.getInstance("logo_mysql.PNG");
		// im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		// im.setWidthPercentage(50);
		// ParrafoHoja.add(im);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		document.add(ParrafoHoja);

	}

	// Se conecta al DBMS MySQL , obtiene los datos de la tabla (SELECT) y los
	// acomoda en una tabla JTable de iText.
	// Espera como entrada el parrafo donde agregara la tabla
	private void agregarTabla(Paragraph parrafo, String consultaSeleccionada, String tituloTabla, Date fechaInicio,
			Date fechaFin) throws SQLException {

		// Anchos de las columnas
		float anchosFilas[] = { 1f, 1f, 1f, 1f, 1f };
		PdfPTable tabla = new PdfPTable(anchosFilas);
		String rotulosColumnas[] = miMovimiento.getColumnas();
		// Porcentaje que ocupa a lo ancho de la pagina del PDF
		tabla.setWidthPercentage(100);
		// Alineacion horizontal centrada
		tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
		// agregar celda que ocupa las 9 columnas de los rotulos
		PdfPCell cell = new PdfPCell(new Paragraph(tituloTabla));
		cell.setColspan(11);
		// Centrar contenido de celda
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// Color de fondo de la celda
		cell.setBackgroundColor(azulClaro);
		tabla.addCell(cell);

		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");
		Locale locale = new Locale("es", "CO");
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(locale);

		// Mostrar los rotulos de las columnas
		for (int i = 0; i < rotulosColumnas.length; i++) {
			cell = new PdfPCell(new Paragraph(rotulosColumnas[i]));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(grisClaro);
			tabla.addCell(cell);
		}

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		CallableStatement miProcedimiento = null;
		ResultSet rs;
		if (consultaSeleccionada.equals("entrada")) {

			miProcedimiento = conexion.prepareCall("{call listar_movimientos_entrada}");

		} else if (consultaSeleccionada.equals("salida")) {

			miProcedimiento = conexion.prepareCall("{call listar_movimientos_salida}");

		} else if (consultaSeleccionada.equals("entradaFecha")) {

			miProcedimiento = conexion.prepareCall("{call listar_movimientos_entrada_fechas(?,?)}");
			miProcedimiento.setDate(1, fechaInicio);
			miProcedimiento.setDate(2, fechaFin);

		} else if (consultaSeleccionada.equals("salidaFecha")) {

			miProcedimiento = conexion.prepareCall("{call listar_movimientos_salida_fechas(?,?)}");
			miProcedimiento.setDate(1, fechaInicio);
			miProcedimiento.setDate(2, fechaFin);

		} else if (consultaSeleccionada.equals("todos")) {

			miProcedimiento = conexion.prepareCall("{call listar_movimientos_fechas(?,?)}");
			miProcedimiento.setDate(1, fechaInicio);
			miProcedimiento.setDate(2, fechaFin);
		}

		rs = miProcedimiento.executeQuery();

		// Iterar Mientras haya una fila siguiente
		while (rs.next()) { // Agregar 6 celdas
			cell = new PdfPCell(new Paragraph(rs.getString("codigoMovimiento")));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(formatoFecha.format(rs.getDate("fechaMovimiento")))));
			tabla.addCell(cell);

			cell = new PdfPCell(new Paragraph(String.valueOf(formatoMoneda.format(rs.getDouble("entradaMovimiento")))));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(formatoMoneda.format(rs.getDouble("salidaMovimiento")))));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf(formatoMoneda.format(rs.getDouble("saldoMovimiento")))));
			tabla.addCell(cell);

		}

		// Cerrar los objetos de manejo de BD
		rs.close(); // ResultSet
		// estSQL1.close();
		conexion.close();

		// Agregar la tabla con los datos al parrafo que nos llego como entrada
		parrafo.add(tabla);
	} // Fin del metodo que crea la tabla

	// Agrega las lineas en blanco especificadas a un parrafo especificado
	private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
		for (int i = 0; i < nLineas; i++)
			parrafo.add(new Paragraph(" "));
	}

	// Agrega los metadatos del documento, los metadatos a asignar son
	// Titulo, Asunto, Palabras clave, Autor y el sw o org con el cual fue generado
	private static void agregarMetaDatos(Document document) {
		document.addTitle("Documento con datos de tabla MySQL");
		document.addSubject("Usando iText y MySQL");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("PrestApp");
	}

	// Abre el documento PDF
	public void abrirPDF() {
		/* Abrir el archivo PDF */
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + strNombreDelPDF);
		} catch (IOException e) {
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".abrirPDF");
		}
	}
}
