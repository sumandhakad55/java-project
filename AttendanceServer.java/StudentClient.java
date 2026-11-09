import java.io.*;
import java.net.*;

public class StudentClient {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 5000;

        try (
            Socket socket = new Socket(host, port);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            )
        ) {

            System.out.println(
                "Connecting to Campus Attendance Server at localhost:5000..."
            );

            System.out.println(
                "Connected successfully!"
            );

            String studentName = "Rahul Verma";

            System.out.println(
                "Sending student name: \"" + studentName + "\""
            );

            out.println(studentName);

            String response = in.readLine();

            System.out.println(
                "\n--- Response from Server ---"
            );

            System.out.println(response);

            System.out.println("Disconnected.");

        } catch (IOException e) {

            System.out.println(
                "[ERROR] Client error: " + e.getMessage()
            );
        }
    }
}