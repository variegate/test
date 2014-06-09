/*
CREATED: 2013 JUN 14
BY: TAN JIA HONG
UPDATED: 2013 NOV 21
BY: TAN JIA HONG
VERSION: 1.1.5
*/
package biz.variegate.wawasanerp.corecustomization;

import java.util.LinkedHashMap;

public class My_Utility extends Object
{	public static String splitter = ";.;.;";

	public static void println(Object p_obj){	System.out.println(new java.util.Date()+": "+p_obj);	}

	protected static void println(LinkedHashMap p_lhm, int p_level)
	{	if(p_lhm == null)
		{	System.out.println("null");
			return;
		}
		LinkedHashMap p_lhm_sub = null;

		for(Object key : p_lhm.keySet())
		{	for(int i=0; i<p_level; i++) System.out.print("\t");
			if(LinkedHashMap.class.isInstance(p_lhm.get(key)))
			{	System.out.println(key);
				println((LinkedHashMap)p_lhm.get(key), p_level+1);
			}else
			{	System.out.println(key+": "+p_lhm.get(key)+"\t");
			}
		}
	}

	public static void println(LinkedHashMap p_lhm){	println(p_lhm, 0);	}

	public static int getLevel(LinkedHashMap p_lhm)
	{	if(p_lhm == null) return 0;

		int p_level = 1,
			temp = 0;

		for(Object key : p_lhm.keySet())
		{	if(LinkedHashMap.class.isInstance(p_lhm.get(key)))
			{	temp = getLevel((LinkedHashMap)p_lhm.get(key))+1;
				if(temp>p_level) p_level=temp;
			}
		}
		return p_level;
	}

	public static String string_join(Object[] p_obj, Object join)
	{	StringBuffer output = new StringBuffer();

		if(p_obj == null) return null;

		for(int i=0; i<p_obj.length; i++)
		{	if(i>0) output.append(join);
			output.append((String)p_obj[i]);
		}

		return output.toString();
	}
}
