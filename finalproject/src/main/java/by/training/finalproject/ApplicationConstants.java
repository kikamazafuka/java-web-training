package by.training.finalproject;

import java.util.HashSet;
import java.util.Set;

public class ApplicationConstants {

    public static final String LOGIN_CMD_NAME = "loginUser";
    public static final String REGISTER_VIEW_CMD_NAME = "registerUserView";
    public static final String REGISTER_SAVE_CMD_NAME = "registerUserSave";
    public static final String VIEW_ALL_USERS_CMD_NAME = "viewAllUsers";
    public static final String CMD_REQ_PARAMETER = "commandName";
    public static final String VIEWNAME_REQ_PARAMETER = "viewName";
    public static final Set<String> ALL_COMMANDS = new HashSet<>();

    static {
        ALL_COMMANDS.add(LOGIN_CMD_NAME);
        ALL_COMMANDS.add(REGISTER_VIEW_CMD_NAME);
        ALL_COMMANDS.add(REGISTER_SAVE_CMD_NAME);
        ALL_COMMANDS.add(VIEW_ALL_USERS_CMD_NAME);
    }
}
