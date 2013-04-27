package com.manu.ypoll.attempts;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="attempt")
public class Attempt {

	@Id
	private ObjectId objectId;
	private ObjectId questionId;
	private List<String> selected;
	
	
	public Attempt(ObjectId questionId, List<String> selected) {
		super();
		this.questionId = questionId;
		this.selected = selected;
	}
	
	public ObjectId getObjectId() {
		return objectId;
	}
	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}
	public ObjectId getQuestionId() {
		return questionId;
	}
	public void setQuestionId(ObjectId questionId) {
		this.questionId = questionId;
	}
	public List<String> getSelected() {
		return selected;
	}
	public void setSelected(List<String> selected) {
		this.selected = selected;
	}
	
}
