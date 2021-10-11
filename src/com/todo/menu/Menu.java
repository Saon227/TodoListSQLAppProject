package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
    	System.out.println();
    	System.out.println("[To Do List 명령어 사용방법]");
        System.out.println(" 항목 추가 : add");
        System.out.println(" 항목 삭제 : del");
        System.out.println(" 항목 수정 : edit");
        System.out.println(" 전체 목록 : ls");
        System.out.println(" 카테고리 목록 : ls_cate");
        System.out.println(" 제목순 정렬 : ls_name_asc");
        System.out.println(" 제목역순 정렬 : ls_name_desc");
        System.out.println(" 날짜순 정렬 : ls_date");
        System.out.println(" 날짜역순 정렬 : ls_date_desc");
        System.out.println(" 완료 체크 : comp [id]");
        System.out.println(" 완료 항목 정렬 : comp_ls");
        System.out.println(" 항목 검색 : find [키워드]");
        System.out.println(" 카테고리 검색 : find_cate [키테고리]");
        System.out.println(" 종료 : exit");
    }
    
    public static void prompt() {
    	System.out.print("\n명령어를 입력하세요 > ");
    }
}
