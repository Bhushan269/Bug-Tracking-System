<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>User Registration</h1>
<form action="RegisterServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="manager">Project Manager</option>
        <option value="developer">Developer</option>
        <option value="tester">Tester</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
