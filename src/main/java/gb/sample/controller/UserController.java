package gb.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gb.sample.model.LoginRequestModel;
import gb.sample.model.User;
import gb.sample.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Login
   *
   * @param requestModel LoginRequestModel
   * @return LoginResponseModel
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<?> login(
      @RequestBody LoginRequestModel requestModel ) {
    return userService.login(requestModel);
  }

   /**
   * User list
   *
   * @return ResponseEntity<List<User>>
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseEntity<List<User>> list() {
    return ResponseEntity.ok(userService.list());
  }

}
