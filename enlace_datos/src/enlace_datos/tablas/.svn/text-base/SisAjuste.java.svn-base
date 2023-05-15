package enlace_datos.tablas;

import java.util.ArrayList;
import java.util.List;

import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;

public class SisAjuste {

    /**Map varianteCollection <-> enlace_datos.tablas.SisAjuste
     * @associates <{enlace_datos.tablas.SisAjuste}>
     */
   
    /**Map variante <-> enlace_datos.tablas.SisAjuste
     * @associates <{enlace_datos.tablas.SisAjuste}>
     */

    /**Map sisAjusteContratoCollection <-> enlace_datos.tablas.SisAjusteContrato
     * @associates <{enlace_datos.tablas.SisAjusteContrato}>
     */
    private List sisAjusteContratoCollection;
    private List sisAjusteEmpleadoCollection;
    private ValueHolderInterface sisTipoAjuste;
    private Integer idAjuste;
    private Integer idTipoajuste;
    private Integer prioridad;
    private String nombre;
    private String codNomina;
    private String descripcion;
    private String opcional;
    private String removible;
    private String aplicacion;
    private String nivel;
    private Double valorAprox;
    private String nomTipo;

    public SisAjuste() {
        super();
        this.sisAjusteContratoCollection = new ArrayList();
	this.sisAjusteEmpleadoCollection = new ArrayList();
        this.sisTipoAjuste = new ValueHolder();
    }

    public SisTipoAjuste getSisTipoAjuste() {
        return (SisTipoAjuste)this.sisTipoAjuste.getValue();
    }

    public void setSisTipoAjuste(SisTipoAjuste sisTipoAjuste) {
        this.sisTipoAjuste.setValue(sisTipoAjuste);
    }
   public String getNomTipo(){
      if (nomTipo==null){
        if ( this.getSisTipoAjuste().getOperacion().equals("I") || this.getSisTipoAjuste().getOperacion().equals("ISD")){
             this.nomTipo="BONO";
         }
          else{
              this.nomTipo="DESCUENTO";
             }
      }
   
       return this.nomTipo;
   }

   public void setNomTipo(String nomTipo){
       this.nomTipo=nomTipo;    
   }
   
    public Double getValorAprox(){
        return valorAprox;
    }
    
    public void setValorAprox(Double pvalor){
        this.valorAprox=pvalor;
    }

    public void addSisAjusteContrato(int index, 
                                     SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.add(index, aSisAjusteContrato);
        aSisAjusteContrato.setSisAjuste(this);
    }

    public void addSisAjusteContrato(SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.add(aSisAjusteContrato);
        aSisAjusteContrato.setSisAjuste(this);
    }

   	
    public void addSisAjusteEmpleado(SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.add(aSisAjusteEmpleado);
        aSisAjusteEmpleado.setSisAjuste(this);
    }

    public void addSisAjusteEmpleado(int index, 
                                     SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.add(index, aSisAjusteEmpleado);
        aSisAjusteEmpleado.setSisAjuste(this);
    }

    public String getCodNomina() {
        return this.codNomina;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Integer getIdAjuste() {
        return this.idAjuste;
    }

    public Integer getIdTipoajuste() {
        return this.idTipoajuste;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getAplicacion() {
        return this.aplicacion;
    }  
	
    public String getOpcional() {
        return this.opcional;
    }

    public Integer getPrioridad() {
        return this.prioridad;
    }

    public String getRemovible() {
        return this.removible;
    }

	public String getNivel() {
        return this.nivel;
    }
	
    public List<SisAjusteContrato> getSisAjusteContratoCollection() {
        return this.sisAjusteContratoCollection;
    }

   
   
    public List<SisAjusteEmpleado> getSisAjusteEmpleadoCollection() {
        return this.sisAjusteEmpleadoCollection;
    }

	
    public void removeSisAjusteContrato(SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.remove(aSisAjusteContrato);
    }

 
    public void removeSisAjusteEmpleado(SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.remove(aSisAjusteEmpleado);
    }

	
    public void setCodNomina(String codNomina) {
        this.codNomina = codNomina;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdAjuste(Integer idAjuste) {
        this.idAjuste = idAjuste;
    }

    public void setIdTipoajuste(Integer idTipoajuste) {
        this.idTipoajuste = idTipoajuste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public void setRemovible(String removible) {
        this.removible = removible;
    }

    public void setSisAjusteContratoCollection(List<SisAjusteContrato> sisAjusteContratoCollection) {
        this.sisAjusteContratoCollection = sisAjusteContratoCollection;
    }

    	
    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

	public void setSisAjusteEmpleadoCollection(List<SisAjusteEmpleado> sisAjusteEmpleadoCollection) {
        this.sisAjusteEmpleadoCollection = sisAjusteEmpleadoCollection;
    } 
	
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


}
