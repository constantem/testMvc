package tw.leonchen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leonchen.model.House;

@Controller
public class JsonCreatorController {

	@GetMapping("/jsoncreator.controller")
	@ResponseBody
	public String processJsonAction() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Great House");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(hBean1);
		
		House resultBean1 = mapper.readValue(jsonStr, House.class);
		System.out.println(resultBean1.getHouseid() + ":" + resultBean1.getHousename());
		
		return "jsonStr:" + jsonStr;
	}
	
	@GetMapping("/jsoncreator2.controller")
	@ResponseBody
	public House processJsonAction2() {
		House hBean1 = new House();
		hBean1.setHouseid(1002);
		hBean1.setHousename("Fashion House");
		return hBean1;
	}
	
	@GetMapping("/jsoncreator3.controller")
	@ResponseBody
	public ArrayList<House> processJsonAction3() {
		
		House hBean1 = new House();
		hBean1.setHouseid(1002);
		hBean1.setHousename("Fashion House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1003);
		hBean2.setHousename("Nice House");
		
		ArrayList<House> list = new ArrayList<House>();
		list.add(hBean1);
		list.add(hBean2);
		
		return list;
	}
}
