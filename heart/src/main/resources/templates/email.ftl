<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <style type="text/css">
        .container {
            position: relative;
            margin: auto;
            width: 400px;
            height: 300px;
            background-color: lightcyan;
        }
        .header {
            position: relative;
            top: 20px;
        }
        .body {
            position: relative;
            top: 50px;
            left: 50px;
        }
        .footer {
            position: relative;
            top: 100px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Hello, ${nickname}</h1>
        </div>
        <div class="body">
            这是您的验证码！
        </div>
        <div class="footer">
            <h2>${verificationCode}</h2>
        </div>
    </div>
</body>
</html>