<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            transition: background-color 0.3s, color 0.3s;
        }

        .container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            transition: background-color 0.3s, color 0.3s;
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            transition: border-color 0.3s, background-color 0.3s;
        }

        input[type="text"]:focus,
        input[type="date"]:focus,
        select:focus,
        textarea:focus {
            border-color: #007BFF;
            background-color: #f0f8ff;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .dark-mode {
            background-color: #333;
            color: #fff;
        }

        .dark-mode input[type="text"],
        .dark-mode input[type="date"],
        .dark-mode select,
        .dark-mode textarea {
            background-color: #555;
            color: #fff;
            border-color: #666;
        }

        .dark-mode input[type="submit"] {
            background-color: #444;
        }

        .dark-mode input[type="submit"]:hover {
            background-color: #222;
        }

        .toggle-switch {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .toggle-switch label {
            display: inline-flex;
            align-items: center;
            cursor: pointer;
            user-select: none;
        }

        .toggle-switch input {
            display: none;
        }

        .toggle-switch span {
            width: 40px;
            height: 20px;
            background-color: #ccc;
            border-radius: 20px;
            position: relative;
            transition: background-color 0.3s;
        }

        .toggle-switch span::after {
            content: "";
            width: 16px;
            height: 16px;
            background-color: #fff;
            border-radius: 50%;
            position: absolute;
            top: 2px;
            left: 2px;
            transition: transform 0.3s;
        }

        .toggle-switch input:checked + span {
            background-color: #007BFF;
        }

        .toggle-switch input:checked + span::after {
            transform: translateX(20px);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Create a New Task</h1>
        <div class="toggle-switch">
            <label>
                <input type="checkbox" id="darkModeToggle">
                <span></span>
            </label>
        </div>
        <form action="CreateTaskServlet" method="post" onsubmit="return validateForm()">
            <label for="title">Task Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="description">Task Description:</label>
            <textarea id="description" name="description" required></textarea>

            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" required>

            <label for="priority">Priority:</label>
            <select id="priority" name="priority" required>
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
            </select>

            <input type="submit" value="Create Task" id="createTask">
        </form>
    </div>

    <script>
        function validateForm() {
            var title = document.getElementById("title").value;
            var description = document.getElementById("description").value;
            var dueDate = document.getElementById("dueDate").value;
            var priority = document.getElementById("priority").value;

            if (title == "" || description == "" || dueDate == "" || priority == "") {
                alert("All fields must be filled out");
                return false;
            }
            return true;
        }

        document.getElementById('darkModeToggle').addEventListener('change', function() {
            document.body.classList.toggle('dark-mode');
            document.querySelector('.container').classList.toggle('dark-mode');
        });
    </script>
</body>
</html>
