package edu.escuelaing.arsw.app.App.httpServer;
import java.net.*;
import java.io.*;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35002);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35002");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        Integer count = 0;
        String[] header = null;
        while ((inputLine = in.readLine()) != null) {
            if(count == 0) {
                 header = inputLine.split(" ");
            }
            count ++;
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        String path = header[1].substring(1);
        System.out.println(path);
        if(header.length > 0){
            BrowserService browserService = new BrowserService(path);
        }

        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n" + "</head>"
                + "<body>"
                + "My Web Site"
                + "</body>"
                + "</html>" + inputLine;

        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}