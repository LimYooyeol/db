package com.stock.db.service;

import com.stock.db.domain.CorporationVO;
import com.stock.db.dto.Corporation.SectorChangeRateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CorporationServiceTest {

    @Autowired CorporationService corporationService;

    /*
        @warning : DB에 기업 정보가 들어가 있는 경우에만 유효
     */
    @Test
    @DisplayName("기업조회 성공")
    public void 기업조회_테스트(){
        //given
        String cno = "005930";  //삼성전자

        //when
        CorporationVO findCorp = corporationService.findByCno(cno);    //삼성전자

        //then
        assertNotNull(findCorp);
        assertEquals("삼성전자", findCorp.getCname());
    }

    @Test
    @DisplayName("상승률 상위 10개 종목 조회 성공")
    public void 상승률_상위종목_조회_테스트(){
        // given
        int findNum = 10;

        // when
        List<CorporationVO> findCorps = corporationService.getTopRisingCorporations(10);

        // then
        assertNotNull(findCorps);
        assertEquals(findNum, findCorps.size());
    }

    @Test
    @DisplayName("상승률 상위 섹터 조회 성공")
    public void 상승률_상위섹터_조회_테스트(){
        // given
        int findNum = 10;

        // when
        List<SectorChangeRateDto> findSectors = corporationService.getTopRisingSectors(findNum);

        // then
        assertNotNull(findSectors);
        assertEquals(findNum, findSectors.size());
        System.out.println(findSectors);
    }
}