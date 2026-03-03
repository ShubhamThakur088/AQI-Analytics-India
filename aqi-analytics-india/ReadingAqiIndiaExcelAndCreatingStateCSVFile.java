package collectionshandson;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingAqiIndiaExcelAndCreatingStateCSVFile {
	
	public static void createCSV(Set<String> stateNames) throws IOException {
		File file = new File("D:\\CSV-Files\\aqi-analytics-india\\state_names.csv");
		Iterator<String> setIterator = stateNames.iterator();

		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
			fileWriter.write("states");
			fileWriter.newLine();

			while (setIterator.hasNext()) {
				fileWriter.write(setIterator.next().toString());
				fileWriter.newLine();

			}
		}
	}
	
	public static void main(String args[]) throws IOException, FileNotFoundException{
		
		String filePath = new String("D:\\CSV-Files\\aqi-analytics-india\\aqi_india_excel_format.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(filePath);
		XSSFSheet sheet = workBook.getSheet("aqi");
		
		int stateColumnIndex = 0;
		
		Row row = sheet.getRow(0);
		
		for(Cell cells : row) {
			if(cells.toString().trim().equalsIgnoreCase("state")) {
				stateColumnIndex = cells.getColumnIndex();
			}					
		}
		
		Set<String> stateNames = new LinkedHashSet<>();
				
		for(Row rows : sheet) {
			if(rows.getRowNum() == 0) {
				continue;
			}
			
			String provinceName = rows.getCell(stateColumnIndex).toString();
			stateNames.add(provinceName);		
		}
		System.out.println(stateNames);
		createCSV(stateNames);
		workBook.close();
	}
}
