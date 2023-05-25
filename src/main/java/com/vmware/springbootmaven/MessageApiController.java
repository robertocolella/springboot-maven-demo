package com.vmware.springbootmaven;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageApiController {

	private static final Logger LOG = LoggerFactory.getLogger(MessageApiController.class);

	@Value("${configfrom:Hardcoded}")
	String configfrom;

	@Value("${client:VMware}")
	String client;

	@Value("${framework:Spring}")
	String framework;

	@Value("${message:Secure Software Supply Chains Are Great!}")
	String msgSubject;

	@Value("${msg_body:Message Body Text Here.}")
	String msgBody;

	@CrossOrigin
	@Operation(summary = "Get a list of messages.",
	        description = "The API returns a list of messages. The content in these messages could come from a number or different configuration sources.",
			tags = {"Messages"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
			             description = "Messages were resolved and are being returned.",
						 content = @Content(mediaType = "application/json"))
	})
	@GetMapping("/messages")
	public Map<String, String> index() {
		LOG.info("A request has been received for the /messages endpoint.");
		LOG.debug("Config is coming from {}", configfrom);
		Map<String, String> data = new HashMap<String, String>();
		data.put("msg_subject", msgSubject);
		data.put("msg_body", msgBody);
		data.put("framework", framework);
		data.put("client", client);
		LOG.debug("Returning {}.", data.toString());
		return data;
	}
}