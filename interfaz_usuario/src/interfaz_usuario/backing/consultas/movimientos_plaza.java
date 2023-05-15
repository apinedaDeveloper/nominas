package interfaz_usuario.backing.consultas;

import javax.faces.event.ValueChangeEvent;

public class movimientos_plaza {
    boolean vCombo_dependencia=false;
    boolean vCombo_unidad=false;
    boolean vCombo_plaza=false;
    public movimientos_plaza() {
    }
    public boolean getComboDependencia(){
        return this.vCombo_dependencia;
    }

    public boolean getComboUnidad(){
        return this.vCombo_unidad;
    }
    
    public boolean getComboPlaza(){
        return this.vCombo_plaza;
    }
    public void cmb_unidades(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
         vCombo_unidad=true;
         }
         vCombo_dependencia=false;
         vCombo_plaza = false;
       // System.out.println("unidad");
        
    }

    public void cmb_dependencias(ValueChangeEvent valueChangeEvent) {
        vCombo_dependencia=true;
        vCombo_unidad=false;
        vCombo_plaza=false;
       // System.out.println("dependencia");
    }
    
    public void cmb_plazas(ValueChangeEvent valueChangeEvent) {
    
      if (valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            vCombo_plaza=true;
      }     
            vCombo_dependencia=false;
            vCombo_unidad=false;
           // System.out.println("dependencia");
        }
}


