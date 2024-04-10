<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bienvenue</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-image: url("./accueil.jpg");
      background-size:cover;
      background-position:center;
      background-repeat:no-repeat;
      background-color: #939597;
      opacity: 0; 
      animation: fadeIn 2s forwards;
    }
    
    @keyframes fadeIn {
      from { opacity: 0; }
      to { opacity: 1; }
    }
    
    .accueil {
      background-color: #f7f7f7;
      box-shadow: black 0px 0px 2px 2px;
      text-align: center;
      padding: 50px;
      
    }
    
    .titre {
      font-size: 36px;
      font-weight: bold;
      color: #333;
      position: relative;
    }
    .message {
      font-size: 20px;
      color: #666;
    }   
  </style>
</head>
<body>
  <div class="accueil">
    <h1 class="titre">Bienvenue !</h1>
    <p class="message">Heureux de vous voir sur notre site web.<br>Enrichissez vos connaissances et élargissez vos horizons en visitant notre site</p>
  </div>
  <form action="http://localhost:8080/projetJavaWeb/projet">
  <div class="boutton"><input type="submit" value="explorer"></div>  
  </form>
  
</body>
</html>
