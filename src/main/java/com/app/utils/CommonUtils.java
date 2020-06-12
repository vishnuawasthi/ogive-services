package com.app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

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
	
	
	
	
	public static void main (String ...strings) {
		
	}
}
