package org.iii.swaggerTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Controller
@RequestMapping(value = "/api", produces = "application/json; charset=utf-8")
@Api(value="Users")
public class APIController {
	
	@ApiOperation(value = "Fetch all Users")
	@RequestMapping(value = { "/users" }, method = { RequestMethod.GET })
	public @ResponseBody String listUsers() {
		
		
		JSONArray users = new JSONArray();

		users.put(new JSONObject("{\"name\":\"Mark\",\"age\":26}"));
		users.put(new JSONObject("{\"name\":\"Ko\",\"age\":25}"));
		users.put(new JSONObject("{\"name\":\"KK\",\"age\":24}"));
		
		return users.toString();
	}
	
	@ApiOperation(value = "Add New User")
	@RequestMapping(value = { "/users" }, method = { RequestMethod.POST })
	public @ResponseBody String addUser(@RequestParam String name,@RequestParam int age) {
		
		return (new JSONObject("{\"name\":\""+name+"\",\"age\":"+age+"}").toString());
		
	}
}
