package com.quanfeng.basedao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("baseDAO")  
@SuppressWarnings("all")
public class BaseDAOimpl<T> implements BaseDAO<T> {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(Object o) {
		// TODO Auto-generated method stub

		return this.getCurrentSession().save(o);
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(o);
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<T> find(String hql, Object[] param) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		// TODO Auto-generated method stub
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getCurrentSession().get(c, id);
	}

	@Override
	public T get(String hql, Object[] param) {
		// TODO Auto-generated method stub
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T get(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		   List<T> l = this.find(hql, param);  
	        if (l != null && l.size() > 0) {  
	            return l.get(0);  
	        } else {  
	            return null;  
	        }    
	}

	@Override
	public Long count(String hql) {
		// TODO Auto-generated method stub
		   return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();  
	}

	@Override
	public Long count(String hql, Object[] param) {
		// TODO Auto-generated method stub
		 Query q = this.getCurrentSession().createQuery(hql);  
	        if (param != null && param.length > 0) {  
	            for (int i = 0; i < param.length; i++) {  
	                q.setParameter(i, param[i]);  
	            }  
	        }  
	        return (Long) q.uniqueResult();  
	        }

	@Override
	public Long count(String hql, List param) {
		// TODO Auto-generated method stub
		 Query q = this.getCurrentSession().createQuery(hql);  
	        if (param != null && param.size() > 0) {  
	            for (int i = 0; i < param.size(); i++) {  
	                q.setParameter(i, param.get(i));  
	            }  
	        }  
	        return (Long) q.uniqueResult();  
	}

	@Override
	public Integer executeHql(String hql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery(hql).executeUpdate();  	}

	@Override
	public Integer executeHql(String hql, Object[] param) {
		  Query q = this.getCurrentSession().createQuery(hql);  
	        if (param != null && param.length > 0) {  
	            for (int i = 0; i < param.length; i++) {  
	                q.setParameter(i, param[i]);  
	            }  
	        }  
	        return q.executeUpdate();  
	}

	@Override
	public Integer executeHql(String hql, List param) {
	    Query q = this.getCurrentSession().createQuery(hql);  
        if (param != null && param.size() > 0) {  
            for (int i = 0; i < param.size(); i++) {  
                q.setParameter(i, param.get(i));  
            }  
        }  
        return q.executeUpdate();  
    }  
}
