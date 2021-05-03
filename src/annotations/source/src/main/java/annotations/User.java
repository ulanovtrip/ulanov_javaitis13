package annotations;

@HtmlForm(method = "post", action = "/user")
public class User {

    @HtmlInput(name = "nickname", placeholder = "Ваш ник")
    private String nickName;

    @HtmlInput(name = "email", type = "email", placeholder = "Ваша почта")
    private String email;

    @HtmlInput(name = "password", type = "password", placeholder = "Ваш пароль")
    private String password;
}
