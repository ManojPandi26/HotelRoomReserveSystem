package Hotelreserveproject;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Toolkit;

public class RoomsReservation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomsReservation frame = new RoomsReservation();
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
	public RoomsReservation() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.GRAY);
		setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 13));
		
		setTitle("ReservationGUI");
        setSize(609, 373);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manoj\\OneDrive\\Pictures\\Screenshots\\dino-reichmuth-kk3W5-0b6e0-unsplash.jpg"));

        // Create buttons
        JButton viewRoomsButton = new JButton("View Available Rooms");
        viewRoomsButton.setFocusable(false);
        viewRoomsButton.setForeground(Color.WHITE);
        viewRoomsButton.setBackground(Color.DARK_GRAY);
        viewRoomsButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        viewRoomsButton.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        JButton makeReservationButton = new JButton("Make a Reservation");
        makeReservationButton.setFocusable(false);
        makeReservationButton.setForeground(Color.WHITE);
        makeReservationButton.setBackground(Color.DARK_GRAY);
        makeReservationButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        
        
        
        
        JButton viewReservationsButton = new JButton("View Reservations");
        viewReservationsButton.setFocusable(false);
        viewReservationsButton.setForeground(Color.WHITE);
        viewReservationsButton.setBackground(Color.DARK_GRAY);
        viewReservationsButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        
        
        
        JButton exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        
        
        
        // Set up the layout
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JLabel lblNewLabel = new JLabel("Hotel Reservation Details");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        getContentPane().add(lblNewLabel);

        
        
        
        
        getContentPane().add(viewRoomsButton);
        getContentPane().add(makeReservationButton);
        getContentPane().add(viewReservationsButton);
        getContentPane().add(exitButton);

        // Set up the frame visibility
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);

	
	
	viewRoomsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement logic to view available rooms
            // Use JOptionPane or update a JTextArea to display the information
//        	try {
//                // Call DAO method to fetch available rooms
//                String roomsInfo = InteractionGUI.viewRooms();
//                textArea.setText(roomsInfo); // Display the rooms information in the JTextArea
//            } catch (SQLException ex) {
//                ex.printStackTrace(); // Handle exception properly
//                JOptionPane.showMessageDialog(RoomsReservation.this, "Error: Unable to fetch available rooms.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
        	
        	try {
				showAvailableRoomsPopup();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
        }
    });

    makeReservationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement logic to make a reservation
            // Use JOptionPane or create a new JFrame for reservation details
        	showReservationFrame();
        	
        }
    });

    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.exit(0);
        }
    });

   
        viewReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            	try {
                    String reservationsDetails = InteractionGUI.viewReservations();
                    showReservationsFrame(reservationsDetails);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to fetch reservations details.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
	}
	
	
	///Available rooms popup.....
	
	private void showAvailableRoomsPopup() {
        JFrame popupFrame = new JFrame("Available Rooms");
        popupFrame.setSize(400, 300);
        popupFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make the JTextArea non-editable

        // Add textArea to the frame
        popupFrame.add(new JScrollPane(textArea));

        // Fetch and display available rooms information
        try {
            String roomsInfo = InteractionGUI.viewRooms();
            textArea.setText(roomsInfo); // Display the rooms information in the JTextArea
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly
            JOptionPane.showMessageDialog(RoomsReservation.this, "Error: Unable to fetch available rooms.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        popupFrame.setVisible(true);
    }
	
	
	
	
	// make reservation frame ............
	
	 private void showReservationFrame() {
	        JFrame reservationFrame = new JFrame("Make Reservation");
	        reservationFrame.setSize(400, 200);
	        reservationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	        JPanel panel = new JPanel(new GridLayout(4, 2));

	        
	        JLabel lblName = new JLabel("Name:");
	        JTextField txtName = new JTextField();
	        JLabel lblCheckIn = new JLabel("Check-In Date:");
	        JTextField txtCheckIn = new JTextField();
	        JLabel lblRoomNumber = new JLabel("Room Number:");
	        JTextField txtRoomNumber = new JTextField();

	       
	        panel.add(lblName);
	        panel.add(txtName);
	        panel.add(lblCheckIn);
	        panel.add(txtCheckIn);
	        panel.add(lblRoomNumber);
	        panel.add(txtRoomNumber);

	        JButton btnConfirmReservation = new JButton("Confirm Reservation");
	        btnConfirmReservation.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 try {
	            		 String name = txtName.getText();
	            		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	            		 
	                     java.util.Date checkInDate =  dateFormat.parse(txtCheckIn.getText());
	                     int roomNumber = Integer.parseInt(txtRoomNumber.getText());
	                     boolean success = InteractionGUI.makeReservationsGui(name,checkInDate,roomNumber);
	                    
	                     if (success) {
	                         JOptionPane.showMessageDialog(RoomsReservation.this, "Reservation successfully made!", "Done", JOptionPane.INFORMATION_MESSAGE);
	                     } else {
	                         JOptionPane.showMessageDialog(RoomsReservation.this, "Failed to make reservation. Room may already be reserved.", "Error", JOptionPane.ERROR_MESSAGE);
	                     }
	                 } catch (SQLException ex) {
	                     ex.printStackTrace(); // Handle exception properly
	                     JOptionPane.showMessageDialog(RoomsReservation.this, "Error: Unable to make reservation.", "Error", JOptionPane.ERROR_MESSAGE);
	                 } catch (ParseException ex) {
	                     JOptionPane.showMessageDialog(RoomsReservation.this, "Invalid date format. Please enter date in YYYY-MM-DD format.", "Error", JOptionPane.ERROR_MESSAGE);
	                 }
	            }
	        });

	        reservationFrame.add(panel, BorderLayout.CENTER);
	        reservationFrame.add(btnConfirmReservation, BorderLayout.SOUTH);

	        reservationFrame.setVisible(true);
	    }


	 
	 //view reservation popup......
	 
	 public void showReservationsFrame(String reservationsDetails) {
	        // Create a new JFrame for displaying reservations details
	        JFrame frame = new JFrame("Reservations Details");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        // Create a JTextArea to display reservations details
	        JTextArea textArea = new JTextArea(reservationsDetails);
	        textArea.setEditable(false);

	        // Add a scroll pane to the text area
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

	        // Set the size of the frame
	        frame.setSize(400, 300);

	        // Make the frame visible
	        frame.setVisible(true);
	    }
	 
	 
	
}
