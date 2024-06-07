<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assign Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Employee Affectation</h1>
    <form action="/employee/affecter" method="post">
        <div class="form-group">
            <label >Employee Name:</label>
            <select name="id" class="form-control" required>
                <c:forEach var="employee" items="${employees}">
                    <option value="${employee.id}">${employee.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label >Project Name:</label>
            <select name="projects" class="form-control" multiple required>
                <c:forEach var="project" items="${projects}">
                    <option value="${project.id}">${project.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="implication">Implication (%):</label>
            <input type="number" id="implication" name="implication" class="form-control" min="0" max="100" required>
        </div>
        <button type="submit" class="btn btn-primary">Affecter Employee</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
