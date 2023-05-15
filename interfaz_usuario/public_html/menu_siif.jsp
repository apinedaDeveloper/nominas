<jsp:directive.page import="javax.faces.context.ExternalContext" />
<jsp:directive.page import="javax.faces.context.FacesContext" />
<jsp:directive.page import="javax.servlet.http.HttpServletResponse" />
<jsp:scriptlet>
ExternalContext vExterna = FacesContext.getCurrentInstance().getExternalContext();
HttpServletResponse vSrvltResponse=(HttpServletResponse)vExterna.getResponse();
String urlRedirect;
urlRedirect=vExterna.getInitParameter("PaginaMenuSiif");
vSrvltResponse.sendRedirect(urlRedirect);
</jsp:scriptlet>