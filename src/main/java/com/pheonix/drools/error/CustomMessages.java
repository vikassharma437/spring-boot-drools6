package com.pheonix.drools.error;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name = "messages")
public class CustomMessages {

	private final List<CustomMessage> messages = Collections.synchronizedList(new ArrayList<CustomMessage>());

	public Collection<CustomMessage> getMessages() {
		return Collections.unmodifiableCollection(messages);
	}

	public void addMessage(String field, String message) {
		this.messages.add(new CustomMessage(field, message));
	}

	public boolean hasErrors() {
		if (this.messages.size() > 0) {
			return true;
		}
		return false;
	}

}
