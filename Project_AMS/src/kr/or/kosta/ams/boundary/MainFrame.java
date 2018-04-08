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
	
	// 0 : �űԵ��
	
	AccountManager manager;		// ���°���
	
	Panel headerPanel;			// ��ܺκ� Panel
	Panel bodyPanel;			// �ϴܺκ� Panel
	
	Label accountTypeLbl;		// �������� Label
	Label accountNumberLbl;		// ���¹�ȣ Label
	Label accountNameLbl;		// �����ָ� Label
	Label accountPwdLbl;		// ��й�ȣ Label
	Label borrowMoneyLbl;		// ����ݾ� Label
	Label depositMoneyLbl;		// �Աݱݾ� Label
	Label accountListLbl;       // ���¸�� Label
	Label accountUnitLbl;		// ����:�� Label
	Label errorLbl;				// ���� Label
	
	Choice accountTypeCie;		// �������� Choice
	
	TextField accountNumberTf;	// ���¹�ȣ TextField
	TextField accountNameTf;	// �����ָ� TextField
	TextField accountPwdTf;		// ��й�ȣ TextField
	TextField borrrowMoneyTf;	// ����ݾ� TextField
	TextField depositMoneyTf;	// �Աݱݾ� TextField
	
	TextArea accountListTa;		// ���¸�� TextArea
	
	Button accountNbSrhBtn;	    // ��ȸ Button
	Button accountNmSrhBtn;		// �˻� Button
	Button accountNewRegBtn;	// �űԵ�� Button
	Button accountNbDelBtn;		// ���� Button
	Button accountAllSrhBtn;	// ��ü��ȸ Button
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem menuItem;
	
	// �ʱ�ȭ
	public MainFrame() {
		this.manager = new AccountManager();
		headerPanel  = new Panel();
		bodyPanel  = new Panel();
		
		accountTypeLbl   = new Label("��������");
		accountNumberLbl = new Label("���¹�ȣ");
		accountNameLbl   = new Label("�����ָ�");
		accountPwdLbl    = new Label("��й�ȣ");
		borrowMoneyLbl   = new Label("����ݾ�");
		depositMoneyLbl  = new Label("�Աݱݾ�");
		accountListLbl   = new Label("���¸��");
		accountUnitLbl   = new Label("(����: ��)");
		errorLbl         = new Label("");
		
		errorLbl.setForeground(Color.RED);
		
		accountTypeCie   = new Choice();
		accountTypeCie.add("��ü");
		accountTypeCie.add("����ݰ���");
		accountTypeCie.add("���̳ʽ�����");
		
		accountNumberTf = new TextField();
		accountNameTf   = new TextField();
		accountPwdTf    = new TextField();
		borrrowMoneyTf  = new TextField();
		depositMoneyTf  = new TextField();
		accountListTa   = new TextArea(15, 15);
		
		accountNbSrhBtn  = new Button("��ȸ");
		accountNmSrhBtn  = new Button("�˻�");
		accountNewRegBtn = new Button("�űԵ��");
		accountNbDelBtn  = new Button("����");
		accountAllSrhBtn = new Button("��ü��ȸ");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		this.manager = new AccountManager();
		menuBar  = new MenuBar();
		menu     = new Menu("File");
		menuItem = new MenuItem("����"); 
		
		accountPwdTf.setEchoChar('*');
		
		// Component���� Default ����
		setDefault();
		
		// Menu����
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
	 * Frame �г����� �⺻���� ������� setting
	 */
	public void setContents() {
		setLayout(new BorderLayout(10, 0));
		
		// ������ Ȯ���ϱ� ���� ���� ����
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
		
		// ���� ���� Label ���
		add(headerPanel, accountTypeLbl  , 0, 0, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNumberLbl, 0, 2, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNameLbl  , 0, 4, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountPwdLbl   , 0, 6, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, borrowMoneyLbl  , 0, 8, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		
		// ���� ���� Label �� Component ���
		add(headerPanel, accountTypeCie , 5, 0, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNumberTf, 5, 2, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNameTf  , 5, 4, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountPwdTf   , 5, 6, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		add(headerPanel, borrrowMoneyTf , 5, 8, 10, 1, 0.5, 0, GridBagConstraints.BOTH);
		
		// �߾� Button ó��
		add(headerPanel, accountNbSrhBtn , 15, 2, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, accountNmSrhBtn , 15, 4, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		add(headerPanel, depositMoneyLbl , 15, 6, 5, 1, 0.1, 0, GridBagConstraints.NONE);
		add(headerPanel, accountNewRegBtn, 15, 8, 5, 1, 0.1, 0, GridBagConstraints.BOTH);
		
		// ���� ���� Button ó��
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
	 * Container�� GridBagLayout ���·� ��ҵ��� �߰�
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
	 * Component �⺻ ����
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
	 * �̺�Ʈ �߰�
	 */
	public void setEventRegister() {
		
		// �űԵ�� ��ư
		accountNewRegBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �űԵ�� execute
				execute(0);
			}
		});
		
		// �������� �ڽ�
		accountTypeCie.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ("����ݰ���".equals(accountTypeCie.getSelectedItem())) {
					borrrowMoneyTf.setEnabled(false);
					selectType(1);
				}
				else if("���̳ʽ�����".equals(accountTypeCie.getSelectedItem())){
					borrrowMoneyTf.setEnabled(true);
					selectType(2);
				}
				else if("��ü".equals(accountTypeCie.getSelectedItem())) {
					listAll();
				}
				
			}
		});
		
		// ��ȸ��ư
		accountNbSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(1);
			}
		});
		
		// ������ư
		accountNbDelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(2);
			}
		});
		
		// ��ü��ȸ��ư
		accountAllSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listAll();
				setDefault();
			}
		});
		
		// �˻���ư
		accountNmSrhBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute(3);
			}
		});
		
		// ������ â X��ư
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		// ���¹�ȣ TextField���� ����Ű �Է� �� ��ȸ��ư �̺�Ʈ ����
		accountNumberTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					execute(1);
				}
			}
		});
		
		// �����ָ� TextField���� ����Ű �Է� �� �˻���ư �̺�Ʈ ����
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
	 * �� �̺�Ʈ���� ��ȿ�� �˻� �� ��� ����
	 * @param flag => 0: �űԵ�Ϲ�ư
	 *                1: ��ȸ��ư
	 *                2: ������ư
	 *                3: �˻���ư
	 */
	private void execute(int flag) {
		switch (flag) {
		
			// �űԵ�Ϲ�ư execute
			case 0:
				if ("��ü".equals(accountTypeCie.getSelectedItem())) {
					errorLbl.setText("���������� ���� �� �űԵ�� �ٶ��ϴ�.");
					accountTypeCie.requestFocus();
					return;
				}
				
				int parsingAccountPwdTf   = 0;
				int parsingDepositMoneyTf = 0;
				int parsingBorrrowMoneyTf = 0;
				
				// ���¹�ȣ �Է� �ʼ�
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("���¹�ȣ�� �Է��ϼ���.");
					accountNumberTf.requestFocus();
					return;
				}
				
				if ("".equals(accountNameTf.getText())) {
					errorLbl.setText("�����ָ��� �Է��ϼ���.");
					accountNameLbl.requestFocus();
					return;
				}
				
				if ("".equals(accountPwdTf.getText())) {
					errorLbl.setText("��й�ȣ�� �Է��ϼ���.");
					accountPwdLbl.requestFocus();
					return;
				}
				
				if ("".equals(depositMoneyTf.getText())) {
					errorLbl.setText("�Աݱݾ��� �Է��ϼ���.");
					depositMoneyTf.requestFocus();
					return;
				}
				
				try {
					parsingAccountPwdTf   = Integer.valueOf(accountPwdTf.getText());
					parsingDepositMoneyTf = Integer.valueOf(depositMoneyTf.getText());
					parsingBorrrowMoneyTf = Integer.valueOf(borrrowMoneyTf.getText());
				} catch (NumberFormatException e2) {
					errorLbl.setText("��й�ȣ �� �Աݱݾ��� ���ڸ� �Է°����մϴ�.");
					return;
				}
				
				Account account = manager.get(accountNumberTf.getText());
				
				if (account != null) {
					errorLbl.setText("�̹� ��ϵ� ���¹�ȣ�� �����մϴ�.");
					accountNumberTf.requestFocus();
					return;
				}
				
				// Choice�ڽ��� ����ݰ����� ���
				if ("����ݰ���".equals(accountTypeCie.getSelectedItem())) {
					addAccount(new Account(accountNumberTf.getText(), accountNameTf.getText(), parsingAccountPwdTf, parsingDepositMoneyTf));
				}
				
				// Choice�ڽ��� ���̳ʽ������� ���
				if ("���̳ʽ�����".equals(accountTypeCie.getSelectedItem())) {
					if ("".equals(borrrowMoneyTf.getText())) {
						errorLbl.setText("����ݾ��� �Է��ϼ���.");
						borrrowMoneyTf.requestFocus();
						return;
					}
					
					addAccount(new MinusAccount(accountNumberTf.getText(), accountNameTf.getText(), parsingAccountPwdTf, parsingDepositMoneyTf, parsingBorrrowMoneyTf));
				}
				
				
				setDefault();
				
				listAll();
				
				break;
			// ��ȸ��ư execute
			case 1:
				
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("��ȸ �� ���¹�ȣ�� �Է��ϼ���.");
					accountNumberTf.requestFocus();
					return;
				}
				
				getAccount();
				
				break;
			
			// ������ư execute
			case 2:
				
				if ("".equals(accountNumberTf.getText())) {
					errorLbl.setText("���� �� ���¹�ȣ�� �Է��ϼ���.");
					accountNumberTf.requestFocus();
					return;
				}
				
				removeAccount();
				
				listAll();
				
				accountListTa.append("���� �� ����Դϴ�.");
				
				break;
				
			case 3:
				
				if ("".equals(accountNameTf.getText())) {
					errorLbl.setText("�˻� �� �����ָ��� �Է��ϼ���.");
					accountNameTf.requestFocus();
					return;
				}
				
				searchAccount();
				
				break;
		}	
	}
	
	/**
	 * ���������� ���� ��� ���
	 * @param flag		1: ����ݰ���
	 * 					2: ���̳ʽ�����
	 */
	public void selectType(int flag) {
		printHeader();
		for (int i = 0; i < manager.getCount(); i++) {
			if (flag == 1) {
				if (manager.getAccounts()[i].getAccountType() == "�����") {
					accountListTa.append(manager.getAccounts()[i].toString() + "\n");
				}
			} else if(flag == 2){
				if (manager.getAccounts()[i].getAccountType() == "���̳ʽ�") {
					accountListTa.append(manager.getAccounts()[i].toString() + "\n");
				}
			}
		} 
		printFooter();
	}
	
	/**
	 * ��ü ��� ���
	 */
	public void listAll() {
		printHeader();
		for (int i = 0; i < manager.getCount(); i++) {
				accountListTa.append(manager.getAccounts()[i].toString() + "\n");
		}
		printFooter();
	}
	
	/**
	 * ��ȸ��ư�� ���� ��� ��� ���
	 */
	public void getAccount() {
		Account account = manager.get(accountNumberTf.getText());
		printHeader();
		accountListTa.append(account.toString() + "\n");
		printFooter();
		accountListTa.append("��ȸ�� ����Դϴ�.");
	}
	
	/**
	 * ������ư�� ���� ��� ����
	 */
	public void removeAccount() {
		manager.remove(accountNumberTf.getText());
	}
	
	/**
	 * �˻���ư�� ���� ��� ��� ���
	 */
	public void searchAccount() {
		Account[] accounts = manager.search(accountNameTf.getText());
		printHeader();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null)
			accountListTa.append(accounts[i].toString() + "\n");
		}
		printFooter();
		accountListTa.append("�˻��� ����Դϴ�.");
	}
	
	/**
	 * �ű԰��� ����
	 * @param account
	 */
	public void addAccount(Account account) {
		manager.open(account);
	}
	
	/**
	 * ��½� ��ܺκ�
	 */
	private void printHeader() {
		accountListTa.setText("");
		
		accountListTa.append("====================================================================================\n");
		accountListTa.append(String.format("%1$4s", "��������")+ String.format("%1$17s", "���¹�ȣ") + String.format("%1$20s", "�����ָ�")
							+ String.format("%1$13s", "�����ܾ�") + String.format("%1$13s", "����ݾ�") + "\n");
		accountListTa.append("====================================================================================\n");
	}
	
	/**
	 * ��½� �ϴܺκ�
	 */
	private void printFooter() {
		accountListTa.append("------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * ����
	 */
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
}
