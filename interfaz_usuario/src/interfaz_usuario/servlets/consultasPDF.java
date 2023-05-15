package interfaz_usuario.servlets;

public class consultasPDF {
    /*
     * plazas de tesorero
     */ 
    public static String vConsultaPlazaTeso [] ={
    "select c.id_dependencia,d.id_unidad,b.id_renglon,i.nombre as nomRenglon,c.nombre as nomDep,d.nombre as nomUnidad,b.formato2,e.id_puesto,e.nombre,a.numero_plaza,cantidad_horas,salario_base,a.escalafon,a.complemento_sal,disponible,fecha_inicio,fecha_fin,decode(periodo_plaza,'A','ANUAL','S','SEMESTRAL') AS REGIMEN \n" + 
    "from sis_plaza a, sis_partida_vw b, sis_dependencia c, sis_unidad_ejecutora d, sis_puesto e ,sis_Renglon i,partida prt\n" + 
    "where a.id_partida=b.id_partida \n" + 
    "and prt.id_partida=b.id_partida \n" +
    "and c.id_dependencia=b.id_dependencia\n" + 
    "and d.id_programa=b.id_programa\n" + 
    "and d.id_dependencia=b.id_dependencia\n" + 
    "and d.id_unidad=b.id_unidad\n" + 
    "and e.id_puesto=a.id_puesto\n" + 
    "and i.id_renglon=b.id_renglon\n" + 
    "and a.correlativo=?\n" + 
    "and\n" + 
    "exists(\n" + 
    "select 1 from usuario_unidad b, partida c\n" + 
    "where b.id_partida=c.id_partida\n" + 
    "and usuario=? and usuario=? \n" + 
    "and b.tipo_usuario='TRABAJADOR'\n" + 
    "and sysdate between b.vigencia_de and nvl(b.vigencia_a,sysdate)\n" + 
    "and prt.aniomanual=c.aniomanual\n" + 
    "and prt.d1=c.d1\n" + 
    "and prt.d2=c.d2\n" + 
    "and prt.d3d4=c.d3d4\n" + 
    "and \n" + 
    "(\n" + 
    "(\n" + 
    "prt.d7=c.d7\n" + 
    "and prt.d6=c.d6\n" + 
    "and prt.d5=c.d5\n" + 
    ")\n" + 
    "or\n" + 
    "(\n" + 
    "c.d5 is null\n" + 
    "and c.d6 is null\n" + 
    "and c.d7 is null \n" + 
    ")\n" + 
    ")\n" + 
    ")\n"
    ,
    " and formato1=? "
    ,
    " and numero_plaza=? "
    ,
    " and formato1=?  and numero_plaza=? "
    ,
    " and b.id_dependencia=?"
    ,
    " order by b.id_programa,b.id_dependencia,b.id_unidad,b.id_renglon asc,numero_plaza asc"};

    /*
     * plazas de tesorero por partida
     */ 
    public static String vConsultaPlazaTesoAper[]={
    "select Case When Extract(year from a.fecha_inicio) < 2017\n" + 
    "        Then 0 Else 1 End AnioActual, Case When Extract(year from a.fecha_inicio) < 2017\n" + 
    "  Then To_Char(a.registro_empleado)\n" + 
    "  Else decode(se.cui,null,'0',Trim(To_Char(se.cui,'9999G99999G9999','NLS_NUMERIC_CHARACTERS= '', ''')))\n" + 
    "  End Reg_CUI, c.id_dependencia,\n" + 
    "d.id_unidad,\n" + 
    "b.id_renglon,\n" + 
    "i.nombre as nomRenglon,\n" + 
    "c.nombre as nomDep,\n" + 
    "d.nombre as nomUnidad,\n" + 
    "b.formato2,\n" + 
    "e.id_puesto,\n" + 
    "e.nombre,\n" + 
    "a.plaza,\n" + 
    "a.horas_plaza,\n" + 
    "a.salario_base,\n" + 
    "a.escalafon,\n" + 
    "a.compl_salarial,\n" + 
    "a.fecha_inicio,\n" + 
    "a.fecha_fin,\n" + 
    "a.registro_empleado,\n" + 
    "a.meses_duracion as duracion,\n" + 
    "initcap(nvl((select NVL2 (apellido1, ' ' || apellido1, '')||NVL2 (apellido2, ' ' || apellido2, '')||', '||NVL2(nombre1, ' ' || nombre1, '')||NVL2 (nombre2, ' ' || nombre2, '')as nombrecompleto from sis_empleado_vw empl where empl.registro_empleado=a.registro_empleado),'PLAZA VACANTE')) as NomEmpl,\n" + 
    "a.salario_base+a.escalafon+a.compl_salarial as totalmensual,\n" + 
    "round(a.meses_duracion*(a.salario_base+a.escalafon+a.compl_salarial),2) as totalAnual\n" + 
    "from sis_archivo_apertura a, sis_partida_vw b, sis_dependencia c, sis_unidad_ejecutora d, sis_puesto e ,sis_Renglon i, partida prt, sis_empleado se \n" + 
    "where a.id_partida=b.id_partida and a.registro_empleado=se.registro_empleado\n" + 
    "and prt.id_partida=b.id_partida \n" +
    "and c.id_dependencia=b.id_dependencia\n" + 
    "and d.id_programa=b.id_programa\n" + 
    "and d.id_dependencia=b.id_dependencia\n" + 
    "and d.id_unidad=b.id_unidad\n" + 
    "and e.id_puesto=a.puesto\n" + 
    "and i.id_renglon=b.id_renglon\n" + 
    "and a.id_carga_archivo_datos=\n" + 
    "(select max(id_carga_archivo_datos) \n" + 
    "from sis_carga_archivo_datos\n" + 
    "where anio=?\n" + 
    "and error is null" +
    " and id_origen_carga_archivo=1" +
    ")\n " + 
    "and\n" + 
    "exists(\n" + 
    "select 1 from usuario_unidad b, partida c\n" + 
    "where b.id_partida=c.id_partida\n" + 
    "and usuario=? and usuario=? \n" + 
    "and b.tipo_usuario='TRABAJADOR'\n" + 
    "and sysdate between b.vigencia_de and nvl(b.vigencia_a,sysdate)\n" + 
    "and prt.aniomanual=c.aniomanual\n" + 
    "and prt.d1=c.d1\n" + 
    "and prt.d2=c.d2\n" + 
    "and prt.d3d4=c.d3d4\n" + 
    "and \n" + 
    "(\n" + 
    "(\n" + 
    "prt.d7=c.d7\n" + 
    "and prt.d6=c.d6\n" + 
    "and prt.d5=c.d5\n" + 
    ")\n" + 
    "or\n" + 
    "(\n" + 
    "c.d5 is null\n" + 
    "and c.d6 is null\n" + 
    "and c.d7 is null \n" + 
    ")\n" + 
    ")\n" + 
    ")\n"
    ,
    " and formato1=? "
    ,
    " and plaza = ? "
    ,
    " and formato1=? and plaza = ? "
    , 
    " and b.id_dependencia=?"
    ,
    " order by b.id_programa,b.id_dependencia,b.id_unidad,b.id_renglon asc,plaza asc\n"
    };
    
    /*
     * listado de palazas vinculada con SICOIN
     */ 
    public static String vConsultaPlazaTesoSICOIN [] ={
    "SELECT DISTINCT  (select formato2 from sis_partida_vw where id_partida = pl.id_partida) codigo_siif, u.unidad_ejecutora id_unidad, u.nombre_unidad_ejecutora nomUnidad, s.renglon id_renglon, rn.nombre nomRenglon\n" 
+", pl.id_partida, pl.id_puesto, pl.numero_plaza, pl.correlativo, pl.salario_base, pl.complemento_sal, pl.escalafon, pl.fecha_inicio, pl.fecha_Fin\n" 
+", pl.cantidad_horas, pl.disponible, decode(periodo_plaza,'A','ANUAL','S','SEMESTRAL') AS REGIMEN\n" 
+", e.id_puesto, e.nombre\n" 
+", ?||'.'||s.partida formato_partida_sicoin\n" 
+"FROM SIS_PLAZA PL\n" 
+"INNER JOIN SICOIN_PARTIDA_EGRESOS_VIEW s on s.id_partida_egresos = pl.id_partida_sicoin\n" 
+"inner join SICOIN_UNIDAD_EJECUTORA u on u.unidad_ejecutora = s.unidad_ejecutora\n" 
+"inner join  sis_puesto e on e.id_puesto = pl.id_puesto\n" 
+"inner join sis_renglon rn on rn.id_renglon = s.renglon \n" 
+"inner join partida pt on pt.id_partida = pl.id_partida\n" 
+"where pl.correlativo = ?\n" 
+"and exists(\n" 
+"select 1 from usuario_unidad b, partida c\n" 
+"where b.id_partida=c.id_partida\n" 
+"and usuario=?\n" 
+"and b.tipo_usuario='TRABAJADOR'\n" 
+"and sysdate between b.vigencia_de and nvl(b.vigencia_a,sysdate)\n" 
+"and pt.aniomanual=c.aniomanual\n" 
+"and pt.d1=c.d1\n" 
+"and pt.d2=c.d2\n" 
+"and pt.d3d4=c.d3d4\n" 
+"and \n" 
+"(  (pt.d7=c.d7\n" 
+"and pt.d6=c.d6\n" 
+"and pt.d5=c.d5\n" 
+") or (\n" 
+"c.d5 is null\n" 
+"and c.d6 is null\n" 
+"and c.d7 is null \n" 
+") ) )"
    ,
    " and pt.d3d4=?"
  };
  
    public static String vConsultaHISTSAL [] ={
    "select registro_empleado,nombrecompleto,cui,partida1,partida2,numero_plaza,tipoNomina,id_proceso, nombreProceso,periodo, \n" + 
    "nominal,total_bono,num_doc_fisico,nombreBanco,to_char(fecha_anulacion,'DD/MM/YYYY') fecha_anulacion,\n" + 
    "--, (select id_doc_pago_anulado from sis_doc_pago_anulado where no_doc_fisico = num_doc_fisico and anulado<>1) sis_21     --SUBQUERY ORIGINAL\n" + 
    "(select id_doc_pago_anulado from sis_doc_pago_anulado where no_doc_fisico = num_doc_fisico and anulado<>1 and id_doc_pago=id_documento_banco) sis_21     --CAMBIO REALIZADO 20-04-2020, Rolando Anona\n" + 
    ", datos.nombre,nomCategoria,nomNivel,nomTipo,datos.id_programa,datos.id_dependencia,datos.id_unidad,datos.id_renglon,\n" + 
    "id_nomina,id_tipo_nomina,anio,datos.d8,datos.d9d10,datos.id_periodo,id_documento_banco,id_puesto,datos.D1D2,id_estado,to_char(fecha_emision,'DD/MM/YYYY') fecha_emision,\n" + 
    "correlativo,codigoNomina,req_prof,catepuesto,nivelpuesto,NOM_SERVICIO,sueldo_base,escalafon,compl_salarial\n" + 
    ",subprog,unie.nombre as nomsubprog,tipoproceso\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '01' group by cod_nomina),0) as dsc1\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '02' group by cod_nomina),0) as dsc2\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '03' group by cod_nomina),0) as dsc3\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '04' group by cod_nomina),0) as dsc4\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '05' group by cod_nomina),0) as dsc5\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '06' group by cod_nomina),0) as dsc6\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '07' group by cod_nomina),0) as dsc7\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '08' group by cod_nomina),0) as dsc8\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '09' group by cod_nomina),0) as dsc9\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '10' group by cod_nomina),0) as dsc10\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '11' group by cod_nomina),0) as dsc11\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '12' group by cod_nomina),0) as dsc12\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '13' group by cod_nomina),0) as dsc13\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '14' group by cod_nomina),0) as dsc14\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '15' group by cod_nomina),0) as dsc15\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '16' group by cod_nomina),0) as dsc16\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '17' group by cod_nomina),0) as dsc17\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '18' group by cod_nomina),0) as dsc18\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '19' group by cod_nomina),0) as dsc19\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '20' group by cod_nomina),0) as dsc20\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '21' group by cod_nomina),0) as dsc21\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '22' group by cod_nomina),0) as dsc22\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '23' group by cod_nomina),0) as dsc23\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '24' group by cod_nomina),0) as dsc24\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '25' group by cod_nomina),0) as dsc25\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '26' group by cod_nomina),0) as dsc26\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '27' group by cod_nomina),0) as dsc27\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '28' group by cod_nomina),0) as dsc28\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '29' group by cod_nomina),0) as dsc29\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '30' group by cod_nomina),0) as dsc30\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '31' group by cod_nomina),0) as dsc31\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '32' group by cod_nomina),0) as dsc32\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '33' group by cod_nomina),0) as dsc33\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '34' group by cod_nomina),0) as dsc34\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '35' group by cod_nomina),0) as dsc35\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '36' group by cod_nomina),0) as dsc36\n" + 
    "  , nvl((select  sum(abs(sis_det_calculo_ajuste.VALOR_APLICADO)) as valor from sis_det_calculo_ajuste  inner join sis_ajuste on sis_det_calculo_ajuste.ID_AJUSTE=sis_ajuste.ID_AJUSTE where  sis_det_calculo_ajuste.VALOR_APLICADO<0  and sis_det_calculo_ajuste.id_nomina=datos.id_nomina and sis_ajuste.COD_NOMINA = '37' group by cod_nomina),0) as dsc37\n" + 
    ", genero, id_contrato, formaObtPuesto, total_descuento, liquido,\n" + 
    " nombreabr as nomTipoDoc\n" + 
    "from\n" + 
    "(\n" + 
    "select \n" + 
    "a.registro_empleado,\n" + 
    "a.nombrecompleto,\n" + 
    "a.cui,\n" + 
    "d.formato2 as partida1,\n" + 
    "m.formato as partida2,\n" + 
    "c.numero_plaza,\n" + 
    "o.nombre as tipoNomina,\n" + 
    "p.nombre as periodo, \n" + 
    "c.nominal,\n" + 
    "c.total_bono,\n" + 
    "i.num_doc_fisico,\n" + 
    "j.nombre as nombreBanco,\n" + 
    "i.fecha_anulacion,\n" + 
    "       Case when e.id_puesto in (999990,999994,999999) \n" + 
    "	Then Decode(contr.nom_plaza,null,'',InitCap(contr.nom_plaza))||' F. C.'\n" + 
    "        Else e.nombre\n" + 
    "       End as nombre,\n" + 
    "f.nombre as nomCategoria,\n" + 
    "g.nombre as nomNivel,\n" + 
    "g.tipo as nomTipo,\n" + 
    "d.id_programa,\n" + 
    "d.id_dependencia,\n" + 
    "d.id_unidad,\n" + 
    "d.id_renglon,\n" + 
    "c.id_nomina,\n" + 
    "c.id_tipo_nomina,\n" + 
    "c.anio,\n" + 
    "m.d8,\n" + 
    "m.d9d10,\n" + 
    "c.periodo as id_periodo,\n" + 
    "i.id_documento_banco,\n" + 
    "e.id_puesto,\n" + 
    "m.d1||m.d2 as D1D2,\n" + 
    "i.id_estado,\n" + 
    "i.fecha_emision,\n" + 
    "nvl(c.anio_periodo,c.correlativo) as correlativo,\n" + 
    "(\n" + 
    "select codigo from\n" + 
    "sis_tiponomina_periodo tnp\n" + 
    "where tnp.id_tipo_nomina=c.id_tipo_nomina\n" + 
    "and tnp.ID_PERIODO=c.periodo\n" + 
    "and rownum<=1\n" + 
    ") as codigoNomina,\n" + 
    "decode(e.REQ_PROF,1,'SI',0,'NO') as req_prof,\n" + 
    "f.NOMBRE as catepuesto,\n" + 
    "g.NOMBRE as nivelpuesto,\n" + 
    "tsp.NOM_SERVICIO,\n" + 
    "c.sueldo_base,\n" + 
    "c.escalafon,\n" + 
    "c.compl_salarial,\n" + 
    "case when c.id_partida_egreso is not null and parte.d9d10 in (41,42) then\n" + 
    "    to_char(parte.d1)||to_char(parte.d2)||trim(to_char(parte.d3d4,'00'))||to_char(parte.d5)||to_char(parte.d6)||to_char(parte.d7) else to_char(d.id_programa)||trim(to_char(d.id_dependencia,'00'))||to_char(id_unidad) end as subprog,\n" + 
    "prc.tipoproceso,\n" + 
    "prc.id_proceso,\n" + 
    "decode(a.genero,'N','',a.genero) as genero,\n" + 
    "contr.id_contrato,\n" + 
    "fobt.nombre as formaObtPuesto,\n" + 
    "c.total_descuento,\n" + 
    "c.liquido,\n" + 
    "tipdoc.nombreabr,\n" + 
    "tproc.nombre nombreProceso,\n" + 
    "c.id_partida partia_nom\n" + 
    "from\n" + 
    "    sis_empleado_vw a, \n" + 
    "     sis_nomina c left outer join partida parte\n" + 
    "    on c.id_partida_egreso=parte.id_partida\n" + 
    "    left outer join sis_contrato contr\n" + 
    "    on contr.id_contrato=c.id_contrato\n" + 
    "    and exists (\n" + 
    "     select 1 from sis_autorizacion au, sis_autorizacion_det dt\n" + 
    "      where au.id_contrato=contr.id_contrato\n" + 
    "      and dt.id_autorizacion=au.id_autorizacion\n" + 
    "      and dt.id_estado=4\n" + 
    "    )\n" + 
    "    left outer join sis_forma_obt_puesto fobt\n" + 
    "    on fobt.id_forma_obt_puesto=contr.id_forma_obt_puesto, \n" + 
    "    sis_partida_vw d,\n" + 
    "    sis_puesto e\n" + 
    "    left outer join sis_tiposerv_puesto tsp on e.id_tiposerv_puesto=tsp.id_tiposerv_puesto,\n" + 
    "    sis_categoria_puesto f,\n" + 
    "    sis_nivel_puesto g,\n" + 
    "    sis_pago h,\n" + 
    "    sis_documento_banco i,\n" + 
    "    sis_banco j,\n" + 
    "    sis_partida2_vw m,\n" + 
    "    sis_tipo_nomina o,\n" + 
    "    sis_periodo p,\n" + 
    "    sis_proceso prc,\n" + 
    "    sis_tipo_documento tipdoc,\n" + 
    "    sis_tipo_proceso tproc\n" + 
    "where a.registro_empleado=c.registro_empleado\n" + 
    "    and c.id_proceso=prc.id_proceso\n" + 
    "    and prc.tipoproceso = tproc.id_tipoproceso\n" + 
    "    and c.id_partida=d.id_partida\n" + 
    "    and e.id_puesto=c.id_puesto\n" + 
    "    and f.id_categoria=e.id_categoria\n" + 
    "    and g.id_nivel_puesto=f.id_nivel_puesto\n" + 
    "    and h.id_nomina=c.id_nomina\n" + 
    "    and c.id_tipo_nomina<>20\n" + 
    "    and h.id_documento_banco=i.id_documento_banco\n" + 
    "    and j.id_banco=i.id_banco\n" + 
    "    and m.id_partida=nvl(c.id_partida_egreso,(select part.id_partida from sis_det_partida_pago det,partida part where det.id_documento_banco=i.id_documento_banco and part.id_partida=det.id_partida and part.d9d10 not in (76,12,17,24) and rownum<=1))\n" + 
    "    and c.periodo=p.id_periodo\n" + 
    "    and c.id_tipo_nomina=o.id_tipo_nomina\n" + 
    "    and tipdoc.id_tipo_documento=i.id_tipo_documento\n" + 
    "    and ?<>0 \n" + 
    "    )datos left outer\n" + 
    "     join sis_unidad_ejecutora unie\n" + 
    "     on to_char(unie.id_programa)||trim(to_char(unie.id_dependencia,'00'))||to_char(unie.id_unidad)=datos.subprog\n" + 
    "     inner join partida part on part.id_partida = datos.partia_nom\n" + 
    "where\n" + 
    "  exists(\n" + 
    "  select 1 from usuario_unidad b, partida c, usuario_perfil up\n" + 
    "  where b.id_partida=c.id_partida\n" + 
    "  and up.usuario = b.usuario\n" + 
    "  and b.usuario=?\n" + 
    "  and b.tipo_usuario='TRABAJADOR'\n" + 
    "  and sysdate between b.vigencia_de and nvl(b.vigencia_a,sysdate)\n" + 
    "  and part.aniomanual=c.aniomanual\n" + 
    "  and ( \n" + 
    "         (up.perfil not in ( 'analista_recursos_hum','auditor','coordinador_sueldos','contraloria','coordinador_isr','consulta_histsal_lab') and \n" + 
    "          part.d1=c.d1\n" + 
    "          and part.d2=c.d2\n" + 
    "          and part.d3d4=c.d3d4\n" + 
    "          and \n" + 
    "          (\n" + 
    "          (part.d7=c.d7\n" + 
    "          and part.d6=c.d6\n" + 
    "          and part.d5=c.d5\n" + 
    "          )\n" + 
    "          or\n" + 
    "          (\n" + 
    "          c.d5 is null\n" + 
    "          and c.d6 is null\n" + 
    "          and c.d7 is null \n" + 
    "          )\n" + 
    "          ))\n" + 
    "           or \n" + 
    "          up.perfil in ( 'analista_recursos_hum','auditor','coordinador_sueldos','contraloria','coordinador_isr','consulta_histsal_lab')\n" + 
    "      )\n" + 
    "  )"
    ,
    " and "
    };

    public consultasPDF() {
    }
    
    public static String getConsultaTeso(int vOp){
        String vConsulta;
        int vSize;
        vSize=vConsultaPlazaTeso.length-1;
        
         switch (vOp){
         case 1:
         vConsulta=vConsultaPlazaTeso[0]+vConsultaPlazaTeso[1]+vConsultaPlazaTeso[vSize]; 
         break;
         case 2:
         vConsulta=vConsultaPlazaTeso[0]+vConsultaPlazaTeso[2]+vConsultaPlazaTeso[vSize]; 
         break;
         case 3:
         vConsulta=vConsultaPlazaTeso[0]+vConsultaPlazaTeso[3]+vConsultaPlazaTeso[vSize]; 
         case 4:
         vConsulta=vConsultaPlazaTeso[0]+vConsultaPlazaTeso[4]+vConsultaPlazaTeso[vSize]; 
         break;
         default:
         vConsulta=vConsultaPlazaTeso[0]+vConsultaPlazaTeso[vSize]; 
         break;     
         }
        return vConsulta;
    }
    
    public static String getConsultaTesoAper(int vOp){
        String vConsulta;
        int vSize;
        vSize=vConsultaPlazaTesoAper.length-1;
        
         switch (vOp){
         case 1:
         vConsulta=vConsultaPlazaTesoAper[0]+vConsultaPlazaTesoAper[1]+vConsultaPlazaTesoAper[vSize]; 
         break;
         case 2:
         vConsulta=vConsultaPlazaTesoAper[0]+vConsultaPlazaTesoAper[2]+vConsultaPlazaTesoAper[vSize]; 
         break;
         case 3:
         vConsulta=vConsultaPlazaTesoAper[0]+vConsultaPlazaTesoAper[3]+vConsultaPlazaTesoAper[vSize]; 
         case 4:
         vConsulta=vConsultaPlazaTesoAper[0]+vConsultaPlazaTesoAper[4]+vConsultaPlazaTesoAper[vSize]; 
         break;
         default:
         vConsulta=vConsultaPlazaTesoAper[0]+vConsultaPlazaTesoAper[vSize]; 
         break;     
         }
        return vConsulta;
    }
    
    public static String getConsultaTesoSICOIN(int vOp){
        String vConsulta;
        int vSize;
        vSize=vConsultaPlazaTesoSICOIN.length-1;
        
         switch (vOp){
         case 4:
         vConsulta=vConsultaPlazaTesoSICOIN[0]+vConsultaPlazaTesoSICOIN[1]; 
         break;
         default:
         vConsulta=vConsultaPlazaTesoSICOIN[0]; 
         
         
         break;     
         } 
         
        return vConsulta;
    }
    
    public static String getConsultaHistSal(String vOp){
        String vConsulta="", vWhere = "";
        String [] vVals;     
        String [] vVal;     
        int vSize;
        vSize=vConsultaHISTSAL.length-1;
        
        vVals=vOp.split("\\$");
        
        if (vVals.length > 0){
            vConsulta=vConsultaHISTSAL[0]+vConsultaHISTSAL[1];
        }
              
            for (int i=1; i < vVals.length; i++) {
                vVal = vVals[i].split("\\.");
                vWhere = "";
                
                if (vVal[0].equals("3"))
                    vWhere = "datos.registro_empleado = "+vVal[1];
                else if ((vVal[0].equals("4")))
                    vWhere = "datos.num_doc_fisico = "+vVal[1];
                else if ((vVal[0].equals("6")))
                    vWhere = "datos.id_periodo in "+vVal[1];
                else if ((vVal[0].equals("5")))
                    vWhere = " anio in "+vVal[1];
                else if ((vVal[0].equals("55")))
                    vWhere = " anio = "+vVal[1];
                else if ((vVal[0].equals("7")))
                    vWhere = " datos.id_dependencia in "+vVal[1];
                else if ((vVal[0].equals("2"))){
                    String [] vTempo3;
                    String [] vT;
                    String st = "";
                    vTempo3 = vVal[1].split("_");
                    
                    for (int j=1; j < vTempo3.length; j++) {
                        vT = vTempo3[j].split("\\|");
                        if (j==1)
                            st = "(datos.id_programa="+vT[1] + " and datos.id_dependencia="+vT[2] + " and datos.id_unidad="+vT[3]+")";
                        else   
                            st += " or (datos.id_programa="+vT[1] + " and datos.id_dependencia="+vT[2] + " and datos.id_unidad="+vT[3] +")";
                    } 
                    vWhere = "("+st+")";
                }
                else if ((vVal[0].equals("8")))
                    vWhere = " datos.d1d2 in "+vVal[1];
                else if ((vVal[0].equals("9")))
                    vWhere = " datos.d9d10 in "+vVal[1];
                else if ((vVal[0].equals("10")))
                    vWhere = " datos.id_tipo_nomina in  "+vVal[1] + " and d9d10 not in (0,75,76,72,81)";
                else if ((vVal[0].equals("11")))
                    vWhere = " datos.id_tipo_nomina in "+vVal[1];
                else if ((vVal[0].equals("12")))
                    vWhere = " datos.tipoproceso in "+vVal[1] +" and id_proceso<>101";   
                else if ((vVal[0].equals("13")))
                    vWhere = " exists(select 1 from sis_Det_calculo_ajuste x where x.id_nomina=datos.id_nomina and id_ajuste in "+vVal[1]+ ")"; 
                else if ((vVal[0].equals("14")))
                    vWhere = " datos.id_puesto in "+vVal[1];
                else if ((vVal[0].equals("15")))
                    vWhere = " datos.NomTipo = '"+vVal[1]+"'";   
                else if ((vVal[0].equals("16")))
                    vWhere = " datos.nombrecompleto like '%"+vVal[1]+"%'";
                else if ((vVal[0].equals("17")))
                    vWhere = " datos.cui='"+vVal[1]+"'";
                
                if (vWhere!="" && i==1)
                    vConsulta=vConsulta+vWhere;
                else if (vWhere!="")
                    vConsulta=vConsulta+ " and " + vWhere;
            }
            vConsulta += " order by datos.codigoNomina ASC";
       //  System.out.println(vConsulta);
        return vConsulta;
    }
}
