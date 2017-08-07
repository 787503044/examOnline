package com.neuq.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�Ƴ��洢��session�е�user����ʵ��ע������
		if (request.getSession().getAttribute("user")!=null) {
				request.getSession().removeAttribute("user");
		}
		
		String message = String.format(
				"ע���ɹ�����3���Ϊ���Զ�������ҳ����<meta http-equiv='refresh' content='3;url=%s'/>", 
				request.getContextPath()+"/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
