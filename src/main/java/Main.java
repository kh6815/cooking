import org.ini4j.Ini;
import org.ini4j.Profile;
import org.ini4j.Wini;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static Map<String, List<Profile.Section>> items = new HashMap<>();
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

        /*
        Point initialClick; // 마우스의 x, y 좌표를 저장하기 위해 선언
        JFrame j = new JFrame();
        j.setResizable(false); // 크기 변경 불가능하도록 함
        j.setUndecorated(true);
        j.setSize(300,300);
        j.setVisible(true);
        j.addMouseListener(new moveWindows()); // 윈도우 이동하기 위해 설정
        j.addMouseMotionListener(new moveWindows()); // 윈도우 이동하기 위해 설정
        */

    }

    public static void select() throws IOException {
        File iniFile = new File("recipe.ini");
        Ini ini = new Ini(iniFile);
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

        System.out.println(items);
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

    public static class MainFrame extends JFrame
    {
        //private Mainpg m_pg = null;

        private Point initialClick;

        public MainFrame()
        {
            setResizable(false);
            setUndecorated(true);

            // setTitle("MainFrame")
            setSize(barSize, 10);
            setAlwaysOnTop( true );
            setVisible(true);

            panel = new JPanel();
            panel.setBackground(Color.GREEN);
            panel.setSize(barSize * 30 / 100, 10);
            //panel.setSize(0, 0);
            panel.setLocation(0,0);

            panel2 = new JPanel();
            panel2.setBackground(Color.red);
            panel2.setSize(barSize * 40 / 100, 10);
            //panel2.setSize(0, 0);
            panel2.setLocation(0,0);

            panel3 = new JPanel();
            panel3.setBackground(Color.blue);
            panel3.setSize(barSize * 100 / 100, 10);
            //panel3.setSize(0, 0);
            panel3.setLocation(0,0);

            setLayout(null);
            getContentPane().add(panel);
            getContentPane().add(panel2);
            getContentPane().add(panel3);

            this.addMouseListener(new moveWindows());
            this.addMouseMotionListener(new moveWindows());
        }

        class moveWindows extends MouseAdapter
        {
            public void mousePressed(MouseEvent e)
            {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }

            public void mouseDragged(MouseEvent e)
            {
                JFrame jf = (JFrame) e.getSource();

                int thisX = jf.getLocation().x;
                int thisY = jf.getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                jf.setLocation(X, Y);
            }
        }
    }
    public static class SecondFrame extends JFrame implements ItemListener
    {
        Choice ch;
        JScrollPane m_ScrollPane = null;
        DefaultListModel<String> m_ListModel = null;
        JList m_List = null;

        JLabel j1;
        JLabel j2;
        JLabel j3;
        JLabel j4;
        JLabel j5;
        JLabel j6;
        JLabel j7;

        JTextField tf = new JTextField(100);

        Button barLenBtn;
        public SecondFrame()
        {
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // setTitle("MainFrame")
            setSize(600, 500);
            setVisible(true);

            ch = new Choice();
            ch.addItem("전체 목록");
            ch.addItem("혼합 (연습랭크 이상)");
            ch.addItem("굽기 (F랭크 이상)");
            ch.addItem("삶기 (E랭크 이상)");
            ch.addItem("반죽 (D랭크 이상)");
            ch.addItem("끓이기 (C랭크 이상)");
            ch.addItem("면만들기 (B랭크 이상)");
            ch.addItem("튀기기 (A랭크 이상)");
            ch.addItem("볶기 (9랭크 이상)");
            ch.addItem("파스타 만들기 (8랭크 이상)");
            ch.addItem("잼 만들기 (7랭크 이상)");
            ch.addItem("파이 만들기 (6랭크 이상)");
            ch.addItem("찌기 (5랭크 이상)");
            ch.addItem("피자 만들기 (4랭크 이상)");
            ch.addItem("발효 (3랭크 이상)");
            ch.addItem("수비드 (2랭크 이상)");
            ch.addItem("저미기 (1랭크 이상)");
            add(ch);

            ch.addItemListener(this);

            setLayout( null );
            ch.setBounds(10,10,200,30);

            m_ListModel = new DefaultListModel<>();
            m_List = new JList<String>(m_ListModel);
            m_ScrollPane = new JScrollPane(m_List);

            for(String strKey : items.keySet()){
                Set<String> strings = items.get(strKey).get(0).keySet();
                for (String string : strings) {
                    m_ListModel.addElement(string);
                }
            }

            add(m_ScrollPane);
            m_ScrollPane.setBounds(10, 60, 250, 400);

            tf.setText(String.valueOf(barSize));
            add(tf).setBounds(280, 20, 80, 30);
            barLenBtn = new Button("바 길이 조정");
            barLenBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    barSize =  Integer.parseInt(tf.getText());
                    mf.setSize(barSize,10);
                }
            });
            add(barLenBtn).setBounds(370, 20, 100, 30);

           j1 = new JLabel("요리 이름 : ");
            j2 = new JLabel("조리법 : ");
            j3 = new JLabel("재료 : ");
            j4 = new JLabel("재료1");
            j5 = new JLabel("재료2");
            j6 = new JLabel("재료3");
            j7 = new JLabel("효과 : ");
            add(j1).setBounds(280, 60, 500, 200);
            add(j2).setBounds(280, 100, 500, 200);
            add(j3).setBounds(280, 140, 500, 200);
            add(j4).setBounds(350, 140, 500, 200);
            add(j5).setBounds(350, 160, 500, 200);
            add(j6).setBounds(350, 180, 500, 200);
            add(j7).setBounds(280, 240, 500, 200);

            // 이벤트 핸들러 등록
            JListHandler handler = new JListHandler();
            m_List.addListSelectionListener(handler);

        }
        class JListHandler implements ListSelectionListener
        {
            String[] temp;
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Set<String> strings;
                for(String strKey : items.keySet()){
                    if(items.get(strKey).get(0).get(m_List.getSelectedValue()) != null){
                        temp = String.valueOf(items.get(strKey).get(0).get(m_List.getSelectedValue())).split("[|]");

                        j1.setText("요리 이름 : " + m_List.getSelectedValue());
                        j2.setText("조리법 : " + strKey);
                        j3.setText("재료 : " );
                        j4.setText(temp[0] + "(" + temp[3] + "%)");
                        j5.setText(temp[1] + "(" + temp[4] + "%)");
                        j6.setText(temp[2] + "(" + temp[5] + "%)");
                        if(temp.length > 6 ){
                            j7.setText("효과 : " + temp[6]);
                        }

                        //System.out.println(mf);
                        //mf.getContentPane().setBackground(Color.BLUE)

                        int first = Integer.parseInt(temp[3]);
                        int second = first + Integer.parseInt(temp[4]);
                        int third = second + Integer.parseInt(temp[5]);

                        panel.setSize(barSize * first / 100, 10);

                        panel2.setSize(barSize * second / 100, 10);

                        panel3.setSize(barSize * third / 100, 10);

                        //return;
                    }
                }
            }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            m_ListModel.clear();

            Set<String> strings;
            switch (ch.getSelectedItem()) {
                case "전체 목록" :
                    for(String strKey : items.keySet()){
                        strings = items.get(strKey).get(0).keySet();
                        for (String string : strings) {
                            m_ListModel.addElement(string);
                        }
                    }
                    break;
                case "혼합 (연습랭크 이상)" :
                    strings = items.get("혼합 (연습랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "굽기 (F랭크 이상)" :
                    strings = items.get("굽기 (F랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "삶기 (E랭크 이상)" :
                    strings = items.get("삶기 (E랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "반죽 (D랭크 이상)" :
                    strings = items.get("반죽 (D랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "끓이기 (C랭크 이상)" :
                    strings = items.get("끓이기 (C랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "면만들기 (B랭크 이상)" :
                    strings = items.get("면만들기 (B랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "튀기기 (A랭크 이상)" :
                    strings = items.get("튀기기 (A랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "볶기 (9랭크 이상)" :
                    strings = items.get("볶기 (9랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "파스타 만들기 (8랭크 이상)" :
                    strings = items.get("파스타 만들기 (8랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "잼 만들기 (7랭크 이상)" :
                    strings = items.get("잼 만들기 (7랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "파이 만들기 (6랭크 이상)" :
                    strings = items.get("파이 만들기 (6랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "찌기 (5랭크 이상)" :
                    strings = items.get("찌기 (5랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "피자 만들기 (4랭크 이상)" :
                    strings = items.get("피자 만들기 (4랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "발효 (3랭크 이상)" :
                    strings = items.get("발효 (3랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "수비드 (2랭크 이상)" :
                    strings = items.get("수비드 (2랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
                case "저미기 (1랭크 이상)" :
                    strings = items.get("저미기 (1랭크 이상)").get(0).keySet();
                    for (String string : strings) {
                        m_ListModel.addElement(string);
                    }
                    break;
            }
        }
    }
}



