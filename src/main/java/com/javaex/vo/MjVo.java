package com.javaex.vo;

public class MjVo {
	
	//필드
	private int userno;
	private String name;
	private String hp;
	private String birth;
	private String userpw;
	private int idx;
	private String notice_name;
	private String title;
	private String content;
	private String regDate;
	private int pagesNo;
	
	//생성자
	public MjVo() {
		super();
	}
	
	public MjVo(int userno, String name, String hp, String birth, String userpw) {
		super();
		this.userno = userno;
		this.name = name;
		this.hp = hp;
		this.birth = birth;
		this.userpw = userpw;
	}

	public MjVo(int idx, String notice_name, String title, String content, String regDate, int pagesNo) {
		super();
		this.idx = idx;
		this.notice_name = notice_name;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.pagesNo = pagesNo;
	}

	//메소드-gs
	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getNotice_name() {
		return notice_name;
	}

	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getPagesNo() {
		return pagesNo;
	}

	public void setPagesNo(int pagesNo) {
		this.pagesNo = pagesNo;
	}

	//메소드일반
	@Override
	public String toString() {
		return "MjVo [userno=" + userno + ", name=" + name + ", hp=" + hp + ", birth=" + birth + ", userpw=" + userpw
				+ ", idx=" + idx + ", notice_name=" + notice_name + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", pagesNo=" + pagesNo + "]";
	}

}
