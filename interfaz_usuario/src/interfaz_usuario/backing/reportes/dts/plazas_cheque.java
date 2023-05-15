package interfaz_usuario.backing.reportes.dts;

import java.math.BigDecimal;

public class plazas_cheque {
  private String PARTIDAPAGO;
  private String FORMATO1;
  private String NUMERO_PLAZA;
  private String NOMPUESTO;
  private BigDecimal NOMINAL;
  private String NOMINA;

    public plazas_cheque() {
    }

    public void setPARTIDAPAGO(String pARTIDAPAGO) {
        this.PARTIDAPAGO = pARTIDAPAGO;
    }

    public String getPARTIDAPAGO() {
        return PARTIDAPAGO;
    }

    public void setFORMATO1(String fORMATO1) {
        this.FORMATO1 = fORMATO1;
    }

    public String getFORMATO1() {
        return FORMATO1;
    }

    public void setNUMERO_PLAZA(String nUMERO_PLAZA) {
        this.NUMERO_PLAZA = nUMERO_PLAZA;
    }

    public String getNUMERO_PLAZA() {
        return NUMERO_PLAZA;
    }

    public void setNOMPUESTO(String nOMPUESTO) {
        this.NOMPUESTO = nOMPUESTO;
    }

    public String getNOMPUESTO() {
        return NOMPUESTO;
    }

    public void setNOMINAL(BigDecimal nOMINAL) {
        this.NOMINAL = nOMINAL;
    }

    public BigDecimal getNOMINAL() {
        return NOMINAL;
    }

    public void setNOMINA(String nOMINA) {
        this.NOMINA = nOMINA;
    }

    public String getNOMINA() {
        return NOMINA;
    }
}
