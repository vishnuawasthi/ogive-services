package com.app.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
	
	/*public static void main (String ...strings) {
		String caseNamesMapping = "Community Support Program:bh community support program outreach,\r\n" + 
				"BH Autism:bh autism outreach,\r\n" + 
				"BH Eating Disorders:bh eating disorder outreach,\r\n" + 
				"BH CLIMB:bh climb outreach,\r\n" + 
				"BH Parents & Families:bh parents and families outreach,\r\n" + 
				"BH Intensive Behavioral Case Management:bh intensive case management outreach,\r\n" + 
				"BH Substance Use:bh substance use disorder outreach,\r\n" + 
				"BH High Risk Opioid:bh high risk opioid outreach,\r\n" + 
				"BH Morphine Milligram Equivalent Outreach:bh morphine milligram equivalent outreach";
		Map <String, String> map = caseOpportunityNameMap(caseNamesMapping);
		map.entrySet().forEach(entry ->{
			System.out.println(entry.getKey() + " | " +entry.getValue());
		});
		
		
	}*/
}
