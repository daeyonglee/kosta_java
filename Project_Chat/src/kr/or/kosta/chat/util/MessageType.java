package kr.or.kosta.chat.util;

public interface MessageType {
	
	public static final String DELEMITER = "#¡Ú#";
	
	public static final String CC_CONNECT          = "1000";
	public static final String CC_MULTI_MESSAGE    = "2000";
	public static final String CC_SINGLE_MESSAGE   = "2100";
	public static final String CC_FILE_YN          = "2200";
	public static final String CC_SINGLE_FILE_SEND = "2300";
	public static final String CC_SINGLE_FILE_RECEIVE = "2400";
	public static final String YES				   = "YES";
	public static final String NO                  = "NO";
	public static final String CC_DISCONNECT       = "3000";
	public static final String SERVER              = "SERVER";
	                                               
	public static final String SC_CONNECT_LIST     = "4000";
}
