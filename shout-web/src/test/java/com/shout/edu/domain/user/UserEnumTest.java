package com.shout.edu.domain.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.shout.edu.domain.user.Role;

@RunWith(SpringRunner.class)
public class UserEnumTest {
	
	@Test
	public void Enum_호출() {
		Role role = Role.GUEST;
		System.out.println(">>>>> key : " + role.getKey());
		System.out.println(">>>>> title : " + role.getTitle());

		for(Role roleFor : Role.values()) {
			System.out.println(">>>>> key : " + roleFor.getKey());
			System.out.println(">>>>> title : " + roleFor.getTitle());			
		}	

	}
}
