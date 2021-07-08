<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value='/listPageClient.css' />">
    </head>
    <center>
        <body>
            <div class="container">
                <h1 class="tituloDaPagina">Lista de Exames Realizados pelo Cliente</h1>
                <h3 class="saudacaoCliente">${message1}!</h3>
                <br><br>
                <p class="textoExameDoClient">${message2}</p>
                <br>
            </div>
            <div class="botaoSair">
                <a class="button login__submit" role="button" href="<%=request.getContextPath()%>/login/logout">Sair da Sessão</a>
            </div>
        </body>
    </center>
</html>