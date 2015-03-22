package com.zy.wechat.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.zy.wechat.dao.entity.UserEntity;
import com.zy.wechat.dao.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
//	@Autowired
//	private UserMapper userMapper;
	
	@Autowired
	private DataSourceTransactionManager txManager;
	
	public void test(){
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		UserMapper userMapper0 = sqlSession.getMapper(UserMapper.class);
		UserEntity user = userMapper0.selectUser("hadoop");
		Transaction tx = new JdbcTransactionFactory().newTransaction(sqlSession.getConnection());
		try {
			user.setTimestamp("11111111");
			userMapper0.updateUser(user);
			userMapper0.insertUser(user);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
