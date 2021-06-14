package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DVDPack;
import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	// @Autowired
	// 예외 발생
	// XML Bean 설정 시 id는 자동으로 부여 되지 않는다.
	// @Qualifier 사용 불가
	DigitalVideoDisc dvd1;

	@Autowired
	@Qualifier("ironMan")
	DigitalVideoDisc dvd2;

	@Autowired
	@Qualifier("avengersInfinityWar")
	DigitalVideoDisc dvd3;

	@Autowired
	@Qualifier("avengersEndgame")
	DigitalVideoDisc dvd4;

	@Autowired
	@Qualifier("avengersAgeOfUltron")
	DigitalVideoDisc dvd5;

	@Autowired
	@Qualifier("captainAmerica")
	DigitalVideoDisc dvd6;

	@Autowired
	@Qualifier("avengersDirectorEdition")
	DigitalVideoDisc dvd7;

	@Autowired
	@Qualifier("avengersExpansionPack1")
	DigitalVideoDisc dvd8;

	@Autowired
	@Qualifier("avengersExpansionPack2")
	DigitalVideoDisc dvd9;

	@Autowired
	@Qualifier("avengersExpansionPack3")
	DigitalVideoDisc dvd10;

	@Autowired
	@Qualifier("avengersTriplepack")
	DVDPack dvdPack;
	
	@Ignore
	@Test
	public void testDVD1() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDVD2() {
		assertNotNull(dvd2);
	}

	@Test
	public void testDVD3() {
		assertNotNull(dvd3);
	}

	@Test
	public void testDVD4() {
		assertNotNull(dvd4);
	}

	@Test
	public void testDVD5() {
		assertNotNull(dvd5);
	}

	@Test
	public void testDVD6() {
		assertNotNull(dvd6);
	}

	@Test
	public void testDVD7() {
		assertNotNull(dvd7);
	}

	@Test
	public void testDVD8() {
		assertNotNull(dvd8);
	}

	@Test
	public void testDVD9() {
		assertNotNull(dvd9);
	}

	@Test
	public void testDVD10() {
		assertNotNull(dvd10);
	}
	
	@Test
	public void testDVDPack() {
		assertNotNull(dvdPack);
	}
	
}