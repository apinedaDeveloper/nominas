package interfaz_usuario.backing.gestiones;

import interfaz_usuario.usuario;

import interfaz_usuario.util.ADFUtils;

import interfaz_usuario.util.JSFUtils;

import javax.faces.context.FacesContext;

import oracle.adf.view.faces.component.core.nav.CoreCommandButton;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class solicitud {
    private BindingContainer bindings;
    private CoreCommandButton btn_guardarCondi_judicial;

    public solicitud() {
    }

    public BindingContainer getBindings() {
        return this.bindings;
    }

    public void setBindings(BindingContainer bindings) {
        this.bindings = bindings;
    }


    public String IrAPagina(String Varsolicitud){
    
        if (Varsolicitud.equals("LICENCIA")) {
          // System.out.println("toy en las licencias");
            usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
            return "ver_sol_licencia";
        }
        else if (Varsolicitud.equals("DESCUENTO JUDICIAL")){
         //   System.out.println("toy en los descuentos judiciales");
            usuario.set_opciones(usuario.VISTA_ORDEN_JUDICIAL,1);
            return "empleado_orden_judicial";
        }else if (Varsolicitud.equals("SUSPENSION IGSS")){
            usuario.set_opciones(usuario.VISTA_SUSP_IGSS,1);
            return "verSuspIgss";
        }else if (Varsolicitud.equals("BAJA SUPENCION LABORAL")){
            usuario.set_opciones(usuario.VISTA_SUSP_LAB,1);
            return "op_baja_susp_lab";
        }else if (Varsolicitud.equals("ALTA SUSPENSION IGSS")){
            usuario.set_opciones(usuario.VISTA_SUSP_IGSS,1);
            return "op_alta_susp_igss";
        }else if (Varsolicitud.equals("RENUNCIA")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Renuncias");
            usuario.set_opciones(usuario.VISTA_RENUNCIA_PARCIAL,1);
            return "new_desp_renun_empl";
        }else if (Varsolicitud.equals("RENUNCIA PARCIAL")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,"RENUNCIA PARCIAL");
            usuario.set_opciones(usuario.VISTA_RENUNCIA_PARCIAL,1);
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Renuncias");
            return "new_desp_renun_empl";
        }
        else if (Varsolicitud.equals("DESPIDO")){
             usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
             usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Despidos");
                  // usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
            return "new_desp_renun_empl";
        }
        else if (Varsolicitud.equals("DECISION DE AUTORIDADES")){
            usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
            usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Decisión de Autoridades");
                 // usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
            return "new_desp_renun_empl";
        }
        else if (Varsolicitud.equals("DEUDORES")){
             usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
             usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
             //usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Despidos");
                  // usuario.set_opciones(usuario.CURRENT_ITEM_MENU,vMenuItem.getText());
             return "op_deudores";
         }
          else if (Varsolicitud.equals("PROMOCION Y RECLASIFICACION"))
          {
            usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
            usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
             return "gestEmpl_promoreclasif";
          }
           else if (Varsolicitud.equals("RETIRO OBLIGATORIO"))
          {
              usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
              usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
              usuario.set_opciones(usuario.VISTA_RETIRO,1);
               return "gest_RetiroOblig";
           }
            else if (Varsolicitud.equals("RESCISION DE CONTRATOS"))
            {
               usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
               usuario.set_opciones(usuario.CURRENT_ITEM_MENU,"Rescision de contratos");
               usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
               usuario.set_opciones(usuario.VISTA_RESCISION,1);
                return "gest_NewRescPlaza";
            }
            else if (Varsolicitud.equals("FALLECIMIENTO"))
            {
               usuario.set_opciones(usuario.CURRENTSOLICITUD,Varsolicitud);
               usuario.set_opciones(usuario.VISTA_SOLICITUD,1);
               usuario.set_opciones(usuario.VISTA_FALLECIMIENTO,1);
                return "verFallecimiento";
            }           
         else 
                 
       return null;
    }

    public String comnd_link_IdSolicitud() {

        Object nomSolicitud;
        nomSolicitud = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.NombreSolicitud}");

        //System.out.println(nomSolicitud);
       // nomSolicitud = JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{row.rowKeyStr}");

       // System.out.println(nomSolicitud);
        
        return IrAPagina(nomSolicitud.toString().trim());
    }

    public void setBtn_guardarCondi_judicial(CoreCommandButton btn_guardarCondi_judicial) {
        this.btn_guardarCondi_judicial = btn_guardarCondi_judicial;
    }

    public CoreCommandButton getBtn_guardarCondi_judicial() {
        return btn_guardarCondi_judicial;
    }

    public String btn_create_condiconOrdenJudicial_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = 
            bindings.getOperationBinding("Crear");
        Object result = operationBinding.execute();
        btn_guardarCondi_judicial.setDisabled(false);
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
}
