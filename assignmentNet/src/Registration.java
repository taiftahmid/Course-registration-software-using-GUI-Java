

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
    import java.io.IOException;
    import java.util.LinkedList;

public class Registration {
	private LinkedList<Course> courseList= new LinkedList<Course>();
	IExtraFeeCalculator iefc;
        IDiscountStrategy ids;
        private double grandTotal;
        CompositeDiscountStrategy b = new BestForNsu();
        CompositeDiscountStrategy b1 = new BestForStudent();
        public LinkedList<Listener> listeners = new LinkedList<Listener>();

	public LinkedList<Course> getCourseList() 
	{
		return courseList;
	}

	public void addCourse(Course c)
	{
		courseList.add(c);
	}
	
	public double getTotal()
	{
		double   total = 0.0;
		
		for(int i=0;i<courseList.size();i++)
		{
			Course course =(Course) (courseList.get(i));
			total = total + course.getSubTotal();
		}
		return total;
	}
	
	public double getGrandTotal(String n) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		
		grandTotal = this.getTotal() + this.getExtraFeeAmount() - this.getDiscount(n);
                publishGT();
                return grandTotal;
	}
	
	public void remove()
	{
		courseList.clear();
	}
	
	public int getExtraFeeAmount() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		
		iefc = CourseFactory.getInstance().getExtraFeeCalculator();
		return iefc.getExtraAmount(this.getTotal());
	}
        
        int getDiscount(String n) throws InstantiationException, IllegalAccessException, ClassNotFoundException{

    	
		ids = DiscountPolicyFactory.getInstance().getStrategy(n);

		return (int) (ids.getTotal(this));

	}
        
        public void addListener(Listener lt){
		
		listeners.add(lt);
	}
        
        
	public void publishGT() {
		for(Listener lis : listeners){
			lis.update(grandTotal);
			//System.out.println("pubSize ="+listeners.size());
			
		}

	}

}
