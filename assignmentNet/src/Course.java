/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Course {
    
    
	private String id;
	private String title;
	private double credit;
	private double tutionPerCredit;
        
        
	
	public Course()
	{
		tutionPerCredit=0.0;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getCredit()
	{
		return credit;
	}

	public void setCredit(double credit)
	{
		this.credit = credit;
	}

	public double getTutionPerCredit()
	{
		return tutionPerCredit;
	}

	public void setTutionPerCredit(double tutionPerCredit) 
	{
		this.tutionPerCredit = tutionPerCredit;
	}
	
	public double getSubTotal()
	{
		return tutionPerCredit*credit;
	}

    } 
 
