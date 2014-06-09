/*
CREATED: 2013 JUN 14
BY: TAN JIA HONG
UPDATED: 2013 NOV 25
BY: TAN JIA HONG
VERSION: 1.2.3
*/
package biz.variegate.wawasanerp.corecustomization;

import java.awt.Color;
import java.util.LinkedHashMap;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

public class My_XSSFWorkbook extends XSSFWorkbook
{	public LinkedHashMap<String, XSSFCellStyle> cellstyle = null;
	public short df_int = createDataFormat().getFormat("0");
	public short df_double= createDataFormat().getFormat("");	//#,##0.00

	public My_XSSFWorkbook()
	{
	}

	public XSSFCellStyle createCellStyle(XSSFFont font, String hAlign, String vAlign, Color color)
	{	XSSFCellStyle cs = this.createCellStyle();
		if(font!=null) cs.setFont(font);
		if(hAlign!=null) cs.setAlignment(create_hAlign(hAlign));
		if(vAlign!=null) cs.setVerticalAlignment(create_vAlign(vAlign));
		if(color!=null)
		{	cs.setFillForegroundColor(new XSSFColor(color));
			cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cs.setFillBackgroundColor(new XSSFColor(color));
			cs.setFillPattern(XSSFCellStyle.BIG_SPOTS);
		}

		return cs;
	}

	public XSSFCellStyle createCellStyle(XSSFFont font, String hAlign, String vAlign, Color color, Short dataformat)
	{	XSSFCellStyle cs = createCellStyle(font, hAlign, vAlign, color);
		cs.setDataFormat(dataformat);
		return cs;
	}

	public XSSFCellStyle createCellStyle(XSSFFont font, String hAlign, String vAlign, Color color, LinkedHashMap<String, LinkedHashMap<String, Object>> border)
	{	XSSFCellStyle cs = createCellStyle(font, hAlign, vAlign, color);

		if(border!=null)
		{	for(String key : border.keySet())
			{	for(String key_sub : border.get(key).keySet())
				{	if(key.toUpperCase().equals("TOP"))
					{	if(key_sub.toUpperCase().equals("COLOR"))	cs.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor((Color)(border.get(key).get(key_sub))));
						else cs.setBorderTop((Short)(border.get(key).get(key_sub)));
					}else if(key.toUpperCase().equals("BOTTOM"))
					{	if(key_sub.toUpperCase().equals("COLOR"))	cs.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor((Color)(border.get(key).get(key_sub))));
						else cs.setBorderBottom((Short)(border.get(key).get(key_sub)));
					}else if(key.toUpperCase().equals("LEFT"))
					{	if(key_sub.toUpperCase().equals("COLOR"))	cs.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor((Color)(border.get(key).get(key_sub))));
						else cs.setBorderLeft((Short)(border.get(key).get(key_sub)));
					}else if(key.toUpperCase().equals("RIGHT"))
					{	if(key_sub.toUpperCase().equals("COLOR"))	cs.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor((Color)(border.get(key).get(key_sub))));
						else cs.setBorderRight((Short)(border.get(key).get(key_sub)));
					}
				}
			}
		}

		return cs;
	}

	public XSSFCellStyle createCellStyle(XSSFFont font, String hAlign, String vAlign, Color color, LinkedHashMap<String, LinkedHashMap<String, Object>> border, Short dataformat)
	{	XSSFCellStyle cs = createCellStyle(font, hAlign, vAlign, color, border);
		cs.setDataFormat(dataformat);
		return cs;
	}

	public XSSFFont createFont(String name, double size, Color color, boolean isBold)
	{	XSSFFont font = createFont();
		if(name!=null) font.setFontName(name);
		font.setFontHeightInPoints((short)size);
		if(color!=null) font.setColor(new XSSFColor(color));
		if(isBold) font.setBoldweight(create_fontBold(true));
		else font.setBoldweight(create_fontBold(false));
		return font;
	}

	public void createCell(XSSFRow p_row, int p_column, Object p_obj, XSSFCellStyle p_cs)
	{	XSSFCellStyle cs_temp = (XSSFCellStyle)p_cs.clone();
		XSSFCell cell = p_row.createCell(p_column);

		if(p_obj == null) cell.setCellValue("");
		else if(Integer.class.isInstance(p_obj))
		{	cs_temp.setDataFormat(df_int);
			cell.setCellValue(My_Parser.toInteger(p_obj));
		}else if(Double.class.isInstance(p_obj) || Float.class.isInstance(p_obj))
		{	cs_temp.setDataFormat(df_double);
			cell.setCellValue(My_Parser.toDouble(p_obj));
		}else
			cell.setCellValue(p_obj+"");

		cell.setCellStyle(cs_temp);
		cs_temp = null;
	}

	public short create_hAlign(String align)
	{	align=align.toUpperCase();
		if(align.equals("CENTER")) return XSSFCellStyle.ALIGN_CENTER;
		else if(align.equals("LEFT")) return XSSFCellStyle.ALIGN_LEFT;
		else if(align.equals("RIGHT")) return XSSFCellStyle.ALIGN_RIGHT;
		return XSSFCellStyle.ALIGN_CENTER;
	}

	public short create_vAlign(String align)
	{	align=align.toUpperCase();
		if(align.equals("CENTER")) return XSSFCellStyle.VERTICAL_CENTER;
		else if(align.equals("TOP")) return XSSFCellStyle.VERTICAL_TOP;
		else if(align.equals("BOTTOM")) return XSSFCellStyle.VERTICAL_BOTTOM;
		return XSSFCellStyle.VERTICAL_CENTER;
	}

	public short create_fontBold(boolean isBold)
	{	if(isBold) return XSSFFont.BOLDWEIGHT_BOLD;
		else return XSSFFont.BOLDWEIGHT_NORMAL;
	}

	public void initialCellStyle()
	{	if(cellstyle == null) cellstyle = new LinkedHashMap<String, XSSFCellStyle>();

		XSSFFont font_title = createFont(My_Style.font_name, My_Style.font_size_title, My_Style.font_color_title, true);
		cellstyle.put("title", createCellStyle(font_title, "CENTER", "CENTER", My_Style.bgcolor_title));
		cellstyle.put("title_left", createCellStyle(font_title, "LEFT", "CENTER", My_Style.bgcolor_title));
		cellstyle.put("title_right", createCellStyle(font_title, "RIGHT", "CENTER", My_Style.bgcolor_title));

		XSSFFont font_h1 = createFont(My_Style.font_name, My_Style.font_size_h1, My_Style.font_color_h1, true);
		cellstyle.put("h1", createCellStyle(font_h1, "CENTER", "CENTER", My_Style.bgcolor_h1));
		cellstyle.put("h1_left", createCellStyle(font_h1, "LEFT", "CENTER", My_Style.bgcolor_h1));
		cellstyle.put("h1_right", createCellStyle(font_h1, "RIGHT", "CENTER", My_Style.bgcolor_h1));

		XSSFFont font_h2= createFont(My_Style.font_name, My_Style.font_size_h2, My_Style.font_color_h2, true);
		cellstyle.put("h2", createCellStyle(font_h2, "CENTER", "CENTER", My_Style.bgcolor_h2));
		cellstyle.put("h2_left", createCellStyle(font_h2, "LEFT", "CENTER", My_Style.bgcolor_h2));
		cellstyle.put("h2_right", createCellStyle(font_h2, "RIGHT", "CENTER", My_Style.bgcolor_h2));

		XSSFFont font_h3= createFont(My_Style.font_name, My_Style.font_size_h3, My_Style.font_color_h3, true);
		cellstyle.put("h3", createCellStyle(font_h3, "CENTER", "CENTER", My_Style.bgcolor_h3));
		cellstyle.put("h3_left", createCellStyle(font_h3, "LEFT", "CENTER", My_Style.bgcolor_h3));
		cellstyle.put("h3_right", createCellStyle(font_h3, "RIGHT", "CENTER", My_Style.bgcolor_h3));

		XSSFFont font_h4= createFont(My_Style.font_name, My_Style.font_size_h4, My_Style.font_color_h4, true);
		cellstyle.put("h4", createCellStyle(font_h4, "CENTER", "CENTER", My_Style.bgcolor_h4));
		cellstyle.put("h4_left", createCellStyle(font_h4, "LEFT", "CENTER", My_Style.bgcolor_h4));
		cellstyle.put("h4_right", createCellStyle(font_h4, "RIGHT", "CENTER", My_Style.bgcolor_h4));

		XSSFFont font_bold = createFont(My_Style.font_name, My_Style.font_size, My_Style.font_color_bold, true);
		cellstyle.put("bold", createCellStyle(font_bold, "CENTER", "CENTER", My_Style.bgcolor_cell));
		cellstyle.put("boldLeft", createCellStyle(font_bold, "LEFT", "CENTER", My_Style.bgcolor_cell));
		cellstyle.put("boldRight", createCellStyle(font_bold, "RIGHT", "CENTER", My_Style.bgcolor_cell));

		XSSFFont font = createFont(My_Style.font_name, My_Style.font_size, My_Style.font_color_cell, false);
		cellstyle.put("center", createCellStyle(font, "CENTER", "CENTER", My_Style.bgcolor_cell));
		cellstyle.put("left", createCellStyle(font, "LEFT", "CENTER", My_Style.bgcolor_cell));
		cellstyle.put("right", createCellStyle(font, "RIGHT", "CENTER", My_Style.bgcolor_cell));

		XSSFFont font_th= createFont(My_Style.font_name, My_Style.font_size_th, My_Style.font_color_th, true);
		cellstyle.put("th", createCellStyle(font_th, "CENTER", "CENTER", My_Style.bgcolor_th));
		cellstyle.put("th_left", createCellStyle(font_th, "LEFT", "CENTER", My_Style.bgcolor_th));
		cellstyle.put("th_right", createCellStyle(font_th, "RIGHT", "CENTER", My_Style.bgcolor_th));
	}

	public float getCellHeightInPoints(XSSFCellStyle cs){	return (float)(cs.getFont().getFontHeightInPoints()*1.2+2);	}

	public short createFormat(String format){	return createDataFormat().getFormat(format);	}

	public static void main(String[] args) throws Exception
	{	My_XSSFWorkbook my_xssf=new My_XSSFWorkbook();
		my_xssf.initialCellStyle();
		LinkedHashMap<String, XSSFCellStyle> lhm_cs = my_xssf.cellstyle;

		org.apache.poi.xssf.usermodel.XSSFSheet sheet = my_xssf.createSheet(org.apache.poi.ss.util.WorkbookUtil.createSafeSheetName("Overall Budget Report"));
		org.apache.poi.xssf.usermodel.XSSFRow row = null;

		int y = -1;

		for(int i=0; i<50000; i++)
		{
			row = sheet.createRow(++y);
			row.setHeightInPoints(my_xssf.getCellHeightInPoints(lhm_cs.get("title")));
			my_xssf.createCell(row, 0, 1, lhm_cs.get("center"));
			my_xssf.createCell(row, 1, 1.1, lhm_cs.get("center"));
			my_xssf.createCell(row, 2, "1", lhm_cs.get("center"));
			my_xssf.createCell(row, 3, "1.1", lhm_cs.get("center"));
		}

		java.io.FileOutputStream fileOut = new java.io.FileOutputStream("MyWorkbook.xlsx");
		my_xssf.write(fileOut);
		fileOut.close();
	}
}
