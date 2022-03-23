package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface ICrud<T> extends Serializable {

	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	/**
	 * Salva ou atualiza
	 * @param obj
	 * @throws Exception
	 */
	void saveOrUpdate(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	/**
	 * salva ou atualiza e retorna o objeto em estado persistente
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	T merge(T obj) throws Exception;
	
	/**
	 * Carrega a lista de dados de determinada classe
	 * @param objs
	 * @return
	 * @throws Exception
	 */
	List<T> findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findByPorId(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDinamica(String sql) throws Exception;
	
	/**
	 * executar update com HQL
	 * @param sql
	 * @throws Exception
	 */
	void executeUpdateQueryDinamica(String sql) throws Exception;
	
	/**
	 * executar update com sql
	 * @param sql
	 * @throws Exception
	 */
	void executeUpdateSQLDinamica(String sql) throws Exception;
	
	/**
	 * hibernate limpar a sessão
	 * @throws Exception
	 */
	void clearSession() throws Exception;
	
	/**
	 * retira o objeto da sessão do hibernate
	 * @param obj
	 * @throws Exception
	 */
	void evict(T obj) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	/**
	 * JDBC do Spring
	 * @return
	 */
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	Long totalRegistros(String table) throws Exception;
	
	Query obterQuery(String sql) throws Exception;
	
	/**
	 * Carregamento por demanda, em tela com limitação para exibir dados
	 * @param sql
	 * @param iniRegistro
	 * @param maxResultado
	 * @return
	 * @throws Exception
	 */
	List<T> findListByQueryDinamica(String sql, int iniRegistro, int maxResultado) throws Exception;
}
