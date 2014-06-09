/*
CREATED: 2013 JUL 15
BY: TAN JIA HONG
UPDATED: 2013 NOV 11
BY: TAN JIA HONG
VERSION: 1.1.7
*/
package biz.variegate.wawasanerp.corecustomization;

import java.sql.ResultSet;
import java.util.LinkedHashMap;

public class My_OBData extends Object
{	public static LinkedHashMap getOrgList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query = null;
		ResultSet rs = null;

		try
		{	my_db = new My_DB();

			query =	"SELECT ad_org_id, name\n"+
					"FROM	ad_org\n"+
					"WHERE\n"+
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"	AND ad_org_id<>'0'\n" +
					"ORDER BY name";
			//printlnD(query);
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("ad_org_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getBPartnerList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");
		if(!lhm_input.containsKey("inp_isvendor")) lhm_input.put("inp_isvendor", "*");
		if(!lhm_input.containsKey("inp_iscustomer")) lhm_input.put("inp_iscustomer", "*");


		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	c_bpartner_id, name\n" +
					"FROM\n" +
					"	c_bpartner\n" +
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isvendor"))+" = '*' THEN 1=1 ELSE isvendor="+My_DB.escape_string(lhm_input.get("inp_isvendor"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_iscustomer"))+" = '*' THEN 1=1 ELSE iscustomer="+My_DB.escape_string(lhm_input.get("inp_iscustomer"))+" END)\n" +
					"ORDER BY\n" +
					"	name";
			//printlnD(query);
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("c_bpartner_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getWarehouseList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");
		if(!lhm_input.containsKey("inp_m_warehouse_id")) lhm_input.put("inp_m_warehouse_id", "*");
		if(!lhm_input.containsKey("inp_ad_user_id")) lhm_input.put("inp_ad_user_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	m_warehouse_id, name\n" +
					"FROM\n" +
					"	m_warehouse\n" +
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_m_warehouse_id"))+" = '*' THEN 1=1 ELSE m_warehouse_id IN ("+My_DB.escape_string(lhm_input.get("inp_m_warehouse_id"))+") END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_user_id"))+" = '*' THEN 1=1 ELSE m_warehouse_id IN (SELECT m_warehouse_id FROM cc_user_warehouse WHERE ad_user_id = "+My_DB.escape_string(lhm_input.get("inp_ad_user_id"))+" AND isactive='Y') END)\n"+
					"ORDER BY name";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("m_warehouse_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getProductCategoryList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	m_product_category_id, name\n" +
					"FROM\n" +
					"	m_product_category\n" +
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY name";
			//printlnD(query);
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("m_product_category_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getAssetGroupList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	a_asset_group_id, name\n" +
					"FROM\n" +
					"	a_asset_group\n" +
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY name";
			//printlnD(query);
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("a_asset_group_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getLocatorList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	m_locator_id, value AS name\n" +
					"FROM\n" +
					"	m_locator\n"+
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY value";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("m_locator_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getSchemaList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	c_acctschema_id, name\n" +
					"FROM\n" +
					"	c_acctschema\n"+
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY name";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("c_acctschema_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getPeriodList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	c_period_id, name\n" +
					"FROM\n" +
					"	c_period\n"+
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY startdate";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("c_period_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getYearList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	c_year_id, year AS name\n" +
					"FROM\n" +
					"	c_year\n"+
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY year";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("c_year_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}

	public static LinkedHashMap getSessionCodeList(LinkedHashMap lhm_input) throws Exception
	{	LinkedHashMap lhm_output = new LinkedHashMap();

		if(lhm_input == null) lhm_input = new LinkedHashMap();
		if(!lhm_input.containsKey("inp_isActive")) lhm_input.put("inp_isActive", "*");
		if(!lhm_input.containsKey("inp_ad_client_id")) lhm_input.put("inp_ad_client_id", "*");
		if(!lhm_input.containsKey("inp_ad_org_id")) lhm_input.put("inp_ad_org_id", "*");

		My_DB my_db = null;
		String query=null;
		ResultSet rs=null;

		try
		{	my_db = new My_DB();

			query =	"SELECT\n" +
					"	cc_sessioncode_id, name\n" +
					"FROM\n" +
					"	cc_sessioncode\n"+
					"WHERE\n" +
					"	(CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_isActive"))+" = '*' THEN 1=1 ELSE isactive="+My_DB.escape_string(lhm_input.get("inp_isActive"))+" END)\n" +
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" = '*' THEN 1=1 ELSE ad_client_id="+My_DB.escape_string(lhm_input.get("inp_ad_client_id"))+" END)\n"+
					"	AND (CASE WHEN "+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" = '*' THEN 1=1 ELSE ad_org_id="+My_DB.escape_string(lhm_input.get("inp_ad_org_id"))+" END)\n"+
					"ORDER BY name";
			rs = my_db.getResultSet(query);

			while(rs.next())
			{	lhm_output.put(rs.getString("cc_sessioncode_id"), rs.getString("name"));
			}
		}catch(Exception e){
			throw e;
		}finally
		{	if(rs != null) try{rs.close();}catch(Exception e){};
			if(my_db != null) my_db.close();
		}
		return lhm_output;
	}
}
