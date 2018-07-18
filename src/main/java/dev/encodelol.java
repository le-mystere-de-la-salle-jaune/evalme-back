package dev;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encodelol {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hash = encoder.encode("dupont");

		System.out.println(hash);

	}

}
