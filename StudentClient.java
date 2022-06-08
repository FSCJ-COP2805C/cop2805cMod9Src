// StudentClient.java
// gets input from user and sends to server

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StudentClient {

    // Host name or ip
    final static String HOST = "localhost";
    final static int PORT    = 8000;

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);

        // input variables
        String name = "";
        String street = "";
        String city = "";
        String state = "";
        String zip = "";
        
        // get input
        System.out.print("Please enter the student's name: ");
        name = input.nextLine();
        System.out.print("Please enter the student's street: ");
        street = input.nextLine();
        System.out.print("Please enter the student's city: ");
        city = input.nextLine();
        System.out.print("Please enter the student's state: ");
        state = input.nextLine();
        System.out.print("Please enter the student's zipcode: ");
        zip = input.nextLine();
        
        // connect to the server
        try (Socket socket = new Socket(HOST, PORT); 
              ObjectOutputStream toServer =
                    new ObjectOutputStream(socket.getOutputStream());) { 
                           
            // create a Student object and send to the server
            StudentAddress s =
                    new StudentAddress(name, street, city, state, zip);
            toServer.writeObject(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}