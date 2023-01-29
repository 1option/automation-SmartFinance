package constants;

import java.io.File;

public class Constant {

    public static class URLS {
        public static final String AUTHORIZATION_PAGE = "https://my-preprod.joy.money/login";
        public static final String LK_PAGE = "https://my-preprod.joy.money/user/loans";
        public static final String JIRA_PAGE = "https://docs.google.com/spreadsheets/d/1BuBdqABOpNC9LE0ebnaCBT1on9Rs0Exjpu84sW7Zq0E/edit#gid=1305118921";
    }

    public static class UserData {
        public static final String LOGIN_PHONE_NUMBER = "79131111111";
        public static final String MOCK_PHONE_NUMBER = "79000000001";
        public static final String RECOVERY_PHONE_NUMBER = "79999999990";
        public static final String PASSWORD = "123456";
        public static final String SMS = "1234";
        public static final String RECOVERY_SMS = "1234";
        public static final File ACCOUNTS_LOG_FILE = new File("src/test/files/accounts.txt");
        public static final File ACCOUNTS_LOG_DIR = new File("src/test/files/");
        public static final File PASSPORT_FILE = new File("src/test/files/passport.jpg");
        public static final String PAN_0 = "4000000000000000";
        public static final String PAN_4 = "4000000000000004";

    }


}
