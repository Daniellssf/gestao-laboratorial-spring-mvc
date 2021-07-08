<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
    <head>
        <link rel="stylesheet" href="<c:url value='/edit.css' />">
    </head>
<center>
    <body>
    <h1 class="tituloDaPagina">Área de Atualização de Cliente</h1>
        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form class="login" method="post" action="<%=request.getContextPath()%>/administrator/edit">
                        <h3 class="messageError">${message}</h3>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="nomeCliente" class="login__input" value="${client.nomeCliente}">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="username" class="login__input" value="${client.username}">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="password" class="login__input" value="${client.password}">
                        </div>
                        <input type="hidden" name="id" value="${client.id}" >

                       <p class="textoExameDoClient">Exame do Cliente: ${exam}</p>

                        <button class="button login__submit">
                            <span class="button__text">Atualizar</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>
                        <a class="button login__submit" href="<%=request.getContextPath()%>/administrator/list" role="button">Listar Cliente</a>
                        <a class="button login__submit" href="<%=request.getContextPath()%>/login/logout" role="button">Sair da Sessão</a>
                    </form>
                </div>
                <div class="screen__background">
                    <span class="screen__background__shape screen__background__shape4"></span>
                    <span class="screen__background__shape screen__background__shape3"></span>
                    <span class="screen__background__shape screen__background__shape2"></span>
                    <span class="screen__background__shape screen__background__shape1"></span>
                </div>
            </div>
        </div>
    <p class="rodapeTexto">Sistema desenvolvido por <a href="https://www.linkedin.com/in/daniel-farias-44a4ab136/" target="_blank">@daniellssf</a></p>
    </body>
</center>
</html>
