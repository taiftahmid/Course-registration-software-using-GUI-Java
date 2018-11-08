
import java.io.IOException;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CourseFactory {
    
    IExtraFeeCalculator ef; 
	static CourseFactory instance;
        FeeProperties newfps; 
	public LinkedList<Course> clist = new LinkedList<Course>();

	
	public CourseFactory()
	{
            newfps = new FeeProperties();
		/*Course C1 = new Course();
		C1.setId("Cse327");
		C1.setTitle("Soft. Eng");
		C1.setCredit(3.0);
		C1.setTutionPerCredit(1500);
		clist.add(C1);
		
		
		Course C2 = new Course();
		C2.setId("Cse311");
		C2.setTitle("DataBase Management System");
		C2.setCredit(3.0);
		C2.setTutionPerCredit(1500);
		clist.add(C2);
		
		Course C3 = new Course();
		C3.setId("Cse225");
		C3.setTitle("Data Structures and Algorithm");
		C3.setCredit(3.0);
		C3.setTutionPerCredit(1500);
		clist.add(C3);
		

		Course C4 = new Course();
		C4.setId("Cse332");
		C4.setTitle("Computer Architecture And Organization");
		C4.setCredit(3.0);
		C4.setTutionPerCredit(1500);
		clist.add(C4); */
		
	}
        
        Course getCourse(String cid) {
		Course cs = null;
		
		CID cd = new CID();
		
		cd.setCid(cid);

		cs = (Course)PersistenceFacade.getInstance().get(cd,Course.class);
		
		return cs;
        }
	
	/*public Course getCourse(String id) 
	{
		Course co = new Course();
		
		for(int i=0;i<clist.size();i++)
		{
			Course course =(Course) (clist.get(i));
			if(course.getId().equals(id))
			{
				co = course;
				break;
			}
		
		}
		return co;
	} */
        
        void setCourse(String id,String title,double credit, int tpc) {
		Course cs= new Course();
		cs.setId(id);
		cs.setTitle(title);
		cs.setCredit(credit);
		cs.setTutionPerCredit(tpc);
		
		
		
		

		PersistenceFacade.getInstance().put(cs);
        }
	
	public static synchronized CourseFactory getInstance(){
		
		if(instance == null){
			instance = new CourseFactory();
		}
		return instance;
	}
	
	public IExtraFeeCalculator getExtraFeeCalculator() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		
                newfps.setProperty();
		String className = System.getProperty("extraFeeCalculator.class.name");
		if(ef == null){
			ef = (IExtraFeeCalculator) Class.forName(className).newInstance();
		}
		return ef; 
	}
	
	
	
	public LinkedList<Course> getDetails()
	{	
		return clist;
	}

}
