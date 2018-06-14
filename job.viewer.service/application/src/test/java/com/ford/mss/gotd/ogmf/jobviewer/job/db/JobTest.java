package com.ford.mss.gotd.ogmf.jobviewer.job.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.annotation.RequestScope;

import com.ford.mss.gotd.ogmf.jobviewer.job.JobDE;
import com.ford.mss.gotd.ogmf.jobviewer.job.JobRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = com.ford.mss.gotd.ogmf.jobviewer.app.JobViewerApplication.class)
public class JobTest {

	@Autowired
	private TestEntityManager entityManager;
	
	
	@Autowired
	private JobRepository jobRepository;
	
	@Test
	@Ignore
	public void getAllJobs() {
		// given
	    JobDE job = new JobDE();
	    //Persist a sample data using entityManager
	    
	    // when
	    List<JobDE> jobs = jobRepository.findAll();
	 
	    // then
	    assertThat(jobs).isNotNull();
	    assertThat(jobs).size().isEqualTo(0);
	    
	}

}
