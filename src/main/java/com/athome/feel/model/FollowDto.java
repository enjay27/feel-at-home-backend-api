package com.athome.feel.model;

public class FollowDto {

    private final int memberId;
    private final int friendId;

    public FollowDto(int memberId, int friendId) {
        this.memberId = memberId;
        this.friendId = friendId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getFriendId() {
        return friendId;
    }
}
