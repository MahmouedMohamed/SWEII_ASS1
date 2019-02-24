import javax.ws.rs.core.MediaType;

import java.util.Iterator;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class omdb {
	String Title="";
	String Year="";
	String Rated="";
	String Released="";
	String Runtime="";
	String Genre="";
	String Director="";
	String Writer="";
	String Actors="";
	String Plot="";
	String Language="";
	String Country="";
	String Awards="";
	String Poster="";
	String Ratings="";
	String Metascore="";
	String imdbRating="";
	String imdbVotes="";
	String imdbID="";
	String Type="";
	String DVD="";
	String BoxOffice="";
	String Production="";
	String Website="";
	public void settitle(String t)
	{
		Title=t;
	}
	public void setyear(String y)
	{
		Year=y;
	}
	public void setrated(String r)
	{
		Rated=r;
	}
	public void setrelease(String r)
	{
		Released=r;
	}
	public void setruntime(String t)
	{
		Runtime=t;
	}
	public void setgenre(String y)
	{
		Genre=y;
	}
	public void setdirector(String r)
	{
		Director=r;
	}
	public void setwriter(String r)
	{
		Writer=r;
	}
	public void setactors(String p)
	{
		Actors=p;
	}
	public void setplot(String t)
	{
		Plot=t;
	}
	public void setlanguage(String y)
	{
		Language=y;
	}
	public void setcountry(String r)
	{
		Country=r;
	}
	public void setaward(String r)
	{
		Awards=r;
	}
	public void setposter(String t)
	{
		Poster=t;
	}
	public String gettitle()
	{
		return Title;
	}
	public String getyear()
	{
		return Year;
	}
	public String getrated()
	{
		return Rated;
	}
	public String getrelease()
	{
		return Released;
	}
	public String getruntime()
	{
		return Runtime;
	}
	public String getgenre()
	{
		return Genre;
	}
	public String getdirector()
	{
		return Director;
	}
	public String getwriter()
	{
		return Writer;
	}
	public String getactors()
	{
		return Actors;
	}
	public String getplot()
	{
		return Plot;
	}
	public String getlanguage()
	{
		return Language;
	}
	public String getcountry()
	{
		return Country;
	}
	public String getaward()
	{
		return Awards;
	}
	public String getposter()
	{
		return Poster;
	}

	public int getconnection(String name)
	{	
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://www.omdbapi.com/?apikey=6b0d2a9c&t="+name);
		String all=(target.request(MediaType.APPLICATION_JSON).get(String.class));
		String[] arrOfStr =all.split(",\"");
		if(arrOfStr[0].contains("Response"))
		{
			return -1;
		}
		else {
		settitle(arrOfStr[0].substring(9));
		setyear(arrOfStr[1].substring(6));
		setrated(arrOfStr[2].substring(7));
		setrelease(arrOfStr[3].substring(10));
		setruntime(arrOfStr[4].substring(9));
		setgenre(arrOfStr[5].substring(7));
		setdirector(arrOfStr[6].substring(10));
		setwriter(arrOfStr[7].substring(8));
		setactors(arrOfStr[8].substring(8));
		setplot(arrOfStr[9].substring(6));
		setlanguage(arrOfStr[10].substring(10));
		setcountry(arrOfStr[11].substring(9));
		setaward(arrOfStr[12].substring(8));
		setposter(arrOfStr[13].substring(8));
		return 0;
		}
	}
	}


