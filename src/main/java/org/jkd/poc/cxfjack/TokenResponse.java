package org.jkd.poc.cxfjack;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kdjayasu on 10/16/14.
 */
@XmlRootElement(name = "tokenResponse")
public class TokenResponse {

    public TokenResponse(String token, String expiredAt) {
        this.token = token;
        this.expiredAt = expiredAt;
    }

    private String token;

    @XmlElement(name = "expired_at")
    private String expiredAt;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }
}
