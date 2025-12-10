package tools;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfUtil {

    // Fonte padrão
    private static final Font FONT_TITULO = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    private static final Font FONT_CABECALHO = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static final Font FONT_TEXTO = new Font(Font.FontFamily.HELVETICA, 10);

    public static void gerarPdf(
            String nomeArquivo,
            String titulo,
            String[] cabecalhos,
            List<String[]> dados
    ) throws Exception {

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(nomeArquivo));
        doc.open();

        
        Paragraph tituloPdf = new Paragraph(titulo + "\n\n", FONT_TITULO);
        tituloPdf.setAlignment(Element.ALIGN_CENTER);
        doc.add(tituloPdf);

  
        PdfPTable tabela = new PdfPTable(cabecalhos.length);
        tabela.setWidthPercentage(100);

        
        for (String c : cabecalhos) {
            PdfPCell cell = new PdfPCell(new Paragraph(c, FONT_CABECALHO));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(cell);
        }

        
        for (String[] linha : dados) {
            for (String coluna : linha) {
                tabela.addCell(new Paragraph(coluna, FONT_TEXTO));
            }
        }

        doc.add(tabela);
        doc.close();
    }
}
