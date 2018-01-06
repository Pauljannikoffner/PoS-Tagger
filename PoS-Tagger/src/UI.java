import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI {

	private JFrame frame;
	private JPanel panel;
	private JTextField textField;
	private JButton button;

	public UI() {
		frame = new JFrame("PoS-Tagger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.WHITE);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.WHITE);

		textField = new JTextField("Wörter hier eingeben");
		panel.add(textField);

		button = new JButton("Huhu");
		panel.add(button);

		frame.add(panel, BorderLayout.PAGE_START);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
