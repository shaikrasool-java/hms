package com.nareshit.utility;

import java.util.ArrayList;
import java.util.List;

import com.nareshit.bean.AddressBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Address;
import com.nareshit.domain.Hospital;

public class HospitalMapper {

	public static Hospital mapBeanToDomain(HospitalBean hospBean) {
		Hospital hosp = new Hospital();
		hosp.setEmail(hospBean.getEmail());
		hosp.setName(hospBean.getName());
		hosp.setFax(hospBean.getFax());
		hosp.setPhone(hospBean.getPhone());
		hosp.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(hospBean.getStatus()))));
		
		List<Address> addrList = null;
		List<AddressBean> addBeansList = hospBean.getAddrInfo();
		if(addBeansList != null && addBeansList.size() >0) {
			addrList = new ArrayList<Address>();
			for(AddressBean addBean : addBeansList) {
				addrList.add(AddressMapper.mapBeanToDomain(addBean));
			}
			hosp.setAddrList(addrList);
		}
		
		
		
		return hosp;
		
	
	}
	
	public static HospitalBean mapDomainToBean(Hospital hospDomain) {
		HospitalBean hosp = new HospitalBean();
		hosp.setHospId(hospDomain.getId());
		hosp.setEmail(hospDomain.getEmail());
		hosp.setName(hospDomain.getName());
		hosp.setFax(hospDomain.getFax());
		hosp.setPhone(hospDomain.getPhone());
		
		boolean hospStatus = hospDomain.isStatus();
		
		hosp.setStatus(String.valueOf(hospStatus));
		List<AddressBean> addBeansList = null;
		List<Address> addrList = hospDomain.getAddrList();
		if(addrList != null && addrList.size() >0) {
			addBeansList = new ArrayList<AddressBean>();
			for(Address ad : addrList) {
				addBeansList.add(AddressMapper.mapDomainToBean(ad));
			}
			hosp.setAddrInfo(addBeansList);
		}
		
		return hosp;
	}
	
		
}
