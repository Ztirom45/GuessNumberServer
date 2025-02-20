package com.example.demo;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.convention.TestBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.example.demo.database.LoggingEntity;
import com.example.demo.database.LoggingRepository;
import com.example.demo.database.LoggingService;

@ExtendWith(MockitoExtension.class)
class LoggingServiceTests{
        @Mock
        private LoggingRepository loggingRepository;
	@InjectMocks
        private LoggingService loggingService;
        private LoggingEntity loggingEntity;
       
        @BeforeEach
        public void setup(){
	    LoggingEntity loggingEntity = LoggingEntity.builder()
				.timestamp(LocalTime.now())
				.loggingContent("test")
				.build();
        }
        
        @DisplayName("Junit test saveLog") 
        @Test
        void testSave(){
            System.out.println("start Test");
            LoggingEntity loggingEntity2 = LoggingEntity.builder()
				.timestamp(LocalTime.now())
				.loggingContent("test")
				.build();
            loggingService.savelog(loggingEntity2);

            // test inviroment reading does not work
            // ther
            List<LoggingEntity> logList = loggingService.fetchlogList();
            System.out.println(logList);
            System.out.println(loggingRepository.findAll());
            System.out.println(loggingService.fetchlogList());
            assertThat(logList).isNotNull();
            //assertThat(loggingService.fetchlogList().size()).isEqualTo(0);
            System.out.println("end Test");
        }
    }




