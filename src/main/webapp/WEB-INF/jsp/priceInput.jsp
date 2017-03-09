<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <form:form commandName="singleDto"
                   id="priceForm"
                   action="${pageContext.request.contextPath}/price.htm"
                   method="POST">
            <table class="table table-striped table-bordered">
                <tr>
                    <td class="field-content" width="25%">输入</td>
                    <td class="field-content" width="75%">
                        <form:textarea path="input" rows="10" cols="100" />
                        <form:errors path="input"  class="label label-danger" />
                    </td>
                </tr>
                <tr>
                    <td class="field-content" colspan="2" align="left">
                        <button id="submitBtn" type="submit" class="btn btn-success" name="action">提交</button>
                    </td>
                </tr>
            </table>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>