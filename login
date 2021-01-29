
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class Login extends JFrame implements ActionListener {

	JPanel panel, panel1, panel2;
	JLabel user_label , password_label, message;
	JTextField userName_text;
	JPasswordField password_text;
	JButton submit, cancel;
	
	public Login(){
		super("Login");
		setLayout(new GridLayout(3,1));
		
		panel = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, ""); 
		panel.setBorder(titledBorder);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		user_label = new JLabel("User Name:");
		userName_text = new JTextField("");
		panel.add(user_label);
		panel.add(userName_text);
		
		panel1 = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(border1, ""); 
		panel1.setBorder(titledBorder1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		password_label = new JLabel (" Password: ");
		password_text = new JPasswordField("");
		panel1.add(password_label);
		panel1.add(password_text);
		
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		submit = new JButton("Login");
		panel2.add(submit, BorderLayout.AFTER_LINE_ENDS);
		
		add(panel);
		add(panel1);
		add(panel2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		submit.addActionListener(this);
		setSize(350,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = userName_text.getText();
		String password = password_text.getText();
		if ((userName.equals("admin") ) && (password.equals("admin112002"))) {
			this.setVisible(false);
			new GiaoDien();
		} else {
			JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
			userName_text.setText("");
			password_text.setText("");
		}
	}
}
