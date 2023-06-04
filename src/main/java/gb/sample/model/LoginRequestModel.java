package gb.sample.model;

import lombok.Data;

/**
 * ログインリクエストモデル
 */
@Data
public class LoginRequestModel {

  private String loginName;

  private String password;
}
