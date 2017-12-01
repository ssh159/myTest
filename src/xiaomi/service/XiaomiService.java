package xiaomi.service;

import java.util.List;

import xiaomi.entity.ScheduleInfo;

public interface XiaomiService {
	
	public List<ScheduleInfo> showAll();
	public void addSche(ScheduleInfo s);
	public void delSche(Integer[] sids);
	public List<ScheduleInfo> find(String like);
	public ScheduleInfo find(Integer sid);
	public void updateSche(ScheduleInfo s);
	
}
