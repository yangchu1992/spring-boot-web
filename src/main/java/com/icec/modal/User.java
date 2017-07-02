package com.icec.modal;

import com.icec.enums.UserStatusEnum;
import org.springframework.stereotype.Component;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static com.icec.enums.UserStatusEnum.*;

/**
 * Created by jqChu on 2017/6/17.
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
@Component
public class User {

    private Long id;
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "昵称不能为空")
    private String nickName;
    @NotNull(message = "密码不能为空")
    @Min(value = 6, message = "长度不少于6位")
    private String password;
    private UserStatusEnum status;

    public User() {
        super();
        this.status = ENABLE;
    }

    public User(String userName, String nickName, String password) {
        this();
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
