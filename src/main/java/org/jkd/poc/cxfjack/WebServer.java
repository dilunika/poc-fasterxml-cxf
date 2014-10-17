package org.jkd.poc.cxfjack;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 * Created by kdjayasu on 10/16/14.
 */
public class WebServer {

    public WebServer() {

        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(TokenService.class);
        sf.setResourceProvider(TokenService.class, new SingletonResourceProvider(new TokenService()));
        sf.setProvider(new JsonProvider());
        sf.setAddress("http://localhost:9000/");
        sf.create();
    }

    public static void main(String[] args) {

        new WebServer();
        System.out.println("Server started .....");
    }


}
