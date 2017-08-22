package quote;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomQuote
 */
@WebServlet("/random-quote")
public class RandomQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomQuote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random rand = new Random();
		HttpSession sess = request.getSession();
		List<Quote> quotes = (List<Quote>) sess.getAttribute("quotes");
		
		if (quotes != null) {
			int index = rand.nextInt(quotes.size());
			Quote randQuote = quotes.get(index);
			sess.setAttribute("randQuote", randQuote);			
		} else {
			sess.setAttribute("randQuote", new Quote(
					"Autor nieznany",
					"Masz za malo cytacikow"));
		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/result_randQuote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
