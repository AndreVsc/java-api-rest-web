package andrevsc.java_api_rest_web.model;

public class Usuario {
    private Integer id;
    private String login;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", login=" + login + ", password=" + password + "]";
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}