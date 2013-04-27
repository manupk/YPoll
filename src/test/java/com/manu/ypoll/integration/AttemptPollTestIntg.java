package com.manu.ypoll.integration;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manu.ypoll.admin.PollManager;
import com.manu.ypoll.admin.PollRepository;
import com.manu.ypoll.attempts.Attempter;
import com.manu.ypoll.commons.Option;
import com.manu.ypoll.commons.Poll;

@Configurable(autowire = Autowire.BY_NAME)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AttemptPollTestIntg {

	@Autowired
	private PollRepository pollRepository;
	@Autowired
	private PollManager pollManager;
	@Autowired
	private Attempter attempter;

	private ObjectId storedPollId;
	private String optionId;

	@Test
	public void testForLife() {
		System.out.println("I AM READY");
	}

	@Test
	public void testCreatePollAndAttemptIt() {
		test1CreatePoll();
		test2PollById();
		test3attemptPoll();
	}

	public void test1CreatePoll() {

		Option option1 = new Option();
		optionId = "A";
		option1.setOptionId(optionId);
		option1.setOptionTxt("Good");

		Option option2 = new Option();
		option2.setOptionId("B");
		option2.setOptionTxt("Bad");

		List<Option> list = new ArrayList<Option>();
		list.add(option1);
		list.add(option2);

		Poll poll = new Poll();
		poll.setOptions(list);
		poll.setQuestionTxt("How are you feeling now?");

		poll = pollManager.createPoll(poll);

		storedPollId = poll.getId();
		Assert.assertNotNull(storedPollId);
	}

	public void test2PollById() {
		Poll poll = pollRepository.findOne(storedPollId);
		Assert.assertNotNull(poll);
		System.out.println(pollRepository.findAll());
	}

	public void test3attemptPoll() {
		Poll poll = pollRepository.findOne(storedPollId);
		List<String> selectedIds = new ArrayList<String>();
		selectedIds.add(optionId);
		attempter.attempt(poll, selectedIds);
	}
}
