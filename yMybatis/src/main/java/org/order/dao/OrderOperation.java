package org.order.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.order.po.Order;

@Component
public class OrderOperation {
	private String getAllStatement = "dao.orderMapper.getAll";
	private String insertStatement = "dao.orderMapper.insert";
	private String deleteStatement="dao.orderMapper.deleteAll";
	private String deleteByIdStatement="dao.orderMapper.deleteById";

	public List<Object> getAll(String nickName) throws IOException {
		OrderOperation orderOperation = new OrderOperation();
		String statement = orderOperation.getAllStatement;
		SqlSession session = orderOperation.getSession();
		List<Object> carts = session.selectList(statement,nickName);// 捕获所有对象
		return carts;
	}
	
	public void insert(Order order) {
		OrderOperation orderOperation=new OrderOperation();
		String statement=orderOperation.insertStatement;
		SqlSession session=orderOperation.getSession();
		session.insert(statement, order);
		session.commit();
	}
	public void deleteAll() {
		OrderOperation orderOperation=new OrderOperation();
		String statement=orderOperation.deleteStatement;
		SqlSession session=orderOperation.getSession();
		session.insert(statement);
		session.commit();
	}
	public void deleteById(Integer id) {
		OrderOperation orderOperation=new OrderOperation();
		String statement=orderOperation.deleteByIdStatement;
		SqlSession session=orderOperation.getSession();
		session.delete(statement,id);
		session.commit();
	}
	
	public SqlSession getSession() {
		String resource = "configuration.xml";
		InputStream is = GoodOperation.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		return session;
	}
}
