package bookrent;

import java.util.Scanner;

public class Bookmain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "MS949");
        
        
        while(true){
            String num = sc.nextLine();

            if(num.equals("1")){

            } else if(num.equals("2")){
                // 로그인이 안됬을경우 분기
            } else if(num.equals("3")){

            } else if(num.equals("4")){

            } else if(num.equals("5")){
                break;
            } else{
                System.out.println("잘못입력하셧습니다.");
            }
        }


    }

    public void printInfo(){
        System.out.println("1. 로그인");
        System.out.println("2. 로그아웃");
        System.out.println("3. 회원가입");
        System.out.println("4. 도서 검색");
        System.out.println("5. 프로그램 종료");
        System.out.print("메뉴입력: ");
    }

    public void userInfo(){
        System.out.println("1. 도서 대여");
        System.out.println("2. 도서 반납");
        System.out.println("3. 마이페이지");
        System.out.println("4. 개인정보수정");
        System.out.println("5. 메인으로");
        System.out.print("메뉴입력: ");
    }

    public void adminInfo(){
        System.out.println("1. 도서 관리");
        System.out.println("2. 회원 관리");
        System.out.println("3. 대여/반납 관리");
        System.out.println("4. 통계조회");
        System.out.println("5. 관리자 종료");
        System.out.print("메뉴입력: ");
    }

    public void bookAdminInfo(){
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 찾기");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("5. 도서관리 종료");
        System.out.print("메뉴입력: ");
    }

    public void userAdminInfo(){
        System.out.println("1. 유저 조회");
        System.out.println("2. 악성 유저");
        System.out.println("3. 유저관리 종료");
        System.out.print("메뉴입력: ");
    }

    public void rantalInfo(){
        System.out.println("1. ");
    }
}
