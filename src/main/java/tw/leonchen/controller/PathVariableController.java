package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PathVariableController {
	
	@RequestMapping(path = "/member/{mid}", method = RequestMethod.GET)
    public void processAction(@PathVariable("mid") String memberid) {
    	System.out.println("memberid:" + memberid);
    }
}
