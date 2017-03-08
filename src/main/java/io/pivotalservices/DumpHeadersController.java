package io.pivotalservices;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DumpHeadersController {

	@RequestMapping("/")
	@ResponseBody
    public Map<String, String> dumpHeaders(HttpServletRequest request) {
		Map<String, String> headers = new HashMap<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			headers.put(key, value);
		}
        return headers;
    }
}
