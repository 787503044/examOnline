package com.neuq.service.I;

import java.util.List;

import com.neuq.bean.Mistakes;

public interface MistakesInterfaceBiz {
		/**
		 * ����һ������
		 */
		public boolean insert(Mistakes mistakes);		
		/**
		 * ɾ��һ������
		 */
		public boolean delete(Mistakes mistakes);
		/**
		 * ��ѯĳ��ѧ����ȫ������  
		 */
		public List<Mistakes> select(String username);		
		/**
		 * ��֪ʶ���ѯĳ��ѧ����ȫ������
		 */
		public List<Mistakes> select(String username,String questionpoint);
}
