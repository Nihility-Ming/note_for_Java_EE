package com.iphone567.tally.controller;

import java.util.List;

import com.iphone567.tally.domain.Tally;
import com.iphone567.tally.service.TallyService;
import com.iphone567.tally.view.TallyView;
import com.iphone567.tally.view.TallyView.TallyViewDelegate;

public class TallyController implements TallyViewDelegate {
	private TallyView tallyView = new TallyView();
	private TallyService tallyService = new TallyService();
	{
		this.tallyView.setDelegate(this);
	}

	public void run() {
		while (true) {
			this.tallyView.showWelcome();
		}
	}

	@Override
	public void tallyViewDidSelectedWelcomeIndex(int index) {
		// 1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统
		switch (index) {
		case 1:
			this.tallyView.showAddTallyInput();
			break;
		case 2:
			this.tallyView.showEditTallyInput();
			break;
		case 3:
			this.tallyView.showDeleteTallyInput();
			break;
		case 4:
			this.tallyView.showCheckTallyInput();
			break;
		case 5:
			this.tallyView.showExitMessage();
			System.exit(0);
			break;
		default:
			this.tallyView.showInputIndexErrorMessage();
			break;
		}
	}

	@Override
	public void tallyViewWillAddTally(Tally tally) {
		if (this.tallyService.add(tally) > 0) {
			this.tallyView.showAddTallySuccess();
		} else {
			this.tallyView.showAddTallyError();
		}
	}

	@Override
	public void tallyViewWillDeleteTally(int tallyId) {
		Tally tally = this.tallyService.check(tallyId);
		if (tally == null) {
			this.tallyView.showCheckTallyEmpty();
			return;
		}

		if (this.tallyService.delete(tallyId) > 0) {
			this.tallyView.showDeleteTallySuccess();
		} else {
			this.tallyView.showDeleteTallyError();
		}
	}

	@Override
	public void tallyViewWillCheckTallies(String startDate, String endDate) {
		List<Tally> tallies = this.tallyService.check(startDate, endDate);
		showTallies(tallies);
	}

	@Override
	public boolean tallyViewWillCheckTallies() {
		List<Tally> tallies = this.tallyService.check();
		showTallies(tallies);
		return tallies.size() > 0;
	}

	@Override
	public boolean tallyViewWillEditTally(int tallyId) {
		Tally tally = this.tallyService.check(tallyId);
		if (tally == null) {
			this.tallyView.showCheckTallyEmpty();
			return false;
		}

		return true;
	}

	private void showTallies(List<Tally> tallies) {
		int size = tallies.size();
		if (size > 0) {
			this.tallyView.showTallies(tallies);
			this.tallyView.showCheckTallySuccess(size);
		} else {
			this.tallyView.showCheckTallyEmpty();
		}
	}

	@Override
	public void tallyViewSendEditTally(Tally tally) {
		if (this.tallyService.update(tally) > 0) {
			this.tallyView.showEditTallySuccess();
		} else {
			this.tallyView.showEditTallyError();
		}
	}

}
