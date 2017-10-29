package com.yss1.pproc;

import java.util.Date;

import com.yss1.pproc.util.Utils;

public class Man {
	private String name;
	private String fam;
	private String otch;
	private String snils;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public String getFormattedBirthday() {
		return Utils.getFormattedDate(birthday);
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFam() {
		return fam;
	}

	public void setFam(String fam) {
		this.fam = fam;
	}

	public String getOtch() {
		return otch;
	}

	public void setOtch(String otch) {
		this.otch = otch;
	}

	public String getSnils() {
		return snils;
	}

	public void setSnils(String snils) {
		this.snils = snils;
	}

}
