<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<h2>User Registration</h2>
<form action="register" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <label for="role">Role:</label><br>
    <select id="role" name="role" required>
        <option value="Project Manager">Project Manager</option>
        <option value="Developer">Developer</option>
        <option value="Tester">Tester</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
