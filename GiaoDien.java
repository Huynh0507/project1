import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame implements ActionListener  {
	
	JFrame frame;
	DefaultTableModel dm;
	JTable tbl;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5,
			   jtf6, jtf7, jtf8, jtf9, jtfSearch; 
	DBConnection dbcon;
	
	public GiaoDien() {
		super("Chương trình quản lý đề tài tốt nghiệp cuối khóa");
		
		//Tạo 1 MenuBar 
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);
		JMenu mnuFile=new JMenu("File");		menubar.add(mnuFile);
		JMenu mnuEdit=new JMenu("Show");		menubar.add(mnuEdit);
		
		JMenuItem mnuFileExit=new JMenuItem("Exit");		mnuFile.add(mnuFileExit);
		JMenuItem mnuFileSave=new JMenuItem("Save");		mnuFile.add(mnuFileSave);
		
		mnuFile.addSeparator();
		
		mnuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Exit = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Exit?",JOptionPane.YES_NO_OPTION);
				if(Exit == JOptionPane.YES_OPTION){
					System.exit(0);
					System.out.println("EXIT SUCCESSFUL");
				}
			}
		});
		
		mnuFileSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Save = JOptionPane.showConfirmDialog(frame,  "Do you want to save?", "Save?", JOptionPane.YES_NO_OPTION);
				if (Save == JOptionPane.YES_OPTION) {
					
				}
			}
		});
		
		//Tạo 1 panel hiển thị thông tin người quản lý
		
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelInf = new JPanel();
		Border borderInf = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorderInf = BorderFactory.createTitledBorder(borderInf, ""); 
		panelInf.setBorder(titledBorderInf);
		panel.add(panelInf, BorderLayout.CENTER);
		panelInf.setLayout(new GridLayout(20,1));
		
		JLabel hoten = new JLabel("Họ và tên: Nguyễn Châu Quy Phượng");			panelInf.add(hoten);
		JLabel ngsinh = new JLabel("Ngày sinh: 16/12/2002");					panelInf.add(ngsinh);
		JLabel qquan = new JLabel("Quê quán: tp. Đồng Hới, tỉnh Quảng Bình");	panelInf.add(qquan);
		JLabel msv = new JLabel("Mã Sinh Viên: 20IT064");						panelInf.add(msv);
		JLabel lop = new JLabel("Mã Lớp: 20IT2");								panelInf.add(lop);
		JLabel khoa = new JLabel("Khoa: Khoa học máy tính");					panelInf.add(khoa);
		JLabel nganh = new JLabel("Ngành: Công nghệ thông tin");				panelInf.add(nganh);
		
		
		//Tạo 1 panel hiển thi thông tin cần quản lý
		JPanel panel1 = new JPanel();
		Border bor = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBor = BorderFactory.createTitledBorder(bor, "Thông tin chung"); 
		panel1.setBorder(titledBor);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		//panel chứa thông tin sinh viên
		JPanel p1 = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(border1, "Thông tin sinh viên");
		p1.setBorder(titledBorder1);
		panel1.add(p1, BorderLayout.NORTH);	
		p1.setLayout(new BorderLayout());
		
		
		JPanel p11 = new JPanel();
		Border border11 = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder11 = BorderFactory.createTitledBorder(border11, ""); 
		p11.setBorder(titledBorder11);
		p1.add(p11, BorderLayout.WEST);
		p11.setLayout(new GridLayout(5,1));
		
		JLabel jlb1 = new JLabel("Họ và tên");		p11.add(jlb1);
		JLabel jlb2 = new JLabel("Mã SV");			p11.add(jlb2);
		JLabel jlb3 = new JLabel("Mã Lớp");			p11.add(jlb3);
		JLabel jlb4 = new JLabel("Khoa");			p11.add(jlb4);
		JLabel jlb5 = new JLabel("Ngành");			p11.add(jlb5);
		
		
		JPanel p12 = new JPanel();
		Border border12 = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder12 = BorderFactory.createTitledBorder(border12, ""); 
		p12.setBorder(titledBorder12);
		p1.add(p12, BorderLayout.CENTER);
		p12.setLayout(new GridLayout(5,1));
		
		jtf1 = new JTextField(20);		p12.add(jtf1);
		jtf2 = new JTextField(20);		p12.add(jtf2);
		jtf3 = new JTextField(20);		p12.add(jtf3);
		jtf4 = new JTextField(20);		p12.add(jtf4);
		jtf5 = new JTextField(20);		p12.add(jtf5);
		
		
		//panel chứa thông tin đề tài của sinh viên
		JPanel p2 = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(border2, "Thông tin đề tài"); 
		p2.setBorder(titledBorder2);
		panel1.add(p2, BorderLayout.CENTER);
		p2.setLayout(new BorderLayout());
		
		
		JPanel p21 = new JPanel();
		Border border21 = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder21 = BorderFactory.createTitledBorder(border21, ""); 
		p21.setBorder(titledBorder21);
		p2.add(p21, BorderLayout.WEST);
		p21.setLayout(new GridLayout(4,1));
		
		JLabel jlb6 = new JLabel("Tên ĐT");			p21.add(jlb6);
		JLabel jlb7 = new JLabel("Mã Số ĐT");		p21.add(jlb7);
		JLabel jlb8 = new JLabel("TGTH");			p21.add(jlb8);
		JLabel jlb9 = new JLabel("GVHD");			p21.add(jlb9);
		
		
		JPanel p22 = new JPanel();
		Border border22 = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder22 = BorderFactory.createTitledBorder(border22, ""); 
		p22.setBorder(titledBorder22);
		p2.add(p22, BorderLayout.CENTER);
		p22.setLayout(new GridLayout(4,1));
		
		jtf6 = new JTextField(20);		p22.add(jtf6);
		jtf7 = new JTextField(20);		p22.add(jtf7);
		jtf8 = new JTextField(20);		p22.add(jtf8);
		jtf9 = new JTextField(20);		p22.add(jtf9);
		
		
		//panel chứa thanh công cụ
		JPanel p3 = new JPanel();
		Border border3 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorder3 = BorderFactory.createTitledBorder(border3, "Công cụ"); 
		p3.setBorder(titledBorder3);
		panel1.add(p3, BorderLayout.SOUTH);
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
				
		JButton Add = new JButton("Add");					p3.add(Add);
		JButton Reset = new JButton("Reset"); 				p3.add(Reset);
		JButton Delete = new JButton("Delete");				p3.add(Delete);
		
		Add.addActionListener(this);
		Reset.addActionListener(this);
		Delete.addActionListener(this);
		
		JPanel p31 = new JPanel();
		Border border31 = BorderFactory.createLineBorder(Color.GREEN);
		TitledBorder titledBorder31 = BorderFactory.createTitledBorder(border31, "Tìm kiếm (Sử dụng Mã Sinh Viên để tìm kiếm)"); 
		p31.setBorder(titledBorder31);
		p3.add(p31, BorderLayout.NORTH);
		p31.setLayout(new BoxLayout(p31, BoxLayout.X_AXIS));
		
		JLabel jlbSearch = new JLabel("Search");			p31.add(jlbSearch);
		jtfSearch = new JTextField(20);						p31.add(jtfSearch);
		JButton Search= new JButton("Search");	    		p31.add(Search);
		Search.addActionListener(this);
		
		JPanel p4 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder4 = BorderFactory.createTitledBorder(border4, "Danh sách sinh viên"); 
		p4.setBorder(titledBorder4);
		panel1.add(p4, BorderLayout.NORTH);
		p4.setLayout(new CardLayout());
		
		//tạo bảng
		dm = new DefaultTableModel();
		dm.addColumn("Họ tên");
		dm.addColumn("Mã SV");
		dm.addColumn("Mã Lớp");
		dm.addColumn("Khoa");
		dm.addColumn("Ngành");
		dm.addColumn("Tên ĐT");
		dm.addColumn("Mã Số ĐT");
		dm.addColumn("TGTH");
		dm.addColumn("GVHD");
		
		tbl = new JTable(dm);
		
		dbcon = new DBConnection();
		
		
		try {
			ResultSet rs = dbcon.getStmt().executeQuery("select * from SinhVien inner join DeTai on SinhVien.MaSV=DeTai.MaSV ");
			
			//them du lieu vao csdl cho cac bang
			while (rs.next()) {
				
				dm.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		JScrollPane sc = new JScrollPane(tbl);
		p4.add(sc);
		panel1.add(p4);
		
		add(panel1);
		
		
		JTabbedPane myTabled = new JTabbedPane();
		
		myTabled.add(panel,"Thông tin người quản lý");
	 	
		myTabled.add(panel1, "Thông tin quản lý đề tài tốt nghiệp của sinh viên");
		Container con= getContentPane();
		con.add(myTabled);
		
		
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameButton = e.getActionCommand();//e.getSource()
		if(nameButton.equals("Add")){
			System.out.println("Click add");
			
			dm.addRow(new String []{jtf1.getText(),jtf2.getText(), jtf3.getText(), jtf4.getText(), jtf5.getText(),
									jtf6.getText(),jtf7.getText(), jtf8.getText(), jtf9.getText()});
			
			try {	
				dbcon.getStmt()
					 .execute("INSERT INTO SinhVien(HoTen,MaSV,MaLop,Khoa,Nganh) VALUES (N'"
							 				+ jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText()
							 				+ "',N'" + jtf4.getText() + "',N'" +jtf5.getText() + "');");
				dbcon.getStmt()
					 .execute("INSERT INTO DeTai(MaSV,TenDT,MaSoDT,TGTH,GVHD) VALUES ('"
							 				+ jtf2.getText() + "',N'" + jtf6.getText() + "','" + jtf7.getText()
							 				+ "','" + jtf8.getText() + "',N'" + jtf9.getText() + "');");			
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(nameButton.equals("Reset")) {
			System.out.println("Click Reset");
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
			jtf8.setText("");
			jtf9.setText("");
		}
		
		if(nameButton.equals("Delete")) {
			int a = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Delete?", JOptionPane.YES_NO_OPTION);
			if(a != JOptionPane.YES_OPTION) {
				int i = tbl.getSelectedRow();
				try {
					dbcon.getStmt()
						 .execute("DELETE TOP ("+ i +") FROM SinhVien");
					dbcon.getStmt()
						 .execute("DELETE TOP ("+ i +") FROM DeTai");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
}
