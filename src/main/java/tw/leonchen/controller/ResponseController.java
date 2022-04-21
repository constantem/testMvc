package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

	@GetMapping(path = "/responsebody.controller")
	@ResponseBody   // application/json
	public String processResponseAction() {
		return "This is a Response Message !!";
	}
	
	@GetMapping(path = "/responsebodycharset.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody   
	public String processResponseWithCharsetAction() {
		return "你好，Hola, amigo !!";
	}
	
	@GetMapping("/responseentityaction.controller")
	public ResponseEntity<String> processResponseEntityAction(){
		return new ResponseEntity<String>("Custom Status Code Response 403 Forbidden", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/responseentityheaders.controller")
	public ResponseEntity<String> processResponseEntityHeadersAction(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("Custom Header Information", headers, HttpStatus.OK);
	}
//	
//	@GetMapping(path = "/responseimage.controller", produces = "text/plain;charset=UTF-8")
//	public void processResponseImageAsByteArrayAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
//		IOUtils.copy(is, response.getOutputStream());
//	}
//	
//	@GetMapping(path = "/responseimagebytearray.controller", produces = "text/plain;charset=UTF-8")
//	@ResponseBody
//	public byte[] processResponseImageAsByteArrayAction2(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
//		return IOUtils.toByteArray(is);
//	}
}
