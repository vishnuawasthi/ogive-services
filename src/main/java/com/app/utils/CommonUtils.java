package com.app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.dto.OpportuityDetails;

public class CommonUtils {
	
	public static String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}

	
	public static Map<String, String> caseOpportunityNameMap(String str) {
		Map<String, String> map = new HashMap<String, String>();
		String[] caseOppMapArray = str.split(",");
		int index = 0;
		while (index < caseOppMapArray.length) {
			String[] caseProgram = caseOppMapArray[index].split(":");
			map.put(caseProgram[0], caseProgram[1]);
			index++;
		}
		return map;

	}
	
	
	public static Map<String ,OpportuityDetails> prepareMap(){
		
		List<OpportuityDetails> list = new ArrayList<OpportuityDetails>();
		
		OpportuityDetails autism = new OpportuityDetails();
		autism.setOpportunityName("bh autism");
		autism.setRank(4);
		
		OpportuityDetails climb = new OpportuityDetails();
		climb.setOpportunityName("bh climb");
		climb.setRank(8);
		
		OpportuityDetails eatingDisorder = new OpportuityDetails();
		eatingDisorder.setOpportunityName("bh eating disorders");
		eatingDisorder.setRank(3);
		
		OpportuityDetails commuitySupportProgram = new OpportuityDetails();
		commuitySupportProgram.setOpportunityName("bh community support program");
		commuitySupportProgram.setRank(1);
		
		
		list.add(eatingDisorder);
		list.add(commuitySupportProgram);
		list.add(climb);
		list.add(autism);
		
		Map <String ,OpportuityDetails >  map = list.stream()
				.collect(Collectors.toMap(OpportuityDetails::getOpportunityName, opportunityDetails->{
			return  opportunityDetails ;
		}));
		
		
		//Map <String ,OpportuityDetails >  map2 = list.stream().collect(Collectors.toMap());
		
		
		return map;
	}
	
	public static void main (String ...strings) {
		
		System.out.println("prepareMap() -> "+prepareMap());
	}
}
