package raf;

import java.util.*;
import java.io.*;

/**
 * FriendDao �׽�Ʈ�� ���� ���ø����̼� Ŭ����
 * @author �����
 */
public class  FriendApp{
	public static void main(String[] args) {
		
		FriendDao friendDao = null;
		
		try{
			friendDao = new FriendDao();
			
			// ���Ͽ� ģ��(���ڵ�) �߰� �׽�Ʈ
			friendDao.create(new Friend("�����", 10, 61.34, "011-1111-8707"));
			friendDao.create(new Friend("��Ժ�", 20, 62.34, "010-2222-8707"));
			friendDao.create(new Friend("����ȭ", 30, 63.34, "010-3333-8707"));
			friendDao.create(new Friend("�ڼ���", 40, 64.34, "010-4444-8707"));
			friendDao.create(new Friend("�����", 50, 65.34, "010-5555-8707"));
			friendDao.create(new Friend("������", 60, 66.34, "010-6666-8707"));
			System.out.println("ģ�� ���� ���� �Ϸ�!");
			
			// ��ü ����Ʈ..
			System.out.println("***** ��ϵ� ��� ģ�� ����Ʈ(�� "+friendDao.getRecordCount()+"��) *****");
			ArrayList<Friend> list = (ArrayList<Friend>) friendDao.listAll();
			for (Friend friend : list) {
				System.out.println(friend.getName() + "\t" + friend.getAge() + "\t" + friend.getWeight() + "\t" + friend.getTelephone());
			}

			// ��Ʈ�� �ݱ�
			friendDao.close();
			
		}catch(IOException e){
			e.printStackTrace();
		} 
	}
}
