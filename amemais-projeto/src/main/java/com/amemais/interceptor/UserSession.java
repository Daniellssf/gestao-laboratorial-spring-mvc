package com.amemais.interceptor;

import com.amemais.model.Administrator;
import com.amemais.model.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    Administrator administrator;
    Client client;

    public void addLoggedAdmin(Administrator administrator) {
        this.administrator = administrator;
    }

    public Administrator getLoggedAdmin() {
        return administrator;
    }

    public void removeLoggedAdmin() {
        this.administrator = null;
    }

    public void addLoggedClient(Client client) {
        this.client = client;
    }

    public Client getLoggedClient() {
        return client;
    }

    public void removeLoggedClient() {
        this.client = null;
    }
}
