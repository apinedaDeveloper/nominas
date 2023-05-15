package enlace_datos.tablas;

import java.util.ArrayList;
import java.util.List;

public class SisTipoAjuste {

    /**Map sisAjusteCollection <-> project1.SisAjuste
     * @associates <{project1.SisAjuste}>
     */
    private List sisAjusteCollection;
    private Integer idTipoajuste;
    private String nombre;
    private String descripcion;
    private String operacion;

    public SisTipoAjuste() {
        super();
        this.sisAjusteCollection = new ArrayList();
    }

    public void addSisAjuste(SisAjuste aSisAjuste) {
        this.sisAjusteCollection.add(aSisAjuste);
        aSisAjuste.setSisTipoAjuste(this);
    }

    public void addSisAjuste(int index, SisAjuste aSisAjuste) {
        this.sisAjusteCollection.add(index, aSisAjuste);
        aSisAjuste.setSisTipoAjuste(this);
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Integer getIdTipoajuste() {
        return this.idTipoajuste;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getOperacion() {
        return this.operacion;
    }

    public List<SisAjuste> getSisAjusteCollection() {
        return this.sisAjusteCollection;
    }

    public void removeSisAjuste(SisAjuste aSisAjuste) {
        this.sisAjusteCollection.remove(aSisAjuste);
        aSisAjuste.setSisTipoAjuste(null);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdTipoajuste(Integer idTipoajuste) {
        this.idTipoajuste = idTipoajuste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setSisAjusteCollection(List<SisAjuste> sisAjusteCollection) {
        this.sisAjusteCollection = sisAjusteCollection;
    }

}
