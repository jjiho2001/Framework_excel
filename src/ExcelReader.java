import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {

	public ExcelReader() {
		
	}

	void start() {
		
		try {
			File f = new File("C:/Users/Jiho Jung/Desktop/dev/member.xls");
			FileInputStream fis = new FileInputStream(f);
			
			// 엑셀파일을 객체 생성하기
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			
			// 1. workbook 구하기
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			// sheet 수 구하기
			int sheetCnt = workbook.getNumberOfSheets();
			System.out.println("sheet number -> " + sheetCnt);
			
			// 2. 회원목록 sheet 객체 얻어오기
			HSSFSheet sheet = workbook.getSheet("회원목록"); // work.getSheetAt(0); 도 가능
			
			// 행의 수
			int rowCnt = sheet.getPhysicalNumberOfRows();
			System.out.println("row number -> " + rowCnt);
			
			System.out.println("번호\t이름\t연락처");
			
			for(int idx = 1; idx < rowCnt; idx++) {
				HSSFRow row = sheet.getRow(idx);
				
				// cell number 구하기
				
				int cellCnt = row.getPhysicalNumberOfCells();
				
				for (int i = 0; i < cellCnt; i++) {
					HSSFCell cell = row.getCell(i);
					
					if(i == 0) {
						int num = (int)row.getCell(i).getNumericCellValue(); // 숫자 double
						System.out.print(num + "\t");
					} else {
						String str = row.getCell(i).getStringCellValue(); // 문자 String
						System.out.print(str + "\t");
					}
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ExcelReader().start();

	}

}
