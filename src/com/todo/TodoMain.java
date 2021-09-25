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
		boolean isList = false;
		boolean quit = false;
		TodoUtil.loadList(l, "todolist.txt");
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
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
				System.out.println("[전체 목록 (총 " + l.getList().size() + "개)]");
				isList = true; //TodoUtil.listAll(l);
				break;

			case "ls_name_asc":
				l.sortByName();
				System.out.println("\n[제목순 정렬]");
				isList = true;
				break;

			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("\n[제목역순 정렬]");
				isList = true;
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("\n[날짜순 정렬]");
				isList = true;
				break;
				
			case "find":
				String keyword = sc.next().trim();
				System.out.println("[항목 검색 결과]");
				TodoUtil.findItem(l, keyword);
				break;
				
			case "help":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				System.out.println(" -> 종료합니다.");
				break;

			default:
				System.out.println(" -> 정확한 명령어를 입력하세요. (도음말 - help)");
				break;
			}
			
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		TodoUtil.saveList(l, "todolist.txt");
	}
}
