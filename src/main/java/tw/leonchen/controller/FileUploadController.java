package tw.leonchen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;

@Controller
public class FileUploadController {

	@GetMapping("/uploadmain.controller")
	public String processMainAction() {
		return "uploadFile";
	}
	
	@PostMapping("/uploadfile.controller")
	@ResponseBody
	public String processUploadFileAction(@RequestParam("myFiles") MultipartFile mf, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		
		String saveFileTempDirPath = request.getSession().getServletContext().getRealPath("/") + "uploadTempDir\\";
		File saveFileTempDir = new File(saveFileTempDirPath);
		saveFileTempDir.mkdirs();
		
		String saveFilePath = saveFileTempDirPath + fileName;
		File saveFile = new File(saveFilePath);
		mf.transferTo(saveFile);
		
		if(fileName!=null && fileName.length()!=0) {
			saveFile(fileName, saveFilePath);
		}
		
		return "saveFilePath:" + saveFilePath;
	}
	
	@Autowired
	private PictureService pService;

	private void saveFile(String fileName, String saveFilePath) {
		
		try {
			InputStream is = new FileInputStream(saveFilePath);
			byte[] b = new byte[is.available()];
			is.read(b);
			is.close();
			
			Picture p1 = new Picture(fileName, b);
			
			pService.insert(p1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
