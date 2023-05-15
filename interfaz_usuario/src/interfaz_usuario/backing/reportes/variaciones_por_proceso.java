package interfaz_usuario.backing.reportes;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

public class variaciones_por_proceso {
    public variaciones_por_proceso() {
    }

    public String btn_buscar() {
        // Add event code here...
        Object pBinding, pEstado;
        String vConsultas, vParamEstados;
        boolean vEspecifico = false;

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarContr1.inputValue}");

        vConsultas = "";

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = "CONTRATOS";
            vEspecifico = true;
        }

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarLic1.inputValue}");

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = vConsultas + "|LICENCIAS";
            vEspecifico = true;
        }

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarSuspIgss1.inputValue}");

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = vConsultas + "|SUSPIGSS";
            vEspecifico = true;
        }

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarDescJud1.inputValue}");

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = vConsultas + "|DESC_JUDICIAL";
            vEspecifico = true;
        }

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarRenunDesp1.inputValue}");

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = vConsultas + "|RENUNCIADESP";
            vEspecifico = true;
        }

        pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.mostrarHoraExtra1.inputValue}");

        if (pBinding != null && pBinding.equals(true)) {
            vConsultas = vConsultas + "|HORA_EXTRA";
            vEspecifico = true;
        }


        if (JSFUtils.resolveExpression(FacesContext.getCurrentInstance(), "#{bindings.mostrarReclaf1.inputValue}").equals(true) &&JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                "#{bindings.mostrarPromDoc1.inputValue}").equals(true)) {

            vConsultas = vConsultas + "|PROMRECLASIF";
            vEspecifico = true;
        } else {

            pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                        "#{bindings.mostrarReclaf1.inputValue}");

            if (pBinding != null && pBinding.equals(true)) {
                vConsultas = vConsultas + "|RECLASIF";
                vEspecifico = true;
            }

            pBinding = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                        "#{bindings.mostrarPromDoc1.inputValue}");

            if (pBinding != null && pBinding.equals(true)) {
                vConsultas = vConsultas + "|PROMDOC";
                vEspecifico = true;
            }


        }


        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vEstadoContrato1.inputValue}");

        vParamEstados = "";

        if (pEstado != null) {

            vParamEstados = "C|" + pEstado;
        }

        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vEstadoLic1.inputValue}");

        if (pEstado != null) {

            vParamEstados = vParamEstados + "|L|" + pEstado;
        }

        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vSuspIgss1.inputValue}");

        if (pEstado != null) {

            vParamEstados = vParamEstados + "|G|" + pEstado;
        }

        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vDescJud1.inputValue}");

        if (pEstado != null) {

            vParamEstados = vParamEstados + "|J|" + pEstado;
        }

        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vRenun1.inputValue}");

        if (pEstado != null) {

            vParamEstados = vParamEstados + "|R|" + pEstado;
        }


        pEstado = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),
                    "#{bindings.vHoraE1.inputValue}");

        if (pEstado != null) {

            vParamEstados = vParamEstados + "|H|" + pEstado;
        }


        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),
                "#{bindings.pConsulta.inputValue}", vConsultas);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),
                "#{bindings.mostrarTodo1.inputValue}", !vEspecifico);
        JSFUtils.setExpressionValue(FacesContext.getCurrentInstance(),
                "#{bindings.vEstados1.inputValue}", vParamEstados);


        JSFUtils.EjecutarAcccion(FacesContext.getCurrentInstance(),
                "EjecutarConsulGestiones");

        return null;
    }
}
