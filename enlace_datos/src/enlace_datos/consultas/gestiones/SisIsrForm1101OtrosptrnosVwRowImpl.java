package enlace_datos.consultas.gestiones;

import enlace_datos.entidades.gestiones.SisIsrForm1101OtrosptrnosImpl;

import java.math.BigDecimal;

import oracle.jbo.Row;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisIsrForm1101OtrosptrnosVwRowImpl extends ViewRowImpl {
    public static final int REGISTROEMPLEADO = 0;
    public static final int ANIO = 1;
    public static final int NIT = 2;
    public static final int NOMBREPATRONO = 3;
    public static final int RENTANETA = 4;
    public static final int FECHACREACION = 5;
    public static final int FECHAMODIFICACION = 6;
    public static final int SELECCIONADO = 7;
    public static final int TOTALRENTA = 8;
    public static final int SISISRFORM1101VW = 9;
    private boolean vSeleccionado=false;

    /**This is the default constructor (do not remove)
     */
    public SisIsrForm1101OtrosptrnosVwRowImpl() {
    }

    /**Gets SisIsrForm1101Otrosptrnos entity object.
     */
    public SisIsrForm1101OtrosptrnosImpl getSisIsrForm1101Otrosptrnos() {
        return (SisIsrForm1101OtrosptrnosImpl)getEntity(0);
    }

    /**Gets the attribute value for REGISTRO_EMPLEADO using the alias name RegistroEmpleado
     */
    public Number getRegistroEmpleado() {
        return (Number) getAttributeInternal(REGISTROEMPLEADO);
    }

    /**Sets <code>value</code> as attribute value for REGISTRO_EMPLEADO using the alias name RegistroEmpleado
     */
    public void setRegistroEmpleado(Number value) {
        setAttributeInternal(REGISTROEMPLEADO, value);
    }

    /**Gets the attribute value for ANIO using the alias name Anio
     */
    public Number getAnio() {
        return (Number) getAttributeInternal(ANIO);
    }

    /**Sets <code>value</code> as attribute value for ANIO using the alias name Anio
     */
    public void setAnio(Number value) {
        setAttributeInternal(ANIO, value);
    }

    /**Gets the attribute value for NIT using the alias name Nit
     */
    public String getNit() {
        return (String) getAttributeInternal(NIT);
    }

    /**Sets <code>value</code> as attribute value for NIT using the alias name Nit
     */
    public void setNit(String value) {
        setAttributeInternal(NIT, value);
    }

    /**Gets the attribute value for NOMBRE_PATRONO using the alias name NombrePatrono
     */
    public String getNombrePatrono() {
        return (String) getAttributeInternal(NOMBREPATRONO);
    }

    /**Sets <code>value</code> as attribute value for NOMBRE_PATRONO using the alias name NombrePatrono
     */
    public void setNombrePatrono(String value) {
        setAttributeInternal(NOMBREPATRONO, value);
    }

    /**Gets the attribute value for RENTA_NETA using the alias name RentaNeta
     */
    public Number getRentaNeta() {
        return (Number) getAttributeInternal(RENTANETA);
    }

    /**Sets <code>value</code> as attribute value for RENTA_NETA using the alias name RentaNeta
     */
    public void setRentaNeta(Number value) {
        setAttributeInternal(RENTANETA, value);
    }

    /**Gets the attribute value for FECHA_CREACION using the alias name FechaCreacion
     */
    public Date getFechaCreacion() {
        return (Date) getAttributeInternal(FECHACREACION);
    }

    /**Sets <code>value</code> as attribute value for FECHA_CREACION using the alias name FechaCreacion
     */
    public void setFechaCreacion(Date value) {
        setAttributeInternal(FECHACREACION, value);
    }

    /**Gets the attribute value for FECHA_MODIFICACION using the alias name FechaModificacion
     */
    public Date getFechaModificacion() {
        return (Date) getAttributeInternal(FECHAMODIFICACION);
    }

    /**Sets <code>value</code> as attribute value for FECHA_MODIFICACION using the alias name FechaModificacion
     */
    public void setFechaModificacion(Date value) {
        setAttributeInternal(FECHAMODIFICACION, value);
    }

    /**Gets the attribute value for the calculated attribute Seleccionado
     */
    public Boolean getSeleccionado() {
        return vSeleccionado;
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Seleccionado
     */
    public void setSeleccionado(Boolean value) {
    
        vSeleccionado=value;
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case REGISTROEMPLEADO:
            return getRegistroEmpleado();
        case ANIO:
            return getAnio();
        case NIT:
            return getNit();
        case NOMBREPATRONO:
            return getNombrePatrono();
        case RENTANETA:
            return getRentaNeta();
        case FECHACREACION:
            return getFechaCreacion();
        case FECHAMODIFICACION:
            return getFechaModificacion();
        case SELECCIONADO:
            return getSeleccionado();
        case TOTALRENTA:
            return getTotalRenta();
        case SISISRFORM1101VW:
            return getSisIsrForm1101Vw();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case REGISTROEMPLEADO:
            setRegistroEmpleado((Number)value);
            return;
        case ANIO:
            setAnio((Number)value);
            return;
        case NIT:
            setNit((String)value);
            return;
        case NOMBREPATRONO:
            setNombrePatrono((String)value);
            return;
        case RENTANETA:
            setRentaNeta((Number)value);
            return;
        case FECHACREACION:
            setFechaCreacion((Date)value);
            return;
        case FECHAMODIFICACION:
            setFechaModificacion((Date)value);
            return;
        case SELECCIONADO:
            setSeleccionado((Boolean)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute TotalRenta
     */
    public Number getTotalRenta() {
        SisIsrForm1101OtrosptrnosVwImpl vDatos;
        Number vTotalRentaEntidad,vTotalRentaNeta;
        vDatos=(SisIsrForm1101OtrosptrnosVwImpl)this.getViewObject();
        vTotalRentaEntidad=(Number) this.getSisIsrForm1101Otrosptrnos().getSisIsrForm1101().getAttribute("RentaNetaOtros");
        
       // this.getSisIsrForm1101Otrosptrnos().getSisIsrForm1101().getAttributeNames()
        vTotalRentaNeta=vDatos.getTotalRenta();
        
        if (vTotalRentaNeta.compareTo(vTotalRentaEntidad)!=0){
            this.getSisIsrForm1101Otrosptrnos().getSisIsrForm1101().setAttribute("RentaNetaOtros",vTotalRentaNeta);            
        }
        
        return vTotalRentaNeta;
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute TotalRenta
     */
    public void setTotalRenta(Number value) {
        setAttributeInternal(TOTALRENTA, value);
    }

    /**Gets the associated <code>Row</code> using master-detail link SisIsrForm1101Vw
     */
    public Row getSisIsrForm1101Vw() {
        return (Row)getAttributeInternal(SISISRFORM1101VW);
    }
}
