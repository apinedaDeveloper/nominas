package enlace_datos.consultas;



import enlace_datos.tablas.SisAjuste;
import enlace_datos.tablas.SisAjusteContrato;
import enlace_datos.tablas.SisAjusteEmpleado;
import enlace_datos.tablas.SisContrato;
import enlace_datos.tablas.SisDiaSemana;
import enlace_datos.tablas.SisDireccion;
import enlace_datos.tablas.SisEmpleado;

import enlace_datos.util.resulOp;

import java.util.ArrayList;
import java.util.List;

import java.util.Vector;

import javax.ejb.Local;

import oracle.jbo.domain.Number;


@Local
public interface interfaz_top_linkLocal {
    Object mergeEntity(Object entity);

    Object persistEntity(Object entity);

    Object refreshEntity(Object entity);

    void removeEntity(Object entity);

    List<SisDireccion> findAllSisDireccion();

    List<SisEmpleado> todos_empleados();

    List<SisEmpleado> empleado_porId(java.lang.Number reg_empleado);

    String guardar_empleado(Object empleado);


    List<SisEmpleado> findAllSisEmpleado();

    List<SisContrato> findAllSisContrato();


    resulOp crear_contrato(Object contrato, ArrayList parametros);

    List<SisAjuste> findAllSisAjuste();

    List<SisAjusteContrato> findAllSisAjusteContrato();

    List<SisAjuste> ajuste_obligatorios();

        
    List<SisContrato> contrato_busqueda(java.lang.Number reg_empleado, 
                                        java.lang.Number numContrato);

    List<SisContrato> contrato_by_id(java.lang.Number numContrato);

    List<SisAjusteEmpleado> findAllSisAjusteEmpleado();


    List<SisAjuste> ajuste_oblig_contrato(Number programa, Number dependencia, 
                                          Number unidad, Number salario, 
                                          Number horas);

    List<SisDiaSemana> findAllSisDiaSemana();
}
