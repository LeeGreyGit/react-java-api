package gb.sample.model;

import lombok.Data;

/**
 * ログインリクエストモデル
 */
@Data
public class TodoUpdateRequestModel {

  private Integer id;

  private String title;

  private String text;
}
