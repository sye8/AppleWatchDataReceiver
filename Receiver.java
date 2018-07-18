/**
 * @author yesifan
 *
 */

import java.util.Date;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(
		description = "Watch Data Receiver",
		urlPatterns = {"/Receiver"}
)

public class Receiver extends HttpServlet{

	private static final long serialVersionUID = -5694874634147673806L;

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
	    
	    String idJson = json.substring(1, json.indexOf(','));
	    String id = gson.fromJson(idJson, ID.class).toString();
	    
	    json = "[" + json.substring(json.indexOf(',')+1);
	    System.out.println(json);
	    
	    HKQuantitySample[] results = gson.fromJson(json, HKQuantitySample[].class);
	    
	    Date date = new Date();
	    String dateStr = date.toString();
	    dateStr = dateStr.replaceAll("\\s", "_");
//	    File output = new File("/Users/yesifan/Downloads/" + dateStr + "_" + id + ".txt");
	    File output = new File("webapps/hrData/" + dateStr + "_" + id + ".txt");
	    PrintWriter out = new PrintWriter(output);
	    out.write(id + "\n");
	    out.write("HR\tStart Date\tEnd Date\n");
	    for(HKQuantitySample r: results){
	    	out.write(r.toString());
	    }
	    out.flush();
	    out.close();
    }
	
}
