package com.qhit.lh.gr3.bonnie.t07.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 王云纳
 * TODO
 * 2017年12月5日下午7:19:42
 * 保存数据
 * 处理业务
 */
public class FileAction extends ActionSupport {
	private String username;
	private File uploadFile;
	
	private String uploadFileFileName;      //文件名
	private String uploadFileContentType;   //文件类型
	/**
	 * @return
	 * 处理上传文件的业务
	 */
	public String upload() {
		if(uploadFile != null) {
			try {
				//1，读取上传的文件：
				InputStream is = new FileInputStream(uploadFile);
				//写之前：创建保存的文件（localhost:8080/StrutsT07/upload/uploadFileFileName）创建文件夹
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				//写:输出流--》
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//根据创建的文件，写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到!");
			} catch (IOException e) {
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败!");
			}
		}else {
			//文件未找到
			super.addFieldError("uploadFile", "文件未找到!");
		}
		return "uploadSuccess";
	}
	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return
	 */
	public File getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile
	 */
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	/**
	 * @return
	 */
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	/**
	 * @param uploadFileFileName
	 */
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	/**
	 * @return
	 */
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	/**
	 * @param uploadFileContentType
	 */
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
}