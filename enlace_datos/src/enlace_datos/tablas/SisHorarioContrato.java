package enlace_datos.tablas;

import enlace_datos.util.horario;

import oracle.toplink.indirection.ValueHolder;
import oracle.toplink.indirection.ValueHolderInterface;
import enlace_datos.util.utils;

public class SisHorarioContrato {

    /**Map sisContrato <-> project2.SisContrato
     * @associates <{project2.SisContrato}>
     */
    private ValueHolderInterface sisContrato;
    private Long idContrato;
    private String idDia;
    private String horaEntrada;
    private String horaSalida;
    private horario horaE;
    private horario horaS;
    private String strDia;

    public SisHorarioContrato() {
        super();
        this.sisContrato = new ValueHolder();
        idDia="L-V";
        horaE=new horario();
        horaS=new horario();
       
    }

   public void setDia(String pDia){
       pDia=strDia;
   }

  public String getNombreDia(){
      return this.getSisContrato().getNombreDia(idDia);
  }

   public String getDia(){
       return strDia;
   }
    public String getHoraE(){
         if (this.horaEntrada!=null){
            this.horaE.setHorarioBase(this.horaEntrada); 
         }
        return this.horaE.getHorario();
    }
   
   public void setHoraE(String pHoraE){
       this.horaE.setHorario(pHoraE);
       this.setHoraEntrada("0 "+this.horaE.getHorario()+":00");
       
   }
   public String getHoraS(){
         if (this.horaSalida!=null){
            this.horaS.setHorarioBase(this.horaSalida); 
         }
   
       return this.horaS.getHorario();
   }

  public void setHoraS(String pHoraS){
    this.horaS.setHorario(pHoraS);
    this.setHoraSalida("0 "+this.horaS.getHorario()+":00");
  }
  
  public double getNumHoras(){
    return this.horaS.getDiff_Horas(this.horaE);
  }
  
    public SisHorarioContrato(String horaE,String horaS,String dia) {
        super();
        this.sisContrato = new ValueHolder();
    }

    public String getHoraEntrada() {
        return this.horaEntrada;
    }

    public String getHoraSalida() {
        return this.horaSalida;
    }

    public Long getIdContrato() {
        return this.idContrato;
    }

    public String getIdDia() {
        return this.idDia;
    }

    public SisContrato getSisContrato() {
        return (SisContrato)this.sisContrato.getValue();
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
        
        
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public void setIdDia(String idDia) {
        this.idDia = idDia;
    }

    public void setSisContrato(SisContrato sisContrato) {
        this.sisContrato.setValue(sisContrato);
    }

}
