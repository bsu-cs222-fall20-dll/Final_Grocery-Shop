package edu.bsu.cs222.finalProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    @FXML
    private javafx.scene.control.TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private AnchorPane rootPane;

    public void launchMainUI() throws IOException {
            AnchorPane pane = FXMLLoader.load(getClass().getResource( "/ui/mainUI.fxml" ));
            rootPane.getChildren().setAll( pane );
    }

    @SuppressWarnings( "unused" ) // will be used later
    public String getUsername() {
        String username;
        username = usernameInput.getText();
        if (isValidUserName( username ))
            {return username;}
        else
            {return "Invalid username";}
    }

    @SuppressWarnings( "unused" ) // will be used later
    public String getPassword() {
        String password;
        password = passwordInput.getText();
        if (isValidPassword( password ))
            {return password;}
        else
            {return "Invalid password";}
    }

    private boolean isValidUserName(String username) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+(@bsu\\.edu)?");
        Matcher matcher = pattern.matcher(username);
        return (matcher.find() && matcher.group().equals(username));
    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+([+-]?[0-9]+)?");
        Matcher matcher = pattern.matcher(password);
        return (matcher.find() && matcher.group().equals(password));
    }

    @SuppressWarnings( "unused" ) // will be used later
    public ArrayList<String> getUserInfo() {
        ArrayList<String> userInfo = new ArrayList <>();
        String username = this.getUsername();
        String password = this.getPassword();
        userInfo.add( username );
        userInfo.add( password );
        return userInfo;
    }
}
