package basket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Start.Start_image;
import Start.Start_image2;
import Start.Start_image3;
import Start.Thread_M;
import run.Products;

public class SmallBasket extends Panel {
	int total1 = 0;
	TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY); // �ֹ������� ��� textarea
	Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 16);

	Panel cart1;

	public SmallBasket(Frame f, List<Products> list) {

		Font font = new Font("", Font.BOLD, 20);
		JLabel l1 = new JLabel("                                          �ֹ����� ");
		Button payment = new Button("�� ��");
		Button cancel = new Button("�� ��");
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		TextArea ta2 = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);

		ta.setBounds(0, 625, 600, 150);
		ta2.setBounds(520, 755, 200, 20);
		f.add(ta2);

		l1.setBounds(0, 595, 600, 30);
		payment.setBounds(30, 785, 265, 50);
		cancel.setBounds(310, 785, 265, 50);

		ta.setEditable(false);

		l1.setFont(font);
		l1.setOpaque(true);

		ta.setBackground(Color.white);

		l1.setBackground(Color.black);
		l1.setForeground(Color.white);

		for (int i = 0; i < list.size(); i++) {
			total1 += list.get(i).getPrice() * list.get(i).getCnt();
		} // �� ����

		ta.setText("\t               ��ǰ��      \t\t     �ܰ�\t\t             ����\t\t  �հ�\n");
		ta.append("=================================================================================================");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().length() < 4) {

				ta.append("\t               " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");

			} else if (list.get(i).getName().length() == 4) {

				ta.append("\t             " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");

			} else if (list.get(i).getName().length() == 5) {

				ta.append("\t           " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");

			} else if (list.get(i).getName().length() == 6) {

				ta.append("\t          " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");

			} else if (list.get(i).getName().length() == 7) {

				ta.append("\t          " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");

			} else {

				ta.append("\t          " + list.get(i).getName() + "\t                 " + list.get(i).getPrice()
						+ "\t\t\t   " + list.get(i).getCnt() + "\t\t" + list.get(i).getPrice() * list.get(i).getCnt()
						+ "��" + "\n");
			}
			ta.append("-------------------------------------------------------------------------------------------------");
		}

		ta2.setText("" + total1 + "��");

		// ����â �Ѿ�� ��ư
		payment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.removeAll();
				new Payment(f, list);
				JOptionPane.showMessageDialog(f, "�� �ݾ��� : " + total1 + "�� �Դϴ�.");
			}
		});

		// �ֹ� ��ü ����ϴ� ��ư
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.removeAll();
				Start_image s1 = new Start_image(f, list);
				s1.stop = true;
				Start_image2 s2 = new Start_image2(f, list);
				s2.stop = true;
				Start_image3 s3 = new Start_image3(f, list);
				s3.stop = true;

				new Thread_M(f, list);
			}
		});
		f.add(payment);
		f.add(cancel);
		f.add(ta);

		f.add(l1);

		f.setVisible(true);
	}// ������

}
