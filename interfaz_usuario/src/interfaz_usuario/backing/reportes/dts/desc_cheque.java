package interfaz_usuario.backing.reportes.dts;

import java.math.BigDecimal;

public class desc_cheque {
   private String COD_NOMINA;
   private BigDecimal VALOR;

    public desc_cheque() {
    }

    public void setCOD_NOMINA(String cOD_NOMINA) {
        this.COD_NOMINA = cOD_NOMINA;
    }

    public String getCOD_NOMINA() {
        return COD_NOMINA;
    }

    public void setVALOR(BigDecimal vALOR) {
        this.VALOR = vALOR;
    }

    public BigDecimal getVALOR() {
        return VALOR;
    }
}
