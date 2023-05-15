package interfaz_usuario.backing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.math.BigDecimal;

import java.net.URL;
import java.net.URLConnection;

import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlForm;

import oracle.adf.view.faces.component.core.input.CoreInputText;
import oracle.adf.view.faces.component.core.input.CoreSelectOneChoice;
import oracle.adf.view.faces.component.core.layout.CorePanelForm;
import oracle.adf.view.faces.component.core.layout.CoreShowOneRadio;
import oracle.adf.view.faces.component.core.nav.CoreCommandButton;
import oracle.adf.view.faces.component.core.output.CoreMessages;
import oracle.adf.view.faces.component.html.HtmlBody;
import oracle.adf.view.faces.component.html.HtmlHead;
import oracle.adf.view.faces.component.html.HtmlHtml;

import pkg_util_base_datos.interfaz_DB;

import webservices.usacCuenta.USACSoapClient;

public class Pruebax {


    private HtmlHtml html1;
    private HtmlHead head1;
    private HtmlBody body1;
    private HtmlForm form1;
    private CoreMessages messages1;
    private CorePanelForm panelForm1;
    private CoreSelectOneChoice navList1;
    private UISelectItems selectItems1;
    private CoreCommandButton commandButton1;
    private CoreInputText inputText1;
    private CoreInputText txtNumCuenta;
    private CoreInputText txtCedula;
    private CoreInputText txtNombres;
    private CoreInputText txt1erApe;
    private CoreInputText txt2doApe;
    private CoreInputText txtResultado;
    private CoreInputText txtURLresult;
    private CoreInputText txtURLInput;
    private CoreShowOneRadio showOneRadio;

    public void setHtml1(HtmlHtml html1) {
        this.html1 = html1;
    }

    public HtmlHtml getHtml1() {
        return html1;
    }

    public void setHead1(HtmlHead head1) {
        this.head1 = head1;
    }

    public HtmlHead getHead1() {
        return head1;
    }

    public void setBody1(HtmlBody body1) {
        this.body1 = body1;
    }

    public HtmlBody getBody1() {
        return body1;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }


    public void setMessages1(CoreMessages messages1) {
        this.messages1 = messages1;
    }

    public CoreMessages getMessages1() {
        return messages1;
    }


    public String botoi1() {
        // Add event code here...
        return null;
    }


    public void setPanelForm1(CorePanelForm panelForm1) {
        this.panelForm1 = panelForm1;
    }

    public CorePanelForm getPanelForm1() {
        return panelForm1;
    }


    public void setNavList1(CoreSelectOneChoice navList1) {
        this.navList1 = navList1;
    }

    public CoreSelectOneChoice getNavList1() {
        return navList1;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setCommandButton1(CoreCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public CoreCommandButton getCommandButton1() {
        return commandButton1;
    }


    public void setInputText1(CoreInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public CoreInputText getInputText1() {
        return inputText1;
    }

    public String Verificar_action() {
        // Add event code here...
        USACSoapClient vServicio ;
        Object vResultado;
        
        try{
        vServicio= new USACSoapClient();
        vResultado=vServicio.validaCuenta(this.getTxtNumCuenta().getValue().toString(),this.getTxtCedula().getValue().toString(),this.getTxtNombres().getValue().toString(),this.getTxt1erApe().getValue().toString(),this.getTxt2doApe().getValue().toString());
        this.txtResultado.setValue(vResultado.toString());
        
        
        }catch(Exception exep){
            this.txtResultado.setValue(exep.getMessage());
            
        }
        return null;
    }

    public void setTxtNumCuenta(CoreInputText txtNumCuenta) {
        this.txtNumCuenta = txtNumCuenta;
    }

    public CoreInputText getTxtNumCuenta() {
        return txtNumCuenta;
    }

    public void setTxtCedula(CoreInputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public CoreInputText getTxtCedula() {
        return txtCedula;
    }

    public void setTxtNombres(CoreInputText txtNombres) {
        this.txtNombres = txtNombres;
    }

    public CoreInputText getTxtNombres() {
        return txtNombres;
    }

    public void setTxt1erApe(CoreInputText txt1erApe) {
        this.txt1erApe = txt1erApe;
    }

    public CoreInputText getTxt1erApe() {
        return txt1erApe;
    }

    public void setTxt2doApe(CoreInputText txt2doApe) {
        this.txt2doApe = txt2doApe;
    }

    public CoreInputText getTxt2doApe() {
        return txt2doApe;
    }

    public void setTxtResultado(CoreInputText txtResultado) {
        this.txtResultado = txtResultado;
    }

    public CoreInputText getTxtResultado() {
        return txtResultado;
    }

    public String GetURL() {
        // Add event code here...
         String inputLine,vBuffer="";
         try{
             URL vdirec = new URL(this.txtURLInput.getValue().toString());
             URLConnection yc = vdirec.openConnection();
           
                                  
             BufferedReader in = new BufferedReader(
                                     new InputStreamReader(
                                     yc.getInputStream()));
 
 
             while ((inputLine = in.readLine()) != null) 
                 vBuffer+=inputLine;
                 
             in.close();
             
         }catch(Exception exep){
             
             vBuffer=exep.getMessage();
         }
         
         this.txtURLresult.setValue(vBuffer);
         
        return null;
    }

    public void setTxtURLresult(CoreInputText txtURLresult) {
        this.txtURLresult = txtURLresult;
    }

    public CoreInputText getTxtURLresult() {
        return txtURLresult;
    }

    public void setTxtURLInput(CoreInputText txtURLInput) {
        this.txtURLInput = txtURLInput;
    }

    public CoreInputText getTxtURLInput() {
        return txtURLInput;
    }

    public void setShowOneRadio(CoreShowOneRadio showOneRadio) {
        this.showOneRadio = showOneRadio;
    }

    public CoreShowOneRadio getShowOneRadio() {
        return showOneRadio;
    }

    public String commandButton_action() {
        // Add event code here...
        this.getShowOneRadio();
        
        return null;
    }

    public String commandButton_action2() {
    
        interfaz_DB conexion = new interfaz_DB();
        Object vValorSession,vValorconsulta,vDeclara;
        vDeclara=conexion.getValorConsultaSimpleClob("dec_jurada",this.txtURLInput.getValue().toString());
        this.txtURLresult.setValue(vDeclara);
        conexion.cn_Cerrar_coneccion();
        
        return null;
    }
}
