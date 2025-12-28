import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ATM {

    private static List<User> usersList = new ArrayList<>();


    static{
        usersList.add(new User(1, "AL", "amy1"));
        usersList.add(new User(2, "LindaWilliams", "linda2"));
        usersList.add(new User(3, "SusanWilson", "susan3"));
        usersList.add(new User(4, "JamesThomas", "james4"));
        usersList.add(new User(5, "NancyHarrys", "nancy5"));
    }

    public static boolean checkUserName(String userName){
        for(User u : usersList){
            if(userName.equals(u.getUserName())){
                return true;
            }
        }
        return false;
    }
    private static User tempoU;
    public static boolean validateUser(String userName, String password){
        for(User u : usersList){
            if(userName.equals(u.getUserName()) && password.equals(u.getPassword())){

                tempoU = u;
                return true;
            }
        }
        return false;
    }

//    public static void printTempoU(){
//        System.out.println(tempoU.getUserID() +" "+ tempoU.getUserName() +" "+ tempoU.getPassword());
//    }

    public static User getUser(){
        return tempoU;
    }



}
