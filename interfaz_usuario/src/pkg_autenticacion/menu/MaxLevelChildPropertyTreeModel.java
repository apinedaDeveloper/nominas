package pkg_autenticacion.menu;

import oracle.adf.view.faces.model.ChildPropertyTreeModel;

public class MaxLevelChildPropertyTreeModel extends ChildPropertyTreeModel
{
  private int maxLevel;
  
  public MaxLevelChildPropertyTreeModel(Object instance, String childProperty, int maxLevel)
  {
    super(instance, childProperty);
    this.maxLevel = maxLevel;
  }
  
  public boolean isContainer()
  {
    boolean container = super.isContainer() && (getDepth() < maxLevel);
    return container;
  }
  
  public boolean isReallyContainer()
  {
    boolean container = super.isContainer();
    return container;
  }
  
  public boolean isContainerReallyEmpty()
  {
    if (!isReallyContainer()) return true;
    
    enterContainer();
    try
    {
      int kids = getRowCount();
      if (kids < 0)
      {
        setRowIndex(0);
        return !isRowAvailable();
      }
      return (kids == 0);
    }
    finally
    {
      exitContainer();
    }
  }
}
