package interfaz_usuario.backing.reportes.dts;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Cheque {
    private BigDecimal ID_DOCUMENTO_BANCO;
    private BigDecimal NUM_DOC_FISICO;
    private BigDecimal VALOR;
    private String VALTEXTO;
    private Timestamp FECHA_EMISION;
    private String NOMCOMPLETOCHEQ;
    private BigDecimal REGISTRO_EMPLEADO;
    private String NOMDEPENDENCIA;
    private String PARTIDAUNIDAD;
    private String NOMINA;
    private Timestamp FECHA_REF;
    private BigDecimal TOTAL_NOMINAL;
    private BigDecimal TOTAL_BONO;
    private BigDecimal TOTAL_DESC;
    private String CLV;
    private BigDecimal NUM_INVENTARIO;
    private BigDecimal ANIOISR;
    private BigDecimal ASCHEQUEISR;
    private ArrayList vPlazas;
    private ArrayList vDesc;

    public Cheque() {
    vPlazas = new ArrayList();
    vDesc= new ArrayList();
    }

   public void addDesc(String pCodNomina, BigDecimal pValor){
   
     desc_cheque descuento=new desc_cheque();     
     descuento.setCOD_NOMINA(pCodNomina);
     descuento.setVALOR(pValor);
     
     vDesc.add(descuento); 
       
       
   }

    public void addPlaza(String  pPartidaPAgo,String pPartida, String pNumeroPlaza, String pNomPuesto,BigDecimal pNominal,String pNomina){
    
      plazas_cheque vPlaza=new plazas_cheque();  
      vPlaza.setPARTIDAPAGO(pPartidaPAgo);
      vPlaza.setFORMATO1(pPartida);
      vPlaza.setNUMERO_PLAZA(pNumeroPlaza);
      vPlaza.setNOMPUESTO(pNomPuesto);
      vPlaza.setNOMINAL(pNominal);
      vPlaza.setNOMINA(pNomina);      
      vPlazas.add(vPlaza);
        
    }

    public void setID_DOCUMENTO_BANCO(BigDecimal iD_DOCUMENTO_BANCO) {
        this.ID_DOCUMENTO_BANCO = iD_DOCUMENTO_BANCO;
    }

    public BigDecimal getID_DOCUMENTO_BANCO() {
        return ID_DOCUMENTO_BANCO;
    }

    public void setNUM_DOC_FISICO(BigDecimal nUM_DOC_FISICO) {
        this.NUM_DOC_FISICO = nUM_DOC_FISICO;
    }

    public BigDecimal getNUM_DOC_FISICO() {
        return NUM_DOC_FISICO;
    }

    public void setVALOR(BigDecimal vALOR) {
        this.VALOR = vALOR;
    }

    public BigDecimal getVALOR() {
        return VALOR;
    }

    public void setVALTEXTO(String vALTEXTO) {
        this.VALTEXTO = vALTEXTO;
    }

    public String getVALTEXTO() {
        return VALTEXTO;
    }

    public void setFECHA_EMISION(Timestamp fECHA_EMISION) {
        this.FECHA_EMISION = fECHA_EMISION;
    }

    public Timestamp getFECHA_EMISION() {
        return FECHA_EMISION;
    }

    public void setNOMCOMPLETOCHEQ(String nOMCOMPLETOCHEQ) {
        this.NOMCOMPLETOCHEQ = nOMCOMPLETOCHEQ;
    }

    public String getNOMCOMPLETOCHEQ() {
        return NOMCOMPLETOCHEQ;
    }

    public void setREGISTRO_EMPLEADO(BigDecimal rEGISTRO_EMPLEADO) {
        this.REGISTRO_EMPLEADO = rEGISTRO_EMPLEADO;
    }

    public BigDecimal getREGISTRO_EMPLEADO() {
        return REGISTRO_EMPLEADO;
    }

    public void setNOMDEPENDENCIA(String nOMDEPENDENCIA) {
        this.NOMDEPENDENCIA = nOMDEPENDENCIA;
    }

    public String getNOMDEPENDENCIA() {
        return NOMDEPENDENCIA;
    }

    public void setPARTIDAUNIDAD(String pARTIDAUNIDAD) {
        this.PARTIDAUNIDAD = pARTIDAUNIDAD;
    }

    public String getPARTIDAUNIDAD() {
        return PARTIDAUNIDAD;
    }

    public void setNOMINA(String nOMINA) {
        this.NOMINA = nOMINA;
    }

    public String getNOMINA() {
        return NOMINA;
    }

    public void setFECHA_REF(Timestamp fECHA_REF) {
        this.FECHA_REF = fECHA_REF;
    }

    public Timestamp getFECHA_REF() {
        return FECHA_REF;
    }

    public void setTOTAL_NOMINAL(BigDecimal tOTAL_NOMINAL) {
        this.TOTAL_NOMINAL = tOTAL_NOMINAL;
    }

    public BigDecimal getTOTAL_NOMINAL() {
        return TOTAL_NOMINAL;
    }

    public void setTOTAL_BONO(BigDecimal tOTAL_BONO) {
        this.TOTAL_BONO = tOTAL_BONO;
    }

    public BigDecimal getTOTAL_BONO() {
        return TOTAL_BONO;
    }

    public void setTOTAL_DESC(BigDecimal tOTAL_DESC) {
        this.TOTAL_DESC = tOTAL_DESC;
    }

    public BigDecimal getTOTAL_DESC() {
        return TOTAL_DESC;
    }

    public void setCLV(String cLV) {
        this.CLV = cLV;
    }

    public String getCLV() {
        return CLV;
    }

    public void setNUM_INVENTARIO(BigDecimal nUM_INVENTARIO) {
        this.NUM_INVENTARIO = nUM_INVENTARIO;
    }

    public BigDecimal getNUM_INVENTARIO() {
        return NUM_INVENTARIO;
    }

    public void setANIOISR(BigDecimal aNIOISR) {
        this.ANIOISR = aNIOISR;
    }

    public BigDecimal getANIOISR() {
        return ANIOISR;
    }

    public void setASCHEQUEISR(BigDecimal aSCHEQUEISR) {
        this.ASCHEQUEISR = aSCHEQUEISR;
    }

    public BigDecimal getASCHEQUEISR() {
        return ASCHEQUEISR;
    }
    
    public JRDataSource  getPlazasDS() {
        return new JRBeanCollectionDataSource(this.vPlazas); 
    }
    
    public JRDataSource  getDescDS() {
        return new JRBeanCollectionDataSource(this.vDesc); 
    }
}
