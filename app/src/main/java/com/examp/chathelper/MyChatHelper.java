package com.examp.chathelper;

import com.hyphenate.chat.EMClient;

//我的帮助类吧
public class MyChatHelper {
	private MyChatHelper() {
	}

	private static MyChatHelper help = new MyChatHelper();

	public static MyChatHelper getInstance() {
		return help;// 单例
	}

	public void loadmessage() {// 加载联系人 群组
		EMClient.getInstance().chatManager().loadAllConversations();
		EMClient.getInstance().groupManager().loadAllGroups();
	}
}
