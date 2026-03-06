package collectionshandson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateCsvForCitiesStateWise {
	
	
	public static void createCSV(Map<Integer, String> cityAqiDetailsMaps, List<String> stateName) throws IOException {
		String filePath = new String("D:\\CSV-Files\\aqi-analytics-india\\");
		
		String fileName = filePath+stateName.get(0).toLowerCase()+"_state_cities_aqi_data.csv";		
		File file = new File(fileName);
		file.createNewFile();
		
		try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))){
			fileWriter.write("date,city_name,air_quality_status,aqi_value");
			fileWriter.newLine();
			
			for(Map.Entry<Integer, String> map : cityAqiDetailsMaps.entrySet()) {
				String value = map.getValue();
				
				fileWriter.write(value);
				fileWriter.newLine();
			}			
		}
	}
	
	

	public static void main(String args[]) throws IOException {
		String filePath = new String("D:\\CSV-Files\\aqi-analytics-india\\aqi_india_excel_format.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(filePath);

		XSSFSheet sheet = workBook.getSheet("aqi");
		
		int i = 0;
		int j = 0;
		
		List<String> statesList = new ArrayList<>(Arrays.asList("Andhra Pradesh"));//Andhra Pradesh, Arunachal Pradesh, Assam, Bihar, Chandigarh, Chhattisgarh, Delhi, Goa, Gujarat, Haryana, Himachal Pradesh, Jammu and Kashmir, Jharkhand, Karnataka, Kerala, Ladakh, Madhya Pradesh, Maharashtra, Manipur, Meghalaya, Mizoram, Nagaland, Odisha, Puducherry, Punjab, Rajasthan, Sikkim, Tamil Nadu, Telangana, Tripura, Uttar Pradesh, Uttarakhand, West Bengal
		Map<Integer, String> cityAqiDetailsMap = new LinkedHashMap<>();
		
		
		while (i != statesList.size()) {
			System.out.println(statesList.get(i));
			for (Row rows : sheet) {
				if (rows.getRowNum() == 0) {
					continue;
				}

				for (Cell cells : rows) {
					CellType typeOfCell = cells.getCellType();

					if (typeOfCell == CellType.STRING) {
						if (cells.getStringCellValue().toString().trim().equalsIgnoreCase(statesList.get(i))) {
							String areaDetails =cells.getRow().getCell(0)+ "," +cells.getRow().getCell(2)+ "," + cells.getRow().getCell(6) +","+ cells.getRow().getCell(5);
							cityAqiDetailsMap.put(j, areaDetails);							
						}
					}
					j++;
				}
			}
			i++;
		}
//		System.out.println(cityAqiDetailsMap.size());
//		System.out.println(cityAqiDetailsMap);
		workBook.close();
		
		createCSV(cityAqiDetailsMap, statesList);
	}
	
}
