package com.manu.ypoll.commons;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "poll")
public class Poll {

	@Id
	private ObjectId id;

	private String questionTxt;
	private String permalink;
	
	private List<Option> options;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getQuestionTxt() {
		return questionTxt;
	}

	public void setQuestionTxt(String questionTxt) {
		this.questionTxt = questionTxt;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", questionTxt=" + questionTxt + ", options="
				+ options + "]";
	}
}
