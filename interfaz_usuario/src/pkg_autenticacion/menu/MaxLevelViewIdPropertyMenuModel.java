package pkg_autenticacion.menu;

import interfaz_usuario.util.JSFUtils;

import java.beans.IntrospectionException;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.el.PropertyResolver;

import oracle.adf.view.faces.model.ViewIdPropertyMenuModel;

public class MaxLevelViewIdPropertyMenuModel extends ViewIdPropertyMenuModel
{
  private Map<Object, Object> _focusPathMap;
  
  public MaxLevelViewIdPropertyMenuModel(Object instance, String viewIdProperty) throws IntrospectionException
  {
    super(instance, viewIdProperty);
  }
  
  public void setWrappedData(Object data)
  {
    Object oldPath = getRowKey();
    
    //set the focus path map
    _focusPathMap = new HashMap<Object, Object>();
    _focusPathMap.clear();
    setRowKey(null);
    FacesContext context = FacesContext.getCurrentInstance();
    _addToMap(context, (MaxLevelChildPropertyTreeModel)data, _focusPathMap, getViewIdProperty());
    setRowKey(oldPath);
  }

  private static void _addToMap(
    FacesContext context,
    MaxLevelChildPropertyTreeModel tree,
    Map<Object, Object> focusPathMap,
    String viewIdProperty
    )
  {
   MenuItem vtemp;
    for ( int i = 0; i < tree.getRowCount(); i++)
    {
      tree.setRowIndex(i);
      if (viewIdProperty != null)
      {
        Object focusPath = tree.getRowKey();
        
        String vPaginasRel[];
        Object data = tree.getRowData();
        PropertyResolver resolver =
         context.getApplication().getPropertyResolver();
        Object viewIdObject = resolver.getValue(data, viewIdProperty);
         vtemp=(MenuItem)(data);
        
        
          if (vtemp.getPaginasRel()!=null){
            vPaginasRel=vtemp.getPaginasRel().split("\\|");  
             for (int i2=0;i2<vPaginasRel.length;i2++){
                focusPathMap.put(vtemp.getLabel()+"|"+vPaginasRel[i2], focusPath);
                focusPathMap.put(vPaginasRel[i2], focusPath);
             }
          }
        
        
        if (viewIdObject!=null && focusPathMap.containsKey(viewIdObject)){
            
            focusPathMap.put(vtemp.getLabel()+"|"+viewIdObject, focusPath);
        }
          else{
              focusPathMap.put(viewIdObject, focusPath);
        }
        
        
      }

      if (tree.isReallyContainer() && !tree.isContainerReallyEmpty())
      {
        tree.enterContainer();
        _addToMap(context, tree, focusPathMap, viewIdProperty);
        tree.exitContainer();
      }

    }
  }
  
  public Object getFocusRowKey()
  {
    String currentViewId = getCurrentViewId();
    String vNombreItem;
    Object focusRowKey;
    
    
      vNombreItem=(String)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{flujo_usuario.current_Item}");
      if (vNombreItem==null || vNombreItem.equals("NO")){
          focusRowKey = _focusPathMap.get(currentViewId);    
      }
       else{
           focusRowKey = _focusPathMap.get(vNombreItem+"|"+currentViewId);
            if (focusRowKey==null)
                focusRowKey = _focusPathMap.get(currentViewId);
           
       }

      
   return focusRowKey;
  }
}
