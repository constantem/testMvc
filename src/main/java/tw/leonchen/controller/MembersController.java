package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.leonchen.model.Members;

@Controller
public class MembersController {
	
    @GetMapping("/membersmain.controller")
	public String processMainAction(Model m) {
    	//Members mem = new Members();
    	Members mem = new Members("kitty","female",30);
    	m.addAttribute("members", mem);
    	return "members";
	}
    
    
    @PostMapping("/addMembers")
    public String processAction(@ModelAttribute("members") Members mem1, BindingResult result, Model m) {
    	if(result.hasErrors()) {
    		return "membersError";
    	}
    	
    	m.addAttribute("mName", mem1.getMemberName());
    	m.addAttribute("mGender", mem1.getGender());
    	m.addAttribute("mAge", mem1.getAge());
    	
    	return "membersResult";
    }
}
