package com.neuq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.bean.Student;
import com.neuq.bean.StudentGrade;
import com.neuq.bean.Teacher;
import com.neuq.dao.I.TeacherInterfaceDao;
import com.neuq.db.DBUtil;

public class TeacherInterfaceImplDao implements TeacherInterfaceDao{
	@SuppressWarnings("unused")
	private static Connection con = DBUtil.getConnection();
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	/**
	 * ��ʦ��ѯ������Ϣ
	 */
	public Teacher select(Teacher t, Connection con) throws SQLException {
		Teacher info=new Teacher();
		String sql = "select * from Teacher where username = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, t.getTeachername());
		rs = pst.executeQuery();
		while(rs.next()) {
			info.setTeachername(rs.getString(2));
			info.setPwd(rs.getString(3));
			info.setName(rs.getString(4));
			info.setSex(rs.getString(5));
			info.setTelephone(rs.getString(7));
			info.setEmail(rs.getString(8));
		}
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}

	@Override
	/**
	 * ����ѧ��
	 */
	public boolean insert(Student s, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "insert into Student values (null,?,?,?,?,?,?,?,3)";
		pst = con.prepareStatement(sql);
		pst.setString(1, s.getUsername());
		pst.setString(2, s.getPwd());
		pst.setString(3, s.getName());
		pst.setString(4, s.getSex());
		pst.setString(5, s.getStudentclass());
		pst.setString(6, s.getTelephone());
		pst.setString(7, s.getEmail());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * �޸Ľ�ʦ������Ϣ������
	 */
	public boolean updata(Teacher t, Connection con) throws SQLException {
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "updata Teacher set pwd = ? where username = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, t.getPwd());
		pst.setString(2, t.getTeachername());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * ɾ��ѧ��
	 */
	public boolean delete(Student s, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "delete from Student  where username = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, s.getUsername());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * ��ʦ��ѯѧ���б�
	 */
	public List<Student> select(String sc, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Student info = new Student();
		PreparedStatement pst=null;
		List<Student> list  = new ArrayList<Student>();	
		ResultSet rs = null;
		String sql = "select * from Student where studentclass= ? ";
		pst = con.prepareStatement(sql);
		pst.setString(1, sc);
		rs = pst.executeQuery();
		while(rs.next()) {
			info.setId(rs.getInt(1));
			info.setUsername(rs.getString(2));
			info.setName(rs.getString(4));
			info.setSex(rs.getString(5));
			info.setStudentclass(rs.getString(6));
			info.setTelephone(rs.getString(7));
			info.setEmail(rs.getString(8));
			list.add(info);
		}
		DBUtil.CloseConnection(rs, pst, con);
		return list;
	}

	@Override
	public List<StudentGrade> stucj(String studentclass,String Papername) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		ArrayList<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			String sql="select score,username form studentgrade  where papername=? and username = (select username from student where studentclass = ?) ";
			pst = con.prepareStatement(sql);
			pst.setString(1, Papername);
			pst.setString(2, studentclass);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentGrade sg=new StudentGrade();
				sg.setId(rs.getInt(1));
				sg.setUsername(rs.getString(2));
				sg.setScore(rs.getInt(3));
				sg.setPapername(rs.getString(4));
				list.add(sg);
	}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return list;


}
/**
 * �鿴��ʦ������Ϣ
 */
	@Override
	public Teacher showTeacherInfo(String username) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		Teacher u=new Teacher();
		String sql="select * from teacher where username = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, username);
		rs = pst.executeQuery(sql);
		while (rs.next()) {

			u.setId(rs.getInt("id"));
			u.setTeachername(rs.getString("username"));
			u.setName(rs.getString("name"));
			u.setSex(rs.getString("sex"));
			u.setEmail(rs.getString("email"));
            u.setTelephone(rs.getString("telephone"));
			System.out.println(u.toString());

		}
		return u;
	}
	
}




