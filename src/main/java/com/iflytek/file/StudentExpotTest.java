package com.iflytek.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class StudentExpotTest {

	public static void main(String[] args) throws IOException {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1000, "zhangsan", "20"));
		list.add(new Student(1001, "lisi", "23"));
		list.add(new Student(1002, "wangwu", "25"));
		
		String[] title = { "Sno", "Name", "Age" };
		String[][] values = new String[list.size()][];
		
		for(int i = 0; i < list.size();i++) {
			values[i] = new String[title.length];
			Student s = list.get(i);
			values[i][0] = String.valueOf(s.getId());
			values[i][1] = s.getName();
			values[i][2] = s.getAge();
			
		}
		
		File file = new File("D:/student.xls");
		
		FileOutputStream fos = new FileOutputStream(file);

		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook("学生表", title, values, null);
		
		wb.write(fos);
		
		fos.close();
	}

}
