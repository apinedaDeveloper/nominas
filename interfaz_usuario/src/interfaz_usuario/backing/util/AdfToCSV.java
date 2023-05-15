package interfaz_usuario.backing.util;

import interfaz_usuario.util.utils;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletResponseWrapper;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

public class AdfToCSV {
    private String vTitulos[];
    private String vOrden[];
    private String vNombreArchivo;
    
    public AdfToCSV() {
    }
    
    public void setTitulos(String [] vTitulos){
     this.vTitulos=vTitulos;   
    }
    
    public void setOrden(String [] vOrden){
     this.vOrden=vOrden;
    }
    
    public void setNomArchivo(String vNom){
        this.vNombreArchivo=vNom;
    }
    
    /**
     * Método tomado y adaptado de iAdvise, de su artículo 
     * "Export ADF Table To Excel" del 11 de Abril de 2007, http://iadvise.blogspot.com/2007/04/export-adf-table-to-excel.html.
     * Este método coge una tabla ADF cualquiera y devuelve al usuario su contenido
     * en una hoja excel
     * 
     * @param tableContent Tabla con el contenido
     * @throws IOException 
     */
    public void exportHtmlTableToExcelOrig(DCIteratorBinding tableContent) throws IOException {

        //Set the filename DateTime dt = new
        Date ahora = new Date();
        Object vValorCol;

        // El nombre habría que tratar de hacerlo pseudoúnico de una mara más fina
        String filename = ahora.toString() + ".csv";


        //Setup the output 
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponseWrapper response = 
            (HttpServletResponseWrapper)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", 
                           "attachment; filename=" + filename);

        response.setContentType(contentType);
        PrintWriter out = response.getWriter();

        // Obtengo el iterador de la tabla
        RowSetIterator rsi = tableContent.getRowSetIterator();

        String[] attNames = rsi.getRowAtRangeIndex(0).getAttributeNames();

        // Pinta el título de las columnas
        for (int i = 0; i < attNames.length; i++) {

            out.print(attNames[i] + ",");

        }

        out.println();
        
        // Obtengo el índice del registro actual
        Row filaSeleccionada = rsi.getCurrentRow();
        
        // Me posiciono en el primer registro
        rsi.first();
        
        Row currentRow;
        // Itero por todas las filas
        while ((currentRow = rsi.getCurrentRow()) != null) {
            Object[] attValues = currentRow.getAttributeValues();
            
            
            // Recorro cada columna y escribo su valor
            for (int j = 0; j < attValues.length; j++) {
                
                vValorCol=attValues[j];
                
                if (vValorCol!=null && vValorCol.getClass()==oracle.jbo.domain.Date.class){
                    
                    vValorCol=utils.getFechaFormato2("dd/MM/yyyy",(oracle.jbo.domain.Date)vValorCol);
                    
                }            
                out.print((vValorCol==null?" ":vValorCol) + ",");
            }

            out.println();

            // Muevo el iterador hacia delante
            rsi.next();
        }
        out.close();

        // Finaliza el fichero
        fc.responseComplete();
        
        // Vuelvo a dejar al iterador posicionado donde lo encontré, para evitar errores
        // de "cambio de divisa"
        rsi.setCurrentRow( filaSeleccionada );

    }


    private String LimpiarCadena(String pValor)
    {
      String vResultado;  
        
        vResultado=pValor.replace("\"","");
        vResultado=vResultado.replace(",","");
        
    return vResultado;    
    }

    public  void exportHtmlTableToExcelCustom(DCIteratorBinding tableContent) throws IOException {

        //Set the filename DateTime dt = new
        Date ahora = new Date();
        Object vValorCol;
        int vLinea=0;

        // El nombre habría que tratar de hacerlo pseudoúnico de una mara más fina
        String filename =  vNombreArchivo+ ".csv";


        //Setup the output 
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponseWrapper response = 
            (HttpServletResponseWrapper)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", 
                           "attachment; filename=" + filename);

        response.setContentType(contentType);
        PrintWriter out = response.getWriter();

        // Obtengo el iterador de la tabla
        RowSetIterator rsi = tableContent.getRowSetIterator();

        String[] attNames = this.vTitulos;

        // Pinta el título de las columnas
        for (int i = 0; i < attNames.length; i++) {

            out.print(attNames[i] + ",");

        }

        out.println();
        
        // Obtengo el índice del registro actual
        Row filaSeleccionada = rsi.getCurrentRow();
        
        // Me posiciono en el primer registro
        rsi.first();
        
        Row currentRow;
        // Itero por todas las filas
        
      try{  
      
        while ((currentRow = rsi.getCurrentRow()) != null) {
          //  Object[] attValues = currentRow.getAttributeValues();
            
            // Recorro cada columna y escribo su valor
            for (int j = 0; j < vOrden.length; j++) {

                vValorCol=currentRow.getAttribute(vOrden[j]);
               /* 
                if (vLinea>450){
                    System.out.println("linea"+vLinea+ "col "+vValorCol);
                }
                */
                if (vValorCol!=null && vValorCol.getClass()==oracle.jbo.domain.Date.class){
                    
                    vValorCol=utils.getFechaFormato2("dd/MM/yyyy",(oracle.jbo.domain.Date)vValorCol);
                    
                }            
                
               
                out.print((vValorCol==null?" ":LimpiarCadena(vValorCol.toString())) + ",");
             
            }
            vLinea++;
          //  System.out.println("l "+vLinea);
            out.println();

            if (vLinea==200){
                out.flush();
                vLinea=0;
            }
            // Muevo el iterador hacia delante
            rsi.next();
        }
        out.close();
        

        // Finaliza el fichero
        fc.responseComplete();
        
        // Vuelvo a dejar al iterador posicionado donde lo encontré, para evitar errores
        // de "cambio de divisa"
        rsi.setCurrentRow( filaSeleccionada );
      }catch(Exception exep){
          
          exep.printStackTrace();
          
      }
    }




    
}
