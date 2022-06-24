package com.varxyz.jv200.mod010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;	// 읽은 byte 수
		try {
			try {
				fis = new FileInputStream("test.txt");	// 상대주소 
														// 절대주소는 ex) ("/test.txt");
				fos = new FileOutputStream("test_copy.txt");
				for( int readByte; (readByte = fis.read()) != -1; ) {	
					fos.write(readByte);;
					totalBytes++;
				}
			} finally {
				fos.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트 수: " + totalBytes + "bytes.");
	}
}

// UTF-8 숫자 or 영어 1byte 한줄 띄워쓰기는 2byte 
// UTF-8 한글 or 한자 3byte