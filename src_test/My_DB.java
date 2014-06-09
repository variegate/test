/*
CREATED: 2013 JAN 10
BY: TAN JIA HONG
UPDATED: 2013 NOV 21
BY: TAN JIA HONG
VERSION: 1.1.3
*/
package biz.variegate.wawasanerp.corecustomization;

import org.openbravo.base.session.OBPropertiesProvider;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

public class My_DB extends Object
{	private Connection connection=null;

	public My_DB() throws Exception
	{	String db_url=OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("bbdd.url");
		String db_sid=OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("bbdd.sid");
		String db_user=OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("bbdd.systemUser");
		String db_pass=OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("bbdd.systemPassword");

		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(db_url+"/"+db_sid, db_user, db_pass);
	}

	public ResultSet getResultSet(String query) throws Exception
	{	return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	}

	public int executeUpdate(String query) throws Exception
	{	return connection.createStatement().executeUpdate(query);
	}

	public static String escape_string(Object p_obj)
	{	if(p_obj == null) return "NULL";

		return "'"+((String)p_obj).replace("'", "''")+"'";
	}

	public static String escape_string(Object[] p_obj)
	{	if(p_obj == null) return "NULL";

		String out = "";
		for(int i=0; i<p_obj.length; i++)
		{	out += escape_string(p_obj[i]);
			if(i<p_obj.length-1) out+=",";
		}
		return out;
	}

	public void close()
	{	if(connection==null)	return;
		try{	connection.close();
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
