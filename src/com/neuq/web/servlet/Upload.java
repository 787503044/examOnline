package com.neuq.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Upload() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		//smartupload 
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// ��ʼ��
		su.initialize(pageContext);
		// �����ļ��ϴ����Ե�����
		su.setAllowedFilesList("xls,xlsx,txt");
		// �����ϴ������ļ��Ĵ�С
		su.setMaxFileSize(1024 * 1024 * 10);// 10mb
		// �������ϴ��ļ��Ĵ�С
		su.setTotalMaxFileSize(1024 * 1024 * 10 * 5);
		// 50mb
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ��ʼ�����ϴ�

		// ��ȡ�ļ��ϴ����͵��������
		SmartRequest srequest = su.getRequest();

		String msg = srequest.getParameter("msg");
		// ��ȡ���ϴ����ļ�
		SmartFiles sfs = su.getFiles();
		// ��ȡһ��
		SmartFile sf = sfs.getFile(0);
		try {
			sf.saveAs("upload/" + sf.getFileName());
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		System.out.println(msg );
		System.out.println(sf.getFilePathName());
		System.out.println("�ļ��ϴ��ɹ���");
		}}