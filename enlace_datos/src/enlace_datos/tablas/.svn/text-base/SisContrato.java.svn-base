package enlace_datos.tablas;

import enlace_datos.consultas.QUERRYSImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;


public class SisContrato {

    /**Map sisAjusteContratoCollection <-> enlace_datos.tablas.SisAjusteContrato
     * @associates <{enlace_datos.tablas.SisAjusteContrato}>
     */
    private List sisAjusteContratoCollection;
    private ValueHolderInterface sisEmpleado;
    private List sisHorarioContratoCollection;
    private Long idContrato;
    private Integer idTipoContrato;
    private Integer idFormaObtPuesto;
    private Integer idPartida;
    private Integer idPuesto;
    private Integer correlativo;
    private Long registroEmpleado;
    private Double sueldobase;
    private String atribucion;
    private Integer horascontratadas;
    private Long lugarPosesion;
    private Date fechaPosesion;
    private String instalacionPosesion;
    private Date fechaCreacion;
    private Integer estatus;
    private Integer numeroPlaza;
    private Date fechaInicio;
    private Date fechaFin;
    private HashMap nombreDias;

    public SisContrato() {
        super();
        this.lugarPosesion=new Long(1);
        this.idTipoContrato=new Integer(1);
        this.idFormaObtPuesto=new Integer(1);
        this.fechaPosesion=new Date();
        this.sisAjusteContratoCollection = new ArrayList();
	this.sisEmpleado = new ValueHolder();
        this.sisHorarioContratoCollection = new ArrayList();    
        nombreDias=new HashMap();
    }
 
    public void addNombreDia(String pKey,String pNombre){
       nombreDias.put(pKey,pNombre) ;
    }
    
    public String getNombreDia(String pKey){
      return nombreDias.get(pKey)!=null? (String)nombreDias.get(pKey):"";
    }
    
    public void addSisHorarioContrato(SisHorarioContrato aSisHorarioContrato) {
        this.sisHorarioContratoCollection.add(aSisHorarioContrato);
        aSisHorarioContrato.setSisContrato(this);
    }
    
    public void addSisHorarioContrato(int index, 
                                      SisHorarioContrato aSisHorarioContrato) {
        
        this.sisHorarioContratoCollection.add(index, aSisHorarioContrato);
        aSisHorarioContrato.setSisContrato(this);

    }

    public List<SisHorarioContrato> getSisHorarioContratoCollection() {
        return this.sisHorarioContratoCollection;
    }
    
    public void removeSisHorarioContrato(SisHorarioContrato aSisHorarioContrato) {
        this.sisHorarioContratoCollection.remove(aSisHorarioContrato);
    }

    public void setSisHorarioContratoCollection(List<SisHorarioContrato> sisHorarioContratoCollection) {
        this.sisHorarioContratoCollection = sisHorarioContratoCollection;
     }
 
   public double getNumHoras(){
     double num_horas=0;
      for (Iterator iter=this.getSisHorarioContratoCollection().iterator();iter.hasNext();){
          num_horas=num_horas+((SisHorarioContrato)iter.next()).getNumHoras();
      }
       return num_horas;
   }

   public void removeFila(){
       System.out.println("borrando fila"+this.sisAjusteContratoCollection.size());
       this.sisAjusteContratoCollection.remove(0);
   }

    public void addSisAjusteContrato(SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.add(aSisAjusteContrato);
        aSisAjusteContrato.setSisContrato(this);
    }

    public void addSisAjusteContrato(int index, 
                                     SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.add(index, aSisAjusteContrato);
        aSisAjusteContrato.setSisContrato(this);
    }

public List<SisAjusteContrato> getSisAjusteContratoCollection() {
       return this.sisAjusteContratoCollection;
     }
    
    
    public void setSisAjusteContratoCollection(List<SisAjusteContrato> sisAjusteContratoCollection) {
        this.sisAjusteContratoCollection = sisAjusteContratoCollection;
       
        SisAjuste v_Ajuste;
        List<SisAjusteContrato> vAjusteContratos;
        SisAjusteContrato vAjuste;
        
        vAjusteContratos=this.getSisAjusteContratoCollection();
        for (Iterator iter=vAjusteContratos.iterator();iter.hasNext();){
            vAjuste=(SisAjusteContrato)iter.next();
            v_Ajuste=vAjuste.getSisAjuste();
            vAjuste.setnombreAjuste(v_Ajuste.getNombre());
            //ajustes.add(pru3);
        }
       
    }
 
 
 
 
    public String getAtribucion() {
        return this.atribucion;
    }

    public Integer getCorrelativo() {
        return this.correlativo;
    }

    public Integer getEstatus() {
        return this.estatus;
    }

	 public SisEmpleado getSisEmpleado() {
        return (SisEmpleado)this.sisEmpleado.getValue();
    }
	
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaPosesion() {
        return this.fechaPosesion;
    }

    
    public Integer getHorascontratadas() {
        return this.horascontratadas;
    }

    public Long getIdContrato() {
        return this.idContrato;
    }

    public Integer getIdFormaObtPuesto() {
        return this.idFormaObtPuesto;
    }

    public Integer getIdPartida() {
        return this.idPartida;
    }

    public Integer getIdPuesto() {
        return this.idPuesto;
    }

    public Integer getIdTipoContrato() {
        return this.idTipoContrato;
    }

    public String getInstalacionPosesion() {
        return this.instalacionPosesion;
    }

    public Long getLugarPosesion() {
        return this.lugarPosesion;
    }

    public Integer getNumeroPlaza() {
        return this.numeroPlaza;
    }

    public Long getRegistroEmpleado() {
        return this.registroEmpleado;
    }

    
    public Double getSueldobase() {
        return this.sueldobase;
    }

    public void removeSisAjusteContrato(SisAjusteContrato aSisAjusteContrato) {
        this.sisAjusteContratoCollection.remove(aSisAjusteContrato);
    }

    public void setAtribucion(String atribucion) {
        this.atribucion = atribucion;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaPosesion(Date fechaPosesion) {
        this.fechaPosesion = fechaPosesion;
    }

    
    public void setHorascontratadas(Integer horascontratadas) {
        this.horascontratadas = horascontratadas;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public void setIdFormaObtPuesto(Integer idFormaObtPuesto) {
        this.idFormaObtPuesto = idFormaObtPuesto;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public void setInstalacionPosesion(String instalacionPosesion) {
        this.instalacionPosesion = instalacionPosesion;
    }

    public void setLugarPosesion(Long lugarPosesion) {
        this.lugarPosesion = lugarPosesion;
    }

    public void setNumeroPlaza(Integer numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public void setRegistroEmpleado(Long registroEmpleado) {
        this.registroEmpleado = registroEmpleado;
    }


    public void setSueldobase(Double sueldobase) {
        this.sueldobase = sueldobase;
    }
	
	public void setSisEmpleado(SisEmpleado sisEmpleado) {
        this.sisEmpleado.setValue(sisEmpleado);
    }

}
