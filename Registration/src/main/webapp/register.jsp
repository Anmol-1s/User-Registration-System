<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>

    <h2>Registration Form</h2>

    <form action="/regForm" method="post">
        
        <label for="name">First Name:</label>
        <input type="text" id="name" name="name" required> <br><br>

        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" required> <br><br>
     
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required> <br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required> <br><br>

        <label for="city">City:</label>
        <select id="city" name="city" required>
            <option value="">Select City</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Delhi">Delhi</option>
            <option value="Bangalore">Bangalore</option>
            <option value="Hyderabad">Hyderabad</option>
        </select> <br><br>

        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="Male" required>
        <label for="male">Male</label>

        <input type="radio" id="female" name="gender" value="Female">
        <label for="female">Female</label>

        <input type="radio" id="other" name="gender" value="Other">
        <label for="other">Other</label> <br><br>

        <input type="submit" value="Register">
    </form>

</body>
</html>
