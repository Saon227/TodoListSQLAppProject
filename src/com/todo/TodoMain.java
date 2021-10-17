package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean quit = false;
		//l.importData("todolist.txt");
		Menu.displaymenu();
		do {
			Menu.prompt();
			String choice = sc.next();
			switch (choice) {

			case "add":
				System.out.println("\n[항목 추가]");
				TodoUtil.createItem(l);
				break;
			
			case "del":
				System.out.println("\n[항목 삭제]");
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				System.out.println("\n[항목 수정]");
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				System.out.println("\n[전체 목록 (총 " + l.getCount() + "개)]");
				TodoUtil.listAll(l);
				break;
				
			case "ls_cate":
				System.out.println("\n[카테고리 목록]");
				TodoUtil.listCategory(l);
				break;

			case "ls_name_asc":
				System.out.println("\n[제목순 정렬]");
				TodoUtil.listAll(l, "title", 1);
				break;

			case "ls_name_desc":
				System.out.println("\n[제목역순 정렬]");
				TodoUtil.listAll(l, "title", 0);
				break;
				
			case "ls_date":
				System.out.println("\n[날짜순 정렬]");
				TodoUtil.listAll(l, "due_date", 1);
				break;
				
			case "ls_date_desc":
				System.out.println("\n[날짜역순 정렬]");
				TodoUtil.listAll(l, "due_date", 0);
				break;
				
			case "find":
				String keyword = sc.next().trim();
				System.out.println("\n[항목 검색 결과]");
				TodoUtil.findKeyword(l, keyword);
				break;
				
			case "find_cate":
				String cate = sc.next().trim();
				System.out.println("\n[카테고리 검색 결과]");
				TodoUtil.findCategory(l, cate);
				break;
				
			case "comp":
				int num = sc.nextInt();
				TodoUtil.completeItem(l, num);
				break;
			
			case "ls_comp":
				TodoUtil.listComplete(l);
				break;
				
			case "help":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				System.out.println(" -> 종료합니다.");
				break;
			
			case "add_subject":
				TodoUtil.addSubject(l);
				break;
			
			case "add_place":
				TodoUtil.addPlace(l);
				break;

			default:
				System.out.println(" -> 정확한 명령어를 입력하세요. (도음말 - help)");
				break;
			}
		} while (!quit);
		//TodoUtil.saveList(l, "todolist.txt");
	}
}
