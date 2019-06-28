package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.mum.dao.GenericDao;
import edu.mum.dao.UserDao;


/*@SuppressWarnings("unchecked")
@Repository*/
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager2;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    @Override
    public void save( T entity ){
        entityManager2.persist( entity );
     }

    public void delete( T entity ){
        entityManager2.remove( entity );
     }

	@Override
	public void delete(Long id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( Long id ){
	    return (T) entityManager2.find( daoType, id );
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		      return entityManager2.createQuery( "from " + daoType.getName() )
		       .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager2.merge( entity );
	   }


 }