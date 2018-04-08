package raf;

import java.io.*;
import java.util.*;

/**
 * RandomAccessFile�� �̿��Ͽ� ģ�������� ���ڵ� ������ ���Ͽ� ����/�б� ó��
 * 
 * @author �����
 */
public class FriendDao{
	
	/** ���� ���� ���*/
	private static final String FILE_PATH = "friends.dbf";
	
	/** ���ڵ�(ģ��)�� ������ ���� ���� �÷� ������ ���� */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** ���ڵ�(ģ�� �̸�,����,������,��ȭ��ȣ) ������ ���� �÷��� ������ ���� */
	private static final int NAME_LENGTH = 10;      // �̸�(10����Ʈ)
	private static final int AGE_LENGTH = 4;        // ����(4����Ʈ)
	private static final int WEIGHT_LENGTH = 8;     // ������(8����Ʈ)
	private static final int TELEPHONE_LENGTH = 26; // ��ȭ��ȣ(26����Ʈ)
	
	/** ģ������ ������ ���� ���ڵ� ������ : 48����Ʈ */	
	public static final int RECORD_LENGTH = NAME_LENGTH + AGE_LENGTH + WEIGHT_LENGTH + TELEPHONE_LENGTH;
	
	private RandomAccessFile file;
	
	/** ����� ģ��(���ڵ�)�� */
	private int recordCount = 0;
	
	public FriendDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// ����� ������ �ִ� ���..
		if(file.length() != 0){
			recordCount = file.readInt();
		}
	}	

	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/** ģ�� ���� ���� */
	public void create(Friend friend) throws IOException{
		// ������ ������ ���ڵ峡���� ���� ������ �̵�.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// ���ο� ���ڵ�(ģ��) �߰�
		// 10 + 4 + 8 + 26
		String name = friend.getName();
		int age = friend.getAge();
		double weight = friend.getWeight();
		String telephone = friend.getTelephone();
		
		int charCount = name.length();		
		//10����Ʈ(5����)�� �̸� ����
		for(int i = 0; i < (NAME_LENGTH/2); i++){		
			// EX) "�����  "
			file.writeChar((i<charCount ? name.charAt(i) : ' '));
		}
		
		// ����(4����Ʈ)
		file.writeInt(age);
		// ������(8����Ʈ)
		file.writeDouble(weight);
				
		// 26����Ʈ(13����)�� ��ȭ��ȣ ����		
		charCount = telephone.length();
		for(int i = 0; i < (TELEPHONE_LENGTH/2); i++){
			// EX) "010-9179-8707"
			file.writeChar((i<charCount ? telephone.charAt(i) : ' '));
		}

		// ���ڵ� ���� �� ���������͸� ������ ó������ �̵�����
		// ��ϵ� ���ڵ�(ģ��) �� 1 ����
		file.seek(0);
		file.writeInt(++recordCount);
	}
	

	/** ��ϵ� ��ü����Ʈ ��ȯ */
	public List<Friend>  listAll() throws IOException{
		List<Friend> list = new ArrayList<Friend>();
		for(int i=0; i<recordCount; i++){
			Friend friend = read(i);
			list.add(friend);		
		}
		return list;
	}
	
	
	/** Ư�� ���ڵ��� ������ Friend�� ��ȯ */
	private Friend read(int index) throws IOException{
		Friend friend = null;
		
		String name = "";
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		for(int i=0; i<(NAME_LENGTH/2); i++){
			name += file.readChar();
		}
		name = name.trim();
		
		int age = 0;
		age = file.readInt();
		
		double weight = 0.0;
		weight = file.readDouble();
		
		String telephone = "";
		for(int i = 0;i<(TELEPHONE_LENGTH/2);i++){
			telephone += file.readChar();
		}
		telephone = telephone.trim();
		
		friend = new Friend(name, age, weight, telephone);
		return friend;
	}
	
	// ��Ʈ�� �ݱ�
	public void close(){
		try{
			if(file != null) file.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}


