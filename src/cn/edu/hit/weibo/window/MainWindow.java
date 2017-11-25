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

import cn.edu.hit.weibo.component.Counter;
import cn.edu.hit.weibo.component.Logger;
import cn.edu.hit.weibo.dao.BlogDao;
import cn.edu.hit.weibo.model.Blog;
import cn.edu.hit.weibo.subject.ModifyOperation;
import cn.edu.hit.weibo.subject.ReadOperation;
import cn.edu.hit.weibo.util.ListtoVector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


  
    /**  
    * @ClassName: MainWindow  
    * @Description: TODO 程序主窗口
    * @author dell  
    * @date 2017年11月25日  
    *    
    */  
    
public class MainWindow {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private Vector<String> columnNames;
	private DefaultTableModel dataModel;
	private ReadOperation readOperation;
	private ModifyOperation modifyOperation;
	private Counter counter;
	private Logger logger;
	private BlogDao blogDao;

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
		modifyOperation = new ModifyOperation();
		readOperation = new ReadOperation();
		counter = new Counter(readOperation);
		readOperation.registerObserver(counter);
		logger = new Logger(modifyOperation);
		modifyOperation.registerObserver(logger);
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
		
		//微博标题
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(136, 13, 755, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//正文输入框
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 136, 841, 119);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 352, 841, 327);
		frame.getContentPane().add(scrollPane);
		
		//博文表
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//显示表格数据
		flashTable();
		
		JButton button_view = new JButton("查看");
		button_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String id = null;
				if(index!=-1){
					id = table.getValueAt(index,0).toString();
				}else{
					JOptionPane.showMessageDialog(null, "未选择博文", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				//测试用
//				System.out.println(id);
				
				if(id!=null){
					int blogid = Integer.parseInt(id);
					Blog blog = readOperation.read(blogid);
					textField.setText(blog.getTitle());
					textArea.setText(blog.getText());
					flashTable();
				}
			}
		});
		button_view.setFont(new Font("宋体", Font.PLAIN, 20));
		button_view.setBounds(50, 296, 113, 27);
		frame.getContentPane().add(button_view);
		
		JButton button_add = new JButton("发布");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String text = textArea.getText();
				Blog blog = new Blog();
				blog.setTitle(title);
				blog.setText(text);
				modifyOperation.add(blog);
				
				flashTable();
			}
		});
		button_add.setFont(new Font("宋体", Font.PLAIN, 20));
		button_add.setBounds(223, 296, 113, 27);
		frame.getContentPane().add(button_add);
		
		JButton button_modify = new JButton("修改");
		button_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String id = null;
				if(index!=-1){
					id = table.getValueAt(index,0).toString();
				}else{
					JOptionPane.showMessageDialog(null, "未选择博文", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
//				System.out.println(id);
				
				if(id!=null){
					int blogid = Integer.parseInt(id);
//					System.out.println(blogid);
					blogDao = new BlogDao();
					Blog blog = blogDao.getBlogById(blogid);
					new ModifyWindow(blog,modifyOperation);
					flashTable();
				}
			}
		});
		button_modify.setFont(new Font("宋体", Font.PLAIN, 20));
		button_modify.setBounds(430, 296, 113, 27);
		frame.getContentPane().add(button_modify);
		
		JButton button_delete = new JButton("删除");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String id = null;
				if(index!=-1){
					id = table.getValueAt(index,0).toString();
				}else{
					JOptionPane.showMessageDialog(null, "未选择博文", "错误", JOptionPane.ERROR_MESSAGE);
				}
				if(id!=null){
					int blogid = Integer.parseInt(id);
//					System.out.println(blogid);
					blogDao = new BlogDao();
					Blog blog = blogDao.getBlogById(blogid);
					modifyOperation.delete(blog);
					flashTable();
				}
			}
		});
		button_delete.setFont(new Font("宋体", Font.PLAIN, 20));
		button_delete.setBounds(620, 296, 113, 27);
		frame.getContentPane().add(button_delete);
		
		JLabel Label_text = new JLabel("正文：");
		Label_text.setFont(new Font("宋体", Font.PLAIN, 20));
		Label_text.setBounds(50, 96, 72, 27);
		frame.getContentPane().add(Label_text);
		
		JLabel Label_title = new JLabel("标题：");
		Label_title.setFont(new Font("宋体", Font.PLAIN, 20));
		Label_title.setBounds(50, 27, 72, 18);
		frame.getContentPane().add(Label_title);
		
		JButton button_refresh = new JButton("刷新");
		button_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flashTable();
			}
		});
		button_refresh.setFont(new Font("宋体", Font.PLAIN, 20));
		button_refresh.setBounds(777, 296, 113, 27);
		frame.getContentPane().add(button_refresh);
		
		
	}
	
	/**
	 * @Description 刷新表格
	 * @param  参数
	 * @return void 返回类型 
	 * @throws
	 */
	public void flashTable(){
		BlogDao blogDao = new BlogDao();
		Vector<Vector<String>> blogList = ListtoVector.toVector(blogDao.getAllBlogList());
		if(blogList!=null){
			dataModel = new DefaultTableModel(blogList,columnNames);
			table.setModel(dataModel);
		}
		else{
				JOptionPane.showMessageDialog(null, "未找到数据", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
