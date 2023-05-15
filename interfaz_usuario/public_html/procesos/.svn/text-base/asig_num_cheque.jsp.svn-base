<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/webcache" prefix="afc"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces" prefix="af"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/html" prefix="afh"%>
<f:loadBundle basename="propiedades" var="txt"/>
<f:view>
  <afh:html>
    <afh:head title="#{txt[\'gen_pago.title\']}">
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
    </afh:head>
    <afh:body>
      <af:messages/>
      <h:form>
        <af:page title="#{txt[\'asig_num_cheque.title\']}"
            value="#{modeloMenu.modeloBD}" var="node">
            <f:facet name="nodeStamp">
              <af:commandMenuItem text="#{node.label}"
                                  action="#{node.getOutcome}"/>
            </f:facet>
          <f:facet name="infoUser">
              <f:subview id="info1">
                <jsp:include page="/global/facet_infoUser.jspx"/>
              </f:subview>
            </f:facet>
             <f:facet name="menuSwitch">
              <f:subview id="menuSwt">
                <jsp:include page="/global/facet_menuSwitch.jspx"/>
              </f:subview>
            </f:facet>
            <f:facet name="branding">
              <f:subview id="logo">
                <jsp:include page="/global/facet_branding.jspx"/>
              </f:subview>
            </f:facet>
          <af:panelHorizontal halign="center">
            <af:panelBox>
              <af:panelHorizontal>
                <af:selectOneChoice value="#{bindings[\'asignacion_num_cheque1IdBanco\'].inputValue}"
                                    label="#{txt[\'asig_num_cheque.idBanco.cmb\']}"
                                    binding="#{asig_num_cheque.combo_banco}"
                                    required="true"
                                    partialTriggers="btn_crear_detalle">
                  <f:selectItems value="#{bindings[\'asignacion_num_cheque1IdBanco\'].items}"/>
                </af:selectOneChoice>
                <af:commandButton text="Asignar Banco"
                                  action="#{asig_num_cheque.btn_asignarBanco}"/>
              </af:panelHorizontal>
              <af:panelHeader text="#{txt[\'asig_num_cheque.pnl_header1.texto\']}">
                <af:table value="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].collectionModel}"
                          var="row"
                          rows="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].rangeSize}"
                          first="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].rangeStart}"
                          emptyText="Ningun rango"
                          selectionState="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].collectionModel.selectedRow}"
                          selectionListener="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].collectionModel.makeCurrent}"
                          partialTriggers="btn_crear_detalle btn_borrar_rango"
                          id="tbl_rangos">
                  <f:facet name="selection">
                    <af:tableSelectOne text="Select and" autoSubmit="true"/>
                  </f:facet>
                  <af:column sortProperty="NumChequeInicial" sortable="false"
                             headerText="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].labels.NumChequeInicial}">
                    <af:inputText value="#{row.NumChequeInicial}"
                                  required="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].attrDefs.NumChequeInicial.mandatory}"
                                  columns="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].attrHints.NumChequeInicial.displayWidth}">
                      <f:convertNumber groupingUsed="false"
                                       pattern="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].formats.NumChequeInicial}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortProperty="NumChequeFin" sortable="false"
                             headerText="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].labels.NumChequeFin}">
                    <af:inputText value="#{row.NumChequeFin}"
                                  required="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].attrDefs.NumChequeFin.mandatory}"
                                  columns="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].attrHints.NumChequeFin.displayWidth}">
                      <f:convertNumber groupingUsed="false"
                                       pattern="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].formats.NumChequeFin}"/>
                    </af:inputText>
                  </af:column>
                  <af:column sortable="false" headerText="Numero Inventario">
                    <af:inputText value="#{row.NumInventario}" columns="10">
                    <f:convertNumber groupingUsed="false"
                                       pattern="#{bindings[\'asignacion_num_cheque1detalle_asig_cheque2\'].formats.NumInventario}"/>
                    </af:inputText>
                  </af:column>
                </af:table>
                <af:objectSpacer width="10" height="20"/>
                <af:panelButtonBar id="pnl_botones">
                  <af:commandButton text="#{txt[\'asig_num_cheque.btn_crear\']}"
                                    disabled="false"
                                    binding="#{asig_num_cheque.btn_crear_cheque}"
                                    id="btn_crear_detalle"
                                    partialSubmit="true"
                                    action="#{asig_num_cheque.btn_crear_detalle_action}"/>
                  <af:commandButton text="#{txt[\'asig_num_cheque.btn_borrar\']}"
                                    binding="#{asig_num_cheque.btn_guardar_det}"
                                    actionListener="#{bindings.Delete.execute}"
                                    partialSubmit="true" id="btn_borrar_rango"/>
                  <af:commandButton text="#{txt[\'asig_num_cheque.btn_cancelar\']}"
                                    disabled="#{!bindings.Rollback.enabled}"
                                    immediate="true"
                                    action="#{asig_num_cheque.btn_cancelar}">
                    <af:resetActionListener/>
                  </af:commandButton>
                  <af:commandButton text="#{txt[\'asig_num_cheque.btn_sig.text\']}" action="op_detalle_proc_pago"/>
                </af:panelButtonBar>
                <af:objectSpacer width="10" height="20"/>
              </af:panelHeader>
            </af:panelBox>
          </af:panelHorizontal>
        </af:page>
      </h:form>
    </afh:body>
  </afh:html>
</f:view>
<%-- 
  oracle-jdev-comment:preferred-managed-bean-name:asig_num_cheque
--%>