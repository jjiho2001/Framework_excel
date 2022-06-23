import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
Excel로 내용을 읽기쓰기를 하기 위해서는 framework이 필요하다.

POI 다운로드

jakarta.apache.org에서 왼쪽 카테고리에서 POI 선택

Build Path

poi-5.2.2, commons-math3-3.6.1

HSSFWorkbook : workbook을 만들어주는 class

*/
public class ExcelWriter {

	public ExcelWriter() {
		// 엑셀로 쓰기
		// 1. workbook 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// 2. sheet 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		// 3. row 생성
		HSSFRow row0 = sheet1.createRow(0); // 0행 생성
		
		// 4. cell 생성
		HSSFCell cell0 = row0.createCell(0);
		
		cell0.setCellValue("번호");
		
		row0.createCell(1).setCellValue("이름");
		row0.createCell(2).setCellValue("연락처");
		
		HSSFRow row1 = sheet1.createRow(1);
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("홍길동");
		row1.createCell(2).setCellValue("010-1111-1111");
		
		HSSFRow row2 = sheet1.createRow(2);
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("이순신");
		row2.createCell(2).setCellValue("010-2222-2222");
		
		HSSFRow row3 = sheet1.createRow(3);
		row3.createCell(0).setCellValue(3);
		row3.createCell(1).setCellValue("세종대왕");
		row3.createCell(2).setCellValue("010-3333-3333");
		
		// 파일로 쓰기
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
