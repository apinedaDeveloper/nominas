package pkg_autenticacion.menu;

import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.adf.view.faces.component.core.nav.CoreCommandMenuItem;

import oracle.security.jazn.collector.TokenCollector;
import oracle.security.jazn.login.LoginModuleManager;
import oracle.security.jazn.sso.util.JSSOUtil;
import oracle.security.jazn.token.HttpRequestIdentityToken;

public class MenuItem
{
    private String _label          = null;
    private String _outcome        = null;
    private String _viewId         = null;
    private String _destination    = null;
    private String _icon           = null;
    private String _type           = CoreCommandMenuItem.TYPE_DEFAULT;
    private List   _children       = null;
    private long   id_padre        = 0;
    private String _paginasRel     = null;
    
    //extended security attributes
    private boolean _readOnly = false;
    private boolean _shown = true; 
    

    public void setLabel(String label) {
        this._label = label;
    }

    /**
     * ToDo - return the looked up value of this String from the resource
     * bundle.
     * @return
     */
    public String getLabel() {
        return _label;
    }

    public void setOutcome(String outcome) {
        this._outcome = outcome;
    }

    public String getOutcome() {
      if (_outcome.equals("outcome_salir")){
            
          HttpServletResponse response=null;
          ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        
          
         // System.out.println("debug sesion " +FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap());
          
          
          try{
             response = (HttpServletResponse)ectx.getResponse();
                             
              if (ectx.getAuthType()!=null && ectx.getAuthType().equals("FORM")){
                   HttpSession session = (HttpSession)ectx.getSession(false);
                   response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
                   session.invalidate();  
                   FacesContext.getCurrentInstance().responseComplete();
                   //System.out.println("debug sesion  salida");
               }else{
                  HttpSession session = (HttpSession)ectx.getSession(false);
                  JSSOUtil.logout(response,ectx.getInitParameter("PaginaInicio"));
                  session.invalidate();  
                  FacesContext.getCurrentInstance().responseComplete();
                 // response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
                 // response.sendRedirect(ectx.getInitParameter("PaginaSalida")+"?url="+ectx.getInitParameter("PaginaInicio"));     
              }
             
          }catch(Exception exep) {
              exep.printStackTrace();
              try{
              response.sendRedirect(ectx.getInitParameter("PaginaInicio"));
              
              }catch(Exception exep2){
                  exep2.printStackTrace();
              }
          }
         
      }
        return _outcome;
    }

    public void setViewId(String viewId) {
        this._viewId = viewId;
    }

    public String getViewId() {
        return _viewId;
    }


    public void setViewId2(String viewId) {
        this._viewId = viewId;
    }

    public String getViewId2() {
        return _viewId+"x";
    }

    public void setDestination(String destination) {
        this._destination = destination;
    }

    public String getDestination() {
        return _destination;
    }

    public void setIcon(String icon) {
        this._icon = icon;
    }

    public String getIcon() {
        return _icon;
    }
    
    public String getIco() {
        return _icon;
    }    

    public void setType(String type) {
        this._type = type;
    }

    public String getType() {
        return _type;
    }

    public void setChildren(List children) {
        this._children = children;
    }

    public List getChildren() {
        return _children;
    }

    public void setReadOnly(boolean readOnly) {
        this._readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return _readOnly;
    }

    public void setShown(boolean shown) {
        this._shown = shown;
    }

    public boolean isShown() {
        return _shown;
    }
    
    public void setIdPadre(long id_padre){
     this.id_padre=id_padre;   
    }
    
    public long getIdPadre(){
     return this.id_padre;   
    }
    
    public void setPaginasRel(String pPaginasRel){
        this._paginasRel=pPaginasRel;
    }
    
    public String getPaginasRel(){
        return this._paginasRel;
    }
}

