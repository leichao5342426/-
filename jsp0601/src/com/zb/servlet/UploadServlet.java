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
			
//			request.setCharacterEncoding("utf-8")  �Ѿ�����������
			//1.����FileItemFactory����
			FileItemFactory factory = new DiskFileItemFactory();
			//2.����ServletFileupload����
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3.����request 
			List<FileItem> list = upload.parseRequest(request);
			
			for(FileItem fi : list){
				if(fi.isFormField()){
					//��ͨ�ı�  text ,password ,select, textarea ,checkbox��radio
					String name = fi.getString("utf-8");	//��ȡ��ͨ����ֵ    ��������� �������м���"utf-8"����ת��
					System.out.println(name);
				}else{
//					String photoPath = "d:/"
					
					//�ļ���
					//��ȡ�ļ��Ĵ�С
					long size = fi.getSize();
					//��ȡ�ļ���
					String name = fi.getName();
					System.out.println(size+"     "+name);
					String photoPath = "d:/"+name;
					//��ȡ�ļ�
					byte[] b = fi.get();
				
					FileOutputStream fos = new FileOutputStream(photoPath);
					//��������
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
