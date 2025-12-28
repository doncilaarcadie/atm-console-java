import java.util.List;

public class User {
    private int userID;
    private String userName;
    private String password;

    //private Account account = new Account();
    private CurrentAccount currentAccount = new CurrentAccount();
    private SavingAccount savingAccount = new SavingAccount();
    private BusinessAccount businessAccount = new BusinessAccount();




    public User(int userID, String userName, String password) {
        if (userID > 0) {
            this.userID = userID;
        }
        this.userName = userName;
        this.password = password;
        // account = new Account(this.userID, 0);


    }

    //getters and setters for user
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getters for accounts

//    public Account getAccount() {
//        return account;
//    }
    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }
    public SavingAccount getSavingAccount() {
        return savingAccount;
    }
    public BusinessAccount getBusinessAccount() {
        return businessAccount;
    }

}