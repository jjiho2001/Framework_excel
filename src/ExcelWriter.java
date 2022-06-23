import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
Excel�� ������ �б⾲�⸦ �ϱ� ���ؼ��� framework�� �ʿ��ϴ�.

POI �ٿ�ε�

jakarta.apache.org���� ���� ī�װ����� POI ����

Build Path

poi-5.2.2, commons-math3-3.6.1

HSSFWorkbook : workbook�� ������ִ� class

*/
public class ExcelWriter {

	public ExcelWriter() {
		// ������ ����
		// 1. workbook ����
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// 2. sheet ����
		HSSFSheet sheet1 = workbook.createSheet("ȸ�����");
		HSSFSheet sheet2 = workbook.createSheet();
		
		// 3. row ����
		HSSFRow row0 = sheet1.createRow(0); // 0�� ����
		
		// 4. cell ����
		HSSFCell cell0 = row0.createCell(0);
		
		cell0.setCellValue("��ȣ");
		
		row0.createCell(1).setCellValue("�̸�");
		row0.createCell(2).setCellValue("����ó");
		
		HSSFRow row1 = sheet1.createRow(1);
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("ȫ�浿");
		row1.createCell(2).setCellValue("010-1111-1111");
		
		HSSFRow row2 = sheet1.createRow(2);
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("�̼���");
		row2.createCell(2).setCellValue("010-2222-2222");
		
		HSSFRow row3 = sheet1.createRow(3);
		row3.createCell(0).setCellValue(3);
		row3.createCell(1).setCellValue("�������");
		row3.createCell(2).setCellValue("010-3333-3333");
		
		// ���Ϸ� ����
		try {
			File f = new File("C:/Users/Jiho Jung/Desktop/dev/member.xls");
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("excel write complete...");
	}

	public static void main(String[] args) {
		new ExcelWriter();

	}

}
