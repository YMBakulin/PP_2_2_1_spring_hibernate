package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      User user1 = null;
      Car car = null;

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      user1 = new User("User1", "Lastname1", "user1@mail.ru");
      car = new Car("Model1", 12);
      user1.setUserCar(car);
      userService.add(user1);

      user1 = new User("User2", "Lastname2", "user2@mail.ru");
      car = new Car("Model2", 2);
      user1.setUserCar(car);
      userService.add(user1);

      user1 = new User("User3", "Lastname3", "user3@mail.ru");
      car = new Car("Model3", 115);
      user1.setUserCar(car);
      userService.add(user1);

      user1 = new User("User4", "Lastname4", "user4@mail.ru");
      car = new Car("Model4", 34);
      user1.setUserCar(car);
      userService.add(user1);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car model = " + user.getUserCar().getModel());
         System.out.println("Car series = " + user.getUserCar().getSeries());
         System.out.println();
      }

      //В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера,
      // владеющего машиной по ее модели и серии.
      Car carByModelSeries = carService.getCarByModelSeries("Model3", 115);
      System.out.println("Id = " + carByModelSeries.getUser().getId());
      System.out.println("First Name = " + carByModelSeries.getUser().getFirstName());
      System.out.println("Last Name = " + carByModelSeries.getUser().getLastName());
      System.out.println("Email = " + carByModelSeries.getUser().getEmail());
      System.out.println("Car model = " + carByModelSeries.getModel());
      System.out.println("Car series = " + carByModelSeries.getSeries());

      context.close();
   }
}
