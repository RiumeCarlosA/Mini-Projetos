package avaliacaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Janela1 {
	
	public void criarJanela() {
		Crud crud = new Crud();
		
		JFrame frame = new JFrame();
		frame.setTitle("Avalidaor de professor");
		frame.setLocation(400, 200);
		frame.setSize(370,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Professor: ");
		lb1.setBounds(30, 20, 100, 20);
		lb1.setFont(new Font("Dialog",5 , 13));
		frame.add(lb1);
		
		JComboBox<String> cb1 = new JComboBox<String>();
		try {
			List<Professor> professores = crud.mostrarProfessores();
			for(Professor i : professores) {
				cb1.addItem(i.getNome());
			}
		} catch (SQLException e) { JOptionPane.showMessageDialog(null, e.getMessage());}
		cb1.setBounds(180, 20, 150, 20);
		cb1.setFont(new Font("Dialog",5 , 12));
		frame.add(cb1);
		
		JLabel lb2 = new JLabel("Comentario: ");
		lb2.setBounds(30, 60, 100, 20);
		lb2.setFont(new Font("Dialog",5 , 13));
		frame.add(lb2);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(30, 90, 300, 140);
		ta1.setFont(new Font("Dialog",5 , 12));
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
		ta1.setBorder(BorderFactory.createLineBorder(Color.gray));
		frame.add(ta1);
		
		JButton bt1 = new JButton("Adicionar");
		bt1.setFont(new Font("Dialog",5 , 12));
		bt1.setBounds(30, 260, 100, 20);
		bt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(ta1.getText().length() <= 200) {
					try {
						String guardar = cb1.getSelectedItem() + "";
						crud.inserirComentario(guardar , ta1.getText());
						JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}	
				}else {JOptionPane.showMessageDialog(null, "Comentário não pode exceder 200 caracteres!!");}
			}
		});
		frame.add(bt1);
		
		JButton bt3 = new JButton("Visualizar");
		bt3.setFont(new Font("Dialog",5 , 12));
		bt3.setBounds(230, 260, 100, 20);
		bt3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				Janela2 janela2 = new Janela2();
				janela2.criarJanela2();
			}
		});
		frame.add(bt3);
		
		
		frame.setVisible(true);
	}
	
}
