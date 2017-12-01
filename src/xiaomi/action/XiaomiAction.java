package xiaomi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import xiaomi.entity.ScheduleInfo;
import xiaomi.service.XiaomiService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class XiaomiAction extends ActionSupport{
	
	@Autowired
	private XiaomiService xiaomiService;
	
	private List<ScheduleInfo> list;//get
	private Integer[] sids;   		//set
	private ScheduleInfo s;			//get set
	private String like;			//set
	private Integer update_id;		//set
	private String status;			//get
	
	
	public void setLike(String like) {
		this.like = like;
	}

	public String getStatus() {
		return status;
	}
	
	public List<ScheduleInfo> getList() {
		return list;
	}
	public void setSids(Integer[] sids) {
		this.sids = sids;
	}
	public void setUpdate_id(Integer update_id) {
		this.update_id = update_id;
	}
	
	public ScheduleInfo getS() {
		return s;
	}
	public void setS(ScheduleInfo s) {
		this.s = s;
	}
	
//方法：显示：
	public String showAll(){
		list=xiaomiService.showAll();
		System.out.println(list.size());
		return "show";
	}
//添加：	
	public String sendAdd(){
		s=null;
		status="添加";
		return "send";
	}
	
	public String addSche(){
		xiaomiService.addSche(s);
		return "add";
	}
//删除	
	public String delSche(){
		xiaomiService.delSche(sids);
		return "del";
	}
//查询：	
	public String find(){
		if(like.isEmpty()){
			list=xiaomiService.showAll();
		}else{
			list=xiaomiService.find(like);
		}
		like="";
		return "find";
	}
//修改	
	public String updateSche(){
		xiaomiService.updateSche(s);
		return "update";
	}
	
	public String sendUpdate(){
		s=xiaomiService.find(update_id);
		s.setSid(update_id);
		status = "修改";
		return "send";   

	} 
}
