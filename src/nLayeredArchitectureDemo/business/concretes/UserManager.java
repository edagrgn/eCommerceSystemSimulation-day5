package nLayeredArchitectureDemo.business.concretes;

import nLayeredArchitectureDemo.business.abstracts.UserService;
import nLayeredArchitectureDemo.core.GoogleRegisterService;
import nLayeredArchitectureDemo.dataAccess.abstracts.UserDao;
import nLayeredArchitectureDemo.dataAccess.concretes.HibernateUserDao;
import nLayeredArchitectureDemo.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserManager implements UserService {

    private UserDao userDao;
    private GoogleRegisterService googleRegisterService;

    public UserManager(UserDao userDao,GoogleRegisterService googleRegisterService) {
        this.userDao = userDao;
        this.googleRegisterService = googleRegisterService;
    }

    private List<String> emailList = new ArrayList<String>();
    private List<String> passwordList = new ArrayList<String>();

    public boolean isValidEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isVerificationLink(String email){
        return true;
    }

    @Override
    public void register(User user) {

        //check first nama and last name
        if(user.getFirstName().length()<3 && user.getLastName().length()<3) {
            System.out.println("Invalid character usage!Try again please.");
            return;
        }

        //password check
        if(user.getPassword().length()<6){
            System.out.println("Error! Insufficient or invalid character usage!");
            return;
        }

        //check mail
        if(user.getEmail().contains(user.getEmail())){
            System.out.println("Registered email!Try again please.");
        }
        else{
            System.out.println("Valid email! Please confirm your email address and confirmation code at "+user.getEmail());
        }

        if(isVerificationLink(user.getEmail())){
            System.out.println("Successfully registered!");
            emailList.add(user.getEmail());
            passwordList.add(user.getPassword());
            this.userDao.save(user);
            this.googleRegisterService.registerToSystem("google manager daki mesaj gelecek");
        }
        else{
            System.out.println("Please check your link in the email and try again.");
        }

    }


    @Override
    public void signIn(String email, String password) {

        if(emailList.contains(email) && passwordList.contains(password)){
            System.out.println("You have successfully logged in.");
        }
        else{
            System.out.println("Email address or password is incorrect! Please try again.");
        }
    }
}
