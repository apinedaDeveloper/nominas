package enlace_datos.consultas.mensajes;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SisMensajesRelacionadosVwRowImpl extends ViewRowImpl {
    public static final int IDMENSAJEENTRANTE = 0;
    public static final int IDMENSAJESAL = 1;
    public static final int IDREPLY = 2;
    public static final int USUARIO = 3;
    public static final int ESTADO = 4;
    public static final int FECHALECTURA = 5;
    public static final int USUARIOENVIO = 6;
    public static final int ASUNTO = 7;
    public static final int MENSAJE = 8;
    public static final int FECHACREACION = 9;
    public static final int NOMBREENVIA = 10;
    public static final int RECIBE = 11;

    /**This is the default constructor (do not remove)
     */
    public SisMensajesRelacionadosVwRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute IdMensajeEntrante
     */
    public Number getIdMensajeEntrante() {
        return (Number) getAttributeInternal(IDMENSAJEENTRANTE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdMensajeEntrante
     */
    public void setIdMensajeEntrante(Number value) {
        setAttributeInternal(IDMENSAJEENTRANTE, value);
    }

    /**Gets the attribute value for the calculated attribute IdMensajeSal
     */
    public Number getIdMensajeSal() {
        return (Number) getAttributeInternal(IDMENSAJESAL);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdMensajeSal
     */
    public void setIdMensajeSal(Number value) {
        setAttributeInternal(IDMENSAJESAL, value);
    }

    /**Gets the attribute value for the calculated attribute IdReply
     */
    public Number getIdReply() {
        return (Number) getAttributeInternal(IDREPLY);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdReply
     */
    public void setIdReply(Number value) {
        setAttributeInternal(IDREPLY, value);
    }

    /**Gets the attribute value for the calculated attribute Usuario
     */
    public String getUsuario() {
        return (String) getAttributeInternal(USUARIO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Usuario
     */
    public void setUsuario(String value) {
        setAttributeInternal(USUARIO, value);
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

    /**Gets the attribute value for the calculated attribute FechaLectura
     */
    public Date getFechaLectura() {
        return (Date) getAttributeInternal(FECHALECTURA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute FechaLectura
     */
    public void setFechaLectura(Date value) {
        setAttributeInternal(FECHALECTURA, value);
    }

    /**Gets the attribute value for the calculated attribute UsuarioEnvio
     */
    public String getUsuarioEnvio() {
        return (String) getAttributeInternal(USUARIOENVIO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute UsuarioEnvio
     */
    public void setUsuarioEnvio(String value) {
        setAttributeInternal(USUARIOENVIO, value);
    }

    /**Gets the attribute value for the calculated attribute Asunto
     */
    public String getAsunto() {
        return (String) getAttributeInternal(ASUNTO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Asunto
     */
    public void setAsunto(String value) {
        setAttributeInternal(ASUNTO, value);
    }

    /**Gets the attribute value for the calculated attribute Mensaje
     */
    public String getMensaje() {
        return (String) getAttributeInternal(MENSAJE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Mensaje
     */
    public void setMensaje(String value) {
        setAttributeInternal(MENSAJE, value);
    }

    /**Gets the attribute value for the calculated attribute FechaCreacion
     */
    public String getFechaCreacion() {
        return (String) getAttributeInternal(FECHACREACION);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute FechaCreacion
     */
    public void setFechaCreacion(String value) {
        setAttributeInternal(FECHACREACION, value);
    }

    /**Gets the attribute value for the calculated attribute Nombreenvia
     */
    public String getNombreenvia() {
        return (String) getAttributeInternal(NOMBREENVIA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Nombreenvia
     */
    public void setNombreenvia(String value) {
        setAttributeInternal(NOMBREENVIA, value);
    }

    /**Gets the attribute value for the calculated attribute Recibe
     */
    public String getRecibe() {
        return (String) getAttributeInternal(RECIBE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Recibe
     */
    public void setRecibe(String value) {
        setAttributeInternal(RECIBE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDMENSAJEENTRANTE:
            return getIdMensajeEntrante();
        case IDMENSAJESAL:
            return getIdMensajeSal();
        case IDREPLY:
            return getIdReply();
        case USUARIO:
            return getUsuario();
        case ESTADO:
            return getEstado();
        case FECHALECTURA:
            return getFechaLectura();
        case USUARIOENVIO:
            return getUsuarioEnvio();
        case ASUNTO:
            return getAsunto();
        case MENSAJE:
            return getMensaje();
        case FECHACREACION:
            return getFechaCreacion();
        case NOMBREENVIA:
            return getNombreenvia();
        case RECIBE:
            return getRecibe();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDMENSAJEENTRANTE:
            setIdMensajeEntrante((Number)value);
            return;
        case IDMENSAJESAL:
            setIdMensajeSal((Number)value);
            return;
        case IDREPLY:
            setIdReply((Number)value);
            return;
        case USUARIO:
            setUsuario((String)value);
            return;
        case ESTADO:
            setEstado((String)value);
            return;
        case FECHALECTURA:
            setFechaLectura((Date)value);
            return;
        case USUARIOENVIO:
            setUsuarioEnvio((String)value);
            return;
        case ASUNTO:
            setAsunto((String)value);
            return;
        case MENSAJE:
            setMensaje((String)value);
            return;
        case FECHACREACION:
            setFechaCreacion((String)value);
            return;
        case NOMBREENVIA:
            setNombreenvia((String)value);
            return;
        case RECIBE:
            setRecibe((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}
