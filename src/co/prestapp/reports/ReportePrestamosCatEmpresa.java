package co.prestapp.reports;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;

import co.prestapp.DAO.PrestamoDAO;
import co.prestapp.connection.DBConnection;
import co.prestapp.connection.DBError;

import com.lowagie.text.pdf.PdfPTable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReportePrestamosCatEmpresa {

	PrestamoDAO miPrestamo = new PrestamoDAO();
	DBError error = new DBError();
	private String strNombreDelPDF;
	Color grisClaro = new Color(230, 230, 230);
	Color azulClaro = new Color(124, 195, 255);

	// ############# VARIABLES PARA MANEJO DE BASE DE DATOS ########################
	Document document;
	PdfWriter writer;
	String strRotuloPDF;

	// Metodo principal del ejemplo
	public ReportePrestamosCatEmpresa(String titulo, String nomPDF, String categoriaSeleccionada, String tituloTabla) {
		strRotuloPDF = titulo;
		strNombreDelPDF = nomPDF;
		try { // Hoja tamanio carta, rotarla (cambiar a horizontal)
			document = new Document(PageSize.LETTER);

			writer = PdfWriter.getInstance(
					// that listens to the document
					document,
					// direccionar el PDF-stream a un archivo
					new FileOutputStream(strNombreDelPDF));
			document.open();

			agregarMetaDatos(document);
			agregarContenido(document, categoriaSeleccionada, tituloTabla);

			document.close();

			System.out.println("Se ha generado el PDF: " + strNombreDelPDF);

		} catch (Exception e) {
			e.printStackTrace();
			error.guardarMensajeError(e.getMessage(), this.getClass().getCanonicalName() + ".ReportePrestamos");
		}
	}

	// agrega el contenido del documento; para este ejemplo agrega una tabla con
	// datos y una imagen
	// Espera como entrada el documento donde agregara el contenido
	private void agregarContenido(Document document, String categoriaSeleccionada, String tituloTabla)
			throws DocumentException {
		Paragraph ParrafoHoja = new Paragraph();

		// Agregamos una linea en blanco al principio del documento
		// agregarLineasEnBlanco(ParrafoHoja, 1);
		// Colocar un encabezado (en mayusculas)
		ParrafoHoja.add(new Paragraph(strRotuloPDF));
		// agregarLineasEnBlanco(ParrafoHoja, 1);
		// 1.- AGREGAMOS LA TABLA
		try {
			agregarTabla(ParrafoHoja, categoriaSeleccionada, tituloTabla);
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
	private void agregarTabla(Paragraph parrafo, String categoriaSeleccionada, String tituloTabla) throws SQLException {

		// Manejo de fuente
		Font fuente = new Font(Font.HELVETICA);
		fuente.setSize(11);

		// Anchos de las columnas
		float anchosFilas[] = { 1.4f, 1.6f, 1f, 0.4f, 1f, 0.6f, 0.5f, 0.5f, 0.5f, 0.5f };
		PdfPTable tabla = new PdfPTable(anchosFilas);
		String rotulosColumnas[] = miPrestamo.getColumnasRequeridoReportes();
		// Porcentaje que ocupa a lo ancho de la pagina del PDF
		tabla.setWidthPercentage(100);
		// Alineacion horizontal centrada
		tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
		// agregar celda que ocupa las 9 columnas de los rotulos
		PdfPCell cell = new PdfPCell(new Paragraph(tituloTabla));
		cell.setColspan(10);
		// Centrar contenido de celda
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// Color de fondo de la celda
		cell.setBackgroundColor(azulClaro);
		tabla.addCell(cell);

		DateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");

		// Mostrar los rotulos de las columnas
		for (int i = 0; i < rotulosColumnas.length; i++) {
			cell = new PdfPCell(new Paragraph(rotulosColumnas[i], fuente));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(grisClaro);
			tabla.addCell(cell);
		}

		DBConnection miConexion = new DBConnection();
		Connection conexion = miConexion.darConexion();
		CallableStatement miProcedimiento;
		ResultSet rs;
		if (categoriaSeleccionada.equals("todos")) {
			miProcedimiento = conexion.prepareCall("{call listar_prestamos_requerido}");
		} else if (categoriaSeleccionada.equals("pendientes")) {
			miProcedimiento = conexion.prepareCall("{call listar_prestamos_pendientes}");
		} else if (categoriaSeleccionada.equals("pagados")) {
			miProcedimiento = conexion.prepareCall("{call listar_prestamos_pagados}");
		} else if (categoriaSeleccionada.equals("vencidos")) {
			miProcedimiento = conexion.prepareCall("{call listar_prestamos_vencidos}");
		} else {
			miProcedimiento = conexion.prepareCall("{call listar_prestamos_req_categoria(?)}");
			miProcedimiento.setString(1, categoriaSeleccionada);
		}

		rs = miProcedimiento.executeQuery();

		// Iterar Mientras haya una fila siguiente
		while (rs.next()) { // Agregar 10 celdas
			cell = new PdfPCell(new Paragraph(rs.getString("nombreCliente"), fuente));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(rs.getString("empresaCliente"), fuente));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(rs.getString("referenciaCliente"), fuente));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(rs.getString("codigoPrestamo"), fuente));
			tabla.addCell(cell);
			if (rs.getDate("fechaInicioPrestamo") != null) {
				cell = new PdfPCell(
						new Paragraph(String.valueOf(formatoFecha.format(rs.getDate("fechaInicioPrestamo"))), fuente));
				tabla.addCell(cell);
			}
			cell = new PdfPCell(new Paragraph(String.valueOf((rs.getInt("montoPrestamo")) / 1000), fuente));
			tabla.addCell(cell);
			if (rs.getString("tipoPlazoPrestamo").equals("QUINCENAL")) {
				cell = new PdfPCell(new Paragraph("QUI", fuente));
				tabla.addCell(cell);
			}
			if (rs.getString("tipoPlazoPrestamo").equals("MENSUAL")) {
				cell = new PdfPCell(new Paragraph("MEN", fuente));
				tabla.addCell(cell);
			}
			if (rs.getString("tipoPlazoPrestamo").equals("SEMANAL")) {
				cell = new PdfPCell(new Paragraph("SEM", fuente));
				tabla.addCell(cell);
			}

			cell = new PdfPCell(new Paragraph(String.valueOf(rs.getInt("numeroCuotasprestamo")), fuente));

			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf((rs.getInt("montoACobrar")) / 1000), fuente));
			tabla.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.valueOf((rs.getInt("saldoRestantePrestamo")) / 1000), fuente));
			tabla.addCell(cell);

		}

		// Cerrar los objetos de manejo de BD
		rs.close();
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
