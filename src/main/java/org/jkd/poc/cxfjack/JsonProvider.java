package org.jkd.poc.cxfjack;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * Created by kdjayasu on 10/16/14.
 */
public class JsonProvider extends JacksonJaxbJsonProvider {

    public JsonProvider() {

        _mapperConfig.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,true);
        _mapperConfig.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

    }
}
