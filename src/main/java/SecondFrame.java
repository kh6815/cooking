import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SecondFrame extends JFrame implements ItemListener {

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
    JButton j4_;
    JButton j5_;
    JButton j6_;

    JTextField tf = new JTextField(100);
    JTextField sf = new JTextField(200);

    Button barLenBtn;
    Button searchBtn;

    String searchText1;
    String searchText2;
    String searchText3;

    MouseAdapter mouseAdapter1 = new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            System.out.println("1");
            System.out.println("me = " + me.getSource());
            sf.setText(searchText1);
            ActionEvent actionEvent = new ActionEvent(searchBtn, ActionEvent.ACTION_PERFORMED, "1");
            ActionListener actionListener = searchBtn.getActionListeners()[0];
            actionListener.actionPerformed(actionEvent);
        }
    };
    MouseAdapter mouseAdapter2 = new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            System.out.println("2");
            System.out.println("me = " + me.getSource());
            sf.setText(searchText2);
            ActionEvent actionEvent = new ActionEvent(searchBtn, ActionEvent.ACTION_PERFORMED, "1");
            ActionListener actionListener = searchBtn.getActionListeners()[0];
            actionListener.actionPerformed(actionEvent);
        }
    };
    MouseAdapter mouseAdapter3 = new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            System.out.println("3");
            System.out.println("me = " + me.getSource());
            sf.setText(searchText3);
            ActionEvent actionEvent = new ActionEvent(searchBtn, ActionEvent.ACTION_PERFORMED, "1");
            ActionListener actionListener = searchBtn.getActionListeners()[0];
            actionListener.actionPerformed(actionEvent);
        }
    };
    public SecondFrame()
    {
        super("????????? ??????");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setTitle("MainFrame")
        setSize(600, 500);
        setVisible(true);

        ch = new Choice();
        ch.addItem("?????? ??????");
        ch.addItem("?????? (???????????? ??????)");
        ch.addItem("?????? (F?????? ??????)");
        ch.addItem("?????? (E?????? ??????)");
        ch.addItem("?????? (D?????? ??????)");
        ch.addItem("????????? (C?????? ??????)");
        ch.addItem("???????????? (B?????? ??????)");
        ch.addItem("????????? (A?????? ??????)");
        ch.addItem("?????? (9?????? ??????)");
        ch.addItem("????????? ????????? (8?????? ??????)");
        ch.addItem("??? ????????? (7?????? ??????)");
        ch.addItem("?????? ????????? (6?????? ??????)");
        ch.addItem("?????? (5?????? ??????)");
        ch.addItem("?????? ????????? (4?????? ??????)");
        ch.addItem("?????? (3?????? ??????)");
        ch.addItem("????????? (2?????? ??????)");
        ch.addItem("????????? (1?????? ??????)");
        add(ch);

        ch.addItemListener(this);

        setLayout( null );
        ch.setBounds(10,10,200,30);

        m_ListModel = new DefaultListModel<>();
        m_List = new JList<String>(m_ListModel);
        m_ScrollPane = new JScrollPane(m_List);
        java.util.List<String> list = new ArrayList<>();

        for(String strKey : Main.items.keySet()){
            try {
                Set<String> strings = Main.items.get(strKey).get(0).keySet();
                for (String string : strings) {
                    if(!string.equals("->??????_??????(") && list.contains(string)){
                        System.out.println(string);
                        list.add(string + " ->??????_??????(" + strKey + ")");

                        File iniFile = new File("recipe.ini");
                        Wini wini = new Wini(iniFile);
                        String value = wini.get(strKey, string);
                        System.out.println("value = " + value);
                        wini.remove(strKey,string);
                        wini.put(strKey, string + " ->??????_??????(" + strKey + ")", value);
                        wini.store();
                        //multiList.put(string + " =>??????_??????(" + strKey + ")", strKey);

                        Main.items.get(strKey).get(0).remove(string);
                        Main.items.get(strKey).get(0).add(string + " ->??????_??????(" + strKey + ")", value);
                    }else{
                        list.add(string);
                    }
                }
            } catch(NullPointerException e){

            } catch (InvalidFileFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(list);
        //m_ListModel.removeAllElements();
        for (String s : list) {
            m_ListModel.addElement(s);
        }

        add(m_ScrollPane);
        m_ScrollPane.setBounds(10, 80, 250, 380);

        //??? ?????? ??????
        Action barLenAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Main.barSize =  Integer.parseInt(tf.getText());
                Main.mf.setSize(Main.barSize,10);
            }
        };
        tf.setText(String.valueOf(Main.barSize));
        add(tf).setBounds(280, 10, 80, 30);
        tf.addActionListener(barLenAction);
        barLenBtn = new Button("??? ?????? ??????");
        barLenBtn.addActionListener(barLenAction);
        add(barLenBtn).setBounds(370, 10, 100, 30);

        //?????? ??????
        Action searchAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                m_ListModel.clear();
                Set<String> strings;
                for(String strKey : Main.items.keySet()){
                    try {
                        strings = Main.items.get(strKey).get(0).keySet();
                        for (String string : strings) {
                            if(string.contains(sf.getText())){
                                m_ListModel.addElement(string);
                            }
                        }
                    }catch (NullPointerException nullPointerException){

                    }
                }

                if(m_ListModel.size() == 0) JOptionPane.showMessageDialog(null, "???????????? ????????? ????????????.", "?????? ??????", JOptionPane.ERROR_MESSAGE);
            }
        };
        add(sf).setBounds(10, 40, 180, 30);
        sf.addActionListener(searchAction);
        searchBtn = new Button("?????? ??????");
        searchBtn.addActionListener(searchAction);
        add(searchBtn).setBounds(190, 40, 80, 30);

        j1 = new JLabel("?????? ?????? : ");
        j2 = new JLabel("????????? : ");
        j3 = new JLabel("?????? : ");
        j4 = new JLabel("??????1");
        j5 = new JLabel("??????2");
        j6 = new JLabel("??????3");
        j7 = new JLabel("?????? : ");
        j4_ = new JButton("1");
        j5_ = new JButton("2");
        j6_ = new JButton("3");
        add(j1).setBounds(280, 60, 500, 200);
        add(j2).setBounds(280, 100, 500, 200);
        add(j3).setBounds(280, 140, 500, 200);
        add(j4).setBounds(350, 220, 500, 50);
        add(j4_).setLocation(350,140);
        add(j5).setBounds(350, 250, 500, 50);
        add(j5_).setLocation(350,170);
        add(j6).setBounds(350, 280, 500, 50);
        add(j6_).setLocation(350,200);
        add(j7).setBounds(280, 250, 500, 200);

        // ????????? ????????? ??????
        JListHandler handler = new JListHandler();
        m_List.addListSelectionListener(handler);

    }
    class JListHandler implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            Set<String> strings;
            j4.removeMouseListener(mouseAdapter1);
            j5.removeMouseListener(mouseAdapter2);
            j6.removeMouseListener(mouseAdapter3);
            j4.setForeground(Color.black);
            j5.setForeground(Color.black);
            j6.setForeground(Color.black);

            for(String strKey : Main.items.keySet()){
                try{
                    if(Main.items.get(strKey).get(0).get(m_List.getSelectedValue()) != null){
                        String[] temp = String.valueOf(Main.items.get(strKey).get(0).get(m_List.getSelectedValue())).split("[|]");

                        j1.setText("?????? ?????? : " + m_List.getSelectedValue());
                        j2.setText("????????? : " + strKey);
                        j3.setText("?????? : " );
                        j4.setText(temp[0] + "(" + temp[3] + "%)");
                        j5.setText(temp[1] + "(" + temp[4] + "%)");
                        j6.setText(temp[2] + "(" + temp[5] + "%)");



                        ArrayList<String> keyList = new ArrayList<>(Main.items.keySet());
                        for(int i = 0; i < keyList.size(); i++){
                            try {
                                if(Main.items.get(keyList.get(i)).get(0).get(temp[0]) != null){
                                    //searchEvent(j4, temp[0]);
                                    j4.setForeground(Color.blue);
                                    searchText1 = temp[0];
                                    j4.addMouseListener(mouseAdapter1);
                                    //System.out.println("searchText1 = " + searchText1);
                                }
                                else if(Main.items.get(keyList.get(i)).get(0).get(temp[1]) != null){
                                    j5.setForeground(Color.blue);
                                    searchText2 = temp[1];
                                    j5.addMouseListener(mouseAdapter2);
                                    //System.out.println("searchText2 = " + searchText2);
                                }
                                else if(Main.items.get(keyList.get(i)).get(0).get(temp[2]) != null){
                                    j6.setForeground(Color.blue);
                                    searchText3 = temp[2];
                                    j6.addMouseListener(mouseAdapter3);
                                    //System.out.println("searchText3 = " + searchText3);
                                }
                            }catch (NullPointerException nullPointerException){

                            }
                        }

                        if(temp.length > 6 ){
                            j7.setText("?????? : " + temp[6]);
                        }
                        else{
                            j7.setText("?????? : ");
                        }

                        //System.out.println(mf);
                        //mf.getContentPane().setBackground(Color.BLUE)

                        int first = Integer.parseInt(temp[3]);
                        int second = first + Integer.parseInt(temp[4]);
                        int third = second + Integer.parseInt(temp[5]);

                        Main.panel.setSize(Main.barSize * first / 100, 10);
                        Main.panel2.setSize(Main.barSize * second / 100, 10);
                        Main.panel3.setSize(Main.barSize * third / 100, 10);

                        return;
                    }
                }catch (NullPointerException nullPointerException){
                }
            }
        }
    }

    private void searchEvent(JLabel jLabel ,String text) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        m_ListModel.clear();
        List<String> list = new ArrayList<>();

        Set<String> strings;
        switch (ch.getSelectedItem()) {
            case "?????? ??????" :
                for(String strKey : Main.items.keySet()){
                    try {
                        strings = Main.items.get(strKey).get(0).keySet();
                        for (String string : strings) {
                            //m_ListModel.addElement(string);
                            list.add(string);
                        }
                    } catch(NullPointerException nullPointerException){

                    }
                }
                break;
            case "?????? (???????????? ??????)" :
                strings = Main.items.get("?????? (???????????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (F?????? ??????)" :
                strings = Main.items.get("?????? (F?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (E?????? ??????)" :
                strings = Main.items.get("?????? (E?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (D?????? ??????)" :
                strings = Main.items.get("?????? (D?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "????????? (C?????? ??????)" :
                strings = Main.items.get("????????? (C?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "???????????? (B?????? ??????)" :
                strings = Main.items.get("???????????? (B?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "????????? (A?????? ??????)" :
                strings = Main.items.get("????????? (A?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (9?????? ??????)" :
                strings = Main.items.get("?????? (9?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "????????? ????????? (8?????? ??????)" :
                strings = Main.items.get("????????? ????????? (8?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "??? ????????? (7?????? ??????)" :
                strings = Main.items.get("??? ????????? (7?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? ????????? (6?????? ??????)" :
                strings = Main.items.get("?????? ????????? (6?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (5?????? ??????)" :
                strings = Main.items.get("?????? (5?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? ????????? (4?????? ??????)" :
                strings = Main.items.get("?????? ????????? (4?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "?????? (3?????? ??????)" :
                strings = Main.items.get("?????? (3?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "????????? (2?????? ??????)" :
                strings = Main.items.get("????????? (2?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
            case "????????? (1?????? ??????)" :
                strings = Main.items.get("????????? (1?????? ??????)").get(0).keySet();
                for (String string : strings) {
                    //m_ListModel.addElement(string);
                    list.add(string);
                }
                break;
        }
        Collections.sort(list);
        for (String s : list) {
            m_ListModel.addElement(s);
        }
    }
}

