import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/* 
    Design an application for a pizzeria (Pizzeria.java).
    The user makes pizza order choices from list boxes, and the application displays the price.

    The user can choose a pizza size of small ($7), medium ($9), large ($11), or extra large ($14),
    and one of any number of toppings.

    There is no additional charge for cheese, but any other topping adds $1 to the base price.
    Offer at least five different topping choices.
*/

public class Pizzeria extends JFrame implements ActionListener {
	
	// Variables
	private String[] pizzaSize = {"Small", "Medium", "Large", "Extra Large"},
					 toppingChoices = {"Bacon", "Black Olives", "Green Olives", "Green Peppers", "Ground Beef", "Ham", "Hot Peppers",
									  "Jalapeno Peppers", "Mild Pepperoni", "Mushrooms", "Onions", "Pepperoni", "Pineapple", "Salami",
									  "Tomato", "Extra Cheese"};
	private String selected;
	private double totalPrice;
	
	// Fonts
	private Font lblFont = new Font("Cambria", Font.BOLD, 18);
	private Font btnFont = new Font("Cambria", Font.BOLD, 16);
	private Font listFont = new Font("Cambria", Font.BOLD, 14);
	
	// Lists
	private DefaultListModel listModel1 = new DefaultListModel(),
							 listModel2 = new DefaultListModel(),
							 listModel3 = new DefaultListModel();
	
	private JList list1 = new JList(listModel1), 
				  list2 = new JList(listModel2),
				  list3 = new JList(listModel3);
	
	// Labels
	private JLabel lbl_logo = new JLabel(),
				   lbl_price = new JLabel(),
				   lbl_toppings = new JLabel(),
				   lbl_size = new JLabel(),
				   lbl_selection = new JLabel();
	
	// Panels
	private JPanel pnl_north = new JPanel(),
				   pnl_south = new JPanel(),
				   pnl_center = new JPanel(),
				   pnl_logo = new JPanel(),
				   pnl_headings = new JPanel(),
				   pnl_price = new JPanel(),
				   pnl_buttons = new JPanel();
	
	// Buttons
	private JButton btn_addSize = new JButton("Add Size"),
					btn_addTopping = new JButton("Add Topping"),
					btn_remove = new JButton("Remove Item"),
					btn_clear = new JButton("Clear"),
					btn_submit = new JButton("Submit");
	
	// Images
	private ImageIcon icon = new ImageIcon("pizza.png"),
					  logo = new ImageIcon("andresLogo.png");
	
	// Container
	private Container content = getContentPane();
	

	// Display Content
	public Pizzeria() {
		this.setTitle("Andre's Pizza");
		this.setSize(550,750);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		
		content.setBackground(Color.gray);
		content.setLayout(new BorderLayout());
	    content.add(BorderLayout.NORTH,pnl_north);
	    content.add(BorderLayout.SOUTH,pnl_south);
	    content.add(BorderLayout.CENTER,pnl_center);
		
		
	    // Fills the size list
		fillSizeList();
		
		
		// Fills the topping list
		fillToppingsList();
	    
		
	    // JFrame North Panel
	    lbl_logo.setIcon(logo);
	    pnl_north.setLayout(new BorderLayout());
	    pnl_north.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, new Color(0x861230)));
	    pnl_north.add(BorderLayout.NORTH,pnl_logo);
	    pnl_north.add(BorderLayout.SOUTH,pnl_headings);
	   
	    lbl_size.setText("Pizza Size");
	    lbl_toppings.setText("Pizza Toppings");
	    lbl_selection.setText("Current Selections");
	    
	    lbl_size.setFont(lblFont);
	    lbl_toppings.setFont(lblFont);
	    lbl_selection.setFont(lblFont);
	    
	    pnl_logo.setBackground(new Color(0xd6c8ae));
	    pnl_logo.add(lbl_logo);
	    
	    pnl_headings.add(lbl_size);
	    lbl_size.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    pnl_headings.add(lbl_toppings);
	    lbl_toppings.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	    pnl_headings.add(lbl_selection);
	    lbl_selection.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
	    pnl_headings.setLayout(new GridLayout());
	    pnl_headings.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0x40635f)));
	    pnl_headings.setBackground(new Color(0xd6c8ae));	    
		
	    // JFrame South Panel
	    pnl_south.setLayout(new BorderLayout());
	    pnl_south.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, new Color(0x861230)));
	    pnl_south.add(BorderLayout.NORTH,pnl_price);
	    pnl_south.add(BorderLayout.SOUTH,pnl_buttons);
	    
	    pnl_price.setBackground(new Color(0xd6c8ae));
	    pnl_price.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, new Color(0x40635f)));
	    pnl_price.add(lbl_price);
	    lbl_price.setFont(lblFont);
	    lbl_price.setText("Total Price: $" + String.format("%.2f", totalPrice));
	    
	    pnl_buttons.setBackground(new Color(0xd6c8ae));
	    
	    pnl_buttons.add(btn_addSize);
	    btn_addSize.setFont(btnFont);
		btn_addSize.addActionListener (this);
		
		pnl_buttons.add(btn_addTopping);
		btn_addTopping.setFont(btnFont);
		btn_addTopping.addActionListener (this);
		
		pnl_buttons.add(btn_remove);
		btn_remove.setFont(btnFont);
		btn_remove.addActionListener (this);
		
		pnl_buttons.add(btn_clear);
		btn_clear.setFont(btnFont);
		btn_clear.addActionListener (this);
		
		pnl_buttons.add(btn_submit);
		btn_submit.setFont(btnFont);
		btn_submit.addActionListener (this);
	    
	    // JFrame Center Panel
	    pnl_center.setLayout(new GridLayout());
	    pnl_center.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x861230)));
	    pnl_center.add(list1);
	    list1.setFont(listFont);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));
		pnl_center.add(list2);
		list2.setFont(listFont);
		list2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		pnl_center.add(list3);
		list3.setFont(listFont);
		list3.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 20));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Populates Size List
	public void fillSizeList() {
		for (int i=0; i<pizzaSize.length; i++) {		
			listModel1.add(i,  pizzaSize[i]);	
		}
	}	
	
	// Populates Topping List
	public void fillToppingsList() {
		for (int i=0; i<toppingChoices.length; i++) {
			listModel2.add(i,  toppingChoices[i]);
		}
	}
	
	// Button Action Listener Events
	public void actionPerformed(ActionEvent evt) {
		
		// If Add Size button is clicked
		if (evt.getSource() == btn_addSize) {
			// add the selected size to the current selections list and compare the selected value to determine the price to charge
			listModel3.addElement(list1.getSelectedValue());
			selected = (String) list1.getSelectedValue();
			switch (selected) {
				case "Small": totalPrice = totalPrice + 7.00; break;
				case "Medium": totalPrice = totalPrice + 9.00; break;
				case "Large": totalPrice = totalPrice + 11.00; break;
				case "Extra Large": totalPrice = totalPrice + 14.00; break;
				default: System.out.println("No selection made.  Please select a size.");
			}
			// disable Add Size button to allow only one selection
			btn_addSize.setEnabled(false);
			// display updated price
			lbl_price.setText("Total Price: $" + String.format("%.2f", totalPrice));			
		}
		
		// If Add Topping button is clicked
		if (evt.getSource() == btn_addTopping) {
			// add the selected size to the current selections list and compare the selected value to determine the price to charge
			listModel3.addElement(list2.getSelectedValue());
			selected = (String) list2.getSelectedValue();
			switch (selected) {
				case "Extra Cheese": totalPrice = totalPrice + 0.00; break;
				default: totalPrice = totalPrice + 1.00;
			}
			// display updated price
			lbl_price.setText("Total Price: $" + String.format("%.2f", totalPrice));
		}
		
		// If Remove Item button is clicked
		if (evt.getSource() == btn_remove) {
			// store and compare the selected value to determine what price to subtract, then remove the selection from the list
			selected = (String) list3.getSelectedValue();
			listModel3.removeElement(list3.getSelectedValue());
			switch (selected) {
				case "Small": totalPrice = totalPrice - 7.00;
				  			  btn_addSize.setEnabled(true); break;
				case "Medium": totalPrice = totalPrice - 9.00; 
							   btn_addSize.setEnabled(true); break;
				case "Large": totalPrice = totalPrice - 11.00; 
							  btn_addSize.setEnabled(true); break;
				case "Extra Large": totalPrice = totalPrice - 14.00;
							        btn_addSize.setEnabled(true); break;
				case "Extra Cheese": totalPrice = totalPrice - 0.00; break;
				default: totalPrice = totalPrice - 1.00;
			}
			// display updated price
			lbl_price.setText("Total Price: $" + String.format("%.2f", totalPrice));
		}
		
		// If Clear button is clicked
		if (evt.getSource() == btn_clear) {
			// remove all current selections, re-enable the Add Size button, and reset the price to $0.00
			listModel3.removeAllElements();
			btn_addSize.setEnabled(true);
			totalPrice = 0.00;
			}
			// display updated price
			lbl_price.setText("Total Price: $" + String.format("%.2f", totalPrice));
	
		// If Submit button is clicked
		if (evt.getSource() == btn_submit) {
			// show a confirmation dialog
			JOptionPane.showMessageDialog(null, "We have received your order.\nYour pizza will be ready in 30 minutes.\nThanks for choosing Andre's Pizza!");
			}
		}
	
	public static void main(String[] args) {
		Pizzeria myFrame = new Pizzeria();
		myFrame.pack();
		myFrame.setVisible(true);
	}

}
