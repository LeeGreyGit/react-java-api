package gb.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gb.sample.error.CheckUtil;
import gb.sample.error.ErrorMessage;
import gb.sample.mapper.UserMapper;
import gb.sample.model.LoginRequestModel;
import gb.sample.model.LoginResponseModel;
import gb.sample.model.User;

@Service
public class UserService {
  @Autowired
  private  UserMapper userMapper;

  public List<User> list() {
    List<User> users = userMapper.getUserList();
    return users;
  }

  /**
   * Login
   * @param requestModel LoginRequestModel
   * @return LoginResponseModel
   */
  public ResponseEntity<?> login(LoginRequestModel requestModel){

      // 必須チェック
    if (CheckUtil.isEmpty(requestModel.getLoginName())) {
        return new ResponseEntity<>(new ErrorMessage("No input login name"), HttpStatus.BAD_REQUEST);
    }
    if (CheckUtil.isEmpty(requestModel.getPassword())) {
        return new ResponseEntity<>(new ErrorMessage("No input password"), HttpStatus.BAD_REQUEST);
    }

    // ユーザー取得
   User user = userMapper.selectUser(requestModel);

    if (user == null){
        return new ResponseEntity<>(new ErrorMessage("No data found"), HttpStatus.NOT_FOUND);
    }
    LoginResponseModel loginSuccess = new LoginResponseModel();
    loginSuccess.setUserId(user.getUserId());
    loginSuccess.setUserName(user.getUserName());
    return ResponseEntity.ok(loginSuccess);
  }
}
