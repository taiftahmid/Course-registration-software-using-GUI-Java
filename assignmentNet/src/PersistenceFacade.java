
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
public class PersistenceFacade {
    
    public static PersistenceFacade instance;
    
    HashMap<Class<?>,IMapper> mappers = new HashMap<Class<?>,IMapper>();
    
    public PersistenceFacade() {
		mappers.put(Course.class,new CourseRDBMapper("Course"));	
	//	System.out.println("mappers");
	
	}
    
    public static PersistenceFacade getInstance(){
		if(instance==null){
			instance = new PersistenceFacade();
		}
		return instance;
	}
    
    public Object get(CID cid,Class persistenceClass){
		
	IMapper mapper=null;
		
		mapper = (IMapper)mappers.get(persistenceClass);
	
		
		return mapper.get(cid);
	
	}
    
    public void put(Object obj){
			
         IMapper mapper = null;
		
		mapper = (IMapper) mappers.get(obj.getClass());
		
		mapper.put(obj);
	
	}
	
}
