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
				System.out.println("\n[�׸� �߰�]");
				TodoUtil.createItem(l);
				break;
			
			case "del":
				System.out.println("\n[�׸� ����]");
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				System.out.println("\n[�׸� ����]");
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				System.out.println("\n[��ü ��� (�� " + l.getCount() + "��)]");
				TodoUtil.listAll(l);
				break;
				
			case "ls_cate":
				System.out.println("\n[ī�װ� ���]");
				TodoUtil.listCategory(l);
				break;

			case "ls_name_asc":
				System.out.println("\n[����� ����]");
				TodoUtil.listAll(l, "title", 1);
				break;

			case "ls_name_desc":
				System.out.println("\n[���񿪼� ����]");
				TodoUtil.listAll(l, "title", 0);
				break;
				
			case "ls_date":
				System.out.println("\n[��¥�� ����]");
				TodoUtil.listAll(l, "due_date", 1);
				break;
				
			case "ls_date_desc":
				System.out.println("\n[��¥���� ����]");
				TodoUtil.listAll(l, "due_date", 0);
				break;
				
			case "find":
				String keyword = sc.next().trim();
				System.out.println("\n[�׸� �˻� ���]");
				TodoUtil.findKeyword(l, keyword);
				break;
				
			case "find_cate":
				String cate = sc.next().trim();
				System.out.println("\n[ī�װ� �˻� ���]");
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
				System.out.println(" -> �����մϴ�.");
				break;
			
			case "add_subject":
				TodoUtil.addSubject(l);
				break;
			
			case "add_place":
				TodoUtil.addPlace(l);
				break;

			default:
				System.out.println(" -> ��Ȯ�� ��ɾ �Է��ϼ���. (������ - help)");
				break;
			}
		} while (!quit);
		//TodoUtil.saveList(l, "todolist.txt");
	}
}
