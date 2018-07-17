package dev.metiers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuperService {

	private PasswordEncoder passwordEncoder;

	public SuperService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void utiliserAlgoEncodage() {

		String iciUnMotDePasse = "topSecret";

		String iciMotDePasseHashe = this.passwordEncoder.encode(iciUnMotDePasse);
	}

}