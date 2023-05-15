package interfaz_usuario.backing.reportes.dts;

import java.math.BigDecimal;

import java.sql.ResultSet;

import java.util.ArrayList;

import pkg_util_base_datos.interfaz_DB;

public class fill_data {
   interfaz_DB vConexion;
   String SqlQuerryCheque="select unique a.id_documento_banco,\n" + 
     "a.num_doc_fisico,\n" + 
     "valor,\n" + 
     "sis_pkg_util.getNumero_to_letras(valor,2) as valTexto,\n" + 
     "fecha_emision,\n" + 
     "nvl(g.nom_beneficiario,g.nomcompletocheq) as nomcompletocheq,\n" + 
     "g.registro_empleado,\n" + 
     "j.nombre as nomDependencia,i.ID_PROGRAMA||trim(to_char(i.ID_DEPENDENCIA,'00'))||i.ID_UNIDAD as partidaUnidad,\n" + 
     "sis_pkg_util.getNominaChequeCodAnt(a.id_documento_banco,<IdProceso>) as nomina ,\n" + 
     "k.fecha_Ref\n" + 
     ",\n" + 
     "(\n" + 
     "select sum(nominal) \n" + 
     "from sis_documento_banco a1,\n" + 
     "sis_pago b1,\n" + 
     "sis_nomina c1\n" + 
     "where  b1.id_proceso=<IdProceso>\n" + 
     "and a1.id_documento_banco=b1.id_documento_banco\n" + 
     "and b1.id_nomina=c1.id_nomina\n" + 
     "and a1.id_documento_banco=a.id_documento_banco\n" + 
     ") as total_nominal,\n" + 
     "(\n" + 
     "select sum(total_bono) \n" + 
     "from sis_documento_banco a1,\n" + 
     "sis_pago b1,\n" + 
     "sis_nomina c1\n" + 
     "where  b1.id_proceso=<IdProceso>\n" + 
     "and a1.id_documento_banco=b1.id_documento_banco\n" + 
     "and b1.id_nomina=c1.id_nomina\n" + 
     "and a1.id_documento_banco=a.id_documento_banco\n" + 
     ") as total_bono,\n" + 
     "(\n" + 
     "select sum(total_descuento) \n" + 
     "from sis_documento_banco a1,\n" + 
     "sis_pago b1,\n" + 
     "sis_nomina c1\n" + 
     "where  b1.id_proceso=<IdProceso>\n" + 
     "and a1.id_documento_banco=b1.id_documento_banco\n" + 
     "and b1.id_nomina=c1.id_nomina\n" + 
     "and a1.id_documento_banco=a.id_documento_banco\n" + 
     ") as total_desc,\n" + 
     "g.clv,\n" + 
     "a.num_inventario,\n" + 
     "to_number(to_char(fecha_emision,'yyyy'))-1 as anioISR,\n" + 
     "(\n" + 
     "select count(0)\n" + 
     "from sis_nomina nom,\n" + 
     "sis_pago pg\n" + 
     "where nom.id_nomina=pg.id_nomina\n" + 
     "and pg.id_documento_banco=a.id_documento_banco\n" + 
     "and nom.id_tipo_nomina=20\n" + 
     "and pg.id_proceso=<IdProceso>"+
     "and rownum<=1\n" + 
     ") asChequeISR\n" + 
     "from sis_documento_banco a, \n" + 
     "sis_tipo_documento b, \n" + 
     "sis_nomina d,\n" + 
     "sis_empleado g,\n" + 
     "sis_partida i,\n" + 
     "sis_dependencia j, \n" + 
     "sis_proceso k\n" + 
     "where a.id_tipo_documento=b.id_tipo_documento\n" + 
     "and b.nombre='CHEQUE'\n" + 
     "and exists(\n" + 
     "select 1 from sis_estado_docbanco_vw e\n" + 
     "where e.id_estado=a.id_estado\n" + 
     "and e.nombre in('GENERADO','CIRCULACION')\n" + 
     ")\n" + 
     "and d.registro_empleado=g.registro_empleado\n" + 
     "and i.id_partida=d.id_partida\n" + 
     "and i.id_dependencia=j.id_dependencia\n" + 
     "and k.id_proceso=a.id_proceso\n" + 
     "and k.id_proceso=<IdProceso>\n" + 
     "and exists(\n" + 
     "select 1 from sis_pago f\n" + 
     "where f.id_proceso=<IdProceso>\n" + 
     "and f.id_nomina=d.id_nomina\n" + 
     "and f.id_documento_banco=a.id_documento_banco\n" + 
     ")\n" + 
     "order by num_doc_fisico asc\n";
     
   String vSqlQuerryPlazas="select case when d.id_partida_egreso is not null then\n" + 
   " sis_pkg_pagos.GETPARTIDAPAGOTP2(d.id_partida_egreso,-1)\n" + 
   " else\n" + 
   " sis_pkg_pagos.GETPARTIDAPAGOTP2(d.id_partida,d.id_tipo_nomina)\n" + 
   " end as partidaPago,\n" + 
   "a.formato1,to_char(d.numero_plaza,'0000') as numero_plaza,\n" + 
   "c.nombreabrev as nomPuesto,\n" + 
   "d.nominal,g.codigo||'/'||to_char(nvl(d.anio_periodo,d.correlativo)) as nomina\n" + 
   "from sis_partida_vw a, sis_puesto c,sis_nomina d, sis_documento_banco e,sis_pago f,sis_tiponomina_periodo g \n" + 
   "where a.id_partida=d.id_partida\n" + 
   "and d.id_puesto=c.id_puesto\n" + 
   "and g.id_tipo_nomina=d.id_tipo_nomina\n" + 
   "and g.id_periodo=d.periodo\n" + 
   "and f.id_nomina=d.id_nomina\n" + 
   "and f.id_documento_banco=e.id_documento_banco\n" + 
   "and f.id_proceso=<pIdProceso>\n" + 
   "and e.id_documento_banco=<pIdDocumento>\n" + 
   "and rownum<18\n" + 
   "order by numero_plaza,d.anio,g.codigo asc";
   
   String vSqlDesc="select  b.cod_nomina,abs(sum(valor_aplicado)) as valor\n" + 
   "from sis_det_calculo_ajuste a, sis_ajuste b\n" + 
   "where a.id_ajuste=b.id_ajuste\n" + 
   "and exists(\n" + 
   "select 1 from sis_nomina c, sis_pago d, sis_documento_banco e\n" + 
   "where c.id_nomina=a.id_nomina\n" + 
   "and c.id_nomina=d.id_nomina\n" + 
   "and d.id_documento_banco=e.id_documento_banco\n" + 
   "and e.id_documento_banco=<pIdDocumento> \n" + 
   "and d.id_proceso=<pIdProceso>\n" + 
   ")\n" + 
   "and valor_aplicado<0\n" + 
   "group by b.cod_nomina\n" + 
   "order by cod_nomina asc";
   
   boolean vError=false;
   private String vDebug;
   
   
    public fill_data() {
    
      vConexion=new interfaz_DB();
     
    }
    
public ArrayList getCheques(BigDecimal pIdProceso)
{
 
 ResultSet vFilas;
 ArrayList vResultado=new ArrayList();
 Cheque vCheque,vChequeanul;
 BigDecimal vNumChequeActual,vNumChequeAnt=null;
 String SqlQuerry,SqlQuerry2;
 int vDiferenciaCheques;
 BigDecimal vTemp=new BigDecimal("0"),vValorcero=new BigDecimal(0);
 int vTamCheques;
 
 SqlQuerry=this.SqlQuerryCheque.replace("<IdProceso>",pIdProceso.toString());
  vError=false;
 try
 {
     vDebug="";
 
     vFilas=vConexion.Bol_ejecutar_sentencia(SqlQuerry);
     
      while (vFilas.next())
      {
      
        vCheque=new Cheque();
        vCheque.setID_DOCUMENTO_BANCO(vFilas.getBigDecimal("id_documento_banco"));
        vCheque.setNUM_DOC_FISICO(vFilas.getBigDecimal("num_doc_fisico"));
        vCheque.setVALOR(vFilas.getBigDecimal("valor"));
        vCheque.setVALTEXTO(vFilas.getString("valTexto"));
        vCheque.setFECHA_EMISION(vFilas.getTimestamp("fecha_emision"));
        vCheque.setNOMCOMPLETOCHEQ(vFilas.getString("nomcompletocheq"));
        vCheque.setREGISTRO_EMPLEADO(vFilas.getBigDecimal("registro_empleado"));
        vCheque.setNOMDEPENDENCIA(vFilas.getString("nomDependencia"));
        vCheque.setPARTIDAUNIDAD(vFilas.getString("partidaUnidad"));
        vCheque.setNOMINA(vFilas.getString("nomina"));
        vCheque.setFECHA_REF(vFilas.getTimestamp("fecha_ref"));
        vCheque.setTOTAL_NOMINAL(vFilas.getBigDecimal("total_nominal"));
        vCheque.setTOTAL_BONO(vFilas.getBigDecimal("total_bono"));
        vCheque.setTOTAL_DESC(vFilas.getBigDecimal("total_desc"));
        vCheque.setCLV(vFilas.getString("clv"));
        vCheque.setNUM_INVENTARIO(vFilas.getBigDecimal("num_inventario"));
        vCheque.setANIOISR(vFilas.getBigDecimal("anioISR"));
        vCheque.setASCHEQUEISR(vFilas.getBigDecimal("asChequeISR"));
          
          vNumChequeActual=vCheque.getNUM_DOC_FISICO();
          
          if (vNumChequeAnt==null){
              vNumChequeAnt=vNumChequeActual;
          }else if (vNumChequeAnt!=null)
          {
             vNumChequeAnt=vNumChequeAnt.add(new BigDecimal(1));
             
             if (vNumChequeAnt.compareTo(vNumChequeActual)<0)
             {
              vDiferenciaCheques=vNumChequeActual.subtract(vNumChequeAnt).intValue();
                for (int vContador=0;vContador<vDiferenciaCheques;vContador++)
                {
                
                    vChequeanul=new Cheque();
                    //vChequeanul.setID_DOCUMENTO_BANCO(vTemp.add(new BigDecimal(vContador)));
                     vChequeanul.setID_DOCUMENTO_BANCO(vTemp.add(new BigDecimal(0)));
                    vChequeanul.setNUM_DOC_FISICO(new BigDecimal(vNumChequeAnt.toString()).add(new BigDecimal(vContador)));
                    vChequeanul.setVALOR(new BigDecimal(0));
                    vChequeanul.setVALTEXTO("A N U L A D O");
                    //vChequeanul.setFECHA_EMISION(vFilas.getTimestamp("fecha_emision"));
                    vChequeanul.setNOMCOMPLETOCHEQ("A N U L A D O");
                    //vChequeanul.setREGISTRO_EMPLEADO("");
                    vChequeanul.setNOMDEPENDENCIA(" ");
                    vChequeanul.setPARTIDAUNIDAD(" ");
                    //vChequeanul.setNOMINA(vFilas.getString("nomina"));
                    //vChequeanul.setFECHA_REF(vFilas.getTimestamp("fecha_ref"));
                    vChequeanul.setTOTAL_NOMINAL(new BigDecimal(0));
                    vChequeanul.setTOTAL_BONO(new BigDecimal(0));
                    vChequeanul.setTOTAL_DESC(new BigDecimal(0));
                    vChequeanul.setCLV("");
                   // vChequeanul.setNUM_INVENTARIO(vFilas.getBigDecimal("num_inventario"));
                    //vChequeanul.setANIOISR(vFilas.getBigDecimal("anioISR"));
                    vChequeanul.setASCHEQUEISR(new BigDecimal(0));
                    
                    vResultado.add(vChequeanul);          
                }
              
                vNumChequeAnt=vNumChequeActual;  
             }
            
          }   
          
        vResultado.add(vCheque);          
      }

 vFilas.close();
 vConexion.cerrarSentenciaActual();
 
     ///  agregando las plazas y descuentos   
      vTamCheques=vResultado.size();
     vDebug=vDebug+"\n Tamanio del array: "+vTamCheques+ " \n";
     
      for ( int pos=0;pos<vTamCheques; pos++)      
      {
      
          vCheque=(Cheque)vResultado.get(pos);
          
          if (vCheque.getID_DOCUMENTO_BANCO().compareTo(vValorcero)!=0)
          {
              
          
          
              SqlQuerry=this.vSqlQuerryPlazas;
              SqlQuerry=SqlQuerry.replace("<pIdProceso>",pIdProceso.toString());
              SqlQuerry=SqlQuerry.replace("<pIdDocumento>",vCheque.getID_DOCUMENTO_BANCO().toString() );
              
              vFilas=vConexion.Bol_ejecutar_sentencia(SqlQuerry);
              
              vDebug=vDebug+" PLAZAS "+vCheque.getID_DOCUMENTO_BANCO();
              while (vFilas!=null && vFilas.next())
              {
                vCheque.addPlaza(vFilas.getString("partidaPago"),vFilas.getString("formato1"),vFilas.getString("numero_plaza"),vFilas.getString("nomPuesto"),vFilas.getBigDecimal("nominal"),vFilas.getString("nomina"));  
               // System.out.println("debug "+ pos);  
                vDebug=vDebug+" "+vFilas.getString("numero_plaza")+", ";
              }     
              
              //vDebug=vDebug+"\n ";
              vFilas.close();
              vConexion.cerrarSentenciaActual();
              
              SqlQuerry=this.vSqlDesc;
              SqlQuerry=SqlQuerry.replace("<pIdProceso>",pIdProceso.toString());
              SqlQuerry=SqlQuerry.replace("<pIdDocumento>",vCheque.getID_DOCUMENTO_BANCO().toString());
              
              vFilas=vConexion.Bol_ejecutar_sentencia(SqlQuerry);
              
              vDebug=vDebug+" DESC "+vCheque.getID_DOCUMENTO_BANCO();
              while (vFilas!=null && vFilas.next())
              {
                vCheque.addDesc(vFilas.getString("cod_nomina"),vFilas.getBigDecimal("valor"));  
                vDebug=vDebug+" "+vFilas.getString("cod_nomina")+", ";  
              }     
              
              vDebug=vDebug+"\n ";
              vFilas.close();
              vConexion.cerrarSentenciaActual();
              
          }
      }
 
 vConexion.cn_Cerrar_coneccion();

 
 }catch(Exception exep)
 {
    vConexion.cn_Cerrar_coneccion();
    exep.printStackTrace();
    vError=true;
    vDebug=vDebug+exep.getMessage();
    
 }
 
return vResultado;        
}


    public void setIsError(boolean vError) {
        this.vError = vError;
    }

    public boolean isIsError() {
        return vError;
    }

    public void setDebug(String vDebug) {
        this.vDebug = vDebug;
    }

    public String getDebug() {
        return vDebug;
    }
}
