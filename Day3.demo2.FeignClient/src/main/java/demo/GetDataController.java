package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class GetDataController {
	@Autowired
	private MyServiceClient cl;
	@Autowired
	private ReqResClient client;
	
@GetMapping(value="/getdata/{l}")
	public String getdata(@PathVariable(name="l") String l ){
	System.out.println(" l = "  + l);
	List<Dept> list = cl.find(l);
	System.out.println("List size =" + list.size());
	String str = "<table border='1' bgcolor='cyan' >";
	for (Dept e : list) {
		 str+="<tr><td>"+e.getDeptno()+"</td><td>" + e.getDname() +"</td><td>"+e.getLoc() +"</td></tr>";	
	}
	str+= "</table>";
	return str;
}


@GetMapping(value="/req")
public String getdata1( ){
	UserData udata =client.get();
	User user = udata.getData();
	String str = "<table border='1' bgcolor='cyan' >";
	 str+="<tr><td>"+user.getId()+"</td><td>" + user.getFirst_name() +"</td><td>"+user.getLast_name() 
	 +"</td><td><img src=' " + user.getAvatar() + "'></tr>";	

	 str+= "</table>";
return str;
}


}
