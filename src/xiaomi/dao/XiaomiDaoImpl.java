package xiaomi.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import xiaomi.entity.ScheduleInfo;

@Repository
@Scope("prototype")
public class XiaomiDaoImpl implements XiaomiDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<ScheduleInfo> showAll() {
		
		return getSession().createQuery("from ScheduleInfo",ScheduleInfo.class).getResultList();
	}

	@Override
	public void addSche(ScheduleInfo s) {
		s.setBuyDate(new Date());
		getSession().save(s);
	}

	@Override
	public void delSche(Integer[] sids) {
		if(sids!=null){
			for(Integer sid:sids){
				getSession().delete(getSession().find(ScheduleInfo.class, sid));
			}
		}
	}

	@Override
	public List<ScheduleInfo> find(String like) {
		String sql="from ScheduleInfo where productName like :productName or consignee like :consignee ";
		return getSession().createQuery(sql,ScheduleInfo.class)
				.setParameter("productName", "%"+like+"%")
				.setParameter("consignee", "%"+like+"%")
				.getResultList();
	}

	@Override
	public ScheduleInfo find(Integer sid) {
		if(sid!=null){
			return getSession().find(ScheduleInfo.class, sid);
		}else{
			return null;
		}
	}

	@Override
	public void updateSche(ScheduleInfo s) {
		getSession().update(s);
	}

}
