package util_PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GeneradorPDFMantencionTI {
    //paleta color verde para el preventivo
    private static final BaseColor VERDE_HIRATA = new BaseColor(34, 139, 34); 

    //  Paleta de colores del formulario 
    private static final BaseColor ROJO_HIRATA   = new BaseColor(180, 30,  30);   
    private static final BaseColor GRIS_SECCION  = new BaseColor(220, 220, 220);  
    private static final BaseColor GRIS_TABLA    = new BaseColor(240, 240, 240);  
    private static final BaseColor AZUL_BADGE    = new BaseColor(30,  80,  160);  
    private static final BaseColor BORDE         = new BaseColor(180, 180, 180);

    // Tipografías 
    private static final Font FONT_TITULO    = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD,   BaseColor.WHITE);
    private static final Font FONT_SUBTITULO = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.WHITE);
    private static final Font FONT_SECCION   = new Font(Font.FontFamily.HELVETICA,  9, Font.BOLD,   new BaseColor(60, 60, 60));
    private static final Font FONT_ETIQUETA  = new Font(Font.FontFamily.HELVETICA,  8, Font.BOLD,   new BaseColor(80, 80, 80));
    private static final Font FONT_VALOR     = new Font(Font.FontFamily.HELVETICA,  8, Font.NORMAL, BaseColor.BLACK);
    private static final Font FONT_BADGE     = new Font(Font.FontFamily.HELVETICA,  9, Font.BOLD,   BaseColor.WHITE);
    private static final Font FONT_PIE       = new Font(Font.FontFamily.HELVETICA,  7, Font.ITALIC, new BaseColor(120, 120, 120));

    
    //  PREVENTIVO
   
   public static void generarPreventivo(
        int idMantencion,
        String folio,
        String nroEquipo,
        String fechaEncabezado,
        String fechaTerminoPDF,
        String horaInicio,
        String horaTermino,
        String tecnicoResponsable,
        String usuarioEquipo,
            String marca,
            String modelo,
            String nroSerie,
            String sistemaOperativo,
            
            // Hardware checklist
            boolean chkLimpieza,
            boolean chkConexiones,
            boolean chkRAM,
            boolean chkDisco,
            boolean chkFuente,
            boolean chkPuertos,
            boolean chkArmado,
            
            // Software checklist
            boolean chkVersionSO,
            boolean chkActSO,
            boolean chkActApps,
            boolean chkAntivirus,
            boolean chkLimpiezaArch,
            
            // Observaciones escritas
            String observaciones,
            
            //ruta donde se guarda el PDF
            String rutaDestino) throws Exception {
//Tamaño del documento en este caso tamaño carta
        Document doc = new Document(PageSize.LETTER, 36, 36, 36, 50);
        
        //escritor del PDF conectado a la ruta del archivo
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(rutaDestino));
        doc.open();

    

        // Encabezado  del formulario Preventivo
     agregarEncabezado(doc, writer,
        "Formulario de Mantenimiento Preventivo",
        "PREVENTIVO",
        fechaEncabezado,
        folio,
        idMantencion,
        VERDE_HIRATA);

        //  1. Datos generales 
        agregarTituloSeccion(doc, "1. Datos generales");
        //tabla de 4 columnas
        PdfPTable tGen = new PdfPTable(new float[]{1.2f, 2f, 1.2f, 2f});
        
        // ancho de la tabla 100%
        tGen.setWidthPercentage(100);
        tGen.setSpacingBefore(4);
       String[] partes = horaTermino != null ? horaTermino.trim().split(" ") : new String[]{};
String fechaTer = partes.length >= 1 && !partes[0].isEmpty() ? partes[0] : "—";
String horaTer  = partes.length >= 2 && !partes[1].isEmpty() ? partes[1] : "—";

agregarCeldaDatosPar(tGen, "N° equipo", nroEquipo);
agregarCeldaDatosPar(tGen, "Fecha término", fechaTerminoPDF);
agregarCeldaDatosPar(tGen, "Hora inicio", horaInicio);
agregarCeldaDatosPar(tGen, "Hora término", horaTermino);
        PdfPCell celdaTecnico = celdaEtiqueta("Técnico responsable");
        PdfPCell celdaTecnicoVal = celdaValorSpan(tecnicoResponsable, 3);
        tGen.addCell(celdaTecnico);
        tGen.addCell(celdaTecnicoVal);
        PdfPCell celdaUsuario = celdaEtiqueta("Usuario del equipo");
        PdfPCell celdaUsuarioVal = celdaValorSpan(usuarioEquipo, 3);
        tGen.addCell(celdaUsuario);
        tGen.addCell(celdaUsuarioVal);
        doc.add(tGen);

        //  2. Datos del equipo 
        agregarTituloSeccion(doc, "2. Datos del equipo");
        PdfPTable tEq = new PdfPTable(new float[]{1f, 2f, 1f, 2f});
        tEq.setWidthPercentage(100);
        tEq.setSpacingBefore(4);
        agregarCeldaDatosPar(tEq, "Marca",            marca);
        agregarCeldaDatosPar(tEq, "Modelo",           modelo);
        agregarCeldaDatosPar(tEq, "N° serie",         nroSerie);
        agregarCeldaDatosPar(tEq, "Sistema operativo",sistemaOperativo);
        doc.add(tEq);

        //  3. Checklist hardware 
        agregarTituloSeccion(doc, "3. Lista de chequeo — hardware");
        PdfPTable tHW = new PdfPTable(new float[]{4f, 0.5f, 0.5f, 3f});
        tHW.setWidthPercentage(100);
        tHW.setSpacingBefore(4);
        agregarEncabezadoChecklist(tHW);
        agregarFilaChecklist(tHW, "Limpieza física interna (polvo, ventiladores, disipadores)", chkLimpieza, "");
        agregarFilaChecklist(tHW, "Verificación y ajuste de conexiones internas",                chkConexiones, "");
        agregarFilaChecklist(tHW, "Revisión y prueba de memoria RAM",                            chkRAM, "");
        agregarFilaChecklist(tHW, "Revisión de disco duro / SSD (estado y capacidad)",           chkDisco, "");
        agregarFilaChecklist(tHW, "Verificación de fuente de poder",                             chkFuente, "");
        agregarFilaChecklist(tHW, "Revisión de puertos USB, red y periféricos",                  chkPuertos, "");
        agregarFilaChecklist(tHW, "Armado del equipo y verificación de encendido",               chkArmado, "");
        doc.add(tHW);

        //  4. Checklist software 
        agregarTituloSeccion(doc, "4. Lista de chequeo — software");
        PdfPTable tSW = new PdfPTable(new float[]{4f, 0.5f, 0.5f, 3f});
        tSW.setWidthPercentage(100);
        tSW.setSpacingBefore(4);
        agregarEncabezadoChecklist(tSW);
        agregarFilaChecklist(tSW, "Verificación de versión del sistema operativo",                           chkVersionSO, "");
        agregarFilaChecklist(tSW, "Actualización del sistema operativo (parches y service packs)",           chkActSO, "");
        agregarFilaChecklist(tSW, "Actualización de aplicaciones clave (Office, navegadores, etc.)",         chkActApps, "");
        agregarFilaChecklist(tSW, "Verificación y actualización de antivirus / antimalware",                 chkAntivirus, "");
        agregarFilaChecklist(tSW, "Limpieza de archivos temporales, caché y papelera",                       chkLimpiezaArch, "");
        doc.add(tSW);

        //  5. Observaciones 
        agregarTituloSeccion(doc, "5. Observaciones generales");
        PdfPTable tObs = new PdfPTable(1);
        tObs.setWidthPercentage(100);
        tObs.setSpacingBefore(4);
        PdfPCell cObs = new PdfPCell(new Phrase(observaciones.isEmpty() ? " " : observaciones, FONT_VALOR));
        cObs.setMinimumHeight(60);
        cObs.setPadding(6);
        cObs.setBorderColor(BORDE);
        tObs.addCell(cObs);
        doc.add(tObs);

        agregarPiePagina(writer, "RF-06 · Mantenimiento de Equipos");
        doc.close();
        abrirPDF(rutaDestino);
    }

    
    //  CORRECTIVO
  
   public static void generarCorrectivo(
        int idMantencion,
        String folio,
        String nroEquipo,
            String fechaStr,
            String horaInicio,
            String horaTermino,
            String tecnicoResponsable,
            String usuarioEquipo,
            String marca,
            String modeloEquipo,
            String nroSerie,
            String sistemaOperativo,
            String sintomaReportado,
            String tipoFalla,       
            String prioridad,        
            String[][] acciones,     
            String[][] piezas,       
            String rutaDestino) throws Exception {

        Document doc = new Document(PageSize.LETTER, 36, 36, 36, 50);
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(rutaDestino));
        doc.open();

      

        //  Encabezado 
        agregarEncabezado(doc, writer, "Formulario de Mantenimiento Correctivo", "CORRECTIVO",
        fechaStr, folio, idMantencion, ROJO_HIRATA);

        //  1. Datos generales 
        agregarTituloSeccion(doc, "1. Datos generales");
        PdfPTable tGen = new PdfPTable(new float[]{1.2f, 2f, 1.2f, 2f});
        tGen.setWidthPercentage(100);
        tGen.setSpacingBefore(4);
        String[] partes = horaTermino != null ? horaTermino.trim().split(" ") : new String[]{};
String fechaTer = partes.length >= 1 && !partes[0].isEmpty() ? partes[0] : "—";
String horaTer  = partes.length >= 2 && !partes[1].isEmpty() ? partes[1] : "—";

agregarCeldaDatosPar(tGen, "N° equipo", nroEquipo);
agregarCeldaDatosPar(tGen, "Fecha término", fechaTer);

agregarCeldaDatosPar(tGen, "Hora inicio", horaInicio);
agregarCeldaDatosPar(tGen, "Hora término", horaTer);
        PdfPCell celdaTecnico = celdaEtiqueta("Técnico responsable");
        PdfPCell celdaTecnicoVal = celdaValorSpan(tecnicoResponsable, 3);
        tGen.addCell(celdaTecnico);
        tGen.addCell(celdaTecnicoVal);
        PdfPCell celdaUsuario = celdaEtiqueta("Usuario del equipo");
        PdfPCell celdaUsuarioVal = celdaValorSpan(usuarioEquipo, 3);
        tGen.addCell(celdaUsuario);
        tGen.addCell(celdaUsuarioVal);
        doc.add(tGen);

        // 2. Datos del equipo 
        agregarTituloSeccion(doc, "2. Datos del equipo");
        PdfPTable tEq = new PdfPTable(new float[]{1f, 2f, 1f, 2f});
        tEq.setWidthPercentage(100);
        tEq.setSpacingBefore(4);
        agregarCeldaDatosPar(tEq, "Marca",            marca);
        agregarCeldaDatosPar(tEq, "Modelo",           modeloEquipo);
        agregarCeldaDatosPar(tEq, "N° serie",         nroSerie);
        agregarCeldaDatosPar(tEq, "Sistema operativo",sistemaOperativo);
        doc.add(tEq);

        //  3. Descripción de la falla 
        agregarTituloSeccion(doc, "3. Descripción de la falla");
        PdfPTable tFalla = new PdfPTable(new float[]{1.5f, 4f});
        tFalla.setWidthPercentage(100);
        tFalla.setSpacingBefore(4);

        // Síntoma
        tFalla.addCell(celdaEtiqueta("Problema detectado"));
        PdfPCell cSintoma = new PdfPCell(new Phrase(sintomaReportado, FONT_VALOR));
        cSintoma.setPadding(5); cSintoma.setMinimumHeight(30); cSintoma.setBorderColor(BORDE);
        tFalla.addCell(cSintoma);

        // Tipo de falla con checkboxes visuales
        tFalla.addCell(celdaEtiqueta("Tipo de falla"));
        String tipoTxt = (tipoFalla.contains("Hardware") ? "X  Hardware        Software" : "Hardware        X  Software");
        PdfPCell cTipo = new PdfPCell(new Phrase(tipoTxt, FONT_VALOR));
        cTipo.setPadding(5); cTipo.setBorderColor(BORDE); tFalla.addCell(cTipo);

        // Prioridad
        tFalla.addCell(celdaEtiqueta("Prioridad"));
        String priTxt = (prioridad.contains("Alta")  ? "X  Alta        Media        Baja" :
                 prioridad.contains("Media") ? "Alta        X  Media        Baja" :
                                               "Alta        Media        X  Baja");
        PdfPCell cPri = new PdfPCell(new Phrase(priTxt, FONT_VALOR));
        cPri.setPadding(5); cPri.setBorderColor(BORDE); tFalla.addCell(cPri);
        doc.add(tFalla);

        //  4. Acciones correctivas 
        agregarTituloSeccion(doc, "4. Acciones correctivas realizadas");
        PdfPTable tAcc = new PdfPTable(new float[]{0.4f, 4f, 1f});
        tAcc.setWidthPercentage(100);
        tAcc.setSpacingBefore(4);
        // Encabezado
        agregarCeldaEncabezadoTabla(tAcc, "N°");
        agregarCeldaEncabezadoTabla(tAcc, "Acción realizada");
       agregarCeldaEncabezadoTabla(tAcc, "Observaciones");

        String[][] accionesEfectivas = (acciones != null && acciones.length > 0) ? acciones :
                new String[][]{{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};

        for (int i = 0; i < Math.max(5, accionesEfectivas.length); i++) {
            boolean alterno = (i % 2 == 1);
            BaseColor bg = alterno ? GRIS_TABLA : BaseColor.WHITE;
            String num = String.valueOf(i + 1);
            String accion = (i < accionesEfectivas.length && accionesEfectivas[i][0] != null) ? accionesEfectivas[i][0] : "";
            String res    = (i < accionesEfectivas.length && accionesEfectivas[i][1] != null) ? accionesEfectivas[i][1] : "";
            agregarCeldaTablaColoreada(tAcc, num,    bg, Element.ALIGN_CENTER);
            agregarCeldaTablaColoreada(tAcc, accion, bg, Element.ALIGN_LEFT);
           agregarCeldaTablaColoreada(tAcc, "", bg, Element.ALIGN_LEFT);
        }
        doc.add(tAcc);

        //  5. Piezas reemplazadas 
        agregarTituloSeccion(doc, "5. Piezas reemplazadas");
        PdfPTable tPiezas = new PdfPTable(new float[]{4f, 1.5f});
        tPiezas.setWidthPercentage(100);
        tPiezas.setSpacingBefore(4);
        agregarCeldaEncabezadoTabla(tPiezas, "Componente");
       agregarCeldaEncabezadoTabla(tPiezas, "Piezas solicitadas");

        
String[][] piezasEfectivas = new String[Math.max(8, piezas != null ? piezas.length : 0)][3];
if (piezas != null) {
    for (int k = 0; k < piezas.length; k++)
        piezasEfectivas[k] = piezas[k];
}
for (int k = (piezas != null ? piezas.length : 0); k < piezasEfectivas.length; k++)
    piezasEfectivas[k] = new String[]{"", "", ""};

        for (int i = 0; i < Math.max(4, piezasEfectivas.length); i++) {
            boolean alterno = (i % 2 == 1);
            BaseColor bg = alterno ? GRIS_TABLA : BaseColor.WHITE;
            String comp = (i < piezasEfectivas.length && piezasEfectivas[i][0] != null) ? piezasEfectivas[i][0] : "";
            String remp = (i < piezasEfectivas.length && piezasEfectivas[i][2] != null) ? piezasEfectivas[i][2] : "";
           agregarCeldaTablaColoreada(tPiezas, comp, bg, Element.ALIGN_LEFT);
           String rempTxt = remp.contains("Sí") ? "X" : "";
          agregarCeldaTablaColoreada(tPiezas, rempTxt, bg, Element.ALIGN_CENTER);
        }
        doc.add(tPiezas);

        agregarPiePagina(writer, "RF-06 · Mantenimiento de Equipos");
        doc.close();
        abrirPDF(rutaDestino);
    }


    private static void agregarEncabezado(Document doc, PdfWriter writer,
        String titulo, String badge, String fecha, String folio,
        int idMantencion,
        BaseColor badgeColor) throws DocumentException {

        PdfPTable header = new PdfPTable(new float[]{1.5f, 4f, 1.5f});
        header.setWidthPercentage(100);
        header.setSpacingAfter(8);

        // Celda logo / empresa
        PdfPCell cLogo = new PdfPCell();
        cLogo.setBackgroundColor(badgeColor);
        cLogo.setPadding(10);
        cLogo.setBorder(Rectangle.NO_BORDER);
        Paragraph pEmp = new Paragraph("EMPRESA DE TRANSPORTE\nHirata",
                new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.WHITE));
        pEmp.setAlignment(Element.ALIGN_CENTER);
        cLogo.addElement(pEmp);
        header.addCell(cLogo);

        // Celda título
        PdfPCell cTit = new PdfPCell();
        cTit.setBackgroundColor(badgeColor);
        cTit.setPadding(10);
        cTit.setBorder(Rectangle.NO_BORDER);
        Paragraph pTit = new Paragraph(titulo, FONT_TITULO);
        pTit.setAlignment(Element.ALIGN_CENTER);
        Paragraph pSub = new Paragraph("RF-06 · Equipos informáticos de oficina", FONT_SUBTITULO);
        pSub.setAlignment(Element.ALIGN_CENTER);
        cTit.addElement(pTit);
        cTit.addElement(pSub);
        header.addCell(cTit);

     
        PdfPCell cBadge = new PdfPCell();
        cBadge.setBackgroundColor(badgeColor);
        cBadge.setPadding(10);
        cBadge.setBorder(Rectangle.NO_BORDER);
        Paragraph pBadge = new Paragraph(badge, FONT_BADGE);
        pBadge.setAlignment(Element.ALIGN_CENTER);
        Paragraph pFecha = new Paragraph("Fecha: " + fecha, FONT_SUBTITULO);
        pFecha.setAlignment(Element.ALIGN_CENTER);
        Paragraph pFolio = new Paragraph("Folio: " + folio, FONT_SUBTITULO);
pFolio.setAlignment(Element.ALIGN_CENTER);

Font FONT_ID_INTERNO = new Font(
        Font.FontFamily.HELVETICA,
        7,
        Font.NORMAL,
        BaseColor.WHITE
);

Paragraph pId = new Paragraph("ID interno: " + idMantencion, FONT_ID_INTERNO);
pId.setAlignment(Element.ALIGN_CENTER);

cBadge.addElement(pBadge);
cBadge.addElement(pFecha);
cBadge.addElement(pFolio);
cBadge.addElement(pId);
        header.addCell(cBadge);

        doc.add(header);
    }

    private static void agregarTituloSeccion(Document doc, String texto) throws DocumentException {
        PdfPTable t = new PdfPTable(1);
        t.setWidthPercentage(100);
        t.setSpacingBefore(8);
        t.setSpacingAfter(0);
        PdfPCell c = new PdfPCell(new Phrase(texto, FONT_SECCION));
        c.setBackgroundColor(GRIS_SECCION);
        c.setPadding(5);
        c.setBorderColor(BORDE);
        t.addCell(c);
        doc.add(t);
    }

    private static void agregarCeldaDatosPar(PdfPTable tabla, String etiqueta, String valor) {
        tabla.addCell(celdaEtiqueta(etiqueta));
        PdfPCell cVal = new PdfPCell(new Phrase(valor != null ? valor : "", FONT_VALOR));
        cVal.setPadding(5); cVal.setBorderColor(BORDE); tabla.addCell(cVal);
    }

    private static PdfPCell celdaEtiqueta(String texto) {
        PdfPCell c = new PdfPCell(new Phrase(texto, FONT_ETIQUETA));
        c.setBackgroundColor(GRIS_SECCION);
        c.setPadding(5);
        c.setBorderColor(BORDE);
        return c;
    }

    private static PdfPCell celdaValorSpan(String valor, int colspan) {
        PdfPCell c = new PdfPCell(new Phrase(valor != null ? valor : "", FONT_VALOR));
        c.setColspan(colspan);
        c.setPadding(5);
        c.setBorderColor(BORDE);
        return c;
    }

    private static void agregarEncabezadoChecklist(PdfPTable tabla) {
        String[] cols = {"Actividad", "Sí", "No", "Observación"};
        for (String col : cols) {
            PdfPCell c = new PdfPCell(new Phrase(col, FONT_ETIQUETA));
            c.setBackgroundColor(GRIS_SECCION);
            c.setPadding(4);
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBorderColor(BORDE);
            tabla.addCell(c);
        }
    }

    private static void agregarFilaChecklist(PdfPTable tabla, String actividad,
            boolean marcado, String obs) {
        PdfPCell cAct = new PdfPCell(new Phrase(actividad, FONT_VALOR));
        cAct.setPadding(4); cAct.setBorderColor(BORDE); tabla.addCell(cAct);

     PdfPCell cSi = new PdfPCell(new Phrase(marcado ? "X" : "", FONT_VALOR));
cSi.setHorizontalAlignment(Element.ALIGN_CENTER); 
cSi.setPadding(4); 
cSi.setBorderColor(BORDE);
tabla.addCell(cSi);

PdfPCell cNo = new PdfPCell(new Phrase(!marcado ? "X" : "", FONT_VALOR));
cNo.setHorizontalAlignment(Element.ALIGN_CENTER); 
cNo.setPadding(4); 
cNo.setBorderColor(BORDE);
tabla.addCell(cNo);

        PdfPCell cObs = new PdfPCell(new Phrase(obs != null ? obs : "", FONT_VALOR));
        cObs.setPadding(4); cObs.setBorderColor(BORDE); tabla.addCell(cObs);
    }

    private static void agregarCeldaEncabezadoTabla(PdfPTable tabla, String texto) {
        PdfPCell c = new PdfPCell(new Phrase(texto, FONT_ETIQUETA));
        c.setBackgroundColor(GRIS_SECCION);
        c.setPadding(4);
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setBorderColor(BORDE);
        tabla.addCell(c);
    }

    private static void agregarCeldaTablaColoreada(PdfPTable tabla, String texto,
            BaseColor bg, int align) {
        PdfPCell c = new PdfPCell(new Phrase(texto != null ? texto : "", FONT_VALOR));
        c.setBackgroundColor(bg);
        c.setPadding(4);
        c.setHorizontalAlignment(align);
        c.setMinimumHeight(18);
        c.setBorderColor(BORDE);
        tabla.addCell(c);
    }

    private static void agregarPiePagina(PdfWriter writer, String referencia) {
        PdfContentByte cb = writer.getDirectContent();
        cb.saveState();
        cb.setColorStroke(BORDE);
        cb.setLineWidth(0.5f);
        cb.moveTo(36, 42); cb.lineTo(559, 42); cb.stroke();
        cb.restoreState();

        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,
                new Phrase("Empresa de Transporte Hirata · Departamento de Mantención", FONT_PIE),
                36, 32, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                new Phrase("Página 1 de 1", FONT_PIE), 297, 32, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,
                new Phrase(referencia, FONT_PIE), 559, 32, 0);
    }

    private static void abrirPDF(String ruta) {
        try {
            File f = new File(ruta);
            if (f.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(f);
            }
        } catch (Exception ignored) {}
    }
}
