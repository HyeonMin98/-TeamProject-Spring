package basket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Menu.Coffe1;
import run.Products;

public class Payment {

	public Payment(Frame f, List<Products> list) {

		Font font = new Font("���� ���", Font.BOLD, 25);

		
		
		JLabel select = new JLabel("���� ����� ������ �ּ���");
		
		select.setBounds(170,50, 400,100);
		select.setFont(font);
		f.add(select);
		
		
		RoundedButton card = new RoundedButton("�ſ� ī��");
		card.setBounds(50, 150, 500, 150);
		card.setBackground(Color.RED);
		card.setFont(font);

		RoundedButton cash = new RoundedButton("���� ����");
		cash.setBounds(50, 320, 500, 150);
		cash.setBackground(Color.RED);
		cash.setFont(font);
		
		RoundedButton back = new RoundedButton("���ư���");
		back.setBounds(500,750,100,100);

		f.add(card);
		f.add(cash);
		f.add(back);

		card.setForeground(Color.white);
		cash.setForeground(Color.white);

		f.setVisible(true);
		f.setResizable(false);
		
		card.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane thanks = new JOptionPane();
				thanks.showMessageDialog(f,"ī�带 �־��ּ���");
			}
			
		});
		cash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane thanks = new JOptionPane();
				thanks.showMessageDialog(f,"������ �־��ּ���");
			}
			
		});
		
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.removeAll();
				new Coffe1(f, (java.util.List) list);

			}
		});
			


	}

}
