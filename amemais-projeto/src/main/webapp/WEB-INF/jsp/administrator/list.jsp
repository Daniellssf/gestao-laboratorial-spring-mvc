<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value='/listPageAdm.css' />">
    </head>
    <center>
    <body>
        <div class="container">
            <div class="w-75 p-3" style="background-color: #eee;">
            <h1 class="tituloDaPagina">
                Lista de Clientes Cadastrados
            </h1>

            <table class="table table-success table-striped">
             <h3 class="messageError">${message}</h3>
             <tr>
                <th>
                    Editar Cliente
                </th>
                 <th>
                    Deletar Cliente
                </th>
                <th>
                    Id
                </th>
                <th>
                    Nome
                </th>
                 <th>
                    Username
                </th>
                 <th>
                    Senha do USuário
                </th>
                 <th>
                    Exame Realizado
                </th>
              </tr>
              <c:forEach var="client" items="${clientList}">
               <tr>
                    <td>
                        <a href="<%=request.getContextPath()%>/administrator/edit?id=${client.id}">Editar</a>
                    </td>
                   <td>
                        <a href="<%=request.getContextPath()%>/administrator/delete?id=${client.id}">Deletar</a>
                    </td>
                    <td>
                        <c:out value="${client.id}" />
                    </td>
                    <td>
                        <c:out value="${client.nomeCliente}" />
                    </td>
                   <td>
                        <c:out value="${client.username}" />
                    </td>
                   <td>
                        <c:out value="${client.password}" />
                    </td>
                   <td>
                        <c:out value="${client.exame}" />
                    </td>
                </tr>
              </c:forEach>
             </table>

            <a class="button login__submit" href="<%=request.getContextPath()%>/administrator/criar" role="button">Adicionar Cliente</a>
            <a class="button login__submit" href="<%=request.getContextPath()%>/login/logout" role="button">Sair da Sessão</a>
            </div>
        </div>
        <p class="rodapeTexto">Sistema desenvolvido por <a href="https://www.linkedin.com/in/daniel-farias-44a4ab136/" target="_blank">@daniellssf</a></p>
    </body>
    </center>
</html>