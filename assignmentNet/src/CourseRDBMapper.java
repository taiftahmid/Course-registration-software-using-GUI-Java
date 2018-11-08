
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CourseRDBMapper extends AbstractRDBMapper {
    
    public CourseRDBMapper(String tableName) {
		super(tableName);
	
	}
    @Override
    protected Object getObjectFromRecord(CID cid, ResultSet DBRecord) {
        
        String key = cid.getCid();
		
		String id = null;
		String title=null; 
		double credit=0; 
		int tpc=0; 
                
                try {
			

			while(DBRecord.next()){
				if(DBRecord.getString("id").equalsIgnoreCase(key)){
				id = DBRecord.getString("id");
				title = DBRecord.getString("title");
				credit=DBRecord.getInt("credit");
				tpc = DBRecord.getInt("tuitionPerCredit");
				System.err.println("out");
				}
				
				 
			}
		//	dbc.con.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
                
                Course cs = new Course();
		
		if(id==null)
			return null;
		
		try {
			cs.setId(id);
			cs.setTitle(title);
			cs.setCredit(credit);
			cs.setTutionPerCredit(tpc);
			

			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		
		return cs;			
    }

    @Override
    protected void putObjectInStrorage(Object obj) {
        
        Course cs=(Course)obj;
	
		
		String id = cs.getId();
		String title=cs.getTitle(); 
		double credit=cs.getCredit(); 
		double tpc= cs.getTutionPerCredit(); 
                
                try {
			String sql = "INSERT INTO course"
					+ "(id,title,credit,tuitionPerCredit) VALUES"
					+ "(?,?,?,?)";
			
			
			ps = (PreparedStatement) dbc.con.prepareStatement(sql);
			  
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setDouble(3, credit);
            ps.setDouble(4, tpc);
			
	
			
			
			ps.executeUpdate();

			dbc.con.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}		

    }
    
}
