package interfaz_usuario.backing.util;

import enlace_datos.util.resulOp;
import enlace_datos.util.utils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.event.ActionEvent;
import javax.xml.parsers.*;

import oracle.jbo.JboException;

import org.w3c.dom.*;
import org.xml.sax.*;



import oracle.adf.view.faces.component.core.data.CoreTable;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.model.RowKeySet;
import oracle.adf.view.faces.model.SortableModel;
import oracle.jbo.domain.Date;

import oracle.xml.parser.v2.XMLElement;

public class interrupcion_lab_TableHandler {

    private SortableModel tableModel;
    private CoreTable tbl_interrupcion;
    private CoreCommandButton btn_agregar;
    private CoreCommandButton btn_editar;
    private CoreCommandButton btn_eliminar;
    private CoreCommandButton btn_aceptar;
    private boolean vLlenaTabla=false;

    public interrupcion_lab_TableHandler() {
        Collection<interrupcion_laboral> rows = new ArrayList<interrupcion_laboral>();
        tableModel = new SortableModel(rows);
        /*
        interrupcion_laboral bean = new interrupcion_laboral();
        bean.setSelected(true);
        bean.setTipoInterrupcion("Suspensiones del IGSS");
        bean.setFechaI(new Date());
        bean.setFechaF(new Date());
        
        ((List)tableModel.getWrappedData()).add(0, bean);
        */
    }


    public void createInterrupcion(ActionEvent evt) {
        interrupcion_laboral bean = new interrupcion_laboral();
        bean.setSelected(true);
        ((List)tableModel.getWrappedData()).add(0, bean);
     //   table.setFirst(0);
       // enableSorting(false);
       // disableOtherButtons((CoreCommandButton)evt.getComponent());
     //   table.getSelectionState().clear();
    }


    private void resetSelected() 
    {
          Collection<interrupcion_laboral> vInterrupciones = 
              (Collection<interrupcion_laboral>)tableModel.getWrappedData();
          for (interrupcion_laboral vInterrupcion: vInterrupciones) {
              vInterrupcion.setSelected(false);
          }
   }
     
    public void setTableModel(SortableModel tableModel) {
        this.tableModel = tableModel;
    }

    public SortableModel getTableModel() {
        return tableModel;
    }

    public String agregar_btn() {        
         resetSelected();
         interrupcion_laboral bean = new interrupcion_laboral();
         bean.setSelected(true);
         bean.setTipoInterrupcion("Suspensiones del IGSS");
         ((List)tableModel.getWrappedData()).add(0, bean);
         disableOtherButtons(this.getBtn_agregar());
        return null;
    }

    public void setTbl_interrupcion(CoreTable tbl_interrupcion) {
        this.tbl_interrupcion = tbl_interrupcion;
    }

    public CoreTable getTbl_interrupcion() {
        return tbl_interrupcion;
    }

    public String editar_btn() {
         RowKeySet rowKeySet = this.tbl_interrupcion.getSelectionState();
         Set set = rowKeySet.getKeySet();
         resetSelected();
         for (Iterator itr = set.iterator(); itr.hasNext(); ) {
             int index = Integer.parseInt((String)itr.next());
             interrupcion_laboral bean = 
                 (interrupcion_laboral)((List)tableModel.getWrappedData()).get(index);
             bean.setSelected(true);
         }
         //enableSorting(false);
         disableOtherButtons(this.getBtn_editar());
        return null;
    }

    public String eliminar_btn() {
         Set<String> selection = this.tbl_interrupcion.getSelectionState().getKeySet();
         for (String rowKey: selection) {
             this.tbl_interrupcion.setRowKey(rowKey);
             interrupcion_laboral bean = (interrupcion_laboral)this.tbl_interrupcion.getRowData();
             ((Collection)tableModel.getWrappedData()).remove(bean);
         }
         this.tbl_interrupcion.getSelectionState().clear();
      return null;   
    }
    
private void disableOtherButtons(CoreCommandButton button) {

if (button == this.getBtn_aceptar())
{
    this.getBtn_agregar().setDisabled(false);
    this.getBtn_eliminar().setDisabled(false);            
    this.getBtn_editar().setDisabled(false);
    this.getBtn_aceptar().setDisabled(true);
} else {
    this.getBtn_agregar().setDisabled(true);
    this.getBtn_eliminar().setDisabled(true);          
    this.getBtn_editar().setDisabled(true);
   this.getBtn_aceptar().setDisabled(false);
}

}


    public void setBtn_agregar(CoreCommandButton btn_agregar) {
        this.btn_agregar = btn_agregar;
    }

    public CoreCommandButton getBtn_agregar() {
        return btn_agregar;
    }

    public void setBtn_editar(CoreCommandButton btn_editar) {
        this.btn_editar = btn_editar;
    }

    public CoreCommandButton getBtn_editar() {
        return btn_editar;
    }

    public void setBtn_eliminar(CoreCommandButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public CoreCommandButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_aceptar(CoreCommandButton btn_aceptar) {
        this.btn_aceptar = btn_aceptar;
    }

    public CoreCommandButton getBtn_aceptar() {
        return btn_aceptar;
    }

public String aceptar_btn() {

    interrupcion_laboral vSeleccionado=this.getSelectedRow();
    boolean vError=false;
    
    if (vSeleccionado!=null){
        
       if (vSeleccionado.getTipoInterrupcion()==null){
           //throw new JboException("Por favor ingrese el tipo de suspención");
          interfaz_usuario.util.utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese el tipo de suspención"),"form1:page1:tbl_interrupt");
          vError=true;
       }
        
       if (vSeleccionado.getFechaI()==null){
         //  interfaz_usuario.util.utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese la fecha suspención"));
           interfaz_usuario.util.utils.setADFMensajetoControl(new resulOp(resulOp.OPE_ERROR,"Por favor ingrese la fecha suspención"),"form1:page1:tbl_interrupt");
           //throw new JboException("Por favor ingrese la fecha suspención");
        //   utils.se
           vError=true;
       }
    }
     
    if (vError==false){
        resetSelected();
        disableOtherButtons(this.getBtn_aceptar());
        this.tbl_interrupcion.getSelectionState().clear();
  
    }
      
      return null;
}
    
public String getFilas(){
String vXML;
Collection<interrupcion_laboral> vInterrupciones = 
        (Collection<interrupcion_laboral>)tableModel.getWrappedData();

vXML="<interrupciones>";

for (interrupcion_laboral vInterrupcion: vInterrupciones) {

    vXML=vXML+"<interrupcion>";
    vXML=vXML+"<tipo>"+vInterrupcion.getTipoInterrupcion()+"</tipo>";
     if (vInterrupcion.getFechaI()!=null)
       vXML=vXML+"<fechaI>"+utils.getFechaFormato("dd/MM/yyyy", vInterrupcion.getFechaI())+"</fechaI>";
     else
       vXML=vXML+"<fechaI>"+"</fechaI>";
       
     if (vInterrupcion.getFechaF()!=null)
       vXML=vXML+"<fechaF>"+utils.getFechaFormato("dd/MM/yyyy",vInterrupcion.getFechaF())+"</fechaF>";
     else
       vXML=vXML+"<fechaF>"+"</fechaF>";
       
     vXML=vXML+"</interrupcion>";
 }

vXML=vXML+"</interrupciones>";    

return vXML;
}    


public void setFilas(String pFilas){

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder;
Document doc;
ByteArrayInputStream vXMLBytes;
String vFechas;
int vFilas;

vFilas=((List)tableModel.getWrappedData()).size();

if (vLlenaTabla==false)
{
try{

vLlenaTabla=true;
vXMLBytes=new ByteArrayInputStream(pFilas.getBytes());    
builder = factory.newDocumentBuilder();    
doc = builder.parse(vXMLBytes); 
NodeList list,listTemp;
list=doc.getChildNodes();
interrupcion_laboral bean = new interrupcion_laboral();
Element element;
list=list.item(0).getChildNodes();   

((List)tableModel.getWrappedData()).clear();    
    
for (int i=0; i<list.getLength(); i++) 
{

    element = (Element)list.item(i);
  //element.getChildNodes().item(i).getChildNodes().getLength()
  
    listTemp=element.getChildNodes();
//    element.getNodeName()
    bean = new interrupcion_laboral();
    bean.setSelected(false);
    bean.setTipoInterrupcion(getTextValue(element,listTemp.item(0).getNodeName()));
    
    vFechas=getTextValue(element,listTemp.item(1).getNodeName());
     
    if (vFechas!=null && !vFechas.equals(""))
      bean.setFechaI(utils.getFechaOracle(vFechas));
  
    vFechas=getTextValue(element,listTemp.item(2).getNodeName());
    
    if (vFechas!=null && !vFechas.equals(""))
     bean.setFechaF( utils.getFechaOracle(vFechas));
    
    ((List)tableModel.getWrappedData()).add(0, bean);
//  System.out.println(element.getNodeName()); 

}
    
}catch(Exception exep)
{
    exep.printStackTrace();    
    
}
}     

}

private String getTextValue(Element ele, String tagName) {
String textVal = null;

try{

NodeList nl = ele.getElementsByTagName(tagName);
if(nl != null && nl.getLength() > 0) {
   Element el = (Element)nl.item(0);
textVal = el.getFirstChild().getNodeValue();
   }
   
}catch(Exception exep){
    
    
}
 return textVal;
}

public void resetTabla(){
    
    vLlenaTabla=false;
    ((List)tableModel.getWrappedData()).clear();    
}


public interrupcion_laboral getSelectedRow()
{
    List vFilas;
    interrupcion_laboral bean,vResp=null;
    vFilas=(List)tableModel.getWrappedData();
    
     for (Iterator itr = vFilas.iterator(); itr.hasNext(); ) {            
         bean = (interrupcion_laboral)itr.next();
         
          if (bean.isSelected()){
              vResp=bean;
              break;
          }
         
        }
 return vResp;
}


}
