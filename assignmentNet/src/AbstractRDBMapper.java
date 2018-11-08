
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class AbstractRDBMapper extends AbstractPersistenceMapper {
    
    String tableName;
	ResultSet DBRecord;
	DBStorage dbc;
	Statement st;
	PreparedStatement ps;
        
        public AbstractRDBMapper(String tableName) {
		this.tableName = tableName;
		dbc = new DBStorage();
		
	}
        
        private ResultSet getDBRecord(CID cid) {
        
            String key = cid.getCid();
		
		
		try {
			

			st= (Statement) dbc.con.createStatement();  
			  
			DBRecord = st.executeQuery("Select *from "+tableName);  
						
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return DBRecord;
    }
        
        @Override
	protected Object getObjectFromStorage(CID cid) {
		DBRecord = getDBRecord(cid);
		
		return getObjectFromRecord(cid, DBRecord);
	}
        
        


	protected abstract Object getObjectFromRecord(CID cid,ResultSet DBRecord);
	protected  abstract void putObjectInStrorage(Object obj);

    
}
