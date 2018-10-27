package html;

/**
 * Created by sergii on 26.10.18.
 */
public class User {
    private String login;
    private String password;

    public User(String l, String p) {
        login = l;
        password = p;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
