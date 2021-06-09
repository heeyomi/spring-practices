package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "/uploads-mysite";

	public String resotre(MultipartFile file) {
		String url = null;
		
		try {
			if (file.isEmpty()) {
				return url;
			}
			
			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1); //+1을 하면 .을 포함하지 않는 것
			String saveFilename = generateSaveFilename(extName);
			long fileSize = file.getSize();
			
			System.out.println("################" + originFilename);
			System.out.println("################" + fileSize);
			System.out.println("################" + saveFilename);
			
			byte[] data = file.getBytes();
			new FileOutputStream(SAVE_PATH + "/" + saveFilename).write(data);

		} catch (IOException e) {
			throw new RuntimeException("File Upload error : " + e);
			//MySite에서는 FileUploadException 만들기
		}
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}

}
