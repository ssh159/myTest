package xiaomi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import xiaomi.dao.XiaomiDao;
import xiaomi.entity.ScheduleInfo;

@Service
@Scope("prototype")
public class XiaomiServiceImpl implements XiaomiService{
	
	@Autowired
	private XiaomiDao xiaomiDao;
//显示：	
	@Override
	public List<ScheduleInfo> showAll() {
		
		return xiaomiDao.showAll();
	}
//添加：
	@Override
	public void addSche(ScheduleInfo s) {
		xiaomiDao.addSche(s);
	}
//删除
	@Override
	public void delSche(Integer[] sids) {
		xiaomiDao.delSche(sids);
	}
//查询：
	@Override
	public List<ScheduleInfo> find(String like) {
		
		return xiaomiDao.find(like);
	}

	@Override
	public ScheduleInfo find(Integer sid) {
		
		return xiaomiDao.find(sid);
	}
//修改：
	@Override
	public void updateSche(ScheduleInfo s) {
		
		xiaomiDao.updateSche(s);
	}
	
}
