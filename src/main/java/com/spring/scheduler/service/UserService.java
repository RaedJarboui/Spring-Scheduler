package com.spring.scheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.scheduler.model.User;
import com.spring.scheduler.repository.UserRepository;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepo;

	@Scheduled(fixedRate = 5000)
	public void addToDBJob() { // add user object to DB every 5 sec
		User user = User.builder().name("user " + new Random().nextInt(374483)).build();
		log.info("user id :" + user.getId());
		log.info("user name :" + user.getName());
		userRepo.save(user);
		System.out.println("User saved into DB : " + new Date());
	}

	@Scheduled(fixedDelay = 10000) // run next job after 10 sec from last job execution
	public void retriveListOfUsers() { // retrieve data from DB every 10 sec
		List<User> users = userRepo.findAll();
		System.out.println("User retrieve from DB : " + new Date());
		log.info("users size : {} " + users.size());

	}

	@Scheduled(cron = "0 15 10 15 * ?") // task to be executed at 10:15 AM on the 15th day of every month.
	public void scheduleTaskUsingCronExpression() {

		long now = System.currentTimeMillis() / 1000;
		System.out.println("schedule tasks using cron jobs - " + now);
	}

}
