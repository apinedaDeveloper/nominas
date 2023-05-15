package interfaz_usuario.backing.gestiones;
import javax.faces.event.ValueChangeEvent;

public class sel_plazas {
    boolean vCombo_dependencia=false;
    boolean vCombo_unidad=false;
    public sel_plazas() {
    }

    public boolean getComboDependencia(){
        return this.vCombo_dependencia;
    }

    public boolean getComboUnidad(){
        return this.vCombo_unidad;
    }
    public void cmb_unidades(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
         vCombo_unidad=true;
         vCombo_dependencia=false;
       // System.out.println("unidad");
        
    }

    public void cmb_dependencias(ValueChangeEvent valueChangeEvent) {
        vCombo_dependencia=true;
        vCombo_unidad=false;
       // System.out.println("dependencia");
}

}