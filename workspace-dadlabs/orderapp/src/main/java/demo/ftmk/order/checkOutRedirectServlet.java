package demo.ftmk.order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class checkOutRedirectServlet
 */
@WebServlet("/demo/checkOutRedirectServlet")
public class checkOutRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkOutRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Get orderedProduct from session
		HttpSession session = request.getSession();
		List<OrderedProduct> orderedProducts = (List<OrderedProduct>) session.getAttribute("orderedProducts");
		
		// Forward servlet to zeroOrder.html if orderedProducts does not exist
		RequestDispatcher dispatcher;
		if( orderedProducts== null) {
			System.out.println("No order");
			dispatcher = request.getRequestDispatcher("zeroOrder.html");
			dispatcher.forward(request, response);
		}else {
			//calculate total quantity and total order
			//Invoke the appropriate method from orderDataManager
			OrderDataManager orderDataManager = new OrderDataManager();
			Order order = orderDataManager.processOrder(orderedProducts);
			
			//Display details of order
			PrintWriter writer = response.getWriter();
			writer.println("<html>"); 
			writer.println("<strong>Order Number : </strong>" + order.getOrderId() + "<br><br>"); 
			writer.println("<strong>List of Ordered Products</strong><br><br><br>"); 
			writer.println("<table>"); 
			writer.println("<tr>"); 
			writer.println("<th>Product</th>"); 
			writer.println("<th>Quantity</th>"); 
			writer.println("<th>Price per Unit (RM)</th>"); 
			writer.println("</tr>"); 
			
			List<OrderedProduct> items = order.getOrderedProducts();
			for (OrderedProduct item: items) {
				writer.println("<tr>");
				writer.println("<td>" + item.getProduct().getName() + "</td>"); 
				writer.println("<td>" + item.getQuantity() + "</td>"); 
				writer.println("<td>" + item.getProduct().getPrice() + "</td>"); 
				writer.println("</tr>");
			}
			writer.println("</table>"); 
			writer.println("<br><br>Total Quantity : " + order.getTotalQuantity()); 
			writer.println("<br>Service Tax : RM " + String.format("%.2f", order.getServiceTax())); 
			writer.println("<br>Total Amount : RM " + String.format("%.2f", order.getTotalAmount())); 
			writer.println("<br><br>This order is made on " + order.getOrderDate()); 
			writer.println("<br><br><a href=\"..\\index.jsp\">Home</a>"); 
			writer.println("</html>");
		}
		//Remove attribute from session
		session.removeAttribute("orderedProducts");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
