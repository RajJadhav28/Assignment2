package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pro3
 */
@WebServlet("/Pro3")
public class Pro3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pro3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Integer visitCount=(Integer)session.getAttribute("visitCount");
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(name.equals("quastech")&&pass.equals("root")) {
		if(visitCount==null) {
			visitCount=0;
		}
		visitCount++;
		session.setAttribute("visitCount", visitCount);
		/*out.print("You have visited"+visitCount+" times");*/
		RequestDispatcher rd=request.getRequestDispatcher("Pro31");
		rd.forward(request, response);
		}else {
			out.print("<font color='red'>Sorry username or password mismatch</font>");
			RequestDispatcher rd=request.getRequestDispatcher("Pro3.html");
			rd.include(request, response);
		}
	}

}
