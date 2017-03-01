package com.iphone456.tally.service;

import java.util.List;

import com.iphone456.tally.dao.TallyDao;
import com.iphone567.tally.domain.Tally;

public class TallyService {
	private TallyDao tallyDao = new TallyDao();

	public int add(Tally tally) {
		return tallyDao.add(tally);
	}

	public int delete(int id) {
		return tallyDao.delete(id);
	}

	public int update(Tally tally) {
		return tallyDao.update(tally);
	}

	public Tally check(int id) {
		return tallyDao.check(id);
	}

	public List<Tally> check() {
		return tallyDao.check();
	}
	
	public List<Tally> check(String startDate, String endDate) {
		return tallyDao.check(startDate, endDate);
	}
}
