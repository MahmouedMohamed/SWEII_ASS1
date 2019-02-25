import javax.ws.rs.core.MediaType;

import java.util.Iterator;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Nasa {
	String copyright="";
	String date="";
	String explanation="";
	String hdurl="";
	public void setcopyright(String t)
	{
		copyright=t;
	}
	public void setdate(String y)
	{
		date=y;
	}
	public void setexplanation(String r)
	{
		explanation=r;
	}
	public void sethdurl(String r)
	{
		hdurl=r;
	}
	public String getcopyright()
	{
		return copyright;
	}
	public String getdate()
	{
		return date;
	}
	public String getexplanation()
	{
		return explanation;
	}
	public String gethdurl()
	{
		return hdurl;
	}
	public Nasa()
	{
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("https://api.nasa.gov/planetary/apod?api_key=ahQZtRlV5kjks6zxFzzFpJB1P2e7K8yp3QyfdjEa");
		String all=(target.request(MediaType.APPLICATION_JSON).get(String.class));
		String[] arrOfStr =all.split(",\"");
		setcopyright(arrOfStr[0].substring(13));
		setdate(arrOfStr[1].substring(6));
		setexplanation(arrOfStr[2].substring(13));
		sethdurl(arrOfStr[3].substring(7));
	}
	

}
