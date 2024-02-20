<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>STUDENT ADMISSION</title>
    <link rel="stylesheet" href="admissionStyle.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-top: 10px;
            color: #333;
            font-weight: bold;
            text-align: left;
        }

        input,
        select,
        button {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
<h1>Admission application </h1>
<form action="studentServlet" method="post" enctype="multipart/form-data">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" min="1" required>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender" required>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
    </select>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="course">Desired Course:</label>
    <input type="text" id="course" name="course" required>

    <label for="year">Year of Admission:</label>
    <input type="text" id="year" name="year" required>

    <label for="passportFile">Upload Passport (JPG or PNG):</label>
    <input type="file" name="passportFile" id="passportFile" accept=".jpg,.png">

    <label for="diplomaFile">Upload Diploma (PDF only):</label>
    <input type="file" name="diplomaFile" id="diplomaFile" accept=".pdf">

    <button type="submit">Submit</button>
</form>
</body>
</html>
