package com.rever.web.ui;
import com.rever.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@PageTitle("Login | Vaadin Login")
@AnonymousAllowed

public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm loginForm = new LoginForm();

    public LoginView(){
        addClassName("login-rich-content");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        loginForm.getElement().getThemeList().add("dark");
        add(new H1("Vaadin Application"), loginForm);
        loginForm.addLoginListener(this::login);
    }

    private void login(AbstractLogin.LoginEvent e) {

        boolean bAuthenticate = authenticate(e);
        if (bAuthenticate) {
            navigateToMainPage();
        }
        else {
            loginForm.setError(true);
        }

    }

    private boolean authenticate(AbstractLogin.LoginEvent e) {
        if (e.getUsername().equalsIgnoreCase("yasar"))
            return true;
        else
            return false;
    }

    private void navigateToMainPage() {
        UI.getCurrent().navigate(MainView.class);
    }
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }
    }
}
