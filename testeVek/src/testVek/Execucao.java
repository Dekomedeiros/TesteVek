package testVek;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Execucao {

	static int opc;
	static int valor;
	static int valorMin; 
	static int valorMax; 
	public static void verificarPagamento(String pag) throws ParseException {
		JFormattedTextField parcela = new JFormattedTextField();
		JFormattedTextField parcela6x = new JFormattedTextField();
		JFormattedTextField parcela12x = new JFormattedTextField();
		
		if(pag.equals("Débito")) {
			JOptionPane.showMessageDialog(null, "Pagamento Realizado", null, JOptionPane.INFORMATION_MESSAGE);
		}else 
			if(pag.equals("Crédito")) {
				
				opc = 1; 
				mascara(parcela);
				if(parcela.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
				}else {
					Object[] local = {"Taxa de Crédito", parcela};
					
					JOptionPane.showMessageDialog(null, local, pag, JOptionPane.INFORMATION_MESSAGE);
					String parcelamento = parcela.getText();
					parcelamento = parcelamento.replace("", "");
					checkValorVazio(parcelamento, pag);
				}	
			}else {
				opc = 2;
				Object[] local = {"Preencha os campos. \n" + "Taxa de Parcelamento em 6x", parcela6x,
								"\n Taxa de Parcelamento em 12x", parcela12x};
				
				JOptionPane.showMessageDialog(null, local, pag, JOptionPane.INFORMATION_MESSAGE);
				String parcelamento6x = parcela6x.getText();
				String parcelamento12x = parcela12x.getText();
				parcelamento6x = parcelamento6x.replace("", "");
				parcelamento12x = parcelamento12x.replace("", "");
				checkParcelaVazia(parcelamento6x, parcelamento12x, pag);
				}
		}
	
	
	
	public static void mascara(JFormattedTextField txtfield) throws ParseException {
		MaskFormatter numero = new MaskFormatter("**");
		numero.setValidCharacters("0123456789");
		numero.install(txtfield);
		txtfield.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				txtfield.setCaretPosition(0);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtfield.setCaretPosition(0);
				
			}
		});
	}
	
	public static void checkValorVazio(String valorVazio, String pag) {
		if(valorVazio.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo Obrigatório, favor preencher", "Aviso", JOptionPane.WARNING_MESSAGE);
		}else {
			valor = Integer.parseInt(valorVazio);
			checkValor(pag);
			
		}
	}
	
	public static void checkValor(String pag) {
		if(opc == 3) {
			if(valor >=valorMin && valor <=valorMax) {
				JOptionPane.showMessageDialog(null, "Pagamento Realizado", null, JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Taxa informada encontra-se fora dos valores aceitáveis", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}else if(valor > valorMax) {
			JOptionPane.showMessageDialog(null, "Pagamento Realizado", null, JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Taxa informada encontra-se fora dos valores aceitáveis", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void checkParcelaVazia(String parcelamento6x, String parcelamento12x, String pag) {
		if(parcelamento6x.isEmpty()) {
			valor = Integer.parseInt(parcelamento6x);
			checkValor(pag);
			parcelamento12x = "";
		}else if(parcelamento12x.isEmpty()) {
			if(parcelamento12x.equalsIgnoreCase("N/A")) {
				JOptionPane.showMessageDialog(null, "Pagamento Concluído", null, JOptionPane.INFORMATION_MESSAGE);
			}
			valor = Integer.parseInt(parcelamento12x);
			checkValor(pag);
		}
	}
}
