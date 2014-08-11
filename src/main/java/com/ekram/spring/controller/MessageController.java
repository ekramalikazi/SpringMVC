package com.ekram.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ekram.spring.model.Message;

@Controller
@RequestMapping("/message")
public final class MessageController {

	private static final Logger LOG = Logger.getLogger(MessageController.class);

	private Map<Integer, Message> messages = new HashMap<Integer, Message>();

	public MessageController() {
		messages.put(1, new Message(1, "Hello World"));
		messages.put(2, new Message(2, "Hello India"));
		messages.put(3, new Message(3, "Hello USA"));
		messages.put(4, new Message(4, "Hello UK"));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String list(ModelMap model) {
		LOG.debug("Processing message list...");
		List<Message> list = new ArrayList<Message>(messages.values());
		model.addAttribute("messages", list);
		return "list";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getMessage(@PathVariable("id") Integer id, ModelMap model) {
		Message message = messages.get(id);
		model.addAttribute("message", message);
		return "message";
	}

}