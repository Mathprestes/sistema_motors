package br.com.megamotos.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricaSessoes = CriarFabricaDeSessoes();

	public static SessionFactory getFabricaSessoes() {
		return fabricaSessoes;
	}

	private static SessionFactory CriarFabricaDeSessoes() {

		try {

			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();// registrar a solicita��o do usuario
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			return fabrica;

		} catch (Throwable ex) {

			System.err.println("A Fábrica de Sessões não pode ser criada!! " + ex);
			throw new ExceptionInInitializerError(ex);

		}
	}
}