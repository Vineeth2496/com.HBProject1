package HB1.com.HBProject1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HB_Employee")
public class Employee {
	@Id
	@Column(name = "e_id")
	private Integer eid;
	@Column(name = "e_name")
	private String ename;
	@Column(name = "e_sal")
	private Float esal;
	
	public Employee() {
		super();
	}

	public Employee(Integer eid, String ename, Float esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Float getEsal() {
		return esal;
	}

	public void setEsal(Float esal) {
		this.esal = esal;
	}
	

}
