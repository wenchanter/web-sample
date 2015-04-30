package com.wenchanter.web.sample.pojo;


/**
 * 
 * @author jeff.dk
 * 
 */
public class ThreadData extends PersistentObject {

	private static final long serialVersionUID = 4574708521560077379L;
	private String docid;
	private String userid;
	private String nickname;
	private String title;
	private int rcount;
	private String ptime;
	private String lmodify;
	private int plock;
	private int hits;
	private int isnew;
	private String oldid;
	private String modelid;
	private String url;
	private String pboardid;
	private String pdocid;
	private String keyword;
	private int tcount;
	private String abs;
	private int digg;
	private String board;
	private String position;
	private int anonymous;

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public int getDigg() {
		return digg;
	}

	public void setDigg(int digg) {
		this.digg = digg;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getIsnew() {
		return isnew;
	}

	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLmodify() {
		return lmodify;
	}

	public void setLmodify(String lmodify) {
		this.lmodify = lmodify;
	}

	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOldid() {
		return oldid;
	}

	public void setOldid(String oldid) {
		this.oldid = oldid;
	}

	public String getPboardid() {
		return pboardid;
	}

	public void setPboardid(String pboardid) {
		this.pboardid = pboardid;
	}

	public String getPdocid() {
		return pdocid;
	}

	public void setPdocid(String pdocid) {
		this.pdocid = pdocid;
	}

	public int getPlock() {
		return plock;
	}

	public void setPlock(int plock) {
		this.plock = plock;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getTcount() {
		return tcount;
	}

	public void setTcount(int tcount) {
		this.tcount = tcount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private String m_table;

	public void setTable(String table) {
		this.m_table = table;
	}

	@Override
	public String getTable() {
		return m_table;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	@Override
	public String getPartition() {
		return board;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public int getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(int anonymous) {
		this.anonymous = anonymous;
	}

}
