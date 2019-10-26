package com.pramati.crs.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomClientDetailsService clientDetailsService;

	@Value("${keystore.password}")
	private String pwd;

	@Value("${keystore.alias}")
	private String alias = "server-alias";

	@Value("${keystore.filename}")
	private String fileName;

	@Value("${spring.datasource.url}")
	private String sqlUrl;

	@Value("${spring.datasource.username}")
	private String sqlUsername;

	@Value("${spring.datasource.password}")
	private String sqlPassword;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenServices(tokenServices()).tokenStore(tokenStore())
				.accessTokenConverter(jwtAccessTokenConverter());
		endpoints.pathMapping("/oauth/token", "/user/login");
		endpoints.pathMapping("/oauth/check_token", "/user/validateToken");
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore());
		tokenServices.setClientDetailsService(clientDetailsService);
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenEnhancer(jwtAccessTokenConverter());
		return tokenServices;
	}

	@Bean
	public JdbcTokenStore tokenStore() {
		return new JdbcTokenStore(getDataSource());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource(fileName), pwd.toCharArray()).getKeyPair(alias);
		converter.setKeyPair(keyPair);
		return converter;
	}

	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(sqlUrl);
		dataSource.setUsername(sqlUsername);
		dataSource.setPassword(sqlPassword);
		return dataSource;
	}

}
