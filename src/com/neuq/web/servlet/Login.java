package com.neuq.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.bean.Student;
import com.neuq.dao.I.StudentInterfaceDao;
import com.neuq.dao.Impl.StudentInterfaceImplDao;
import com.neuq.service.I.StudentInterfaceBiz;
import com.neuq.service.Impl.StudentInterfaceImplBiz;


/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	public void destroy() {
		super.destroy();

	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//����doPost����
	this.doPost(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ServletContext����

		String uname=request.getParameter("username");
		String upsw=request.getParameter("password");
		String message1 =null;
		String message2 =null;
	StudentInterfaceBiz service=new StudentInterfaceImplBiz();
	
		//�û���¼
		Student stu=null;
		try {
			stu = service.login(uname, upsw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stu==null){
			 message1 = String.format(
						"�Բ����û������������󣡣������µ�¼��2���Ϊ���Զ�������¼ҳ�棡");
			 
			 message2 = String.format(
					"<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/login.jsp");
			 request.setAttribute("message1",message1);
			request.setAttribute("message2",message2);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//��¼�ɹ��󣬾ͽ��û��洢��session��
		request.getSession().setAttribute("user", stu);
		int r=stu.getRu();
        System.out.print(r);


		if (r==1) {
			//��������Ա����
			 message1 = String.format(
						"����Ա��½�ɹ���");
	 message2 = String.format(
				"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/teacher/index.jsp");

		} else if(r==2){
			//������ͨ�û�����
			 message1 = String.format(
						"��ʦ��½�ɹ���");
			 message2 = String.format(
						"<meta http-equiv='refresh' content='3;url=%s'", 
						request.getContextPath()+"/teacher/index.jsp");
			 
	}else {
		//��ת��ѧ��ҳ��
		 message1 = String.format(
					"ѧ����½�ɹ���");
		 message2 = String.format(
					"<meta http-equiv='refresh' content='3;url=%s'", 
					request.getContextPath()+"/user/index.jsp");
		 
	}
		
		
		
		request.setAttribute("message2",message2);
		request.setAttribute("message1",message1);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	}


