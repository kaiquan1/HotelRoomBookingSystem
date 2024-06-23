package Application;

import java.util.ArrayList;
import java.util.List;

public class WaitingList {
    private List<User> vipWaitingList;
    private List<User> normalWaitingList;
    private List<User> nonMemberWaitingList;

    public WaitingList() {
        vipWaitingList = new ArrayList<>();
        normalWaitingList = new ArrayList<>();
        nonMemberWaitingList = new ArrayList<>();
    }

    public void addToVIPWaitingList(User user) {
        vipWaitingList.add(user);
    }

    public void addToNormalWaitingList(User user) {
        normalWaitingList.add(user);
    }

    public void addToNonMemberWaitingList(User user) {
        nonMemberWaitingList.add(user);
    }

    public List<User> getVIPWaitingList() {
        return vipWaitingList;
    }

    public List<User> getNormalWaitingList() {
        return normalWaitingList;
    }

    public List<User> getNonMemberWaitingList() {
        return nonMemberWaitingList;
    }
    
	public void removeFromVIPWaitingList(User user) {
		vipWaitingList.remove(user);
	}
	
	public void removeFromNormalWaitingList(User user) {
		normalWaitingList.remove(user);
	}
	
	public void removeFromNonMemberWaitingList(User user) {
		nonMemberWaitingList.remove(user);
	}
	
	public boolean findUserInWaitingList(List<User> waitingList, User user) {
		return waitingList.contains(user);
	}
}
