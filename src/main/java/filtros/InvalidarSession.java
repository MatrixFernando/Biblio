package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class InvalidarSession
 */
@WebFilter("/InvalidarSession")
public class InvalidarSession implements Filter {

    /**
     * Default constructor. 
     */
    public InvalidarSession() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		System.out.println("joojoj");
		HttpSession session = ((HttpServletRequest)request).getSession();
        // don't create if it doesn't exist
		System.out.println(session.getAttribute("NumEco"));
if(session.getAttribute("NumEco")==null) {
	//request.getRequestDispatcher("/index.html").forward(request, response);
System.out.println("ddddddddddoooooo");
System.out.println(session.getAttribute("NumEco"));
chain.doFilter(request, response);
} else {
	System.out.println("elseeeeeee");
	
	System.out.println(session.getAttribute("NumEco"));
	 request.getRequestDispatcher("/Codigo/InicioDeSistema.jsp").forward(request, response);
 	

}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
