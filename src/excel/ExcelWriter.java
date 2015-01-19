package excel;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	private final String[][] header = {
		{"구분", "테스트 항목", "", "정상여부"},
		{"", "", "테스트 내용", ""}
	};
	private final String[] part = {
		"2.API Call",
		"",
		"3.SKT Legacy",
		"",
		"",
		"",
		"",
		"",
		"",
		""
	};
	private final String[][] service = {
		{"Listen To MCS API Call", ""},
		{"MCS To Listen API Call", ""},
		{"NGcP", ""},
		{"UAPS", ""},
		{"IPS (DCB)", ""},
		{"ECG - Upload", ""},
		{"ECG - Download", ""},
		{"MLB", "mlbBatch"},
		{"CRBT", ""},
		{"CCMS", ""}
	};
	
	public static void main(String[] args) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		ExcelWriter ew = new ExcelWriter();
		data.put("clsBatch", "12/16 - 전체:0, 발급:0, F:0\n12/17 - 전체:0, 발급:0, F:0");
		data.put("mlbBatch", "12/16 - 전체:2, 발급:0, F:2\n12/17 - 전체:0, 발급:0, F:0");
		data.put("rcvBatch", "12/16 - 전체:2, 발급:1, F:1\n12/17 - 전체:0, 발급:0, F:0");
		
		boolean result = ew.createExcel(data);
		System.out.println("result : "+result);
	}
	
	public boolean createExcel(Map<String, String> data) throws Exception{
		boolean result = true;
		Workbook wb = new XSSFWorkbook();

        Map<String, CellStyle> styles = createStyles(wb);

        Sheet sheet = wb.createSheet("Daily Report");
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        
        
        header[0][2] = getDay(-1) + " (09:00) ~ "+getDay(0)+" (09:00)";
        
        //header row
        Cell headerCell;
        for (int i = 0; i < header.length; i++) {
        	Row headerRow = sheet.createRow(i);
        	for (int j = 0; j < header[i].length; j++) {    
	            headerCell = headerRow.createCell(j);
	            headerCell.setCellValue(header[i][j]);
	            headerCell.setCellStyle(styles.get("header"));
	        }
        }
        
        int rowNum = 2;
        for (int i = 0; i < part.length; i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(part[i]);
            cell.setCellStyle(styles.get("cell"));
        }
	
		rowNum = 2;
	    for (int i = 0; i < service.length; i++) {
	        Row row = sheet.getRow(rowNum++);
            Cell cell = row.createCell(1);
            cell.setCellValue(service[i][0]);
            cell.setCellStyle(styles.get("cell"));
	    }
        
	    rowNum = 2;
	    for (int i = 0; i < service.length; i++) {
	    	Row row = sheet.getRow(rowNum++);
	    	Cell cell = row.createCell(2);
	    	cell.setCellValue(data.get(service[i][1]));
            cell.setCellStyle(styles.get("cell"));
		}
	    
	    rowNum = 2;
	    for (int i = 0; i < service.length; i++) {
	    	Row row = sheet.getRow(rowNum++);
	    	Cell cell = row.createCell(3);
	    	cell.setCellValue("");
            cell.setCellStyle(styles.get("cell"));
		}
	    
        sheet.setColumnWidth(0, 256*15);
        sheet.setColumnWidth(1, 256*20);
        sheet.setColumnWidth(2, 256*45);
        sheet.setColumnWidth(3, 256*15);

        sheet.addMergedRegion( new CellRangeAddress(0, 1, 0, 0) );
        sheet.addMergedRegion( new CellRangeAddress(0, 1, 1, 1) );
        sheet.addMergedRegion( new CellRangeAddress(0, 1, 3, 3) );
        
        // Write the output to a file
        String file = "C:/ListenMCS/service/logExcel.xls";
        if(wb instanceof XSSFWorkbook) file += "x";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
        
        return result;
    }

	/**
     * Create a library of cell styles
     */
    private Map<String, CellStyle> createStyles(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;

        Font headerFont = wb.createFont();
        headerFont.setFontName("돋움");
        headerFont.setFontHeightInPoints((short)9);
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(headerFont);
        style.setWrapText(true);
        styles.put("header", style);
        
        
        Font cellFont = wb.createFont();
        cellFont.setFontName(HSSFFont.FONT_ARIAL);
        cellFont.setFontHeightInPoints((short)9);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(cellFont);
        style.setWrapText(true);
        styles.put("cell", style);

        return styles;
    }
    
    public String getDay(int i) {
		Calendar todayCal = new GregorianCalendar();
		if(i != 0) todayCal.add ( todayCal.DATE, i ); 
		return String.valueOf(todayCal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(todayCal.get(Calendar.DAY_OF_MONTH));
	}
}
