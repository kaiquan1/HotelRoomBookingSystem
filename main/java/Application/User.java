package Application;

public class User {
    private String name;
    private String memberType;
    private boolean hasExclusiveReward;

    public User() {
    }
    
    public User(String name, String memberType, boolean hasExclusiveReward) {
        this.name = name;
        this.memberType = memberType;
        this.hasExclusiveReward = hasExclusiveReward;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public boolean hasExclusiveReward() {
        return hasExclusiveReward;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

    public void setExclusiveReward(boolean hasExclusiveReward) {
        this.hasExclusiveReward = hasExclusiveReward;
    }
}
