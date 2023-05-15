package enlace_datos.tablas;

import java.util.Date;
import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;


public class SisAjusteEmpleado {

    private ValueHolderInterface sisAjuste;
    private ValueHolderInterface sisEmpleado;
    private Long registroEmpleado;
    private Long idAjuste;
    private Double idCorrelativo;
    private Double idProceso;
    private Date fechaInicio;
    private Date fechaFin;
    private Double valor;
    private String nombreAjuste;

    public SisAjusteEmpleado() {
        super();
        this.sisAjuste = new ValueHolder();
        this.sisEmpleado = new ValueHolder();
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

    public Double getIdCorrelativo() {
        return this.idCorrelativo;
    }

    public Double getIdProceso() {
        return this.idProceso;
    }

    public Long getRegistroEmpleado() {
        return this.registroEmpleado;
    }

    public Double getValor() {
        return this.valor;
    }

     public SisAjuste getSisAjuste() {
        return (SisAjuste)this.sisAjuste.getValue();
    }
	
    public SisEmpleado getSisEmpleado() {
        return (SisEmpleado)this.sisEmpleado.getValue();
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

    public void setIdCorrelativo(Double idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public void setIdProceso(Double idProceso) {
        this.idProceso = idProceso;
    }

    public void setRegistroEmpleado(Long registroEmpleado) {
        this.registroEmpleado = registroEmpleado;
    }

    public void setSisEmpleado(SisEmpleado sisEmpleado) {
        this.sisEmpleado.setValue(sisEmpleado);
    }
	
    public void setValor(Double valor) {
        this.valor = valor;
    }
	
    public void setSisAjuste(SisAjuste sisAjuste) {
        this.sisAjuste.setValue(sisAjuste);
    }

}
