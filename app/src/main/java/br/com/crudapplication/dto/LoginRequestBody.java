package br.com.crudapplication.dto;

public class LoginRequestBody {

    private final String login;
    private final String password;

    public LoginRequestBody(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequestBody{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
