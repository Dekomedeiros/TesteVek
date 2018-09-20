package testVek;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {
	
	private String pag;
	Object[] tipoPag = {"Débito", "Crédito", "Crédito/Parcelado", "Parcelado"};

	private JPanel contentPane;
	
	public void init() {
		setTitle("Teste Vek");
		setVisible(true);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal(){
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cBox = new JComboBox();
		cBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		cBox.setModel(new DefaultComboBoxModel(new String[] {"1318", "4409", "4628", "4430"}));
		cBox.setBounds(94, 81, 108, 32);
		cBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				if(cBox.getSelectedItem().equals("4409")) {
					 pag = (String) JOptionPane.showInputDialog(null, "Selecione a forma de pagamento", "Pagamento", JOptionPane.PLAIN_MESSAGE, null, tipoPag, null);                
				        JOptionPane.showMessageDialog(null, "Operação concluída", pag, JOptionPane.PLAIN_MESSAGE); 
				}else if(cBox.getSelectedItem().equals("4628")) {
					pag = (String) JOptionPane.showInputDialog(null, "Selecione a forma de pagamento", "Pagamento", JOptionPane.PLAIN_MESSAGE, null, tipoPag, null);
			       // Execucao.verificarPagamento(pag);
				}else if(cBox.getSelectedItem().equals("4430")) {
					JFormattedTextField amex = new JFormattedTextField();
					//Execucao.mascara(amex);
					
				
			}
			}
		});
		contentPane.add(cBox);
		
	}
}
