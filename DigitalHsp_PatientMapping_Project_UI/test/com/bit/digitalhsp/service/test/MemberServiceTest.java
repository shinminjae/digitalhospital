package com.bit.digitalhsp.service.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.bit.digitalhsp.mapping.configuration.SpringContextFactory;
import kr.bit.digitalhsp.mapping.service.MappingService;
import kr.bit.digitalhsp.mapping.vo.ImageInfo;
import kr.bit.digitalhsp.mapping.vo.MappingInfo;
import kr.bit.digitalhsp.mapping.vo.PatientInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;


public class MemberServiceTest {

	ApplicationContext ctx =  SpringContextFactory.getInstance();
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectPatList() {
		MappingService memberService =  (MappingService)ctx.getBean("mappingService");
		
		List<ImageInfo> returnResult = memberService.getMappingImageList("aaa", "bbbb");
		
		for(ImageInfo imageInfo : returnResult)
		{
			System.out.println(imageInfo);
		}
		//System.out.println(maps);
	}

	
	@Test
	public void testSelectMappingList() {
		MappingService memberService =  (MappingService)ctx.getBean("mappingService");
		
		List<MappingInfo> returnResult = memberService.getMappingList();
		
		System.out.println(returnResult);
	}
}
