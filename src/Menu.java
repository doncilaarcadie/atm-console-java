import java.util.Scanner;

public class Menu {
    public static void startMenu(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to ATM");
            System.out.print("Please input your username: ");
            String userName = sc.nextLine();


            if (ATM.checkUserName(userName)) {
                System.out.print("Please input your password:");
                String password = sc.nextLine();
                boolean flagForQuit = false;
                if(ATM.validateUser(userName, password)){
                    User user = ATM.getUser();
                    System.out.println("\nWelcome " + userName);

                    do {
                        System.out.println("""
                                \nPlease select an option:
                                1). Check balance
                                2). Withdraw money
                                3). Deposit
                                4). Change password
                                6). Show history
                                5). Quit""");

                        String userOption = sc.nextLine();

                        switch (userOption) {
                            case "1" -> checkBalance(user);
                            case "2" -> withdrawMoney(user);
                            case "3" -> depositMoney(user);
                            case "4" -> changePassword(user);
                            case "5" -> flagForQuit = true;
                            //case "6" -> showHistory(user);
                            default -> System.out.println("Inexistent option");
                        }
                    } while (!flagForQuit);

                }else{
                    System.out.println("Wrong password, please try again\n");
                }

            }else {
                System.out.println("Inexistent username, please rewiev \n");
            }
        }
    }

    public static void checkBalance(User user){
        Scanner sc = new Scanner(System.in);
        String userAccountOption = "";
        while(!userAccountOption.equals("4")) {
            System.out.println("""
                    \nPlease select your Account type: 
                    1). Current Account
                    2). Saving Account
                    3). Business Account
                    4). Quit""");

            userAccountOption = sc.nextLine();
            switch (userAccountOption) {
                case "1":
                    System.out.println("Your Current Account Balance is: "
                            + user.getCurrentAccount().getBalance());
                    break;
                case "2":
                    System.out.println("Your Saving Account Balance is: "
                            + user.getSavingAccount().getBalance());
                    break;
                case "3":
                    System.out.println("Your Business Account Balance is: "
                            + user.getBusinessAccount().getBalance());
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid Account type!");
                    break;

            }
        }
    }

    public static void withdrawMoney(User user){
        Scanner sc = new Scanner(System.in);
        String userAccountOption;
        while(true) {
            System.out.println("""
                    \nFor withdraw select your Account type: 
                    1). Current Account
                    2). Saving Account
                    3). Business Account
                    4). Quit""");
            userAccountOption = sc.nextLine();
            if(userAccountOption.equals("4")){
                break;
            }

            System.out.print("Please select amount to withdraw: ");
            while(true) {
                try {
                    double depoAmount = sc.nextDouble();
                    sc.nextLine(); //without this line default will be triggered
                    switch (userAccountOption) {
                        case "1" -> user.getCurrentAccount().withdraw(depoAmount);
                        case "2" -> user.getSavingAccount().withdraw(depoAmount);
                        case "3" -> user.getBusinessAccount().withdraw(depoAmount);
                        default -> System.out.println("""
                                DECLINED !!!
                                Invalid Account type!""");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Error: " + e + "\nPlease review your input!");
                    sc.nextLine();// consume buffer inside the Scanner, otherwise infinite loop error catch
                }
            }
        }
    }

    public static void depositMoney(User user){
        Scanner sc = new Scanner(System.in);
        String userAccountOption = "";
        while(true) {
            System.out.println("""
                    \nFor deposit select your Account type: 
                    1). Current Account
                    2). Saving Account
                    3). Business Account
                    4). Quit""");
            userAccountOption = sc.nextLine();
            if(userAccountOption.equals("4")){
                break;
            }

            System.out.print("Please enter deposit amount: ");
            while(true) {
                try {
                    double depoAmount = sc.nextDouble();
                    sc.nextLine(); //without this line default will be triggered
                    switch (userAccountOption) {
                        case "1" -> user.getCurrentAccount().deposit(depoAmount);
                        case "2" -> user.getSavingAccount().deposit(depoAmount);
                        case "3" -> user.getBusinessAccount().deposit(depoAmount);
                        default -> System.out.println("""
                                \nDECLINED !!!
                                Invalid Account type!""");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Error: " + e + "\nPlease review your input!");
                    sc.nextLine();// consume buffer inside the Scanner, otherwise infinite loop error catch
                }
            }
        }

    }

    public static void changePassword(User user){
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your old password: ");
        String oldPassword = sc.nextLine();
        if(!oldPassword.equals(user.getPassword())){
            System.out.println("Wrong password, process aborted!");
            return;
        }
        System.out.print("""
                Enter new password
                the password must be at least 4 characters long
                the password muat contain at least one digit: """);
        String newPassword = sc.nextLine();
        System.out.print("Confirm your password: ");
        String confirmPassword = sc.nextLine();
        if(oldPassword.equals(user.getPassword()) &&
                newPassword.matches(".*\\d.*") && //regex for at least one digit in string
                newPassword.equals(confirmPassword) &&
                newPassword.length() >=4){
            user.setPassword(newPassword);
            System.out.println("The password was successfully changed");
        }else{
            System.out.println("Sorry, password didn't met the requirements! Try again.");
        }
    }


}
