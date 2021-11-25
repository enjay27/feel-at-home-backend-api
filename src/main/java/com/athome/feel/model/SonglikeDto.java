package com.athome.feel.model;

public class SonglikeDto {
	
	private int member_id;
	private int song_id;
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	public SonglikeDto(int member_id, int song_id) {
		super();
		this.member_id = member_id;
		this.song_id = song_id;
	}
	public SonglikeDto() {
		super();
	}
	
	
}
