package calculator;
 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
 
public class Calculator {
	public static void main(String[] args) {
		/** add JFrame */
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setTitle("计算器");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		frame.setLayout(new BorderLayout());

		/** add JTextField */
		JTextField jtf = new JTextField("");
		jtf.setEnabled(true);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		jtf.setEditable(false);
		frame.add(jtf, BorderLayout.NORTH);

		/** add listener */
		ActionListener command = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getActionCommand().equals("BackSpace")) {
						StringBuffer sb = new StringBuffer(jtf.getText());
						jtf.setText(sb.substring(0, sb.length()-1));
					}
					else if (e.getActionCommand().equals("C")) {
						jtf.setText("");
					}
					else if (e.getActionCommand().equals("=")) {
						jtf.setText(calculate(jtf.getText()));
					}
					else {
						jtf.setText(jtf.getText() + e.getActionCommand());
					}
				} catch (Exception ex) {
					jtf.setText("ERROR");
				}
            }
		};

		/** add JPanels */
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 4));
		frame.add(panel1, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2));
		frame.add(panel2, BorderLayout.SOUTH);

		/** add buttons */
		panel1.add(addButton("7", command));
		panel1.add(addButton("8", command));
		panel1.add(addButton("9", command));
		panel1.add(addButton("+", command));
		panel1.add(addButton("4", command));
		panel1.add(addButton("5", command));
		panel1.add(addButton("6", command));
		panel1.add(addButton("-", command));
		panel1.add(addButton("1", command));
		panel1.add(addButton("2", command));
		panel1.add(addButton("3", command));
		panel1.add(addButton("*", command));
		panel1.add(addButton(".", command));
		panel1.add(addButton("0", command));
		panel1.add(addButton("=", command));
		panel1.add(addButton("/", command));
		panel2.add(addButton("BackSpace", command));
		panel2.add(addButton("C", command));

		frame.setVisible(true);
	}

	public static JButton addButton (String label, ActionListener command) {
		JButton button = new JButton(label);
		button.addActionListener(command);
		return button;
	}

	public static String calculate (String string) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		return se.eval(string).toString();
	}
}