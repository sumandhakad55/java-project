import java.io.*;
import java.net.*;

public class AttendanceServer {

    public static void main(String[] args) {

        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println(
                "[SERVER] Attendance Server running on port " + port + "..."
            );

            System.out.println(
                "[SERVER] Waiting for student to connect..."
            );

            try (
                Socket socket = serverSocket.accept();

                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );

                PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
                )
            ) {

                System.out.println(
                    "[SERVER] Connected to student at "
                    + socket.getInetAddress()
                );

                String studentName = in.readLine();

                System.out.println(
                    "[RECEIVED] Marking attendance for: "
                    + studentName
                );

                out.println(
                    "Attendance Confirmed for "
                    + studentName + "!"
                );

                System.out.println(
                    "[SERVER] Confirmation dispatched. Closing connection."
                );
            }

        } catch (IOException e) {

            System.out.println(
                "[ERROR] Server error: " + e.getMessage()
            );
        }
    }
}