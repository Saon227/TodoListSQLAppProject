package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
    	System.out.println();
    	System.out.println("[To Do List ��ɾ� �����]");
        System.out.println(" �׸� �߰� : add");
        System.out.println(" �׸� ���� : del");
        System.out.println(" �׸� ���� : edit");
        System.out.println(" ��ü ��� : ls");
        System.out.println(" ī�װ� ��� : ls_cate");
        System.out.println(" ����� ���� : ls_name_asc");
        System.out.println(" ���񿪼� ���� : ls_name_desc");
        System.out.println(" ��¥�� ���� : ls_date");
        System.out.println(" ��¥���� ���� : ls_date_desc");
        System.out.println(" �Ϸ� üũ : comp [id]");
        System.out.println(" �Ϸ� �׸� ���� : comp_ls");
        System.out.println(" �׸� �˻� : find [Ű����]");
        System.out.println(" ī�װ� �˻� : find_cate [Ű�װ�]");
        System.out.println(" ���� �߰� : add_subject");
        System.out.println(" ��� �߰� : add_place");
        System.out.println(" ���� : exit");
    }
    
    public static void prompt() {
    	System.out.print("\n��ɾ �Է��ϼ��� > ");
    }
}
