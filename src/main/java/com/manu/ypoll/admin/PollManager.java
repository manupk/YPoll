package com.manu.ypoll.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.manu.ypoll.commons.Poll;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PollManager {
	
	@Autowired
	private PollRepository pollRepo;
	
	public Poll createPoll(Poll poll) {

		poll = pollRepo.save(poll);

		return poll;
	}

}
