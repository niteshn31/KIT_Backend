package com.springboot.mailSend1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ContactUsController {

	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping("/contact-us")
	public String handleContactUsForm() {
		// Process the form data
		ContactUsForm ContactUs = new ContactUsForm();
		ContactUs.setEmail("nayanaraj9564@gmail.com");
		ContactUs.setName("Nayana");
		ContactUs.setMessage("Welcome");

		String name = ContactUs.getName();
		String email = ContactUs.getEmail();
		String message = ContactUs.getMessage();

		// Send email
		sendEmail(name, email, message);

		// Return a success message (you can customize this based on your needs)
		return "Message sent successfully!";
	}

	private void sendEmail(String name, String email, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("nitesh@kitservices.in"); // Replace with the recipient's email address
		mailMessage.setSubject("New Contact Us Form Submission");
		mailMessage.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);

		// Send the email
		javaMailSender.send(mailMessage);
	}
}
