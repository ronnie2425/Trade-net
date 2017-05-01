package edu.ycp.cs320.Trade_net.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.Chat;
import edu.ycp.cs320.Trade_net.model.Notification;

public class InitialData {
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setUserId(userId++);				
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setEmail(i.next());
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<Notification> getNotifications() throws IOException {
		List<Notification> notList = new ArrayList<Notification>();
		ReadCSV readNotifications = new ReadCSV("notifications.csv");
		try {
			// auto-generated primary key for books table
			Integer notId = 1;
			while (true) {
				List<String> tuple = readNotifications.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Notification not =new Notification();
				not.setNotificationId(notId++);
				not.setUserId(Integer.parseInt(i.next()));
				not.setNotification(i.next());
				notList.add(not);
			}
			return notList;
		} finally {
			readNotifications.close();
		}
	}
	public static List<Posts> getPosts() throws IOException {
		List<Posts> postList = new ArrayList<Posts>();
		ReadCSV readPosts = new ReadCSV("posts.csv");
		try {
			// auto-generated primary key for books table
			Integer postId = 1;
			while (true) {
				List<String> tuple = readPosts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Posts post = new Posts();
				post.setPostId(postId++);
				post.setUserId(Integer.parseInt(i.next()));
				post.setPlatform(i.next());
				post.setGame(i.next());
				post.setBuy(i.next());
				post.setTime(Double.parseDouble(i.next()));
				post.setMessage(i.next());
				postList.add(post);
			}
			return postList;
		} finally {
			readPosts.close();
		}
	}
	public static List<Chat> getChat() throws IOException {
		List<Chat> chatList = new ArrayList<Chat>();
		ReadCSV readChat = new ReadCSV("chat.csv");
		try {
			// auto-generated primary key for books table
			Integer chatId = 1;
			while (true) {
				List<String> tuple = readChat.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Chat c = new Chat();
				c.setMsg(i.next());
				c.setMsgId(chatId++);
				chatList.add(c);
			}
			return chatList;
		} finally {
			readChat.close();
		}
	}
}
