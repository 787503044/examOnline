package com.neuq.service.I;

import java.util.List;

import com.neuq.bean.Paper;

public interface PaperInterfaceBiz {
	/**
	 * 增加一张试卷
	 * @param paper
	 * @return
	 */
	public boolean insert(Paper paper);
	
	/**
	 * 删除一张试卷
	 * @param paper
	 * @return
	 */
	public boolean delete(Paper paper);
	
	/**
	 * 更新修改一张试卷
	 * @param paper
	 * @return
	 */
//	public boolean update(Paper paper);
	
	/**
	 * 查询全部试卷
	 * @param 无
	 * @return  Paper 试卷集合
	 */
	public List<Paper> select();
	
	/**
	 * 按知识点查询试卷
	 * @param questionpoint
	 * @return  Paper 试卷集合
	 */
	public List<Paper> select(String questionpoint);
	public List<Paper> showbeforePaper();
	public List<Paper> showafterPaper();
	public List<Paper> shownowPaper();
}
