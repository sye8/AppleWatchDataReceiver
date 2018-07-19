import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * @author yesifan
 *
 */

@WebServlet(
		description = "Survey Data Receiver",
		urlPatterns = {"/Survey"}
)

public class Survey extends HttpServlet{

	private static final long serialVersionUID = -8652420292925761818L;

	public void init() throws ServletException {
    	//Do nothing
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Do nothing
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	StringBuilder stringBuilder = new StringBuilder();
    	BufferedReader reader = request.getReader();
    	String line;
    	while ((line = reader.readLine()) != null) {
	    	stringBuilder.append(line).append('\n');
	    }
	    reader.close();
	    System.out.println(stringBuilder);
	    
	    Gson gson = new Gson();
	    String json = stringBuilder.toString();
	    
	    SurveyAnswer ans = gson.fromJson(json, SurveyAnswer.class);
	    
	    Date date = new Date();
	    String dateStr = date.toString();   
	    dateStr = dateStr.replaceAll("\\s", "_");
	    
	    File output = new File("webapps/hrData/" + dateStr + "_" + ans.getId() + "_survey.txt");
	    PrintWriter out = new PrintWriter(output);
	    out.write(ans.getId() + "\n");
	    out.write(ans.toString());
	    out.flush();
	    out.close();
    }
	
}
