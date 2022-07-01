package com.varxyz.jv300.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	// 2MB, 업로드한 파일 크기가 태그 값보다 크면 location에 지정한 디렉터리에 임시로 파일을 복사 
	maxFileSize = 1024 * 1024 * 10,			// 10MB, 업로드 가능한 파일의 최대 파일 크기
	maxRequestSize = 1024 * 1024 * 50		// 50MB, 전체 사이즈
	)
	
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File saveDir = new File(SAVE_DIR);
		if(!saveDir.exists()) {
			saveDir.mkdir();  // 폴더가 없으면 폴더를 만들어라
		}
		for(Part part : request.getParts()) {
			System.out.println(saveDir.getPath() + File.separator + extractFileName(part));
			part.write(saveDir.getPath() + File.separator + extractFileName(part));	// getPath 는 c:/temp를 가르킴
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully. </h3>");
		out.println("</body></html>");
		out.close();
		
//		Enumeration<String> en = request.getHeaderNames();
//		while(en.hasMoreElements()) {
//			String header = en.nextElement();
//			System.out.println(header + " = " + request.getHeader(header));
//		}
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("contenDisp: " + contentDisp);
		for(String s : contentDisp.split(";")) {
			if(s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", " ");
			}else {
				return s;
			}
		}
		return "";
	}
}