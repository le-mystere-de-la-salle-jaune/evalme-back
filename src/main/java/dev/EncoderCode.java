package dev;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderCode {

	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String password = "testPassword";
		String passwordHashe = bCryptPasswordEncoder.encode(password);
		System.out.println(passwordHashe);
	}

}
