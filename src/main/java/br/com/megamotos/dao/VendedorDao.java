package br.com.megamotos.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import br.com.megamotos.domain.Vendedor;
import br.com.megamotos.util.HibernateUtil;

public class VendedorDao extends GenericDao<Vendedor>{
	
	
	
	public Vendedor autenticar(String cpf, String senha){
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
				
				
		try{
			Criteria consulta = sessao.createCriteria(Vendedor.class);
			consulta.createAlias("pessoa", "p");
			consulta.add(Restrictions.eq("p.cpf", cpf));
			
			SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			Vendedor resultado = (Vendedor) consulta.uniqueResult(); 
			
			return resultado;
			
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
		
	}

}
