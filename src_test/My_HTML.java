/*
 CREATED: 2013 JUL 25
 BY: TAN JIA HONG
 UPDATED: 2013 NOV 21
 BY: TAN JIA HONG
 VERSION:	1.1.6
 */
package biz.variegate.wawasanerp.corecustomization;

import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.LinkedHashMap;

public class My_HTML extends Object
{	public static String generateHTML_orgOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getOrgList(lhm_input));
	}

	public static String generateHTML_bPartnerOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getBPartnerList(lhm_input));
	}

	public static String generateHTML_warehouseOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getWarehouseList(lhm_input));
	}

	public static String generateHTML_productCategoryOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getProductCategoryList(lhm_input));
	}

	public static String generateHTML_assetGroupOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getAssetGroupList(lhm_input));
	}

	public static String generateHTML_locatorOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getLocatorList(lhm_input));
	}

	public static String generateHTML_schemaOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getSchemaList(lhm_input));
	}

	public static String generateHTML_periodOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getPeriodList(lhm_input));
	}

	public static String generateHTML_yearOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getYearList(lhm_input));
	}

	public static String generateHTML_sessionCodeOption(HttpServletResponse response, LinkedHashMap lhm_input) throws Exception
	{	return generateHTML(response, My_OBData.getSessionCodeList(lhm_input));
	}

	private static String generateHTML(HttpServletResponse response, LinkedHashMap lhm_data) throws Exception
	{	String html = "";
		for(Object k: lhm_data.keySet())
			html += "<option value=\""+k+"\">"+lhm_data.get(k)+"</option>";

		if(response!=null)
		{	response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(html);
			out.close();
		}
		return html;
	}
}
