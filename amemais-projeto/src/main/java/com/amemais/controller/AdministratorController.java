package com.amemais.controller;

import com.amemais.model.Client;
import com.amemais.model.Exam;
import com.amemais.repository.ClientRepository;
import com.amemais.repository.ExamRepository;
import org.h2.jdbc.JdbcSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class AdministratorController {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/administrator/criar", method = RequestMethod.GET)
    public String criarPagina() {
        return "/administrator/criar";
    }

    @RequestMapping(value = "/administrator/criar", method = RequestMethod.POST)
    public void create(@RequestParam("nomeCliente") String nomeCliente,
                       @RequestParam("password") String password,
                       @RequestParam("username") String username,
                       @RequestParam("exame") String exame,
                       @RequestParam("data") String data,
                       Map<String, Object> model) {
        if (!nomeCliente.isEmpty() || !password.isEmpty() || !username.isEmpty() || !exame.isEmpty() || !data.isEmpty()) {
            try {
                Exam exam = new Exam(exame, data);
                Client client = new Client(nomeCliente, password, username, exam);
                examRepository.save(exam);
                clientRepository.save(client);
                model.put("message", "Cliente " + client.getNomeCliente() + " cadastrado com sucesso!");
            }catch (Exception e) {
                model.put("message", "Username já está em uso!");
            }
        } else {
            model.put("message", "Todos os campos devem ser preenchidos!");
        }
    }

    @RequestMapping(value = "/administrator/list", method = RequestMethod.GET)
    public String listaPagina(Map<String, Object> model) {
        Iterable<Client> all = clientRepository.findAll();
        model.put("clientList", all);
        return "administrator/list";
    }

    @RequestMapping(value = "/administrator/edit", method = RequestMethod.GET)
    public String editarPagina(@RequestParam("id") Long id,
                               Map<String, Object> model) {
        Client client = clientRepository.findOne(id);
        Exam exam = examRepository.findOne(id);
        model.put("client", client);
        model.put("exam", exam);
        return "/administrator/edit";
    }

    @RequestMapping(value = "/administrator/edit", method = RequestMethod.POST)
    public void editarCliente(@RequestParam("id") Long id,
                              @RequestParam("nomeCliente") String nomeCliente,
                              @RequestParam("password") String password,
                              @RequestParam("username") String username,
                              Map<String, Object> model) {
        Client client = clientRepository.findOne(id);
        client.setNomeCliente(nomeCliente);
        client.setPassword(password);
        client.setUsername(username);

        clientRepository.save(client);

        model.put("client", client);
        model.put("message", "O cliente " + client.getNomeCliente() + " foi editado com Sucesso!");
    }

    @RequestMapping(value = "/administrator/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id, Map<String, Object> model) {

        Client c = clientRepository.findOne(id);
        Long idExam = null;
        if(c.getExame() != null) {
            idExam = c.getExame().getId();
        }
        clientRepository.delete(id);
        if (idExam != null) {
            examRepository.delete(idExam);
        }

        model.put("message", "O cliente foi removido com sucesso!");
        return "redirect:/administrator/list";
    }
}
