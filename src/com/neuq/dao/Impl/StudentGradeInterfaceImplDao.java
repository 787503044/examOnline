package com.neuq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.bean.StudentGrade;
import com.neuq.dao.I.StudentGradeInterfaceDao;
import com.neuq.db.DBUtil;

public class StudentGradeInterfaceImplDao implements StudentGradeInterfaceDao {
	private static Connection con = null;
	private static PreparedStatement pr = null;
	private static ResultSet rs = null;

	
	/**
	 * ����һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean insert(StudentGrade studentGrade) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="insert into studentGrade values (null,?,?,?)";
        try {
			pr=con.prepareStatement(sql);
			pr.setString(1, studentGrade.getUsername());
			pr.setInt(2, studentGrade.getScore());
			pr.setString(3, studentGrade.getPapername());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
	
		
		return row>0;
	}
	/**
	 * ɾ��һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean delete(StudentGrade studentGrade) {
		int row=0;
        con=DBUtil.getConnection();
        String sql="delete from studentGrade where username=? and papername=?";
        try {
        	pr=con.prepareStatement(sql);
			pr.setString(1, studentGrade.getUsername());
			pr.setString(2, studentGrade.getPapername());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}

	
	/**
	 * �޸�һ��ѧ���ɼ���¼
	 * @param studentGrade
	 * @return
	 */
	@Override
	public boolean update(StudentGrade studentGrade) {
		int row=0;
        con=DBUtil.getConnection();
        //��Ŀ���಻���
        String sql="update studentGrade set  username=?,score=?, papername=? where id=?";
        try {
			pr=con.prepareStatement(sql);	
			pr.setString(1, studentGrade.getUsername());
			pr.setInt(2, studentGrade.getScore());
			pr.setString(3, studentGrade.getPapername());
			pr.setInt(4, studentGrade.getId());
			row=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}
		return row>0;
	}
	/**
	 * ��ѯĳ��ѧ����ȫ���ɼ���¼
	 * @param username ѧ������
	 * @return ĳ��ѧ����ȫ���ɼ���¼StudentGrade
	 */
	@Override
	public List<StudentGrade> select(String username) {
		List<StudentGrade> list=new ArrayList<StudentGrade>();
		String sql="select * from StudentGrade where username=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, username);
			rs=pr.executeQuery();
			while (rs.next()) {
				StudentGrade sgrade=new StudentGrade();
				sgrade.setId(rs.getInt("id"));
				sgrade.setUsername(username);
				sgrade.setScore(rs.getInt("score"));
				sgrade.setPapername(rs.getString("papername"));
				list.add(sgrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}
	
/**
 * ��ѯĳ���Ծ���ĳ���༶��ȫ���ɼ���¼
 * @param studentclass ѧ�����ڰ༶
 * @param  papername �Ծ���
 * @return ĳ���Ծ��ȫ���ɼ���¼
 */
	@Override
	public List<StudentGrade> select(String studentclass, String papername) {
		List<StudentGrade> list=new ArrayList<StudentGrade>();
		String sql="select * from StudentGrade where studentclass=? and papername=?";
		  con=DBUtil.getConnection();
		  try {
			pr=con.prepareStatement(sql);
			pr.setString(1, studentclass);
			pr.setString(2, papername);
			rs=pr.executeQuery();
			while (rs.next()) {
				StudentGrade sgrade=new StudentGrade();
				sgrade.setId(rs.getInt("id"));
				sgrade.setUsername(rs.getString("username"));
				sgrade.setScore(rs.getInt("score"));
				sgrade.setPapername(rs.getString("papername"));
				list.add(sgrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pr, con);
		}	
		return list;
	}

}
