package app;

import java.util.Set;
import java.util.HashSet;

public class User {
	private String name;
	private HashSet<User> friends = new HashSet<>();

	public User(String name) {
		this.name = name;
	}

	public void addFriend(User user) {
		this.friends.add(user);
		user.friends.add(this);
	}

	public Set<User> getFriends() {
		return this.friends;
	}

	public String getName() {
		return this.name;
	}

	public static void main(String[] args) {
		User john = new User("John");
		User mary = new User("Mary");
		User mark = new User("Mark");
		john.addFriend(mary);
		john.addFriend(mark);
	}
}