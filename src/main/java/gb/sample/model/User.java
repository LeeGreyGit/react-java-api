package gb.sample.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String loginName;

    private String password;
}
