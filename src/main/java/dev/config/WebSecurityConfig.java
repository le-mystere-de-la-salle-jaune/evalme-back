package dev.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Configuration de la source d'identité
	@Bean
	public UserDetailsService userDetailsService(DataSource ds) {
		// changement de stratégie Mémoire => JDBC
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();

		// configuration de la source de données
		manager.setDataSource(ds);

		// requête pour obtenir les informations d'un utilisateur en fonction du
		// nom d'utilisateur
		manager.setUsersByUsernameQuery(
				"select identifiant, mot_de_passe, 'true' from utilisateur where identifiant=?");

		// requête pour obtenir les rôles d'un utilisateur
		manager.setAuthoritiesByUsernameQuery("select identifiant, profil from utilisateur where identifiant=?");

		return manager;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// les requêtes ci-dessous ne seront pas soumises à
				// authentification
				.authorizeRequests().antMatchers("/connexion", "/webjars/**").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/connexion");

	}

	// le bean `passwordEncoder` contient l'algorithme de hashage des mots de
	// passe de l'application.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
