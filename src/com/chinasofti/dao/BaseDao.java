package com.chinasofti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//����ģ���������ʱ�����޸ģ�û������ ��ʱ��������
	void saveOrUpdate(T t);
	//��
	void save(T t);
	//ɾ
	void delete(T t);
	//ɾ
	void delete(Serializable id);
	//��
	void update(T t);
	//�� ����ID��
	T getByID(Serializable id);
	//�� ��ѯ�ܼ�¼��
	Integer getTotalCount(DetachedCriteria dc);
	//��  ��ҳ��ѯ�б�
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
