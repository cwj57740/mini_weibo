package cn.edu.hit.weibo.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import cn.edu.hit.weibo.model.Blog;
import cn.edu.hit.weibo.subject.ModifyOperation;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyWindow {

	private JFrame frame;
	private JTextField textField;
	private Blog blog;
	private ModifyOperation modifyOperation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyWindow window = new ModifyWindow();
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
	public ModifyWindow() {
		initialize();
	}
	
	public ModifyWindow(Blog blog) {
		modifyOperation = new ModifyOperation();
		this.blog = blog;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_title = new JLabel("标题：");
		label_title.setFont(new Font("宋体", Font.PLAIN, 20));
		label_title.setBounds(31, 27, 72, 18);
		frame.getContentPane().add(label_title);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(117, 13, 755, 43);
		frame.getContentPane().add(textField);
		
		JLabel label_text = new JLabel("正文：");
		label_text.setFont(new Font("宋体", Font.PLAIN, 20));
		label_text.setBounds(31, 96, 72, 27);
		frame.getContentPane().add(label_text);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 136, 841, 121);
		frame.getContentPane().add(textArea);
		
		String title = textField.getText();
		String text = textArea.getText();
		textField.setText(blog.getTitle());
		textArea.setText(blog.getText());
		
		JButton button_sure = new JButton("确定");
		button_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title1 = textField.getText();
				String text1 = textArea.getText();
				blog.setText(text1);
				blog.setTitle(title1);
				modifyOperation.modify(blog);
				frame.dispose();
			}
		});
		button_sure.setFont(new Font("宋体", Font.PLAIN, 20));
		button_sure.setBounds(149, 315, 113, 27);
		frame.getContentPane().add(button_sure);
		
		JButton button_cancel = new JButton("取消");
		button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_cancel.setFont(new Font("宋体", Font.PLAIN, 20));
		button_cancel.setBounds(567, 315, 113, 27);
		frame.getContentPane().add(button_cancel);
	}

}
