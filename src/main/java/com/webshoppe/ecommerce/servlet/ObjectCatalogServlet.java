package com.webshoppe.ecommerce.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.entity.Toy;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;
import com.webshoppe.ecommerce.repository.BookRepository;
import com.webshoppe.ecommerce.repository.FlowerRepository;
import com.webshoppe.ecommerce.repository.ToyRepository;
import com.webshoppe.ecommerce.service.BookCatalogService;
import com.webshoppe.ecommerce.service.FlowerCatalogService;
import com.webshoppe.ecommerce.service.ToyCatalogService;

public class ObjectCatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ToyCatalogService toyCatalogService;
	private ToyRepository toyRepository;

	private FlowerCatalogService flowerCatalogService;
	private FlowerRepository flowerRepository;
	
	private BookCatalogService bookCatalogService;
	private BookRepository bookRepository;

	private JdbcConnectionManager jdbcConnectionManager;
	//private StringBuilder stringBuilder;

	@Override
	public void init() throws ServletException {

		jdbcConnectionManager = new JdbcConnectionManager();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//stringBuilder = new StringBuilder();

		final String category = request.getServletPath();// get the request

		switch (category) {

		case "/toy-catalog":

			toyRepository = new ToyRepository(jdbcConnectionManager);
			toyCatalogService = new ToyCatalogService(toyRepository);

			final List<Toy> toys = toyCatalogService.getToyCatalog();

			request.setAttribute("toyCatalog", toys);
	        request.getRequestDispatcher("/jsp/ToyCatalog.jsp").forward(request, response);
	 

			//displayToys(toys);
			break;

		case "/flower-catalog":

			flowerRepository = new FlowerRepository(jdbcConnectionManager);
			flowerCatalogService = new FlowerCatalogService(flowerRepository);

			final List<Flower> flowers = flowerCatalogService.getFlowerCatalog();
			
			request.setAttribute("flowerCatalog", flowers);
	        request.getRequestDispatcher("/jsp/FlowerCatalog.jsp").forward(request, response);

			//displayFlowers(flowers);

			break;

		case "/book-catalog":
			
			bookRepository = new BookRepository(jdbcConnectionManager);
			bookCatalogService = new BookCatalogService(bookRepository);

			final List<Book> books = bookCatalogService.getBookCatalog();
			
			request.setAttribute("bookCatalog", books);
	        request.getRequestDispatcher("/jsp/BookCatalog.jsp").forward(request, response);
			//displayBooks(books);

			break;
		}

		//PrintWriter out = response.getWriter();
		//out.println(stringBuilder.toString());
		//out.flush();
		//out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//stringBuilder = new StringBuilder();

		final String minimumPriceParam = request.getParameter("minimum-price");
		final BigDecimal minimumPrice = new BigDecimal(minimumPriceParam);

		final String maximumPriceParam = request.getParameter("maximum-price");
		final BigDecimal maximumPrice = new BigDecimal(maximumPriceParam);

		final String category = request.getParameter("select-category");
		selectionCategory(request, response, category, minimumPrice, maximumPrice);

		//PrintWriter out = response.getWriter();
		//out.println(stringBuilder.toString());
		//out.flush();
		//out.close();
	}

	private void selectionCategory(HttpServletRequest request, HttpServletResponse response, String category, BigDecimal minimumPrice, BigDecimal maximumPrice) throws ServletException, IOException {

		switch (category) {

		case "toy":

			final List<Toy> toys = toyCatalogService.getToyCatalog(minimumPrice, maximumPrice);
			
			request.setAttribute("toyCatalog", toys);
	        request.getRequestDispatcher("/jsp/ToyCatalog.jsp").forward(request, response);
			//displayToys(toys);

			break;

		case "flower":

			final List<Flower> flowers = flowerCatalogService.getFlowerCatalog(minimumPrice, maximumPrice);
			
			request.setAttribute("flowerCatalog", flowers);
	        request.getRequestDispatcher("/jsp/FlowerCatalog.jsp").forward(request, response);
			
			//displayFlowers(flowers);
			
			break;

		case "book":
			
			final List<Book> books = bookCatalogService.getBookCatalog(minimumPrice, maximumPrice);
			
			request.setAttribute("bookCatalog", books);
	        request.getRequestDispatcher("/jsp/BookCatalog.jsp").forward(request, response);
			//displayBooks(books);

			break;
		}

	}

//	private void displayToys(List<Toy> toys) {
//
//		if (toys.isEmpty()) {
//			stringBuilder.append("<b>Toy Catalog Empty</b>");
//		} else {
//			stringBuilder.append("<table class='table'>");
//			stringBuilder.append("<thead>");
//			stringBuilder.append("<th scope='col'>Toy ID</th>");
//			stringBuilder.append("<th scope='col'>Name</th>");
//			stringBuilder.append("<th scope='col'>Description</th>");
//			stringBuilder.append("<th scope='col'>Price</th>");
//			stringBuilder.append("</thead>");
//			toys.forEach(e -> {
//				stringBuilder.append("<tr scope='row'>");
//				stringBuilder.append("<td>").append(e.getId()).append("</td>");
//				stringBuilder.append("<td>").append(e.getName()).append("</td>");
//				stringBuilder.append("<td>").append(e.getDescription()).append("</td>");
//				stringBuilder.append("<td>").append(e.getPrice()).append("</td>");
//				stringBuilder.append("</tr>");
//			});
//			stringBuilder.append("</table>");
//		}
//	}
//
//	private void displayFlowers(List<Flower> flowers) {
//
//		if (flowers.isEmpty()) {
//			stringBuilder.append("<b>Flower Catalog Empty</b>");
//		} else {
//			stringBuilder.append("<table class='table'>");
//			stringBuilder.append("<thead>");
//			stringBuilder.append("<th scope='col'>Flower ID</th>");
//			stringBuilder.append("<th scope='col'>Name</th>");
//			stringBuilder.append("<th scope='col'>Description</th>");
//			stringBuilder.append("<th scope='col'>Price</th>");
//			stringBuilder.append("</thead>");
//			flowers.forEach(e -> {
//				stringBuilder.append("<tr scope='row'>");
//				stringBuilder.append("<td>").append(e.getFlowerID()).append("</td>");
//				stringBuilder.append("<td>").append(e.getFlowerName()).append("</td>");
//				stringBuilder.append("<td>").append(e.getFlowerDescription()).append("</td>");
//				stringBuilder.append("<td>").append(e.getFlowerPrice()).append("</td>");
//				stringBuilder.append("</tr>");
//			});
//			stringBuilder.append("</table>");
//		}
//	}
//	
//	private void displayBooks(List<Book> books) {
//
//		if (books.isEmpty()) {
//			stringBuilder.append("<b>Book Catalog Empty</b>");
//		} else {
//			stringBuilder.append("<table class='table'>");
//			stringBuilder.append("<thead>");
//			stringBuilder.append("<th scope='col'>Book ID</th>");
//			stringBuilder.append("<th scope='col'>Title</th>");
//			stringBuilder.append("<th scope='col'>Description</th>");
//			stringBuilder.append("<th scope='col'>Price</th>");
//			stringBuilder.append("</thead>");
//			books.forEach(e -> {
//				stringBuilder.append("<tr scope='row'>");
//				stringBuilder.append("<td>").append(e.getBookId()).append("</td>");
//				stringBuilder.append("<td>").append(e.getTitle()).append("</td>");
//				stringBuilder.append("<td>").append(e.getBookDescription()).append("</td>");
//				stringBuilder.append("<td>").append(e.getBookPrice()).append("</td>");
//				stringBuilder.append("</tr>");
//			});
//			stringBuilder.append("</table>");
//		}
//	}

}
