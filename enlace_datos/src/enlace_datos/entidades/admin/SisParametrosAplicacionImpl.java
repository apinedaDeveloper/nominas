package enlace_datos.entidades.admin;

import enlace_datos.util.myEntityImpl;
import enlace_datos.util.utils;
import enlace_datos.util.utils_DB;

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
public class SisParametrosAplicacionImpl extends myEntityImpl {
    public static final int NOMPARAMETRO = 0;
    public static final int DESCRIPCION = 1;
    public static final int VALORNUMERICO = 2;
    public static final int VALORCADENA = 3;
    public static final int CREADOPOR = 4;
    public static final int FECHACREACION = 5;
    public static final int MODIFICADOPOR = 6;
    public static final int FECHAMODIFICACION = 7;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public SisParametrosAplicacionImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("enlace_datos.entidades.admin.SisParametrosAplicacion");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for NomParametro, using the alias name NomParametro
     */
    public String getNomParametro() {
        return (String)getAttributeInternal(NOMPARAMETRO);
    }

    /**Sets <code>value</code> as the attribute value for NomParametro
     */
    public void setNomParametro(String value) {
        setAttributeInternal(NOMPARAMETRO, value);
    }

    /**Gets the attribute value for Descripcion, using the alias name Descripcion
     */
    public String getDescripcion() {
        return (String)getAttributeInternal(DESCRIPCION);
    }

    /**Sets <code>value</code> as the attribute value for Descripcion
     */
    public void setDescripcion(String value) {
        setAttributeInternal(DESCRIPCION, value);
    }

    /**Gets the attribute value for ValorNumerico, using the alias name ValorNumerico
     */
    public Number getValorNumerico() {
        return (Number)getAttributeInternal(VALORNUMERICO);
    }

    /**Sets <code>value</code> as the attribute value for ValorNumerico
     */
    public void setValorNumerico(Number value) {
        setAttributeInternal(VALORNUMERICO, value);
    }

    /**Gets the attribute value for ValorCadena, using the alias name ValorCadena
     */
    public String getValorCadena() {
        return (String)getAttributeInternal(VALORCADENA);
    }

    /**Sets <code>value</code> as the attribute value for ValorCadena
     */
    public void setValorCadena(String value) {
        setAttributeInternal(VALORCADENA, value);
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

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case NOMPARAMETRO:
            return getNomParametro();
        case DESCRIPCION:
            return getDescripcion();
        case VALORNUMERICO:
            return getValorNumerico();
        case VALORCADENA:
            return getValorCadena();
        case CREADOPOR:
            return getCreadoPor();
        case FECHACREACION:
            return getFechaCreacion();
        case MODIFICADOPOR:
            return getModificadoPor();
        case FECHAMODIFICACION:
            return getFechaModificacion();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case NOMPARAMETRO:
            setNomParametro((String)value);
            return;
        case DESCRIPCION:
            setDescripcion((String)value);
            return;
        case VALORNUMERICO:
            setValorNumerico((Number)value);
            return;
        case VALORCADENA:
            setValorCadena((String)value);
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

   public void validarEntidad(){
       if (this.getValorNumerico()==null && (this.getValorCadena()==null ||(this.getValorCadena()!=null && this.getValorCadena().equals("")))){
         throw  new JboException("Por favor ingrese un valor num�rico/cadena");
       }
       
   }

    /**Custom DML update/insert/delete logic here.
     */
    protected void doDML(int operation, TransactionEvent e) {
        
        validarEntidad();
        
        if (operation==this.DML_INSERT){
            
            this.setCreadoPor(utils.getAuthUser(e.getDBTransaction()));
            
        }else if (operation==this.DML_UPDATE){
            
            this.setModificadoPor(utils.getAuthUser(e.getDBTransaction()));
            this.setFechaModificacion(utils.getFechaActual());
        }
        
        registrarLogOperaciones(operation, e); 
        super.doDML(operation, e);
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(String nomParametro) {
        return new Key(new Object[]{nomParametro});
    }
}
