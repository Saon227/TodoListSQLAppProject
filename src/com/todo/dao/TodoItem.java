package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int id;
    private int is_completed;
    private String subject;
    private String place;

//	public String toSaveString() {
//    	return category + "##" + title + "##" + desc + "##" + due_date + "##" + current_date + "\n";
//    }
    
    @Override
    public String toString() {
    	
    	title += "\t  ";
    	String check = String.format("%-3s", ((is_completed!=0) ? "[V]" : "[_]"));
    	if(desc.length()<13) {
    		desc += "\t";
    		if(desc.length()<8) {
    			desc += "\t";
    		}
    	}
    	subject = ((subject == null) ? "         " : subject+"\t ");
    	place = ((place == null) ? "        " : place+"\t ");
    	
    	return String.format("%-8s", " [" + category + "]") + title + check + " : " + desc + "\t" + subject + place + due_date + "  -  " + current_date;
    }

	public TodoItem(String title, String desc, String category, String due_date, int is_completed, String subject, String place){
        this.title = title;
        this.desc = desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date = f.format(new Date());
        this.category = category;
        this.due_date = due_date;
        this.is_completed = is_completed;
        this.subject = subject;
        this.place = place;
    } //새로 생성, 수정할때
    
    public TodoItem(String title, String desc, String current_date, String category, String due_date){
        this.title = title;
        this.desc = desc;
        this.current_date = current_date;
        this.category = category;
        this.due_date = due_date;
    } //파일에서 받아올때
    
    public TodoItem(int is_completed){
        this.is_completed = is_completed;
    } //완료 체크할 때
    
    public TodoItem(String subject, int id){
        this.subject = subject;
    } //완료 체크할 때
    
    public TodoItem(int id, String place){
        this.place = place;
    } //완료 체크할 때
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
	
    public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
