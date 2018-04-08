package kr.or.kosta.ams.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.or.kosta.ams.entity.Account;
import kr.or.kosta.ams.entity.AccountManager;
import kr.or.kosta.ams.entity.MinusAccount;

@SuppressWarnings("serial")
public class MainFrame extends Frame{
	
	// 0 : 신규등록
	
	AccountManager manager;		// 계좌관리
	
	Panel headerPanel;			// 상단부분 Panel
	Panel bodyPanel;			// 하단부분 Panel
	
	Label accountTypeLbl;		// 계좌종류 Label
	Label accountNumberLbl;		// 계좌번호 Label
	Label accountNameLbl;		// 예금주명 Label
	Label accountPwdLbl;		// 비밀번호 Label
	Label borrowMoneyLbl;		// 대출금액 Label
	Label depositMoneyLbl;		// 입금금액 Label
	Label accountListLbl;       // 계좌목록 Label
	Label accountUnitLbl;		// 단위:원 Label
	Label errorLbl;				// 에러 Label
	
	Choice accountTypeCie;		// 계좌종류 Choice
	
	TextField accountNumberTf;	// 계좌번호 TextField
	TextField accountNameTf;	// 예금주명 TextField
	TextField accountPwdTf;		// 비밀번호 TextField
	TextField borrrowMoneyTf;	// 대출금액 TextField
	TextField depositMoneyTf;	// 입금금액 TextField
	
	TextArea accountListTa;		// 계좌목록 TextArea
	
	Button accountNbSrhBtn;	    // 조회 Button
	Button accountNmSrhBtn;		// 검색 Button
	Button accountNewRegBtn;	// 신규등록 Button
	Button accountNbDelBtn;		// 삭제 Button
	Button accountAllSrhBtn;	// 전체조회 Button
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem;
	
	// 초기화
	public MainFrame() {
		this.manager = new AccountManager();
		headerPanel  = new Panel();
		bodyPanel  = new Panel();
		
		accountTypeLbl   = new Label("계좌종류");
		accountNumberLbl = new Label("계좌번호");
		accountNameLbl   = new Label("예금주명");
		accountPwdLbl    = new Label("비밀번호");
		borrowMoneyLbl   = new Label("대출금액");
		depositMoneyLbl  = new Label("입금금액");
		accountListLbl   = new Label("계좌목록");
		accountUnitLbl   = new Label("(단위: 원)");
		errorLbl         = new Label("");
		
		errorLbl.setForeground(Color.RED);
		
		accountTypeCie   = new Choice();
		accountTypeCie.add("전체");
		accountTypeCie.add("입출금계좌");
		accountTypeCie.add("마이너스계좌");
		
		accountNumberTf = new TextField();
		accountNameTf   = new TextField();
		accountPwdTf    = new TextField();
		borrrowMoneyTf  = new TextField();
		depositMoneyTf  = new TextField();
		accountListTa   = new TextArea(15, 15);
		
		accountNbSrhBtn  = new Button("조회");
		accountNmSrhBtn  = new Button("검색");
		accountNewRegBtn = new Button("신규등록");
		accountNbDelBtn  = new Button("삭제");
		accountAllSrhBtn = new Button("전체조회");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		this.manager = new AccountManager();
		menuBar  = new MenuBar();
		menu     = new Menu("File");
		menuItem = new MenuItem("열기"); 
		
		accountPwdTf.setEchoChar('*');
		
		// Component들의 Default 설정
		setDefault();
		
		// Menu설정
		setMenu();
	}
	
	// getter/setter
	public AccountManager getManager() {
		return manager;
	}

	public void setManager(AccountManager manager) {
		this.manager = manager;
	}
	
	/**
	 * 
	 */
	public void setMenu() {
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(menuItem);
	}
	
	/**
	 * Frame 패널위에 기본적인 내용들을 setting
	 */
	public void setContents() {
		setLayout(new BorderLayout(10, 0));
		
		// 눈으로 확인하기 위한 배경색 변경
		//headerPanel.setBackground(Color.RED);
		//centerPanel.setBackground(Color.CYAN);
		//footerPanel.setBackground(Color.BLUE);
		setHeader();
		setBody();
		
		add(headerPanel, BorderLayout.NORTH);
		add(bodyPanel  , BorderLayout.CENTER);
		
	}
	
	private void setHeader() {
		
		headerPanel.setLayout(gridBagLayout);
		headerPanel.setBackground(new Color(234, 234, 234));
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);
		
		// 가장 좌측 Label 등록
		add(headerPanel, accountTypeLbl  , 0, 0, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNumberLbl, 0, 2, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNameLbl  , 0, 4, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountPwdLbl   , 0, 6, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, borrowMoneyLbl  , 0, 8, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		
		// 가장 좌측 Label 옆 Component 등록
		add(headerPanel, accountTypeCie , 5, 0, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNumberTf, 5, 2, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNameTf  , 5, 4, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountPwdTf   , 5, 6, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, borrrowMoneyTf , 5, 8, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		
		// 중앙 Button 처리
		add(headerPanel, accountNbSrhBtn , 15, 2, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNmSrhBtn , 15, 4, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, depositMoneyLbl , 15, 6, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNewRegBtn, 15, 8, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		
		// 가장 우측 Button 처리
		add(headerPanel, accountNbDelBtn , 20, 2, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, new Label()     , 25, 2, 5, 1, 0.4, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountAllSrhBtn, 20, 8, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, depositMoneyTf  , 20, 6, 10, 1, 0.2, 0, GridBagConstraints.BOTH);
	}
	
	private void setBody() {
		bodyPanel.setLayout(gridBagLayout);
		
		gridBagConstraints.insets = new Insets(5, 0, 0, 0);
		add(bodyPanel, accountListLbl, 0, 0, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(bodyPanel, errorLbl      , 5, 0, 20, 1, 1, 0, GridBagConstraints.BOTH);
		add(bodyPanel, accountUnitLbl, 25, 0, 5, 1, 0.001,0, GridBagConstraints.BOTH);
		add(bodyPanel, accountListTa , 0, 2, 30, 1, 1, 0, GridBagConstraints.BOTH);
	}
	
	/**
	 * Container에 GridBagLayout 형태로 요소들을 추가
	 * @param container
	 * @param com
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 * @param fill
	 */
	private void add(Container container, Component com, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill) {
		
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		
		gridBagConstraints.fill = fill;
		
		gridBagLayout.setConstraints(com, gridBagConstraints);
		container.add(com, gridBagConstraints);
	}
	
	/**
	 * Component 기본 설정
	 */
	private void setDefault() {
		accountListTa.setEditable(false);
		accountTypeCie.select(0);
		accountNumberTf.setText("");
		accountNameTf.setText("");
		accountPwdTf.setText("");
		borrrowMoneyTf.setText("");
		depositMoneyTf.setText("");
		errorLbl.setText("");
	}
	
	/**
	 * 이벤트 추가
	 */
	public void setEventRegister() {
		
		// 신규등록 버튼
		accountNewRegBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 신규등록 execute
				execute(0);
			}
		});
		
		// 계좌종류 박스
		accountTypeCie.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ("입출금계좌".equals(accountTypeCie.getSelectedItem())) {
					borrrowMoneyTf.setEnabled(false);
					selectType(1);
				}
				else if("마이너스계좌".equals(accountTypeCie.getSelectedItem())){
					borrrowMoneyTf.setEnabled(true);
					selectType(2);
				}
				else if("전체".equals(accountTypeCie.getSelectedItem())) {
					listAll();
				}
				
			}
		});
		
		// 조회버튼
		accountNbSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(1);
			}
		});
		
		// 삭제버튼
		accountNbDelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(2);
			}
		});
		
		// 전체조회버튼
		accountAllSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listAll();
				setDefault();
			}
		});
		
		// 검색버튼
		accountNmSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(3);
			}
		});
		
		// 윈도우 창 X버튼
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		// 계좌번호 TextField에서 엔터키 입력 시 조회버튼 이벤트 수행
		accountNumberTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					execute(1);
				}
			}
		});
		
		// 예금주명 TextField에서 엔터키 입력 시 검색버튼 이벤트 수행
		accountNameTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					execute(3);
				}
			}
		});
	}
	
	
	/**
	 * 각 이벤트마다 유효성 검사 및 기능 수행
	 * @param flag => 0: 신규등록버튼
	 *                1: 조회버튼
	 *                2: 삭제버튼
	 *                3: 검색버튼
	 */
	private void execute(int flag) {
		switch (flag) {
		
			// 신규등록버튼 execute
			case 0:
				if ("전체".equals(accountTypeCie.getSelectedItem())) {
					errorLbl.setText("계좌종류를 선택 후 신규등록 바랍니다.");
					accountTypeCie.requestFocus();
					return;
				}
				
				int parsingAccountPwdTf   = 0;
				int parsingDepositMoneyTf = 0;
				int parsingBorrrowMoneyTf = 0;
				
				// 계좌번호 입력 필수
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("계좌번호를 입력하세요.");
					accountNumberTf.requestFocus();
					return;
				}
				
				if ("".equals(accountNameTf.getText())) {
					errorLbl.setText("예금주명을 입력하세요.");
					accountNameLbl.requestFocus();
					return;
				}
				
				if ("".equals(accountPwdTf.getText())) {
					errorLbl.setText("비밀번호를 입력하세요.");
					accountPwdLbl.requestFocus();
					return;
				}
				
				if ("".equals(depositMoneyTf.getText())) {
					errorLbl.setText("입금금액을 입력하세요.");
					depositMoneyTf.requestFocus();
					return;
				}
				
				try {
					parsingAccountPwdTf   = Integer.valueOf(accountPwdTf.getText());
					parsingDepositMoneyTf = Integer.valueOf(depositMoneyTf.getText());
					parsingBorrrowMoneyTf = Integer.valueOf(borrrowMoneyTf.getText());
				} catch (NumberFormatException e2) {
					errorLbl.setText("비밀번호 및 입금금액은 숫자만 입력가능합니다.");
					return;
				}
				
				Account account = manager.get(accountNumberTf.getText());
				
				if (account != null) {
					errorLbl.setText("이미 등록된 계좌번호가 존재합니다.");
					accountNumberTf.requestFocus();
					return;
				}
				
				// Choice박스가 입출금계좌일 경우
				if ("입출금계좌".equals(accountTypeCie.getSelectedItem())) {
					addAccount(new Account(accountNumberTf.getText(), accountNameTf.getText(), parsingAccountPwdTf, parsingDepositMoneyTf));
				}
				
				// Choice박스가 마이너스계좌일 경우
				if ("마이너스계좌".equals(accountTypeCie.getSelectedItem())) {
					if ("".equals(borrrowMoneyTf.getText())) {
						errorLbl.setText("대출금액을 입력하세요.");
						borrrowMoneyTf.requestFocus();
						return;
					}
					
					addAccount(new MinusAccount(accountNumberTf.getText(), accountNameTf.getText(), parsingAccountPwdTf, parsingDepositMoneyTf, parsingBorrrowMoneyTf));
				}
				
				
				setDefault();
				
				listAll();
				
				break;
			// 조회버튼 execute
			case 1:
				
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("조회 할 계좌번호를 입력하세요.");
					accountNumberTf.requestFocus();
					return;
				}
				
				getAccount();
				
				break;
			
			// 삭제버튼 execute
			case 2:
				
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("삭제 할 계좌번호를 입력하세요.");
					accountNumberTf.requestFocus();
					return;
				}
				
				removeAccount();
				
				listAll();
				
				accountListTa.append("삭제 후 결과입니다.");
				
				break;
				
			case 3:
				
				if ("".equals(accountNameTf.getText())) {
					errorLbl.setText("검색 할 예금주명을 입력하세요.");
					accountNameTf.requestFocus();
					return;
				}
				
				searchAccount();
				
				break;
		}	
	}
	
	/**
	 * 계좌종류에 따라 목록 출력
	 * @param flag		1: 입출금계좌
	 * 					2: 마이너스계좌
	 */
	public void selectType(int flag) {
		printHeader();
		for (int i = 0; i < manager.getCount(); i++) {
			if (flag == 1) {
				if (manager.getAccounts()[i].getAccountType() == "입출금") {
					accountListTa.append(manager.getAccounts()[i].toString() + "\n");
				}
			} else if(flag == 2){
				if (manager.getAccounts()[i].getAccountType() == "마이너스") {
					accountListTa.append(manager.getAccounts()[i].toString() + "\n");
				}
			}
		} 
		printFooter();
	}
	
	/**
	 * 전체 목록 출력
	 */
	public void listAll() {
		printHeader();
		for (int i = 0; i < manager.getCount(); i++) {
				accountListTa.append(manager.getAccounts()[i].toString() + "\n");
		}
		printFooter();
	}
	
	/**
	 * 조회버튼에 대한 결과 목록 출력
	 */
	public void getAccount() {
		Account account = manager.get(accountNumberTf.getText());
		printHeader();
		accountListTa.append(account.toString() + "\n");
		printFooter();
		accountListTa.append("조회된 결과입니다.");
	}
	
	/**
	 * 삭제버튼에 대한 기능 수행
	 */
	public void removeAccount() {
		manager.remove(accountNumberTf.getText());
	}
	
	/**
	 * 검색버튼에 대한 결과 목록 출력
	 */
	public void searchAccount() {
		Account[] accounts = manager.search(accountNameTf.getText());
		printHeader();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null)
			accountListTa.append(accounts[i].toString() + "\n");
		}
		printFooter();
		accountListTa.append("검색한 결과입니다.");
	}
	
	/**
	 * 신규계좌 개설
	 * @param account
	 */
	public void addAccount(Account account) {
		manager.open(account);
	}
	
	/**
	 * 출력시 상단부분
	 */
	private void printHeader() {
		accountListTa.setText("");
		
		accountListTa.append("====================================================================================\n");
		accountListTa.append(String.format("%1$4s", "계좌종류")+ String.format("%1$17s", "계좌번호") + String.format("%1$20s", "예금주명")
							+ String.format("%1$13s", "현재잔액") + String.format("%1$13s", "대출금액") + "\n");
		accountListTa.append("====================================================================================\n");
	}
	
	/**
	 * 출력시 하단부분
	 */
	private void printFooter() {
		accountListTa.append("------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * 종료
	 */
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
}
