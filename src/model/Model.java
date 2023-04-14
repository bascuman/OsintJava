package model;

import controller.Controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Model implements Runnable{

    //Clase que se encarga de hacer requests https y devuelve el resultado al controlador cuando se encuentra un resultado statisfactorio
    private Controller c;

    private String usuario;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public Controller getC() {
        return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Model(Controller c){
        this.c= c;
    }

    @Override
    public void run() {
        usuario = c.getView().getUsernameField().getText();
        String[] urls = {"https://www.tiktok.com/@"+usuario+"/",
                "https://www.youtube.com/@"+usuario,
                "https://github.com/"+usuario,
                "https://open.spotify.com/user/"+usuario,
                "https://www.tumblr.com/"+usuario};
        for (int i = 0; i < urls.length; i++) {
            try {
                URL url = new URL(urls[i]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int status = con.getResponseCode();
                if (status < 299) {
                    c.getView().getOutputArea().append(urls[i]+"\n");
                }
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
