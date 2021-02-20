package com.api5;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
    public DataSource dataSource(){ // metódo que irá pegar tudo que é necessario para realizar a conexão com o db
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); // conexao com o hibernate
		adapter.setDatabase(Database.MYSQL); // tipo do banco
		adapter.setShowSql(true); // permite que o hibernate mostre as querys no console
		adapter.setGenerateDdl(true);// permite que o hibernate crie as tabelas automaticamente
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect"); // dialeto usando para o banco
		adapter.setPrepareConnection(true); // hibernate prepara a conexao automaticamente com o db
		return adapter;
	}
	
}
