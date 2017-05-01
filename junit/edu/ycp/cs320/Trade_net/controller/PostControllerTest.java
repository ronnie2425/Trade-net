package edu.ycp.cs320.Trade_net.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.model.*;
import edu.ycp.cs320.Trade_net.controller.*;
import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;

public class PostControllerTest {
	private Posts model;
	private User user;
	private PostController controller;
	private IDatabase db;
	private List<Posts> posts = null;
	private List<Notification> nots = null;
	private List<Posts> posts2 = null;
	private int id;
	private Notification not;
	@Before
	public void setUp() {
		user= new User("testp","pass","email",5);
		 model=new Posts("platform6", "game6", "buy", "message",user);
		controller= new PostController(model);
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
		//db.insertUser("testp", "pass", "email");
	}
	
	
	@Test
	public void testDeletePostandGetPosts() {
		db= DatabaseProvider.getInstance();
		db.insertPost(user.getUserId(), "platform6", "game6", "buy", 30, "message");
		
		posts=controller.getPosts();
		
		assertEquals(false,posts.isEmpty());
		assertEquals(true ,model.getPlatform().equals((posts.get(0).getPlatform())));
		assertEquals(true ,model.getGame().equals(posts.get(0).getGame()));
		assertEquals(true , model.getBuy().equals(posts.get(0).getBuy()));
		
		id=posts.get(0).getPostId();
		model.setPostId(id);
		controller=new PostController(model);
		controller.deletePost();
		posts2=controller.getPosts();
		
		assertEquals(true,posts2.isEmpty());
		
	}
	@Test
	public void testNotify1(){
		not=new Notification("message",user);
		controller.notify1();
		db= DatabaseProvider.getInstance();
		nots=db.findNot(5);
		assertEquals(false,nots.isEmpty());
	}
}
