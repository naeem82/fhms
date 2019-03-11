package com.student.fhms.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class CustomeMultipartFile implements MultipartFile {
	
	private final byte[] fileContent;

	private String fileName;

	private String contentType;

	private File file;
	private String destPath = System.getProperty("java.io.tmpdir");

	private FileOutputStream fileOutputStream;
	
	public  CustomeMultipartFile(byte[]fileData,String name) {
		this.fileContent=fileData;
		this.fileName=name;
		file=new File(destPath+fileName);
		// TODO Auto-generated constructor stub
	}


	@Override
	public byte[] getBytes() throws IOException {
		return fileContent;
		
		
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return contentType;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return new ByteArrayInputStream(fileContent);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return fileName;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return fileName;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return fileContent.length;
	}

	@Override
	public boolean isEmpty() {
		return (fileContent==null || fileContent.length==0);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		fileOutputStream=new FileOutputStream(dest);
		fileOutputStream.write(fileContent);

	}
	
	public void clearOutStreams() throws IOException {
		if (null != fileOutputStream) {
		        fileOutputStream.flush();
		        fileOutputStream.close();
		        file.deleteOnExit();
		}
	}
}
