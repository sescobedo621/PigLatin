package pigLatinWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PigLatin")
public class PigLatinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pigLatin.jsp").forward(request, response);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phrase = req.getParameter("phrase");
		PigLatin pigLatin = new PigLatin(phrase);
		HttpSession session = req.getSession();
		if(session.getAttribute("translations") == null){
			session.setAttribute("translations", new ArrayList<String>());
		}
		pigLatin.translatePhrase();
		req.setAttribute("wordTranslated", pigLatin.getWordTranslated());
		if(pigLatin != null){
			
			ArrayList<String> translationList =  (ArrayList<String>) session.getAttribute("translations");
			translationList.add(pigLatin.getWordTranslated());
			req.getRequestDispatcher("pigLatin.jsp").forward(req, resp);

		}
			
	}
}
