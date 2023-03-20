package org.example.gui;

import io.reactivex.disposables.Disposable;
import org.example.api.GitLabApi;
import org.example.api.QueryBean;
import org.example.gui.parser.IWorkListParser;
import org.example.gui.parser.WorkListDefaultParser;
import org.example.gui.parser.WorkListGsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkListFrame extends JFrame {

    private final TextArea textArea;
    private JTextField hostFiled;
    private JTextField tokenFiled;
    private JTextField nameFiled;
    private JTextField startTimeFiled;
    private JTextField endTimeFiled;

    private IWorkListParser workListParser;

    private WorkListDefaultParser defaultParser=new WorkListDefaultParser();
    private WorkListGsonParser gsonParser=new WorkListGsonParser();
    private final QueryBean presetBean;
    private JCheckBox rawDataCheckBox;

    public WorkListFrame(QueryBean presetBean) throws HeadlessException {
        workListParser=new WorkListDefaultParser();
        this.presetBean=presetBean;
       setStyle();
       setLayout(new BorderLayout());
       add(createTopPanel(),BorderLayout.NORTH);
        textArea = new TextArea();
       textArea.setSize(500,600);
       add(textArea,BorderLayout.CENTER);
       setPreInfo();
       setVisible(true);

    }

    private void setPreInfo() {
        if(presetBean==null){
            return;
        }
        hostFiled.setText(presetBean.baseUrl);
        nameFiled.setText(presetBean.name);
        tokenFiled.setText(presetBean.token);
    }

    private JPanel createTopPanel(){
        JPanel jPanel=new JPanel();
        jPanel.setPreferredSize(new Dimension(0,180));
        jPanel.setBackground(Color.WHITE);
       jPanel.setLayout(null);//不适用布局管理器
        hostFiled = addFiledToPanel(jPanel, "Gitlab 地址", 10);
        tokenFiled = addFiledToPanel(jPanel, "token", 35);
        nameFiled = addFiledToPanel(jPanel, "用户名", 60);
        JLabel label=new JLabel("日志包含开始时间和结束时间");
        label.setBounds(20,85,250,20);
        jPanel.add(label);

        rawDataCheckBox = new JCheckBox("查看原始json数据");
        rawDataCheckBox.setBounds(300,85,150,20);
        jPanel.add(rawDataCheckBox);

        startTimeFiled = addFiledToPanel(jPanel, "开始时间(格式 2023-01-02)", 110);
        endTimeFiled = addFiledToPanel(jPanel, "结束时间(格式 2023-01-02)", 135);
        JButton autoTimeButton=createAutoTimeButton(startTimeFiled,endTimeFiled);


        JButton queryButton=new JButton("查询");
        queryButton.addActionListener(queryAction);
        queryButton.setBounds(310,140,70,20);
        jPanel.add(queryButton);


        JButton copyButton=new JButton("复制");
        copyButton.setBounds(400,140,70,20);
        copyButton.addActionListener(copyAction);
        jPanel.add(copyButton);


        jPanel.add(autoTimeButton);
        return jPanel;
    }

    private AbstractAction queryAction=new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            long statTimeToRun=System.currentTimeMillis();
            //查询
            String baseUrl = hostFiled.getText();
            String name = nameFiled.getText();
            String token = tokenFiled.getText();
            String statTime = startTimeFiled.getText();
            String endTime = endTimeFiled.getText();
            QueryBean bean = new QueryBean(baseUrl, token, name, statTime, endTime);
            Disposable disposable = GitLabApi.getWorkList(bean)
                    .subscribe(list -> {
                        long runTime = System.currentTimeMillis() - statTimeToRun;
                        workListParser=rawDataCheckBox.isSelected()?gsonParser:defaultParser;
                        String workListInfo = workListParser.getWorkListInfo(runTime, bean, list);
                        textArea.setText(workListInfo);
                    }, e -> {
                        e.printStackTrace();
                        String s = "请求失败:" + e.getMessage();
                        textArea.setText(s);
                    });
        }
    };



    private AbstractAction copyAction=new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setClipboardString(textArea.getText());
            JOptionPane.showMessageDialog(null, "复制成功");
        }
    };

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    private JButton createAutoTimeButton(JTextField statTime,JTextField endTime){
        JButton autoTimeButton=new JButton("自动获取本周时间");

        int x = statTime.getWidth() + statTime.getX();
        autoTimeButton.setBounds(x+40,statTime.getY(),140,20);
        autoTimeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //自动生成时间，周一到周五
                Date date=new Date();
                Date firstDayOfWeek = TimeUtil.getFirstDayOfWeek(date);
                Date lastDayOfWeek = TimeUtil.getLastDayOfWeek(date);
                statTime.setText(sf.format(firstDayOfWeek));
                endTime.setText(sf.format(lastDayOfWeek));
            }
        });

        return autoTimeButton;
    }



    private JTextField addFiledToPanel(JPanel jPanel,String title,int y){
        int stringWidth = getStringWidth(title);
        int fieldWidth=100;
        if(stringWidth<100){
            stringWidth=100;
            fieldWidth=150;
        }
        JLabel label1=new JLabel(title);
        label1.setBounds(20,y,stringWidth+30,20);
        jPanel.add(label1);
        label1.getWidth();
        //默认20个字符款
        JTextField hostField=new JTextField(20);
        hostField.setBounds(stringWidth+30,y,fieldWidth,20);
        jPanel.add(hostField);
        return hostField;
    }

    private int getStringWidth(String title){
        JLabel label = new JLabel(title);
        Font font = label.getFont(); // JLabel所使用的字体
        String text = label.getText(); // JLabel文字内容
        FontMetrics fm = label.getFontMetrics(font); // 获取字体规格
        int width = fm.stringWidth(text); // 宽（像素）
        return width;
    }

    private void setStyle(){
        setTitle("GitLab工作记录查询器");
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/trs.jpg"));
        setIconImage(imageIcon.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
    }

}
