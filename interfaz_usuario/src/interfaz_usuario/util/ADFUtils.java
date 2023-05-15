package interfaz_usuario.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCParameter;
import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.jbo.Row;

/**
 * A series of convenience functions for dealing with ADF Bindings.
 * @author Duncan Mills
 * @author Steve Muench
 * $Id: ADFUtils.java,v 1.5 2006/04/20 12:07:44 steve Exp $.
 */
 public class ADFUtils {
           
     /**
      * Returns the evaluated value of a pageDef parameter
      * @param bindings reference to the page's binding container, usually obtained using getBindings()
      * @param parameterName name of the pagedef parameter
      * @return evaluated value of the parameter as a String
      */
     public static Object getPageDefParameterValue(BindingContainer bindings, String parameterName) {
         DCParameter param = ((DCBindingContainer)bindings).findParameter(parameterName);
         return param.getValue();
     }
     
     /**
      * Returns the evaluated value of a pageDef parameter
      * @param bindings reference to the current BindingContainer
      * @param pageDefName reference to the page definition file of the page with the parameter
      * @param parameterName name of the pagedef parameter
      * @return evaluated value of the parameter as a String
      */
     public static Object getPageDefParameterValue(BindingContainer bindings, String pageDefName, String parameterName) {
         BindingContainer paramBC = findBindingContainer(bindings,pageDefName);
         return getPageDefParameterValue(paramBC,parameterName);
     }
     
     public static void setPageBoundAttributeValue(BindingContainer bindings, String attributeName, Object value) {
         AttributeBinding binding = (AttributeBinding)bindings.getControlBinding(attributeName);
         binding.setInputValue(value);
     }
     
     public static void setPageBoundAttributeValue(BindingContainer bindings, String pageDefName, String attributeName, Object value) {
         BindingContainer remoteBC = findBindingContainer(bindings,pageDefName);
         setPageBoundAttributeValue(remoteBC,attributeName,value);
     }    
     
     private static String wrapInEL(String rawValue){
         StringBuffer buff = new StringBuffer("${'");
         buff.append(rawValue);
         buff.append("'}"); 
         return buff.toString();
     }

     /**
      * @param bindings
      * @param pageDefName name of the page defintion XML file to use 
      * @return BindingContainer ref for the named definition
      */
     public static BindingContainer findBindingContainer(BindingContainer bindings, String pageDefName){
         BindingContext bctx = ((DCBindingContainer)bindings).getBindingContext();
         BindingContainer foundContainer = bctx.findBindingContainer(pageDefName);
         return foundContainer;
     }     
     
    /**
     * Get a List of attribute values for an iterator.
     * 
     * @param iter iterator binding
     * @param valueAttrName name of value attribute to use
     * @return List of attribute values
     */
    public static List attributeListForIterator(DCIteratorBinding iter, 
                                                String valueAttrName) {
      List attributeList = new ArrayList();
      for (Row r: iter.getAllRowsInRange()) {
        attributeList.add(r.getAttribute(valueAttrName));
      }
      return attributeList;
    }     
    
    
    /**
     * Get List of attribute values for an iterator.
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName value attribute to use
     * @return List of attribute values for an iterator
     */
    public static List attributeListForIterator(String iteratorName, 
                                                String valueAttrName) {
      return attributeListForIterator(findIterator(iteratorName), valueAttrName);
    }
    
    /**
     * Find an iterator binding in the current binding container by name.
     * 
     * @param name iterator binding name
     * @return iterator binding
     */
    public static DCIteratorBinding findIterator(String name) {
      DCIteratorBinding iter = getDCBindingContainer().findIteratorBinding(name);
      if (iter == null) {
        throw new RuntimeException("Iterator '" + name + "' not found");
      }
      return iter;
    }
    
    /**
     * Return the current page's binding container.
     * @return the current page's binding container
     */
    public static BindingContainer getBindingContainer() {
      return (BindingContainer)JSFUtils.resolveExpression(FacesContext.getCurrentInstance(),"#{bindings}");
    }

    /**
     * Return the Binding Container as a DCBindingContainer.
     * @return current binding container as a DCBindingContainer
     */
    public static DCBindingContainer getDCBindingContainer() {
      return (DCBindingContainer)getBindingContainer();
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     * 
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     * 
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName name of the value attribute to use
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsForIterator(String iteratorName, 
                                                          String valueAttrName, 
                                                          String displayAttrName) {
      return selectItemsForIterator(findIterator(iteratorName), valueAttrName, 
                                    displayAttrName);
    }
     
    /**
     * Get List of ADF Faces SelectItem for an iterator binding with description.
     * 
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     * 
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName name of the value attribute to use
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute to use for description
     * @return ADF Faces SelectItem for an iterator binding with description
     */
    public static List<SelectItem> selectItemsForIterator(String iteratorName, 
                                                          String valueAttrName, 
                                                          String displayAttrName, 
                                                          String descriptionAttrName) {
      return selectItemsForIterator(findIterator(iteratorName), valueAttrName, 
                                    displayAttrName, descriptionAttrName);
    }  
    
    /**
     * Get List of ADF Faces SelectItem for an iterator binding with description.
     * 
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     * 
     * @param iter ADF iterator binding
     * @param valueAttrName name of value attribute to use for key
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute for description
     * @return ADF Faces SelectItem for an iterator binding with description
     */
    public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter, 
                                                          String valueAttrName, 
                                                          String displayAttrName, 
                                                          String descriptionAttrName) {
      List<SelectItem> selectItems = new ArrayList<SelectItem>();
      for (Row r: iter.getAllRowsInRange()) {
        selectItems.add(new SelectItem(r.getAttribute(valueAttrName), 
                                       (String)r.getAttribute(displayAttrName), 
                                       (String)r.getAttribute(descriptionAttrName)));         
          
      }
      return selectItems;
    }
   
    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     * 
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     * 
     * @param iter ADF iterator binding
     * @param valueAttrName name of value attribute to use for key
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter, 
                                                          String valueAttrName, 
                                                          String displayAttrName) {
      List<SelectItem> selectItems = new ArrayList<SelectItem>();
      for (Row r: iter.getAllRowsInRange()) {
        selectItems.add(new SelectItem(r.getAttribute(valueAttrName), 
                                       (String)r.getAttribute(displayAttrName)));
      }
      return selectItems;
    }
  
     
}
