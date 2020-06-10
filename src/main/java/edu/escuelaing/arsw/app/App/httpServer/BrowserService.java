package edu.escuelaing.arsw.app.App.httpServer;

public class BrowserService {
    File htmlFile;
    File pngFile;
    public BrowserService(String filePath){
        if(filePath.contains(".html")){
            htmlFile = new HtmlFile();
        }
        else if (filePath.contains(".png")){
            pngFile = new PngFile();
        }
    }
}
