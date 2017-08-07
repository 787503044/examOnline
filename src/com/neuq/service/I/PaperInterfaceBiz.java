package com.neuq.service.I;

import java.util.List;

import com.neuq.bean.Paper;

public interface PaperInterfaceBiz {
	/**
	 * ����һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean insert(Paper paper);
	
	/**
	 * ɾ��һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean delete(Paper paper);
	
	/**
	 * �����޸�һ���Ծ�
	 * @param paper
	 * @return
	 */
//	public boolean update(Paper paper);
	
	/**
	 * ��ѯȫ���Ծ�
	 * @param ��
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select();
	
	/**
	 * ��֪ʶ���ѯ�Ծ�
	 * @param questionpoint
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select(String questionpoint);
	public List<Paper> showbeforePaper();
	public List<Paper> showafterPaper();
	public List<Paper> shownowPaper();
}
