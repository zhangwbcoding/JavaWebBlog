package com.zwb.action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Comment;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.CommentServiceImpl;
import com.zwb.serviceImpl.GeneralUtilsImpl;

import net.sf.json.JSONObject;

public class CreatCommentAction implements Action {
	private Comment comment;
	private String tip;
	private GeneralUtilsImpl gu;
	private CommentServiceImpl cs;
	private BlogServiceImpl bs;
	private JSONObject jo;
	
	
	




	public JSONObject getJo() {
		return jo;
	}



	public void setJo(JSONObject jo) {
		this.jo = jo;
	}



	public Comment getComment() {
		return comment;
	}



	public void setComment(Comment comment) {
		this.comment = comment;
	}



	public String getTip() {
		return tip;
	}



	public void setTip(String tip) {
		this.tip = tip;
	}



	public GeneralUtilsImpl getGu() {
		return gu;
	}



	public void setGu(GeneralUtilsImpl gu) {
		this.gu = gu;
	}



	public CommentServiceImpl getCs() {
		return cs;
	}



	public void setCs(CommentServiceImpl cs) {
		this.cs = cs;
	}

	public BlogServiceImpl getBs() {
		return bs;
	}



	public void setBs(BlogServiceImpl bs) {
		this.bs = bs;
	}	

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = gu.getSession();
		String userid = (String) session.getAttribute("userid");
		String username=(String) session.getAttribute("username");
		if(userid==null){
			tip = "ÇëÏÈµÇÂ¼£¡";
			return ERROR;
		}
		else{
			comment.setUserid(userid);
			comment.setUsername(username);
			comment.setBlogtitle(bs.showblog(comment.getBlogid()).getTitle());
			cs.save(comment);
			comment.setCreated_at("¸Õ¸Õ");
			jo = JSONObject.fromObject(comment);
			return SUCCESS ;
		}
	}





}
