/*
CREATED: 2013 JUN 19
BY: TAN JIA HONG
UPDATED: 2013 NOV 28
BY: TAN JIA HONG
VERSION: 1.1.3
*/
package biz.variegate.wawasanerp.corecustomization;

import java.util.LinkedHashMap;

public class My_Validation extends Object
{
	public static boolean isNullOrEmpty(Object p_obj)
	{	if(p_obj == null) return true;

		if(LinkedHashMap.class.isInstance(p_obj))
		{	if(((LinkedHashMap)p_obj).isEmpty()) return true;
			else return false;
		}else if(String.class.isInstance(p_obj))
		{	if(new String(p_obj+"").length()==0) return true;
			else return false;
		}

		return false;
	}

	public static boolean isNumeric(Object p_obj)
	{	if(Integer.class.isInstance(p_obj) || Double.class.isInstance(p_obj) || Float.class.isInstance(p_obj))
			return true;
		else if(String.class.isInstance(p_obj) || Object.class.isInstance(p_obj))
		{	if(new String(p_obj+"").matches("^[-+]?\\d+(\\.\\d*)?$")) return true;
			return false;
		}
		return false;
	}
}
