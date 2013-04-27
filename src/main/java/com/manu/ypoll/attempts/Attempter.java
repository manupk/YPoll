package com.manu.ypoll.attempts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.manu.ypoll.commons.Poll;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Attempter {
	
	@Autowired
	private AttempterRepository attempterRepository;
	
	public void attempt(Poll p, List<String> selectedIds){
		Attempt attempt = new Attempt(p.getId(), selectedIds);
		attempterRepository.save(attempt);
	}
}
