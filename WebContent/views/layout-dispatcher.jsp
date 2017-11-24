<%-- 
    Document   : layout-dispatcher
    Created on : Sep 2, 2017, 2:29:18 PM
    Author     : DuongNguyen
--%>

<%
    String view = request.getParameter("view");
    if (view.startsWith("home/")) {
        pageContext.forward("home-layout.jsp");
    } else if (view.startsWith("admin/")) {
        pageContext.forward("admin-layout.jsp");
    } else if (view.startsWith("error/")) {
        pageContext.forward("error-layout.jsp");
    } else {
        pageContext.forward("home-layout.jsp");
    }
%>
