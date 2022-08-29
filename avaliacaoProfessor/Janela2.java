package avaliacaoProfessor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sistemaDeCadastro.Usuario;

public class Janela2 {
	@SuppressWarnings("unchecked")
	public void criarJanela2() {
		Crud crud = new Crud();
		JFrame frame = new JFrame();
		frame.setLocation(800, 180);
		frame.setTitle("Avalidaor de professor");
		frame.setSize(400,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Professor: ");
		lb1.setBounds(30, 20, 100, 20);
		lb1.setFont(new Font("Dialog",5 , 12));
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
		
		JLabel lb3 = new JLabel("Professor");
		lb3.setBounds(30, 100, 120, 20);
		lb3.setBorder(BorderFactory.createLineBorder(Color.gray));
		lb3.setFont(new Font("Dialog",5 , 12));
		frame.add(lb3);
		
		@SuppressWarnings("rawtypes")
		DefaultListModel model1 = new DefaultListModel();
		JList<Comentario> lista1 = new JList<Comentario>(model1);
		lista1.setBorder(BorderFactory.createLineBorder(Color.gray));
		lista1.setBounds(30, 120, 120, 150);
		lista1.setFont(new Font("Dialog",5 , 12));
		lista1.setModel(model1);
		frame.add(lista1);
		
		JLabel lb2 = new JLabel("Comentário");
		lb2.setBounds(150, 100, 180, 20);
		lb2.setBorder(BorderFactory.createLineBorder(Color.gray));
		lb2.setFont(new Font("Dialog",5 , 12));
		frame.add(lb2);
		
		@SuppressWarnings("rawtypes")
		DefaultListModel model2 = new DefaultListModel();
		JList<Comentario> lista2 = new JList<Comentario>(model2);
		lista2.setBorder(BorderFactory.createLineBorder(Color.gray));
		lista2.setBounds(150, 120, 180, 150);
		lista2.setFont(new Font("Dialog",5 , 12));
		lista2.setModel(model2);
		lista2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(lista2.getSelectedValue() != null) {
					int i = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir este comentário?");        
					if(i == 0) {
						try {
							String comentario = String.valueOf(lista2.getSelectedValue());
							crud.removerComentario(comentario);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}	
				}
			}
		});
		frame.add(lista2);
		
		JButton bt1 = new JButton("Mostrar");
		bt1.setFont(new Font("Dialog",5 , 12));
		bt1.setBounds(130, 60, 100, 20);
		bt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					model1.clear();
					model2.clear();
					lista1.setModel(model1);
					lista1.setModel(model2);
					String guardar = cb1.getSelectedItem() + "";
					List<Comentario> comentario = crud.mostrarComentario(guardar);
					for(Comentario i : comentario) {
						model1.addElement(guardar);
						model2.addElement(i.getConteudo());
						lista1.setModel(model1);
						lista2.setModel(model2);
					}
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frame.add(bt1);
		
		frame.setVisible(true);
	}
}
