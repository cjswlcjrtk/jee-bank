package com.bank.web.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileTest {
	public static final String FILE_PATH =String.format("C:%sUsers%suser%seclipse-jee%sjee-bitcamp%sWebContent%sresources%stxt%s",
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator);
	
	public static void main(String[] args) {
		System.out.println("aaa"+FILE_PATH);
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter writer = 
					new BufferedWriter(new FileWriter(file, true));
			BufferedReader reader = 
					new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			while(true) {
				switch(JOptionPane.showInputDialog("0.종료 1.저장 2.읽기")) {
				case "0":
					JOptionPane.showMessageDialog(null, "종료");
					return;
				case "1":
					String msg = JOptionPane.showInputDialog("메세지를 입력하세요. 데이터 사이에 , 입력");
					writer.write(msg);
					writer.newLine();//줄바꿈
					writer.flush();//전송
					break;
				case "2":
					msg = "";
					while((msg = reader.readLine()) != null) {
						list.add(msg+"/");
					}				
					JOptionPane.showMessageDialog(null, list);
					reader.close();//static의 경우 일부로라도 close줘야한다. 지금 에러 뜨는건 dao에서 해결 가능하다.
					break;
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
