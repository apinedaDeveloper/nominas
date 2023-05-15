package pkg_autenticacion.menu;

import java.beans.IntrospectionException;

import java.util.List;

import oracle.adf.view.faces.model.TreeModel;

public class MenuTreeModelAdapter
{
  private String _propertyName = null;
  private Object _instance = null;
  private transient TreeModel _model = null;
  private int _maxLevel = Integer.MAX_VALUE;

  public TreeModel getModel() throws IntrospectionException
  {
    if (_model == null)
    {
      _model = new MaxLevelChildPropertyTreeModel(getInstance(), getChildProperty(), getMaxLevel());
    }
    return _model;
  }

  public void setMaxLevel(int maxLevel)
  {
    this._maxLevel = maxLevel;
  }

  public int getMaxLevel()
  {
    return _maxLevel;
  }

  public String getChildProperty()
  {
    return _propertyName;
  }

  /**
   * Sets the property to use to get at child lists
   * @param propertyName
   */
  public void setChildProperty(String propertyName)
  {
    _propertyName = propertyName;
    _model = null;
  }

  public Object getInstance()
  {
    return _instance;
  }

  /**
   * Sets the root list for this tree.
   * @param instance must be something that can be converted into a List
   */
  public void setInstance(Object instance)
  {
    _instance = instance;
    _model = null;
  }
  
  /**
   * Sets the root list for this tree.
   * This is needed for passing a List when using the managed bean list  
   * creation facility, which requires the parameter type is List.
   * @param instance the list of root nodes
   */
  public void setListInstance(List instance)
  {
    setInstance(instance);
  }
}

