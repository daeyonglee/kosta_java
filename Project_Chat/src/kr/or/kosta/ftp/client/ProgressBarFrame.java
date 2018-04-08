package kr.or.kosta.ftp.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

/**
 * 파일 복사 진행창
 * @author 김기정
 */
public class ProgressBarFrame extends JFrame{
	JPanel progressPanel;
	JProgressBar progressBar;
	JPanel buttonPanel;
	JButton confirmButton;
	String fileName;
	
	public ProgressBarFrame(String fileName) {
		super("파일 다운로드");
		this.fileName = fileName;
		progressPanel = new JPanel();
		progressBar = new JProgressBar(0, 100);
		progressBar.setPreferredSize(new Dimension(350, 20));
		progressBar.setStringPainted(true);
		progressPanel.setBorder(new TitledBorder(fileName + "다운로드중."));
		buttonPanel = new JPanel();
		confirmButton = new JButton("  확인  ");
		confirmButton.setEnabled(false);
	}

	public void setComponents(){
		progressPanel.add(progressBar);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(confirmButton);
		add(progressPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setAlwaysOnTop(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 프로그레스바 진행 처리
	 * @param value
	 */
	public void setProgress(int value){
		progressBar.setValue(value);
		progressBar.setString(value + "% 다운로드중...");
		if(value == 100){
			progressBar.setString(fileName+" 다운로드 완료.");
			confirmButton.setEnabled(true);
		}
	}
	
	/**
	 * 종료 처리
	 */
	private void exit(){
		setVisible(false);
		dispose();
	}
	
	/**
	 * 이벤트소스에 이벤트리스너 등록
	 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	
	public static void main(String[] args) throws InterruptedException {
		ProgressBarFrame frame = new ProgressBarFrame("조은거.zip");
		frame.setComponents();
		frame.setSize(380, 130);
		frame.eventRegist();
		frame.setVisible(true);
		
		new Thread() {
			public void run() {
				for(int i=0; i<=100; i+=10) {
					frame.setProgress(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			};
		}.start();
		
	}

}
