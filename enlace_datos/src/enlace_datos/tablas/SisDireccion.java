package enlace_datos.tablas;

import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;

public class SisDireccion {

    /**Map sisEmpleado <-> enlace_datos.tablas.SisEmpleado
     * @associates <{enlace_datos.tablas.SisEmpleado}>
     */
    private ValueHolderInterface sisEmpleado;
    private Double idDireccion;
    private Long idMunicipio;
    private String avecalle;
    private String numCasa;
    private String apto;
    private String zona;
    private String colonia;

    public SisDireccion() {
        super();
        this.sisEmpleado = new ValueHolder();
    }

    public String getApto() {
        return this.apto;
    }

    public String getAvecalle() {
        return this.avecalle;
    }

    public String getColonia() {
        return this.colonia;
    }

    public Double getIdDireccion() {
        return this.idDireccion;
    }

    public Long getIdMunicipio() {
        return this.idMunicipio;
    }

    public String getNumCasa() {
        return this.numCasa;
    }

    public SisEmpleado getSisEmpleado() {
        return (SisEmpleado)this.sisEmpleado.getValue();
    }

    public String getZona() {
        return this.zona;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public void setAvecalle(String avecalle) {
        this.avecalle = avecalle;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setIdDireccion(Double idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public void setSisEmpleado(SisEmpleado sisEmpleado) {
        this.sisEmpleado.setValue(sisEmpleado);
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
