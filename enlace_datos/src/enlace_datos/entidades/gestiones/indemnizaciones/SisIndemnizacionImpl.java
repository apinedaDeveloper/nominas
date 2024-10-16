package enlace_datos.entidades.gestiones.indemnizaciones;

import enlace_datos.util.utils;

import java.util.Calendar;

import oracle.jbo.AttributeList;
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
public class SisIndemnizacionImpl extends EntityImpl {
    public static final int IDINDEMNIZACION = 0;
    public static final int IDTIPOPRESTACION = 1;
    public static final int ANIO = 2;
    public static final int CORRELATIVOANIO = 3;
    public static final int REGISTROEMPLEADO = 4;
    public static final int IDSOLICITUD = 5;
    public static final int ANIOSTIEMPOSERVICIO = 6;
    public static final int MESESTIEMPOSERVICIO = 7;
    public static final int DIASTIEMPOSERVICIO = 8;
    public static final int IDBENEFICIARIOSOL = 9;
    public static final int IDESTADO = 10;
    public static final int TOTALSUELDOS = 11;
    public static final int DIFERIDOCALC = 12;
    public static final int DIFERIDO12CALC = 13;
    public static final int AGUINALDOCALC = 14;
    public static final int BONO14CALC = 15;
    public static final int SUELDOPROMEDIO = 16;
    public static final int TOTALPRESTACION = 17;
    public static final int GASTOFUNERARIO = 18;
    public static final int FECHARETIRO = 19;
    public static final int FECHASOLICITUD = 20;
    public static final int TIPORETIRO = 21;
    public static final int PROGRAMA = 22;
    public static final int NUMCHEQUE = 23;
    public static final int IDPADRE = 24;
    public static final int CREADOPOR = 25;
    public static final int FECHACREACION = 26;
    public static final int MODIFICADOPOR = 27;
    public static final int FECHAMOD = 28;
    public static final int SISTIPOINDEMNIZACION = 29;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public SisIndemnizacionImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("enlace_datos.entidades.gestiones.indemnizaciones.SisIndemnizacion");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for IdTipoPrestacion, using the alias name IdTipoPrestacion
     */
    public Number getIdTipoPrestacion() {
        return (Number)getAttributeInternal(IDTIPOPRESTACION);
    }

    /**Sets <code>value</code> as the attribute value for IdTipoPrestacion
     */
    public void setIdTipoPrestacion(Number value) {
        setAttributeInternal(IDTIPOPRESTACION, value);
    }

    /**Gets the attribute value for Anio, using the alias name Anio
     */
    public Number getAnio() {
        return (Number)getAttributeInternal(ANIO);
    }

    /**Sets <code>value</code> as the attribute value for Anio
     */
    public void setAnio(Number value) {
        setAttributeInternal(ANIO, value);
    }

    /**Gets the attribute value for CorrelativoAnio, using the alias name CorrelativoAnio
     */
    public Number getCorrelativoAnio() {
        return (Number)getAttributeInternal(CORRELATIVOANIO);
    }

    /**Sets <code>value</code> as the attribute value for CorrelativoAnio
     */
    public void setCorrelativoAnio(Number value) {
        setAttributeInternal(CORRELATIVOANIO, value);
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

    /**Gets the attribute value for AniosTiempoServicio, using the alias name AniosTiempoServicio
     */
    public Number getAniosTiempoServicio() {
        return (Number)getAttributeInternal(ANIOSTIEMPOSERVICIO);
    }

    /**Sets <code>value</code> as the attribute value for AniosTiempoServicio
     */
    public void setAniosTiempoServicio(Number value) {
        setAttributeInternal(ANIOSTIEMPOSERVICIO, value);
    }

    /**Gets the attribute value for MesesTiempoServicio, using the alias name MesesTiempoServicio
     */
    public Number getMesesTiempoServicio() {
        return (Number)getAttributeInternal(MESESTIEMPOSERVICIO);
    }

    /**Sets <code>value</code> as the attribute value for MesesTiempoServicio
     */
    public void setMesesTiempoServicio(Number value) {
        setAttributeInternal(MESESTIEMPOSERVICIO, value);
    }

    /**Gets the attribute value for DiasTiempoServicio, using the alias name DiasTiempoServicio
     */
    public Number getDiasTiempoServicio() {
        return (Number)getAttributeInternal(DIASTIEMPOSERVICIO);
    }

    /**Sets <code>value</code> as the attribute value for DiasTiempoServicio
     */
    public void setDiasTiempoServicio(Number value) {
        setAttributeInternal(DIASTIEMPOSERVICIO, value);
    }

    /**Gets the attribute value for IdBeneficiarioSol, using the alias name IdBeneficiarioSol
     */
    public Number getIdBeneficiarioSol() {
        return (Number)getAttributeInternal(IDBENEFICIARIOSOL);
    }

    /**Sets <code>value</code> as the attribute value for IdBeneficiarioSol
     */
    public void setIdBeneficiarioSol(Number value) {
        setAttributeInternal(IDBENEFICIARIOSOL, value);
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

    /**Gets the attribute value for TotalSueldos, using the alias name TotalSueldos
     */
    public Number getTotalSueldos() {
        return (Number)getAttributeInternal(TOTALSUELDOS);
    }

    /**Sets <code>value</code> as the attribute value for TotalSueldos
     */
    public void setTotalSueldos(Number value) {
        setAttributeInternal(TOTALSUELDOS, value);
    }

    /**Gets the attribute value for DiferidoCalc, using the alias name DiferidoCalc
     */
    public Number getDiferidoCalc() {
        return (Number)getAttributeInternal(DIFERIDOCALC);
    }

    /**Sets <code>value</code> as the attribute value for DiferidoCalc
     */
    public void setDiferidoCalc(Number value) {
        setAttributeInternal(DIFERIDOCALC, value);
    }

    /**Gets the attribute value for Diferido12Calc, using the alias name Diferido12Calc
     */
    public Number getDiferido12Calc() {
        return (Number)getAttributeInternal(DIFERIDO12CALC);
    }

    /**Sets <code>value</code> as the attribute value for Diferido12Calc
     */
    public void setDiferido12Calc(Number value) {
        setAttributeInternal(DIFERIDO12CALC, value);
    }

    /**Gets the attribute value for AguinaldoCalc, using the alias name AguinaldoCalc
     */
    public Number getAguinaldoCalc() {
        return (Number)getAttributeInternal(AGUINALDOCALC);
    }

    /**Sets <code>value</code> as the attribute value for AguinaldoCalc
     */
    public void setAguinaldoCalc(Number value) {
        setAttributeInternal(AGUINALDOCALC, value);
    }

    /**Gets the attribute value for Bono14Calc, using the alias name Bono14Calc
     */
    public Number getBono14Calc() {
        return (Number)getAttributeInternal(BONO14CALC);
    }

    /**Sets <code>value</code> as the attribute value for Bono14Calc
     */
    public void setBono14Calc(Number value) {
        setAttributeInternal(BONO14CALC, value);
    }

    /**Gets the attribute value for SueldoPromedio, using the alias name SueldoPromedio
     */
    public Number getSueldoPromedio() {
        return (Number)getAttributeInternal(SUELDOPROMEDIO);
    }

    /**Sets <code>value</code> as the attribute value for SueldoPromedio
     */
    public void setSueldoPromedio(Number value) {
        setAttributeInternal(SUELDOPROMEDIO, value);
    }

    /**Gets the attribute value for TotalPrestacion, using the alias name TotalPrestacion
     */
    public Number getTotalPrestacion() {
        return (Number)getAttributeInternal(TOTALPRESTACION);
    }

    /**Sets <code>value</code> as the attribute value for TotalPrestacion
     */
    public void setTotalPrestacion(Number value) {
        setAttributeInternal(TOTALPRESTACION, value);
    }

    /**Gets the attribute value for GastoFunerario, using the alias name GastoFunerario
     */
    public Number getGastoFunerario() {
        return (Number)getAttributeInternal(GASTOFUNERARIO);
    }

    /**Sets <code>value</code> as the attribute value for GastoFunerario
     */
    public void setGastoFunerario(Number value) {
        setAttributeInternal(GASTOFUNERARIO, value);
    }

    /**Gets the attribute value for FechaSolicitud, using the alias name FechaSolicitud
     */
    public Date getFechaSolicitud() {
        return (Date)getAttributeInternal(FECHASOLICITUD);
    }

    /**Sets <code>value</code> as the attribute value for FechaSolicitud
     */
    public void setFechaSolicitud(Date value) {
        setAttributeInternal(FECHASOLICITUD, value);
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

    /**Gets the attribute value for FechaMod, using the alias name FechaMod
     */
    public Date getFechaMod() {
        return (Date)getAttributeInternal(FECHAMOD);
    }

    /**Sets <code>value</code> as the attribute value for FechaMod
     */
    public void setFechaMod(Date value) {
        setAttributeInternal(FECHAMOD, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDINDEMNIZACION:
            return getIdIndemnizacion();
        case IDTIPOPRESTACION:
            return getIdTipoPrestacion();
        case ANIO:
            return getAnio();
        case CORRELATIVOANIO:
            return getCorrelativoAnio();
        case REGISTROEMPLEADO:
            return getRegistroEmpleado();
        case IDSOLICITUD:
            return getIdSolicitud();
        case ANIOSTIEMPOSERVICIO:
            return getAniosTiempoServicio();
        case MESESTIEMPOSERVICIO:
            return getMesesTiempoServicio();
        case DIASTIEMPOSERVICIO:
            return getDiasTiempoServicio();
        case IDBENEFICIARIOSOL:
            return getIdBeneficiarioSol();
        case IDESTADO:
            return getIdEstado();
        case TOTALSUELDOS:
            return getTotalSueldos();
        case DIFERIDOCALC:
            return getDiferidoCalc();
        case DIFERIDO12CALC:
            return getDiferido12Calc();
        case AGUINALDOCALC:
            return getAguinaldoCalc();
        case BONO14CALC:
            return getBono14Calc();
        case SUELDOPROMEDIO:
            return getSueldoPromedio();
        case TOTALPRESTACION:
            return getTotalPrestacion();
        case GASTOFUNERARIO:
            return getGastoFunerario();
        case FECHARETIRO:
            return getFechaRetiro();
        case FECHASOLICITUD:
            return getFechaSolicitud();
        case TIPORETIRO:
            return getTipoRetiro();
        case PROGRAMA:
            return getPrograma();
        case NUMCHEQUE:
            return getNumCheque();
        case IDPADRE:
            return getIdPadre();
        case CREADOPOR:
            return getCreadoPor();
        case FECHACREACION:
            return getFechaCreacion();
        case MODIFICADOPOR:
            return getModificadoPor();
        case FECHAMOD:
            return getFechaMod();
        case SISTIPOINDEMNIZACION:
            return getSisTipoIndemnizacion();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDINDEMNIZACION:
            setIdIndemnizacion((Number)value);
            return;
        case IDTIPOPRESTACION:
            setIdTipoPrestacion((Number)value);
            return;
        case ANIO:
            setAnio((Number)value);
            return;
        case CORRELATIVOANIO:
            setCorrelativoAnio((Number)value);
            return;
        case REGISTROEMPLEADO:
            setRegistroEmpleado((Number)value);
            return;
        case IDSOLICITUD:
            setIdSolicitud((Number)value);
            return;
        case ANIOSTIEMPOSERVICIO:
            setAniosTiempoServicio((Number)value);
            return;
        case MESESTIEMPOSERVICIO:
            setMesesTiempoServicio((Number)value);
            return;
        case DIASTIEMPOSERVICIO:
            setDiasTiempoServicio((Number)value);
            return;
        case IDBENEFICIARIOSOL:
            setIdBeneficiarioSol((Number)value);
            return;
        case IDESTADO:
            setIdEstado((Number)value);
            return;
        case TOTALSUELDOS:
            setTotalSueldos((Number)value);
            return;
        case DIFERIDOCALC:
            setDiferidoCalc((Number)value);
            return;
        case DIFERIDO12CALC:
            setDiferido12Calc((Number)value);
            return;
        case AGUINALDOCALC:
            setAguinaldoCalc((Number)value);
            return;
        case BONO14CALC:
            setBono14Calc((Number)value);
            return;
        case SUELDOPROMEDIO:
            setSueldoPromedio((Number)value);
            return;
        case TOTALPRESTACION:
            setTotalPrestacion((Number)value);
            return;
        case GASTOFUNERARIO:
            setGastoFunerario((Number)value);
            return;
        case FECHARETIRO:
            setFechaRetiro((Date)value);
            return;
        case FECHASOLICITUD:
            setFechaSolicitud((Date)value);
            return;
        case TIPORETIRO:
            setTipoRetiro((Number)value);
            return;
        case PROGRAMA:
            setPrograma((Number)value);
            return;
        case NUMCHEQUE:
            setNumCheque((Number)value);
            return;
        case IDPADRE:
            setIdPadre((Number)value);
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
        case FECHAMOD:
            setFechaMod((Date)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the associated entity SisTipoIndemnizacionImpl
     */
    public SisTipoIndemnizacionImpl getSisTipoIndemnizacion() {
        return (SisTipoIndemnizacionImpl)getAttributeInternal(SISTIPOINDEMNIZACION);
    }

    /**Sets <code>value</code> as the associated entity SisTipoIndemnizacionImpl
     */
    public void setSisTipoIndemnizacion(SisTipoIndemnizacionImpl value) {
        setAttributeInternal(SISTIPOINDEMNIZACION, value);
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

    /**Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**Custom DML update/insert/delete logic here.
     */
    protected void doDML(int operation, TransactionEvent e) {
        String valUsuario;
        if (operation == this.DML_INSERT) {
            /*SequenceImpl sequence =
                new SequenceImpl("SIS_INDEMNIZACION_SEQ", e.getDBTransaction());
            Number idIndemnizacion = sequence.getSequenceNumber();
            this.setIdIndemnizacion(idIndemnizacion);*/
            valUsuario = 
                    utils.getAuthUser(e.getDBTransaction()); //obtengo el registro del usuario logueado
            if (this.getCreadoPor() == null) {
                this.setCreadoPor(valUsuario);
            }
        } else if (operation == this.DML_UPDATE) {
            valUsuario = 
                    utils.getAuthUser(e.getDBTransaction()); //obtengo el registro del usuario logueado
            if (this.getModificadoPor() == null) {
                this.setModificadoPor(valUsuario);
            }
            //Vamos a setear la fecha de modificación
            Object fecha = new oracle.jbo.domain.Date().getCurrentDate();
            Calendar calendario = Calendar.getInstance();
            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);
            Date fechaHora = 
                new Date(fecha.toString() + " " + String.valueOf(hora) + ":" + 
                         String.valueOf(minutos) + ":" + 
                         String.valueOf(segundos));
            this.setFechaMod(fechaHora);
            /*if (this.getAniosTiempoServicio() == null) {
                this.setAniosTiempoServicio(Number.formattedTextToNumber("0"));
            }
            if (this.getMesesTiempoServicio() == null) {
                this.setMesesTiempoServicio((Number)"0");
            }
            if (this.getDiasTiempoServicio() == null) {
                this.setDiasTiempoServicio((Number)"0");
            }*/
        }
        super.doDML(operation, e);
    }

    /**Gets the attribute value for FechaRetiro, using the alias name FechaRetiro
     */
    public Date getFechaRetiro() {
        return (Date)getAttributeInternal(FECHARETIRO);
    }

    /**Sets <code>value</code> as the attribute value for FechaRetiro
     */
    public void setFechaRetiro(Date value) {
        setAttributeInternal(FECHARETIRO, value);
    }

    /**Gets the attribute value for TipoRetiro, using the alias name TipoRetiro
     */
    public Number getTipoRetiro() {
        return (Number)getAttributeInternal(TIPORETIRO);
    }

    /**Sets <code>value</code> as the attribute value for TipoRetiro
     */
    public void setTipoRetiro(Number value) {
        setAttributeInternal(TIPORETIRO, value);
    }

    /**Gets the attribute value for NumCheque, using the alias name NumCheque
     */
    public Number getNumCheque() {
        return (Number)getAttributeInternal(NUMCHEQUE);
    }

    /**Sets <code>value</code> as the attribute value for NumCheque
     */
    public void setNumCheque(Number value) {
        setAttributeInternal(NUMCHEQUE, value);
    }

    /**Gets the attribute value for IdIndemnizacion, using the alias name IdIndemnizacion
     */
    public Number getIdIndemnizacion() {
        return (Number)getAttributeInternal(IDINDEMNIZACION);
    }

    /**Sets <code>value</code> as the attribute value for IdIndemnizacion
     */
    public void setIdIndemnizacion(Number value) {
        setAttributeInternal(IDINDEMNIZACION, value);
    }

    /**Gets the attribute value for IdPadre, using the alias name IdPadre
     */
    public Number getIdPadre() {
        return (Number)getAttributeInternal(IDPADRE);
    }

    /**Sets <code>value</code> as the attribute value for IdPadre
     */
    public void setIdPadre(Number value) {
        setAttributeInternal(IDPADRE, value);
    }

    /**Gets the attribute value for Programa, using the alias name Programa
     */
    public Number getPrograma() {
        return (Number)getAttributeInternal(PROGRAMA);
    }

    /**Sets <code>value</code> as the attribute value for Programa
     */
    public void setPrograma(Number value) {
        setAttributeInternal(PROGRAMA, value);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(Number idIndemnizacion) {
        return new Key(new Object[]{idIndemnizacion});
    }
}
