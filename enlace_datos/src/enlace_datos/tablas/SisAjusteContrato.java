package enlace_datos.tablas;

import java.util.Date;

import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;

public class SisAjusteContrato {

    /**Map sisContrato <-> enlace_datos.tablas.SisContrato
     * @associates <{enlace_datos.tablas.SisContrato}>
     */
    private ValueHolderInterface sisContrato;

    /**Map sisAjuste <-> enlace_datos.tablas.SisAjuste
     * @associates <{enlace_datos.tablas.SisAjuste}>
     */
    private ValueHolderInterface sisAjuste;
    private Long idContrato;
    private Long idAjuste;
    private Double idCorrelativo;
    private Double idProceso;
    private Date fechaInicio;
    private Date fechaFin;
    private Double valor;
    private String nombreAjuste;

    public SisAjusteContrato() {
        super();
        this.sisContrato = new ValueHolder();
        this.sisAjuste = new ValueHolder();
    }

	public String getnombreAjuste(){
        return this.nombreAjuste;
    }

     public void setnombreAjuste(String str_nombre){
        this.nombreAjuste=str_nombre;
     }
	 
    public Date getFechaFin() {
        return this.fechaFin;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Long getIdAjuste() {
        return this.idAjuste;
    }

    public Long getIdContrato() {
        return this.idContrato;
    }

    public Double getIdCorrelativo() {
        return this.idCorrelativo;
    }

    public Double getIdProceso() {
        return this.idProceso;
    }

    public SisAjuste getSisAjuste() {
        return (SisAjuste)this.sisAjuste.getValue();
    }

    public SisContrato getSisContrato() {
        return (SisContrato)this.sisContrato.getValue();
    }

    public Double getValor() {
        return this.valor;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setIdAjuste(Long idAjuste) {
        this.idAjuste = idAjuste;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public void setIdCorrelativo(Double idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public void setIdProceso(Double idProceso) {
        this.idProceso = idProceso;
    }

    public void setSisAjuste(SisAjuste sisAjuste) {
        this.sisAjuste.setValue(sisAjuste);
    }

    public void setSisContrato(SisContrato sisContrato) {
        this.sisContrato.setValue(sisContrato);
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
