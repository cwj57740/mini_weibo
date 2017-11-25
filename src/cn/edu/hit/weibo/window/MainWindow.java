package cn.edu.hit.weibo.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class MainWindow {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private Vector<String> columnNames;
	private DefaultTableModel dataModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		columnNames = new Vector<String>();
		columnNames.add("id");
		columnNames.add("标题");
		columnNames.add("正文");
		columnNames.add("阅读次数");
		columnNames.add("是否删除");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 961, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 136, 841, 119);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 352, 841, 327);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//显示表格数据
		
		JButton button_view = new JButton("查看");
		button_view.setFont(new Font("宋体", Font.PLAIN, 20));
		button_view.setBounds(50, 296, 113, 27);
		frame.getContentPane().add(button_view);
		
		JButton button_add = new JButton("发布");
		button_add.setFont(new Font("宋体", Font.PLAIN, 20));
		button_add.setBounds(280, 296, 113, 27);
		frame.getContentPane().add(button_add);
		
		JButton button_modify = new JButton("修改");
		button_modify.setFont(new Font("宋体", Font.PLAIN, 20));
		button_modify.setBounds(525, 296, 113, 27);
		frame.getContentPane().add(button_modify);
		
		JButton button_delete = new JButton("删除");
		button_delete.setFont(new Font("宋体", Font.PLAIN, 20));
		button_delete.setBounds(743, 296, 113, 27);
		frame.getContentPane().add(button_delete);
		
		JLabel Label_text = new JLabel("正文：");
		Label_text.setFont(new Font("宋体", Font.PLAIN, 20));
		Label_text.setBounds(50, 96, 72, 27);
		frame.getContentPane().add(Label_text);
		
		JLabel Label_title = new JLabel("标题：");
		Label_title.setFont(new Font("宋体", Font.PLAIN, 20));
		Label_title.setBounds(50, 27, 72, 18);
		frame.getContentPane().add(Label_title);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(136, 13, 755, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	/**
	 * @Description 刷新表格
	 * @param  参数
	 * @return void 返回类型 
	 * @throws
	 */
//	public void flashTable(){
//		Vector<Vector<String>>  = ;
//		if(!=null){
//			dataModel = new DefaultTableModel(,columnNames);
//			table.setModel(dataModel);
//		}
//		else{
//				JOptionPane.showMessageDialog(null, "未找到数据", "错误", JOptionPane.ERROR_MESSAGE);
//		}
//	}
	
}
