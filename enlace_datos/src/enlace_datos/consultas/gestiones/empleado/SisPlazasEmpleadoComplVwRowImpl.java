package enlace_datos.consultas.gestiones.empleado;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisPlazasEmpleadoComplVwRowImpl extends ViewRowImpl {
    public static final int CORRELATIVO = 0;
    public static final int IDCONTRATO = 1;
    public static final int PARTIDA = 2;
    public static final int IDPUESTO = 3;
    public static final int NUMEROPLAZA = 4;
    public static final int NOMPUESTO = 5;
    public static final int NOMDEPENDENCIA = 6;
    public static final int HORASCONTRATADAS = 7;
    public static final int FECHAINICIO = 8;
    public static final int FECHAFIN = 9;
    public static final int REGISTROEMPLEADO = 10;
    public static final int ESTADO = 11;
    public static final int IDPARTIDA = 12;
    public static final int SELECCIONADO = 13;

    /**This is the default constructor (do not remove)
     */
    public SisPlazasEmpleadoComplVwRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute IdContrato
     */
    public Number getIdContrato() {
        return (Number) getAttributeInternal(IDCONTRATO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdContrato
     */
    public void setIdContrato(Number value) {
        setAttributeInternal(IDCONTRATO, value);
    }

    /**Gets the attribute value for the calculated attribute Partida
     */
    public String getPartida() {
        return (String) getAttributeInternal(PARTIDA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Partida
     */
    public void setPartida(String value) {
        setAttributeInternal(PARTIDA, value);
    }

    /**Gets the attribute value for the calculated attribute IdPuesto
     */
    public Number getIdPuesto() {
        return (Number) getAttributeInternal(IDPUESTO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdPuesto
     */
    public void setIdPuesto(Number value) {
        setAttributeInternal(IDPUESTO, value);
    }

    /**Gets the attribute value for the calculated attribute NumeroPlaza
     */
    public Number getNumeroPlaza() {
        return (Number) getAttributeInternal(NUMEROPLAZA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute NumeroPlaza
     */
    public void setNumeroPlaza(Number value) {
        setAttributeInternal(NUMEROPLAZA, value);
    }

    /**Gets the attribute value for the calculated attribute NomPuesto
     */
    public String getNomPuesto() {
        return (String) getAttributeInternal(NOMPUESTO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute NomPuesto
     */
    public void setNomPuesto(String value) {
        setAttributeInternal(NOMPUESTO, value);
    }

    /**Gets the attribute value for the calculated attribute Nomdependencia
     */
    public String getNomdependencia() {
        return (String) getAttributeInternal(NOMDEPENDENCIA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Nomdependencia
     */
    public void setNomdependencia(String value) {
        setAttributeInternal(NOMDEPENDENCIA, value);
    }

    /**Gets the attribute value for the calculated attribute Horascontratadas
     */
    public Number getHorascontratadas() {
        return (Number) getAttributeInternal(HORASCONTRATADAS);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Horascontratadas
     */
    public void setHorascontratadas(Number value) {
        setAttributeInternal(HORASCONTRATADAS, value);
    }

    /**Gets the attribute value for the calculated attribute FechaInicio
     */
    public Date getFechaInicio() {
        return (Date) getAttributeInternal(FECHAINICIO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute FechaInicio
     */
    public void setFechaInicio(Date value) {
        setAttributeInternal(FECHAINICIO, value);
    }

    /**Gets the attribute value for the calculated attribute FechaFin
     */
    public Date getFechaFin() {
        return (Date) getAttributeInternal(FECHAFIN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute FechaFin
     */
    public void setFechaFin(Date value) {
        setAttributeInternal(FECHAFIN, value);
    }

    /**Gets the attribute value for the calculated attribute RegistroEmpleado
     */
    public Number getRegistroEmpleado() {
        return (Number) getAttributeInternal(REGISTROEMPLEADO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute RegistroEmpleado
     */
    public void setRegistroEmpleado(Number value) {
        setAttributeInternal(REGISTROEMPLEADO, value);
    }

    /**Gets the attribute value for the calculated attribute Estado
     */
    public String getEstado() {
        return (String) getAttributeInternal(ESTADO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Estado
     */
    public void setEstado(String value) {
        setAttributeInternal(ESTADO, value);
    }

    /**Gets the attribute value for the calculated attribute IdPartida
     */
    public Number getIdPartida() {
        return (Number) getAttributeInternal(IDPARTIDA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdPartida
     */
    public void setIdPartida(Number value) {
        setAttributeInternal(IDPARTIDA, value);
    }

    /**Gets the attribute value for the calculated attribute Seleccionado
     */
    public Boolean getSeleccionado() {
        return (Boolean) getAttributeInternal(SELECCIONADO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Seleccionado
     */
    public void setSeleccionado(Boolean value) {
        setAttributeInternal(SELECCIONADO, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CORRELATIVO:
            return getCorrelativo();
        case IDCONTRATO:
            return getIdContrato();
        case PARTIDA:
            return getPartida();
        case IDPUESTO:
            return getIdPuesto();
        case NUMEROPLAZA:
            return getNumeroPlaza();
        case NOMPUESTO:
            return getNomPuesto();
        case NOMDEPENDENCIA:
            return getNomdependencia();
        case HORASCONTRATADAS:
            return getHorascontratadas();
        case FECHAINICIO:
            return getFechaInicio();
        case FECHAFIN:
            return getFechaFin();
        case REGISTROEMPLEADO:
            return getRegistroEmpleado();
        case ESTADO:
            return getEstado();
        case IDPARTIDA:
            return getIdPartida();
        case SELECCIONADO:
            return getSeleccionado();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CORRELATIVO:
            setCorrelativo((Number)value);
            return;
        case IDCONTRATO:
            setIdContrato((Number)value);
            return;
        case PARTIDA:
            setPartida((String)value);
            return;
        case IDPUESTO:
            setIdPuesto((Number)value);
            return;
        case NUMEROPLAZA:
            setNumeroPlaza((Number)value);
            return;
        case NOMPUESTO:
            setNomPuesto((String)value);
            return;
        case NOMDEPENDENCIA:
            setNomdependencia((String)value);
            return;
        case HORASCONTRATADAS:
            setHorascontratadas((Number)value);
            return;
        case FECHAINICIO:
            setFechaInicio((Date)value);
            return;
        case FECHAFIN:
            setFechaFin((Date)value);
            return;
        case REGISTROEMPLEADO:
            setRegistroEmpleado((Number)value);
            return;
        case ESTADO:
            setEstado((String)value);
            return;
        case IDPARTIDA:
            setIdPartida((Number)value);
            return;
        case SELECCIONADO:
            setSeleccionado((Boolean)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute Correlativo
     */
    public Number getCorrelativo() {
        return (Number) getAttributeInternal(CORRELATIVO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Correlativo
     */
    public void setCorrelativo(Number value) {
        setAttributeInternal(CORRELATIVO, value);
    }
}
