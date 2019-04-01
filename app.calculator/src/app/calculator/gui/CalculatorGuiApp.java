package app.calculator.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.calculator.model.CalculatorModel;

public class CalculatorGuiApp {

	public static void main(String[] args) {
		CalculatorGuiApp gui = new CalculatorGuiApp();
		gui.createAndShowGui();
	}

	private CalculatorModel calculatorModel = new CalculatorModel();
	private JFrame fr = new JFrame("my calculator");
	private JTextField tfVal;
	private JLabel lbRes;

	private void createAndShowGui() {
		Font font = new Font(null, Font.BOLD, 18);
		// set the main window
		fr.setLayout(null);
		fr.setBounds(100, 100, 325, 250);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tfVal = new JTextField();
		JButton btAdd = new JButton("+");
		JButton btSub = new JButton("-");
		JButton btMul = new JButton("x");
		JButton btDiv = new JButton(":");
		JButton btReset = new JButton("Reset");
		lbRes = new JLabel("0.0");
		// set the layout
		tfVal.setBounds(20, 20, 200, 25);
		btAdd.setBounds(20, 70, 45, 25);
		btSub.setBounds(70, 70, 45, 25);
		btMul.setBounds(120, 70, 45, 25);
		btDiv.setBounds(170, 70, 45, 25);
		lbRes.setBounds(20, 120, 125, 25);
		btReset.setBounds(20, 170, 125, 25);
		// set font
		tfVal.setFont(font);
		btAdd.setFont(font);
		btSub.setFont(font);
		btMul.setFont(font);
		btDiv.setFont(font);
		lbRes.setFont(font);
		btReset.setFont(font);
		// add components to main window
		fr.add(tfVal);
		fr.add(btAdd);
		fr.add(btSub);
		fr.add(btMul);
		fr.add(btDiv);
		fr.add(lbRes);
		fr.add(btReset);
		// connect view to model
		CalculatorListener listener = new CalculatorListener();
		btAdd.addActionListener(listener);
		btSub.addActionListener(listener);
		btMul.addActionListener(listener);
		btDiv.addActionListener(listener);
		btReset.addActionListener(listener);

		fr.setVisible(true);
	}

	class CalculatorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getText();
			if (command.equals("Reset")) {
				calculatorModel.reset();
				tfVal.setText(null);
			} else {
				try {

					double a = Double.parseDouble(tfVal.getText());
					switch (command) {
					case "+":
						calculatorModel.add(a);
						break;
					case "-":
						calculatorModel.sub(a);
						break;
					case "x":
						calculatorModel.mul(a);
						break;
					case ":":
						calculatorModel.div(a);
						break;
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(fr, ex.toString());
				}
			}

			double res = calculatorModel.getResult();
			lbRes.setText(String.valueOf(res));
		}

	}
}
