package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class ViewWindow {
	


	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("����ͼ������");
		f.setLocation(300, 300);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLayout(new GridLayout(0,1));
		
		//��������ͼ��ISBN����
		Panel panelISBN = new Panel();
		final TextField textISBN = new TextField(10);
		Button butt = new Button("����");
		panelISBN.add(new Label("������ͼ��ISBN:"));
		panelISBN.add(textISBN);
		panelISBN.add(butt);
		f.add(panelISBN);
		
		//
		Panel panelName = new Panel();
		final TextField bookName = new TextField(10);
		bookName.setEnabled(false);
		panelName.add(new Label("ͼ����:"));
		panelName.add(bookName);
//		f.add(new Label("ͼ����:"));
		f.add(panelName);
		//
		final TextField authorName = new TextField(10);
		f.add(new Label("ͼ������:"));
		f.add(authorName);
		//
		final TextField bookIsbn10 = new TextField(10);
		f.add(new Label("ͼ��ISBN10��:"));
		f.add(bookIsbn10);
		//
		final TextField bookIsbn13 = new TextField(10);
		f.add(new Label("ͼ��ISBN13��:"));
		f.add(bookIsbn13);
		//
		final TextField bookPage = new TextField(10);
		f.add(new Label("ͼ��ҳ��:"));
		f.add(bookPage);
		//
		final TextField bookPrice = new TextField(10);
		f.add(new Label("ͼ��۸�:"));
		f.add(bookPrice);
		//
		final TextField bookBinding = new TextField(10);
		f.add(new Label("ͼ��װ����ʽ:"));
		f.add(bookBinding);
		//
		final TextField publisher = new TextField(10);
		f.add(new Label("ͼ�������:"));
		f.add(publisher);
		//
		final TextField pubdate = new TextField(10);
		f.add(new Label("ͼ���������:"));
		f.add(pubdate);
		//
		final TextField bookDetail = new TextField(10);
		f.add(new Label("ͼ�����ݸ�Ҫ:"));
		f.add(bookDetail);
		//���ð�ť����
		butt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Books book;
				ISBN isbnTest = new ISBN();
				String isbn = textISBN.getText();//��ȡ�����ͼ��ISBN��
				String bookjson;
				try {
					bookjson = isbnTest.fetchBookInfoByXML(isbn);
					JSONObject jsonobj=isbnTest.stringToJson(bookjson);				    
				    book = (Books)isbnTest.setBookData();
				    bookName.setText(book.getTitle());
				    authorName.setText(book.getAuthor());
				    bookIsbn10.setText(book.getIsbn10());
				    bookIsbn13.setText(book.getIsbn13());
				    bookBinding.setText(book.getBinding());
				    bookDetail.setText(book.getSummary());
				    bookPage.setText(book.getPage());
				    bookPrice.setText(book.getPrice());
				    publisher.setText(book.getPublisher());
				    pubdate.setText(book.getPubdate());
				    
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent args) {
			   System.exit(0);
			}
		});
		//f.setResizable(false);
	}

}
