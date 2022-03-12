import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile;
import org.ini4j.Wini;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    public static Map<String, List<Profile.Section>> items = new HashMap<>();
    public static List<Profile.Section> barLocation;
    public static List<Profile.Section> itemList1;
    public static List<Profile.Section> itemList2;
    public static List<Profile.Section> itemList3;
    public static List<Profile.Section> itemList4;
    public static List<Profile.Section> itemList5;
    public static List<Profile.Section> itemList6;
    public static List<Profile.Section> itemList7;
    public static List<Profile.Section> itemList8;
    public static List<Profile.Section> itemList9;
    public static List<Profile.Section> itemList10;
    public static List<Profile.Section> itemList11;
    public static List<Profile.Section> itemList12;
    public static List<Profile.Section> itemList13;
    public static List<Profile.Section> itemList14;
    public static List<Profile.Section> itemList15;
    public static List<Profile.Section> itemList16;
    public static MainFrame mf;

    public static JPanel panel, panel2, panel3;

    public static int barSize = 195;

    public static void main(String args[]) throws IOException {
        //init();
        select();

        mf = new MainFrame();

        SecondFrame f = new SecondFrame();
    }

    public static void select() throws IOException {
        File iniFile = new File("recipe.ini");
        Ini ini = new Ini(iniFile);
        barLocation = ini.getAll("사이드바 위치");
        itemList1 = ini.getAll("혼합 (연습랭크 이상)");
        itemList2 = ini.getAll("굽기 (F랭크 이상)");
        itemList3 = ini.getAll("삶기 (E랭크 이상)");
        itemList4 = ini.getAll("반죽 (D랭크 이상)");
        itemList5 = ini.getAll("끓이기 (C랭크 이상)");
        itemList6 = ini.getAll("면만들기 (B랭크 이상)");
        itemList7 = ini.getAll("튀기기 (A랭크 이상)");
        itemList8 = ini.getAll("볶기 (9랭크 이상)");
        itemList9 = ini.getAll("파스타 만들기 (8랭크 이상)");
        itemList10 = ini.getAll("잼 만들기 (7랭크 이상)");
        itemList11 = ini.getAll("파이 만들기 (6랭크 이상)");
        itemList12 = ini.getAll("찌기 (5랭크 이상)");
        itemList13 = ini.getAll("피자 만들기 (4랭크 이상)");
        itemList14 = ini.getAll("발효 (3랭크 이상)");
        itemList15 = ini.getAll("수비드 (2랭크 이상)");
        itemList16 = ini.getAll("저미기 (1랭크 이상)");

        items.put("혼합 (연습랭크 이상)", itemList1);
        items.put("굽기 (F랭크 이상)", itemList2);
        items.put("삶기 (E랭크 이상)", itemList3);
        items.put("반죽 (D랭크 이상)", itemList4);
        items.put("끓이기 (C랭크 이상)", itemList5);
        items.put("면만들기 (B랭크 이상)", itemList6);
        items.put("튀기기 (A랭크 이상)", itemList7);
        items.put("볶기 (9랭크 이상)", itemList8);
        items.put("파스타 만들기 (8랭크 이상)", itemList9);
        items.put("잼 만들기 (7랭크 이상)", itemList10);
        items.put("파이 만들기 (6랭크 이상)", itemList11);
        items.put("찌기 (5랭크 이상)", itemList12);
        items.put("피자 만들기 (4랭크 이상)", itemList13);
        items.put("발효 (3랭크 이상)", itemList14);
        items.put("수비드 (2랭크 이상)", itemList15);
        items.put("저미기 (1랭크 이상)", itemList16);
    }
    public static void init() throws IOException {
        File iniFile = new File("recipe.ini");

        Wini wini = new Wini(iniFile);
        wini.put("혼합 (연습랭크 이상)", "에스프레소 마끼야또", "에스프레소|스팀밀크|물|41|40|19|최대생명력 5 증가, 의지 5 증가, 행운 5 증가");
        wini.put("혼합 (연습랭크 이상)", "아이스 카페 모카", "카페 모카|얼음|생크림|60|21|19|체력+ 20, 지력 + 30, 솜씨 + 30");

        wini.put("굽기 (F랭크 이상)", "은어소금구이", "은어|레몬|소금|75|9|16|최대생명력+24 , 솜씨+10 ,체력+10 상체근육증가");
        wini.put("굽기 (F랭크 이상)", "T본 스테이크", "커다란고기덩어리|타임|소금|77|15|8|최대생명력+40, 체력+8, 의지+5, 솜씨+5");

        wini.put("삶기 (E랭크 이상)", "메기 조개 찜", "메기|조개|마늘|50|40|10|생명력 33증가 , 의지35증가");
        wini.put("삶기 (E랭크 이상)", "버섯찜", "개암버섯|물|소금|61|29|10|최대생명력+18, 솜씨+5, 행운+5");

        wini.put("반죽 (D랭크 이상)", "밀가루 빵 반죽", "밀가루|이스트|물|65|12|23|다른 요리의 재료로 쓰임");
        wini.put("반죽 (D랭크 이상)", "옥수수 빵 반죽", "밀가루|옥수수가루|물|37|40|23|다른 요리의 재료로 쓰임");

        wini.put("끓이기 (C랭크 이상)", "크레이지 초코볼", "쿠킹포션|재료 초콜릿|후추|24|51|25|");
        wini.put("끓이기 (C랭크 이상)", "에스프레소", "볶은커피|물||19|81|0|솜씨 + 5,의지 +15,행운 +15");

        wini.put("면만들기 (B랭크 이상)", "누들", "물|밀가루|달걀|40|40|20|다른 요리의 재료로 쓰임");
        wini.put("면만들기 (B랭크 이상)", "소면", "물|밀가루|소금|50|45|5|다른 요리의 재료로 쓰임");

        wini.put("튀기기 (A랭크 이상)", "아브네아 잉어튀김", "아브네아잉어|튀김옷|소금|66|31|3|");
        wini.put("튀기기 (A랭크 이상)", "감자튀김", "튀김옷|감자||20|80|0|최대생명력+18, 체력+7");

        wini.put("볶기 (9랭크 이상)", "모듬볶음밥", "밥|야채모듬|베이컨|50|30|20|최대생명력+40, 체력+15, 지력+4, 솜씨+8, 의지+20");
        wini.put("볶기 (9랭크 이상)", "버섯볶음밥", "밥|야채모듬|양송이버섯|48|32|20|최대생명력+35, 체력+12, 지력+8, 솜씨+10, 의지+18");

        wini.put("파스타 만들기 (8랭크 이상)", "롱 파스타(1)", "물|파스타 반죽|소금|75|19|6|다른 요리의 재료로 쓰임");
        wini.put("파스타 만들기 (8랭크 이상)", "롱 파스타(2)", "물|파스타 반죽||80|20|0|다른 요리의 재료로 쓰임");

        wini.put("잼 만들기 (7랭크 이상)", "땅콩버터잼", "땅콩|올리브유|소금|65|31|4|다이어트 효과 ");
        wini.put("잼 만들기 (7랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");

        wini.put("파이 만들기 (6랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");
        wini.put("찌기 (5랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");
        wini.put("피자 만들기 (4랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");
        wini.put("발효 (3랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");
        wini.put("수비드 (2랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");
        wini.put("저미기 (1랭크 이상)", "포도잼", "포도|설탕||52|48|0|다이어트효과 지력 솜씨 영구증가");

        //신규생성

        wini.store();
        //저장

    }
}



