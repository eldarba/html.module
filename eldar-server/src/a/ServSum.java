package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServSum")
public class ServSum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		Map<String, String[]> map = request.getParameterMap();
		String[] vals = map.get("val");
		if(vals == null) {
			out.print("No Parameters");
			return;
		}
		double sum = 0;
		for (String str : vals) {
			try {
				sum += Double.parseDouble(str);
			}catch (NumberFormatException e) {
				System.out.println(e);
				if(str.equals("")||str==null) {
					out.print("bad parameter: empty");
					return;
				}
				out.print("bad parameter: " + str);
				return;
			}
		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		out.print(sum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
