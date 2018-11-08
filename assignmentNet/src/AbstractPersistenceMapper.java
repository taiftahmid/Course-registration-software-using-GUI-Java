
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class AbstractPersistenceMapper implements IMapper  {
    
    HashMap<CID,Course> cachedObjects = new HashMap<CID,Course>();
    
    public final Object get(CID cid) {
		Object obj = cachedObjects.get(cid);
		
		if(obj==null){
			
			obj = getObjectFromStorage(cid);
			cachedObjects.put(cid,(Course)obj);
			//System.out.println("cached");
			// System.out.println("Size of HashMap  : " + cachedObjects.size()+"ob");
		}
		return obj;
	}
    
    public final void put( Object obj) {
		this.putObjectInStrorage(obj);
		
	}

    protected abstract Object getObjectFromStorage(CID cid);
     protected abstract void putObjectInStrorage(Object obj);
        
    

}
