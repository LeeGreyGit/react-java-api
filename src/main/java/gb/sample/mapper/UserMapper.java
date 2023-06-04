package gb.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import gb.sample.model.LoginRequestModel;
import gb.sample.model.User;

@Mapper
public interface UserMapper {
     List<User> getUserList();


  /**
   * Select user by loginName and password
   *
   * @param request LoginRequestModel
   * @return User
   */
  User selectUser(@Param("request") LoginRequestModel request);
}
