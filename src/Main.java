import nLayeredArchitectureDemo.business.abstracts.UserService;
import nLayeredArchitectureDemo.business.concretes.UserManager;
import nLayeredArchitectureDemo.core.GoogleRegisterAdapter;
import nLayeredArchitectureDemo.dataAccess.concretes.HibernateUserDao;
import nLayeredArchitectureDemo.entities.concretes.User;

public class Main {


    public static void main(String[] args) {

     User user1 = new User(23,"Eda","Gurgen","edarumeysagurgen@gmail.com","Udf12khf");
     User user2 = new User(42,"Merve","Aydogan","test@test.","ws");
     User user3 = new User(77,"t","a","test2@test2.info","989898nnn");

        UserService userService = new UserManager(new HibernateUserDao(),new GoogleRegisterAdapter());

        //Successful
        userService.register(user1);
        userService.signIn(user1.getEmail(),user1.getPassword());


        //contains email and password error
        userService.register(user2);
        userService.signIn(user2.getEmail(),user2.getPassword());


        //Contains character errors in first name and last name
        userService.register(user3);
        userService.signIn(user3.getEmail(),user3.getPassword());




    }
}
