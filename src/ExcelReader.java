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
			
			// ���������� ��ü �����ϱ�
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			
			// 1. workbook ���ϱ�
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			// sheet �� ���ϱ�
			int sheetCnt = workbook.getNumberOfSheets();
			System.out.println("sheet number -> " + sheetCnt);
			
			// 2. ȸ����� sheet ��ü ������
			HSSFSheet sheet = workbook.getSheet("ȸ�����"); // work.getSheetAt(0); �� ����
			
			// ���� ��
			int rowCnt = sheet.getPhysicalNumberOfRows();
			System.out.println("row number -> " + rowCnt);
			
			System.out.println("��ȣ\t�̸�\t����ó");
			
			for(int idx = 1; idx < rowCnt; idx++) {
				HSSFRow row = sheet.getRow(idx);
				
				// cell number ���ϱ�
				
				int cellCnt = row.getPhysicalNumberOfCells();
				
				for (int i = 0; i < cellCnt; i++) {
					HSSFCell cell = row.getCell(i);
					
					if(i == 0) {
						int num = (int)row.getCell(i).getNumericCellValue(); // ���� double
						System.out.print(num + "\t");
					} else {
						String str = row.getCell(i).getStringCellValue(); // ���� String
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
