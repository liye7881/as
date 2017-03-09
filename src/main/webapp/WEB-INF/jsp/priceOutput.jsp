<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <table class="table table-striped table-bordered">
            <tr>
                <td class="td-content" width="35%">名称</td>
                <td class="td-content" width="25%">价格</td>
                <td class="td-content" width="40%">Sku</td>
            </tr>
            <c:forEach items="${singleDto.items}" var="item">
            <tr>
                <td class="td-content">
                    <a href="${item.url}"><c:out value="${item.title}" /></a>
                </td>
                <td class="td-content">
                    <c:out value="${item.price}" />
                </td>
                <td class="td-content">
                    <c:out value="${item.skus}" />
                </td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="3">
                    <a href="${pageContext.request.contextPath}/price.htm"
                       class="btn btn-success">返回</a>
                </td>
            </tr>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>