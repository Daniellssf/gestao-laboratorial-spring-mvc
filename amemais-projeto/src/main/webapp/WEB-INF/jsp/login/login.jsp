<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
    <link rel="stylesheet" href="<c:url value='/login.css'/>">
    </head>
    <center>
    <body>
    <h1 class="tituloDaPagina">Trabalho Final de Projeto de Bloco: Desenvolvimento JAVA</h1>
    <h2 class="nomeDoSistema">Sistema de Gestão Laboratorial</h2>
        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form class="login" method="post" action="<%=request.getContextPath()%>/login/login">
                        <h3 class="messageError">${message}</h3>
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="username" class="login__input" placeholder="User name">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="password" name="password" class="login__input" placeholder="Password">
                        </div>
                        <button class="button login__submit">
                            <span class="button__text">Entrar</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>
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



