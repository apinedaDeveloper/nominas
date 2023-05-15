package enlace_datos.tablas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SisEmpleado {

    /**Map sisDireccionCollection <-> enlace_datos.tablas.SisDireccion
     * @associates <{enlace_datos.tablas.SisDireccion}>
     */
    private List sisDireccionCollection;
    private List sisAjusteEmpleadoCollection;
    private Long registroEmpleado;
    private Integer idNivel = 2;
    private Integer idEstado = 2;
    private Integer idNacionalidad;
    private String apellido1;
    private String apellido2;
    private String apellidocasada;
    private String nombre1;
    private String nombre2;
    private String nombre3;
    private String estadocivil;
    private String genero;
    private Date fechaNacimiento;
    private String ordenCedula;
    private Long registroCedula;
    private Integer municipioCedula;
    private String nit;
    private String igss;
    private String telCasa;
    private String celular;
    private String fax;
    private String email;
    private String titulo;
    private String colegiado;


    public SisEmpleado() {
        super();
        this.sisDireccionCollection = new ArrayList();
        this.sisAjusteEmpleadoCollection = new ArrayList();
    }

    public void addSisDireccion(SisDireccion aSisDireccion) {
        this.sisDireccionCollection.add(aSisDireccion);
        aSisDireccion.setSisEmpleado(this);
    }

    public void addSisDireccion(int index, SisDireccion aSisDireccion) {
        this.sisDireccionCollection.add(index, aSisDireccion);
        aSisDireccion.setSisEmpleado(this);
    }

    public void addSisAjusteEmpleado(int index, 
                                     SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.add(index, aSisAjusteEmpleado);
        aSisAjusteEmpleado.setSisEmpleado(this);
    }
	
    public void addSisAjusteEmpleado(SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.add(aSisAjusteEmpleado);
        aSisAjusteEmpleado.setSisEmpleado(this);
    }
	
    public String getApellido1() {
        return this.apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public String getApellidocasada() {
        return this.apellidocasada;
    }

    public String getCelular() {
        return this.celular;
    }

    public String getColegiado() {
        return this.colegiado;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEstadocivil() {
        return this.estadocivil;
    }

    public String getFax() {
        return this.fax;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public String getGenero() {
        return this.genero;
    }

    public Integer getIdEstado() {
        return this.idEstado == null ? 2 : this.idEstado;
    }

    public Integer getIdNivel() {
        return this.idNivel == null ? 2 : this.idNivel;
    }

    public Integer getIdNacionalidad() {
        return this.idNacionalidad;
    }


    public String getIgss() {
        return this.igss;
    }

    public Integer getMunicipioCedula() {
        return this.municipioCedula;
    }

    public String getNit() {
        return this.nit;
    }

    public String getNombre1() {
        return this.nombre1;
    }

    public String getNombre2() {
        return this.nombre2;
    }

    public String getNombre3() {
        return this.nombre3;
    }

    public String getOrdenCedula() {
        return this.ordenCedula;
    }

    public Long getRegistroCedula() {
        return this.registroCedula;
    }

    public Long getRegistroEmpleado() {
        return this.registroEmpleado;
    }

    public List<SisDireccion> getSisDireccionCollection() {
        return this.sisDireccionCollection;
    }

    public List<SisAjusteEmpleado> getSisAjusteEmpleadoCollection() {
        return this.sisAjusteEmpleadoCollection;
    }
	
    public String getTelCasa() {
        return this.telCasa;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void removeSisDireccion(SisDireccion aSisDireccion) {
        this.sisDireccionCollection.remove(aSisDireccion);
        aSisDireccion.setSisEmpleado(null);
    }

    public void removeSisAjusteEmpleado(SisAjusteEmpleado aSisAjusteEmpleado) {
        this.sisAjusteEmpleadoCollection.remove(aSisAjusteEmpleado);
    }
	
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setApellidocasada(String apellidocasada) {
        this.apellidocasada = apellidocasada;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }


    public void setIgss(String igss) {
        this.igss = igss;
    }

    public void setMunicipioCedula(Integer municipioCedula) {
        this.municipioCedula = municipioCedula;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public void setOrdenCedula(String ordenCedula) {
        this.ordenCedula = ordenCedula;
    }

    public void setRegistroCedula(Long registroCedula) {
        this.registroCedula = registroCedula;
    }

    public void setRegistroEmpleado(Long registroEmpleado) {
        this.registroEmpleado = registroEmpleado;
    }

    public void setSisDireccionCollection(List<SisDireccion> sisDireccionCollection) {
        this.sisDireccionCollection = sisDireccionCollection;
    }
	
    public void setSisAjusteEmpleadoCollection(List<SisAjusteEmpleado> sisAjusteEmpleadoCollection) {
        this.sisAjusteEmpleadoCollection = sisAjusteEmpleadoCollection;
        
        SisAjuste v_Ajuste;
        List<SisAjusteEmpleado> vAjusteEmpleados;
        SisAjusteEmpleado vAjuste;
        
        vAjusteEmpleados=this.getSisAjusteEmpleadoCollection();
        for (Iterator iter=vAjusteEmpleados.iterator();iter.hasNext();){
            vAjuste=(SisAjusteEmpleado)iter.next();
            v_Ajuste=vAjuste.getSisAjuste();
            vAjuste.setnombreAjuste(v_Ajuste.getNombre());
            //ajustes.add(pru3);
        }
        
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
