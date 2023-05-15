package interfaz_usuario.util;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class modelo_tabla implements Serializable{
    private List _list;
    public modelo_tabla() {
        _list = new ArrayList();
    }
    
    public void setAgFila(Object obFila){
        _list.add(obFila);
    }
    
    public void setFila(int indice,Object obFila){
        _list.set(indice,obFila);
    }
    
    public void setRemove(List list1){
     if (list1.size()==0)
    _list.removeAll(_list) ;
    else
     _list.removeAll(list1) ;
    }
    
    public void setList(List list)
    {
      this._list = new ArrayList(list);
    }

    public void setListAg(List list){
       this._list.addAll(list);
    }

    /**
     * @return Returns the _list.
     */
    public List getList()
    {
      return _list;
    }
}
