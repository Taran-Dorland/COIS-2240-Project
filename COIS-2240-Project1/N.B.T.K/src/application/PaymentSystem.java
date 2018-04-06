package application;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
*
*/
public class PaymentSystem extends Application {

   static LocalDateTime currentTime = LocalDateTime.now();
   ArrayList<Payment> payments = new ArrayList<Payment>();

   @Override
   public void start(Stage primaryStage) {
       Button btn = new Button();
       btn.setText("Make Payment");
       btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Payment payment = new Payment();
               payment = getPaymentDetails(payment);
               payments.add(payment);
//System.out.println("Hello World!");
           }
       });

       Button btn2 = new Button();
       btn2.setText("Get Payment History");
       btn2.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               getPaymentDetails();
//System.out.println("Hello World!");
           }
       });
       btn.setTranslateY(30);
       btn2.setTranslateY(-30);

       StackPane root = new StackPane();
       root.getChildren().add(btn);
       root.getChildren().add(btn2);

       Scene scene = new Scene(root, 300, 250);

       primaryStage.setTitle("Hello World!");
       primaryStage.setScene(scene);
       primaryStage.show();
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
       launch(args);
   }

   public static Payment getPaymentDetails(Payment payment) {
       Scanner scan = new Scanner(System.in);

       while (true) {
           try {
               System.out.println("Choose payment type: ");
               System.out.println("1. Credit Card\n2. Debit Card\n3. Cash\n>>>");
               int choice = Integer.parseInt(scan.nextLine());
               if (choice < 1 || choice > 3) {
                   System.out.println("Wrong choice!Enter again\n>>>");
                   continue;
               }
               payment.setPayment_Type(choice);
               payment.setPaymentDate(currentTime.toString());
           } catch (NumberFormatException e) {
               System.out.println("Not a number! Enter again\n>>>");
           }

           if (payment.getPayment_Type() == 1 || payment.getPayment_Type() == 2) {
               System.out.println("///////////////Enter Card Details///////////////// ");

               System.out.println("Enter card number : ");
               payment.setCard_No(scan.nextInt());
               scan.nextLine();
               System.out.println("Enter the billing address:  ");
               payment.setBillingAddress(scan.nextLine());

               System.out.println("Enter cvv code: ");
               payment.setCvv(scan.nextInt());
               scan.nextLine();
               System.out.println("Enter city: ");
               payment.setCity(scan.nextLine());

               System.out.println("Enter the province:");
               payment.setProvince(scan.nextLine());

               System.out.println("Enter state: ");
               payment.setState(scan.nextLine());

               System.out.println("Enter Amount to Be Paid");
               payment.setAmount(scan.nextDouble());

           } else {
               System.out.println("Enter the amount paid: ");
               payment.setAmount(scan.nextDouble());
           }
           scan.nextLine();
           System.out.println(payment.getPaymentDetails());
           break;
       }
       return payment;
   }

   public void getPaymentDetails() {
       for (Payment i : payments) {
           System.out.println(i);
       }
   }
}

