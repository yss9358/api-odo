package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class SolClassHendleVo {
	
	private SolClassVo classVo = new SolClassVo();
	private MultipartFile classImage;
	
	public SolClassHendleVo() {
		super();
	}
	
	public SolClassVo getClassVo() {
		return classVo;
	}
	public void setClassVo(SolClassVo classVo) {
		this.classVo = classVo;
	}
	public MultipartFile getClassImage() {
		return classImage;
	}
	public void setClassImage(MultipartFile classImage) {
		this.classImage= classImage;
	}
	
	
	@Override
	public String toString() {
		return "SolClassHendleVo [classVo=" + classVo + ", classImage=" + classImage + "]";
	}
	

}
