package enlace_datos.consultas;


import enlace_datos.myException;

import enlace_datos.tablas.SisAjuste;
import enlace_datos.tablas.SisAjusteContrato;
import enlace_datos.tablas.SisAjusteEmpleado;
import enlace_datos.tablas.SisContrato;
import enlace_datos.tablas.SisDiaSemana;
import enlace_datos.tablas.SisDireccion;
import enlace_datos.tablas.SisEmpleado;


import enlace_datos.util.resulOp;
import enlace_datos.util.utils;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;


import oracle.jbo.domain.Number;

import oracle.toplink.exceptions.DatabaseException;
import oracle.toplink.sessions.Session;
import oracle.toplink.sessions.UnitOfWork;
import oracle.toplink.util.SessionFactory;
//import interfaz_usuario.util.util_varios;

import oracle.toplink.sessions.DatabaseRecord;


@Stateless(name="interfaz_top_link")
public class interfaz_top_linkBean implements interfaz_top_linkLocal {
    private SessionFactory sessionFactory;

    public interfaz_top_linkBean() {
        this.sessionFactory = 
                new SessionFactory("META-INF/sessions.xml", "default");
    }

    public Object mergeEntity(Object entity) {
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork();
        Object workingCopy = uow.readObject(entity);
        resulOp vResultado;
        try{
        if (workingCopy == null)
            throw new RuntimeException("Could not find entity to update");
        uow.deepMergeClone(entity);
        uow.commit();
        vResultado=new resulOp(resulOp.OPE_OK,"CONTRATO ACTUALIZADO CORRECTAMENTE");
        }catch(Exception exep){
            vResultado=new resulOp(resulOp.OPE_ERROR,utils.getSQLMensaje(exep));
        }
        return vResultado;
    }

    public Object persistEntity(Object entity) {
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork();
        Object existingObject = uow.readObject(entity);
        if (existingObject != null)
            throw new RuntimeException("Entity already exists");
        Object newInstance = uow.deepMergeClone(entity);
        uow.commit();

        return newInstance;
    }

    public Object refreshEntity(Object entity) {
        Session session = getSessionFactory().acquireSession();
        Object refreshedEntity = session.refreshObject(entity);
        session.release();

        return refreshedEntity;
    }

    public void removeEntity(Object entity) {
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork();
        Object workingCopy = uow.readObject(entity);
        if (workingCopy == null)
            throw new RuntimeException("Could not find entity to update");
        uow.deleteObject(workingCopy);
        uow.commit();
    }

    private SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public List<SisDireccion> findAllSisDireccion() {
        Session session = getSessionFactory().acquireSession();
        List<SisDireccion> results = 
            (List<SisDireccion>)session.executeQuery("findAllSisDireccion", SisDireccion.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisDireccion>)getSessionFactory().detach(results);

        return results;
    }

    public List<SisEmpleado> todos_empleados() {
        Session session = getSessionFactory().acquireSession();
        List<SisEmpleado> results = 
            (List<SisEmpleado>)session.executeQuery("todos_empleados", SisEmpleado.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisEmpleado>)getSessionFactory().detach(results);
        
        return results;
    }

  
    public List<SisEmpleado> empleado_porId(java.lang.Number reg_empleado) {
        Session session = getSessionFactory().acquireSession();
        Vector params = new Vector(1);
        SisDireccion direc;
        params.add(reg_empleado);
        List<SisEmpleado> results = 
            (List<SisEmpleado>)session.executeQuery("empleado_porId", 
                                                    SisEmpleado.class, params);
        session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisEmpleado>)getSessionFactory().detach(results);
        //Si no se encuentra el empleado por registro_empleado crea un nuevo empleado
         if (results.size()<=0){
           results.add(new SisEmpleado());       
         }
           
           // Si el empleado no tiene una direccion le crea una por default
           if (results.get(0).getSisDireccionCollection().size()==0){
               direc=new SisDireccion();
               direc.setIdMunicipio(new Long(1));
               results.get(0).addSisDireccion(direc);
           }
           
        return results;
    }

    public String guardar_empleado(Object empleado) {
        
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork();
        String reg_empleado;
        //Object workingCopy = uow.readObject(entity);
        //uow.
      //  if (workingCopy == null)
      //      throw new RuntimeException("Could not find entity to update");
        uow.deepMergeClone(empleado);
        uow.commit();

        reg_empleado=String.valueOf(((SisEmpleado)empleado).getRegistroEmpleado() ); 
/*        
        this.mergeEntity(empleado);
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork(); 
        String verificar;
       //SisDepartamento nuevo=(SisDepartamento)uow.newInstance(SisDepartamento.class);
       // nuevo.setNombre("nombre");
        SisEmpleado be=(SisEmpleado)empleado;
        be.setIdNacionalidad(3);
       verificar="nuevo";
       // uow.commit();
  */     
        return reg_empleado;
    }


    public List<SisEmpleado> findAllSisEmpleado() {
        Session session = getSessionFactory().acquireSession();
        List<SisEmpleado> results = 
            (List<SisEmpleado>)session.executeQuery("findAllSisEmpleado", SisEmpleado.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisEmpleado>)getSessionFactory().detach(results);

        return results;
    }

    public List<SisContrato> findAllSisContrato() {
        Session session = getSessionFactory().acquireSession();
        List<SisContrato> results = 
            (List<SisContrato>)session.executeQuery("findAllSisContrato", SisContrato.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisContrato>)getSessionFactory().detach(results);

        return results;
    }



/*
 *  Metodo para la creacion del contrato
 */
    public resulOp crear_contrato(Object contrato, ArrayList parametros) {
        List <SisEmpleado> empleado;
        SisEmpleado vsisEmpleado;
        SisContrato vContrato;
        SisAjusteContrato vAjusteContrato;
        vContrato=(SisContrato)contrato;
        SisAjusteEmpleado vSisAjusteEmpleado;
        resulOp vResultadoOP;
        Long vId_contrato;
        DatabaseRecord vFilaConsulta;
        UnitOfWork uow = getSessionFactory().acquireUnitOfWork();
        try{
       
      
        // Busco si existe el empleado
        empleado=this.empleado_porId(vContrato.getRegistroEmpleado());

        if (empleado.size()>0&&empleado.get(0).getRegistroEmpleado()!=null){
        /*
            vContrato.setRegistroEmpleado(new Long((String)parametros.get(0)));
            vContrato.setIdPartida(util_varios.getInteger(parametros.get(1)));
            vContrato.setIdPuesto(util_varios.getInteger(parametros.get(2)));
            vContrato.setNumeroPlaza(util_varios.getInteger(parametros.get(3)));
            vContrato.setCorrelativo(util_varios.getInteger(parametros.get(4)));
          */
            vsisEmpleado=empleado.get(0);
            vsisEmpleado.setSisAjusteEmpleadoCollection(vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection());
            vContrato.setSisEmpleado(vsisEmpleado);

            // Se obtiene el id del contrato 
            vFilaConsulta=(DatabaseRecord)uow.executeSQL("select sis_pkg_util.GETCODCONTRATO("+vContrato.getIdPartida().toString() +") as IDCONTRATO from dual").get(0);
            vId_contrato=new Long(vFilaConsulta.get("IDCONTRATO").toString());
            vContrato.setIdContrato(vId_contrato);
            
            

            if (vContrato.getSisAjusteContratoCollection().size()>0){

            /*
             *  Colocando la fecha fin de los descuentos obligatorios de contrato
             */
            for (Iterator iter=vContrato.getSisAjusteContratoCollection().iterator();iter.hasNext();){
                vAjusteContrato=(SisAjusteContrato)iter.next();
                vAjusteContrato.setFechaInicio(vContrato.getFechaInicio());
                vAjusteContrato.setFechaFin(vContrato.getFechaFin());
                }
            }

            /*
             *  Colocando la fecha fin de los descuentos obligatorios de empleado
             */
            if (vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection().size()>0){
            for (Iterator iter=vContrato.getSisEmpleado().getSisAjusteEmpleadoCollection().iterator();iter.hasNext();){
                vSisAjusteEmpleado=(SisAjusteEmpleado)iter.next();
                vSisAjusteEmpleado.setFechaInicio(vContrato.getFechaInicio());
                vSisAjusteEmpleado.setFechaFin(vContrato.getFechaFin());
                vSisAjusteEmpleado.setSisEmpleado(vsisEmpleado);
                }
            }


        uow.deepMergeClone(vContrato);
        uow.commit();
        vResultadoOP=new resulOp(resulOp.OPE_OK,"CONTRATO CREADO CORRECTAMENTE"); 
        }else{
            vResultadoOP=new resulOp(resulOp.OPE_ERROR,"EL EMPLEADO NO EXISTE!!"); 
            uow.release();
        }
   
        }catch(Exception excep){
                  uow.release(); 
                  vResultadoOP=new resulOp(resulOp.OPE_ERROR,utils.getSQLMensaje(excep));
                  
        }
        
       return vResultadoOP;
    }

    public List<SisAjuste> findAllSisAjuste() {
        Session session = getSessionFactory().acquireSession();
        List<SisAjuste> results = 
            (List<SisAjuste>)session.executeQuery("findAllSisAjuste", SisAjuste.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisAjuste>)getSessionFactory().detach(results);

        return results;
    }

    public List<SisAjusteContrato> findAllSisAjusteContrato() {
        Session session = getSessionFactory().acquireSession();
        List<SisAjusteContrato> results = 
            (List<SisAjusteContrato>)session.executeQuery("findAllSisAjusteContrato", SisAjusteContrato.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisAjusteContrato>)getSessionFactory().detach(results);

        return results;
    }

    public List<SisAjuste> ajuste_obligatorios() {
        Session session = getSessionFactory().acquireSession();
        List<SisAjuste> results = 
            (List<SisAjuste>)session.executeQuery("ajuste_obligatorios", SisAjuste.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisAjuste>)getSessionFactory().detach(results);

        return results;
    }

    public List<SisContrato> contrato_busqueda(java.lang.Number reg_empleado, 
                                               java.lang.Number numContrato) {
        Session session = getSessionFactory().acquireSession();
        Vector params = new Vector(2);
        params.add(reg_empleado);
        params.add(numContrato);
        List<SisContrato> results = 
            (List<SisContrato>)session.executeQuery("contrato_busqueda", 
                                                    SisContrato.class, params);
        session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisContrato>)getSessionFactory().detach(results);

        return results;
    }


    public List<SisContrato> contrato_by_id(java.lang.Number numContrato) {
        Session session = getSessionFactory().acquireSession();
        Vector params = new Vector(1);
        List <SisDiaSemana>listaDiasSemana;
        SisDiaSemana vDia;
        params.add(numContrato);
        List<SisContrato> results = 
            (List<SisContrato>)session.executeQuery("contrato_by_id", 
                                                    SisContrato.class, params);
        session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisContrato>)getSessionFactory().detach(results);
        
        if (results.size()<=0){
        SisContrato contrato=new SisContrato();
        contrato.setSisEmpleado(new SisEmpleado());
        results.add(contrato);
        }
        
        /*
         * Obteniendo los nombres de la semana
         */
          listaDiasSemana=this.findAllSisDiaSemana();
          for (Iterator iter=listaDiasSemana.iterator();iter.hasNext();){
             vDia=(SisDiaSemana)iter.next();
             results.get(0).addNombreDia(vDia.getIdDia(),vDia.getNombre());
          }
        
        return results;
    }

    public List<SisAjusteEmpleado> findAllSisAjusteEmpleado() {
        Session session = getSessionFactory().acquireSession();
        List<SisAjusteEmpleado> results = 
            (List<SisAjusteEmpleado>)session.executeQuery("findAllSisAjusteEmpleado", SisAjusteEmpleado.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisAjusteEmpleado>)getSessionFactory().detach(results);

        return results;
    }

    
    public List<SisAjuste> ajuste_oblig_contrato(Number programa, 
                                                 Number dependencia, 
                                                 Number unidad, 
                                                 Number salario, 
                                                 Number horas) {
        Session session = getSessionFactory().acquireSession();
        Vector params = new Vector(5);
        params.add(programa);
        params.add(dependencia);
        params.add(unidad);
        params.add(salario==null?new oracle.jbo.domain.Number(0):salario);
        params.add(horas==null?new oracle.jbo.domain.Number(0):horas);
        
        //params.add(salario==null? new oracle.jbo.domain.Number(0):salario);
        //params.add(horas==null?new oracle.jbo.domain.Number(0):horas);
        List<SisAjuste> results = 
            (List<SisAjuste>)session.executeQuery("ajuste_oblig_contrato", 
                                                  SisAjuste.class, params);
        session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisAjuste>)getSessionFactory().detach(results);

        return results;
    }


    public List<SisDiaSemana> findAllSisDiaSemana() {
        Session session = getSessionFactory().acquireSession();
        List<SisDiaSemana> results = 
            (List<SisDiaSemana>)session.executeQuery("findAllSisDiaSemana", SisDiaSemana.class);session.release();
        // The following lines of code are required if the results from this query will be mutated.
        // See SessionFactory.detach() for more information.
        results = (List<SisDiaSemana>)getSessionFactory().detach(results);
        return results;
    }
}
