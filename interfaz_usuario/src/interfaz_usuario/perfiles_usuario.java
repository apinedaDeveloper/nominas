package interfaz_usuario;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class perfiles_usuario {
    private static String vPerfiles[] = 
    { "analista_recursos_hum", "banco", "oficinista_caja", 
      "clasificacion_puestos", "profesional_contabilidad", "coordinador_isr", 
      "coordinador_descuento_judicial", "coordinador_sueldos", 
      "profesional_presupuesto", "sis_administrador", "tesorero", "vigilancia", 
      "director_general_financiero", "operador_informatica", "auditor", 
      "trabajador_usac", "operador_recursos_hum", "auxiliar_tesoreria", 
      "asistente_recursos_hum", "asistente_recursos_hum_029", 
      "asist_recursos_hum_regper", "asist_recursos_hum_actregper", 
      "jefe_unidad", "jefe_subprograma", "conciliacion_bancaria_conta", 
      "encargado_anulacion_pago", "profesional_caja", "auxiliar_isr", 
      "operador_caja", "consulta_histsal_lab", "caja_acreditamiento", 
      "consulta_ficha_empl", "auxiliar_sueldos", "plan_prestaciones", 
      "archivo_conta", "reclutamiento", "rentas", "curriculum", 
      "rev_boleto_ornato", "analista_postmortem", "consul_curriculum", "coordinador_puestos", "analista_indemnizacion" };


    public String[] getPerfiles() {
        return vPerfiles;
    }

    private boolean isUsuarioEnRole(String vRol) {
        ExternalContext vExContexto;
        vExContexto = FacesContext.getCurrentInstance().getExternalContext();
        return vExContexto.isUserInRole(vRol);
    }

    public boolean isAnalistaRecursosHum() {
        return isUsuarioEnRole(vPerfiles[0]);
    }

    public boolean isBanco() {
        return isUsuarioEnRole(vPerfiles[1]);
    }

    public boolean isOficinistaCaja() {
        return isUsuarioEnRole(vPerfiles[2]);
    }

    public boolean isClasifPuesto() {
        return isUsuarioEnRole(vPerfiles[3]);
    }

    public boolean isProfContabilidad() {
        return isUsuarioEnRole(vPerfiles[4]);
    }

    public boolean isCoordinadorIsr() {
        return isUsuarioEnRole(vPerfiles[5]);
    }

    public boolean isCoordinadorDescJud() {
        return isUsuarioEnRole(vPerfiles[6]);
    }

    public boolean isCoordinadorSueldos() {
        return isUsuarioEnRole(vPerfiles[7]);
    }

    public boolean isProfesionalPresupuesto() {
        return isUsuarioEnRole(vPerfiles[8]);
    }

    public boolean isAdministrador() {
        return isUsuarioEnRole(vPerfiles[9]);
    }

    public boolean isTesorero() {
        return isUsuarioEnRole(vPerfiles[10]);
    }

    public boolean isVigilancia() {
        return isUsuarioEnRole(vPerfiles[11]);
    }

    public boolean isDirectorGeneralFinanciero() {
        return isUsuarioEnRole(vPerfiles[12]);
    }

    public boolean isOperadorInformatica() {
        return isUsuarioEnRole(vPerfiles[13]);
    }

    public boolean isAuditor() {
        return isUsuarioEnRole(vPerfiles[14]);
    }

    public boolean isTrabajadorUsac() {
        return isUsuarioEnRole(vPerfiles[15]);
    }

    public boolean isOperadorRecursosHum() {
        return isUsuarioEnRole(vPerfiles[16]);
    }

    public boolean isAuxiliarTesoreria() {
        return isUsuarioEnRole(vPerfiles[17]);
    }

    public boolean isAsistenteRecursosHum() {
        return isUsuarioEnRole(vPerfiles[18]);
    }

    public boolean isAsistenteRecursosHum029() {
        return isUsuarioEnRole(vPerfiles[19]);
    }

    public boolean isAsistenteRecursosHumRegPer() {
        return isUsuarioEnRole(vPerfiles[20]);
    }

    public boolean isAsistenteRecursosHumActRegPer() {
        return isUsuarioEnRole(vPerfiles[21]);
    }

    public boolean isJefeUnidad() {
        return isUsuarioEnRole(vPerfiles[22]);
    }

    public boolean isJefeSubprograma() {
        return isUsuarioEnRole(vPerfiles[23]);
    }

    public boolean isConciliacionBancariaConta() {
        return isUsuarioEnRole(vPerfiles[24]);
    }

    public boolean isEncargadoAnulacionPago() {
        return isUsuarioEnRole(vPerfiles[25]);
    }

    public boolean isProfesionalCaja() {
        return isUsuarioEnRole(vPerfiles[26]);
    }

    public boolean isAuxiliarISR() {
        return isUsuarioEnRole(vPerfiles[27]);
    }

    public boolean isOperadorCaja() {
        return isUsuarioEnRole(vPerfiles[28]);
    }

    public boolean isConsultaHistsalLab() {
        return isUsuarioEnRole(vPerfiles[29]);
    }

    public boolean isCajaAcredit() {
        return isUsuarioEnRole(vPerfiles[30]);
    }

    public boolean isConsulFichaEmpl() {
        return isUsuarioEnRole(vPerfiles[31]);
    }

    public boolean isAuxiliarSueldos() {
        return isUsuarioEnRole(vPerfiles[32]);
    }

    public boolean isPlanPrestaciones() {
        return isUsuarioEnRole(vPerfiles[33]);
    }

    public boolean isArchivoConta() {
        return isUsuarioEnRole(vPerfiles[34]);
    }

    public boolean isReclutamiento() {
        return isUsuarioEnRole(vPerfiles[35]);
    }

    public boolean isRentas() {
        return isUsuarioEnRole(vPerfiles[36]);
    }

    public boolean isCurriculum() {
        return isUsuarioEnRole(vPerfiles[37]);
    }

    public boolean isRevBoletoOrnato() {
        return isUsuarioEnRole(vPerfiles[38]);
    }

    public boolean isAnalistaPostmortem() {
        return isUsuarioEnRole(vPerfiles[39]);
    }

    public boolean isConsulCurriculum() {
        return isUsuarioEnRole(vPerfiles[40]);
    }
    
    public boolean isCoordinadorPuesto() {
        return isUsuarioEnRole(vPerfiles[41]);
    }
    
    public boolean isAnalistaIndemnizacion() {
        return isUsuarioEnRole(vPerfiles[42]);
    }

}
