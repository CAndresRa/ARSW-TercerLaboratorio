package edu.escuelaing.arsw.app.App.urlManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLManager {
    public static void main(String[] args) {
        String url = args[0];
        try{
            URL siteUrl = new URL(url);
            System.out.println("Protocolo: " + siteUrl.getProtocol());
            System.out.println("Authority: " + siteUrl.getAuthority());
            System.out.println("Host: " + siteUrl.getHost());
            System.out.println("Port: " + siteUrl.getPort());
            System.out.println("Path: " + siteUrl.getPath());
            System.out.println("Query: " + siteUrl.getQuery());
            System.out.println("File: " + siteUrl.getFile());
            System.out.println("Ref: " + siteUrl.getRef());
        } catch (MalformedURLException e){
            Logger.getLogger(URLManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
