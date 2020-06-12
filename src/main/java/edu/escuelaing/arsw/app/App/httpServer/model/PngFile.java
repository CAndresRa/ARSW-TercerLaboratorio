package edu.escuelaing.arsw.app.App.httpServer.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;


public class PngFile implements FileBrowser {
    @Override
    public void getFile(String path, Socket clientSocket) throws IOException {
        BufferedImage in = ImageIO.read(new File( path));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        ImageIO.write(in, "PNG", buffer);
        dataOutputStream.writeBytes( "HTTP/1.1 200 \r\n");
        dataOutputStream.writeBytes("Content-Type: image/png \r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(buffer.toByteArray());
    }
}
