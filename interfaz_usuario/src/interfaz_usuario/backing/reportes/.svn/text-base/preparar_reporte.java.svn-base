package interfaz_usuario.backing.reportes;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.generar_reporte;
import interfaz_usuario.util.util_zip;
import interfaz_usuario.util.utils;

import java.math.BigDecimal;

import pkg_carga_datos.archivo;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import oracle.jbo.domain.Number;

public class preparar_reporte {

    private String vDebug;
    
    public preparar_reporte() {
    
       // System.setProperty("file.encoding", "Cp1252");
        //System.out.println("Dejar  " + System.getProperty("file.encoding"));
        
    }
    
    
    public static void main(String args[]){
      
      try{
    //    Class.forName("oracle.jdbc.OracleDriver"); 
       //new preparar_reporte().preparar_nomina2(utils.getNumberOracle(304),"NOMINA NORMAL","C:\\"); 
     //  new preparar_reporte().generar_rep_pago(utils.getNumberOracle(358));
        
      }catch(Exception exep){
          
          
      }
    }
    
    public void preparar_nomina(oracle.jbo.domain.Number pIdProceso,String nombre_tipo){
         
       String directorio=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");   
        preparar_nomina(pIdProceso,nombre_tipo,directorio);
         
    }

    public void preparar_nomina2(oracle.jbo.domain.Number pIdProceso,String nombre_tipo){
         
       String directorio=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");   
        preparar_nomina2(pIdProceso,nombre_tipo,directorio);
         
    }
    
    public void preparar_nomina(oracle.jbo.domain.Number pIdProceso,String nombre_tipo,String pDirectorio){
            
        boolean c1,c2;    
        long vNumPaginasReporte;
        //System.out.print("esta es la nomina de: "+anio+" "+periodo+" "+tipo);
        String directorio=pDirectorio;//FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
        //String directorio="C:\\";
     
        generar_reporte  reporteContrato=new generar_reporte();
        //HashMap hm=new HashMap();
        //generar_reporte reporteContrato;
        reporteContrato=new generar_reporte();
        HashMap parametrosReporte = new HashMap();
        parametrosReporte.put("pIdProceso",pIdProceso.bigDecimalValue());
       // parametrosReporte.put("ANIO",anio);
       // parametrosReporte.put("PERIODO",periodo);
       // parametrosReporte.put("TIPO_NOMINA",tipo);
        
        reporteContrato.setParametros(parametrosReporte);
       //verificar
        String nombre_archivo=generar_nombre_archivo(nombre_tipo,pIdProceso.toString(),0/*anio*/,0/*periodo*/,2);
        c1=reporteContrato.generarReporteTexto("nomina_sueldos.jasper",directorio,nombre_archivo+".txt",3,11);
        vNumPaginasReporte=reporteContrato.getNumPaginas();
        
        c2=reporteContrato.generarReporteTexto("resumen_nomina_sueldos.jasper",directorio,nombre_archivo+"_resumen"+".txt",3,11);
        vNumPaginasReporte=vNumPaginasReporte+reporteContrato.getNumPaginas();
        
        util_zip salida= new util_zip();
        ArrayList archivos= new ArrayList();
        
        String directorio2 = directorio.substring(0,directorio.length()-1);
        
        directorio2=new String(directorio2.substring( directorio2.lastIndexOf("/")+1,directorio2.length())+"/");
        
        if(c1 && c2){ 
                new archivo(directorio+nombre_archivo+".txt").concatenarInicioArchivo( null,new String(new char[]{27,48,27,67,68,27,80,18,15}),false);
                new archivo(directorio+nombre_archivo+".txt").concatenarFinArchivo(directorio+nombre_archivo+"_resumen"+".txt",true,true);
                //convertir a zip
                archivos.add(directorio+nombre_archivo+".txt");
                salida.setBorrarFuentes(true);
                nombre_archivo=nombre_archivo.replaceAll("%","prcnt");
                salida.crear_zip(directorio+nombre_archivo+".zip",archivos);
                
                
                reporteContrato.insertar_archivo_generado("NOMINA",directorio2,nombre_archivo+".zip");
                
                utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reporte Generado: "+nombre_archivo+".zip [Numero Paginas aprox:" +vNumPaginasReporte+"]"));   
            }else{  
             utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No existen datos para esta Nomina"));   
            }
        
        //Resumen
        //generar_reporte resumenReporteContrato=new generar_reporte();
        //resumenReporteContrato.setParametros(parametrosReporte);
        /*
        if (reporteParams.getParametros()!=null && reporteParams.getParametros().size()>0){
            reporteContrato.setParametros(reporteParams.getParametros());
            reporteContrato.generarReporteTexto("nombramientos.jasper");
        }
        */
}



         public void preparar_nomina2(oracle.jbo.domain.Number pIdProceso,String nombre_tipo,String pDirectorio){
                 
             boolean c1,c2;    
             long vNumPaginasReporte;
             //System.out.print("esta es la nomina de: "+anio+" "+periodo+" "+tipo);
             String directorio=pDirectorio;//FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
             //String directorio="C:\\";
          
             generar_reporte  reporteContrato=new generar_reporte();
             //HashMap hm=new HashMap();
             //generar_reporte reporteContrato;
             reporteContrato=new generar_reporte();
             HashMap parametrosReporte = new HashMap();
             parametrosReporte.put("pIdProceso",pIdProceso.bigDecimalValue());
            // parametrosReporte.put("ANIO",anio);
            // parametrosReporte.put("PERIODO",periodo);
            // parametrosReporte.put("TIPO_NOMINA",tipo);
             
             reporteContrato.setParametros(parametrosReporte);
            //verificar
             String nombre_archivo=generar_nombre_archivo(nombre_tipo,pIdProceso.toString(),0/*anio*/,0/*periodo*/,2);
             c1=reporteContrato.generarReporteTexto("nomina_sueldos_pg.jasper",directorio,nombre_archivo+".txt",3,11);
             vNumPaginasReporte=reporteContrato.getNumPaginas();
             
             c2=reporteContrato.generarReporteTexto("resumen_nomina_sueldos_pg.jasper",directorio,nombre_archivo+"_resumen"+".txt",3,11);
             vNumPaginasReporte=vNumPaginasReporte+reporteContrato.getNumPaginas();
             
             util_zip salida= new util_zip();
             ArrayList archivos= new ArrayList();
             
             String directorio2 = directorio.substring(0,directorio.length()-1);
             
             directorio2=new String(directorio2.substring( directorio2.lastIndexOf("/")+1,directorio2.length())+"/");
             
             if(c1 && c2){ 
                     new archivo(directorio+nombre_archivo+".txt").concatenarInicioArchivo( null,new String(new char[]{27,48,27,67,68,27,80,18,15}),false);
                     new archivo(directorio+nombre_archivo+".txt").concatenarFinArchivo(directorio+nombre_archivo+"_resumen"+".txt",true,true);
                     //convertir a zip
                     archivos.add(directorio+nombre_archivo+".txt");
                     salida.setBorrarFuentes(true);
                     nombre_archivo=nombre_archivo.replaceAll("%","prcnt");
                     salida.crear_zip(directorio+nombre_archivo+".zip",archivos);
                     
                     reporteContrato.insertar_archivo_generado("NOMINA",directorio2,nombre_archivo+".zip");
                     
                     utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reporte Generado: "+nombre_archivo+".zip [Numero Paginas aprox:" +vNumPaginasReporte+"]"));   
                 }else{  
                  utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No existen datos para esta Nomina"));   
                 }
             
             //Resumen
             //generar_reporte resumenReporteContrato=new generar_reporte();
             //resumenReporteContrato.setParametros(parametrosReporte);
             /*
             if (reporteParams.getParametros()!=null && reporteParams.getParametros().size()>0){
                 reporteContrato.setParametros(reporteParams.getParametros());
                 reporteContrato.generarReporteTexto("nombramientos.jasper");
             }
             */
         }


/*
 *  Metodo para generar el reporte para impresion de cheques y detalle de descuentos para las acreditaciones
 */
  public void generar_rep_pago(Number pIdProceso){
             boolean c1,c2;    
             long vNumPaginasReporte;
            // String directorio="c:\\";//FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
             String directorio=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
             generar_reporte  vReporte;
             vReporte=new generar_reporte();
             HashMap parametrosReporte = new HashMap();
             String nombre_archivo;
             String nombre_archivoZip;
             String vIdentificador;
             util_zip salida= new util_zip();
             ArrayList archivos= new ArrayList();
             
             
    if (pIdProceso!=null) {
             parametrosReporte.put("IdProceso",pIdProceso.bigDecimalValue());
            
             vIdentificador=this.getFechaFormato(1);
             vIdentificador="("+pIdProceso.toString()+")-"+vIdentificador;
             vReporte.setParametros(parametrosReporte);
             nombre_archivo=generar_nombre_archivo("Cheques",vIdentificador,0,0,3)+".txt";
            // c1=vReporte.generarReporteTextoChequeDTS("Cheques_dts.jasper",directorio,nombre_archivo,6,11);
             c1=vReporte.generarReporteTextoCheque("Cheques.jasper",directorio,nombre_archivo,6,11);
             vNumPaginasReporte=vReporte.getNumPaginas();
             new archivo(directorio+nombre_archivo).concatenarInicioArchivo( null,new String(new char[]{27,67,51,27,80,18,27,50,27,77,27,80,18,27,50,27,77,13,10,13,10}),false);
  
             archivos.add(directorio+nombre_archivo);
             
            //  c2=false;
                
          
            
             nombre_archivo=generar_nombre_archivo("Detalle_Acreditacion_SIS20",vIdentificador,0,0,3)+".txt";
             c2=vReporte.generarReporteTexto("Det_pagos_Desc.jasper",directorio,nombre_archivo,6,11);
             vNumPaginasReporte=vNumPaginasReporte+vReporte.getNumPaginas();
             new archivo(directorio+nombre_archivo).concatenarInicioArchivo( null,new String(new char[]{27,80,18,27,50,27,77}),false);
             archivos.add(directorio+nombre_archivo);
            
             //archivos.concatenarInicioArchivo( null,new String(new char[]{27,48,27,67,68,27,80,18,15}),false);
        
             
             String directorio2 = directorio.substring(0,directorio.length()-1);
             
             directorio2=new String(directorio2.substring( directorio2.lastIndexOf("/")+1,directorio2.length())+"/");
             
             if((c1 && c2)||vNumPaginasReporte>0){ 
                     nombre_archivoZip="ChequesyDetAcreditaciones"+vIdentificador+".zip";
                     //convertir a zip
                     salida.setBorrarFuentes(true);
                     salida.crear_zip(directorio+nombre_archivoZip,archivos);
                     vReporte.insertar_archivo_generado("CHEQUES Y ACREDITACIONES",directorio2,nombre_archivoZip);
                     
                     utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reporte Generado: "+nombre_archivoZip+" [Numero Paginas aprox:" +vNumPaginasReporte+"]"));   
                 }else{ 
                   if (vReporte.getError()==null){
                       utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No existen datos para generar el reporte"));        
                   }else{
                       utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error: "+vReporte.getError()));        
                   }
                  
                  
                 }
            }      else{
                utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No ha seleccionado el pago")); 
            }
             
         }


    String getFechaFormato(int opcion){
        String vFechaFormato;
        SimpleDateFormat vFormato;
        
        switch(opcion){
                case 1:
                    vFormato = new SimpleDateFormat("ddMMyyyy[HHmm]");
                    vFechaFormato=vFormato.format(new Date());
                break;
                default:
                    vFormato = new SimpleDateFormat("ddMMyyyy");
                    vFechaFormato=vFormato.format(new Date());
                break;
            
        }
        return vFechaFormato;
    }
    
    String generar_nombre_archivo(String nombre_tipo,String vIdentificador,int anio,int periodo,int Opcion){
              String periodoletras;
              NumberFormat formato;
              formato= new DecimalFormat("00");
              periodoletras=formato.format(periodo);
              SimpleDateFormat ab= new SimpleDateFormat("ddMMyyyy[HHmm]");
              String nombre="";
              switch (Opcion){
                 case 1:
                   nombre=new String(nombre_tipo+"_"+periodoletras+anio+'-'+ab.format(new Date()));
                 break;
                 case 2:
                  nombre=new String(nombre_tipo+"("+vIdentificador+")-"+ab.format(new Date()));
                 break;
                 case 3:
                  nombre=new String(nombre_tipo+vIdentificador);
                 break;
                 default:
                 nombre=ab.format(new Date());
                 break;
              }
            
        return nombre;
    }

  
    /*
     *  Metodo para generar el reporte para impresion de cheques y detalle de descuentos para las acreditaciones
     */
      public void generar_rep_pago2(Number pIdProceso){
                 boolean c1,c2;    
                 long vNumPaginasReporte;
                // String directorio="c:\\";//FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
                 String directorio=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DIRECTORIOREPORTESTEXTO");
                 generar_reporte  vReporte;
                 vReporte=new generar_reporte();
                 HashMap parametrosReporte = new HashMap();
                 String nombre_archivo;
                 String nombre_archivoZip;
                 String vIdentificador;
                 util_zip salida= new util_zip();
                 ArrayList archivos= new ArrayList();
                 
                 
        if (pIdProceso!=null) {
                 parametrosReporte.put("IdProceso",pIdProceso.bigDecimalValue());
                
                 vIdentificador=this.getFechaFormato(1);
                 vIdentificador="("+pIdProceso.toString()+")-"+vIdentificador;
                 vReporte.setParametros(parametrosReporte);
                 nombre_archivo=generar_nombre_archivo("Cheques",vIdentificador,0,0,3)+".txt";
                 c1=vReporte.generarReporteTextoChequeDTS("Cheques_dts.jasper",directorio,nombre_archivo,6,11);
                 //c1=vReporte.generarReporteTextoCheque("Cheques.jasper",directorio,nombre_archivo,6,11);
                 vDebug=vReporte.getDebug();
                 vNumPaginasReporte=vReporte.getNumPaginas();
                 new archivo(directorio+nombre_archivo).concatenarInicioArchivo( null,new String(new char[]{27,67,51,27,80,18,27,50,27,77,27,80,18,27,50,27,77,13,10,13,10}),false);
      
                 archivos.add(directorio+nombre_archivo);
                 
                 c2=true;
                    
              
                /*
                 nombre_archivo=generar_nombre_archivo("Detalle_Acreditacion_SIS20",vIdentificador,0,0,3)+".txt";
                 c2=vReporte.generarReporteTexto("Det_pagos_Desc.jasper",directorio,nombre_archivo,6,11);
                 vNumPaginasReporte=vNumPaginasReporte+vReporte.getNumPaginas();
                 new archivo(directorio+nombre_archivo).concatenarInicioArchivo( null,new String(new char[]{27,80,18,27,50,27,77}),false);
                 archivos.add(directorio+nombre_archivo);
                */
                 //archivos.concatenarInicioArchivo( null,new String(new char[]{27,48,27,67,68,27,80,18,15}),false);
            
                 
                 String directorio2 = directorio.substring(0,directorio.length()-1);
                 
                 directorio2=new String(directorio2.substring( directorio2.lastIndexOf("/")+1,directorio2.length())+"/");
                 
                 if((c1 && c2)||vNumPaginasReporte>0){ 
                         nombre_archivoZip="ChequesyDetAcreditaciones"+vIdentificador+".zip";
                         //convertir a zip
                         salida.setBorrarFuentes(true);
                         salida.crear_zip(directorio+nombre_archivoZip,archivos);
                       //  vReporte.insertar_archivo_generado("CHEQUES Y ACREDITACIONES",directorio2,nombre_archivoZip);
                         
                         utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Reporte Generado: "+nombre_archivoZip+" [Numero Paginas aprox:" +vNumPaginasReporte+"]"));   
                     }else{ 
                       if (vReporte.getError()==null){
                           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No existen datos para generar el reporte"));        
                       }else{
                           utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Ha ocurrido un error: "+vReporte.getError()));        
                       }
                      
                      
                     }
                }      else{
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"No ha seleccionado el pago")); 
                }
                 
             }


    public String getDebug() {
        return vDebug;
    }
}
