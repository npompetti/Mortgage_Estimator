import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;


public class main {

	private JFrame frame;
	private JTextField incomeTF;
	private JTextField debtTF;
	private JTextField mortgageTF;
	
	
	double option18;
	double option36;
	int term;
	double rate;
	double downpay;
	double mortgage;
	double greaterOption;
	private JTextField TF18;
	private JTextField TF36;
	private JTextField bestOptionTF;
	private JTextField allowable_mortgage_TF;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMortgageEstimator = new JLabel("Mortgage Estimator");
		lblMortgageEstimator.setBounds(138, 6, 131, 16);
		frame.getContentPane().add(lblMortgageEstimator);
		
		JLabel incomeLBL = new JLabel("Total Gross Income");
		incomeLBL.setBounds(6, 45, 131, 16);
		frame.getContentPane().add(incomeLBL);
		
		JLabel debtLBL = new JLabel("Total Monthly Debt");
		debtLBL.setBounds(6, 89, 131, 16);
		frame.getContentPane().add(debtLBL);
		
		JLabel mortgageLBL = new JLabel("Mortgage Interest Rate");
		mortgageLBL.setBounds(6, 125, 149, 16);
		frame.getContentPane().add(mortgageLBL);
		
		JLabel lblTerm = new JLabel("Term (years)");
		lblTerm.setBounds(6, 161, 131, 16);
		frame.getContentPane().add(lblTerm);
		
		JLabel downpaymentLBL = new JLabel("Optional: Down Payment");
		downpaymentLBL.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		downpaymentLBL.setBounds(6, 208, 177, 16);
		frame.getContentPane().add(downpaymentLBL);
		
		incomeTF = new JTextField();
		incomeTF.setBounds(175, 39, 134, 28);
		frame.getContentPane().add(incomeTF);
		incomeTF.setColumns(10);
		
		debtTF = new JTextField();
		debtTF.setBounds(175, 83, 134, 28);
		frame.getContentPane().add(debtTF);
		debtTF.setColumns(10);
		
		mortgageTF = new JTextField();
		mortgageTF.setBounds(175, 119, 134, 28);
		frame.getContentPane().add(mortgageTF);
		mortgageTF.setColumns(10);
		
		JComboBox termCB = new JComboBox();
		termCB.setBounds(175, 157, 134, 27);
		frame.getContentPane().add(termCB);
		termCB.addItem(10);
		termCB.addItem(15);
		termCB.addItem(30);
		
		JFormattedTextField downpaymentTF = new JFormattedTextField();
		downpaymentTF.setText("0.00");
		downpaymentTF.setBounds(175, 202, 134, 28);
		frame.getContentPane().add(downpaymentTF);
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(474, 6, 46, 16);
		frame.getContentPane().add(lblResults);
		
		JLabel LBL18 = new JLabel("18% gross income");
		LBL18.setBounds(382, 45, 114, 16);
		frame.getContentPane().add(LBL18);
		
		JLabel LBL36 = new JLabel("36% (house pay. + debt)");
		LBL36.setBounds(382, 89, 167, 16);
		frame.getContentPane().add(LBL36);
		
		JLabel bestOptionLBL = new JLabel("Best Option");
		bestOptionLBL.setBounds(382, 125, 114, 16);
		frame.getContentPane().add(bestOptionLBL);
		
		TF18 = new JTextField();
		TF18.setBounds(536, 42, 117, 22);
		frame.getContentPane().add(TF18);
		TF18.setColumns(10);
		
		TF36 = new JTextField();
		TF36.setBounds(536, 83, 117, 28);
		frame.getContentPane().add(TF36);
		TF36.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(incomeTF.getText() == "" || debtTF.getText() == "" || mortgageTF.getText() == "" ){
				}
				else{
					option18 = (Double.parseDouble(incomeTF.getText())/12) * .18;
					option36 = ((Double.parseDouble(incomeTF.getText())/12) * 0.36) - (Double.parseDouble(debtTF.getText()));
					
					TF18.setText(Double.toString(option18));
					TF36.setText(Double.toString(option36));
					
					if (option18 > option36){
						greaterOption = option36;
					}
					else{
						greaterOption = option18;
					}
					
					bestOptionTF.setText(Double.toString(greaterOption));
					
					
					
					term = (int) termCB.getSelectedItem();
					
					if (Double.parseDouble(mortgageTF.getText()) < 1){
						rate = Double.parseDouble(mortgageTF.getText());
					}
					else if(Double.parseDouble(mortgageTF.getText()) > 0){
						rate = (Double.parseDouble(mortgageTF.getText()))/100;
					}
					
					
					if(downpaymentTF.getText() == "0.00"){
						mortgage = present_value.calc_pv(rate, greaterOption, term, 0);
						
						
					}
					
					else if (downpaymentTF.getText() != "" && downpaymentTF.getText() != " ") {
						downpay = Double.parseDouble(downpaymentTF.getText());
						mortgage = present_value.calc_pv(rate, greaterOption, term, downpay);
					}
					DecimalFormat format = new DecimalFormat("#0.00");
					String mortgage_frmtd = format.format(mortgage);
					allowable_mortgage_TF.setText(mortgage_frmtd);
					
					 
					
					
				}
			}
		});
		btnCalculate.setEnabled(true);
		btnCalculate.setBounds(152, 243, 117, 29);
		frame.getContentPane().add(btnCalculate);
		
		bestOptionTF = new JTextField();
		bestOptionTF.setBounds(536, 119, 117, 28);
		frame.getContentPane().add(bestOptionTF);
		bestOptionTF.setColumns(10);
		
		JLabel allowable_mortLBL = new JLabel("Allowable Mortgage");
		allowable_mortLBL.setBounds(382, 168, 138, 16);
		frame.getContentPane().add(allowable_mortLBL);
		
		allowable_mortgage_TF = new JTextField();
		allowable_mortgage_TF.setBounds(536, 155, 117, 28);
		frame.getContentPane().add(allowable_mortgage_TF);
		allowable_mortgage_TF.setColumns(10);
		
		
		
		
		
		
		
	}
}
