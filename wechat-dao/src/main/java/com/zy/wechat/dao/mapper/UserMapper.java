package com.zy.wechat.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zy.wechat.dao.entity.UserEntity;

@Repository
@Transactional
public interface UserMapper {
	
	@Select("select u_id as userId, join_date as timestamp from user_info where u_id=#{userId}")
	public UserEntity selectUser(@Param("userId")String id);
	
	@Select("select u_id as userId, join_date as timestamp from user_info")
	public List<UserEntity> selectAll();
	
	@Insert("insert into user_info(u_id,join_date) values(#{userId},#{timestamp})")
	public void insertUser(UserEntity user);
	
	@Delete("delete from user_info where u_id=#{userId}")
	public void deleteUser(UserEntity user);
	
	@Update("update user_info set u_id=#{userId}, join_date=#{timestamp} where u_id=#{userId}")
	public void updateUser(UserEntity user);
}
