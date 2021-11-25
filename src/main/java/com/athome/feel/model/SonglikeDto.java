package com.athome.feel.model;

public class SonglikeDto {
	
	private int memberId;
	private int songId;
	
	public SonglikeDto() {
	}
	public SonglikeDto(int memberId, int songId) {
		this.memberId = memberId;
		this.songId = songId;
	}
	public int getMemberId() {
		return memberId;
	}
	public int getSongId() {
		return songId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
}
