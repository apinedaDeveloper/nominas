package interfaz_usuario.servlets;

import enlace_datos.util.encription;
import enlace_datos.util.util_Debug;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Blob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg_util_base_datos.interfaz_DB;


public class ver_documento extends HttpServlet {
    private static final String CONTENT_TYPE = 
        "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //Método que busca un documento de el Directorio Server
    public void obtenerDocumentoDirectorioServer(String vRutaCompleta, String vFileName, ServletOutputStream outstream) throws FileNotFoundException, 
                                                                          IOException {
        byte buffer[];
        int vtamBuffer = 5120, vContador;
        FileInputStream vDocumentoAdjunto;
        /*System.out.println("Ruta Completa: " + vRutaCompleta);
        System.out.println("Nombre Archivo: " + vFileName);*/
        buffer = new byte[vtamBuffer];
        vDocumentoAdjunto = new FileInputStream(vRutaCompleta + vFileName);
        if ( !vDocumentoAdjunto.equals(null) ) {
            while ((vContador = vDocumentoAdjunto.read(buffer)) != -1) {
                outstream.write(buffer, 0, vContador);
            }
            vDocumentoAdjunto.close();
        } else {
            outstream.write(new String("No hay información guardada!!").getBytes());
        }
    }
    
    /**Process the HTTP doGet request.
     */
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, 
                                                           IOException {
        String vParametroSource, vRutaUploads, vRutaCompleta;
        String vFileName_ID, vTipoTramite, vContentTypeFile;
        String vParametros[];
        encription decript;
        ServletOutputStream outstream;
        Object vBlob;
        Blob vDataDoc;
        interfaz_DB datos;
        datos = new interfaz_DB();
        outstream = response.getOutputStream();
        decript = new encription();
        try {
            vParametroSource = request.getParameter("source");
            vParametroSource = decript.desencriptarDES(vParametroSource, null);
            vParametros = vParametroSource.split("\\|");
            vRutaUploads = request.getSession().getServletContext().getInitParameter("ROOT_UPLOADS");
            vFileName_ID = vParametros[0]; //El file name o file ID
            vTipoTramite = vParametros[1];
            vContentTypeFile = vParametros[2];
            if (!vTipoTramite.equals("G")) {
                System.out.println("Dato: " + vFileName_ID);
                if (vTipoTramite.equals("E")) {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOCS_EMPL");
                } else if (vTipoTramite.equals("C")) {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOC_CONTRATO");
                } else if (vTipoTramite.equals("A")) {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOCS_ANEXO");
                } else if (vTipoTramite.equals("S")) {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOCS_SOLITUD");
                } else if (vTipoTramite.equals("V")) {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOCS_VARIANOM");
                } else {
                    vRutaCompleta = vRutaUploads + request.getSession().getServletContext().getInitParameter("DIRECTORIO_DOCS_EMPL");
                }
                obtenerDocumentoDirectorioServer(vRutaCompleta, vFileName_ID, outstream);
                response.setHeader("Content-disposition", "inline; filename=\\" + vFileName_ID);
                if ( vContentTypeFile != null && !vContentTypeFile.equals("")) {
                    response.setContentType(vContentTypeFile);
                }
            } else {
                vBlob = datos.getValorConsultaSimpleBlob("data", "select data from sis_archivo_adjunto where id_archivo_Adjunto=" + vFileName_ID);
                if (vBlob != null) {
                    vDataDoc = (Blob)vBlob;
                    response.setHeader("Content-disposition", "inline; filename=\\" + vFileName_ID);
                    if ( vContentTypeFile != null && !vContentTypeFile.equals("")) {
                        response.setContentType(vContentTypeFile);
                    }
                    outstream.write(vDataDoc.getBytes(1, (int)vDataDoc.length()), 0, (int)vDataDoc.length());
                }
            }
        } catch (FileNotFoundException exep) {
            response.setContentType(CONTENT_TYPE);
            outstream.write(new String("No hay información guardada!!").getBytes());
        } catch (IOException exep) {
            response.setContentType(CONTENT_TYPE);
            outstream.write(new String("Hubo un error en la lectura del Archivo!!").getBytes());
        } catch (Exception exep) {
            //exep.printStackTrace();
            util_Debug vDebug = new util_Debug();
            vDebug.DebugA("ver_documento", null, exep, false);
            response.setContentType(CONTENT_TYPE);
            outstream.write(new String("No se pudo abrir el archivo!!").getBytes());
        } finally {
            outstream.flush();
            outstream.close();
            datos.cn_Cerrar_coneccion();
        }
    }
}
