package com.iphone567.tally.view;

import java.util.List;
import java.util.Scanner;

import com.iphone567.tally.domain.Tally;

/**
 * 视图
 * 
 * @author Nihility-Ming
 *
 */
public class TallyView {

	static public interface TallyViewDelegate {

		/**
		 * 用户选择了一个欢迎选项
		 * 
		 * @param index
		 *            1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统
		 */
		void tallyViewDidSelectedWelcomeIndex(int index);

		void tallyViewWillAddTally(Tally tally);

		void tallyViewWillDeleteTally(int tallyId);

		boolean tallyViewWillEditTally(int tallyId);

		void tallyViewSendEditTally(Tally tally);

		boolean tallyViewWillCheckTallies();

		void tallyViewWillCheckTallies(String startDate, String endDate);
	}

	private TallyViewDelegate delegate;

	private Scanner scanner = new Scanner(System.in);

	{
		scanner.useDelimiter("\n");
	}

	public TallyViewDelegate getDelegate() {
		return delegate;
	}

	public void setDelegate(TallyViewDelegate delegate) {
		this.delegate = delegate;
	}

	public void showWelcome() {
		System.out.println();
		System.out.println("---------------管家婆家庭记账软件---------------");
		System.out.println("1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统");
		System.out.println("请输入要操作的功能序号[1-5]:");

		int selectedIndex = 0;
		try {
			selectedIndex = Integer.parseInt(this.scanner.next());
		} catch (Exception e) {
		} finally {
			if (this.delegate != null)
				this.delegate.tallyViewDidSelectedWelcomeIndex(selectedIndex);
		}
	}

	public void showTallies(List<Tally> tallies) {
		this.showTableHeader();
		for (Tally tally : tallies) {
			System.out.println(tally.getZwid() + "／" + tally.getFlname() + "／" + tally.getMoney() + "／"
					+ tally.getZhanghu() + "／" + tally.getCreatetime() + "／" + tally.getDescription());
		}
	}

	public void showAddTallyInput() {
		try {
			System.out.println();
			System.out.println("请输入支出类型：");
			String flname = this.scanner.next();
			System.out.println("请输入支出金额：");
			Double money = 0.0;
			money = Double.parseDouble(this.scanner.next());
			System.out.println("请输入支出途径：");
			String zhanghu = this.scanner.next();
			System.out.println("请输入支出时间：");
			String createtime = this.scanner.next();
			System.out.println("请输入支出描述：");
			String description = this.scanner.next();
			Tally tally = new Tally(null, flname, money, zhanghu, createtime, description);

			if (this.delegate != null)
				this.delegate.tallyViewWillAddTally(tally);
		} catch (Exception e) {
			System.out.println("输入错误！");
		}
	}

	public void showAddTallySuccess() {
		System.out.println();
		System.out.println("添加账务成功！");
	}

	public void showAddTallyError() {
		System.out.println();
		System.out.println("添加账务错误！");
	}

	public void showEditTallyInput() {
		try {
			System.out.println();
			System.out.println("请输入需要编辑账务的ID：");
			Integer id = Integer.parseInt(this.scanner.next());
			if (this.delegate.tallyViewWillEditTally(id)) {
				System.out.println("正在编辑ID" + id + "：");
				System.out.println("请输入支出类型：");
				String flname = this.scanner.next();
				System.out.println("请输入支出金额：");
				Double money = Double.parseDouble(this.scanner.next());
				System.out.println("请输入支出途径：");
				String zhanghu = this.scanner.next();
				System.out.println("请输入支出时间：");
				String createtime = this.scanner.next();
				System.out.println("请输入支出描述：");
				String description = this.scanner.next();
				Tally tally = new Tally(id, flname, money, zhanghu, createtime, description);
				if (this.delegate != null)
					this.delegate.tallyViewSendEditTally(tally);
			}
		} catch (Exception e) {
			System.out.println("非法输入！");
		}
	}

	public void showEditTallySuccess() {
		System.out.println();
		System.out.println("编辑账务成功！");
	}

	public void showEditTallyError() {
		System.out.println();
		System.out.println("编辑账务失败！");
	}

	public void showDeleteTallyInput() {
		System.out.println();
		System.out.println("请输入需要删除的账务的ID：");
		Integer id = this.scanner.nextInt();

		System.out.println("您是否确认删除ID:" + id + "的账务记录？Y/N");
		if (this.scanner.next().equalsIgnoreCase("y")) {
			this.delegate.tallyViewWillDeleteTally(id);
		}
	}

	public void showDeleteTallySuccess() {
		System.out.println();
		System.out.println("删除账务成功！");
	}

	public void showDeleteTallyError() {
		System.out.println();
		System.out.println("删除账务失败！");
	}

	public void showCheckTallyInput() {

		System.out.println();
		System.out.println("1.列出所有数据 2.列出指定日期的数据");
		switch (this.scanner.next()) {
		case "1":
			if (this.delegate != null) {
				this.delegate.tallyViewWillCheckTallies();
			}
			break;
		case "2":
			System.out.println("请输入需要查询账务的开始日期(yyyy-MM-dd)：");
			String startDate = this.scanner.next();
			System.out.println("请输入需要查询账务的结束日期(yyyy-MM-dd)：");
			String endDate = this.scanner.next();
			if (this.delegate != null)
				this.delegate.tallyViewWillCheckTallies(startDate, endDate);
			break;

		default:
			System.out.println("请输入正确的序号！");
			showCheckTallyInput();
			break;
		}

	}

	public void showCheckTallyEmpty() {
		System.out.println();
		System.out.println("找不到数据");
	}

	public void showCheckTallySuccess(int count) {
		System.out.println();
		System.out.println("成功检索到" + count + "条数据。");
	}

	public void showExitMessage() {
		System.out.println();
		System.out.println("Good bye!");
	}

	public void showInputIndexErrorMessage() {
		System.out.println();
		System.out.println("请输入正确的索引值！");
	}

	// 输出表头
	private void showTableHeader() {
		System.out.println();
		System.out.println("ID／类别／账户／金额／时间／说明");
		System.out.println("=============================");
	}

}
