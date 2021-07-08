package com.amemais.controller;

import com.amemais.interceptor.UserSession;
import com.amemais.model.Client;
import com.amemais.repository.ClientRepository;
import com.amemais.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    UserSession userSession;

    @RequestMapping(value = "/client/listExamsClient", method = RequestMethod.GET)
    public String autentication(Map<String, Object> model) {
        Client client = userSession.getLoggedClient();

        model.put("message1", "Bem vindo " + client.getNomeCliente());
        model.put("message2", "Ultimo Exame Realizado: " + client.getExame().getPdf()
                + " || Data de Recebimento: " + client.getExame().getData());
        return "/client/listExamsClient";
    }

}
