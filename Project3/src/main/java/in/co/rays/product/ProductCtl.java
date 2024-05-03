package in.co.rays.product;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductCtl")
public class ProductCtl extends HttpServlet {
			public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			ProductDTO dto = new ProductDTO();
			ProductModel model = new ProductModel();
			if (id != null) {
				dto = model.findByPk(Integer.parseInt(id));
				req.setAttribute("dto", dto);
			}
			RequestDispatcher rd = req.getRequestDispatcher("ProductView.jsp");
			rd.forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			ProductDTO dto = new ProductDTO();
			String id = req.getParameter("id");
			String op = req.getParameter("operation");
			ProductModel model = new ProductModel();
			
			
			dto.setName(req.getParameter("name"));
			try {
				dto.setDate(sdf.parse(req.getParameter("date")));
			} catch (java.text.ParseException e) {
				
				e.printStackTrace();
			}
			dto.setPrize(req.getParameter("prize"));


			dto.setAddress(req.getParameter("address"));
							
			
			if (op.equalsIgnoreCase("update")) {
				dto.setId(Integer.parseInt(id));
				model.update(dto);
				req.setAttribute("dto", dto);
				req.setAttribute("msg", "Product record updated successfully");
			}
			if (op.equalsIgnoreCase("save")) {
				req.setAttribute("dto", dto);
				model.add(dto);
				req.setAttribute("msg", "Product record added successfully");

				
			}if (op.equalsIgnoreCase("reset")) {
//				req.setAttribute("dto", dto);
				
			}
				RequestDispatcher rd = req.getRequestDispatcher("ProductView.jsp");
				rd.forward(req, resp);

			}

}
