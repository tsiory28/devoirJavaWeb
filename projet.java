package projetJavaWeb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class projet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String[] QUESTIONS = {
        "Comment allez-vous aujourd'hui ?",
        "Comment évaluez-vous votre niveau de stress actuel sur une échelle de 1 à 10 ?",
        "Combien d'heures de sommeil avez-vous eu la nuit dernière ?",
        "Quand avez-vous fait de l'exercice physique pour la dernière fois ?",
        "Quel est votre sentiment dominant aujourd'hui ? Bonheur, tristesse, colère, anxiété, autre ?"
    };
    
    public projet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Integer currentQuestionIndex = (Integer) session.getAttribute("currentQuestionIndex");
        if (currentQuestionIndex == null) {
            currentQuestionIndex = 0;
        }

        String question = QUESTIONS[currentQuestionIndex];
        String userResponse = request.getParameter("userResponse");

        if (userResponse != null && !userResponse.isEmpty()) {
            saveResponseToDatabase(userResponse);
            currentQuestionIndex++;
            session.setAttribute("currentQuestionIndex", currentQuestionIndex);
        }

        if (currentQuestionIndex >= QUESTIONS.length) {
//            out.println("<html><body><h1>Merci pour vos réponses !</h1></body></html>");
        	class ScriptLauncher extends HttpServlet {
        	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	        // Création du dispatcher pour rediriger vers un autre script
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8080/projetJavaWeb/AfficherReconfortServlet");
        	        dispatcher.forward(request, response);
        	    }
        	}
            return;
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Chat</title>");
        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial, sans-serif;");
        out.println("margin: 0;");
        out.println("padding: 0;");
        out.println("background-color: #f4f4f4;");
        out.println("}");

        out.println(".container {");
        out.println("max-width: 800px;");
        out.println("margin: 20px auto;");
        out.println("padding: 20px;");
        out.println("background-color: #fff;");
        out.println("border-radius: 8px;");
        out.println("box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("}");

        out.println(".message {");
        out.println("margin-bottom: 15px;");
        out.println("padding: 10px;");
        out.println("border-radius: 5px;");
        out.println("background-color: #f9f9f9;");
        out.println("}");

        out.println(".message input[type=\"text\"] {");
        out.println("width: calc(100% - 70px);");
        out.println("margin-right: 10px;");
        out.println("padding: 8px;");
        out.println("border: 1px solid #ccc;");
        out.println("border-radius: 5px;");
        out.println("}");

        out.println(".message input[type=\"submit\"] {");
        out.println("padding: 8px 15px;");
        out.println("background-color: #007bff;");
        out.println("color: #fff;");
        out.println("border: none;");
        out.println("border-radius: 5px;");
        out.println("cursor: pointer;");
        out.println("}");

        out.println(".message input[type=\"submit\"]:hover {");
        out.println("background-color: #0056b3;");
        out.println("}");

        out.println(".messageElement {");
        out.println("animation-name: fadeIn;");
        out.println("animation-duration: 1s;");
        out.println("}");

        out.println("@keyframes fadeIn {");
        out.println("from { opacity: 0; }");
        out.println("to { opacity: 1; }");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<div class=\"message\">");
        out.println("<p>" + question + "</p>"); 
        out.println("<form action=\"projet\" method=\"post\">"); 
        out.println("<input type=\"text\" id=\"userInput\" name=\"userResponse\" placeholder=\"Votre réponse...\">");
        out.println("<input type=\"submit\" value=\"Envoyer\">");
        out.println("</form>");
        out.println("</div>");
        out.println("<div id=\"chatArea\">");
        for (int i = 0; i <= currentQuestionIndex; i++) {
            out.println("<div class=\"messageElement\">" + QUESTIONS[i] + "</div>");
        }
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void saveResponseToDatabase(String response) {
      
    }
}
