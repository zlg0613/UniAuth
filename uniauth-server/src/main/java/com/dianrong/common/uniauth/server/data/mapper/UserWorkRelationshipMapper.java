package com.dianrong.common.uniauth.server.data.mapper;

import com.dianrong.common.uniauth.server.data.entity.UserWorkRelationship;
import com.dianrong.common.uniauth.server.data.entity.UserWorkRelationshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWorkRelationshipMapper {

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int countByExample(UserWorkRelationshipExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int deleteByExample(UserWorkRelationshipExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int deleteByPrimaryKey(Long id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int insert(UserWorkRelationship record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int insertSelective(UserWorkRelationship record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  List<UserWorkRelationship> selectByExample(UserWorkRelationshipExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  UserWorkRelationship selectByPrimaryKey(Long id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int updateByExampleSelective(@Param("record") UserWorkRelationship record,
      @Param("example") UserWorkRelationshipExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int updateByExample(@Param("record") UserWorkRelationship record,
      @Param("example") UserWorkRelationshipExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int updateByPrimaryKeySelective(UserWorkRelationship record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * user_work_relationship
   *
   * @mbggenerated Thu Jun 01 18:13:03 CST 2017
   */
  int updateByPrimaryKey(UserWorkRelationship record);
}
