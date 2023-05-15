package interfaz_usuario.backing.gestiones;

import enlace_datos.util.resulOp;

import interfaz_usuario.util.JSFUtils;
import interfaz_usuario.util.utils;

import javax.faces.component.html.HtmlForm;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.output.CoreOutputText;

public class Sicoin_crearPartida {
    private HtmlForm form1;
    private CoreOutputText output_formatoPartida;
    private CoreInputText input_unidad_ejecutora;
    private CoreInputText input_unidad_desconcentrada;
    private CoreInputText input_programa;
    private CoreInputText input_subPrograma;
    private CoreInputText input_proyecto;
    private CoreInputText input_actividad;
    private CoreInputText input_obra;
    private CoreInputText input_renglon;
    private CoreInputText input_geografico;
    private CoreInputText input_fuente;
    private CoreInputText input_organismo;
    private CoreInputText input_correlativo;
    private CoreInputText input_nombrePartida;

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public String crearPartida() {
        this.output_formatoPartida.setValue("");
        String result = JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getExistePartida").toString();
        String respuesta_accion = result.substring(0,1);
        String mensaje[] = result.substring(2,result.length()).split("\n");
        if (respuesta_accion.equals("2"))  {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Confirmar"))  {
                clean();
                String formato_partida = "<p style=\"font-size:21px; color:blue\">PARTIDA CREADA:<br/>[" +JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),"getPartidaFormato").toString()+ "]</p>";
                this.output_formatoPartida.setValue(formato_partida);
                for (int i=0 ;i<=mensaje.length-1 ;i++ )  {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_OK,mensaje[i]));
                }
                return "sicoin_creacion";
            }
            
        } else if(respuesta_accion.equals("1")) {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))  {
                for (int i=0 ;i<=mensaje.length-1 ;i++ )  {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,mensaje[i]));
                }
            }
        } else {
            if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))  {
                for (int i=0 ;i<=mensaje.length-1 ;i++ )  {
                    utils.setADFMensaje(new resulOp(resulOp.OPE_ERROR,mensaje[i]));
                }
            }
            
        }
        return null;
    }
    
    private void clean(){
         this.input_unidad_ejecutora.setValue("");
         this.input_unidad_desconcentrada.setValue("");
         this.input_programa.setValue("");
         this.input_subPrograma.setValue("");
         this.input_proyecto.setValue("");
         this.input_actividad.setValue("");
         this.input_obra.setValue("");
         this.input_renglon.setValue("");
         this.input_geografico.setValue("");
         this.input_fuente.setValue("");
         this.input_organismo.setValue("");
         this.input_correlativo.setValue("");
         this.input_nombrePartida.setValue("");
    }
    
    public String action_limpiar_pagina() {
        if (JSFUtils.EjecutarAcccion2(FacesContext.getCurrentInstance(),"Rollback"))  {
            clean();
            this.output_formatoPartida.setValue("");            
        }
        return null;
    }
    
    public void setOutput_formatoPartida(CoreOutputText output_formatoPartida) {
        this.output_formatoPartida = output_formatoPartida;
    }

    public CoreOutputText getOutput_formatoPartida() {
        return output_formatoPartida;
    }

    public void setInput_unidad_ejecutora(CoreInputText input_unidad_ejecutora) {
        this.input_unidad_ejecutora = input_unidad_ejecutora;
    }

    public CoreInputText getInput_unidad_ejecutora() {
        return input_unidad_ejecutora;
    }

    public void setInput_unidad_desconcentrada(CoreInputText input_unidad_desconcentrada) {
        this.input_unidad_desconcentrada = input_unidad_desconcentrada;
    }

    public CoreInputText getInput_unidad_desconcentrada() {
        return input_unidad_desconcentrada;
    }

    public void setInput_programa(CoreInputText input_programa) {
        this.input_programa = input_programa;
    }

    public CoreInputText getInput_programa() {
        return input_programa;
    }

    public void setInput_subPrograma(CoreInputText input_subPrograma) {
        this.input_subPrograma = input_subPrograma;
    }

    public CoreInputText getInput_subPrograma() {
        return input_subPrograma;
    }

    public void setInput_proyecto(CoreInputText input_proyecto) {
        this.input_proyecto = input_proyecto;
    }

    public CoreInputText getInput_proyecto() {
        return input_proyecto;
    }

    public void setInput_actividad(CoreInputText input_actividad) {
        this.input_actividad = input_actividad;
    }

    public CoreInputText getInput_actividad() {
        return input_actividad;
    }

    public void setInput_obra(CoreInputText input_obra) {
        this.input_obra = input_obra;
    }

    public CoreInputText getInput_obra() {
        return input_obra;
    }

    public void setInput_renglon(CoreInputText input_renglon) {
        this.input_renglon = input_renglon;
    }

    public CoreInputText getInput_renglon() {
        return input_renglon;
    }

    public void setInput_geografico(CoreInputText input_geografico) {
        this.input_geografico = input_geografico;
    }

    public CoreInputText getInput_geografico() {
        return input_geografico;
    }

    public void setInput_fuente(CoreInputText input_fuente) {
        this.input_fuente = input_fuente;
    }

    public CoreInputText getInput_fuente() {
        return input_fuente;
    }

    public void setInput_organismo(CoreInputText input_organismo) {
        this.input_organismo = input_organismo;
    }

    public CoreInputText getInput_organismo() {
        return input_organismo;
    }

    public void setInput_correlativo(CoreInputText input_correlativo) {
        this.input_correlativo = input_correlativo;
    }

    public CoreInputText getInput_correlativo() {
        return input_correlativo;
    }

    public void setInput_nombrePartida(CoreInputText input_nombrePartida) {
        this.input_nombrePartida = input_nombrePartida;
    }

    public CoreInputText getInput_nombrePartida() {
        return input_nombrePartida;
    }
}
