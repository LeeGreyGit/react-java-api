package gb.sample.model;

import lombok.Data;

/**
 * ログインレスポンスモデル
 */
@Data
public class LoginResponseModel {

  private Integer userId;

  private String userName;
}
