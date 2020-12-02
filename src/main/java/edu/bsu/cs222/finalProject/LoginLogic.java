package edu.bsu.cs222.finalProject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginLogic {

    public static boolean isValidUserName(String username) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+(@bsu\\.edu)?");
        Matcher matcher = pattern.matcher(username);
        if (username.length() < 5) {return false;}
        return (matcher.find() && matcher.group().equals(username));
    }

    public static boolean isValidPassword(String username, String password) {
        Pattern pattern = Pattern.compile("([$&+,:;=?@#|'<>.^*()%!-]?+[a-zA-Z]+([+-]?[0-9]+)?+" +
                "[$&+,:;=?@#|'<>.^*()%!-]?)");
        Matcher matcher = pattern.matcher(password);
        if (password.length() < 8 || password.contains(username) )
        {return false;}
        return (matcher.find() && matcher.group().equals(password));
    }

    @SuppressWarnings("unused") // will be used later
    public ArrayList<String> getUserInfo(String username, String password) {
        ArrayList<String> userInfo = new ArrayList <>();
        if(isValidUserName(username) && isValidPassword(username, password)) {
            userInfo.add(username);
            userInfo.add(password);
        }
        return userInfo;
    }
}