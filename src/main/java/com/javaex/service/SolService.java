package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.SolDao;

@Service
public class SolService {

	@Autowired
	private SolDao solDao;

	public String exeId(String id) {
		System.out.println("SolService.exeId()");
		return solDao.selectCompanyId(id);
	}

	// 파일업로드
	public String exeCompanyImg(MultipartFile file) {
		String osName = System.getProperty("os.name").toLowerCase();
		String saveDir;
		if (osName.contains("linux")) {
			saveDir = "/app/upload/"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.

		} else {
			saveDir = ".\\uploadImages\\";
		}
		
		String orgName = file.getOriginalFilename();
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String filePath = saveDir + File.separator + saveName;
		System.out.println(saveName);
		
		try {
			byte[] fileData;
			fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveName;
	}

}
