/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.LinkedList;

public class RegisterCourseController {
Registration reg = new Registration();
CourseFactory cF1;
	
	public void makeNewRegistration() 
	{
		reg.remove();
		
	}
	
	public void addCourse(String id)
	{
		Course b = cF1.getInstance().getCourse(id);
		reg.addCourse(b);
		
	}
	
	public Registration getRegistration()
	{	
		return reg;
	}
	
	public LinkedList<Course> getCourse()
	{	
		return reg.getCourseList();
	}

    
    
}
