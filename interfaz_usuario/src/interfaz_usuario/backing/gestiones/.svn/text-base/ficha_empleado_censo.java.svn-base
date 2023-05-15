package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.faces.component.core.layout.CoreShowDetailItem;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.NameValuePairs;
import pkg_util_base_datos.interfaz_DB;

public class ficha_empleado_censo {
    private ArrayList vPreguntas;
    private ArrayList vRespuestasX;
    private ArrayList vControlRdSh;
    private String vRegistroEmpl;
    private HashMap vControl;
    private HashMap vIndice;
    private String vGenero;
    private int vEdad;

    //private HashMap vIndicePreg;
    
    private List<SelectItem> vListaPaises;    
    private List<SelectItem> vListaPaisesPass; 
    private List<SelectItem> vListaPaisesDirec; 
    private List<SelectItem> vListaPaisesDirecAnt; 
        
    private List<SelectItem> vListadepts1;
    private List<SelectItem> vListadeptsDPI;
    private List<SelectItem> vListadeptsDirecAnt;
    private List<SelectItem> vListadeptsDirec;
    private List<SelectItem> vListadeptsDirecNoti;
    private Object vListadepts1Sel;
    
    private List<SelectItem> vListamuniNac;
    private List<SelectItem> vListamuniDPI;
    private List<SelectItem> vListamuniDirecAnt;
    private List<SelectItem> vListamuniDirec;
    private List<SelectItem> vListamuniDirecNoti;
    
    
    private Object vListadeptsDPISel;
    private Object vListadeptsDirecAntSel;
    private Object vListadeptsDirecSel;
    private Object vListadeptsDirecSelNoti;
    
    //---
    private Object vDepSelGeneral;
    private Object vMuniSelGeneral;
    public String vGrupoPreguntas;
    private int vNumMaxVeces=0;
    
        
   //--
   private boolean [] vEjecutaCombo={false,false,false,false,false,false};
   
    public ficha_empleado_censo() {
      vPreguntas=new ArrayList();
      vRespuestasX=new ArrayList();
      vControlRdSh=new ArrayList();
      vControl=new HashMap();
      vIndice=new HashMap();
      vListaPaises=null;
     
      
       for (int i=0;i<=150;i++){
         this.vRespuestasX.add(new NameValuePairs());  
         vControlRdSh.add(null);
       }
    }


private List<SelectItem> getListUniversidades(){
        List<SelectItem> vLista;
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExePuestos"); 
        vLista=utils.crearListaCombo("Sis_UniversidadesVwIterator","IdInstitucionAcademica","NombreInstitucion",0) ;    
 return vLista;       
}

private List<SelectItem> getListPuestos(){
    List<SelectItem> vLista;
    JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ExePuestos"); 
    vLista=utils.crearListaCombo("puesto1Iterator","IdPuesto","Nombre",0) ;    
return vLista;   
}
    

private List<SelectItem> getListUnidadAcad(){
        List<SelectItem> vLista;
        vLista=utils.crearListaCombo("SisUnidadAcademicaVwIterator","CodUnidad","Nombre",0) ;    
return vLista;   
}


 //-------------------------------------------------------------    
public List<SelectItem> getListOfPaisesDirecAnt()
 {
       if (vListaPaisesDirecAnt==null){
          vListaPaisesDirecAnt=utils.crearListaCombo("nacionalidadIterator","IdPais","Nombre",0) ;
        }
               
  return vListaPaisesDirecAnt;
  }
 //-------------------------------------------------------------    
        public List<SelectItem> getListOfPaisesDirec()
            {
               if (vListaPaisesDirec==null){
                  vListaPaisesDirec=utils.crearListaCombo("nacionalidadIterator","IdPais","Nombre",0) ;
               }
            
                return vListaPaisesDirec;
            }


 public List<SelectItem> getListOfPaisesPass()
 {
           if (vListaPaisesPass==null){
              vListaPaisesPass=utils.crearListaCombo("nacionalidadIterator","IdPais","Nombre",0) ;
           }
        
            return vListaPaisesPass;
}

//-------------------------------------------------------------    
    public List<SelectItem> getListOfPaises1()
        {
           if (vListaPaises==null){
              vListaPaises=utils.crearListaCombo("nacionalidadIterator","IdPais","Nombre",0) ;
           }
        
            return vListaPaises;
        }

    //--------------------------------------------------------------
    public List<SelectItem> getListOfmuniDirec()
    {
                Object vMuni,vDepto;
                   if (vListamuniDirec==null||vEjecutaCombo[3]==true){
                   
                     if (vListadeptsDirecSel==null)
                     {
                         
                       vMuni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.MunicipioDirec.inputValue}");
                       
                        if (vMuni!=null){
                            
                            this.vMuniSelGeneral=vMuni;
                            this.vDepSelGeneral=null;
                        }else {
                            this.vMuniSelGeneral=null;  
                        }
                     }else{
                         this.vMuniSelGeneral=null;
                         this.vDepSelGeneral=this.vListadeptsDirecSel;    
                     }
                   
                     
                      vEjecutaCombo[3]=false;
                      
                      if (vMuniSelGeneral!=null ||vDepSelGeneral!=null )
                      {
                          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ListMuniCombos");               
                          vListamuniDirec=utils.crearListaComboPrimeroVacio("municipios_dep_by_munIterator","IdMunicipio","Nombre");    

                          if (vListadeptsDirecSel==null){
                              vDepto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDepartamentoMuni.inputValue}");
                              vListadeptsDirecSel=vDepto;
                          }

                      }
                       
                   }
                
      return vListamuniDirec;
    }


    //--------------------------------------------------------------
public List<SelectItem> getListOfmuniDirecNoti()
{
                Object vMuni,vDepto;
                   if (vListamuniDirecNoti==null||vEjecutaCombo[4]==true){
                   
                     if (vListadeptsDirecSelNoti==null)
                     {
                         
                       vMuni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.MunicipioNoti.inputValue}");
                       
                        if (vMuni!=null){
                            
                            this.vMuniSelGeneral=vMuni;
                            this.vDepSelGeneral=null;
                        }else {
                            this.vMuniSelGeneral=null;  
                        }
                     }else{
                         this.vMuniSelGeneral=null;
                         this.vDepSelGeneral=this.vListadeptsDirecSelNoti;    
                     }
                   
                     
                      vEjecutaCombo[4]=false;
                      
                      if (vMuniSelGeneral!=null ||vDepSelGeneral!=null )
                      {
                          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ListMuniCombos");               
                          vListamuniDirecNoti=utils.crearListaComboPrimeroVacio("municipios_dep_by_munIterator","IdMunicipio","Nombre");    

                          if (vListadeptsDirecSelNoti==null){
                              vDepto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDepartamentoMuni.inputValue}");
                              vListadeptsDirecSelNoti=vDepto;
                          }

                      }
                       
                   }
                
  return vListamuniDirecNoti;
}
    
//--------------------------------------------------------------
public List<SelectItem> getListOfmuniDirecAnt()
{
            Object vMuni,vDepto;
               if (vListamuniDirecAnt==null||vEjecutaCombo[2]==true){
               
                 if (vListadeptsDirecAntSel==null)
                 {
                     
                   vMuni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.MunicipioDirecant.inputValue}");
                   
                    if (vMuni!=null){
                        
                        this.vMuniSelGeneral=vMuni;
                        this.vDepSelGeneral=null;
                    }else{
                        this.vMuniSelGeneral=null;
                    }
                 }else{
                     this.vMuniSelGeneral=null;
                     this.vDepSelGeneral=this.vListadeptsDirecAntSel;    
                 }
               
                 
                  vEjecutaCombo[2]=false;
                  
                  if (vMuniSelGeneral!=null ||vDepSelGeneral!=null )
                  {
                      JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ListMuniCombos");               
                      vListamuniDirecAnt=utils.crearListaComboPrimeroVacio("municipios_dep_by_munIterator","IdMunicipio","Nombre");
                      //utils.crearListaCombo("municipios_dep_by_munIterator","IdMunicipio","Nombre",1);    

                      if (vListadeptsDirecAntSel==null){
                          vDepto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDepartamentoMuni.inputValue}");
                          vListadeptsDirecAntSel=vDepto;
                      }
                      /*
                      if (vListamuniDirecAnt!=null && vListamuniDirecAnt.size()==1){
                          
                          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.MunicipioDirecant.inputValue}",((SelectItem)vListamuniDirecAnt.get(0)).getValue());   
                      }
                      */

                  }
                   
               }
            
  return vListamuniDirecAnt;
}

//--------------------------------------------------------------
    public List<SelectItem> getListOfmuniDPI()
        {
        Object vMuni,vDepto;
           if (vListamuniDPI==null||vEjecutaCombo[1]==true){
           
             if (vListadeptsDPISel==null)
             {
                 
               vMuni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.MunicipioDpi.inputValue}");
               
                if (vMuni!=null){
                    
                    this.vMuniSelGeneral=vMuni;
                    this.vDepSelGeneral=null;
                }else{
                    this.vMuniSelGeneral=null;
                }
             }else{
                 this.vMuniSelGeneral=null;
                 this.vDepSelGeneral=this.vListadeptsDPISel;    
             }
           
             
              vEjecutaCombo[1]=false;
              
              if (vMuniSelGeneral!=null ||vDepSelGeneral!=null )
              {
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ListMuniCombos");               
                  vListamuniDPI=utils.crearListaComboPrimeroVacio("municipios_dep_by_munIterator","IdMunicipio","Nombre");    

                  if (vListadeptsDPISel==null){
                      vDepto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDepartamentoMuni.inputValue}");
                      vListadeptsDPISel=vDepto;
                  }

              }
               
           }
        
            return vListamuniDPI;
        }

//---------------------------------------------------------------
    public List<SelectItem> getListOfmuniNac()
        {
        Object vMuni,vDepto;
           if (vListamuniNac==null||vEjecutaCombo[0]==true){
           
             if (vListadepts1Sel==null)
             {
                 
               vMuni=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.MunicipioNacimiento.inputValue}");
               
                if (vMuni!=null){
                    
                    this.vMuniSelGeneral=vMuni;
                    this.vDepSelGeneral=null;
                }else{
                    this.vMuniSelGeneral=null;
                    vListadepts1Sel=null;
                }
             }else{
                 this.vMuniSelGeneral=null;
                 this.vDepSelGeneral=this.vListadepts1Sel;    
             }
           
             
              vEjecutaCombo[0]=false;
              
              if (vMuniSelGeneral!=null ||vDepSelGeneral!=null )
              {
                  JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"ListMuniCombos");               
                  vListamuniNac=utils.crearListaComboPrimeroVacio("municipios_dep_by_munIterator","IdMunicipio","Nombre");    

                  if (vListadepts1Sel==null){
                      vDepto=JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings.IdDepartamentoMuni.inputValue}");
                      vListadepts1Sel=vDepto;
                  }

              }
               
           }
        
            return vListamuniNac;
        }

//-----------------------------------
public List<SelectItem> getListOfDeptsDirecAnt()
 {
    if (vListadeptsDirecAnt==null){
          JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");  
     vListadeptsDirecAnt=utils.crearListaComboPrimeroVacio("todos_los_DepartamentosIterator1","IdDepartamento","Nombre") ;
      }
           
  return vListadeptsDirecAnt;
 }


//-----------------------------------
public List<SelectItem> getListOfDeptsDirec()
{
        if (vListadeptsDirec==null){
        
        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");        
        vListadeptsDirec=utils.crearListaComboPrimeroVacio("todos_los_DepartamentosIterator1","IdDepartamento","Nombre");
        //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"resetQuerryDep");        
        
 }
               
 return vListadeptsDirec;
}

//-----------------------------------
public List<SelectItem> getListOfDeptsDirecNoti()
   {
            if (vListadeptsDirecNoti==null){
             JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");        
             vListadeptsDirecNoti=utils.crearListaComboPrimeroVacio("todos_los_DepartamentosIterator1","IdDepartamento","Nombre") ;
   }
                   
  return vListadeptsDirecNoti;
}

//-----------------------------------
    public List<SelectItem> getListOfDepts1()
        {
           if (vListadepts1==null){
               JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");        
              vListadepts1=utils.crearListaComboPrimeroVacio("todos_los_DepartamentosIterator1","IdDepartamento","Nombre") ;
           }
        
            return vListadepts1;
        }

//-----------------------------------
    public List<SelectItem> getListOfDeptsDPI()
        {
           if (vListadeptsDPI==null){
              JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");        
              vListadeptsDPI=utils.crearListaComboPrimeroVacio("todos_los_DepartamentosIterator1","IdDepartamento","Nombre");
             //JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"DatosCensoDep");        
           }
        
            return vListadeptsDPI;
        }

//------------------------------------------

    public void setListaDepts1(Object pValor)
    {    
       if (vListadepts1Sel!=pValor)
           vEjecutaCombo[0]=true;
        vListadepts1Sel=pValor;    
    }    


    public Object getListaDepts1()
    {
      if (vListadepts1Sel==null)
          getListOfmuniNac();
          
        return vListadepts1Sel;    
    }    
//----------------------------------------

 public void setListaDeptsDPI(Object pValor)
 {    
    if (vListadeptsDPISel!=pValor)
        vEjecutaCombo[1]=true;
     vListadeptsDPISel=pValor;    
 }    


 public Object getListaDeptsDPI()
 {
   if (vListadeptsDPISel==null)
       getListOfmuniDPI();
       
     return vListadeptsDPISel;    
 }    

//----------------------------------------

public void setListaDeptsDirecAnt(Object pValor)
{    
        if (vListadeptsDirecAntSel!=pValor)
            vEjecutaCombo[2]=true;
         vListadeptsDirecAntSel=pValor;    
}    


public Object getListaDeptsDirecAnt()
{
       if (vListadeptsDirecAntSel==null)
           getListOfmuniDirecAnt();
           
         return vListadeptsDirecAntSel;    
}    


//----------------------------------------
public void setListaDeptsDirec(Object pValor)
{    
            if (vListadeptsDirecSel!=pValor)
                vEjecutaCombo[3]=true;
             vListadeptsDirecSel=pValor;    
}    


//----------------------------------------
public void setListaDeptsDirecNoti(Object pValor)
{    
       if (vListadeptsDirecSelNoti!=pValor)
            vEjecutaCombo[4]=true;
       vListadeptsDirecSelNoti=pValor;    
}    


public Object getListaDeptsDirec()
{
           if (vListadeptsDirecSel==null)
               getListOfmuniDirec();
               
             return vListadeptsDirecSel;    
}    


public Object getListaDeptsDirecNoti()
{
     if (vListadeptsDirecSelNoti==null)
      getListOfmuniDirecNoti();
                   
     return vListadeptsDirecSelNoti;    
}    

    
public void setvDepSelGeneral(Object pValor)
    {
        vDepSelGeneral=pValor;    
    }    


    public Object getvDepSelGeneral(){
        return vDepSelGeneral;    
    }    


    public void setvMuniSelGeneral(Object pValor)
    {
        vMuniSelGeneral=pValor;    
    }    


    public Object getvMuniSelGeneral(){
        return vMuniSelGeneral;    
    }    


    public void setRespuesta1(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(1);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros1(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(1);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros1(){
      return ((NameValuePairs)this.vRespuestasX.get(1)).getAttribute("otros");
    }
    public Object getRespuesta1(){
      return ((NameValuePairs)this.vRespuestasX.get(1)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta2(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(2);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros2(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(2);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros2(){
      return ((NameValuePairs)this.vRespuestasX.get(2)).getAttribute("otros");
    }
    public Object getRespuesta2(){
      return ((NameValuePairs)this.vRespuestasX.get(2)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta3(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(3);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros3(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(3);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros3(){
      return ((NameValuePairs)this.vRespuestasX.get(3)).getAttribute("otros");
    }
    public Object getRespuesta3(){
      return ((NameValuePairs)this.vRespuestasX.get(3)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta4(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(4);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros4(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(4);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros4(){
      return ((NameValuePairs)this.vRespuestasX.get(4)).getAttribute("otros");
    }
    public Object getRespuesta4(){
      return ((NameValuePairs)this.vRespuestasX.get(4)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta5(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(5);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros5(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(5);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros5(){
      return ((NameValuePairs)this.vRespuestasX.get(5)).getAttribute("otros");
    }
    public Object getRespuesta5(){
      return ((NameValuePairs)this.vRespuestasX.get(5)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta6(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(6);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros6(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(6);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros6(){
      return ((NameValuePairs)this.vRespuestasX.get(6)).getAttribute("otros");
    }
    public Object getRespuesta6(){
      return ((NameValuePairs)this.vRespuestasX.get(6)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta7(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(7);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros7(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(7);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros7(){
      return ((NameValuePairs)this.vRespuestasX.get(7)).getAttribute("otros");
    }
    public Object getRespuesta7(){
      return ((NameValuePairs)this.vRespuestasX.get(7)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta8(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(8);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros8(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(8);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros8(){
      return ((NameValuePairs)this.vRespuestasX.get(8)).getAttribute("otros");
    }
    public Object getRespuesta8(){
      return ((NameValuePairs)this.vRespuestasX.get(8)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta9(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(9);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros9(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(9);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros9(){
      return ((NameValuePairs)this.vRespuestasX.get(9)).getAttribute("otros");
    }
    public Object getRespuesta9(){
      return ((NameValuePairs)this.vRespuestasX.get(9)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta10(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(10);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros10(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(10);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros10(){
      return ((NameValuePairs)this.vRespuestasX.get(10)).getAttribute("otros");
    }
    public Object getRespuesta10(){
      return ((NameValuePairs)this.vRespuestasX.get(10)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta11(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(11);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros11(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(11);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros11(){
      return ((NameValuePairs)this.vRespuestasX.get(11)).getAttribute("otros");
    }
    public Object getRespuesta11(){
      return ((NameValuePairs)this.vRespuestasX.get(11)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta12(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(12);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros12(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(12);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros12(){
      return ((NameValuePairs)this.vRespuestasX.get(12)).getAttribute("otros");
    }
    public Object getRespuesta12(){
      return ((NameValuePairs)this.vRespuestasX.get(12)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta13(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(13);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros13(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(13);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros13(){
      return ((NameValuePairs)this.vRespuestasX.get(13)).getAttribute("otros");
    }
    public Object getRespuesta13(){
      return ((NameValuePairs)this.vRespuestasX.get(13)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta14(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(14);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros14(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(14);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros14(){
      return ((NameValuePairs)this.vRespuestasX.get(14)).getAttribute("otros");
    }
    public Object getRespuesta14(){
      return ((NameValuePairs)this.vRespuestasX.get(14)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta15(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(15);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros15(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(15);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros15(){
      return ((NameValuePairs)this.vRespuestasX.get(15)).getAttribute("otros");
    }
    public Object getRespuesta15(){
      return ((NameValuePairs)this.vRespuestasX.get(15)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta16(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(16);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros16(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(16);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros16(){
      return ((NameValuePairs)this.vRespuestasX.get(16)).getAttribute("otros");
    }
    public Object getRespuesta16(){
      return ((NameValuePairs)this.vRespuestasX.get(16)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta17(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(17);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros17(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(17);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros17(){
      return ((NameValuePairs)this.vRespuestasX.get(17)).getAttribute("otros");
    }
    public Object getRespuesta17(){
      return ((NameValuePairs)this.vRespuestasX.get(17)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta18(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(18);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros18(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(18);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros18(){
      return ((NameValuePairs)this.vRespuestasX.get(18)).getAttribute("otros");
    }
    public Object getRespuesta18(){
      return ((NameValuePairs)this.vRespuestasX.get(18)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta19(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(19);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros19(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(19);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros19(){
      return ((NameValuePairs)this.vRespuestasX.get(19)).getAttribute("otros");
    }
    public Object getRespuesta19(){
      return ((NameValuePairs)this.vRespuestasX.get(19)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta20(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(20);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros20(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(20);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros20(){
      return ((NameValuePairs)this.vRespuestasX.get(20)).getAttribute("otros");
    }
    public Object getRespuesta20(){
      return ((NameValuePairs)this.vRespuestasX.get(20)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta21(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(21);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros21(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(21);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros21(){
      return ((NameValuePairs)this.vRespuestasX.get(21)).getAttribute("otros");
    }
    public Object getRespuesta21(){
      return ((NameValuePairs)this.vRespuestasX.get(21)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta22(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(22);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros22(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(22);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros22(){
      return ((NameValuePairs)this.vRespuestasX.get(22)).getAttribute("otros");
    }
    public Object getRespuesta22(){
      return ((NameValuePairs)this.vRespuestasX.get(22)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta23(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(23);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros23(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(23);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros23(){
      return ((NameValuePairs)this.vRespuestasX.get(23)).getAttribute("otros");
    }
    public Object getRespuesta23(){
      return ((NameValuePairs)this.vRespuestasX.get(23)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta24(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(24);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros24(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(24);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros24(){
      return ((NameValuePairs)this.vRespuestasX.get(24)).getAttribute("otros");
    }
    public Object getRespuesta24(){
      return ((NameValuePairs)this.vRespuestasX.get(24)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta25(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(25);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros25(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(25);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros25(){
      return ((NameValuePairs)this.vRespuestasX.get(25)).getAttribute("otros");
    }
    public Object getRespuesta25(){
      return ((NameValuePairs)this.vRespuestasX.get(25)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta26(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(26);
      vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros26(Object vValor){
      NameValuePairs vTempoValores;
      vTempoValores=(NameValuePairs)this.vRespuestasX.get(26);
      vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros26(){
      return ((NameValuePairs)this.vRespuestasX.get(26)).getAttribute("otros");
    }
    public Object getRespuesta26(){
      return ((NameValuePairs)this.vRespuestasX.get(26)).getAttribute("ids");
    }
     ////////////////////////////////////////////////////////
     public void setRespuesta27(Object vValor){
       NameValuePairs vTempoValores;
       vTempoValores=(NameValuePairs)this.vRespuestasX.get(27);
       vTempoValores.setAttribute("ids",vValor);
     }
     public void setRespuestaOtros27(Object vValor){
       NameValuePairs vTempoValores;
       vTempoValores=(NameValuePairs)this.vRespuestasX.get(27);
       vTempoValores.setAttribute("otros",vValor);
     }
     public Object getRespuestaOtros27(){
       return ((NameValuePairs)this.vRespuestasX.get(27)).getAttribute("otros");
     }
     public Object getRespuesta27(){
       return ((NameValuePairs)this.vRespuestasX.get(27)).getAttribute("ids");
     }
      ////////////////////////////////////////////////////////
      public void setRespuesta28(Object vValor){
        NameValuePairs vTempoValores;
        vTempoValores=(NameValuePairs)this.vRespuestasX.get(28);
        vTempoValores.setAttribute("ids",vValor);
      }
      public void setRespuestaOtros28(Object vValor){
        NameValuePairs vTempoValores;
        vTempoValores=(NameValuePairs)this.vRespuestasX.get(28);
        vTempoValores.setAttribute("otros",vValor);
      }
      public Object getRespuestaOtros28(){
        return ((NameValuePairs)this.vRespuestasX.get(28)).getAttribute("otros");
      }
      public Object getRespuesta28(){
        return ((NameValuePairs)this.vRespuestasX.get(28)).getAttribute("ids");
      }
      ////////////////////////////////////////////////////////
       public void setRespuesta29(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(29);
         vTempoValores.setAttribute("ids",vValor);
       }
       public void setRespuestaOtros29(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(29);
         vTempoValores.setAttribute("otros",vValor);
       }
       public Object getRespuestaOtros29(){
         return ((NameValuePairs)this.vRespuestasX.get(29)).getAttribute("otros");
       }
       public Object getRespuesta29(){
         return ((NameValuePairs)this.vRespuestasX.get(29)).getAttribute("ids");
       }
       ////////////////////////////////////////////////////////        
        public void setRespuesta30(Object vValor){
          NameValuePairs vTempoValores;
          vTempoValores=(NameValuePairs)this.vRespuestasX.get(30);
          vTempoValores.setAttribute("ids",vValor);
        }
        public void setRespuestaOtros30(Object vValor){
          NameValuePairs vTempoValores;
          vTempoValores=(NameValuePairs)this.vRespuestasX.get(30);
          vTempoValores.setAttribute("otros",vValor);
        }
        public Object getRespuestaOtros30(){
          return ((NameValuePairs)this.vRespuestasX.get(30)).getAttribute("otros");
        }
        public Object getRespuesta30(){
          return ((NameValuePairs)this.vRespuestasX.get(30)).getAttribute("ids");
        }
        ////////////////////////////////////////////////////////         
         public void setRespuesta31(Object vValor){
           NameValuePairs vTempoValores;
           vTempoValores=(NameValuePairs)this.vRespuestasX.get(31);
           vTempoValores.setAttribute("ids",vValor);
         }
         public void setRespuestaOtros31(Object vValor){
           NameValuePairs vTempoValores;
           vTempoValores=(NameValuePairs)this.vRespuestasX.get(31);
           vTempoValores.setAttribute("otros",vValor);
         }
         public Object getRespuestaOtros31(){
           return ((NameValuePairs)this.vRespuestasX.get(31)).getAttribute("otros");
         }
         public Object getRespuesta31(){
           return ((NameValuePairs)this.vRespuestasX.get(31)).getAttribute("ids");
         }
         ////////////////////////////////////////////////////////
          public void setRespuesta32(Object vValor){
            NameValuePairs vTempoValores;
            vTempoValores=(NameValuePairs)this.vRespuestasX.get(32);
            vTempoValores.setAttribute("ids",vValor);
          }
          public void setRespuestaOtros32(Object vValor){
            NameValuePairs vTempoValores;
            vTempoValores=(NameValuePairs)this.vRespuestasX.get(32);
            vTempoValores.setAttribute("otros",vValor);
          }
          public Object getRespuestaOtros32(){
            return ((NameValuePairs)this.vRespuestasX.get(32)).getAttribute("otros");
          }
          public Object getRespuesta32(){
            return ((NameValuePairs)this.vRespuestasX.get(32)).getAttribute("ids");
          }
          ////////////////////////////////////////////////////////
    
           public void setRespuesta33(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(33);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros33(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(33);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros33(){
                return ((NameValuePairs)this.vRespuestasX.get(33)).getAttribute("otros");
           }
           public Object getRespuesta33(){
                return ((NameValuePairs)this.vRespuestasX.get(33)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta34(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(34);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros34(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(34);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros34(){
                return ((NameValuePairs)this.vRespuestasX.get(34)).getAttribute("otros");
           }
           public Object getRespuesta34(){
                return ((NameValuePairs)this.vRespuestasX.get(34)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta35(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(35);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros35(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(35);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros35(){
                return ((NameValuePairs)this.vRespuestasX.get(35)).getAttribute("otros");
           }
           public Object getRespuesta35(){
                return ((NameValuePairs)this.vRespuestasX.get(35)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta36(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(36);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros36(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(36);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros36(){
                return ((NameValuePairs)this.vRespuestasX.get(36)).getAttribute("otros");
           }
           public Object getRespuesta36(){
                return ((NameValuePairs)this.vRespuestasX.get(36)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta37(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(37);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros37(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(37);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros37(){
                return ((NameValuePairs)this.vRespuestasX.get(37)).getAttribute("otros");
           }
           public Object getRespuesta37(){
                return ((NameValuePairs)this.vRespuestasX.get(37)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta38(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(38);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros38(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(38);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros38(){
                return ((NameValuePairs)this.vRespuestasX.get(38)).getAttribute("otros");
           }
           public Object getRespuesta38(){
                return ((NameValuePairs)this.vRespuestasX.get(38)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta39(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(39);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros39(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(39);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros39(){
                return ((NameValuePairs)this.vRespuestasX.get(39)).getAttribute("otros");
           }
           public Object getRespuesta39(){
                return ((NameValuePairs)this.vRespuestasX.get(39)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta40(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(40);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros40(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(40);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros40(){
                return ((NameValuePairs)this.vRespuestasX.get(40)).getAttribute("otros");
           }
           public Object getRespuesta40(){
                return ((NameValuePairs)this.vRespuestasX.get(40)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta41(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(41);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros41(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(41);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros41(){
                return ((NameValuePairs)this.vRespuestasX.get(41)).getAttribute("otros");
           }
           public Object getRespuesta41(){
                return ((NameValuePairs)this.vRespuestasX.get(41)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta42(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(42);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros42(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(42);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros42(){
                return ((NameValuePairs)this.vRespuestasX.get(42)).getAttribute("otros");
           }
           public Object getRespuesta42(){
                return ((NameValuePairs)this.vRespuestasX.get(42)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta43(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(43);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros43(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(43);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros43(){
                return ((NameValuePairs)this.vRespuestasX.get(43)).getAttribute("otros");
           }
           public Object getRespuesta43(){
                return ((NameValuePairs)this.vRespuestasX.get(43)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta44(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(44);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros44(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(44);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros44(){
                return ((NameValuePairs)this.vRespuestasX.get(44)).getAttribute("otros");
           }
           public Object getRespuesta44(){
                return ((NameValuePairs)this.vRespuestasX.get(44)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta45(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(45);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros45(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(45);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros45(){
                return ((NameValuePairs)this.vRespuestasX.get(45)).getAttribute("otros");
           }
           public Object getRespuesta45(){
                return ((NameValuePairs)this.vRespuestasX.get(45)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta46(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(46);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros46(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(46);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros46(){
                return ((NameValuePairs)this.vRespuestasX.get(46)).getAttribute("otros");
           }
           public Object getRespuesta46(){
                return ((NameValuePairs)this.vRespuestasX.get(46)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta47(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(47);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros47(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(47);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros47(){
                return ((NameValuePairs)this.vRespuestasX.get(47)).getAttribute("otros");
           }
           public Object getRespuesta47(){
                return ((NameValuePairs)this.vRespuestasX.get(47)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta48(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(48);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros48(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(48);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros48(){
                return ((NameValuePairs)this.vRespuestasX.get(48)).getAttribute("otros");
           }
           public Object getRespuesta48(){
                return ((NameValuePairs)this.vRespuestasX.get(48)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta49(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(49);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros49(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(49);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros49(){
                return ((NameValuePairs)this.vRespuestasX.get(49)).getAttribute("otros");
           }
           public Object getRespuesta49(){
                return ((NameValuePairs)this.vRespuestasX.get(49)).getAttribute("ids");
           }
           ////////////////////////////////////////////////////////
           public void setRespuesta50(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(50);
                vTempoValores.setAttribute("ids",vValor);
           }
           public void setRespuestaOtros50(Object vValor){
                NameValuePairs vTempoValores;
                vTempoValores=(NameValuePairs)this.vRespuestasX.get(50);
                vTempoValores.setAttribute("otros",vValor);
           }
           public Object getRespuestaOtros50(){
                return ((NameValuePairs)this.vRespuestasX.get(50)).getAttribute("otros");
           }
           public Object getRespuesta50(){
                return ((NameValuePairs)this.vRespuestasX.get(50)).getAttribute("ids");
           }

    ////////////////////////////////////////////////////////
    public void setRespuesta51(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(51);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros51(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(51);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros51(){
         return ((NameValuePairs)this.vRespuestasX.get(51)).getAttribute("otros");
    }
    public Object getRespuesta51(){
         return ((NameValuePairs)this.vRespuestasX.get(51)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta52(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(52);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros52(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(52);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros52(){
         return ((NameValuePairs)this.vRespuestasX.get(52)).getAttribute("otros");
    }
    public Object getRespuesta52(){
         return ((NameValuePairs)this.vRespuestasX.get(52)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta53(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(53);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros53(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(53);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros53(){
         return ((NameValuePairs)this.vRespuestasX.get(53)).getAttribute("otros");
    }
    public Object getRespuesta53(){
         return ((NameValuePairs)this.vRespuestasX.get(53)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta54(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(54);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros54(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(54);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros54(){
         return ((NameValuePairs)this.vRespuestasX.get(54)).getAttribute("otros");
    }
    public Object getRespuesta54(){
         return ((NameValuePairs)this.vRespuestasX.get(54)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta55(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(55);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros55(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(55);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros55(){
         return ((NameValuePairs)this.vRespuestasX.get(55)).getAttribute("otros");
    }
    public Object getRespuesta55(){
         return ((NameValuePairs)this.vRespuestasX.get(55)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta56(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(56);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros56(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(56);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros56(){
         return ((NameValuePairs)this.vRespuestasX.get(56)).getAttribute("otros");
    }
    public Object getRespuesta56(){
         return ((NameValuePairs)this.vRespuestasX.get(56)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta57(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(57);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros57(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(57);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros57(){
         return ((NameValuePairs)this.vRespuestasX.get(57)).getAttribute("otros");
    }
    public Object getRespuesta57(){
         return ((NameValuePairs)this.vRespuestasX.get(57)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta58(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(58);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros58(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(58);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros58(){
         return ((NameValuePairs)this.vRespuestasX.get(58)).getAttribute("otros");
    }
    public Object getRespuesta58(){
         return ((NameValuePairs)this.vRespuestasX.get(58)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta59(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(59);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros59(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(59);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros59(){
         return ((NameValuePairs)this.vRespuestasX.get(59)).getAttribute("otros");
    }
    public Object getRespuesta59(){
         return ((NameValuePairs)this.vRespuestasX.get(59)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta60(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(60);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros60(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(60);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros60(){
         return ((NameValuePairs)this.vRespuestasX.get(60)).getAttribute("otros");
    }
    public Object getRespuesta60(){
         return ((NameValuePairs)this.vRespuestasX.get(60)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta61(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(61);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros61(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(61);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros61(){
         return ((NameValuePairs)this.vRespuestasX.get(61)).getAttribute("otros");
    }
    public Object getRespuesta61(){
         return ((NameValuePairs)this.vRespuestasX.get(61)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta62(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(62);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros62(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(62);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros62(){
         return ((NameValuePairs)this.vRespuestasX.get(62)).getAttribute("otros");
    }
    public Object getRespuesta62(){
         return ((NameValuePairs)this.vRespuestasX.get(62)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta63(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(63);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros63(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(63);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros63(){
         return ((NameValuePairs)this.vRespuestasX.get(63)).getAttribute("otros");
    }
    public Object getRespuesta63(){
         return ((NameValuePairs)this.vRespuestasX.get(63)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta64(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(64);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros64(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(64);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros64(){
         return ((NameValuePairs)this.vRespuestasX.get(64)).getAttribute("otros");
    }
    public Object getRespuesta64(){
         return ((NameValuePairs)this.vRespuestasX.get(64)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta65(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(65);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros65(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(65);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros65(){
         return ((NameValuePairs)this.vRespuestasX.get(65)).getAttribute("otros");
    }
    public Object getRespuesta65(){
         return ((NameValuePairs)this.vRespuestasX.get(65)).getAttribute("ids");
    }

    ////////////////////////////////////////////////////////
    public void setRespuesta66(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(66);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros66(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(66);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros66(){
         return ((NameValuePairs)this.vRespuestasX.get(66)).getAttribute("otros");
    }
    public Object getRespuesta66(){
         return ((NameValuePairs)this.vRespuestasX.get(66)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta67(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(67);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros67(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(67);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros67(){
         return ((NameValuePairs)this.vRespuestasX.get(67)).getAttribute("otros");
    }
    public Object getRespuesta67(){
         return ((NameValuePairs)this.vRespuestasX.get(67)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta68(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(68);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros68(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(68);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros68(){
         return ((NameValuePairs)this.vRespuestasX.get(68)).getAttribute("otros");
    }
    public Object getRespuesta68(){
         return ((NameValuePairs)this.vRespuestasX.get(68)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta69(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(69);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros69(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(69);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros69(){
         return ((NameValuePairs)this.vRespuestasX.get(69)).getAttribute("otros");
    }
    public Object getRespuesta69(){
         return ((NameValuePairs)this.vRespuestasX.get(69)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta70(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(70);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros70(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(70);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros70(){
         return ((NameValuePairs)this.vRespuestasX.get(70)).getAttribute("otros");
    }
    public Object getRespuesta70(){
         return ((NameValuePairs)this.vRespuestasX.get(70)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta71(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(71);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros71(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(71);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros71(){
         return ((NameValuePairs)this.vRespuestasX.get(71)).getAttribute("otros");
    }
    public Object getRespuesta71(){
         return ((NameValuePairs)this.vRespuestasX.get(71)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta72(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(72);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros72(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(72);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros72(){
         return ((NameValuePairs)this.vRespuestasX.get(72)).getAttribute("otros");
    }
    public Object getRespuesta72(){
         return ((NameValuePairs)this.vRespuestasX.get(72)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta73(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(73);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros73(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(73);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros73(){
         return ((NameValuePairs)this.vRespuestasX.get(73)).getAttribute("otros");
    }
    public Object getRespuesta73(){
         return ((NameValuePairs)this.vRespuestasX.get(73)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta74(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(74);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros74(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(74);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros74(){
         return ((NameValuePairs)this.vRespuestasX.get(74)).getAttribute("otros");
    }
    public Object getRespuesta74(){
         return ((NameValuePairs)this.vRespuestasX.get(74)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta75(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(75);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros75(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(75);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros75(){
         return ((NameValuePairs)this.vRespuestasX.get(75)).getAttribute("otros");
    }
    public Object getRespuesta75(){
         return ((NameValuePairs)this.vRespuestasX.get(75)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta76(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(76);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros76(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(76);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros76(){
         return ((NameValuePairs)this.vRespuestasX.get(76)).getAttribute("otros");
    }
    public Object getRespuesta76(){
         return ((NameValuePairs)this.vRespuestasX.get(76)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta77(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(77);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros77(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(77);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros77(){
         return ((NameValuePairs)this.vRespuestasX.get(77)).getAttribute("otros");
    }
    public Object getRespuesta77(){
         return ((NameValuePairs)this.vRespuestasX.get(77)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta78(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(78);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros78(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(78);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros78(){
         return ((NameValuePairs)this.vRespuestasX.get(78)).getAttribute("otros");
    }
    public Object getRespuesta78(){
         return ((NameValuePairs)this.vRespuestasX.get(78)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta79(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(79);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros79(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(79);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros79(){
         return ((NameValuePairs)this.vRespuestasX.get(79)).getAttribute("otros");
    }
    public Object getRespuesta79(){
         return ((NameValuePairs)this.vRespuestasX.get(79)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta80(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(80);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros80(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(80);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros80(){
         return ((NameValuePairs)this.vRespuestasX.get(80)).getAttribute("otros");
    }
    public Object getRespuesta80(){
         return ((NameValuePairs)this.vRespuestasX.get(80)).getAttribute("ids");
    }

    ////////////////////////////////////////////////////////
    public void setRespuesta81(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(81);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros81(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(81);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros81(){
         return ((NameValuePairs)this.vRespuestasX.get(81)).getAttribute("otros");
    }
    public Object getRespuesta81(){
         return ((NameValuePairs)this.vRespuestasX.get(81)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta82(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(82);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros82(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(82);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros82(){
         return ((NameValuePairs)this.vRespuestasX.get(82)).getAttribute("otros");
    }
    public Object getRespuesta82(){
         return ((NameValuePairs)this.vRespuestasX.get(82)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta83(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(83);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros83(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(83);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros83(){
         return ((NameValuePairs)this.vRespuestasX.get(83)).getAttribute("otros");
    }
    public Object getRespuesta83(){
         return ((NameValuePairs)this.vRespuestasX.get(83)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta84(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(84);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros84(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(84);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros84(){
         return ((NameValuePairs)this.vRespuestasX.get(84)).getAttribute("otros");
    }
    public Object getRespuesta84(){
         return ((NameValuePairs)this.vRespuestasX.get(84)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta85(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(85);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros85(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(85);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros85(){
         return ((NameValuePairs)this.vRespuestasX.get(85)).getAttribute("otros");
    }
    public Object getRespuesta85(){
         return ((NameValuePairs)this.vRespuestasX.get(85)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta86(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(86);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros86(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(86);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros86(){
         return ((NameValuePairs)this.vRespuestasX.get(86)).getAttribute("otros");
    }
    public Object getRespuesta86(){
         return ((NameValuePairs)this.vRespuestasX.get(86)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta87(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(87);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros87(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(87);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros87(){
         return ((NameValuePairs)this.vRespuestasX.get(87)).getAttribute("otros");
    }
    public Object getRespuesta87(){
         return ((NameValuePairs)this.vRespuestasX.get(87)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta88(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(88);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros88(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(88);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros88(){
         return ((NameValuePairs)this.vRespuestasX.get(88)).getAttribute("otros");
    }
    public Object getRespuesta88(){
         return ((NameValuePairs)this.vRespuestasX.get(88)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta89(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(89);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros89(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(89);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros89(){
         return ((NameValuePairs)this.vRespuestasX.get(89)).getAttribute("otros");
    }
    public Object getRespuesta89(){
         return ((NameValuePairs)this.vRespuestasX.get(89)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta90(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(90);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros90(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(90);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros90(){
         return ((NameValuePairs)this.vRespuestasX.get(90)).getAttribute("otros");
    }
    public Object getRespuesta90(){
         return ((NameValuePairs)this.vRespuestasX.get(90)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta91(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(91);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros91(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(91);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros91(){
         return ((NameValuePairs)this.vRespuestasX.get(91)).getAttribute("otros");
    }
    public Object getRespuesta91(){
         return ((NameValuePairs)this.vRespuestasX.get(91)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta92(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(92);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros92(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(92);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros92(){
         return ((NameValuePairs)this.vRespuestasX.get(92)).getAttribute("otros");
    }
    public Object getRespuesta92(){
         return ((NameValuePairs)this.vRespuestasX.get(92)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta93(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(93);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros93(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(93);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros93(){
         return ((NameValuePairs)this.vRespuestasX.get(93)).getAttribute("otros");
    }
    public Object getRespuesta93(){
         return ((NameValuePairs)this.vRespuestasX.get(93)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta94(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(94);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros94(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(94);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros94(){
         return ((NameValuePairs)this.vRespuestasX.get(94)).getAttribute("otros");
    }
    public Object getRespuesta94(){
         return ((NameValuePairs)this.vRespuestasX.get(94)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta95(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(95);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros95(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(95);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros95(){
         return ((NameValuePairs)this.vRespuestasX.get(95)).getAttribute("otros");
    }
    public Object getRespuesta95(){
         return ((NameValuePairs)this.vRespuestasX.get(95)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta96(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(96);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros96(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(96);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros96(){
         return ((NameValuePairs)this.vRespuestasX.get(96)).getAttribute("otros");
    }
    public Object getRespuesta96(){
         return ((NameValuePairs)this.vRespuestasX.get(96)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta97(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(97);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros97(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(97);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros97(){
         return ((NameValuePairs)this.vRespuestasX.get(97)).getAttribute("otros");
    }
    public Object getRespuesta97(){
         return ((NameValuePairs)this.vRespuestasX.get(97)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta98(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(98);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros98(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(98);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros98(){
         return ((NameValuePairs)this.vRespuestasX.get(98)).getAttribute("otros");
    }
    public Object getRespuesta98(){
         return ((NameValuePairs)this.vRespuestasX.get(98)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta99(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(99);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros99(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(99);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros99(){
         return ((NameValuePairs)this.vRespuestasX.get(99)).getAttribute("otros");
    }
    public Object getRespuesta99(){
         return ((NameValuePairs)this.vRespuestasX.get(99)).getAttribute("ids");
    }
    ////////////////////////////////////////////////////////
    public void setRespuesta100(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(100);
         vTempoValores.setAttribute("ids",vValor);
    }
    public void setRespuestaOtros100(Object vValor){
         NameValuePairs vTempoValores;
         vTempoValores=(NameValuePairs)this.vRespuestasX.get(100);
         vTempoValores.setAttribute("otros",vValor);
    }
    public Object getRespuestaOtros100(){
         return ((NameValuePairs)this.vRespuestasX.get(100)).getAttribute("otros");
    }
    public Object getRespuesta100(){
         return ((NameValuePairs)this.vRespuestasX.get(100)).getAttribute("ids");
    }



   public void cambiarStatusRespuesta(String pIdRespuesta,String pValor){
       ArrayList vPreguntas;
       Object vPregTemp;
       int vTamanio;
       NameValuePairs vDatos;
       NameValuePairs vResp;
       String vPregunta;
       
       vPregTemp=vIndice.get(pIdRespuesta);
       
       if (vPregTemp!=null){
           
          vPreguntas=(ArrayList)vPregTemp;  
          vTamanio=vPreguntas.size(); 
           
          for (int i=0;i<vTamanio;i++)
          {
          
            vDatos=(NameValuePairs)vPreguntas.get(i);              
            vPregunta=vDatos.getAttribute("id_pregunta").toString();

            vResp=buscarPregunta(vPregunta);
            
              if (vResp!=null)
              {
                  vResp.setAttribute("bajar",pValor); 
                  cambiarStatusPreguntasXPadre(vPregunta,"0");
              }
              
          }
           
       }else
       {
           
           
       }
       
       
   }

    
  /*
   *   Funcion para obtener todas las respuestas del censo
   */
    public void  actRespRadioShwn(){
     int vTamanio,vTamanioDet;
     Object vControl,vIdRepuesta;
     List vDetails;
     CoreShowDetailItem vDetalle;
     CoreShowOneRadio vControlRadio;
     vTamanio= this.vControlRdSh.size();
     String vIdPregunta,vBajar;
     NameValuePairs vPregunta;
     
   //  System.out.println("resp radiosh");
     
      for (int vIndice=1;vIndice<=vTamanio;vIndice++){
          
          vControl=vControlRdSh.get(vIndice);
          if (vControl!=null){
              
              vControlRadio=(CoreShowOneRadio)vControl;
              vDetails=vControlRadio.getChildren();
              vIdPregunta=vControlRadio.getAttributes().get("id_ShwPregunta").toString();
              
              vPregunta=buscarPregunta(vIdPregunta);
              if (vPregunta!=null)
                vBajar=vPregunta.getAttribute("bajar").toString();
              else 
                vBajar="0";
              
              if (vBajar.equals("1")){
                  
            
              vTamanioDet=vDetails.size();
              
              for(int vInd=0;vInd<vTamanioDet;vInd++)
              {
                  vDetalle=(CoreShowDetailItem)vDetails.get(vInd);
                   
                  vIdRepuesta=vDetalle.getAttributes().get("id_showdt");
                  vPregunta=buscarPregunta(vIdPregunta);
                  if (vPregunta!=null)
                  {
                    //  vDetalle.isRendered()
                    if (vDetalle.isDisclosed())
                    { // es el seleccionado                    
                    
                        vPregunta.setAttribute("ids",vIdRepuesta);
                        vPregunta.setAttribute("bajar","1");
                        cambiarStatusRespuesta(vIdRepuesta.toString(),"1");
                      //  break;
                     
                    }
                    
                    else{
                     //  Object vPregTemp; 
                       vNumMaxVeces=0;
                       cambiarStatusRespuesta(vIdRepuesta.toString(),"0");
                      // vPregTemp=this.vIndice.get(vIdRepuesta);
                       
                     //  cambiarStatusPreguntas(vIdPregunta,"0");
                    //    vPregunta.setAttribute("ids",null); 
                    }
                    
                  }
              }
              
          }   
                
          }else{
              break;
          }
          
      }
        
    }
    

/*
 *   Funcion para obtener todas la respuesta de la tabla
 */
public void  actRespTabla(){
       int vTamanio;
       Object vControl,vRespTabla;
       vTamanio= this.vControlRdSh.size();
       NameValuePairs vPregunta;       
       vTamanio=this.vRespuestasX.size();
       
       for (int i=0;i<vTamanio;i++)
       {
           
           
           vPregunta=(NameValuePairs)vRespuestasX.get(i);
           
           vControl=vPregunta.getAttribute("tipo_control");
           
           if (vControl!=null && vControl.equals("TABLAINTERRUP"))
           {       
           
                vRespTabla=JSFUtils.getManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler.filas");
                if (vRespTabla!=null){
                    
                    vPregunta.setAttribute("otros",vRespTabla.toString());  
                }
                break;
               
           }
           
       }
}
    

/*
 *   Funcion para crear filas de la tabla si aplica
 */
public void SetRespTabla(){
           int vTamanio;
           Object vControl,vRespTabla;
           vTamanio= this.vControlRdSh.size();
           NameValuePairs vPregunta;       
           vTamanio=this.vRespuestasX.size();
           
           for (int i=0;i<vTamanio;i++)
           {
               
               
               vPregunta=(NameValuePairs)vRespuestasX.get(i);
               
               vControl=vPregunta.getAttribute("tipo_control");
               
               if (vControl!=null && vControl.equals("TABLAINTERRUP"))
               {       
               
                    vRespTabla=vPregunta.getAttribute("otros");
                    
                    if (vRespTabla!=null){
                    
                        JSFUtils.setManagedBeanValue(FacesContext.getCurrentInstance(),"interrupcion_lab_TableHandler.filas",vRespTabla.toString());    
                        //vPregunta.setAttribute("otros",vRespTabla.toString());  
                    }
                    break;
                   
               }
               
           }
}

    

    /*
     * Método para cambiar el estatus para bajar las respuestas
     */

    public void cambiarStatusPreguntasXPadre(String pIdPregunta,String pValor){
       ArrayList vRespuestas; 
       vRespuestas=this.vRespuestasX; 
       int vTamanio;
       NameValuePairs vPregunta;
       Object vIdPregunta,vIdPreguntaP;
       
       vTamanio=this.vRespuestasX.size();
       
       for (int i=1;i<vTamanio;i++)
       {
       
           vPregunta=(NameValuePairs)vRespuestasX.get(i);
           vIdPreguntaP=vPregunta.getAttribute("id_pregunta_padre");  
           vIdPregunta=vPregunta.getAttribute("id_pregunta");  
           
         if (vIdPregunta!=null)  
         {  
           if (vIdPreguntaP!=null && vIdPreguntaP.toString().equals(pIdPregunta))
           {       
               vPregunta.setAttribute("bajar",pValor);    
               if  (vNumMaxVeces<20)
               {
                vNumMaxVeces++;
               cambiarStatusPreguntasXPadre(vIdPregunta.toString(),pValor); 
               }
           }
         }else {
           break;  
             
         }
         
       }
       
        
  }



/*
 * Funcion para cambiar el estatus para bajar las respuestas
 */

public void setBajarRespuestas(String pValor){
   ArrayList vRespuestas; 
   vRespuestas=this.vRespuestasX; 
   int vTamanio;
   NameValuePairs vPregunta;
   Object vIdPregunta;
   
   vTamanio=this.vRespuestasX.size();
   
   for (int i=1;i<vTamanio;i++)
   {
   
       vPregunta=(NameValuePairs)vRespuestasX.get(i);
       vIdPregunta=vPregunta.getAttribute("id_pregunta");  
       
       if (vIdPregunta!=null)
       {       
        vPregunta.setAttribute("bajar",pValor);    
           
       }else
       {
         break;  
       }
       
   }
   
    
}

 
public Object getTodasRespuestas(){
    
    return vRespuestasX;      
}
    
/*
 * Metodo para buscar una pregunta entre el listado
 */

public NameValuePairs buscarPregunta(String pIdPregunta){
 
    int vRespuestas;
    NameValuePairs vValores,vResultado=null;    
    Object vPregunta;
    
    vRespuestas=vRespuestasX.size();
    
    for(int vindice=0;vindice<vRespuestas;vindice++){
        
        vValores=(NameValuePairs)vRespuestasX.get(vindice);
        vPregunta=vValores.getAttribute("id_pregunta");
        
          if (vPregunta!=null && vPregunta.toString().equals(pIdPregunta))
          {
              vResultado=vValores;
              break;
              
          }    
    }
    
  return  vResultado;
}
 

public void setAtributo(int pPos,String  pAtributo,Object pValor){
    NameValuePairs vValor;
    vValor=(NameValuePairs)vRespuestasX.get(pPos);           
    vValor.setAttribute(pAtributo,pValor);
    
}

 
public void ResetearRespuestas(){
    
    int vTamanio;
    vTamanio=vRespuestasX.size();
    NameValuePairs vValor;
    
    for (int i=0;i<vTamanio;i++){
     vValor=(NameValuePairs)vRespuestasX.get(i);           
     vValor.setAttribute("ids",null);
     vValor.setAttribute("otros",null);
     vValor.setAttribute("id_pregunta",null);
     
    }    
    
    
    
    vTamanio=vControlRdSh.size();
    for (int i=0;i<vTamanio;i++){
   
        vControlRdSh.set(i,null);
    }    
    
    
}
    
 public void EliminarPreguntas(){
        
        
        vPreguntas.removeAll(vPreguntas);
        vIndice.clear();
        
        
}
    
public ArrayList getPreguntas(){
        interfaz_DB con=new interfaz_DB();
        NameValuePairs vValores,vValores2;
        ArrayList vRespuestas;
        int vNumPreguntas,vContaPreg=1;
        Object vDataSource;
        String vPregunta,vRespRel[];
        String vGeneroPreg;
        
        if (vPreguntas.size()==0){
        //System.out.println("Obteniendo las preguntas");
        
        try{
               Connection vCon_conexion=con.get_Coneccion();
               PreparedStatement vPst_sentencia;
            
               vPst_sentencia=vCon_conexion.prepareStatement("select \n" + 
               "fecha_nacimiento,\n" + 
               "floor(months_between(sysdate,fecha_nacimiento)/12) as edad, \n" + 
               "genero \n" + 
               "from sis_ficha_empleado\n" + 
               "where registro_empleado="+vRegistroEmpl);
        
                ResultSet vRst_filas= vPst_sentencia.executeQuery();      
                while (vRst_filas.next()){
                
                     vEdad=vRst_filas.getInt("edad");  
                     vGenero=vRst_filas.getString("genero");
                     
                 }
                 
                vRst_filas.close();
        
                vPst_sentencia=vCon_conexion.prepareStatement(
                "select a.id_pregunta,b.id_categoria,b.nombre_categoria,pregunta,tipo_control,opcion_otros,id_pregunta_padre,id_respuesta_rel,grupo,obligatorio,properties,texto_otros,nom_datasource,imprime_preg,cod_validacion,generopreg \n" + 
                "from sis_pregunta_censo a, \n" + 
                "sis_categoria_pregunta b\n" + 
                "where a.id_categoria=b.id_categoria\n" +
                "and a.estado=1"+
                " and a.grupo="+vGrupoPreguntas+
                " order by id_categoria,orden asc");
                
                 vRst_filas= vPst_sentencia.executeQuery();
                 NameValuePairs vTempoValores;   
                 String vRespuesta_rel;
                 Object vListaTemp1;
                 ArrayList vListaTemp;
                    
                 while (vRst_filas.next())
                 {
                     vPregunta=vRst_filas.getString("pregunta");                     
                     vPregunta=(vPregunta==null?"":vPregunta);  
                     vGeneroPreg=vRst_filas.getString("generopreg");                     
                     
                 
                    if (vGeneroPreg.equals(vGenero) || vGeneroPreg.equals("U"))
                    {
                        
                 
                     vValores=new NameValuePairs();
                     
                     vValores.setAttribute("id_pregunta",vRst_filas.getLong("id_pregunta"));
                     vValores.setAttribute("nombre_categoria",vRst_filas.getString("nombre_categoria"));
                     vValores.setAttribute("pregunta",vRst_filas.getString("pregunta"));
                     vValores.setAttribute("tipo_control",vRst_filas.getString("tipo_control"));
                     vValores.setAttribute("opcion_otros",vRst_filas.getString("opcion_otros"));
                     vValores.setAttribute("id_pregunta_padre",vRst_filas.getString("id_pregunta_padre"));                     
                     vValores.setAttribute("grupo",vRst_filas.getString("grupo")); 
                     vValores.setAttribute("obligatorio",vRst_filas.getString("obligatorio")); 
                     vValores.setAttribute("properties",vRst_filas.getString("properties")); 
                     vValores.setAttribute("id_respuesta_rel",vRst_filas.getString("id_respuesta_rel")); 
                     vValores.setAttribute("texto_otros",(vRst_filas.getString("texto_otros")==null?"":vRst_filas.getString("texto_otros"))); 
                     vValores.setAttribute("nom_datasource",vRst_filas.getString("nom_datasource")); 
                     vValores.setAttribute("imprime_preg",vRst_filas.getString("imprime_preg")); 
                     
                     
                     vRespuesta_rel=vRst_filas.getString("id_respuesta_rel");
                     
                     
                     
                     // para guardar las preguntas que estan relacionadas con una respuesta.
                     if (vRespuesta_rel!=null)
                     {
                         vRespRel=vRespuesta_rel.split("\\|");
                        
                        for (int i=0;i<vRespRel.length;i++)
                        {
                        
                         vListaTemp1=vIndice.get(vRespRel[i]);   
                         
                         if (vListaTemp1!=null){
                             vListaTemp=(ArrayList)vListaTemp1;
                             vListaTemp.add(vValores);
                         }else{
                             vListaTemp=new ArrayList();
                             vListaTemp.add(vValores);
                             vIndice.put(vRespRel[i],vListaTemp);
                         }
                         
                        }    
                             
                     }
                     
                     vPreguntas.add(vValores);
                     
                     vTempoValores=(NameValuePairs)this.vRespuestasX.get(vContaPreg);
                     vTempoValores.setAttribute("id_pregunta",vRst_filas.getLong("id_pregunta"));
                     vTempoValores.setAttribute("grupo",vRst_filas.getLong("grupo"));
                     vTempoValores.setAttribute("tipo_control",vRst_filas.getString("tipo_control"));
                     vTempoValores.setAttribute("bajar","1");
                     vTempoValores.setAttribute("obligatorio",vRst_filas.getString("obligatorio")); 
                     vTempoValores.setAttribute("pregunta",vRst_filas.getString("pregunta"));
                     vTempoValores.setAttribute("id_pregunta_padre",vRst_filas.getString("id_pregunta_padre"));    
                     vTempoValores.setAttribute("cod_validacion",vRst_filas.getString("cod_validacion"));    
                     
                     vContaPreg++;
                    }
                 }
                
                     vNumPreguntas=vPreguntas.size();
                     
                     vPst_sentencia=vCon_conexion.prepareStatement(
                     "select id_respuesta,respuesta,nivel \n" + 
                     "from sis_listrespuesta_censo\n" + 
                     "where id_pregunta=?\n" + 
                     "and estado=1\n" + 
                     "order by orden asc\n");
                 
                 for (int vIndice=0;vIndice<vNumPreguntas;vIndice++)
                 {
                     
                     vValores=(NameValuePairs)vPreguntas.get(vIndice);
                     vDataSource=vValores.getAttribute("nom_datasource");
                     
                     if (vDataSource==null)
                     {
                     
                         vPst_sentencia.setInt(1,Integer.parseInt(vValores.getAttribute("id_pregunta").toString()));
                         vRst_filas=vPst_sentencia.executeQuery();
                         vRespuestas=new ArrayList();
                         
                         while (vRst_filas.next())
                         {
                         
                         
                             vValores2=new NameValuePairs();
                             
                             vValores2.setAttribute("id_respuesta",vRst_filas.getLong("id_respuesta"));
                             vValores2.setAttribute("respuesta",vRst_filas.getString("respuesta"));
                             vValores2.setAttribute("nivel",vRst_filas.getString("nivel"));
                             vRespuestas.add(vValores2);
                             
                             
                         }
                     
                     }else
                     {
                         List<SelectItem> vTemp;   
                         
                         if (vDataSource.toString().equals("UNIVERSIDADES"))
                            vTemp=getListUniversidades();
                         else if (vDataSource.toString().equals("PUESTOS"))
                             vTemp=this.getListPuestos();
                         else if (vDataSource.toString().equals("UNIDAD_ACAD"))    
                             vTemp=this.getListUnidadAcad();
                         else if (vDataSource.toString().startsWith("RANGO")){
                          String vRangos[];   
                          int vInicio,vFin;
                          vRangos=vDataSource.toString().split("\\|");   
                          vInicio=Integer.parseInt(vRangos[2]);
                          vFin=Integer.parseInt(vRangos[3]);
                          
                          vTemp=utils.crearListaComboRangoNum(vInicio,vFin,vRangos[1],1);   
                             
                         }
                         else
                             vTemp=new ArrayList();
                             
                         vRespuestas=new ArrayList();
                        
                        for (int i=0;i<vTemp.size();i++){
                            vValores2=new NameValuePairs();
                            
                            vValores2.setAttribute("id_respuesta",new Long(vTemp.get(i).getValue().toString()));
                            vValores2.setAttribute("respuesta",vTemp.get(i).getLabel());
                            vValores2.setAttribute("nivel","0");
                            vRespuestas.add(vValores2);
                            
                        }
                         
                     }
                     
                     vValores.setAttribute("respuestas",vRespuestas);                         
                 }
                    
                vRst_filas.close(); 
                vCon_conexion.close();
        
                 }catch(Exception exep)  {
                     exep.printStackTrace();
                     
                 }
        }      
   //  System.out.println("fin Obteniendo las preguntas");   
     return this.vPreguntas;  
 }


public ArrayList getPreguntasxResp(String pIdRespuesta){
    Object vListadoP;
    vListadoP=vIndice.get(pIdRespuesta);
    
    return (vListadoP!=null?(ArrayList)vListadoP:new ArrayList());
}

    public String btn_autorizar_lista() {
      
        resulOp vResultado=new resulOp();
        boolean vResultadoOps=false;
        
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"setCurrentRowWithKey")){
          
          JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),"#{bindings.Aprobado.inputValue}","SI");
            
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Commit")){
            
                JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"BuscarFormulario");
                
                
                vResultado.setMensajeError("Sistema nomina actualizado correctamente.");    
                
                vResultado.setCodigoResultado(resulOp.OPE_OK);
                utils.setADFMensaje(vResultado); 
                vResultadoOps=true;
                
            }
            
        }
        
        return null;
    }
    
public void setPreguntaControl(String pIdPregunta,Object pControl){
    vControl.put(pIdPregunta,pControl);    
}
 
public Object getPreguntaControl(String pIdPregunta){
    return vControl.get(pIdPregunta);
    
}
 


/////////////////////////////////////////////////////////////////////////////////////

   public void setShwOneRadio1(CoreShowOneRadio shwOneRadio) {   
      try{
        
          vControlRdSh.set(1,shwOneRadio);  
          
      }catch(Exception exep)
      {
      
          vControlRdSh.add(shwOneRadio);  
      }
       
        
   }

    public CoreShowOneRadio getShwOneRadio1() {
    Object vValor; 
    
    try{
        
        vValor=vControlRdSh.get(1);
        
          if (vValor!=null)
            return (CoreShowOneRadio)vValor;
          else
            return null;
            
    }catch(Exception exep){
        
        
    }
    
     return null;
    }

    ////////////////////////////////////////////////////////
    public void setShwOneRadio2(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(2,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio2() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(2);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio3(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(3,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio3() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(3);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio4(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(4,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio4() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(4);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio5(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(5,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio5() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(5);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio6(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(6,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio6() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(6);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio7(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(7,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio7() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(7);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio8(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(8,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio8() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(8);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio9(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(9,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio9() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(9);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio10(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(10,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio10() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(10);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio11(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(11,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio11() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(11);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio12(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(12,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio12() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(12);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio13(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(13,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio13() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(13);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio14(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(14,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio14() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(14);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }
    ////////////////////////////////////////////////////////
    public void setShwOneRadio15(CoreShowOneRadio shwOneRadio) { 
          vControlRdSh.set(15,shwOneRadio);
    }
    public CoreShowOneRadio getShwOneRadio15() {
        Object vValor;
           try{
               vValor=vControlRdSh.get(15);
               if (vValor!=null)
                  return (CoreShowOneRadio)vValor;
                    else
                  return null;
              }catch(Exception exep){    
              }     
        return null;
    }



public static void main(String args[]){
  int vInicio=81;
  int vFin=100;
  
  while (vInicio<=vFin){
      
      System.out.println("////////////////////////////////////////////////////////");
      System.out.println("public void setRespuesta"+vInicio+"(Object vValor){");
      System.out.println("     NameValuePairs vTempoValores;");
      System.out.println("     vTempoValores=(NameValuePairs)this.vRespuestasX.get("+vInicio+ ");");
      System.out.println("     vTempoValores.setAttribute(\"ids\",vValor);");      
      System.out.println("}");
           
      System.out.println("public void setRespuestaOtros"+vInicio+"(Object vValor){");   
      System.out.println("     NameValuePairs vTempoValores;");   
      System.out.println("     vTempoValores=(NameValuePairs)this.vRespuestasX.get("+vInicio+ ");");
      System.out.println("     vTempoValores.setAttribute(\"otros\",vValor);");
      System.out.println("}");
       
      System.out.println("public Object getRespuestaOtros"+vInicio+ "(){"); 
      System.out.println("     return ((NameValuePairs)this.vRespuestasX.get("+vInicio+ ")).getAttribute(\"otros\");");
      System.out.println("}");
      
      System.out.println("public Object getRespuesta"+vInicio+ "(){");
      System.out.println("     return ((NameValuePairs)this.vRespuestasX.get("+vInicio+ ")).getAttribute(\"ids\");");
      System.out.println("}");
         
       vInicio++; 
       
     
     /*
       System.out.println("////////////////////////////////////////////////////////");
       System.out.println("public void setShwOneRadio"+vInicio+ "(CoreShowOneRadio shwOneRadio) { ");
       System.out.println("      vControlRdSh.set("+vInicio+ ",shwOneRadio);");
       System.out.println("}");
       
       
       System.out.println("public CoreShowOneRadio getShwOneRadio"+vInicio+ "() {");
       System.out.println("    Object vValor;");       
       System.out.println("       try{");
       System.out.println("           vValor=vControlRdSh.get("+vInicio+ ");");
       System.out.println("           if (vValor!=null)");
       System.out.println("              return (CoreShowOneRadio)vValor;");
       System.out.println("                else");
       System.out.println("              return null;");
       System.out.println("          }catch(Exception exep){    ");
       System.out.println("          }     ");    
       System.out.println("    return null;");       
       System.out.println("}");
    
         vInicio++; 
       */
     }
        
        
    
}


    public void setGenero(String vGenero) {
        this.vGenero = vGenero;
    }

    public String getGenero() {
        return vGenero;
    }

    public void setEdad(int edad) {
        this.vEdad = edad;
    }

    public int getEdad() {
        return vEdad;
    }

    public void setRegistroEmpl(String vRegistroEmpl) {
        this.vRegistroEmpl = vRegistroEmpl;
    }

    public String getRegistroEmpl() {
        return vRegistroEmpl;
    }

    public String cmd_regEmpl_censo_busqueda() {
        // Add event code here...
        
        return null;
    }

    public String generarCSV() {
        // Add event code here...
         HttpServletResponse vRespuesta;
         ServletOutputStream outstream=null;
         vRespuesta=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
         vRespuesta.setContentType("text/html; charset=windows-1252");
         vRespuesta.setHeader ("Content-Disposition", "attachment;filename=\"" + "censo_laboral.csv" + "\""); 
        
        try{
            outstream=vRespuesta.getOutputStream();  
            GeneraCSV(outstream);
            outstream.close();
            
        }catch(Exception exep)
        {
           try{
            outstream.close();
            exep.printStackTrace();
           }catch(Exception exep2){
               
           }
        }
        
          
        
        
        return null;
    }
    
    public void GeneraCSV(ServletOutputStream pSalida)
    {
    interfaz_DB vConeccion=new interfaz_DB();    
    ResultSet vResult,vResult2;
    String vQuerry,vQuerry2;
    //-------
    String vRegistroEmpleado;
    String vRespuesta;
    String vOtraRespuesta;
    String vXmlValor;
    int vPosCol;
    int vPosColAnt;
    int vPosActual;
    int vIdResp;
    int vDifCol;

    //----
    String vBuffer;
    String vLinea;
    String vRegistroAnt;
    String [] vDatosGeneral=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};

    //---
    FileOutputStream vSalida;

    vRegistroAnt="";
    vBuffer="";
    vLinea="";
    vPosActual=1;
    vPosColAnt=0;
    try{

        vQuerry="select distinct nomabre,poscolum from sis_pregunta_censo\n" + 
        "where estado =1\n" + 
        "and poscolum is not null\n" + 
        "order by poscolum\n";

        
        vConeccion.Crear_sentencia(vQuerry);
        vResult=vConeccion.Bol_ejecutar_sentencia();
        
        if (pSalida==null)
          vSalida= new FileOutputStream("c:\\censo_laboral.csv");
        else
          vSalida=null;
          
       // encabezado del CLV
        vLinea="REGISTRO_EMPLEADO,IGSS,NIT,NOM_COMPLETO,FECHA_NAC,PAIS_NAC,DEP_NAC,MUNI_NAC,ORDEN_CEDULA,REGISTRO_CEDULA,MUNI_CEDULA," +
        "CUI,MUNI_CUI,NO_PASAPORTE,PASAPORTE_PAIS,DIRECCION,ZONA,DEPTO_DIREC,MUNI_DIREC,DIREC_NOTI,DEPTO_NOTI,MUNI_NOTI,PAIS_ANTES_USAC,DEPTO_ANTES_USAC,MUNI_ANTES_USAC," +
        "NACIONALIDAD,SEXO,ESTADO_CIVIL,";
        
        while (vResult.next())
        {

           vLinea=vLinea+vResult.getString("nomabre")+",";

        }


        vLinea=vLinea.substring(0,vLinea.length()-1);
        if (pSalida==null)
          vSalida.write(vLinea.getBytes());   
        else
          pSalida.write(vLinea.getBytes());

        vLinea="";
        vResult.close();

        vQuerry="select a.registro_empleado,a.id_pregunta,b.id_respuesta,b.respuesta,a.otra_respuesta,xmltype.getClobVal(xmldoc) as xmlval,c.poscolum,c.nomabre\n" + 
        "from  \n" + 
        "sis_respuesta_censo a, sis_listrespuesta_censo b,sis_pregunta_censo c\n" + 
        "where  a.id_respuesta=b.id_respuesta\n" + 
        "and a.id_pregunta=c.id_pregunta\n" + 
        "order by registro_empleado,poscolum\n";

        vConeccion.Crear_sentencia(vQuerry);
        vResult=vConeccion.Bol_ejecutar_sentencia();
        

        while (vResult.next())
        {

           vRegistroEmpleado=vResult.getString("registro_empleado"); 
           
           vIdResp=vResult.getInt("id_respuesta");         
           vRespuesta=vResult.getString("respuesta"); 
           vOtraRespuesta=vResult.getString("otra_respuesta");
           vPosCol=vResult.getInt("poscolum");
           vXmlValor=vResult.getString("xmlval");
           
            if (!vRegistroAnt.equals(vRegistroEmpleado))
            {
            
                vQuerry2="select * from sis_inf_personal_ficha_vw\n" + 
                "where registro_empleado="+vRegistroEmpleado;


                vResult2=vConeccion.Bol_ejecutar_sentencia(vQuerry2);
            
                if (vResult2.next()){
                
                    vDatosGeneral[0]=vResult2.getString("registro_empleado");
                    vDatosGeneral[1]=vResult2.getString("igss");
                    vDatosGeneral[2]=vResult2.getString("nit");
                    vDatosGeneral[3]=vResult2.getString("nomcompleto");
                    vDatosGeneral[4]=vResult2.getString("fecha_nacimiento");
                    vDatosGeneral[5]=vResult2.getString("paisnac");
                    vDatosGeneral[6]=vResult2.getString("muninac");
                    vDatosGeneral[7]=vResult2.getString("depnac");
                    vDatosGeneral[8]=vResult2.getString("orden_cedula");
                    vDatosGeneral[9]=vResult2.getString("registro_cedula");
                    vDatosGeneral[10]=vResult2.getString("municedula");
                    vDatosGeneral[11]=vResult2.getString("cui");
                    vDatosGeneral[12]=vResult2.getString("munidpi");
                    vDatosGeneral[13]=vResult2.getString("no_pasaporte");
                    vDatosGeneral[14]=vResult2.getString("pasaportepais");
                    vDatosGeneral[15]=vResult2.getString("direcdomiciliar");
                    vDatosGeneral[16]=vResult2.getString("zona_direc");
                    vDatosGeneral[17]=vResult2.getString("depdirec");
                    vDatosGeneral[18]=vResult2.getString("mundirec");
                    vDatosGeneral[19]=vResult2.getString("direc_noti");
                    vDatosGeneral[20]=vResult2.getString("depnoti");
                    vDatosGeneral[21]=vResult2.getString("muninoti");
                    vDatosGeneral[22]=vResult2.getString("paisdirecant");
                    vDatosGeneral[23]=vResult2.getString("depdirecant");
                    vDatosGeneral[24]=vResult2.getString("mundirecant");
                    vDatosGeneral[25]=vResult2.getString("nacionalidad");
                    vDatosGeneral[26]=vResult2.getString("sexo");
                    vDatosGeneral[27]=vResult2.getString("estadocivil");
                    
                      for (int i=0;i<28;i++){
                          
                         vDatosGeneral[i]=(vDatosGeneral[i]==null?"":vDatosGeneral[i]);
                         
                      }
                    
                    
                    /*
                    vLinea="REGISTRO_EMPLEADO,IGSS,NIT,NOM_COMPLETO,FECHA_NAC,PAIS_NAC,DEP_NAC,MUNI_NAC,ORDEN_CEDULA,REGISTRO_CEDULA,MUNI_CEDULA," +
                    "CUI,MUNI_CUI,NO_PASAPORTE,PASAPORTE_PAIS,DIRECCION,ZONA,DEPTO_DIREC,MUNI_DIREC,DIREC_NOTI,DEPTO_NOTI,MUNI_NOTI,PAIS_ANTES_USAC,DEPTO_ANTES_USAC,MUNI_ANTES_USAC" +
                    "NACIONALIDAD,SEXO,ESTADO_CIVIL,";
                    */
                }
                
                vResult2.close();
              
                
            
                if (!vBuffer.equals(""))
                 vLinea=vLinea+"\""+vBuffer.substring(0,vBuffer.length()-1)+"\"";
                 
                vLinea=vLinea+"\n";
                vLinea=vLinea+"\""+vRegistroEmpleado+"\",\""+vDatosGeneral[1]+"\","+"\""+vDatosGeneral[2]+"\","+"\""+vDatosGeneral[3]+"\","+"\""+vDatosGeneral[4]+"\","+"\""+vDatosGeneral[5]+"\",";
                vLinea=vLinea+"\""+vDatosGeneral[7]+"\","+"\""+vDatosGeneral[6]+"\","+"\""+vDatosGeneral[8]+"\","+"\""+vDatosGeneral[9]+"\","+"\""+vDatosGeneral[10]+"\","+"\""+vDatosGeneral[11]+"\",";
                vLinea=vLinea+"\""+vDatosGeneral[12]+"\","+"\""+vDatosGeneral[13]+"\","+"\""+vDatosGeneral[14]+"\","+"\""+vDatosGeneral[15]+"\","+"\""+vDatosGeneral[16]+"\","+"\""+vDatosGeneral[17]+"\",";
                vLinea=vLinea+"\""+vDatosGeneral[18]+"\","+"\""+vDatosGeneral[19]+"\","+"\""+vDatosGeneral[20]+"\","+"\""+vDatosGeneral[21]+"\","+"\""+vDatosGeneral[22]+"\","+"\""+vDatosGeneral[23]+"\",";
                vLinea=vLinea+"\""+vDatosGeneral[24]+"\","+"\""+vDatosGeneral[25]+"\","+"\""+vDatosGeneral[26]+"\","+"\""+vDatosGeneral[27]+"\",";
                
                vRegistroAnt=vRegistroEmpleado;
                vPosActual=1;
                vPosColAnt=0;
                vBuffer="";
            }
           
           
             if (vPosColAnt<(vPosCol-1)){ // para llenar las columnas que van vacias
             
                 vDifCol=vPosCol-vPosColAnt;
                 
                 if (!vBuffer.equals(""))
                  vLinea=vLinea+"\""+vBuffer.substring(0,vBuffer.length()-1)+"\"";
                  vBuffer="";
                 
                 for (int i=0;i<vDifCol;i++){
                     vLinea=vLinea+",";  
                 }
                 //vBuffer=vBuffer+",";  ds
                 vPosColAnt=vPosCol;
             }
             
             
               if (vPosColAnt!=vPosCol)
               {
               
                  if (!vBuffer.equals(""))
                   vLinea=vLinea+"\""+vBuffer.substring(0,vBuffer.length()-1)+"\",";
                   vBuffer="";
                   vPosColAnt=vPosCol;
               }
            
            if (vIdResp==0){
                
                vBuffer=vBuffer+(vOtraRespuesta!=null?vOtraRespuesta:vXmlValor)+",";
                
            }else{
                
                vBuffer=vBuffer + vRespuesta + ",";
                
            }
          
            vPosActual++;
            
            if (vLinea.length()>1000)
            {
            
             if (pSalida==null)
              vSalida.write(vLinea.getBytes()); 
             else
              pSalida.write(vLinea.getBytes()); 
              
              vLinea="";  
              
            }
            
         } /// while
         
       if (pSalida==null){   
        vSalida.write(vLinea.getBytes());   
        vSalida.flush();
        vSalida.close();
       }else {
        
        pSalida.write(vLinea.getBytes());   
        pSalida.flush();   
           
       }
        //System.out.println(vLinea);
        
       vResult.close();
       vConeccion.cn_Cerrar_coneccion();
        
    }catch(Exception exep)
    {
     vConeccion.cn_Cerrar_coneccion();  
      exep.printStackTrace();  
    }
}   
    
}
