package enlace_datos.entidades.gestiones.empleado;

import enlace_datos.util.myEntityImpl;

import java.util.Calendar;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisBeneficiarioImpl extends myEntityImpl {
    public static final int IDBENEFICIARIO = 0;
    public static final int IDSOLICITUD = 1;
    public static final int IDPARENTESCO = 2;
    public static final int NOMBRE = 3;
    public static final int NOCEDULA = 4;
    public static final int CUI = 5;
    public static final int MONTO = 6;
    public static final int PORCENTAJE = 7;
    public static final int RECIBEPAGO = 8;
    public static final int FECHACREACION = 9;
    public static final int CREADOPOR = 10;
    public static final int FECHAMODIF = 11;
    public static final int MODPOR = 12;
    public static final int NOMCOMPLETOCHEQ = 13;
    public static final int NOMBRE1 = 14;
    public static final int NOMBRE2 = 15;
    public static final int NOMBRE3 = 16;
    public static final int APELLIDO1 = 17;
    public static final int APELLIDO2 = 18;
    public static final int CONFIRMADO = 19;
    public static final int IDBANCO = 20;
    public static final int NUMEROCUENTA = 21;
    public static final int ESTADOCUENTA = 22;
    public static final int FECHAOKCUENTA = 23;
    public static final int TIPOPAGO = 24;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public SisBeneficiarioImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = 
                    (EntityDefImpl)EntityDefImpl.findDefObject("enlace_datos.entidades.gestiones.empleado.SisBeneficiario");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for IdBeneficiario, using the alias name IdBeneficiario
     */
    public Number getIdBeneficiario() {
        return (Number)getAttributeInternal(IDBENEFICIARIO);
    }

    /**Sets <code>value</code> as the attribute value for IdBeneficiario
     */
    public void setIdBeneficiario(Number value) {
        setAttributeInternal(IDBENEFICIARIO, value);
    }

    /**Gets the attribute value for IdSolicitud, using the alias name IdSolicitud
     */
    public Number getIdSolicitud() {
        return (Number)getAttributeInternal(IDSOLICITUD);
    }

    /**Sets <code>value</code> as the attribute value for IdSolicitud
     */
    public void setIdSolicitud(Number value) {
        setAttributeInternal(IDSOLICITUD, value);
    }

    /**Gets the attribute value for IdParentesco, using the alias name IdParentesco
     */
    public Number getIdParentesco() {
        return (Number)getAttributeInternal(IDPARENTESCO);
    }

    /**Sets <code>value</code> as the attribute value for IdParentesco
     */
    public void setIdParentesco(Number value) {
        setAttributeInternal(IDPARENTESCO, value);
    }

    /**Gets the attribute value for Nombre, using the alias name Nombre
     */
    public String getNombre() {
        return (String)getAttributeInternal(NOMBRE);
    }

    /**Sets <code>value</code> as the attribute value for Nombre
     */
    public void setNombre(String value) {
        setAttributeInternal(NOMBRE, value);
    }

    /**Gets the attribute value for NoCedula, using the alias name NoCedula
     */
    public String getNoCedula() {
        return (String)getAttributeInternal(NOCEDULA);
    }

    /**Sets <code>value</code> as the attribute value for NoCedula
     */
    public void setNoCedula(String value) {
        setAttributeInternal(NOCEDULA, value);
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

    /**Gets the attribute value for Monto, using the alias name Monto
     */
    public Number getMonto() {
        return (Number)getAttributeInternal(MONTO);
    }

    /**Sets <code>value</code> as the attribute value for Monto
     */
    public void setMonto(Number value) {
        setAttributeInternal(MONTO, value);
    }

    /**Gets the attribute value for Porcentaje, using the alias name Porcentaje
     */
    public Number getPorcentaje() {
        return (Number)getAttributeInternal(PORCENTAJE);
    }

    /**Sets <code>value</code> as the attribute value for Porcentaje
     */
    public void setPorcentaje(Number value) {
        setAttributeInternal(PORCENTAJE, value);
    }

    /**Gets the attribute value for RecibePago, using the alias name RecibePago
     */
    public Number getRecibePago() {
        return (Number)getAttributeInternal(RECIBEPAGO);
    }

    /**Sets <code>value</code> as the attribute value for RecibePago
     */
    public void setRecibePago(Number value) {
        setAttributeInternal(RECIBEPAGO, value);
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

    /**Gets the attribute value for FechaModif, using the alias name FechaModif
     */
    public Date getFechaModif() {
        return (Date)getAttributeInternal(FECHAMODIF);
    }

    /**Sets <code>value</code> as the attribute value for FechaModif
     */
    public void setFechaModif(Date value) {
        setAttributeInternal(FECHAMODIF, value);
    }

    /**Gets the attribute value for ModPor, using the alias name ModPor
     */
    public String getModPor() {
        return (String)getAttributeInternal(MODPOR);
    }

    /**Sets <code>value</code> as the attribute value for ModPor
     */
    public void setModPor(String value) {
        setAttributeInternal(MODPOR, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDBENEFICIARIO:
            return getIdBeneficiario();
        case IDSOLICITUD:
            return getIdSolicitud();
        case IDPARENTESCO:
            return getIdParentesco();
        case NOMBRE:
            return getNombre();
        case NOCEDULA:
            return getNoCedula();
        case CUI:
            return getCui();
        case MONTO:
            return getMonto();
        case PORCENTAJE:
            return getPorcentaje();
        case RECIBEPAGO:
            return getRecibePago();
        case FECHACREACION:
            return getFechaCreacion();
        case CREADOPOR:
            return getCreadoPor();
        case FECHAMODIF:
            return getFechaModif();
        case MODPOR:
            return getModPor();
        case NOMCOMPLETOCHEQ:
            return getNomcompletocheq();
        case NOMBRE1:
            return getNombre1();
        case NOMBRE2:
            return getNombre2();
        case NOMBRE3:
            return getNombre3();
        case APELLIDO1:
            return getApellido1();
        case APELLIDO2:
            return getApellido2();
        case CONFIRMADO:
            return getConfirmado();
        case IDBANCO:
            return getIdBanco();
        case NUMEROCUENTA:
            return getNumeroCuenta();
        case ESTADOCUENTA:
            return getEstadoCuenta();
        case FECHAOKCUENTA:
            return getFechaOkCuenta();
        case TIPOPAGO:
            return getTipoPago();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDBENEFICIARIO:
            setIdBeneficiario((Number)value);
            return;
        case IDSOLICITUD:
            setIdSolicitud((Number)value);
            return;
        case IDPARENTESCO:
            setIdParentesco((Number)value);
            return;
        case NOMBRE:
            setNombre((String)value);
            return;
        case NOCEDULA:
            setNoCedula((String)value);
            return;
        case CUI:
            setCui((String)value);
            return;
        case MONTO:
            setMonto((Number)value);
            return;
        case PORCENTAJE:
            setPorcentaje((Number)value);
            return;
        case RECIBEPAGO:
            setRecibePago((Number)value);
            return;
        case FECHACREACION:
            setFechaCreacion((Date)value);
            return;
        case CREADOPOR:
            setCreadoPor((String)value);
            return;
        case FECHAMODIF:
            setFechaModif((Date)value);
            return;
        case MODPOR:
            setModPor((String)value);
            return;
        case NOMCOMPLETOCHEQ:
            setNomcompletocheq((String)value);
            return;
        case NOMBRE1:
            setNombre1((String)value);
            return;
        case NOMBRE2:
            setNombre2((String)value);
            return;
        case NOMBRE3:
            setNombre3((String)value);
            return;
        case APELLIDO1:
            setApellido1((String)value);
            return;
        case APELLIDO2:
            setApellido2((String)value);
            return;
        case CONFIRMADO:
            setConfirmado((Number)value);
            return;
        case IDBANCO:
            setIdBanco((Number)value);
            return;
        case NUMEROCUENTA:
            setNumeroCuenta((String)value);
            return;
        case ESTADOCUENTA:
            setEstadoCuenta((Number)value);
            return;
        case FECHAOKCUENTA:
            setFechaOkCuenta((Date)value);
            return;
        case TIPOPAGO:
            setTipoPago((Number)value);
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

    /**Custom DML update/insert/delete logic here.
     */
    protected void doDML(int operation, TransactionEvent e) {
        registrarLogOperaciones(operation, e);
        if (operation == this.DML_INSERT || operation == this.DML_UPDATE) {
            if (operation == this.DML_UPDATE) {
                //Vamos a setear la fecha de modificación
                Object fecha = new oracle.jbo.domain.Date().getCurrentDate();
                Calendar calendario = Calendar.getInstance();
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minutos = calendario.get(Calendar.MINUTE);
                int segundos = calendario.get(Calendar.SECOND);
                oracle.jbo.domain.Date fechaHora = 
                    new oracle.jbo.domain.Date(fecha.toString() + " " + 
                                               String.valueOf(hora) + ":" + 
                                               String.valueOf(minutos) + ":" + 
                                               String.valueOf(segundos));
                this.setFechaModif(fechaHora);
            } else {
                SequenceImpl sequence = 
                    new SequenceImpl("SIS_BENEFICIARIO_SQ", e.getDBTransaction());
                Number numBeneficiario = sequence.getSequenceNumber();
                this.setIdBeneficiario(numBeneficiario);
            }
        }
        super.doDML(operation, e);
    }

    /**Gets the attribute value for Nomcompletocheq, using the alias name Nomcompletocheq
     */
    public String getNomcompletocheq() {
        return (String)getAttributeInternal(NOMCOMPLETOCHEQ);
    }

    /**Sets <code>value</code> as the attribute value for Nomcompletocheq
     */
    public void setNomcompletocheq(String value) {
        setAttributeInternal(NOMCOMPLETOCHEQ, value);
    }

    /**Gets the attribute value for Nombre1, using the alias name Nombre1
     */
    public String getNombre1() {
        return (String)getAttributeInternal(NOMBRE1);
    }

    /**Sets <code>value</code> as the attribute value for Nombre1
     */
    public void setNombre1(String value) {
        setAttributeInternal(NOMBRE1, value);
    }

    /**Gets the attribute value for Nombre2, using the alias name Nombre2
     */
    public String getNombre2() {
        return (String)getAttributeInternal(NOMBRE2);
    }

    /**Sets <code>value</code> as the attribute value for Nombre2
     */
    public void setNombre2(String value) {
        setAttributeInternal(NOMBRE2, value);
    }

    /**Gets the attribute value for Nombre3, using the alias name Nombre3
     */
    public String getNombre3() {
        return (String)getAttributeInternal(NOMBRE3);
    }

    /**Sets <code>value</code> as the attribute value for Nombre3
     */
    public void setNombre3(String value) {
        setAttributeInternal(NOMBRE3, value);
    }

    /**Gets the attribute value for Apellido1, using the alias name Apellido1
     */
    public String getApellido1() {
        return (String)getAttributeInternal(APELLIDO1);
    }

    /**Sets <code>value</code> as the attribute value for Apellido1
     */
    public void setApellido1(String value) {
        setAttributeInternal(APELLIDO1, value);
    }

    /**Gets the attribute value for Apellido2, using the alias name Apellido2
     */
    public String getApellido2() {
        return (String)getAttributeInternal(APELLIDO2);
    }

    /**Sets <code>value</code> as the attribute value for Apellido2
     */
    public void setApellido2(String value) {
        setAttributeInternal(APELLIDO2, value);
    }

    /**Add attribute defaulting logic in this method.
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**Gets the attribute value for Confirmado, using the alias name Confirmado
     */
    public Number getConfirmado() {
        return (Number)getAttributeInternal(CONFIRMADO);
    }

    /**Sets <code>value</code> as the attribute value for Confirmado
     */
    public void setConfirmado(Number value) {
        setAttributeInternal(CONFIRMADO, value);
    }

    /**Gets the attribute value for IdBanco, using the alias name IdBanco
     */
    public Number getIdBanco() {
        return (Number)getAttributeInternal(IDBANCO);
    }

    /**Sets <code>value</code> as the attribute value for IdBanco
     */
    public void setIdBanco(Number value) {
        setAttributeInternal(IDBANCO, value);
    }

    /**Gets the attribute value for NumeroCuenta, using the alias name NumeroCuenta
     */
    public String getNumeroCuenta() {
        return (String)getAttributeInternal(NUMEROCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for NumeroCuenta
     */
    public void setNumeroCuenta(String value) {
        setAttributeInternal(NUMEROCUENTA, value);
    }

    /**Gets the attribute value for EstadoCuenta, using the alias name EstadoCuenta
     */
    public Number getEstadoCuenta() {
        return (Number)getAttributeInternal(ESTADOCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for EstadoCuenta
     */
    public void setEstadoCuenta(Number value) {
        setAttributeInternal(ESTADOCUENTA, value);
    }

    /**Gets the attribute value for FechaOkCuenta, using the alias name FechaOkCuenta
     */
    public Date getFechaOkCuenta() {
        return (Date)getAttributeInternal(FECHAOKCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for FechaOkCuenta
     */
    public void setFechaOkCuenta(Date value) {
        setAttributeInternal(FECHAOKCUENTA, value);
    }

    /**Gets the attribute value for TipoPago, using the alias name TipoPago
     */
    public Number getTipoPago() {
        return (Number)getAttributeInternal(TIPOPAGO);
    }

    /**Sets <code>value</code> as the attribute value for TipoPago
     */
    public void setTipoPago(Number value) {
        setAttributeInternal(TIPOPAGO, value);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number idBeneficiario) {
        return new Key(new Object[] { idBeneficiario });
    }
}
