/*
CREATED: 2013 OCT 02
BY: TAN JIA HONG
UPDATED: 2013 OCT 02
BY: TAN JIA HONG
VERSION: 1.1.4
*/
package biz.variegate.wawasanerp.corecustomization;

import java.util.LinkedHashMap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class My_Parser extends Object
{	private static DecimalFormat df_price = new DecimalFormat("0.00");

	public static String toString_price(Object p_obj)
	{	if(Integer.class.isInstance(p_obj) || Double.class.isInstance(p_obj) || Float.class.isInstance(p_obj))
		{	return df_price.format(p_obj);
		}else if(String.class.isInstance(p_obj) || Object.class.isInstance(p_obj))
		{	return toString_price(Double.parseDouble(new String(p_obj+"")));
		}
		return 	df_price.format(0);
	}

	public static String toString_datetime(String date, String from_pattern, String to_pattern)  throws Exception
	{	return new SimpleDateFormat(to_pattern).format(new SimpleDateFormat(from_pattern).parse(date));
	}

	public static String toString_nullToEmpty(String s){	return s==null?"":s;	}
	public static String[] toString_nullToEmpty(String[] s)
	{	if(s==null) return null;
		String[] temp = new String[s.length];
		for(int i=0; i<s.length; i++) temp[i]=toString_nullToEmpty(s[i]);
		return temp;
	}

	public static String toString_emptyToNull(String s)
	{	if(s==null) return null;
		return s.length()==0?null:s;
	}
	public static String[] toString_emptyToNull(String[] s)
	{	if(s==null) return null;
		String[] temp = new String[s.length];
		for(int i=0; i<s.length; i++) temp[i]=toString_emptyToNull(s[i]);
		return temp;
	}

	public static Double toDouble(Object p_obj)
	{	if(p_obj == null) return null;

		if(Double.class.isInstance(p_obj))
			return (Double)p_obj;

		return Double.parseDouble(p_obj+"");
	}

	public static Integer toInteger(Object p_obj)
	{	if(p_obj == null) return null;

		if(Integer.class.isInstance(p_obj))
			return (Integer)p_obj;
		else if(Double.class.isInstance(p_obj))
			return ((Double)(p_obj)).intValue();
		else if(Float.class.isInstance(p_obj))
			return ((Float)(p_obj)).intValue();
		else if(String.class.isInstance(p_obj))
			return toDouble(p_obj).intValue();

		return Integer.parseInt(p_obj+"");
	}


	public static void main(String[] args)
	{	System.out.println("toString_price(123) = " + toString_price(123));
		System.out.println("toString_price(123.123) = " + toString_price(123.123));
		System.out.println("toString_price(\"123\") = " + toString_price("123"));
		System.out.println("toString_price(\"123.123\") = " + toString_price("123.123"));

		System.out.println("toString_price(new Integer(\"123\")) = " + toString_price(new Integer("123")));
		System.out.println("toString_price(new Double(\"123.123\")) = " + toString_price(new Double("123.123")));
		System.out.println("toString_price(new Float(\"123.123\")) = " + toString_price(new Float("123.123")));

		Object obj = "123.123";
		System.out.println("toString_price(obj) = " + toString_price(obj));
		//System.out.println("toString_price(new LinkedHashMap()) = "+toString_price(new LinkedHashMap()));
	}
}
