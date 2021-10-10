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
	
	public static void createItem(TodoList l) {

		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);

		System.out.print(" 제목을 입력하세요 > ");
		title = sc.next().trim();
		
		if (l.isDuplicate(title)) {
			System.out.println(" -> 제목이 중복되었습니다.");
			return;
		}
		
		System.out.print(" 카테고리를 입력하세요 > ");
		category = sc.next().trim();
		
		sc.nextLine();
		System.out.print(" 내용을 입력하세요 > ");
		desc = sc.nextLine().trim();
		
		System.out.print(" 마감날짜를 입력하세요 > ");
		due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date);

		if(l.addItem(t)>0)
			System.out.println(" -> 저장되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" 삭제할 항목의 번호를 입력하세요 > ");
		int num = sc.nextInt();
		
		if (num < 1 || l.getList().size() < num) {
			System.out.println(" -> 해당 번호가 존재하지 않습니다.");
			return;
		}
		
		if(l.deleteItem(num) > 0)
			System.out.println(" -> 삭제되었습니다.");
	}

	public static void updateItem(TodoList l) {

		Scanner sc = new Scanner(System.in);

		System.out.print(" 수정할 항목의 번호를 입력하세요 > ");
		int num = sc.nextInt();
		
		if (num < 1 || l.getList().size() < num) {
			System.out.println(" -> 해당 번호가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(" " + num + ". "+ l.getList().get(num-1).toString());

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
		
		System.out.print(" 새로운 마감날짜를 입력하세요 > ");
		String new_due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_date);
		t.setId(num);
		if(l.updateItem(t) > 0)
			System.out.println(" -> 수정되었습니다.");
	}
	
	public static void listCategory(TodoList l) {
		int count = 0;
		for(String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.println("\n -> 총 " + count + "개의 카테고리가 등록되어 있습니다.");
	}

	
	public static void findKeyword(TodoList l, String keyword) {
		int count = 0;
		for (TodoItem item : l.getList(keyword)) {
			count++;
			System.out.println(" " + count + ". "+ item.toString());
		}
		System.out.println(" -> 총 " + count + "개의 항목을 찾았습니다.");
	}
	
	public static void findCategory(TodoList l, String cate) {
		int count = 0;
		for (TodoItem item : l.getListCategory(cate)) {
			count++;
			System.out.println(" " + count + ". "+ item.toString());
		}
		System.out.println(" -> 총 " + count + "개의 항목을 찾았습니다.");
	}
	
	public static void listAll(TodoList l) {
		int index = 0;
		for (TodoItem item : l.getList()) {
			index++;
			System.out.println(" " + index + ". "+ item.toString());
		}
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.println("\n[전체 목록 (총 " + l.getCount() + "개)]");
		int index = 0;
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			index++;
			System.out.println(" " + index + ". "+ item.toString());
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
