package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);

		System.out.print(" 제목을 입력하세요 > ");
		title = sc.next().trim();
		
		if (list.isDuplicate(title)) {
			System.out.println(" -> 제목이 중복되었습니다.");
			return;
		}
		
		System.out.print(" 카테고리를 입력하세요 > ");
		category = sc.next().trim();
		
		sc.nextLine();
		System.out.print(" 내용을 입력하세요 > ");
		desc = sc.nextLine().trim();
		
		//sc.nextLine();
		System.out.print(" 마감날짜를 입력하세요 > ");
		due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		list.addItem(t);
		System.out.println(" -> 저장되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" 삭제할 제목을 입력하세요 > ");
		
		String title = sc.next();
		
		boolean flag = false;
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println(" -> 삭제되었습니다.");
				flag = true;
				break;
			}
		}
		if(flag == false) {
				System.out.println(" -> 해당 제목이 존재하지 않습니다.");
		}
	}

	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print(" 수정할 제목을 입력하세요 > ");
		String title = sc.next().trim();
		
		if (!l.isDuplicate(title)) {
			System.out.println(" -> 해당 제목이 존재하지 않습니다.");
			return;
		}

		System.out.print(" 새로운 제목을 입력하세요 > ");
		String new_title = sc.next().trim();
		
		if (l.isDuplicate(new_title)) {
			System.out.println(" -> 제목이 중복되었습니다.");
			return;
		}
		
		System.out.print(" 수정할 카테고리를 입력하세요 > ");
		String new_category = sc.next().trim();
		
		sc.nextLine();
		System.out.print(" 새로운 내용을 입력하세요 > ");
		String new_description = sc.nextLine().trim();
		
		sc.nextLine();
		System.out.print(" 새로운 마감날짜를 입력하세요 > ");
		String new_due_date = sc.nextLine().trim();
		
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_date);
				l.addItem(t);
				System.out.println(" -> 수정되었습니다.");
			}
		}
	}

	public static void listAll(TodoList l) {
		//System.out.println("[전체 목록]");
		int index = 1;
		for (TodoItem item : l.getList()) {
			System.out.println(" " + index + ". "+ item.toString());
			index++;
		}
	}
	
	public static void loadList(TodoList l, String filename) {
		//BufferedReader, FileReader, StringTokenizer 사용
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String oneline;
			int count = 0;
			while((oneline = br.readLine()) != null) {
				count++;
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String category = st.nextToken();
				String title = st.nextToken();
				String desc = st.nextToken();
				String due_date = st.nextToken();
				String current_date = st.nextToken();
				
				TodoItem t = new TodoItem(title, desc, current_date, category, due_date);
				l.addItem(t);
			}
			br.close();
			System.out.println(count + "개의 항목을 읽었습니다.");
			
		} catch(FileNotFoundException e) {
			System.out.println(filename + " 파일이 없습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveList(TodoList l, String filename) {
		//FileWriter 사용
		try {
			Writer w = new FileWriter(filename);
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());
			}
			w.close();
			
			System.out.println(" -> 모든 데이터가 저장되었습니다.");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}
