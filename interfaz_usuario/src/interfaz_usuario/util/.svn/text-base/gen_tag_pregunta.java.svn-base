package interfaz_usuario.util;

import interfaz_usuario.backing.gestiones.ficha_empleado_censo;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import oracle.jbo.NameValuePairs;

import oracle.jsp.runtime.OracleJspRuntime;

public class gen_tag_pregunta {
    private ficha_empleado_censo vData;
    private int pNumPregunta;
    private String pCategoriaAnt="";
    private int vNumRadioShw=1;
    private String vGrupoPreg;
    private HashMap vRespuestas;
    
    public gen_tag_pregunta() {
    }
    
    
    public gen_tag_pregunta(ficha_empleado_censo pData) {
     vData=pData;
     pNumPregunta=0;
    }
    
    
    
    public void setGrupoPreg(String pPregunta){
        this.vGrupoPreg=pPregunta;        
    }
    
    
    
    public void setRespuestasvw(HashMap vValor)
    {
        vRespuestas=vValor;
        
    }
    
    
    private boolean isSelectedItem(String vIdRespuesta){
        
        if (vRespuestas!=null)
        return vRespuestas.containsKey(vIdRespuesta);
        else
        return false;
        
    }
    
    
public void GenerarUIControl(NameValuePairs pDataPregunta,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag)  throws Exception{
    ArrayList vListaRespuestas;
    Iterator vRespuestas;
    String vTextoPregunta="",vTipoControl="",vOpcionOtros="",vIdPregunta;
    Object vIdPadre;    
    
    String vCategoriaPreg;    
    NameValuePairs vValores2;
    ArrayList vPreguntasTemp;
    
         vCategoriaPreg=pDataPregunta.getAttribute("nombre_categoria").toString();
         vTextoPregunta=pDataPregunta.getAttribute("pregunta").toString();
         vIdPregunta=pDataPregunta.getAttribute("id_pregunta").toString();
         vTipoControl=pDataPregunta.getAttribute("tipo_control").toString();
         vOpcionOtros=pDataPregunta.getAttribute("opcion_otros").toString();
         vIdPadre=pDataPregunta.getAttribute("id_pregunta_padre");
         
         
         pNumPregunta++;
         // Para imprimir el panel
         if (!vCategoriaPreg.equals(pCategoriaAnt))
         {
             pCategoriaAnt=vCategoriaPreg; 
              {
              
               oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag __jsp_taghandlerPanel=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag text");
                      __jsp_taghandlerPanel.setParent(pParentTag);                                 
                      __jsp_taghandlerPanel.setText(vCategoriaPreg);
                       __jsp_tag_starteval=__jsp_taghandlerPanel.doStartTag();
                  if (__jsp_taghandlerPanel.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                         return;
                         OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerPanel,pNivelTag);
               }

      
          }//Verificando si se coloca el panel en cambio de categoria    
        
           if (!vTipoControl.equals("RADIOSH"))    
           {
            oracle.adfinternal.view.faces.taglib.core.layout.CorePanelLabelAndMessageTag __jsp_taghandlerPanelLabel=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelLabelAndMessageTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelLabelAndMessageTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelLabelAndMessageTag inlineStyle label");
             __jsp_taghandlerPanelLabel.setParent(pParentTag);                           
             __jsp_taghandlerPanelLabel.setInlineStyle("color:rgb(0,74,115);font-size:12.0pt;white-space:normal;");
             __jsp_taghandlerPanelLabel.setLabel(vTextoPregunta);
             __jsp_taghandlerPanelLabel.setValign("top");
             __jsp_tag_starteval=__jsp_taghandlerPanelLabel.doStartTag();
             if (__jsp_taghandlerPanelLabel.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerPanelLabel,pNivelTag);  
           }

                   if (vTipoControl.equals("RADIO")){
                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag __jsp_taghandlerRadio=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag layout value");
                      __jsp_taghandlerRadio.setParent(pParentTag);                      
                      __jsp_taghandlerRadio.setLayout("vertical");
                      __jsp_taghandlerRadio.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                      __jsp_taghandlerRadio.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                      __jsp_tag_starteval=__jsp_taghandlerRadio.doStartTag();
                      
                  //    vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadio);
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                              vRespuestas=vListaRespuestas.iterator();
                              
                              while(vRespuestas.hasNext())
                                  {
                                   vValores2=(NameValuePairs)vRespuestas.next();
                                      {
                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerRadio);
                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,10+pNivelTag);
                                      }
                                  }// while
                            }//checkstartVal
                      
                      
                      if (__jsp_taghandlerRadio.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadio,pNivelTag);
                          }//fin RADIO
                     else if (vTipoControl.equals("RADIOSH")){
                     
                     oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag __jsp_taghandlerRadioShw=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag id label position alignment");
                            __jsp_taghandlerRadioShw.setParent(pParentTag);
                          //__jsp_taghandlerRadioShw.setId("check2");
                            __jsp_taghandlerRadioShw.setLabel(vTextoPregunta);
                            __jsp_taghandlerRadioShw.setPosition("top");
                            __jsp_taghandlerRadioShw.setAlignment("start");
                            __jsp_tag_starteval=__jsp_taghandlerRadioShw.doStartTag();
                            
                   //  vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadioShw);
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                              vRespuestas=vListaRespuestas.iterator();
                              
                              while(vRespuestas.hasNext())
                                  {
                                   vValores2=(NameValuePairs)vRespuestas.next();
                                      {
                                  
                                oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag __jsp_taghandlerItemDt=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag text");
                                __jsp_taghandlerItemDt.setParent(__jsp_taghandlerRadioShw);
                                __jsp_taghandlerItemDt.setText(vValores2.getAttribute("respuesta").toString());
                                if (this.isSelectedItem(vValores2.getAttribute("respuesta").toString())) 
                                {
                                       __jsp_taghandlerItemDt.setDisclosed("true");   
                                }                                      
                                __jsp_tag_starteval=__jsp_taghandlerItemDt.doStartTag();
                           
                                if (vValores2.getAttribute("nivel").toString().equals("1")){
                                    
                                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                        {
                                                                      
                                            vPreguntasTemp=vData.getPreguntasxResp(vValores2.getAttribute("id_respuesta").toString());
                                            
                                            oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag __jsp_taghandler_pnlfrm1=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag");
                                            __jsp_taghandler_pnlfrm1.setParent(__jsp_taghandlerItemDt);
                                            __jsp_tag_starteval=__jsp_taghandler_pnlfrm1.doStartTag();
                                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {

                                            
                                            for (int vi=0;vi<vPreguntasTemp.size();vi++)
                                            {
                                         /*   
                                                oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandler_219x=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                __jsp_taghandler_219x.setParent(__jsp_taghandlerItemDt);
                                                __jsp_taghandler_219x.setLabel("Label 5"+vi);
                                                __jsp_tag_starteval=__jsp_taghandler_219x.doStartTag();
                                                    if (__jsp_taghandler_219x.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                               return;
                                               OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_219x,11);
                                          */  
                                            
                                              GenerarUIControl((NameValuePairs)vPreguntasTemp.get(vi), __jsp_taghandlerItemDt,pageContext,__jsp_tag_starteval,pNivelTag+3);                                           
                                                
                                            }                                            
                                           }
                                           
                                            if (__jsp_taghandler_pnlfrm1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                   return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_pnlfrm1,pNivelTag+2); 
                                           
                                        }
                                }
                          
                               // vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerItemDt);
                                  
                                if (__jsp_taghandlerItemDt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItemDt,pNivelTag+1);
                              
                                      }
                                  }// while
                            }//checkstartVal
                      
                      
                      if (__jsp_taghandlerRadioShw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadioShw,pNivelTag);
                      
                      
                          }//fin SHOW ONE RADIO                                                                                 
                          
                     else if (vTipoControl.equals("COMBO")){
                           
                         oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_Combo=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label");
                         __jsp_taghandler_Combo.setParent(pParentTag);
                      //   __jsp_taghandler_Combo.setLabel("Label 1");
                         __jsp_taghandler_Combo.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                         __jsp_tag_starteval=__jsp_taghandler_Combo.doStartTag();
                         if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                         {



                         }                               
                         if (__jsp_taghandler_Combo.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                           return;
                         OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Combo,pNivelTag);  
                           
                     } // fin COMBO
                     else if (vTipoControl.equals("CHECK")){
                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag __jsp_taghandlerCheck=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag label");
                      __jsp_taghandlerCheck.setParent(pParentTag);
                      __jsp_taghandlerCheck.setLayout("vertical");
                      __jsp_taghandlerCheck.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");  
                      __jsp_taghandlerCheck.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                      __jsp_tag_starteval=__jsp_taghandlerCheck.doStartTag();
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                              vRespuestas=vListaRespuestas.iterator();
                              
                              while(vRespuestas.hasNext())
                                  {
                                   vValores2=(NameValuePairs)vRespuestas.next();
                                      {
                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerCheck);
                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                      }
                                  }// while
                            }//checkstartVal
                      
                      
                      if (__jsp_taghandlerCheck.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerCheck,9+pNivelTag);
                          }//fin CHECK
                     else if (vTipoControl.equals("MANYSHUTTLE")){
                      
                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag __jsp_taghandlerManyShuttle=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag size leadingHeader trailingHeader");
                      __jsp_taghandlerManyShuttle.setParent(pParentTag);
                      __jsp_taghandlerManyShuttle.setSize("5");
                      __jsp_taghandlerManyShuttle.setLeadingHeader("Disponibles");
                      __jsp_taghandlerManyShuttle.setTrailingHeader("Seleccionados");
                      __jsp_taghandlerManyShuttle.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                      __jsp_taghandlerManyShuttle.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                      __jsp_tag_starteval=__jsp_taghandlerManyShuttle.doStartTag();
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                              vRespuestas=vListaRespuestas.iterator();
                              
                              while(vRespuestas.hasNext())
                                  {
                                   vValores2=(NameValuePairs)vRespuestas.next();
                                      {
                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerManyShuttle);
                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                      }
                                  }// while
                            }//checkstartVal
                      
                      
                      if (__jsp_taghandlerManyShuttle.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerManyShuttle,9+pNivelTag);
                          }//fin ManyShuttle
                     
                     else if (vTipoControl.equals("INPUT")){
                          
                           oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                            __jsp_taghandlerInput.setParent(pParentTag);
                            __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                            __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                            __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                            if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                 return;
                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag);
                     
                          }// fin input
    //                              } // FIN TAG PANELLABEL
        
        
             if (vOpcionOtros.equals("1")) // Se agrega la opcion de otros un input text
             { 
           
                  oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                  __jsp_taghandlerInput.setParent(pParentTag);
                  __jsp_taghandlerInput.setLabel("Otro, especifique");
                  __jsp_taghandlerInput.setColumns("20");
                  __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                  __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                  __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                  if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag);
             
             }
             
              { // Agregando un espacio entre las preguntas
                oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandlerSpaceTag=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                __jsp_taghandlerSpaceTag.setParent(pParentTag);
                __jsp_taghandlerSpaceTag.setWidth("10");
                __jsp_taghandlerSpaceTag.setHeight("16");
                __jsp_tag_starteval=__jsp_taghandlerSpaceTag.doStartTag();
                if (__jsp_taghandlerSpaceTag.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerSpaceTag,pNivelTag);
              }
  }



public void GenerarUIControlTabla(NameValuePairs pDataPregunta,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,String pAlignPreg,String pAlignControl)  throws Exception
{
        ArrayList vListaRespuestas;
        Iterator vRespuestas;
        String vTextoPregunta="",vTipoControl="",vOpcionOtros="",vIdPregunta,vGrupo,vProperties;
        Object vIdPadre;    
        
        String vCategoriaPreg;    
        NameValuePairs vValores2;
        ArrayList vPreguntasTemp;
        
             vCategoriaPreg=pDataPregunta.getAttribute("nombre_categoria").toString();
             vTextoPregunta=pDataPregunta.getAttribute("pregunta").toString();
             vIdPregunta=pDataPregunta.getAttribute("id_pregunta").toString();
             vTipoControl=pDataPregunta.getAttribute("tipo_control").toString();
             vOpcionOtros=pDataPregunta.getAttribute("opcion_otros").toString();
             vIdPadre=pDataPregunta.getAttribute("id_pregunta_padre");
             vGrupo=pDataPregunta.getAttribute("grupo").toString();
             vProperties=(pDataPregunta.getAttribute("properties")==null?null:pDataPregunta.getAttribute("properties").toString());
             
         if (vGrupo.equals(vGrupoPreg)){
             
             
             pNumPregunta++;
             // Para imprimir el panel
             if (!vCategoriaPreg.equals(pCategoriaAnt))
             {
                 pCategoriaAnt=vCategoriaPreg; 
                  {
                                   
                        oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw1=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                        __jsp_taghandler_rw1.setParent(pParentTag);
                        __jsp_tag_starteval=__jsp_taghandler_rw1.doStartTag();
                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            {
                              oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_cellrw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag columnSpan header");
                              __jsp_taghandler_cellrw.setParent(__jsp_taghandler_rw1);
                              __jsp_taghandler_cellrw.setColumnSpan("2");
                              __jsp_taghandler_cellrw.setHeader("false");
                              __jsp_tag_starteval=__jsp_taghandler_cellrw.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                   {
                                      {
                                          oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag __jsp_taghandlerPanel=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag text");
                                          __jsp_taghandlerPanel.setParent(__jsp_taghandler_cellrw);                                 
                                          __jsp_taghandlerPanel.setText(vCategoriaPreg);
                                          __jsp_taghandlerPanel.setMessageType("info");
                                          __jsp_taghandlerPanel.setSize("0");
                                          __jsp_tag_starteval=__jsp_taghandlerPanel.doStartTag();
                                          if (__jsp_taghandlerPanel.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                  return;
                                         OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerPanel,pNivelTag+3);                                                                                                                                     
                                         
                                     }                                                                                                                
                                 }
                               if (__jsp_taghandler_cellrw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                return;
                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_cellrw,pNivelTag+1);
                             }
                           }
                         if (__jsp_taghandler_rw1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                         OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw1,pNivelTag);                            
                             
                   }

          
              }//Verificando si se coloca el panel en cambio de categoria    
            
            
                
             /////   pregunta 
                              
                   oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_row1=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                   __jsp_taghandler_row1.setParent(pParentTag);
                   __jsp_tag_starteval=__jsp_taghandler_row1.doStartTag();
                   if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                        {
                         oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_celRw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag halign width");
                         __jsp_taghandler_celRw.setParent(__jsp_taghandler_row1);
                         __jsp_taghandler_celRw.setHalign(pAlignPreg);
                         __jsp_taghandler_celRw.setWidth("475");
                         __jsp_tag_starteval=__jsp_taghandler_celRw.doStartTag();
                           if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                    {
                                      oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_252=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag styleClass value");
                                      __jsp_taghandler_252.setParent(__jsp_taghandler_celRw);
                                      __jsp_taghandler_252.setStyleClass("titulosPreg");
                                      __jsp_taghandler_252.setValue(vTextoPregunta);
                                      __jsp_tag_starteval=__jsp_taghandler_252.doStartTag();
                                      if (__jsp_taghandler_252.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                  return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_252,pNivelTag+2);
                                    }
                                }
                              if (__jsp_taghandler_celRw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                         return;
                             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_celRw,pNivelTag+1);
                        }
                   }
                   if (__jsp_taghandler_row1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                   OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_row1,pNivelTag);
               
                 
        //----------------------------------------
               
               // controles de preguntas
               
                    oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw2=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                    __jsp_taghandler_rw2.setParent(pParentTag);
                    __jsp_tag_starteval=__jsp_taghandler_rw2.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                     {
                         {
                              oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_CellRw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                              __jsp_taghandler_CellRw.setParent(__jsp_taghandler_rw2);
                              __jsp_tag_starteval=__jsp_taghandler_CellRw.doStartTag();
                              if (__jsp_taghandler_CellRw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                            return;
                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_CellRw,pNivelTag+1);
                         }
                                            
                              oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler__CellRw2=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                              __jsp_taghandler__CellRw2.setParent(__jsp_taghandler_rw2);
                              __jsp_taghandler__CellRw2.setHalign(pAlignControl);
                              __jsp_tag_starteval=__jsp_taghandler__CellRw2.doStartTag();
                              
                              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                               {
                                           
                                                 
                                   if (vTipoControl.equals("RADIO"))
                                   {
                                   
                                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag __jsp_taghandlerRadio=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag layout value");
                                      __jsp_taghandlerRadio.setParent(__jsp_taghandler__CellRw2);     
                                      
                                      if (vProperties==null|| (vProperties!=null && vProperties.equals("1")))
                                      __jsp_taghandlerRadio.setLayout("vertical");
                                      else if (vProperties!=null && vProperties.equals("2"))
                                      __jsp_taghandlerRadio.setLayout("horizontal");
                                      
                                      __jsp_taghandlerRadio.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                      __jsp_taghandlerRadio.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                      __jsp_tag_starteval=__jsp_taghandlerRadio.doStartTag();
                                      
                                  //    vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadio);
                                      
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {
                                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                              vRespuestas=vListaRespuestas.iterator();
                                              
                                              while(vRespuestas.hasNext())
                                                  {
                                                   vValores2=(NameValuePairs)vRespuestas.next();
                                                      {
                                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerRadio);
                                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                      }
                                                  }// while
                                            }//checkstartVal
                                      
                                      
                                      if (__jsp_taghandlerRadio.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadio,pNivelTag+2);
                                     }//fin RADIO
                                     
                                     else if (vTipoControl.equals("RADIOSH")){
                                     
                                     oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag __jsp_taghandlerRadioShw=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag id label position alignment");
                                            __jsp_taghandlerRadioShw.setParent(__jsp_taghandler__CellRw2);
                                          //__jsp_taghandlerRadioShw.setId("check2");
                                          //  __jsp_taghandlerRadioShw.setLabel(vTextoPregunta);
                                            __jsp_taghandlerRadioShw.setBinding("#{ficha_empleado_censo.shwOneRadio"+vNumRadioShw+ "}"); 
                                            __jsp_taghandlerRadioShw.setPosition("top");
                                            __jsp_taghandlerRadioShw.setAlignment("start");
                                            __jsp_tag_starteval=__jsp_taghandlerRadioShw.doStartTag();
                                                
                                              vNumRadioShw++;                                                
                                   //  vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadioShw);
                                      
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {
                                            
                                                {
                                                   javax.faces.webapp.AttributeTag __jsp_taghandler_Attri=(javax.faces.webapp.AttributeTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.AttributeTag.class,"javax.faces.webapp.AttributeTag name value");
                                                   __jsp_taghandler_Attri.setParent(__jsp_taghandlerRadioShw);
                                                   __jsp_taghandler_Attri.setName("id_ShwPregunta");
                                                   __jsp_taghandler_Attri.setValue(vIdPregunta);
                                                   __jsp_tag_starteval=__jsp_taghandler_Attri.doStartTag();
                                                   if (__jsp_taghandler_Attri.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                   OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Attri,pNivelTag+3);
                                                }        
                                            
                                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                              vRespuestas=vListaRespuestas.iterator();
                                              
                                              while(vRespuestas.hasNext())
                                                  {
                                                   vValores2=(NameValuePairs)vRespuestas.next();
                                                      {
                                                  
                                                oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag __jsp_taghandlerItemDt=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag text");
                                                __jsp_taghandlerItemDt.setParent(__jsp_taghandlerRadioShw);
                                                __jsp_taghandlerItemDt.setText(vValores2.getAttribute("respuesta").toString());
                                                if (this.isSelectedItem(vValores2.getAttribute("id_respuesta").toString())) 
                                                 {
                                                             __jsp_taghandlerItemDt.setDisclosed("true");   
                                                 }                                      
                                                          
                                                __jsp_tag_starteval=__jsp_taghandlerItemDt.doStartTag();
                                           
                                             //   if (vValores2.getAttribute("nivel").toString().equals("1")){
                                                    
                                                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                        {
                                                                 
                                                            {
                                                               javax.faces.webapp.AttributeTag __jsp_taghandler_Attri=(javax.faces.webapp.AttributeTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.AttributeTag.class,"javax.faces.webapp.AttributeTag name value");
                                                               __jsp_taghandler_Attri.setParent(__jsp_taghandlerItemDt);
                                                               __jsp_taghandler_Attri.setName("id_showdt");
                                                               __jsp_taghandler_Attri.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                               __jsp_tag_starteval=__jsp_taghandler_Attri.doStartTag();
                                                               if (__jsp_taghandler_Attri.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                               OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Attri,pNivelTag+4);
                                                            }        
                                                                 
                                                                 
                                                                                      
                                                            vPreguntasTemp=vData.getPreguntasxResp(vValores2.getAttribute("id_respuesta").toString());
                                                            
                                                            oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag __jsp_taghandler_pnlfrm1=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag");
                                                            __jsp_taghandler_pnlfrm1.setParent(__jsp_taghandlerItemDt);
                                                            __jsp_tag_starteval=__jsp_taghandler_pnlfrm1.doStartTag();
                                                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                            {
            
                                                            
                                                            for (int vi=0;vi<vPreguntasTemp.size();vi++)
                                                            {
                                                         /*   
                                                                oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandler_219x=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                                __jsp_taghandler_219x.setParent(__jsp_taghandlerItemDt);
                                                                __jsp_taghandler_219x.setLabel("Label 5"+vi);
                                                                __jsp_tag_starteval=__jsp_taghandler_219x.doStartTag();
                                                                    if (__jsp_taghandler_219x.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                               return;
                                                               OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_219x,11);
                                                          */  
                                                            
                                                              GenerarUIControlTabla((NameValuePairs)vPreguntasTemp.get(vi), __jsp_taghandlerItemDt,pageContext,__jsp_tag_starteval,pNivelTag+5,"Left","Left");                                           
                                                                
                                                            }                                            
                                                           }
                                                           
                                                            if (__jsp_taghandler_pnlfrm1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                   return;
                                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_pnlfrm1,pNivelTag+4); 
                                                           
                                                        }
                                             //   }
                                          
                                               // vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerItemDt);
                                                  
                                                if (__jsp_taghandlerItemDt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                  return;
                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItemDt,pNivelTag+3);
                                              
                                                      }
                                                  }// while
                                            }//checkstartVal
                                      
                                      
                                      if (__jsp_taghandlerRadioShw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadioShw,pNivelTag+2);
                                      
                                      
                                          }//fin SHOW ONE RADIO                                                                                 
                                          
                                     else if (vTipoControl.equals("COMBO"))
                                     {
                                           
                                         oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_Combo=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label");
                                         __jsp_taghandler_Combo.setParent(__jsp_taghandler__CellRw2);
                                      //   __jsp_taghandler_Combo.setLabel("Label 1");
                                         __jsp_taghandler_Combo.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                         __jsp_tag_starteval=__jsp_taghandler_Combo.doStartTag();
                                         if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                         {
                                             vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                             vRespuestas=vListaRespuestas.iterator();
                                             
                                             while(vRespuestas.hasNext())
                                                 {
                                                  vValores2=(NameValuePairs)vRespuestas.next();
                                                     {
                                                       oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                       __jsp_taghandlerItem.setParent(__jsp_taghandler_Combo);
                                                       __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                       __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                       __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                       if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                         return;
                                                       OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                     }
                                                 }// while                        
                                         }                               
                                         if (__jsp_taghandler_Combo.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                           return;
                                         OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Combo,pNivelTag+2);  
                                           
                                     } // fin COMBO
                                     else if (vTipoControl.equals("CHECK"))
                                     {
                                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag __jsp_taghandlerCheck=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag label");
                                      __jsp_taghandlerCheck.setParent(__jsp_taghandler__CellRw2);
                                      __jsp_taghandlerCheck.setLayout("vertical");
                                      __jsp_taghandlerCheck.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");  
                                      __jsp_taghandlerCheck.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                      __jsp_tag_starteval=__jsp_taghandlerCheck.doStartTag();
                                      
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {
                                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                              vRespuestas=vListaRespuestas.iterator();
                                              
                                              while(vRespuestas.hasNext())
                                                  {
                                                   vValores2=(NameValuePairs)vRespuestas.next();
                                                      {
                                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerCheck);
                                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                      }
                                                  }// while
                                            }//checkstartVal
                                      
                                      
                                      if (__jsp_taghandlerCheck.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerCheck,pNivelTag+2);
                                          }//fin CHECK
                                     else if (vTipoControl.equals("MANYSHUTTLE"))
                                     {
                                      
                                      oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag __jsp_taghandlerManyShuttle=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag size leadingHeader trailingHeader");
                                      __jsp_taghandlerManyShuttle.setParent(__jsp_taghandler__CellRw2);
                                      __jsp_taghandlerManyShuttle.setSize("5");
                                      __jsp_taghandlerManyShuttle.setLeadingHeader("Disponibles");
                                      __jsp_taghandlerManyShuttle.setTrailingHeader("Seleccionados");
                                      __jsp_taghandlerManyShuttle.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                      __jsp_taghandlerManyShuttle.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                      __jsp_tag_starteval=__jsp_taghandlerManyShuttle.doStartTag();
                                      
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {
                                              vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                              vRespuestas=vListaRespuestas.iterator();
                                              
                                              while(vRespuestas.hasNext())
                                                  {
                                                   vValores2=(NameValuePairs)vRespuestas.next();
                                                      {
                                                        oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                        __jsp_taghandlerItem.setParent(__jsp_taghandlerManyShuttle);
                                                        __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                        __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                        __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                        if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                      }
                                                  }// while
                                            }//checkstartVal
                                      
                                      
                                      if (__jsp_taghandlerManyShuttle.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerManyShuttle,pNivelTag+2);
                                          }//fin ManyShuttle
                                     
                                     else if (vTipoControl.equals("INPUT"))
                                     {
                                          
                                           oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                            __jsp_taghandlerInput.setParent(__jsp_taghandler__CellRw2);
                                            __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                            __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                            __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                            if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                 return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+2);
                                     
                                     }// fin input
                                      else if (vTipoControl.equals("OUTLABEL"))
                                      {
                                           
                                        
                                          oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_txt=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag id styleClass value");
                                          __jsp_taghandler_txt.setParent(__jsp_taghandler__CellRw2);
                                          __jsp_taghandler_txt.setStyleClass("tituloscontrol1");
                                          __jsp_taghandler_txt.setValue(vTextoPregunta);
                                          __jsp_tag_starteval=__jsp_taghandler_txt.doStartTag();
                                              if (__jsp_taghandler_txt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                     return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_txt,pNivelTag+2);
                                                                                          
                                      
                                      }// fin label
                                     
                    //   } // FIN TAG PANELLABEL
                        
                        
                             if (vOpcionOtros.equals("1")) // Se agrega la opcion de otros un input text
                             { 
                           
                                  oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                  __jsp_taghandlerInput.setParent(__jsp_taghandler__CellRw2);
                                  __jsp_taghandlerInput.setLabel("Otro, especifique");
                                  __jsp_taghandlerInput.setColumns("20");
                                  __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                  __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                  __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                  if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                            return;
                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+2);
                             
                             }
                             
                              { // Agregando un espacio entre las preguntas
                                oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandlerSpaceTag=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                                __jsp_taghandlerSpaceTag.setParent(__jsp_taghandler__CellRw2);
                                __jsp_taghandlerSpaceTag.setWidth("10");
                                __jsp_taghandlerSpaceTag.setHeight("16");
                                __jsp_tag_starteval=__jsp_taghandlerSpaceTag.doStartTag();
                                if (__jsp_taghandlerSpaceTag.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerSpaceTag,pNivelTag+2);
             
                              }
                  
               } 
              if (__jsp_taghandler__CellRw2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
               return;
                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler__CellRw2,pNivelTag+1);
             }// fin cell de control de pregunta
            if (__jsp_taghandler_rw2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw2,pNivelTag);

     }             
  }


/*
 * Version 2 para la generacion de las preguntas
 */
public void GenerarUIControlTabla2(JspWriter pOut,NameValuePairs pDataPregunta,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,String pAlignPreg,String pAlignControl)  throws Exception
    {
            ArrayList vListaRespuestas;
            Iterator vRespuestas;
            String vTextoPregunta="",vTipoControl="",vOpcionOtros="",vIdPregunta,vGrupo,vProperties,vTextoOtros,vImprimePreg;
            Object vIdPadre;    
            
            String vCategoriaPreg;    
            NameValuePairs vValores2;
            ArrayList vPreguntasTemp;
            boolean vHorizontal;
            
                 vCategoriaPreg=pDataPregunta.getAttribute("nombre_categoria").toString();
                 vTextoPregunta=pDataPregunta.getAttribute("pregunta").toString();
                 vIdPregunta=pDataPregunta.getAttribute("id_pregunta").toString();
                 vTipoControl=pDataPregunta.getAttribute("tipo_control").toString();
                 vOpcionOtros=pDataPregunta.getAttribute("opcion_otros").toString();
                 vIdPadre=pDataPregunta.getAttribute("id_pregunta_padre");
                 vTextoOtros=pDataPregunta.getAttribute("texto_otros").toString();
                 vGrupo=pDataPregunta.getAttribute("grupo").toString();
                 vImprimePreg=pDataPregunta.getAttribute("imprime_preg").toString();
                 
                 
                 vProperties=(pDataPregunta.getAttribute("properties")==null?null:pDataPregunta.getAttribute("properties").toString());
            
           if (vImprimePreg.equals("0")||vImprimePreg.equals("1"))
           {
             if (vGrupo.equals(vGrupoPreg)){
                 
                 
                 pNumPregunta++;
                 // Para imprimir el panel
                 if (!vCategoriaPreg.equals(pCategoriaAnt))
                 {
                     pCategoriaAnt=vCategoriaPreg; 
                      {
                                       
                            oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw1=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                            __jsp_taghandler_rw1.setParent(pParentTag);
                            __jsp_tag_starteval=__jsp_taghandler_rw1.doStartTag();
                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                              {
                                {
                                  oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_cellrw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag columnSpan header");
                                  __jsp_taghandler_cellrw.setParent(__jsp_taghandler_rw1);
                                  __jsp_taghandler_cellrw.setColumnSpan("3");
                                  __jsp_taghandler_cellrw.setHeader("false");
                                  __jsp_tag_starteval=__jsp_taghandler_cellrw.doStartTag();
                                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                       {
                                          {
                                              oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag __jsp_taghandlerPanel=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag text");
                                              __jsp_taghandlerPanel.setParent(__jsp_taghandler_cellrw);                                 
                                              __jsp_taghandlerPanel.setText(vCategoriaPreg);
                                              __jsp_taghandlerPanel.setMessageType("info");
                                              __jsp_taghandlerPanel.setSize("0");
                                              __jsp_tag_starteval=__jsp_taghandlerPanel.doStartTag();
                                              if (__jsp_taghandlerPanel.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerPanel,pNivelTag+3);                                                                                                                                     
                                             
                                         }                                                                                                                
                                     }
                                   if (__jsp_taghandler_cellrw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_cellrw,pNivelTag+1);
                                 }
                               }
                             if (__jsp_taghandler_rw1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw1,pNivelTag);                            
                                 
                       }

              
                  }//Verificando si se coloca el panel en cambio de categoria    
                
                //  System.out.println("pregunta " + vIdPregunta + " "+vTextoPregunta+ " "+pNumPregunta); 
                    
                 /////   pregunta 
                                  
                  if (vImprimePreg.equals("1"))
                  {
                  
                  if (vTipoControl.equals("RADIO2"))
                        vHorizontal=true;
                  else if(vTipoControl.equals("COMBO2"))
                        vHorizontal=true;
                  else
                        vHorizontal=false;
                  
                       oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_row1=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                       __jsp_taghandler_row1.setParent(pParentTag);
                       __jsp_taghandler_row1.setInlineStyle("background-color:rgb(255,247,214);");
                       __jsp_tag_starteval=__jsp_taghandler_row1.doStartTag();
                       if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                        {
                            {
                             oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_celRw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag halign width");
                             __jsp_taghandler_celRw.setParent(__jsp_taghandler_row1);
                             __jsp_taghandler_celRw.setHalign(pAlignPreg);
                              //__jsp_taghandler_celRw.setHalign("right");
                          
                               if (vHorizontal)
                             __jsp_taghandler_celRw.setColumnSpan("2");  
                              
                             __jsp_taghandler_celRw.setWidth("700");
                                
                               
                             __jsp_tag_starteval=__jsp_taghandler_celRw.doStartTag();
                               if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                    {
                                     if (vHorizontal==false)                                     
                                     {
                                         if (vImprimePreg.equals("1"))
                                         {
                                           
                                           oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_252=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag styleClass value");
                                           __jsp_taghandler_252.setParent(__jsp_taghandler_celRw);
                                           __jsp_taghandler_252.setStyleClass("titulosPreg");
                                           
                                         //   if (vImprimePreg.equals("1"))
                                           __jsp_taghandler_252.setValue(vTextoPregunta);
                                         //  else
                                         //   __jsp_taghandler_252.setValue(" ");
                                               
                                           __jsp_tag_starteval=__jsp_taghandler_252.doStartTag();
                                           if (__jsp_taghandler_252.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                       return;
                                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_252,pNivelTag+2);
                                         }else{
                                             
                                             //this.escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag+2,"<p>hola</p>");
                                             
                                         }
                                         
                                     }else
                                     {                                         
                                         {
                                         
                                           oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag __jsp_taghandler_67=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag");
                                           __jsp_taghandler_67.setParent(__jsp_taghandler_celRw);
                                          // __jsp_taghandler_67.setHalign("right");
                                           __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();                                           
                                           if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                           {
                                             { 
                                               oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_252=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag styleClass value");
                                               __jsp_taghandler_252.setParent(__jsp_taghandler_celRw);
                                               __jsp_taghandler_252.setStyleClass("titulosPreg");                                                                    
                                               __jsp_taghandler_252.setValue(vTextoPregunta);                        
                                                   
                                               __jsp_tag_starteval=__jsp_taghandler_252.doStartTag();
                                               if (__jsp_taghandler_252.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                           return;
                                               OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_252,pNivelTag+3);
                                              }
                                             
                                               if (vTipoControl.equals("RADIO2"))
                                               {
                                               
                                                  oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag __jsp_taghandlerRadio=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag layout value");
                                                  __jsp_taghandlerRadio.setParent(__jsp_taghandler_67);     
                                                  
                                                  if (vProperties==null|| (vProperties!=null && vProperties.equals("1")))
                                                  __jsp_taghandlerRadio.setLayout("vertical");
                                                  else if (vProperties!=null && vProperties.equals("2"))
                                                  __jsp_taghandlerRadio.setLayout("horizontal");
                                                  
                                                  //__jsp_taghandlerRadio.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                                  __jsp_taghandlerRadio.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                                  __jsp_tag_starteval=__jsp_taghandlerRadio.doStartTag();
                                                  
                                               //    vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadio);
                                                //System.out.println("id :"+ __jsp_taghandlerRadio.getComponentInstance().getId());
                                                  
                                                     //pDataPregunta.setAttribute("id_control",__jsp_taghandlerRadio.getComponentInstance().getId()); 
                                                     vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerRadio.getComponentInstance().getId());
                                                  
                                                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                        {
                                                          vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                          vRespuestas=vListaRespuestas.iterator();
                                                          
                                                          while(vRespuestas.hasNext())
                                                              {
                                                               vValores2=(NameValuePairs)vRespuestas.next();
                                                                  {
                                                                    oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                                    __jsp_taghandlerItem.setParent(__jsp_taghandlerRadio);
                                                                    __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                                    __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                    __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                                    if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                      return;
                                                                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+4);
                                                                  }
                                                              }// while
                                                        }//checkstartVal
                                                  
                                                  
                                                  if (__jsp_taghandlerRadio.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                  return;
                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadio,pNivelTag+3);
                                                 }//fin RADIO
                                                 else if (vTipoControl.equals("COMBO2")) 
                                                 {
                                                   
                                                     { // Agregando un espacio entre las preguntas
                                                       oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandlerSpaceTag=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                                                       __jsp_taghandlerSpaceTag.setParent(__jsp_taghandler_67);
                                                       __jsp_taghandlerSpaceTag.setWidth("15");
                                                       __jsp_taghandlerSpaceTag.setHeight("10");
                                                       __jsp_tag_starteval=__jsp_taghandlerSpaceTag.doStartTag();
                                                       if (__jsp_taghandlerSpaceTag.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                         return;
                                                       OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerSpaceTag,pNivelTag+3);
                                                     
                                                     }
                                                   
                                                   
                                                     oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_Combo=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label");
                                                     __jsp_taghandler_Combo.setParent(__jsp_taghandler_67);
                                                     //   __jsp_taghandler_Combo.setLabel("Label 1");
                                                     __jsp_taghandler_Combo.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                                     __jsp_tag_starteval=__jsp_taghandler_Combo.doStartTag();
                                                     
                                                     
                                                     vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandler_Combo.getComponentInstance().getId());
                                                     if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                     {
                                                         vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                         vRespuestas=vListaRespuestas.iterator();
                                                         
                                                         while(vRespuestas.hasNext())
                                                             {
                                                              vValores2=(NameValuePairs)vRespuestas.next();
                                                                 {
                                                                   oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                                   __jsp_taghandlerItem.setParent(__jsp_taghandler_Combo);
                                                                   __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                                   __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                   __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                                   if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                     return;
                                                                   OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+4);
                                                                 }
                                                             }// while                        
                                                     }                               
                                                     if (__jsp_taghandler_Combo.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                       return;
                                                     OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Combo,pNivelTag+3);  
  
                                                     
                                                 }
                                                
                                             
                                           } 
                                           if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                             return;
                                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,pNivelTag+2);
                                           
                                         }
                                         
                                     }
                                    

                                  }   
                                        
                                  if (__jsp_taghandler_celRw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                             return;
                                 OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_celRw,pNivelTag+1);
                            }
                            // Si el control va a par de la pregunta 
                    
                  }   
                  if (__jsp_taghandler_row1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                     return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_row1,pNivelTag);                
              }  
            //----------------------------------------
                   
                   // controles de preguntas
                   
                        oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw2=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                        __jsp_taghandler_rw2.setParent(pParentTag);
                        __jsp_tag_starteval=__jsp_taghandler_rw2.doStartTag();
                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                         {
                                                
                                  oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler__CellRw2=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                                  __jsp_taghandler__CellRw2.setParent(__jsp_taghandler_rw2);
                                  __jsp_taghandler__CellRw2.setHalign(pAlignControl);
                                  __jsp_tag_starteval=__jsp_taghandler__CellRw2.doStartTag();
                                  
                                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                   {
                                               
                                                     
                                       if (vTipoControl.equals("RADIO"))
                                       {
                                       
                                          oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag __jsp_taghandlerRadio=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag layout value");
                                          __jsp_taghandlerRadio.setParent(__jsp_taghandler__CellRw2);     
                                          
                                          if (vProperties==null|| (vProperties!=null && vProperties.equals("1")))
                                          __jsp_taghandlerRadio.setLayout("vertical");
                                          else if (vProperties!=null && vProperties.equals("2"))
                                          __jsp_taghandlerRadio.setLayout("horizontal");
                                          
                                          //__jsp_taghandlerRadio.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                          __jsp_taghandlerRadio.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                          __jsp_tag_starteval=__jsp_taghandlerRadio.doStartTag();
                                          
                                      //    vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadio);
                                        //System.out.println("id :"+ __jsp_taghandlerRadio.getComponentInstance().getId());
                                          
                                             //pDataPregunta.setAttribute("id_control",__jsp_taghandlerRadio.getComponentInstance().getId()); 
                                             vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerRadio.getComponentInstance().getId());
                                          
                                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                {
                                                  vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                  vRespuestas=vListaRespuestas.iterator();
                                                  
                                                  while(vRespuestas.hasNext())
                                                      {
                                                       vValores2=(NameValuePairs)vRespuestas.next();
                                                          {
                                                            oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                            __jsp_taghandlerItem.setParent(__jsp_taghandlerRadio);
                                                            __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                            __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                            __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                            if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                              return;
                                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                          }
                                                      }// while
                                                }//checkstartVal
                                          
                                          
                                          if (__jsp_taghandlerRadio.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadio,pNivelTag+2);
                                         }//fin RADIO
                                         
                                         else if (vTipoControl.equals("RADIOSH")){
                                         
                                         oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag __jsp_taghandlerRadioShw=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowOneRadioTag id label position alignment");
                                                __jsp_taghandlerRadioShw.setParent(__jsp_taghandler__CellRw2);
                                              //__jsp_taghandlerRadioShw.setId("check2");
                                              //  __jsp_taghandlerRadioShw.setLabel(vTextoPregunta);
                                                __jsp_taghandlerRadioShw.setBinding("#{ficha_empleado_censo.shwOneRadio"+vNumRadioShw+ "}"); 
                                                __jsp_taghandlerRadioShw.setPosition("top");
                                                __jsp_taghandlerRadioShw.setAlignment("start");
                                                __jsp_tag_starteval=__jsp_taghandlerRadioShw.doStartTag();
                                                    
                                                  vNumRadioShw++;                                                
                                       //  vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadioShw);
                                        
                                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                {
                                                
                                                    {
                                                       javax.faces.webapp.AttributeTag __jsp_taghandler_Attri=(javax.faces.webapp.AttributeTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.AttributeTag.class,"javax.faces.webapp.AttributeTag name value");
                                                       __jsp_taghandler_Attri.setParent(__jsp_taghandlerRadioShw);
                                                       __jsp_taghandler_Attri.setName("id_ShwPregunta");
                                                       __jsp_taghandler_Attri.setValue(vIdPregunta);
                                                       __jsp_tag_starteval=__jsp_taghandler_Attri.doStartTag();
                                                       if (__jsp_taghandler_Attri.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                       OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Attri,pNivelTag+3);
                                                    }        
                                                
                                                  vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                  vRespuestas=vListaRespuestas.iterator();
                                                  
                                                  while(vRespuestas.hasNext())
                                                      {
                                                       vValores2=(NameValuePairs)vRespuestas.next();
                                                          {
                                                      
                                                    oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag __jsp_taghandlerItemDt=(oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CoreShowDetailItemTag text");
                                                    __jsp_taghandlerItemDt.setParent(__jsp_taghandlerRadioShw);
                                                    __jsp_taghandlerItemDt.setText(vValores2.getAttribute("respuesta").toString());
                                                    if (this.isSelectedItem(vValores2.getAttribute("id_respuesta").toString())) 
                                                     {
                                                                 __jsp_taghandlerItemDt.setDisclosed("true");   
                                                     }                                      
                                                              
                                                    __jsp_tag_starteval=__jsp_taghandlerItemDt.doStartTag();
                                               
                                                 //   if (vValores2.getAttribute("nivel").toString().equals("1")){
                                                        
                                                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                            {
                                                                     
                                                                {
                                                                   javax.faces.webapp.AttributeTag __jsp_taghandler_Attri=(javax.faces.webapp.AttributeTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.AttributeTag.class,"javax.faces.webapp.AttributeTag name value");
                                                                   __jsp_taghandler_Attri.setParent(__jsp_taghandlerItemDt);
                                                                   __jsp_taghandler_Attri.setName("id_showdt");
                                                                   __jsp_taghandler_Attri.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                   __jsp_tag_starteval=__jsp_taghandler_Attri.doStartTag();
                                                                   if (__jsp_taghandler_Attri.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                    return;
                                                                   OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Attri,pNivelTag+4);
                                                                }        
                                                                     
                                                                     
                                                                                          
                                                                vPreguntasTemp=vData.getPreguntasxResp(vValores2.getAttribute("id_respuesta").toString());
                                                                
                                                                oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag __jsp_taghandler_pnlfrm1=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelFormTag");
                                                                __jsp_taghandler_pnlfrm1.setParent(__jsp_taghandlerItemDt);
                                                                __jsp_tag_starteval=__jsp_taghandler_pnlfrm1.doStartTag();
                                                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                                {
                                                                  
                                                                
                                                                for (int vi=0;vi<vPreguntasTemp.size();vi++)
                                                                {
                                                             /*   
                                                                    oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandler_219x=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                                    __jsp_taghandler_219x.setParent(__jsp_taghandlerItemDt);
                                                                    __jsp_taghandler_219x.setLabel("Label 5"+vi);
                                                                    __jsp_tag_starteval=__jsp_taghandler_219x.doStartTag();
                                                                        if (__jsp_taghandler_219x.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                   return;
                                                                   OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_219x,11);
                                                              */  
                                                                
                                                                  GenerarUIControlTabla2(pOut,(NameValuePairs)vPreguntasTemp.get(vi), __jsp_taghandlerItemDt,pageContext,__jsp_tag_starteval,pNivelTag+5,"Left","Left");                                           
                                                                    
                                                                }  
                                                                
                                                               }
                                                               
                                                                if (__jsp_taghandler_pnlfrm1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                       return;
                                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_pnlfrm1,pNivelTag+4); 
                                                            
                                                            }
                                                 //   }
                                              
                                                   // vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerItemDt);
                                                      
                                                    if (__jsp_taghandlerItemDt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                      return;
                                                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItemDt,pNivelTag+3);
                                                  
                                                          }
                                                      }// while
                                                }//checkstartVal
                                          
                                          
                                          if (__jsp_taghandlerRadioShw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadioShw,pNivelTag+2);
                                          
                                          
                                              }//fin SHOW ONE RADIO                                                                                 
                                              
                                         else if (vTipoControl.equals("COMBO"))
                                         {
                                               
                                             oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_Combo=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label");
                                             __jsp_taghandler_Combo.setParent(__jsp_taghandler__CellRw2);
                                          //   __jsp_taghandler_Combo.setLabel("Label 1");
                                             __jsp_taghandler_Combo.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                             __jsp_tag_starteval=__jsp_taghandler_Combo.doStartTag();
                                             
                                             
                                             vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandler_Combo.getComponentInstance().getId());
                                             if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                             {
                                                 vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                 vRespuestas=vListaRespuestas.iterator();
                                                 
                                                 while(vRespuestas.hasNext())
                                                     {
                                                      vValores2=(NameValuePairs)vRespuestas.next();
                                                         {
                                                           oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                           __jsp_taghandlerItem.setParent(__jsp_taghandler_Combo);
                                                           __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                           __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                           __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                           if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                             return;
                                                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                         }
                                                     }// while                        
                                             }                               
                                             if (__jsp_taghandler_Combo.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                               return;
                                             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Combo,pNivelTag+2);  
                                               
                                         } // fin COMBO
                                         else if (vTipoControl.equals("CHECK"))
                                         {
                                          oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag __jsp_taghandlerCheck=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag label");
                                          __jsp_taghandlerCheck.setParent(__jsp_taghandler__CellRw2);
                                          __jsp_taghandlerCheck.setLayout("vertical");
                                         // __jsp_taghandlerCheck.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");  
                                          __jsp_taghandlerCheck.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                          __jsp_tag_starteval=__jsp_taghandlerCheck.doStartTag();
                                          
                                         vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerCheck.getComponentInstance().getId());
                                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                {
                                                  vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                  vRespuestas=vListaRespuestas.iterator();
                                                  
                                                  while(vRespuestas.hasNext())
                                                      {
                                                       vValores2=(NameValuePairs)vRespuestas.next();
                                                          {
                                                            oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                            __jsp_taghandlerItem.setParent(__jsp_taghandlerCheck);
                                                            __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                            __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                            __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                            if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                              return;
                                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                          }
                                                      }// while
                                                }//checkstartVal
                                          
                                          
                                          if (__jsp_taghandlerCheck.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerCheck,pNivelTag+2);
                                              }//fin CHECK
                                         else if (vTipoControl.equals("MANYSHUTTLE"))
                                         {
                                          
                                          oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag __jsp_taghandlerManyShuttle=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag size leadingHeader trailingHeader");
                                          __jsp_taghandlerManyShuttle.setParent(__jsp_taghandler__CellRw2);
                                          __jsp_taghandlerManyShuttle.setSize("5");
                                          __jsp_taghandlerManyShuttle.setLeadingHeader("Disponibles");
                                          __jsp_taghandlerManyShuttle.setTrailingHeader("Seleccionados");
                                         // __jsp_taghandlerManyShuttle.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                          __jsp_taghandlerManyShuttle.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                          __jsp_tag_starteval=__jsp_taghandlerManyShuttle.doStartTag();
                                          
                                         vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerManyShuttle.getComponentInstance().getId());        
                                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                {
                                                  vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                  vRespuestas=vListaRespuestas.iterator();
                                                  
                                                  while(vRespuestas.hasNext())
                                                      {
                                                       vValores2=(NameValuePairs)vRespuestas.next();
                                                          {
                                                            oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                            __jsp_taghandlerItem.setParent(__jsp_taghandlerManyShuttle);
                                                            __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                            __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                            __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                            if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                              return;
                                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+3);
                                                          }
                                                      }// while
                                                }//checkstartVal
                                          
                                          
                                          if (__jsp_taghandlerManyShuttle.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerManyShuttle,pNivelTag+2);
                                              }//fin ManyShuttle
                                         
                                         else if (vTipoControl.equals("INPUT"))
                                         {
                                              
                                               oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                __jsp_taghandlerInput.setParent(__jsp_taghandler__CellRw2);
                                                __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                               // __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                                __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                                vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerInput.getComponentInstance().getId());        
                                                
                                                if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                     return;
                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+2);
                                         
                                         }// fin input
                                         else if (vTipoControl.equals("INPUTFECHA")){
                                             {
                                              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag __jsp_taghandlerInputFecha=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag id showRequired autoSubmit value");
                                              __jsp_taghandlerInputFecha.setParent(__jsp_taghandler__CellRw2);                                              
                                              __jsp_taghandlerInputFecha.setShowRequired("false");
                                             //__jsp_taghandler_99.setAutoSubmit("true");
                                              __jsp_taghandlerInputFecha.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                              __jsp_tag_starteval=__jsp_taghandlerInputFecha.doStartTag();
                                                vData.setAtributo(pNumPregunta,"id_control",__jsp_taghandlerInputFecha.getComponentInstance().getId());        
                                               if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                               {
                                                {
                                                  com.sun.faces.taglib.jsf_core.ConvertDateTimeTag __jsp_taghandler_ConvertDt=(com.sun.faces.taglib.jsf_core.ConvertDateTimeTag)OracleJspRuntime.getTagHandler(pageContext,com.sun.faces.taglib.jsf_core.ConvertDateTimeTag.class,"com.sun.faces.taglib.jsf_core.ConvertDateTimeTag pattern");
                                                  __jsp_taghandler_ConvertDt.setParent(__jsp_taghandlerInputFecha);
                                                //  __jsp_taghandler_ConvertDt.setDateStyle("short");
                                                  __jsp_taghandler_ConvertDt.setPattern("dd/MM/yyyy");
                                                //  __jsp_taghandler_ConvertDt.setTimeStyle("short");
                                                  __jsp_tag_starteval=__jsp_taghandler_ConvertDt.doStartTag();
                                                  if (__jsp_taghandler_ConvertDt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                               return;
                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_ConvertDt,pNivelTag+3);
                                                 }
                                                }                                                 
                                              if (__jsp_taghandlerInputFecha.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                            return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInputFecha,pNivelTag+2);
                                             }
                                         } // input fecha
                                         
                                          else if (vTipoControl.equals("OUTLABEL"))
                                          {
                                               
                                            
                                              oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_txt=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag id styleClass value");
                                              __jsp_taghandler_txt.setParent(__jsp_taghandler__CellRw2);
                                              __jsp_taghandler_txt.setStyleClass("tituloscontrol1");
                                              __jsp_taghandler_txt.setValue(vTextoPregunta);
                                              __jsp_tag_starteval=__jsp_taghandler_txt.doStartTag();
                                                  if (__jsp_taghandler_txt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                         return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_txt,pNivelTag+2);
                                                                                              
                                          
                                          }// fin label
                                           else if (vTipoControl.equals("TABLAI"))
                                           {
                                           
                                               String vEncabezado;
                                               String [] vColumnas,vPropiedades;
                                               String vAnchoColumnas;
                                               int vTamanio;
                                               
                                               vProperties=(vProperties==null?"":vProperties);
                                               vPropiedades=vProperties.split("\\|");
                                               if (vPropiedades.length>0){
                                                   vAnchoColumnas=vPropiedades[0];
                                                   
                                               }else{
                                                   vAnchoColumnas="200";
                                               }
                                               
                                               
                                               
                                               vColumnas=vTextoOtros.split("\\|");                                               
                                               vEncabezado="<table><tr class='titulosTabla'><td>"+vTextoPregunta+"</td><td></td>";
                                               vTamanio=vColumnas.length;
                                               
                                               for (int i=0;i<vTamanio;i++){
                                                   
                                                   vEncabezado=vEncabezado+"<td width='"+vAnchoColumnas+"'>"+vColumnas[i]+"</td>";
                                                   
                                               }
                                               vEncabezado=vEncabezado+"</tr>";
                                               
                                               escribir(pOut,__jsp_taghandler__CellRw2,pageContext,__jsp_tag_starteval,pNivelTag+2,vEncabezado);                                           
                                           
                                           }
                                           else if (vTipoControl.equals("TABLAF"))
                                           {
                                               escribir(pOut,__jsp_taghandler__CellRw2,pageContext,__jsp_tag_starteval,pNivelTag+2,"</table>");    
                                           
                                           
                                           }
                                            else if (vTipoControl.equals("TABLAINTERRUP"))
                                            {
                       
                                                this.UITABLAInterrup(pOut,pDataPregunta,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag+2,"Left","Left");                                                                                                                           
                       
                                            }
                                            else if (vTipoControl.equals("PANELHORI"))
                                            {
                       
                                               // this.UITABLAInterrup(pOut,pDataPregunta,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag+2,"Left","Left");                                                                                                                           
                       
                                      
                                                String [] vPropiedades;
                                                String vAnchoSeparador;          
                                                
                                                vProperties=(vProperties==null?"":vProperties);
                                                vPropiedades=vProperties.split("\\|");
                                                if (vPropiedades.length>0){
                                                    vAnchoSeparador=vPropiedades[0];
                                                    
                                                }else{
                                                    vAnchoSeparador="200";
                                                }
                                                
                       
                                                {
                                                   oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag __jsp_taghandler_pnlH=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag id");
                                                   __jsp_taghandler_pnlH.setParent(__jsp_taghandler__CellRw2);
                                                   //__jsp_taghandler_86.setId("panelHorizontal");
                                                   __jsp_taghandler_pnlH.setHalign("left");
                                                   __jsp_tag_starteval=__jsp_taghandler_pnlH.doStartTag();
                                                   if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval)) 
                                                   {
                                                       vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                       vRespuestas=vListaRespuestas.iterator();
                                                       vValores2=(NameValuePairs)vRespuestas.next();
                                                       vPreguntasTemp=vData.getPreguntasxResp(vValores2.getAttribute("id_respuesta").toString());
                                                       

                                                      for (int vi=0;vi<vPreguntasTemp.size();vi++)
                                                       {

                                                       GenerarUIControlTabla2(pOut,(NameValuePairs)vPreguntasTemp.get(vi), __jsp_taghandler_pnlH,pageContext,__jsp_tag_starteval,pNivelTag+3,"Left","Left");                                           
                                                       
                                                       }
                                                       
                                                     
                                                       {
                                                           javax.faces.webapp.FacetTag __jsp_taghandler_91=(javax.faces.webapp.FacetTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.FacetTag.class,"javax.faces.webapp.FacetTag name");
                                                           __jsp_taghandler_91.setParent(__jsp_taghandler_pnlH);
                                                           __jsp_taghandler_91.setName("separator");
                                                           __jsp_tag_starteval=__jsp_taghandler_91.doStartTag();
                                                           if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                            {
                                                           do {
                                                                 {
                                                                  oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandler_92=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                                                                  __jsp_taghandler_92.setParent(__jsp_taghandler_91);
                                                                  __jsp_taghandler_92.setWidth(vAnchoSeparador);
                                                                  __jsp_taghandler_92.setHeight("10");
                                                                  __jsp_tag_starteval=__jsp_taghandler_92.doStartTag();
                                                                  if (__jsp_taghandler_92.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                                 return;
                                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_92,pNivelTag+4);
                                                                 }
                                                           } while (__jsp_taghandler_91.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                            }
                                                            if (__jsp_taghandler_91.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                        return;
                                                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_91,pNivelTag+3);
                                                    } 
                                                       
                                                   }
                                                if (__jsp_taghandler_pnlH.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_pnlH,pNivelTag+2); 
                                                   
                       
                                            }
                                    }
                                            
                        //   } // FIN TAG PANELLABEL
                            
                            /*
                                 if (vOpcionOtros.equals("1")) // Se agrega la opcion de otros un input text
                                 { 
                               
                                      oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                      __jsp_taghandlerInput.setParent(__jsp_taghandler__CellRw2);
                                      
                                      if (vTextoOtros!=null && !vTextoOtros.equals(""))
                                     __jsp_taghandlerInput.setLabel(vTextoOtros);
                                       else                                      
                                     __jsp_taghandlerInput.setLabel("Otro, especifique");
                                      
                                      
                                      __jsp_taghandlerInput.setColumns("20");
                                      __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                   //   __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                      __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                      if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+2);
                                 
                                 }
                                 
                                 */
                                 /*
                                  { // Agregando un espacio entre las preguntas
                                    oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandlerSpaceTag=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                                    __jsp_taghandlerSpaceTag.setParent(__jsp_taghandler__CellRw2);
                                    __jsp_taghandlerSpaceTag.setWidth("10");
                                    __jsp_taghandlerSpaceTag.setHeight("16");
                                    __jsp_tag_starteval=__jsp_taghandlerSpaceTag.doStartTag();
                                    if (__jsp_taghandlerSpaceTag.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                      return;
                                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerSpaceTag,pNivelTag+2);
                 
                                  }
                      */
                   } 
                  if (__jsp_taghandler__CellRw2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                   return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler__CellRw2,pNivelTag+1);
                    
                    
                  if (vOpcionOtros.equals("2"))  // opcion otros pero a la par
                  {
                           
                      oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler__CellRw3=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                      __jsp_taghandler__CellRw3.setParent(__jsp_taghandler_rw2);
                      __jsp_taghandler__CellRw3.setHalign(pAlignControl);
                      __jsp_tag_starteval=__jsp_taghandler__CellRw3.doStartTag();
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                       {

                           oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                           __jsp_taghandlerInput.setParent(__jsp_taghandler__CellRw3);
                           
                           if (vTextoOtros!=null && !vTextoOtros.equals(""))
                           __jsp_taghandlerInput.setLabel(vTextoOtros);
                            else                                      
                           __jsp_taghandlerInput.setLabel("Otro, especifique");
                           
                           
                           __jsp_taghandlerInput.setColumns("20");
                           __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                           //   __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                           __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                           if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                     return;
                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+2);


                       }                             
                                                          
                      if (__jsp_taghandler__CellRw3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                       return;
                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler__CellRw3,pNivelTag+1);                                    
                                                          
                  }
                  
                    
                    
                 }// fin cell de control de pregunta
                 
                 
                if (__jsp_taghandler_rw2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw2,pNivelTag);

             if (vOpcionOtros.equals("1"))
             {   
               
                oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw3=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
                __jsp_taghandler_rw3.setParent(pParentTag);
                __jsp_tag_starteval=__jsp_taghandler_rw3.doStartTag();
                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                  {
             
                      oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler__CellRw4=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                      __jsp_taghandler__CellRw4.setParent(__jsp_taghandler_rw3);
                      __jsp_taghandler__CellRw4.setHalign("Left");
                      __jsp_tag_starteval=__jsp_taghandler__CellRw4.doStartTag();
                      
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                       {

                           {
                             oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag __jsp_taghandler_pnlH=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHorizontalTag");
                             __jsp_taghandler_pnlH.setParent(__jsp_taghandler__CellRw4);
                             __jsp_tag_starteval=__jsp_taghandler_pnlH.doStartTag();
                              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                 {
                                     {
                                        oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_outTxt=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag value");
                                         __jsp_taghandler_outTxt.setParent(__jsp_taghandler_pnlH);
                                           if (vTextoOtros!=null && !vTextoOtros.equals(""))
                                         __jsp_taghandler_outTxt.setValue(vTextoOtros);
                                            else                            
                                         __jsp_taghandler_outTxt.setValue("Otro, especifique: ");
                                         
                                         __jsp_tag_starteval=__jsp_taghandler_outTxt.doStartTag();
                                          if (__jsp_taghandler_outTxt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_outTxt,pNivelTag+3);
                                       }
                                            {
                                                oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                __jsp_taghandlerInput.setParent(__jsp_taghandler_pnlH);                                
                                                __jsp_taghandlerInput.setLabel(null); 
                                                __jsp_taghandlerInput.setColumns("20");
                                                __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                                //   __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                                __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                                if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag+3);

                                              
                                              
                                            }
                                         }
                                        if (__jsp_taghandler_pnlH.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                  return;
                                           OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_pnlH,pNivelTag+2);
                             }
                            

                       }                             
                      if (__jsp_taghandler__CellRw4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                       return;
                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler__CellRw4,pNivelTag+1);        

                  }
                 if (__jsp_taghandler_rw3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                     return;
                 OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw3,pNivelTag); 
             
             }
             
            if (!vTipoControl.equals("LABEL") && !vTipoControl.equals("TABLAI")) 
            { 
             oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag __jsp_taghandler_rw3=(oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlRowLayoutTag");
             __jsp_taghandler_rw3.setParent(pParentTag);
             __jsp_tag_starteval=__jsp_taghandler_rw3.doStartTag();
             if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
               {
                   oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler__CellRw4=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag");
                   __jsp_taghandler__CellRw4.setParent(__jsp_taghandler_rw3);                   
                   __jsp_taghandler__CellRw4.setHeight("10");
                   __jsp_tag_starteval=__jsp_taghandler__CellRw4.doStartTag();
                   
                   if (__jsp_taghandler__CellRw4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                     OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler__CellRw4,pNivelTag+1);        
             
               }
             if (__jsp_taghandler_rw3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                 return;
             OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_rw3,pNivelTag); 
             
             }
             
         }else{
             
            System.out.println("no existe grupo"); 
         }
       }else{
           
           GenerarUIControl2(pOut,pDataPregunta,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,pAlignPreg,pAlignControl);
           
       }
      
      }


    /*
     * Version 2 para la generacion de las preguntas
     */
    public void GenerarUIControl2(JspWriter pOut,NameValuePairs pDataPregunta,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,String pAlignPreg,String pAlignControl)  throws Exception
        {
                ArrayList vListaRespuestas;
                Iterator vRespuestas;
                String vTextoPregunta="",vTipoControl="",vOpcionOtros="",vIdPregunta,vGrupo,vProperties,vTextoOtros,vImprimePreg;
                Object vIdPadre;    
                
                String vCategoriaPreg;    
                NameValuePairs vValores2;
                ArrayList vPreguntasTemp;
                
                     vCategoriaPreg=pDataPregunta.getAttribute("nombre_categoria").toString();
                     vTextoPregunta=pDataPregunta.getAttribute("pregunta").toString();
                     vIdPregunta=pDataPregunta.getAttribute("id_pregunta").toString();
                     vTipoControl=pDataPregunta.getAttribute("tipo_control").toString();
                     vOpcionOtros=pDataPregunta.getAttribute("opcion_otros").toString();
                     vIdPadre=pDataPregunta.getAttribute("id_pregunta_padre");
                     vTextoOtros=pDataPregunta.getAttribute("texto_otros").toString();
                     vGrupo=pDataPregunta.getAttribute("grupo").toString();
                     vImprimePreg=pDataPregunta.getAttribute("imprime_preg").toString();
                     
                     
                     vProperties=(pDataPregunta.getAttribute("properties")==null?null:pDataPregunta.getAttribute("properties").toString());
                     
                 if (vGrupo.equals(vGrupoPreg)){
                     
                     
                     pNumPregunta++;
                     // Para imprimir el panel
                     /*
                     if (!vCategoriaPreg.equals(pCategoriaAnt))
                     {
                         pCategoriaAnt=vCategoriaPreg; 
                          {
                                           
                                      oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag __jsp_taghandler_cellrw=(oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag.class,"oracle.adfinternal.view.faces.taglib.html.HtmlCellFormatTag columnSpan header");
                                      __jsp_taghandler_cellrw.setParent(pParentTag);
                                      __jsp_taghandler_cellrw.setColumnSpan("3");
                                      __jsp_taghandler_cellrw.setHeader("false");
                                      __jsp_tag_starteval=__jsp_taghandler_cellrw.doStartTag();
                                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                           {
                                              {
                                                  oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag __jsp_taghandlerPanel=(oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag.class,"oracle.adfinternal.view.faces.taglib.core.layout.CorePanelHeaderTag text");
                                                  __jsp_taghandlerPanel.setParent(__jsp_taghandler_cellrw);                                 
                                                  __jsp_taghandlerPanel.setText(vCategoriaPreg);
                                                  __jsp_taghandlerPanel.setMessageType("info");
                                                  __jsp_taghandlerPanel.setSize("0");
                                                  __jsp_tag_starteval=__jsp_taghandlerPanel.doStartTag();
                                                  if (__jsp_taghandlerPanel.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                 OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerPanel,pNivelTag+3);                                                                                                                                     
                                                 
                                             }                                                                                                                
                                         }
                                       if (__jsp_taghandler_cellrw.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_cellrw,pNivelTag);
                                 
                                     
                           }

                  
                      }//Verificando si se coloca el panel en cambio de categoria    
                    */
                     // System.out.println("pregunta " + vIdPregunta + " "+vTextoPregunta+ " "+pNumPregunta); 
                        
                     /////   pregunta 
                                      
                                   if ( vImprimePreg.equals("2") ||vImprimePreg.equals("6") ){
                                       
                                       escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<tr><td>");      
                                       
                                   }else if ( vImprimePreg.equals("3")|| vImprimePreg.equals("5")){
                                       escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td>");      
                                       
                                   }
                                            
                                            
                                      
                                              oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_252=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag styleClass value");
                                              __jsp_taghandler_252.setParent(pParentTag);
                                              __jsp_taghandler_252.setStyleClass("titulosPreg");
                                              
                                            if ( vImprimePreg.equals("2") || vImprimePreg.equals("5") ||vImprimePreg.equals("6"))
                                              __jsp_taghandler_252.setValue(vTextoPregunta);
                                            else  
                                              __jsp_taghandler_252.setValue("");
                                              
                                              __jsp_tag_starteval=__jsp_taghandler_252.doStartTag();
                                              if (__jsp_taghandler_252.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_252,pNivelTag+2);
                         
                                
                                     if ( vImprimePreg.equals("2") ){
                                         
                                         escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</td>");      
                                         
                                     }else if ( vImprimePreg.equals("3")){
                                         escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</td>");      
                                         
                                     }else if ( vImprimePreg.equals("4")||vImprimePreg.equals("5")){
                                      //   escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td></tr>");      
                                         
                                     } 
                                      
                                          //----------------------------------------
                       
                                          // controles de preguntas
                       
                                           if (vTipoControl.equals("COMBOC")|| vTipoControl.equals("RADIOC")|| vTipoControl.equals("CHECKC")||vTipoControl.equals("INPUTC"))
                                           {
                                                                                
                                              if ( vImprimePreg.equals("2") || vImprimePreg.equals("3")||vImprimePreg.equals("4")||vImprimePreg.equals("6")  ){                                                  
                                                 escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td><table>");      
                                              }
                                                                                               
                                           }   

                                            
                                                         
                                           if (vTipoControl.equals("RADIO")||vTipoControl.equals("RADIOC"))
                                           {
                                           
                                           /*
                                                 if (vTipoControl.equals("RADIOC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3")||vImprimePreg.equals("4"))){
                                                     
                                                     escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td><table>");      
                                                     
                                                 }
                                           */
                                              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag __jsp_taghandlerRadio=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneRadioTag layout value");
                                              __jsp_taghandlerRadio.setParent(pParentTag);     
                                              
                                              if (vProperties==null|| (vProperties!=null && vProperties.equals("1")))
                                              __jsp_taghandlerRadio.setLayout("vertical");
                                              else if (vProperties!=null && vProperties.equals("2"))
                                              __jsp_taghandlerRadio.setLayout("horizontal");
                                              
                                              //__jsp_taghandlerRadio.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                              __jsp_taghandlerRadio.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                              __jsp_tag_starteval=__jsp_taghandlerRadio.doStartTag();
                                              
                                          //    vDataPreguntas.setPreguntaControl(vIdPregunta,__jsp_taghandlerRadio);
                                              
                                              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                    {
                                                      vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                      vRespuestas=vListaRespuestas.iterator();
                                                      
                                                      while(vRespuestas.hasNext())
                                                          {
                                                           vValores2=(NameValuePairs)vRespuestas.next();
                                                              {
                                                                oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                                __jsp_taghandlerItem.setParent(__jsp_taghandlerRadio);
                                                                __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                                __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                                if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                  return;
                                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                                              }
                                                          }// while
                                                    }//checkstartVal
                                              
                                              
                                              if (__jsp_taghandlerRadio.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerRadio,pNivelTag);
                                              
                                              /*
                                                 if (vTipoControl.equals("RADIOC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3"))){
                                                     
                                                     escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td>");      
                                                     
                                                 }else if (vTipoControl.equals("RADIOC") && ( vImprimePreg.equals("4") || vImprimePreg.equals("5"))){
                                                 
                                                     escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td></tr>");      
                                                 }
                                                */
                                              
                                             }//fin RADIO                                                                                            
                                             else if (vTipoControl.equals("COMBO") || vTipoControl.equals("COMBOC"))
                                             {
                                                   /*
                                                 if (vTipoControl.equals("COMBOC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3")||vImprimePreg.equals("4")||vImprimePreg.equals("6")  ))
                                                 {
                                                                                                     
                                                       escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td><table>");      
                                                                                                     
                                                 }   
                                                   */
                                                 oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_Combo=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label");
                                                 __jsp_taghandler_Combo.setParent(pParentTag);
                                              //   __jsp_taghandler_Combo.setLabel("Label 1");
                                                 __jsp_taghandler_Combo.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                                 __jsp_tag_starteval=__jsp_taghandler_Combo.doStartTag();
                                                 if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                 {
                                                     vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                     vRespuestas=vListaRespuestas.iterator();
                                                     
                                                     while(vRespuestas.hasNext())
                                                         {
                                                          vValores2=(NameValuePairs)vRespuestas.next();
                                                             {
                                                               oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                               __jsp_taghandlerItem.setParent(__jsp_taghandler_Combo);
                                                               __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                               __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                               __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                               if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                 return;
                                                               OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                                             }
                                                         }// while                        
                                                 }                               
                                                 if (__jsp_taghandler_Combo.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                   return;
                                                 OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_Combo,pNivelTag);  
                                              /* 
                                                 
                                                 if (vTipoControl.equals("COMBOC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3"))){
                                                                                                   
                                                          escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td>");      
                                                                                      
                                                 }else if (vTipoControl.equals("COMBOC") && ( vImprimePreg.equals("4") || vImprimePreg.equals("5") || vImprimePreg.equals("6"))){
                                                                                               
                                                           escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td></tr>");      
                                                 }
 /*
                                               */    
                                             } // fin COMBO
                                             else if (vTipoControl.equals("CHECK") || vTipoControl.equals("CHECKC"))
                                             {
                                             
                                             /*
                                              if (vTipoControl.equals("CHECKC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3")||vImprimePreg.equals("4")))
                                              {
                                                                                                          
                                                escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td><table>");      
                                                                                                          
                                              }   
                                             */
                                              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag __jsp_taghandlerCheck=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyCheckboxTag label");
                                              __jsp_taghandlerCheck.setParent(pParentTag);
                                              __jsp_taghandlerCheck.setLayout("vertical");
                                             // __jsp_taghandlerCheck.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");  
                                              __jsp_taghandlerCheck.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                              __jsp_tag_starteval=__jsp_taghandlerCheck.doStartTag();
                                              
                                              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                    {
                                                      vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                      vRespuestas=vListaRespuestas.iterator();
                                                      
                                                      while(vRespuestas.hasNext())
                                                          {
                                                           vValores2=(NameValuePairs)vRespuestas.next();
                                                              {
                                                                oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                                __jsp_taghandlerItem.setParent(__jsp_taghandlerCheck);
                                                                __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                                __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                                if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                  return;
                                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                                              }
                                                          }// while
                                                    }//checkstartVal
                                              
                                              
                                              if (__jsp_taghandlerCheck.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerCheck,pNivelTag);
                                            /*
                                              if (vTipoControl.equals("CHECKC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3"))){
                                                                                                  
                                                         escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td>");      
                                                                                     
                                             }else if (vTipoControl.equals("CHECKC") && ( vImprimePreg.equals("4") || vImprimePreg.equals("5"))){
                                                                                              
                                                          escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td></tr>");      
                                             }
                                            */
                                            }//fin CHECK
                                             else if (vTipoControl.equals("MANYSHUTTLE"))
                                             {
                                              
                                              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag __jsp_taghandlerManyShuttle=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectManyShuttleTag size leadingHeader trailingHeader");
                                              __jsp_taghandlerManyShuttle.setParent(pParentTag);
                                              __jsp_taghandlerManyShuttle.setSize("5");
                                              __jsp_taghandlerManyShuttle.setLeadingHeader("Disponibles");
                                              __jsp_taghandlerManyShuttle.setTrailingHeader("Seleccionados");
                                             // __jsp_taghandlerManyShuttle.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                              __jsp_taghandlerManyShuttle.setValue("#{ficha_empleado_censo.respuesta"+pNumPregunta+"}");
                                              __jsp_tag_starteval=__jsp_taghandlerManyShuttle.doStartTag();
                                              
                                              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                    {
                                                      vListaRespuestas=(ArrayList)pDataPregunta.getAttribute("respuestas");
                                                      vRespuestas=vListaRespuestas.iterator();
                                                      
                                                      while(vRespuestas.hasNext())
                                                          {
                                                           vValores2=(NameValuePairs)vRespuestas.next();
                                                              {
                                                                oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandlerItem=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                                                                __jsp_taghandlerItem.setParent(__jsp_taghandlerManyShuttle);
                                                                __jsp_taghandlerItem.setLabel(vValores2.getAttribute("respuesta").toString());
                                                                __jsp_taghandlerItem.setValue(vValores2.getAttribute("id_respuesta").toString());
                                                                __jsp_tag_starteval=__jsp_taghandlerItem.doStartTag();
                                                                if (__jsp_taghandlerItem.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                  return;
                                                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerItem,pNivelTag+1);
                                                              }
                                                          }// while
                                                    }//checkstartVal
                                              
                                              
                                              if (__jsp_taghandlerManyShuttle.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerManyShuttle,pNivelTag);
                                                  }//fin ManyShuttle
                                             
                                             else if (vTipoControl.equals("INPUT") || vTipoControl.equals("INPUTC"))
                                             {
                                             
                                             /*
                                                 if (vTipoControl.equals("INPUTC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3")||vImprimePreg.equals("4")))
                                                 {
                                                                                                             
                                                   escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<td><table>");      
                                                                                                             
                                                 }   
                                                 */ 
                                                   oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                                    __jsp_taghandlerInput.setParent(pParentTag);
                                                    __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                                   // __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                                    __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                                    if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                         return;
                                                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag);
                                             
                                             /*
                                                 if (vTipoControl.equals("INPUTC") && ( vImprimePreg.equals("2") || vImprimePreg.equals("3"))){
                                                                                                     
                                                            escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td>");      
                                                                                        
                                                 }else if (vTipoControl.equals("INPUTC") && ( vImprimePreg.equals("4") || vImprimePreg.equals("5"))){
                                                                                                 
                                                             escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td></tr>");      
                                                 }    
                                             
                                             */
                                             }// fin input
                                              else if (vTipoControl.equals("OUTLABEL"))
                                              {
                                                   
                                                
                                                  oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_txt=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag id styleClass value");
                                                  __jsp_taghandler_txt.setParent(pParentTag);
                                                  __jsp_taghandler_txt.setStyleClass("tituloscontrol1");
                                                  __jsp_taghandler_txt.setValue(vTextoPregunta);
                                                  __jsp_tag_starteval=__jsp_taghandler_txt.doStartTag();
                                                      if (__jsp_taghandler_txt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                             return;
                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_txt,pNivelTag+2);
                                                                                                  
                                              
                                              }// fin label
                                               else if (vTipoControl.equals("TABLAI"))
                                               {
                                               
                                                   String vEncabezado;
                                                   String [] vColumnas;
                                                   int vTamanio;
                                                   
                                                   vColumnas=vTextoOtros.split("\\|");                                               
                                                   vEncabezado="<table><tr class='titulosTabla'><td>"+vTextoPregunta+"</td>";
                                                   vTamanio=vColumnas.length;
                                                   
                                                   for (int i=0;i<vTamanio;i++){
                                                       
                                                       vEncabezado=vEncabezado+"<td width='200'>"+vColumnas[i]+"</td>";
                                                       
                                                   }
                                                   vEncabezado=vEncabezado+"</tr>";
                                                   
                                                   escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,vEncabezado);                                           
                                               
                                               }
                                               else if (vTipoControl.equals("TABLAF"))
                                               {
                                                   escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table>");    
                                               
                                               
                                               }
                                               else if (vTipoControl.equals("TABLAINTERRUP"))
                                               {
                                               
                                                  this.UITABLAInterrup(pOut,pDataPregunta,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag+1,"Left","Left");                                                                                                                           
                                               
                                               }
                                               
                                               
                 
                                            if (vTipoControl.equals("COMBOC")|| vTipoControl.equals("RADIOC")|| vTipoControl.equals("CHECKC")||vTipoControl.equals("INPUTC"))
                                            {

                                                if ( vImprimePreg.equals("2") || vImprimePreg.equals("3")){
                                                    
                                                    escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td>");  
                                                    
                                                }else if (( vImprimePreg.equals("4") || vImprimePreg.equals("5") || vImprimePreg.equals("6")))
                                                {
                                                    escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</table></td></tr>");      
                                                }
                                                                                                                                                                   
                                            }          
                                               
                                               
                 
                            //   } // FIN TAG PANELLABEL
                                
                                
                                     if (vOpcionOtros.equals("1")) // Se agrega la opcion de otros un input text
                                     { 
                                   
                                          oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag __jsp_taghandlerInput=(oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreInputTextTag label");
                                          __jsp_taghandlerInput.setParent(pParentTag);
                                         if (vTextoOtros!=null && !vTextoOtros.equals(""))
                                         __jsp_taghandlerInput.setLabel(vTextoOtros);
                                          else                                      
                                         __jsp_taghandlerInput.setLabel("Otro, especifique");
                                          __jsp_taghandlerInput.setColumns("20");
                                          __jsp_taghandlerInput.setValue("#{ficha_empleado_censo.respuestaOtros"+pNumPregunta+"}");
                                       //   __jsp_taghandlerInput.setDisabled("#{bindings.estContrl1.inputValue==false?bindings.EstadoControl3.inputValue:true}");
                                          __jsp_tag_starteval=__jsp_taghandlerInput.doStartTag();
                                          if (__jsp_taghandlerInput.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerInput,pNivelTag);
                                     
                                     }
                                     /*
                                      { // Agregando un espacio entre las preguntas
                                        oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag __jsp_taghandlerSpaceTag=(oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreObjectSpacerTag width height");
                                        __jsp_taghandlerSpaceTag.setParent(pParentTag);
                                        __jsp_taghandlerSpaceTag.setWidth("10");
                                        __jsp_taghandlerSpaceTag.setHeight("16");
                                        __jsp_tag_starteval=__jsp_taghandlerSpaceTag.doStartTag();
                                        if (__jsp_taghandlerSpaceTag.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                          return;
                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandlerSpaceTag,pNivelTag);
                     
                                      }
                          */

             }else{
                 
                System.out.println("no existe grupo"); 
             }
          }


public void escribir(JspWriter pOut,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,String pHTML)throws Exception{
    
    {
      com.sun.faces.taglib.jsf_core.VerbatimTag __jsp_taghandler_vbt=(com.sun.faces.taglib.jsf_core.VerbatimTag)OracleJspRuntime.getTagHandler(pageContext,com.sun.faces.taglib.jsf_core.VerbatimTag.class,"com.sun.faces.taglib.jsf_core.VerbatimTag");
      __jsp_taghandler_vbt.setParent(pParentTag);
      __jsp_tag_starteval=__jsp_taghandler_vbt.doStartTag();
      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
      {
        pOut=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_vbt,__jsp_tag_starteval,pOut);
        do {
            pOut.write(pHTML);
        } while (__jsp_taghandler_vbt.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        pOut=OracleJspRuntime.popBodyIfNeeded(pageContext,pOut);
      }
      if (__jsp_taghandler_vbt.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_vbt,pNivelTag);
    }

  
    //pOut.
}

public void div(JspWriter pOut,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,int pOpcion)throws Exception{
    
    if (pOpcion==1)
     escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"<div id='hola'>");
    else
    escribir(pOut,pParentTag,pageContext,__jsp_tag_starteval,pNivelTag,"</div>");
    
}

/*
 * Método para generar la tabla
 */
public void UITABLAInterrup(JspWriter pOut,NameValuePairs pDataPregunta,Tag pParentTag,PageContext pageContext,int __jsp_tag_starteval,int pNivelTag,String pAlignPreg,String pAlignControl)  throws Exception
{    

  //System.out.println("creando tabla");

    {
      oracle.adfinternal.view.faces.taglib.core.data.CoreTableTag __jsp_taghandler_7=(oracle.adfinternal.view.faces.taglib.core.data.CoreTableTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.data.CoreTableTag.class,"oracle.adfinternal.view.faces.taglib.core.data.CoreTableTag emptyText banding bandingInterval var value rows binding");
      __jsp_taghandler_7.setParent(pParentTag);
      __jsp_taghandler_7.setEmptyText("Ningula fila");
      __jsp_taghandler_7.setBanding("row");
      __jsp_taghandler_7.setId("tbl_interrupt");
      __jsp_taghandler_7.setBandingInterval("1");
      __jsp_taghandler_7.setPartialTriggers("tbl_interrupt:btn_agregar tbl_interrupt:btn_editar tbl_interrupt:btn_eliminar tbl_interrupt:btn_aceptar");
      __jsp_taghandler_7.setVar("row");
      __jsp_taghandler_7.setValue("#{interrupcion_lab_TableHandler.tableModel}");
      __jsp_taghandler_7.setRows("50");
      __jsp_taghandler_7.setBinding("#{interrupcion_lab_TableHandler.tbl_interrupcion}");
      __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
      {
        {
          javax.faces.webapp.FacetTag __jsp_taghandler_8=(javax.faces.webapp.FacetTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.FacetTag.class,"javax.faces.webapp.FacetTag name");
          __jsp_taghandler_8.setParent(__jsp_taghandler_7);
          __jsp_taghandler_8.setName("selection");
          __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            do {
              {
                oracle.adfinternal.view.faces.taglib.core.data.CoreTableSelectOneTag __jsp_taghandler_9=(oracle.adfinternal.view.faces.taglib.core.data.CoreTableSelectOneTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.data.CoreTableSelectOneTag.class,"oracle.adfinternal.view.faces.taglib.core.data.CoreTableSelectOneTag");
                __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,pNivelTag+2);
              }
            } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          }
          if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,pNivelTag+1);
        }
        {
          oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag __jsp_taghandler_10=(oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag.class,"oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag headerText sortable");
          __jsp_taghandler_10.setParent(__jsp_taghandler_7);
          __jsp_taghandler_10.setHeaderText("Interrupción");
          __jsp_taghandler_10.setSortable("false");
          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            {
              oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_11=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag value rendered");
              __jsp_taghandler_11.setParent(__jsp_taghandler_10);
              __jsp_taghandler_11.setValue("#{row.tipoInterrupcion}");
              __jsp_taghandler_11.setRendered("#{not row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,pNivelTag+2);
            }
            {
              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag __jsp_taghandler_12=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectOneChoiceTag label value rendered");
              __jsp_taghandler_12.setParent(__jsp_taghandler_10);
              __jsp_taghandler_12.setLabel("Label 1");
              __jsp_taghandler_12.setValue("#{row.tipoInterrupcion}");
              __jsp_taghandler_12.setRendered("#{row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                {
                  oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandler_13=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                  __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                  __jsp_taghandler_13.setLabel("Suspensiones del IGSS");
                  __jsp_taghandler_13.setValue("Suspensiones del IGSS");
                  __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                  if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,pNivelTag+3);
                }
                {
                  oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandler_14=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                  __jsp_taghandler_14.setParent(__jsp_taghandler_12);
                  __jsp_taghandler_14.setLabel("Finalización de contrato");
                  __jsp_taghandler_14.setValue("Finalización de contrato");
                  __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                  if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,pNivelTag+3);
                }
                {
                  oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandler_15=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                  __jsp_taghandler_15.setParent(__jsp_taghandler_12);
                  __jsp_taghandler_15.setLabel("Despido");
                  __jsp_taghandler_15.setValue("Despido");
                  __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                  if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,pNivelTag+3);
                }
                {
                  oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag __jsp_taghandler_16=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectItemTag label value");
                  __jsp_taghandler_16.setParent(__jsp_taghandler_12);
                  __jsp_taghandler_16.setLabel("Renuncia");
                  __jsp_taghandler_16.setValue("Renuncia");
                  __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                  if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,pNivelTag+3);
                }
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,pNivelTag+2);
            }
          }
          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,pNivelTag+1);
        }
        {
          oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag __jsp_taghandler_17=(oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag.class,"oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag formatType headerText sortable");
          __jsp_taghandler_17.setParent(__jsp_taghandler_7);
          __jsp_taghandler_17.setFormatType("text");
          __jsp_taghandler_17.setHeaderText("Suspención");
          __jsp_taghandler_17.setSortable("false");
          __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            {
              oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_18=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag value rendered");
              __jsp_taghandler_18.setParent(__jsp_taghandler_17);
              __jsp_taghandler_18.setValue("#{row.fechaI}");
              __jsp_taghandler_18.setRendered("#{not row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,pNivelTag+2);
            }
            {
              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag __jsp_taghandler_19=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag label value converter rendered");
              __jsp_taghandler_19.setParent(__jsp_taghandler_17);
              __jsp_taghandler_19.setLabel("Label 1");
              __jsp_taghandler_19.setValue("#{row.fechaI}");
              __jsp_taghandler_19.setConverter("oracle.adf.DateTime");
              __jsp_taghandler_19.setRendered("#{row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,pNivelTag+2);
            }
          }
          if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,pNivelTag+1);
        }
        {
          oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag __jsp_taghandler_20=(oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag.class,"oracle.adfinternal.view.faces.taglib.core.data.CoreColumnTag headerText sortable");
          __jsp_taghandler_20.setParent(__jsp_taghandler_7);
          __jsp_taghandler_20.setHeaderText("Reingreso");
          __jsp_taghandler_20.setSortable("false");
          __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            {
              oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_21=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag value rendered");
              __jsp_taghandler_21.setParent(__jsp_taghandler_20);
              __jsp_taghandler_21.setValue("#{row.fechaF}");
              __jsp_taghandler_21.setRendered("#{not row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,pNivelTag+2);
            }
            {
              oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag __jsp_taghandler_22=(oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag.class,"oracle.adfinternal.view.faces.taglib.core.input.CoreSelectInputDateTag label value rendered");
              __jsp_taghandler_22.setParent(__jsp_taghandler_20);
              __jsp_taghandler_22.setLabel("Label 2");
              __jsp_taghandler_22.setValue("#{row.fechaF}");
              __jsp_taghandler_22.setRendered("#{row.selected}");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,pNivelTag+2);
            }
          }
          if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,pNivelTag+1);
        }
        {
          javax.faces.webapp.FacetTag __jsp_taghandler_23=(javax.faces.webapp.FacetTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.FacetTag.class,"javax.faces.webapp.FacetTag name");
          __jsp_taghandler_23.setParent(__jsp_taghandler_7);
          __jsp_taghandler_23.setName("actions");
          __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            do {
              {
                com.sun.faces.taglib.html_basic.PanelGroupTag __jsp_taghandler_24=(com.sun.faces.taglib.html_basic.PanelGroupTag)OracleJspRuntime.getTagHandler(pageContext,com.sun.faces.taglib.html_basic.PanelGroupTag.class,"com.sun.faces.taglib.html_basic.PanelGroupTag");
                __jsp_taghandler_24.setParent(__jsp_taghandler_23);
                __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                {
                  {
                    oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag __jsp_taghandler_25=(oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag.class,"oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag text action binding");
                    __jsp_taghandler_25.setParent(__jsp_taghandler_24);
                    __jsp_taghandler_25.setText("Agregar");
                    __jsp_taghandler_25.setId("btn_agregar");
                    __jsp_taghandler_25.setPartialSubmit("true");
                    __jsp_taghandler_25.setAction("#{interrupcion_lab_TableHandler.agregar_btn}");
                    __jsp_taghandler_25.setBinding("#{interrupcion_lab_TableHandler.btn_agregar}");
                    __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                    if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,pNivelTag+3);
                  }
                  {
                    oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag __jsp_taghandler_26=(oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag.class,"oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag text action binding");
                    __jsp_taghandler_26.setParent(__jsp_taghandler_24);
                    __jsp_taghandler_26.setText("Editar");
                    __jsp_taghandler_26.setId("btn_editar");
                    __jsp_taghandler_26.setPartialSubmit("true");
                    __jsp_taghandler_26.setAction("#{interrupcion_lab_TableHandler.editar_btn}");
                    __jsp_taghandler_26.setBinding("#{interrupcion_lab_TableHandler.btn_editar}");
                    __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                    if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,pNivelTag+3);
                  }
                  {
                    oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag __jsp_taghandler_27=(oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag.class,"oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag text action binding");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_24);
                    __jsp_taghandler_27.setText("Eliminar");
                    __jsp_taghandler_27.setId("btn_eliminar");
                    __jsp_taghandler_27.setPartialSubmit("true");
                    __jsp_taghandler_27.setAction("#{interrupcion_lab_TableHandler.eliminar_btn}");
                    __jsp_taghandler_27.setBinding("#{interrupcion_lab_TableHandler.btn_eliminar}");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,pNivelTag+3);
                  }
                  {
                    oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag __jsp_taghandler_28=(oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag.class,"oracle.adfinternal.view.faces.taglib.core.nav.CoreCommandButtonTag text action binding");
                    __jsp_taghandler_28.setParent(__jsp_taghandler_24);
                    __jsp_taghandler_28.setText("Aceptar");
                    __jsp_taghandler_28.setId("btn_aceptar");
                    __jsp_taghandler_28.setPartialSubmit("true");
                    __jsp_taghandler_28.setAction("#{interrupcion_lab_TableHandler.aceptar_btn}");
                    __jsp_taghandler_28.setBinding("#{interrupcion_lab_TableHandler.btn_aceptar}");
                    __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                    if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,pNivelTag+3);
                  }
                }
                if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,pNivelTag+2);
              }
            } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          }
          if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,pNivelTag+1);
        }
        {
          javax.faces.webapp.FacetTag __jsp_taghandler_29=(javax.faces.webapp.FacetTag)OracleJspRuntime.getTagHandler(pageContext,javax.faces.webapp.FacetTag.class,"javax.faces.webapp.FacetTag name");
          __jsp_taghandler_29.setParent(__jsp_taghandler_7);
          __jsp_taghandler_29.setName("header");
          __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
          {
            do {
              {
                oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag __jsp_taghandler_30=(oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreOutputTextTag value");
                __jsp_taghandler_30.setParent(__jsp_taghandler_29);
                __jsp_taghandler_30.setValue("Interrupciones Laborales");
                __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,pNivelTag+2);
              }
            } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          }
          if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,pNivelTag+1);
        }
      }
      if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,pNivelTag);
    }
    {
      oracle.adfinternal.view.faces.taglib.core.output.CoreMessageTag __jsp_taghandler_31=(oracle.adfinternal.view.faces.taglib.core.output.CoreMessageTag)OracleJspRuntime.getTagHandler(pageContext,oracle.adfinternal.view.faces.taglib.core.output.CoreMessageTag.class,"oracle.adfinternal.view.faces.taglib.core.output.CoreMessageTag messageType partialTriggers for");
      __jsp_taghandler_31.setParent(pParentTag);
      __jsp_taghandler_31.setMessageType("error");
      __jsp_taghandler_31.setPartialTriggers("tbl_interrupt:btn_agregar tbl_interrupt:btn_editar tbl_interrupt:btn_eliminar tbl_interrupt:btn_aceptar");
      __jsp_taghandler_31.setFor("tbl_interrupt");
      __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
      if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,pNivelTag);
    }

   
}

    
}
