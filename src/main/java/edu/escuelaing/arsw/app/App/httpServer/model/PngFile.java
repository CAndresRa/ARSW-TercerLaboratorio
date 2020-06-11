package edu.escuelaing.arsw.app.App.httpServer.model;


import edu.escuelaing.arsw.app.App.httpServer.model.FileBrowser;

import java.io.*;
import java.util.Base64;

public class PngFile implements FileBrowser {
    @Override
    public String getFile(String path) throws IOException {
        File file =  new File(path);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[ 4096 ];
        int bytesRead;
        while ((bytesRead = in.read(data, 0, data.length)) != -1 ) {
            buffer.write(data,0, bytesRead);
        }
        in.close();
        String encodedString = Base64.getEncoder().encodeToString(buffer.toByteArray());

        String output =  "HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                         "<html><img src=\"data:image/png;base64, " + encodedString + "\" alt="
                         + "\"Red dot\""  + "/></html>";

        return output;
    }

}
