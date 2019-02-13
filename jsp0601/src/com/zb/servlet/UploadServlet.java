package com.zb.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
//			request.setCharacterEncoding("utf-8")  已经不起作用了
			//1.创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			//2.创建ServletFileupload对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3.解析request 
			List<FileItem> list = upload.parseRequest(request);
			
			for(FileItem fi : list){
				if(fi.isFormField()){
					//普通的表单  text ,password ,select, textarea ,checkbox，radio
					String name = fi.getString("utf-8");	//获取普通表单的值    如果有中文 在括号中加入"utf-8"进行转码
					System.out.println(name);
				}else{
//					String photoPath = "d:/"
					
					//文件表单
					//获取文件的大小
					long size = fi.getSize();
					//获取文件名
					String name = fi.getName();
					System.out.println(size+"     "+name);
					String photoPath = "d:/"+name;
					//读取文件
					byte[] b = fi.get();
				
					FileOutputStream fos = new FileOutputStream(photoPath);
					//二进制流
					DataOutputStream dis = new DataOutputStream(fos);
					dis.write(b,0,b.length);
					dis.flush();
					dis.close();
					fos.close();
					
					
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
