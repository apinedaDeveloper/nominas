package enlace_datos.entidades.gestiones.contrato;

import enlace_datos.util.utils;

import enlace_datos.util.utils_DB;

import java.text.SimpleDateFormat;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisContrato031Impl extends EntityImpl {
    public static final int IDCONTRATO = 0;
    public static final int IDPARTIDA = 1;
    public static final int NUMEROPLAZA = 2;
    public static final int NOMBREPUESTO = 3;
    public static final int CORRELATIVO = 4;
    public static final int NUMCONTRATOFISICO = 5;
    public static final int REGISTROEMPLEADO = 6;
    public static final int SALARIODIARIO = 7;
    public static final int DIASLABORADOS = 8;
    public static final int SALARIOMENSUAL = 9;
    public static final int BONIFICACION = 10;
    public static final int FECHAINICIO = 11;
    public static final int FECHAFIN = 12;
    public static final int HORASCONTRATADAS = 13;
    public static final int CREADOPOR = 14;
    public static final int FECHACREACION = 15;
    public static final int MODIFICADOPOR = 16;
    public static final int FECHAMODIFICACION = 17;
    public static final int IDESTADO = 18;
    public static final int IDDEPENDENCIA = 19;
    public static final int CUI = 20;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public SisContrato031Impl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("enlace_datos.entidades.gestiones.contrato.SisContrato031");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for IdContrato, using the alias name IdContrato
     */
    public Number getIdContrato() {
        return (Number)getAttributeInternal(IDCONTRATO);
    }

    /**Sets <code>value</code> as the attribute value for IdContrato
     */
    public void setIdContrato(Number value) {
        setAttributeInternal(IDCONTRATO, value);
    }

    /**Gets the attribute value for IdPartida, using the alias name IdPartida
     */
    public Number getIdPartida() {
        return (Number)getAttributeInternal(IDPARTIDA);
    }

    /**Sets <code>value</code> as the attribute value for IdPartida
     */
    public void setIdPartida(Number value) {
        setAttributeInternal(IDPARTIDA, value);
    }

    /**Gets the attribute value for NumeroPlaza, using the alias name NumeroPlaza
     */
    public Number getNumeroPlaza() {
        return (Number)getAttributeInternal(NUMEROPLAZA);
    }

    /**Sets <code>value</code> as the attribute value for NumeroPlaza
     */
    public void setNumeroPlaza(Number value) {
        setAttributeInternal(NUMEROPLAZA, value);
    }

    /**Gets the attribute value for NombrePuesto, using the alias name NombrePuesto
     */
    public String getNombrePuesto() {
        return (String)getAttributeInternal(NOMBREPUESTO);
    }

    /**Sets <code>value</code> as the attribute value for NombrePuesto
     */
    public void setNombrePuesto(String value) {
        setAttributeInternal(NOMBREPUESTO, value);
    }

    /**Gets the attribute value for Correlativo, using the alias name Correlativo
     */
    public Number getCorrelativo() {
        return (Number)getAttributeInternal(CORRELATIVO);
    }

    /**Sets <code>value</code> as the attribute value for Correlativo
     */
    public void setCorrelativo(Number value) {
        setAttributeInternal(CORRELATIVO, value);
    }

    /**Gets the attribute value for NumContratoFisico, using the alias name NumContratoFisico
     */
    public String getNumContratoFisico() {
        return (String)getAttributeInternal(NUMCONTRATOFISICO);
    }

    /**Sets <code>value</code> as the attribute value for NumContratoFisico
     */
    public void setNumContratoFisico(String value) {
        setAttributeInternal(NUMCONTRATOFISICO, value);
    }

    /**Gets the attribute value for RegistroEmpleado, using the alias name RegistroEmpleado
     */
    public Number getRegistroEmpleado() {
        return (Number)getAttributeInternal(REGISTROEMPLEADO);
    }

    /**Sets <code>value</code> as the attribute value for RegistroEmpleado
     */
    public void setRegistroEmpleado(Number value) {
        setAttributeInternal(REGISTROEMPLEADO, value);
    }

    /**Gets the attribute value for SalarioDiario, using the alias name SalarioDiario
     */
    public Number getSalarioDiario() {
        return (Number)getAttributeInternal(SALARIODIARIO);
    }

    /**Sets <code>value</code> as the attribute value for SalarioDiario
     */
    public void setSalarioDiario(Number value) {
        setAttributeInternal(SALARIODIARIO, value);
    }

    /**Gets the attribute value for DiasLaborados, using the alias name DiasLaborados
     */
    public Number getDiasLaborados() {
        return (Number)getAttributeInternal(DIASLABORADOS);
    }

    /**Sets <code>value</code> as the attribute value for DiasLaborados
     */
    public void setDiasLaborados(Number value) {
        setAttributeInternal(DIASLABORADOS, value);
    }

    /**Gets the attribute value for SalarioMensual, using the alias name SalarioMensual
     */
    public Number getSalarioMensual() {
        return (Number)getAttributeInternal(SALARIOMENSUAL);
    }

    /**Sets <code>value</code> as the attribute value for SalarioMensual
     */
    public void setSalarioMensual(Number value) {
        setAttributeInternal(SALARIOMENSUAL, value);
    }

    /**Gets the attribute value for Bonificacion, using the alias name Bonificacion
     */
    public Number getBonificacion() {
        return (Number)getAttributeInternal(BONIFICACION);
    }

    /**Sets <code>value</code> as the attribute value for Bonificacion
     */
    public void setBonificacion(Number value) {
        setAttributeInternal(BONIFICACION, value);
    }

    /**Gets the attribute value for FechaInicio, using the alias name FechaInicio
     */
    public Date getFechaInicio() {
        return (Date)getAttributeInternal(FECHAINICIO);
    }

    /**Sets <code>value</code> as the attribute value for FechaInicio
     */
    public void setFechaInicio(Date value) {
        setAttributeInternal(FECHAINICIO, value);
    }

    /**Gets the attribute value for FechaFin, using the alias name FechaFin
     */
    public Date getFechaFin() {
        return (Date)getAttributeInternal(FECHAFIN);
    }

    /**Sets <code>value</code> as the attribute value for FechaFin
     */
    public void setFechaFin(Date value) {
        setAttributeInternal(FECHAFIN, value);
    }

    /**Gets the attribute value for HorasContratadas, using the alias name HorasContratadas
     */
    public Number getHorasContratadas() {
        return (Number)getAttributeInternal(HORASCONTRATADAS);
    }

    /**Sets <code>value</code> as the attribute value for HorasContratadas
     */
    public void setHorasContratadas(Number value) {
        setAttributeInternal(HORASCONTRATADAS, value);
    }


    /**Gets the attribute value for FechaCreacion, using the alias name FechaCreacion
     */
    public Date getFechaCreacion() {
        return (Date)getAttributeInternal(FECHACREACION);
    }

    /**Sets <code>value</code> as the attribute value for FechaCreacion
     */
    public void setFechaCreacion(Date value) {
        setAttributeInternal(FECHACREACION, value);
    }


    /**Gets the attribute value for FechaModificacion, using the alias name FechaModificacion
     */
    public Date getFechaModificacion() {
        return (Date)getAttributeInternal(FECHAMODIFICACION);
    }

    /**Sets <code>value</code> as the attribute value for FechaModificacion
     */
    public void setFechaModificacion(Date value) {
        setAttributeInternal(FECHAMODIFICACION, value);
    }

    /**Gets the attribute value for IdEstado, using the alias name IdEstado
     */
    public Number getIdEstado() {
        return (Number)getAttributeInternal(IDESTADO);
    }

    /**Sets <code>value</code> as the attribute value for IdEstado
     */
    public void setIdEstado(Number value) {
        setAttributeInternal(IDESTADO, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDCONTRATO:
            return getIdContrato();
        case IDPARTIDA:
            return getIdPartida();
        case NUMEROPLAZA:
            return getNumeroPlaza();
        case NOMBREPUESTO:
            return getNombrePuesto();
        case CORRELATIVO:
            return getCorrelativo();
        case NUMCONTRATOFISICO:
            return getNumContratoFisico();
        case REGISTROEMPLEADO:
            return getRegistroEmpleado();
        case SALARIODIARIO:
            return getSalarioDiario();
        case DIASLABORADOS:
            return getDiasLaborados();
        case SALARIOMENSUAL:
            return getSalarioMensual();
        case BONIFICACION:
            return getBonificacion();
        case FECHAINICIO:
            return getFechaInicio();
        case FECHAFIN:
            return getFechaFin();
        case HORASCONTRATADAS:
            return getHorasContratadas();
        case CREADOPOR:
            return getCreadoPor();
        case FECHACREACION:
            return getFechaCreacion();
        case MODIFICADOPOR:
            return getModificadoPor();
        case FECHAMODIFICACION:
            return getFechaModificacion();
        case IDESTADO:
            return getIdEstado();
        case IDDEPENDENCIA:
            return getIdDependencia();
        case CUI:
            return getCui();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDCONTRATO:
            setIdContrato((Number)value);
            return;
        case IDPARTIDA:
            setIdPartida((Number)value);
            return;
        case NUMEROPLAZA:
            setNumeroPlaza((Number)value);
            return;
        case NOMBREPUESTO:
            setNombrePuesto((String)value);
            return;
        case CORRELATIVO:
            setCorrelativo((Number)value);
            return;
        case NUMCONTRATOFISICO:
            setNumContratoFisico((String)value);
            return;
        case REGISTROEMPLEADO:
            setRegistroEmpleado((Number)value);
            return;
        case SALARIODIARIO:
            setSalarioDiario((Number)value);
            return;
        case DIASLABORADOS:
            setDiasLaborados((Number)value);
            return;
        case SALARIOMENSUAL:
            setSalarioMensual((Number)value);
            return;
        case BONIFICACION:
            setBonificacion((Number)value);
            return;
        case FECHAINICIO:
            setFechaInicio((Date)value);
            return;
        case FECHAFIN:
            setFechaFin((Date)value);
            return;
        case HORASCONTRATADAS:
            setHorasContratadas((Number)value);
            return;
        case CREADOPOR:
            setCreadoPor((String)value);
            return;
        case FECHACREACION:
            setFechaCreacion((Date)value);
            return;
        case MODIFICADOPOR:
            setModificadoPor((String)value);
            return;
        case FECHAMODIFICACION:
            setFechaModificacion((Date)value);
            return;
        case IDESTADO:
            setIdEstado((Number)value);
            return;
        case IDDEPENDENCIA:
            setIdDependencia((Number)value);
            return;
        case CUI:
            setCui((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Add locking logic here.
     */
    public void lock() {
        super.lock();
    }
    
    
    public void ValidarEntidad(){
        String vDia;
        String vMes;
        String vCorrelativo;
        Object vTraslape;

        if (this.getIdDependencia() == null){
            throw new JboException("Por favor seleccione una dependencia");              
        }
        if (this.getIdPartida() == null){
            throw new JboException("Por favor seleccione una partida");              
        }
        if (this.getNumeroPlaza() == null){
            throw new JboException("Por favor ingrese numero de plaza");              
        }
        if (this.getNombrePuesto() == null){
            throw new JboException("Por favor ingrese nombre del puesto");              
        }
        if (this.getSalarioDiario() == null){
            throw new JboException("Por favor ingrese el valor del salario dario");              
        }
        if (this.getHorasContratadas() == null){
            throw new JboException("Por favor ingrese las horas de contrataci�n");              
        }
        if (this.getBonificacion() == null){
            throw new JboException("Por favor el valor de la bonificaci�n");              
        }
        if (this.getFechaInicio() == null){
            throw new JboException("Por favor seleccione fecha inicio del contrato");              
        }
        if (this.getFechaFin() == null){
            throw new JboException("Por favor seleccione fecha fin del contrato");              
        }

        //System.out.println("Fecha completa"+this.getFechaInicio().getValue().toString());
        vDia = this.getFechaInicio().getValue().toString().substring(8,10);
        vMes = this.getFechaInicio().getValue().toString().substring(5,7);
        vCorrelativo = this.getFechaInicio().getValue().toString().substring(0,4);
        //System.out.println("vDia "+vDia);
        //System.out.println("vMes "+vMes);
        //System.out.println("A�o "+vCorrelativo);
        vDia = vDia+"/"+vMes+"/"+vCorrelativo;
        //System.out.println("Fecha "+vDia);

        String vQuery = "select Nvl(count(Id_dependencia),0) Cant\n" + 
        " from sis_contrato031 where id_estado<>230 and id_contrato<>"+this.getIdContrato()
        +" and registro_empleado="+this.getRegistroEmpleado()
        +" and numero_plaza="+this.getNumeroPlaza()
        +" and correlativo="+vCorrelativo
        +" and to_date('"+vDia+ "','dd/MM/yyyy') between fecha_inicio and fecha_fin";
        
        //System.out.println("Query :="+vQuery);
        vTraslape = utils_DB.getEjecutarQuerry(this.getDBTransaction(), vQuery);
        if (vTraslape != null && Integer.parseInt(vTraslape.toString()) > 0 ){
            throw new JboException("Existe traslape con otro contrato partida, plaza y a�o, VERIFIQUE LA INFORMACI�N");
        }
    }    
    /**Custom DML update/insert/delete logic here.
     */
    protected void doDML(int operation, TransactionEvent e) {
        Object pValorConsulta;

        ValidarEntidad();
        if (operation==DML_INSERT){
            this.setCreadoPor(utils.getAuthUser(this.getDBTransaction()));
            pValorConsulta=utils_DB.getIdEstado(e.getDBTransaction(),"INGRESADO","SIS_CONTRATO031");
            this.setIdEstado(utils.getNumberOracle(pValorConsulta));
        }else if (operation==DML_UPDATE){
            this.setModificadoPor(utils.getAuthUser(this.getDBTransaction()));
        }

        try{
            super.doDML(operation, e);
        }catch(Exception exep){
            throw new JboException(utils.getSQLMensaje(exep));
        }
    }

    /**Gets the attribute value for CreadoPor, using the alias name CreadoPor
     */
    public String getCreadoPor() {
        return (String)getAttributeInternal(CREADOPOR);
    }

    /**Sets <code>value</code> as the attribute value for CreadoPor
     */
    public void setCreadoPor(String value) {
        setAttributeInternal(CREADOPOR, value);
    }

    /**Gets the attribute value for ModificadoPor, using the alias name ModificadoPor
     */
    public String getModificadoPor() {
        return (String)getAttributeInternal(MODIFICADOPOR);
    }

    /**Sets <code>value</code> as the attribute value for ModificadoPor
     */
    public void setModificadoPor(String value) {
        setAttributeInternal(MODIFICADOPOR, value);
    }

    /**Gets the attribute value for IdDependencia, using the alias name IdDependencia
     */
    public Number getIdDependencia() {
        return (Number)getAttributeInternal(IDDEPENDENCIA);
    }

    /**Sets <code>value</code> as the attribute value for IdDependencia
     */
    public void setIdDependencia(Number value) {
        setAttributeInternal(IDDEPENDENCIA, value);
    }

    /**Gets the attribute value for Cui, using the alias name Cui
     */
    public String getCui() {
        return (String)getAttributeInternal(CUI);
    }

    /**Sets <code>value</code> as the attribute value for Cui
     */
    public void setCui(String value) {
        setAttributeInternal(CUI, value);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number idContrato) {
        return new Key(new Object[]{idContrato});
    }
}
