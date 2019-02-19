package com.nareshit.bean;

import java.io.Serializable;
import java.util.List;

public class DoctorBean extends UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<PatientBean> pinfo;


	
	//setters and gettters
	
	public List<PatientBean> getPinfo() {
		return pinfo;
	}


	public void setPinfo(List<PatientBean> pinfo) {
		this.pinfo = pinfo;
	}

	// hashcode and equals method
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pinfo == null) ? 0 : pinfo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorBean other = (DoctorBean) obj;
		if (pinfo == null) {
			if (other.pinfo != null)
				return false;
		} else if (!pinfo.equals(other.pinfo))
			return false;
		return true;
	}
	
	
	
	
	

}
