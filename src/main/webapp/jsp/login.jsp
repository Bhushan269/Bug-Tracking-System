<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>User Login</h1>
<form action="LoginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>
</body>
</html>
